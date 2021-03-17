/**
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 * 0.1 / 19 Oca 2021 / 10:44:55
 * 
 * BaşAşağıMotor'dan alındı.
 * 0.7 / 29 Ağu 2020 / 19:23:14
 */
package başaşağıderebeyi.kütüphane.matematik.ortalama;

/** Bir işlemin bir saniyede her tık başına aldığı ortalama süreyi bulmaya
 * yarayan araç. */
public class Süreç {
	private final Ortalama ortalaması;
	private float başlangıcı;
	
	/** Sıfır süreç tanımlar. */
	public Süreç() {
		ortalaması = new Ortalama();
	}
	
	/** Süreci başlatır. */
	public void başla(final float zaman) {
		başlangıcı = zaman;
	}
	
	/** Süreci durdurur. */
	public void dur(final float zaman) {
		ortalaması.ekle(zaman - başlangıcı);
	}
	
	/** Sayaçları sıfırlar. */
	public void sıfırla() {
		ortalaması.sıfırla();
	}
	
	/** Saniye biriminden ortalama süreyi döndürür. */
	public float ortalamasınıEdin() {
		return ortalaması.ortalamasınıEdin();
	}
	
	/** Saniye biriminden sürelerinin toplamını döndürür. */
	public float toplamınıEdin() {
		return ortalaması.toplamınıEdin();
	}
}
