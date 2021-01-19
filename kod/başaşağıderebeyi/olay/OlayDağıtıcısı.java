/**
 * başaşağıderebeyi.olay.OlayDağıtıcısı.java
 * 0.6 / 19 Oca 2021 / 08:08:05
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 * 
 * BaşAşağıMotor'dan biraz alındı.
 * 0.28 / 9 Kas 2020 / 15:27:51
 * 
 * Waistax Engine'den biraz alındı.
 * 1.1.? / ? Ağu 2016 / ?
 */
package başaşağıderebeyi.olay;

import java.lang.reflect.*;
import java.util.*;

/** Olayları dinleyicilere dağıtır. */
public class OlayDağıtıcısı {
	/** Kayıtlı dinleyicilerin bilgileri. */
	private final Map<Class<? extends Olay>, Map<Öncelik, Set<DinleyiciBilgisi>>> dinleyiciler;
	/** Bekleyen olaylar. */
	private final List<Olay> olaySırası;
	/** İşlenmekte olan olaylar. */
	private final List<Olay> işlenenOlaylar;
	/** Eklenmeyi bekleyen dinleyiciler. */
	private final Set<Object> eklenecekler;
	/** Çıkarılmayı bekleyen dinleyiciler. */
	private final Set<Object> çıkarılacaklar;
	
	/** Boş dağıtıcı tanımlar. */
	public OlayDağıtıcısı() {
		dinleyiciler = new HashMap<>();
		olaySırası = new ArrayList<>();
		işlenenOlaylar = new ArrayList<>();
		eklenecekler = new HashSet<>();
		çıkarılacaklar = new HashSet<>();
	}
	
	/** Olayı sıraya ekler. */
	public void olayEkle(Olay olay) {
		synchronized (olaySırası) {
			olaySırası.add(olay);
		}
	}
	
	/** Dinleyiciyi ekleme sırasına koyar. */
	public void dinleyiciEkle(Object nesne) {
		synchronized (olaySırası) {
			eklenecekler.add(nesne);
		}
	}
	
	/** Dinleyiciyi çıkarma sırasına koyar. */
	public void dinleyiciÇıkar(Object nesne) {
		synchronized (çıkarılacaklar) {
			çıkarılacaklar.add(nesne);
		}
	}
	
	/** Dinleyicileri günceller, olayları işler. */
	public void güncelle() {
		synchronized(eklenecekler) {
			eklenecekler.forEach(ö -> dinleyiciEklemeİşlemi(ö));
			eklenecekler.clear();
		}
		synchronized (çıkarılacaklar) {
			çıkarılacaklar.forEach(ö -> dinleyiciÇıkarmaİşlemi(ö));
			çıkarılacaklar.clear();
		}
		synchronized (olaySırası) {
			işlenenOlaylar.addAll(olaySırası);
			olaySırası.clear();
		}
		işlenenOlaylar.forEach(ö -> olayıİşle(ö));
		işlenenOlaylar.clear();
	}
	
	/** Olayı işler. */
	private void olayıİşle(Olay olay) {
		Map<Öncelik, Set<DinleyiciBilgisi>> sınıfHaritası = dinleyiciler.get(olay.getClass());
		if (sınıfHaritası == null)
			return;
		for (Öncelik öncelik : Öncelik.values()) {
			Set<DinleyiciBilgisi> öncelikKümesi = sınıfHaritası.get(öncelik);
			Iterator<DinleyiciBilgisi> yineleyici = öncelikKümesi.iterator();
			while (yineleyici.hasNext()) {
				DinleyiciBilgisi bilgi = yineleyici.next();
				if (olay.kaldırılmış && !bilgi.kaldırılmışlarıDinler)
					continue;
				try {
					bilgi.yöntem.invoke(bilgi.nesne, olay);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/** Dinleyiciyi ekler. */
	private void dinleyiciEklemeİşlemi(Object nesne) {
		for (Method yöntem : nesne.getClass().getMethods()) {
			if (!yöntem.isAnnotationPresent(Dinleyici.class))
				continue;
			Class<?>[] etkenler = yöntem.getParameterTypes();
			if (etkenler.length != 1)
				throw new RuntimeException("Dinleyici tek bir olay almalıdır!");
			@SuppressWarnings("unchecked")
			Class<? extends Olay> sınıf = (Class<? extends Olay>)etkenler[0];
			Dinleyici dinleyici = yöntem.getAnnotation(Dinleyici.class);
			Map<Öncelik, Set<DinleyiciBilgisi>> sınıfHaritası = dinleyiciler.get(sınıf);
			if (sınıfHaritası == null) {
				sınıfHaritası = new HashMap<>();
				for (Öncelik öncelik : Öncelik.values())
					sınıfHaritası.put(öncelik, new HashSet<>());
				dinleyiciler.put(sınıf, sınıfHaritası);
			}
			sınıfHaritası.get(dinleyici.öncelik()).add(new DinleyiciBilgisi(nesne, yöntem, dinleyici.kaldırılmışlarıDinler()));
		}
	}
	
	/** Dinleyiciyi çıkarır. */
	private void dinleyiciÇıkarmaİşlemi(Object nesne) {
		for (Map<Öncelik, Set<DinleyiciBilgisi>> sınıfHaritası : dinleyiciler.values())
			for (Öncelik öncelik : Öncelik.values()) {
				Iterator<DinleyiciBilgisi> yineleyici = sınıfHaritası.get(öncelik).iterator();
				while (yineleyici.hasNext())
					if (yineleyici.next().nesne == nesne)
						yineleyici.remove();
			}
	}
}
