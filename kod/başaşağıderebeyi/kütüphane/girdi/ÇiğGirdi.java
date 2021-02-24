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

/** Bilgisayara veri girmede kullanılan farklı türlerde girdilerin, anlamlandırılmadan işlenmeye hazır
 * hale getirilmesini sağlayan bir yardımcı. */
public class ÇiğGirdi {
	private final Map<Integer, Tuş> klavyesininTuşları;
	private final Map<Integer, Tuş> faresininTuşları;
	private final Dağıtıcı<Tuş> tuşlarınınDağıtıcısı;
	
	private final Yöney2 imlecininEşzamansızKonumu;
	
	/** Bu girdiye sağlanan imlecin ekrandaki konumu. */
	public final Yöney2 imlecininKonumu;
	
	/** Bu girdiye sağlanan imlecin konumundaki değişim. */
	public final Yöney2 imlecininSürüklenmesi;
	
	/** Bu girdiye sağlanan fare imlecinin girdisini kullanan (dinleyen ve işleyen) nesne. İmlecin
	 * girdisini kullanmadan önce uygun olup olmadığına bakılmalı ve kullanıldıktan sonra bu nesne
	 * değiştirilmelidir. */
	public Object imlecininHedefi;
	
	private volatile int tekerleğininEşzamansızDevirlerininToplamı;
	private int tekerleğininDevri;
	
	/** Bu girdiye sağlanan fare tekerleğinin girdisini kullanan (dinleyen ve işleyen) nesne. Tekerleğin
	 * girdisini kullanmadan önce uygun olup olmadığına bakılmalı ve kullanıldıktan sonra bu nesne
	 * değiştirilmelidir. */
	public Object tekerleğininHedefi;
	
	public ÇiğGirdi() {
		klavyesininTuşları = new HashMap<>();
		faresininTuşları = new HashMap<>();
		tuşlarınınDağıtıcısı = new Dağıtıcı<>();
		tuşlarınınDağıtıcısı.yürütmeyiDeğiştir(Tuş::güncelle);
		
		imlecininKonumu = new Yöney2();
		imlecininSürüklenmesi = new Yöney2();
		imlecininEşzamansızKonumu = new Yöney2();
	}
	
	/** Bütün girdilerin anlık durumunu günceller. */
	public void güncelle() {
		tuşlarınınDağıtıcısı.yürüt();
		
		imlecininSürüklenmesi.çıkar(imlecininEşzamansızKonumu, imlecininKonumu);
		imlecininKonumu.değiştir(imlecininEşzamansızKonumu);
		imlecininHedefi = null;
		
		tekerleğininDevri = tekerleğininEşzamansızDevirlerininToplamı;
		tekerleğininEşzamansızDevirlerininToplamı = 0;
		tekerleğininHedefi = null;
	}
	
	/** Verilen tuş koduna denk gelen klavye tuşunu döndürür. Eğer denk bir tuş yoksa null döndürür. */
	public Tuş klavyesininTuşunuEdin(final int tuşunKodu) {
		return klavyesininTuşları.get(tuşunKodu);
	}
	
	/** Eğer verilen tuş koduna denk gelen bir klavye tuşu yoksa yeni bir temsili tuş oluşturur. */
	public void klavyesininTuşunuEkle(final int tuşunKodu) {
		if (!klavyesininTuşları.containsKey(tuşunKodu)) {
			final Tuş tuş = new Tuş(tuşunKodu);
			klavyesininTuşları.put(tuşunKodu, tuş);
			tuşlarınınDağıtıcısı.dağıt(tuş);
		}
	}
	
	/** Verilen tuş koduna denk gelen fare tuşunu döndürür. Eğer denk bir tuş yoksa null döndürür. */
	public Tuş faresininTuşunuEdin(final int tuşunKodu) {
		return faresininTuşları.get(tuşunKodu);
	}
	
	/** Eğer verilen tuş koduna denk gelen bir fare tuşu yoksa yeni bir temsili tuş oluşturur. */
	public void faresininTuşunuEkle(final int tuşKodu) {
		if (!faresininTuşları.containsKey(tuşKodu)) {
			final Tuş tuş = new Tuş(tuşKodu);
			faresininTuşları.put(tuşKodu, tuş);
			tuşlarınınDağıtıcısı.dağıt(tuş);
		}
	}
	
	/** Fare imlecinin eşzamansız olarak ekrandaki konumunu bildirir. */
	public void imlecininKonumunuBildir(final float x, final float y) {
		imlecininEşzamansızKonumu.bileşenleriDeğiştir(x, y);
	}
	
	/** Fare imlecinin verilen nesne tarafından kullanılmaya uygun olup olmadığını döndürür. Uygunsa
	 * imlecin hedefini verilen nesneyle değiştirirek imleci kullanılmış olarak işaretler. */
	public boolean imleciniKullanmayıDene(final Object nesne) {
		if (imlecininHedefi == null) {
			imlecininHedefi = nesne;
			return true;
		}
		
		return imlecininHedefi == nesne;
	}
	
	/** Fare tekerleğinin eşzamansız olarak ekrandaki konumunu bildirir. */
	public void tekerleğininDevriniBildir(final int tekerleğininDevri) {
		tekerleğininEşzamansızDevirlerininToplamı += tekerleğininDevri;
	}
	
	/** Fare tekerleğinin şu andaki devrini döndürür. */
	public int tekerleğininDevriniEdin() {
		return tekerleğininDevri;
	}
	
	/** Fare tekerleğinin verilen nesne tarafından kullanılmaya uygun olup olmadığını döndürür. Uygunsa
	 * tekerleğin hedefini verilen nesneyle değiştirirek tekerleği kullanılmış olarak işaretler. */
	public boolean tekerleğiniKullanmayıDene(final Object nesne) {
		if (tekerleğininHedefi == null) {
			tekerleğininHedefi = nesne;
			return true;
		}
		
		return tekerleğininHedefi == nesne;
	}
}
