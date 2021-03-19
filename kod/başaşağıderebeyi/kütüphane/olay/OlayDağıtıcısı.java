/**
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 * 0.7 / 19 Oca 2021 / 12:28:25
 * 
 * BaşAşağıMotor'dan biraz alındı.
 * 0.28 / 9 Kas 2020 / 15:27:51
 *
 * Waistax Engine'den biraz alındı.
 * 1.1.? / ? Ağu 2016 / ?
 */
package başaşağıderebeyi.kütüphane.olay;

import java.util.*;

/** Olayları dinleyicilere dağıtır. */
public class OlayDağıtıcısı {
	private final Map<
		Class<? extends Olay>,
		SınıfınDinleyicileri<? extends Olay>> sınıflarınDinleyicileri;
	
	/** Boş dağıtıcı tanımlar. */
	public OlayDağıtıcısı() {
		sınıflarınDinleyicileri = new HashMap<>();
	}
	
	/** Verilen olayı dağıtır. */
	@SuppressWarnings("unchecked")
	public <T extends Olay> void dağıt(final T olay) {
		SınıfınDinleyicileri<? extends Olay> sınıfınDinleyicileri =
			sınıflarınDinleyicileri.get(olay.getClass());
		
		if (sınıfınDinleyicileri == null)
			return;
		
		((SınıfınDinleyicileri<T>)sınıfınDinleyicileri).dağıt(olay);
	}
	
	/** Verilen dinleyiciyi ekler. */
	@SuppressWarnings("unchecked")
	public <T extends Olay> void dinleyiciyiEkle(
		DinleyiciBilgisi<T> dinleyiciBilgisi) {
		SınıfınDinleyicileri<? extends Olay> sınıfınDinleyicileri =
			sınıflarınDinleyicileri.get(dinleyiciBilgisi.dinlediğiOlay);
		
		if (sınıfınDinleyicileri == null) {
			sınıfınDinleyicileri = new SınıfınDinleyicileri<>();
			sınıflarınDinleyicileri
				.put(dinleyiciBilgisi.dinlediğiOlay, sınıfınDinleyicileri);
		}
		
		((SınıfınDinleyicileri<T>)sınıfınDinleyicileri).ekle(dinleyiciBilgisi);
	}
	
	/** Verilen dinleyiciyi çıkarır. */
	@SuppressWarnings("unchecked")
	public <T extends Olay> void dinleyiciyiÇıkar(
		DinleyiciBilgisi<T> dinleyiciBilgisi) {
		SınıfınDinleyicileri<? extends Olay> sınıfınDinleyicileri =
			sınıflarınDinleyicileri.get(dinleyiciBilgisi.dinlediğiOlay);
		
		if (sınıfınDinleyicileri == null)
			return;
		
		((SınıfınDinleyicileri<T>)sınıfınDinleyicileri).çıkar(dinleyiciBilgisi);
	}
}
