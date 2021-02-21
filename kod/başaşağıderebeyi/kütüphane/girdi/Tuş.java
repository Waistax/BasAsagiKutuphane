/**
 * başaşağıderebeyi.kütüphane.girdi.Tuş.java
 * 0.5 / 18 Oca 2021 / 10:38:21
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 *
 * BaşAşağıMotor'dan alındı.
 * 0.20 / 1 Kas 2020 / 16:42:13
 */
package başaşağıderebeyi.kütüphane.girdi;

/** Tuş takımındaki ya da faredeki bir tuş. */
public class Tuş {
	/** Tuşun şu anda basılı olup olmadığı. */
	private boolean aşağı;
	/** Tuşun şu anda basılmaya başlanıp başlanmadığı. */
	private boolean basma;
	/** Tuşun şu anda bırakılıp bırakılmadığı. */
	private boolean salma;
	/** Tuşun anlık girdisi. */
	boolean girdi;
	/** Tuşun girdisini işleyen. */
	public Object hedef;
	/** Tuşu temsil eden sayı kodu. */
	public final int kod;
	
	/** Tuşu tanımlar. */
	Tuş(final int kod) {
		this.kod = kod;
	}
	
	/** Tuşu günceller. */
	void güncelle() {
		basma = !aşağı && girdi;
		salma = aşağı && !girdi;
		aşağı = girdi;
		hedef = null;
	}
	
	/** Tuş şu anda basılıysa doğru döndürür. */
	public boolean aşağı() {
		return aşağı;
	}
	
	/** Tuş şu anda basılmaya başlandıysa doğru döndürür. */
	public boolean basma() {
		return basma;
	}
	
	/** Tuş şu anda bırakıldıysa doğru döndürür. */
	public boolean salma() {
		return salma;
	}
	
	/** Tuşun uygun olup olmadığını döndürür. */
	public boolean uygun(final Object nesne) {
		return hedef == null || hedef == nesne;
	}
}
