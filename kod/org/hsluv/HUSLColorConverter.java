/**
 * Cem GEÇGEL (BaşAşağıDerebeyi) tarafından eklendi.
 * 0.13.0 / 17 Mar 2021 / 13:17:14
 * 
 * hsluv-java'dan (revision 4) alındı.
 * Alexei Boronine (boronine) ve Lauren Horne (lahwran) tarafından yazıldı.
 * Kaynak: https://github.com/hsluv/hsluv-java/blob/master/src/main/java/org/hsluv/HUSLColorConverter.java
 */
package org.hsluv;

import java.util.*;

/** RGB renk uzayından HSLuv renk uzayına geçişleri yapmaya yarayan araç. */
public class HUSLColorConverter {
	private static double[][] m = new double[][] {
		new double[] { 3.240969941904521, -1.537383177570093, -0.498610760293 },
		new double[] { -0.96924363628087, 1.87596750150772, 0.041555057407175 },
		new double[] {
			0.055630079696993,
			-0.20397695888897,
			1.056971514242878 }, };
	
	private static double[][] minv = new double[][] {
		new double[] { 0.41239079926595, 0.35758433938387, 0.18048078840183 },
		new double[] { 0.21263900587151, 0.71516867876775, 0.072192315360733 },
		new double[] {
			0.019330818715591,
			0.11919477979462,
			0.95053215224966 }, };
	
	private static double refY = 1.0;
	
	private static double refU = 0.19783000664283;
	private static double refV = 0.46831999493879;
	
	private static double kappa = 903.2962962;
	private static double epsilon = 0.0088564516;
	
	private static List<double[]> getBounds(final double L) {
		final ArrayList<double[]> result = new ArrayList<>();
		
		final double sub1 = Math.pow(L + 16, 3) / 1560896;
		final double sub2 = sub1 > epsilon ? sub1 : L / kappa;
		
		for (int c = 0; c < 3; ++c) {
			final double m1 = m[c][0];
			final double m2 = m[c][1];
			final double m3 = m[c][2];
			
			for (int t = 0; t < 2; ++t) {
				final double top1 = (284517 * m1 - 94839 * m3) * sub2;
				final double top2 =
					(838422 * m3 + 769860 * m2 + 731718 * m1) * L * sub2 -
						769860 * t * L;
				final double bottom =
					(632260 * m3 - 126452 * m2) * sub2 + 126452 * t;
				
				result.add(new double[] { top1 / bottom, top2 / bottom });
			}
		}
		
		return result;
	}
	
	private static double intersectLineLine(
		final double[] lineA,
		final double[] lineB) {
		return (lineA[1] - lineB[1]) / (lineB[0] - lineA[0]);
	}
	
	private static double distanceFromPole(final double[] point) {
		return Math.sqrt(Math.pow(point[0], 2) + Math.pow(point[1], 2));
	}
	
	private static Length lengthOfRayUntilIntersect(
		final double theta,
		final double[] line) {
		final double length =
			line[1] / (Math.sin(theta) - line[0] * Math.cos(theta));
		
		return new Length(length);
	}
	
	private static class Length {
		final boolean greaterEqualZero;
		final double length;
		
		private Length(final double length) {
			greaterEqualZero = length >= 0;
			this.length = length;
		}
	}
	
	private static double maxSafeChromaForL(final double L) {
		final List<double[]> bounds = getBounds(L);
		double min = Double.MAX_VALUE;
		
		for (int i = 0; i < 2; ++i) {
			final double m1 = bounds.get(i)[0];
			final double b1 = bounds.get(i)[1];
			final double[] line = new double[] { m1, b1 };
			
			final double x =
				intersectLineLine(line, new double[] { -1 / m1, 0 });
			final double length =
				distanceFromPole(new double[] { x, b1 + x * m1 });
			
			min = Math.min(min, length);
		}
		
		return min;
	}
	
	private static double maxChromaForLH(final double L, final double H) {
		final double hrad = H / 360 * Math.PI * 2;
		
		final List<double[]> bounds = getBounds(L);
		double min = Double.MAX_VALUE;
		
		for (final double[] bound : bounds) {
			final Length length = lengthOfRayUntilIntersect(hrad, bound);
			if (length.greaterEqualZero)
				min = Math.min(min, length.length);
		}
		
		return min;
	}
	
	private static double dotProduct(final double[] a, final double[] b) {
		double sum = 0;
		
		for (int i = 0; i < a.length; ++i)
			sum += a[i] * b[i];
		
		return sum;
	}
	
