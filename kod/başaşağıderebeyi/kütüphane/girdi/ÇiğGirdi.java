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
import başaşağıderebeyi.kütüphane.yürütücü.*;

import java.util.*;

/** Anlamlandırılmamış, farklı türlerde girdiler. */
public class ÇiğGirdi {
	/** Klavyedeki tuşlar. */
	private final Map<Integer, Tuş> klavye;
	/** Faredeki tuşlar. */
	private final Map<Integer, Tuş> fare;
	/** Tuşları aynı anda güncellenebilmeleri için dağıtan. */
	private final Dağıtıcı<Tuş> tuşDağıtıcısı;
	
	/** Fare imlecinin anlık girdisi. */
	private final Yöney2 imleçGirdisi;
	/** Fare imlecinin ekrandaki konumu. */
	public final Yöney2 imleç;
	/** Fare imlecinin konumundaki değişim. */
	public final Yöney2 sürükleme;
	/** Fare imlecinin girdisini işleyen. */
	public Object imleçHedefi;
	
	/** Fare tekerleğinin eşzamansız dönüşlerinin toplamı. */
	private volatile int tekerlekGirdisi;
	/** Fare tekerleğinin dönüş devri. */
	private int tekerlekDevri;
	/** Fare tekerleğinin girdisini işleyen. */
	public Object tekerlekHedefi;
	
	/** Tuşsuz girdi tanımlar. */
	public ÇiğGirdi() {
		klavye = new HashMap<>();
		fare = new HashMap<>();
		
		tuşDağıtıcısı = new Dağıtıcı<>();
		tuşDağıtıcısı.yürütmeyiDeğiştir(tuş -> tuş.güncelle());
		
		imleç = new Yöney2();
		sürükleme = new Yöney2();
		imleçGirdisi = new Yöney2();
	}
	
	/** Bütün girdileri günceller. */
	public void güncelle() {
		tuşDağıtıcısı.yürüt();

		sürükleme.çıkar(imleçGirdisi, imleç);
		imleç.değiştir(imleçGirdisi);
		imleçHedefi = null;

		tekerlekDevri = tekerlekGirdisi;
		tekerlekGirdisi = 0;
		tekerlekHedefi = null;
	}
	
	/** Tuş takımı tuşu döndürür. */
	public Tuş klavyeTuşunuEdin(final int tuşKodu) {
		return klavye.get(tuşKodu);
	}
	
	/** Tuş takımı tuşunun girdisini yazar. */
	public void klavyeTuşununAşağıOlduğunuDeğiştir(final int tuşKodu, final boolean aşağı) {
		final Tuş tuş = klavyeTuşunuEdin(tuşKodu);
		if (tuş != null)
			tuş.aşağıOlduğunuDeğiştir(aşağı);
	}
	
	/** Tuş takımı tuşu ekler. */
	public void klavyeTuşuEkle(final int tuşKodu) {
		if (!klavye.containsKey(tuşKodu)) {
			Tuş tuş = new Tuş(tuşKodu);
			klavye.put(tuşKodu, tuş);
			tuşDağıtıcısı.dağıt(tuş);
		}
	}
	
	/** Fare tuşu döndürür. */
	public Tuş fareTuşuEdin(final int tuşKodu) {
		return fare.get(tuşKodu);
	}
	
	/** Fare tuşu ekler. */
	public void fareTuşuEkle(final int tuşKodu) {
		if (!fare.containsKey(tuşKodu)) {
			Tuş tuş = new Tuş(tuşKodu);
			fare.put(tuşKodu, tuş);
			tuşDağıtıcısı.dağıt(tuş);
		}
	}
	
	/** Fare tuşunun girdisini yazar. */
	public void fareTuşununAşağıOlduğunuDeğiştir(final int tuşKodu, final boolean aşağı) {
		final Tuş tuş = fareTuşuEdin(tuşKodu);
		if (tuş != null)
			tuş.aşağıOlduğunuDeğiştir(aşağı);
	}
	
	/** Tekerlek devrini döndürür. */
	public int alTekerlekDevri() {
		return tekerlekDevri;
	}
	
	/** İmlecin uygun olup olmadığını döndürür. */
	public boolean imleçUygunMu(final Object nesne) {
		return imleçHedefi == null || imleçHedefi == nesne;
	}
	
	/** Tekerleğin uygun olup olmadığını döndürür. */
	public boolean tekerlekUygunMu(final Object nesne) {
		return tekerlekHedefi == null || tekerlekHedefi == nesne;
	}
	
	/** İmleç girdisi yazar. */
	public void yazİmleçGirdisi(final float x, final float y) {
		imleçGirdisi.bileşenleriDeğiştir(x, y);
	}
	
	/** Tekerlek devrini ekler. */
	public void yazTekerlekGirdisi(final int devir) {
		tekerlekGirdisi += devir;
	}
}
