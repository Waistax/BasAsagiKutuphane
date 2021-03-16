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
	public Runnable çalıştıracağı;
	/** Düğmenin yazısı. */
	public String yazısı;
	
	/** Verilen levhanın içinde tanımlar. */
	public Düğme(final Levha levha) {
		super(levha);
	}
	
	@Override
	public void güncelle() {
		if (!açıkOlmasınıEdin() || !imleçtenİlgiGörmesi)
			return;
		
		if (içerenEkran.solTık.basılmasınıEdin())
			odakla();
		else if (içerenEkran.solTık.salınmasınıEdin()) {
			odakla();
			çalıştıracağı.run();
		}
	}
}
