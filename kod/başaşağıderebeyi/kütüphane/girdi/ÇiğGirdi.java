/**
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 * 0.5 / 18 Oca 2021 / 10:51:20
 *
 * BaşAşağıMotor'dan alındı.
 * 0.4 / 29 Ağu 2020 / 00:26:39
 */
package başaşağıderebeyi.kütüphane.girdi;

import başaşağıderebeyi.kütüphane.matematik.sayısal.*;

import java.util.*;
import java.util.stream.*;

/** Bilgisayara veri girmede kullanılan farklı türlerde girdilerin,
 * anlamlandırılmadan işlenmeye hazır hale getirilmesini sağlayan bir
 * yardımcı. */
public class ÇiğGirdi {
	private final Map<Integer, Tuş> klavyesininTuşları;
	private final Map<Integer, Tuş> faresininTuşları;
	
	private final Yöney2 imlecininEşzamansızKonumu;
	/** Fare imlecinin şu andaki konumu. */
	public final Yöney2 imlecininKonumu;
	/** Fare imlecinin konumunun bir önceki an ile şu an arasındaki değişimi. */
	public final Yöney2 imlecininSürüklenmesi;
	
	private volatile int tekerleğininEşzamansızDevirlerininToplamı;
	/** Fare tekerleğinin bir önceki an ile şu an arasındaki toplam döndüğü
	 * devir. */
	public int tekerleğininDevri;
	
	public ÇiğGirdi() {
		klavyesininTuşları = new HashMap<>();
		faresininTuşları = new HashMap<>();
		
		imlecininKonumu = new Yöney2();
		imlecininSürüklenmesi = new Yöney2();
		imlecininEşzamansızKonumu = new Yöney2();
	}
	
	/** Bütün girdilerin anlık durumunu günceller. */
	public void güncelle() {
		Stream
			.concat(
				klavyesininTuşları.values().parallelStream(),
				faresininTuşları.values().parallelStream())
			.forEach(Tuş::güncelle);
		
		imlecininSürüklenmesi.çıkar(imlecininEşzamansızKonumu, imlecininKonumu);
		imlecininKonumu.değiştir(imlecininEşzamansızKonumu);
		
		tekerleğininDevri = tekerleğininEşzamansızDevirlerininToplamı;
		tekerleğininEşzamansızDevirlerininToplamı = 0;
	}
	
	/** Verilen tuş koduna denk gelen klavye tuşunu döndürür. Eğer denk bir tuş
	 * yoksa null döndürür. */
	public Tuş klavyesininTuşunuEdin(final int tuşunKodu) {
		return klavyesininTuşları.get(tuşunKodu);
	}
	
	/** Eğer verilen tuş koduna denk gelen bir klavye tuşu yoksa yeni bir
	 * temsili tuş oluşturur. */
	public void klavyesininTuşunuEkle(final int tuşunKodu) {
		if (!klavyesininTuşları.containsKey(tuşunKodu)) {
			final Tuş tuş = new Tuş(tuşunKodu);
			klavyesininTuşları.put(tuşunKodu, tuş);
		}
	}
	
	/** Verilen tuş koduna denk gelen fare tuşunu döndürür. Eğer denk bir tuş
	 * yoksa null döndürür. */
	public Tuş faresininTuşunuEdin(final int tuşunKodu) {
		return faresininTuşları.get(tuşunKodu);
	}
	
	/** Eğer verilen tuş koduna denk gelen bir fare tuşu yoksa yeni bir temsili
	 * tuş oluşturur. */
	public void faresininTuşunuEkle(final int tuşKodu) {
		if (!faresininTuşları.containsKey(tuşKodu)) {
			final Tuş tuş = new Tuş(tuşKodu);
			faresininTuşları.put(tuşKodu, tuş);
		}
	}
	
	/** Fare imlecinin eşzamansız olarak ekrandaki konumunu bildirir. */
	public void imlecininKonumunuBildir(final float x, final float y) {
		imlecininEşzamansızKonumu.bileşenleriniDeğiştir(x, y);
	}
	
	/** Fare tekerleğinin eşzamansız olarak ekrandaki konumunu bildirir. */
	public void tekerleğininDevriniBildir(final int tekerleğininDevri) {
		tekerleğininEşzamansızDevirlerininToplamı += tekerleğininDevri;
	}
	
	/** Fare tekerleğinin şu andaki devrini döndürür. */
	public int tekerleğininDevriniEdin() {
		return tekerleğininDevri;
	}
}
