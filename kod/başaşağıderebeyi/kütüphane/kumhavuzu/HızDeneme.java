/**
 * başaşağıderebeyi.kütüphane.kumhavuzu.HızDeneme.java
 * 0.2 / 16 Oca 2021 / 14:05:29
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.kütüphane.kumhavuzu;

import başaşağıderebeyi.kütüphane.matematik.yerleşim.*;

/** Farklı yöntemlerin hızlarını dener. */
public class HızDeneme {
	/** İki karakterden oluşan dizeyi ayrı ayrı ekler. */
	@SuppressWarnings("unused")
	private static void dizeyeÇoktaEkle() {
		final StringBuilder d = new StringBuilder();
		d.append(',').append(' ');
	}
	
	/** İki karakterden oluşan dizeyi birlikte ekler. */
	@SuppressWarnings("unused")
	private static void dizeyeTekteEkle() {
		final StringBuilder d = new StringBuilder();
		d.append(", ");
	}
	
	/** Geriye doğru eksi bire kadar sayar. */
	private static void geriyeEksiBireKadarSay() {
		for (int i = 10 - 1; i > -1; i--) {
		}
	}
	
	/** Geriye doğru sıfıra kadar sayar. */
	private static void geriyeSıfıraKadarSay() {
		for (int i = 10; i-- > 0;) {
		}
	}
	
	/** İki yöntemin çalışma hızlarını karşılaştırır. */
	private static void karşılaştır() {
		final int N = 1000000000;
		final long başlangıç1 = System.nanoTime();
		for (int i = 0; i < N; i++)
			HızDeneme.geriyeSıfıraKadarSay();
		final long süre1 = System.nanoTime() - başlangıç1;
		System.out.println("Ortalama1: " + süre1 / (double)N);
		final long başlangıç2 = System.nanoTime();
		for (int i = 0; i < N; i++)
			HızDeneme.geriyeEksiBireKadarSay();
		final long süre2 = System.nanoTime() - başlangıç2;
		System.out.println("Ortalama2: " + süre2 / (double)N);
	}
	
	/** Bir yöntemin çalışma hızını ölçer. */
	@SuppressWarnings("unused")
	private static void ölç() {
		final int N = 10000000;
		final long başlangıç = System.nanoTime();
		for (int i = 0; i < N; i++)
			HızDeneme.yerleşimVerisininKomşusunuAl();
		System.out.println("Ortalama: " + (System.nanoTime() - başlangıç) / (double)N);
	}
	
	/** Yerleşim verisinin karşısına ulaşma hızını ölçer. */
	@SuppressWarnings("unused")
	private static void yerleşimVerisininKarşısınıAl() {
		YerleşimVerisi.KÜÇÜK_DİKEY.karşı();
	}
	
	/** Yerleşim verisinin komşusuna ulaşma hızını ölçer. */
	private static void yerleşimVerisininKomşusunuAl() {
		YerleşimVerisi.KÜÇÜK_DİKEY.komşu();
	}
	
	/** Denemenin başlangıcı. */
	public static void main(final String[] args) {
		HızDeneme.karşılaştır();
	}
}
