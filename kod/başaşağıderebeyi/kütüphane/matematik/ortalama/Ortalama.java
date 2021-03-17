/**
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 * 0.11 / 11 Mar 2021 / 21:38:41
 */
package başaşağıderebeyi.kütüphane.matematik.ortalama;

/** Bir değerin farklı örneklerinin ortalaması. */
public class Ortalama {
	private int sayacı;
	private float toplamı;
	private float ortalaması;
	
	/** Sayaçları sıfırlar. */
	public void sıfırla() {
		sayacı = 0;
		toplamı = 0.0F;
		ortalaması = 0.0F;
	}
	
	/** Yeni bir değer ekler. */
	public void ekle(final float değeri) {
		toplamı += değeri;
		ortalaması = toplamı / ++sayacı;
	}
	
	/** Eklenen değerlerin toplamını döndürür. */
	public float toplamınıEdin() {
		return toplamı;
	}
	
	/** Eklenen değerlerin ortalamasını döndürür. */
	public float ortalamasınıEdin() {
		return ortalaması;
	}
}
