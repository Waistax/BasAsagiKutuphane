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
	/** Tuş takımındaki tuşlar. */
	private final Map<Integer, Tuş> tuşTakımı;
	/** Faredeki tuşlar. */
	private final Map<Integer, Tuş> fare;
	/** Fare imlecinin ekrandaki konumu. */
	public final Yöney2 imleç;
	/** Fare imlecinin konumundaki değişim. */
	public final Yöney2 sürükleme;
	/** Fare imlecinin anlık girdisi. */
	private final Yöney2 imleçGirdisi;
	/** Fare tekerleğinin dönüş devri. */
	private int tekerlekDevri;
	/** Fare tekerleğinin anlık girdisi. */
	private int tekerlekGirdisi;
	/** Fare imlecinin girdisini işleyen. */
	public Object imleçHedefi;
	/** Fare tekerleğinin girdisini işleyen. */
	public Object tekerlekHedefi;
	
	/** Tuşsuz girdi tanımlar. */
	public ÇiğGirdi() {
		this.tuşTakımı = new HashMap<>();
		this.fare = new HashMap<>();
		this.imleç = new Yöney2();
		this.sürükleme = new Yöney2();
		this.imleçGirdisi = new Yöney2();
	}
	
	/** Bütün girdileri günceller. */
	public void güncelle() {
		this.tekerlekDevri = this.tekerlekGirdisi;
		this.tekerlekGirdisi = 0;
		this.sürükleme.çıkar(this.imleçGirdisi, this.imleç);
		this.imleç.yaz(this.imleçGirdisi);
		for (final Tuş tuş : this.tuşTakımı.values()) {
			tuş.güncelle();
		}
		for (final Tuş tuş : this.fare.values()) {
			tuş.güncelle();
		}
		this.imleçHedefi = null;
		this.tekerlekHedefi = null;
	}
	
	/** Tuş takımı tuşu ekler. */
	public void tuşTakımıTuşuEkle(final int kod) {
		if (!this.tuşTakımı.containsKey(kod)) {
			this.tuşTakımı.put(kod, new Tuş(kod));
		}
	}
	
	/** Tuş takımı tuşu döndürür. */
	public Tuş tuşTakımıTuşuAl(final int kod) {
		return this.tuşTakımı.get(kod);
	}
	
	/** Tuş takımı tuşunun girdisini yazar. */
	public void tuşTakımıGirdisi(final int kod, final boolean girdi) {
		final Tuş tuş = this.tuşTakımıTuşuAl(kod);
		if (tuş != null) {
			tuş.girdi = girdi;
		}
	}
	
	/** Fare tuşu ekler. */
	public void ekleFareTuşu(final int kod) {
		if (!this.fare.containsKey(kod)) {
			this.fare.put(kod, new Tuş(kod));
		}
	}
	
	/** Fare tuşu döndürür. */
	public Tuş alFareTuşu(final int kod) {
		return this.fare.get(kod);
	}
	
	/** Fare tuşunun girdisini yazar. */
	public void yazFareGirdisi(final int kod, final boolean girdi) {
		final Tuş tuş = this.alFareTuşu(kod);
		if (tuş != null) {
			tuş.girdi = girdi;
		}
	}
	
	/** İmleç girdisi yazar. */
	public void yazİmleçGirdisi(final float x, final float y) {
		this.imleçGirdisi.yaz(x, y);
	}
	
	/** Tekerlek devrini döndürür. */
	public int alTekerlekDevri() {
		return this.tekerlekDevri;
	}
	
	/** Tekerlek devrini ekler. */
	public void yazTekerlekGirdisi(final int devir) {
		this.tekerlekGirdisi += devir;
	}
	
	/** İmlecin uygun olup olmadığını döndürür. */
	public boolean imleçUygunMu(final Object nesne) {
		return this.imleçHedefi == null || this.imleçHedefi == nesne;
	}
	
	/** Tekerleğin uygun olup olmadığını döndürür. */
	public boolean tekerlekUygunMu(final Object nesne) {
		return this.tekerlekHedefi == null || this.tekerlekHedefi == nesne;
	}
}