	private static double round(final double value, final int places) {
		final double n = Math.pow(10, places);
		
		return Math.round(value * n) / n;
	}
	
	private static double fromLinear(final double c) {
		if (c <= 0.0031308)
			return 12.92 * c;
		else
			return 1.055 * Math.pow(c, 1 / 2.4) - 0.055;
	}
	
	private static double toLinear(final double c) {
		if (c > 0.04045)
			return Math.pow((c + 0.055) / (1 + 0.055), 2.4);
		else
			return c / 12.92;
	}
	
	private static int[] rgbPrepare(final double[] tuple) {
		
		final int[] results = new int[tuple.length];
		
		for (int i = 0; i < tuple.length; ++i) {
			final double chan = tuple[i];
			final double rounded = round(chan, 3);
			
			if (rounded < -0.0001 || rounded > 1.0001)
				throw new IllegalArgumentException(
					"Illegal rgb value: " + rounded);
			
			results[i] = (int)Math.round(rounded * 255);
		}
		
		return results;
	}
	
	public static double[] xyzToRgb(final double[] tuple) {
		return new double[] {
			fromLinear(dotProduct(m[0], tuple)),
			fromLinear(dotProduct(m[1], tuple)),
			fromLinear(dotProduct(m[2], tuple)), };
	}
	
	public static double[] rgbToXyz(final double[] tuple) {
		final double[] rgbl = new double[] {
			toLinear(tuple[0]),
			toLinear(tuple[1]),
			toLinear(tuple[2]), };
		
		return new double[] {
			dotProduct(minv[0], rgbl),
			dotProduct(minv[1], rgbl),
			dotProduct(minv[2], rgbl), };
	}
	
	private static double yToL(final double Y) {
		if (Y <= epsilon)
			return Y / refY * kappa;
		else
			return 116 * Math.pow(Y / refY, 1.0 / 3.0) - 16;
	}
	
	private static double lToY(final double L) {
		if (L <= 8)
			return refY * L / kappa;
		else
			return refY * Math.pow((L + 16) / 116, 3);
	}
	
	public static double[] xyzToLuv(final double[] tuple) {
		final double X = tuple[0];
		final double Y = tuple[1];
		final double Z = tuple[2];
		
		final double varU = 4 * X / (X + 15 * Y + 3 * Z);
		final double varV = 9 * Y / (X + 15 * Y + 3 * Z);
		
		final double L = yToL(Y);
		
		if (L == 0)
			return new double[] { 0, 0, 0 };
		
		final double U = 13 * L * (varU - refU);
		final double V = 13 * L * (varV - refV);
		
		return new double[] { L, U, V };
	}
	
	public static double[] luvToXyz(final double[] tuple) {
		final double L = tuple[0];
		final double U = tuple[1];
		final double V = tuple[2];
		
		if (L == 0)
			return new double[] { 0, 0, 0 };
		
		final double varU = U / (13 * L) + refU;
		final double varV = V / (13 * L) + refV;
		
		final double Y = lToY(L);
		final double X = 0 - 9 * Y * varU / ((varU - 4) * varV - varU * varV);
		final double Z = (9 * Y - 15 * varV * Y - varV * X) / (3 * varV);
		
		return new double[] { X, Y, Z };
	}
	
	public static double[] luvToLch(final double[] tuple) {
		final double L = tuple[0];
		final double U = tuple[1];
		final double V = tuple[2];
		
		final double C = Math.sqrt(U * U + V * V);
		double H;
		
		if (C < 0.00000001)
			H = 0;
		else {
			final double Hrad = Math.atan2(V, U);
			
			// pi to more digits than they provide it in the stdlib
			H = Hrad * 180.0 / 3.1415926535897932;
			
			if (H < 0)
				H = 360 + H;
		}
		
		return new double[] { L, C, H };
	}
	
	public static double[] lchToLuv(final double[] tuple) {
		final double L = tuple[0];
		final double C = tuple[1];
		final double H = tuple[2];
		
		final double Hrad = H / 360.0 * 2 * Math.PI;
		final double U = Math.cos(Hrad) * C;
		final double V = Math.sin(Hrad) * C;
		
		return new double[] { L, U, V };
	}
	
	public static double[] hsluvToLch(final double[] tuple) {
		final double H = tuple[0];
		final double S = tuple[1];
		final double L = tuple[2];
		
		if (L > 99.9999999)
			return new double[] { 100d, 0, H };
		
		if (L < 0.00000001)
			return new double[] { 0, 0, H };
		
		final double max = maxChromaForLH(L, H);
		final double C = max / 100 * S;
		
		return new double[] { L, C, H };
	}
	
