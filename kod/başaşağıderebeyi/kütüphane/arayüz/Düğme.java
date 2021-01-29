/**
 * başaşağıderebeyi.kütüphane.arayüz.Düğme.java
 * 0.7 / 27 Oca 2021 / 11:05:54
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 * 
 * BaşAşağıMotor'dan alındı.
 * 0.16 / 14 Eyl 2020 / 00:35:13
 */
package başaşağıderebeyi.kütüphane.arayüz;

/** Sol fare tuşuyla basılabilen öğe. */
public class Düğme extends Öğe {
	/** Düğmenin yazısı. */
	public final String yazı;
	/** Düğmenin çalıştırdığı kod. */
	private final Runnable çalıştırılabilir;
	/** Düğmenin bu güncellemede basılı olup olmadığı. */
	private boolean basılı;
	
	/** Tanımlar. */
	public Düğme(final Levha levha, final String yazı, final Runnable çalıştırılabilir) {
		super(levha);
		this.yazı = yazı;
		this.çalıştırılabilir = çalıştırılabilir;
	}
	
	@Override
	public void güncelle() {
		if (!this.açıkMı()) {
			return;
		}
		if (this.üzerinde) {
			if (this.ekran.solTık.basma()) {
				this.odakla();
				this.basılı = true;
			} else if (this.basılı && this.ekran.solTık.salma()) {
				this.odakla();
				this.çalıştırılabilir.run();
				this.basılı = false;
			}
		} else {
			this.basılı = false;
		}
	}
	
	/** Düğmenin basılıp basılmadığını döndürür. */
	public boolean basılıMı() {
		return this.basılı;
	}
}
