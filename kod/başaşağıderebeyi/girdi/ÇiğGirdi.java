/**
 * başaşağıderebeyi.girdi.ÇiğGirdi.java
 * 0.5 / 18 Oca 2021 / 10:51:20
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 * 
 * BaşAşağıMotor'dan alındı.
 * 0.4 / 29 Ağu 2020 / 00:26:39
 */
package başaşağıderebeyi.girdi;

import başaşağıderebeyi.matematik.*;

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
	
	/** Tuşsuz girdi tanımlar. */
	public ÇiğGirdi() {
		tuşTakımı = new HashMap<>();
		fare = new HashMap<>();
		imleç = new Yöney2();
		sürükleme = new Yöney2();
		imleçGirdisi = new Yöney2();
	}
	
	/** Bütün girdileri günceller. */
	public void güncelle() {
		tekerlekDevri = tekerlekGirdisi;
		tekerlekGirdisi = 0;
		sürükleme.çıkar(imleçGirdisi, imleç);
		imleç.yaz(imleçGirdisi);
		for (Tuş tuş : tuşTakımı.values())
			tuş.güncelle();
		for (Tuş tuş : fare.values())
			tuş.güncelle();
	}
	
	/** Tuş takımı tuşu ekler. */
	public void tuşTakımıTuşuEkle(int kod) {
		if (!tuşTakımı.containsKey(kod))
			tuşTakımı.put(kod, new Tuş(kod));
	}
	
	/** Tuş takımı tuşu döndürür. */
	public Tuş tuşTakımıTuşuAl(int kod) {
		return tuşTakımı.get(kod);
	}
	
	/** Tuş takımı tuşunun girdisini yazar. */
	public void tuşTakımıGirdisi(int kod, boolean girdi) {
		Tuş tuş = tuşTakımıTuşuAl(kod);
		if (tuş != null)
			tuş.girdi = girdi;
	}
	
	/** Fare tuşu ekler. */
	public void fareTuşuEkle(int kod) {
		if (!fare.containsKey(kod))
			fare.put(kod, new Tuş(kod));
	}
	
	/** Fare tuşu döndürür. */
	public Tuş fareTuşuAl(int kod) {
		return fare.get(kod);
	}
	
	/** Fare tuşunun girdisini yazar. */
	public void fareGirdisi(int kod, boolean girdi) {
		Tuş tuş = fareTuşuAl(kod);
		if (tuş != null)
			tuş.girdi = girdi;
	}
	
	/** İmleç girdisi yazar. */
	public void imleçGirdisi(float x, float y) {
		imleçGirdisi.yaz(x, y);
	}
	
	/** Tekerlek devrini döndürür. */
	public int tekerlekDevriniAl() {
		return tekerlekDevri;
	}
	
	/** Tekerlek devrini ekler. */
	public void tekerlekGirdisi(int devir) {
		tekerlekGirdisi += devir;
	}
}
