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
	/** Tuşu temsil eden sayı kodu. */
	public final int kod;
	/** Tuşun şu anda basılı olup olmadığı. */
	private boolean aşağı;
	/** Tuşun şu anda basılmaya başlanıp başlanmadığı. */
	private boolean basma;
	/** Tuşun şu anda bırakılıp bırakılmadığı. */
	private boolean salma;
	/** Tuşun anlık girdisi. */
	boolean girdi;
	/** Tuşun girdisini işleyen. */
	private Object hedef;
	
	/** Tuşu tanımlar. */
	Tuş(final int kod) {
		this.kod = kod;
	}
	
	/** Tuşu günceller. */
	void güncelle() {
		this.basma = !this.aşağı && this.girdi;
		this.salma = this.aşağı && !this.girdi;
		this.aşağı = this.girdi;
		this.hedefYaz(null);
	}
	
	/** Tuş şu anda basılıysa doğru döndürür. */
	public boolean aşağı() {
		return this.aşağı;
	}
	
	/** Tuş şu anda basılmaya başlandıysa doğru döndürür. */
	public boolean basma() {
		return this.basma;
	}
	
	/** Tuş şu anda bırakıldıysa doğru döndürür. */
	public boolean salma() {
		return this.salma;
	}
	
	/** Hedefi değiştirir. */
	public void hedefYaz(final Object hedef) {
		this.hedef = hedef;
	}
	
	/** Tuşun uygun olup olmadığını döndürür. */
	public boolean uygun(final Object nesne) {
		return this.hedef == null || this.hedef == nesne;
	}
}
