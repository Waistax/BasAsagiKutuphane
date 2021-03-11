/**
 * başaşağıderebeyi.kütüphane.kumhavuzu.Ortalama.java
 * 0.11 / 11 Mar 2021 / 21:38:41
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.kütüphane.kumhavuzu;

/** Bir değerin farklı örneklerinin ortalaması. */
public class Ortalama {
	private int sayacı;
	private float değeri;
	
	/** Değerini sıfırlar. */
	public void sıfırla() {
		sayacı = 0;
		değeri = 0.0F;
	}
	
	/** Yeni bir örnek ekler. */
	public void ekle(float örnek) {
		değeri = (değeri * sayacı + örnek) / ++sayacı;
	}
	
	/** Eklenen örneklerin ortalamasını döndürür. */
	public float değeriniEdin() {
		return değeri;
	}
}