	public static double[] lchToHsluv(final double[] tuple) {
		final double L = tuple[0];
		final double C = tuple[1];
		final double H = tuple[2];
		
		if (L > 99.9999999)
			return new double[] { H, 0, 100 };
		
		if (L < 0.00000001)
			return new double[] { H, 0, 0 };
		
		final double max = maxChromaForLH(L, H);
		final double S = C / max * 100;
		
		return new double[] { H, S, L };
	}
	
	public static double[] hpluvToLch(final double[] tuple) {
		final double H = tuple[0];
		final double S = tuple[1];
		final double L = tuple[2];
		
		if (L > 99.9999999)
			return new double[] { 100, 0, H };
		
		if (L < 0.00000001)
			return new double[] { 0, 0, H };
		
		final double max = maxSafeChromaForL(L);
		final double C = max / 100 * S;
		
		return new double[] { L, C, H };
	}
	
	public static double[] lchToHpluv(final double[] tuple) {
		final double L = tuple[0];
		final double C = tuple[1];
		final double H = tuple[2];
		
		if (L > 99.9999999)
			return new double[] { H, 0, 100 };
		
		if (L < 0.00000001)
			return new double[] { H, 0, 0 };
		
		final double max = maxSafeChromaForL(L);
		final double S = C / max * 100;
		
		return new double[] { H, S, L };
	}
	
	public static String rgbToHex(final double[] tuple) {
		final int[] prepared = rgbPrepare(tuple);
		
		return String
			.format("#%02x%02x%02x", prepared[0], prepared[1], prepared[2]);
	}
	
	public static double[] hexToRgb(final String hex) {
		return new double[] {
			Integer.parseInt(hex.substring(1, 3), 16) / 255.0,
			Integer.parseInt(hex.substring(3, 5), 16) / 255.0,
			Integer.parseInt(hex.substring(5, 7), 16) / 255.0, };
	}
	
	public static double[] lchToRgb(final double[] tuple) {
		return xyzToRgb(luvToXyz(lchToLuv(tuple)));
	}
	
	public static double[] rgbToLch(final double[] tuple) {
		return luvToLch(xyzToLuv(rgbToXyz(tuple)));
	}
	
	// RGB <--> HUSL(p)
	
	/** HSLuv renk uzayından RGB renk uzayına çevirir. HSLuv değerleri sırasıyla
	 * [0;360], [0;100], [0;100] aralıklarında ve RGB değerleri sırasıyla [0;1],
	 * [0;1], [0;1] aralıklarında olur. */
	public static double[] hsluvToRgb(final double[] tuple) {
		return lchToRgb(hsluvToLch(tuple));
	}
	
	/** RGB renk uzayından HSLUV renk uzayına çevirir. HSLuv değerleri sırasıyla
	 * [0;360], [0;100], [0;100] aralıklarında ve RGB değerleri sırasıyla [0;1],
	 * [0;1], [0;1] aralıklarında olur. */
	public static double[] rgbToHsluv(final double[] tuple) {
		return lchToHsluv(rgbToLch(tuple));
	}
	
	/** HPLuv renk uzayından RGB renk uzayına çevirir. HPLuv değerleri sırasıyla
	 * [0;360], [0;100], [0;100] aralıklarında ve RGB değerleri sırasıyla [0;1],
	 * [0;1], [0;1] aralıklarında olur. HPLuv renk uzayı HSLuv renk uzayının
	 * daha pastel olan biçimidir. */
	public static double[] hpluvToRgb(final double[] tuple) {
		return lchToRgb(hpluvToLch(tuple));
	}
	
	/** RGB renk uzayından HPLUV renk uzayına çevirir. HPLuv değerleri sırasıyla
	 * [0;360], [0;100], [0;100] aralıklarında ve RGB değerleri sırasıyla [0;1],
	 * [0;1], [0;1] aralıklarında olur. HPLuv renk uzayı HSLuv renk uzayının
	 * daha pastel olan biçimidir. */
	public static double[] rgbToHpluv(final double[] tuple) {
		return lchToHpluv(rgbToLch(tuple));
	}
	
	// Hex
	
	public static String hsluvToHex(final double[] tuple) {
		return rgbToHex(hsluvToRgb(tuple));
	}
	
	public static String hpluvToHex(final double[] tuple) {
		return rgbToHex(hpluvToRgb(tuple));
	}
	
	public static double[] hexToHsluv(final String s) {
		return rgbToHsluv(hexToRgb(s));
	}
	
	public static double[] hexToHpluv(final String s) {
		return rgbToHpluv(hexToRgb(s));
	}
	
}
