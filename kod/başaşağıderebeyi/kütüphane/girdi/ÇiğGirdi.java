/**
 * başaşağıderebeyi.kütüphane.girdi.ÇiğGirdi.java
 * 0.5 / 18 Oca 2021 / 10:51:20
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 *
 * BaşAşağıMotor'dan alındı.
 * 0.4 / 29 Ağu 2020 / 00:26:39
 */
package başaşağıderebeyi.kütüphane.girdi;

import başaşağıderebeyi.kütüphane.matematik.*;

import java.util.*;

/** Anlamlandırılmamış, farklı türlerde girdiler. */
public class ÇiğGirdi {
	/** Faredeki tuşlar. */
	private final Map<Integer, Tuş> fare;
	/** Fare imlecinin anlık girdisi. */
	private final Yöney2 imleçGirdisi;
	/** Fare tekerleğinin dönüş devri. */
	private int tekerlekDevri;
	/** Fare tekerleğinin anlık girdisi. */
	private int tekerlekGirdisi;
	/** Tuş takımındaki tuşlar. */
	private final Map<Integer, Tuş> tuşTakımı;
	/** Fare imlecinin ekrandaki konumu. */
	public final Yöney2 imleç;
	/** Fare imlecinin girdisini işleyen. */
	public Object imleçHedefi;
	/** Fare imlecinin konumundaki değişim. */
	public final Yöney2 sürükleme;
	/** Fare tekerleğinin girdisini işleyen. */
	public Object tekerlekHedefi;
	
	/** Tuşsuz girdi tanımlar. */
	public ÇiğGirdi() {
		tuşTakımı = new HashMap<>();
		fare = new HashMap<>();
		imleç = new Yöney2();
		sürükleme = new Yöney2();
		imleçGirdisi = new Yöney2();
	}
	
	/** Fare tuşu döndürür. */
	public Tuş alFareTuşu(final int kod) {
		return fare.get(kod);
	}
	
	/** Tekerlek devrini döndürür. */
	public int alTekerlekDevri() {
		return tekerlekDevri;
	}
	
	/** Fare tuşu ekler. */
	public void ekleFareTuşu(final int kod) {
		if (!fare.containsKey(kod))
			fare.put(kod, new Tuş(kod));
	}
	
	/** Bütün girdileri günceller. */
	public void güncelle() {
		tekerlekDevri = tekerlekGirdisi;
		tekerlekGirdisi = 0;
		sürükleme.çıkar(imleçGirdisi, imleç);
		imleç.değiştir(imleçGirdisi);
		for (final Tuş tuş : tuşTakımı.values())
			tuş.güncelle();
		for (final Tuş tuş : fare.values())
			tuş.güncelle();
		imleçHedefi = null;
		tekerlekHedefi = null;
	}
	
	/** İmlecin uygun olup olmadığını döndürür. */
	public boolean imleçUygunMu(final Object nesne) {
		return imleçHedefi == null || imleçHedefi == nesne;
	}
	
	/** Tekerleğin uygun olup olmadığını döndürür. */
	public boolean tekerlekUygunMu(final Object nesne) {
		return tekerlekHedefi == null || tekerlekHedefi == nesne;
	}
	
	/** Tuş takımı tuşunun girdisini yazar. */
	public void tuşTakımıGirdisi(final int kod, final boolean girdi) {
		final Tuş tuş = tuşTakımıTuşuAl(kod);
		if (tuş != null)
			tuş.girdi = girdi;
	}
	
	/** Tuş takımı tuşu döndürür. */
	public Tuş tuşTakımıTuşuAl(final int kod) {
		return tuşTakımı.get(kod);
	}
	
	/** Tuş takımı tuşu ekler. */
	public void tuşTakımıTuşuEkle(final int kod) {
		if (!tuşTakımı.containsKey(kod))
			tuşTakımı.put(kod, new Tuş(kod));
	}
	
	/** Fare tuşunun girdisini yazar. */
	public void yazFareGirdisi(final int kod, final boolean girdi) {
		final Tuş tuş = alFareTuşu(kod);
		if (tuş != null)
			tuş.girdi = girdi;
	}
	
	/** İmleç girdisi yazar. */
	public void yazİmleçGirdisi(final float x, final float y) {
		imleçGirdisi.değiştir(x, y);
	}
	
	/** Tekerlek devrini ekler. */
	public void yazTekerlekGirdisi(final int devir) {
		tekerlekGirdisi += devir;
	}
}
