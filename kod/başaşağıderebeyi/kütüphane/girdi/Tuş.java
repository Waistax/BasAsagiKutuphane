/**
 * başaşağıderebeyi.kütüphane.girdi.Tuş.java
 * 0.5 / 18 Oca 2021 / 10:38:21
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 *
 * BaşAşağıMotor'dan alındı.
 * 0.20 / 1 Kas 2020 / 16:42:13
 */
package başaşağıderebeyi.kütüphane.girdi;

/** Bilgisayarda basılabilien bir tuş. */
public class Tuş {
	/** Tuşu temsil eden sayı kodu. */
	public final int kodu;
	/** Tuşun eşzamansız olarak aşağıda olup olmadığı. */
	private volatile boolean aşağı;
	
	/** Tuşun şu anda basılı olup olmadığı. */
	private boolean basılı;
	/** Tuşun şu anda basılmaya başlanıp başlanmadığı. */
	private boolean basıldı;
	/** Tuşun şu anda bırakılıp bırakılmadığı. */
	private boolean salındı;
	
	/** Tuşun girdisini işleyen nesne. */
	public Object hedefi;
	
	/** Tuşu tanımlar. */
	public Tuş(final int kodu) {
		this.kodu = kodu;
	}
	
	/** Tuşun anlık durumunu günceller. */
	public void güncelle() {
		basıldı = !basılı && aşağı;
		salındı = basılı && !aşağı;
		basılı = aşağı;
		
		hedefi = null;
	}
	
	/** Tuşun eşzamansız olarak aşağıda olup olmadığını değiştirir. */
	public void aşağıOlduğunuDeğiştir(boolean aşağı) {
		this.aşağı = aşağı;
	}
	
	/** Tuş şu anda basılıysa doğru döndürür. */
	public boolean basılıMı() {
		return basılı;
	}
	
	/** Tuş şu anda basılmaya başlandıysa doğru döndürür. */
	public boolean basıldıMı() {
		return basıldı;
	}
	
	/** Tuş şu anda bırakıldıysa doğru döndürür. */
	public boolean salındıMı() {
		return salındı;
	}
	
	/** Tuşun uygun olup olmadığını döndürür. */
	public boolean uygunMu(final Object nesne) {
		return hedefi == null || hedefi == nesne;
	}
}
