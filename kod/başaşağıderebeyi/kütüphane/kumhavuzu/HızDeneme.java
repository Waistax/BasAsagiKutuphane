/**
 * başaşağıderebeyi.kütüphane.kumhavuzu.HızDeneme.java
 * 0.2 / 16 Oca 2021 / 14:05:29
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.kütüphane.kumhavuzu;

import başaşağıderebeyi.kütüphane.matematik.yerleşim.*;

/** Farklı yöntemlerin hızlarını dener. */
public class HızDeneme {
	/** Denemenin başlangıcı. */
	public static void main(String[] args) {
		yerleşimVerisiKomşuDenemesi();
	}
	
	/** İki karakterden oluşan dizeyi birlikte ya da ayrı ayrı eklemenin hızlarını karşılaştırır. */
	@SuppressWarnings("unused")
	private static void dizeyeEklemeDenemesi() {
		StringBuilder d1 = new StringBuilder();
		StringBuilder d2 = new StringBuilder();
		
		int N = 100000000;

		long başlangıç = System.nanoTime();
		for (int i = 0; i < N; i++) {
			d1.append(", ").setLength(0);
		}
		long süre1 = System.nanoTime() - başlangıç;
		
		başlangıç = System.nanoTime();
		for (int i = 0; i < N; i++) {
			d2.append(',').append(' ').setLength(0);
		}
		long süre2 = System.nanoTime() - başlangıç;
		
		double o1 = (double)süre1 / N;
		double o2 = (double)süre2 / N;
		
		System.out.println("Ortalamalar: " + o1 + " / " + o2);
	}
	
	/** Yerleşim verisinin komşusuna ulaşma hızını ölçer. */
	private static void yerleşimVerisiKomşuDenemesi() {
		int N = 10000000;
		
		System.out.println(YerleşimVerisi.KÜÇÜK_YATAY.komşu());
		System.out.println(YerleşimVerisi.KÜÇÜK_DİKEY.komşu());
		
		long başlangıç = System.nanoTime();
		for (int i = 0; i < N; i++) {
			YerleşimVerisi.KÜÇÜK_DİKEY.komşu();
		}
		long süre = System.nanoTime() - başlangıç;
		double o1 = süre / (double)N;
		
		System.out.println("Ortalama: " + o1);
	}
	
	/** Yerleşim verisinin karşısına ulaşma hızını ölçer. */
	@SuppressWarnings("unused")
	private static void yerleşimVerisiKarşıDenemesi() {
		int N = 10000000;

		System.out.println(YerleşimVerisi.KÜÇÜK_YATAY.karşı());
		System.out.println(YerleşimVerisi.KÜÇÜK_DİKEY.karşı());
		
		long başlangıç = System.nanoTime();
		for (int i = 0; i < N; i++) {
			YerleşimVerisi.KÜÇÜK_DİKEY.karşı();
		}
		long süre = System.nanoTime() - başlangıç;
		double o1 = süre / (double)N;
		
		System.out.println("Ortalama: " + o1);
	}
}
