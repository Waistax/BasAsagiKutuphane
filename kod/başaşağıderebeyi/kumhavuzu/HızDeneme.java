/**
 * başaşağıderebeyi.kumhavuzu.HızDeneme.java
 * 0.2 / 16 Oca 2021 / 14:05:29
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.kumhavuzu;

/**
 * Dizeye ekleme hızlarını denemek için oluşturulmuştur.
 */
public class HızDeneme {
	public static void main(String[] args) {
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
}
