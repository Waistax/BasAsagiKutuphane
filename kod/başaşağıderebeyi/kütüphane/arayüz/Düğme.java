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
	/** Düğmenin çalıştırdığı kod. */
	private final Runnable çalıştırılabilir;
	/** Düğmenin yazısı. */
	public final String yazı;
	
	/** Tanımlar. */
	public Düğme(final Levha levha, final String yazı, final Runnable çalıştırılabilir) {
		super(levha);
		this.yazı = yazı;
		this.çalıştırılabilir = çalıştırılabilir;
	}
	
	@Override
	public void güncelle() {
		if (!açıkMı())
			return;

		if (üzerinde) {
			if (ekran.solTık.basıldıMı()) {
				odakla();
				basılı = true;
			} else if (basılı && ekran.solTık.salındıMı()) {
				odakla();
				çalıştırılabilir.run();
				basılı = false;
			}
		} else
			basılı = false;
	}
}
