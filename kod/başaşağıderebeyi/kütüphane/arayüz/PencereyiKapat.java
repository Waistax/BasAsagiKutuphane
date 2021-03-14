/**
 * başaşağıderebeyi.kütüphane.arayüz.PencereyiKapat.java
 * 0.7 / 27 Oca 2021 / 11:21:37
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.kütüphane.arayüz;

/** Pencereyi kapatan çalıştırabilir. */
public class PencereyiKapat implements Runnable {
	/** Kapatılacak pencere. */
	private final Pencere pencere;
	
	/** Pencere ile tanımlar. */
	public PencereyiKapat(final Pencere pencere) {
		this.pencere = pencere;
	}
	
	@Override
	public void run() {
		pencere.içerenEkran.içeriği.remove(pencere);
	}
}
