/**
 * başaşağıderebeyi.kütüphane.olay.OlayYöneticisi.java
 * 0.6 / 19 Oca 2021 / 08:08:05
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 *
 * BaşAşağıMotor'dan biraz alındı.
 * 0.28 / 9 Kas 2020 / 15:27:51
 *
 * Waistax Engine'den biraz alındı.
 * 1.1.? / ? Ağu 2016 / ?
 */
package başaşağıderebeyi.kütüphane.olay;

import java.lang.reflect.*;
import java.util.*;

/** Olayları teker teker bütün dinleyicilere dağıtır. */
public class OlayYöneticisi implements OlayDağıtıcısı {
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
	public OlayYöneticisi() {
		this.dinleyiciler = new HashMap<>();
		this.olaySırası = new ArrayList<>();
		this.işlenenOlaylar = new ArrayList<>();
		this.eklenecekler = new HashSet<>();
		this.çıkarılacaklar = new HashSet<>();
	}
	
	@Override
	public void olayEkle(final Olay olay) {
		synchronized (this.olaySırası) {
			this.olaySırası.add(olay);
		}
	}
	
	@Override
	public void dinleyiciEkle(final Object nesne) {
		synchronized (this.olaySırası) {
			this.eklenecekler.add(nesne);
		}
	}
	
	@Override
	public void dinleyiciÇıkar(final Object nesne) {
		synchronized (this.çıkarılacaklar) {
			this.çıkarılacaklar.add(nesne);
		}
	}
	
	@Override
	public void güncelle() {
		synchronized (this.eklenecekler) {
			this.eklenecekler.forEach(this::dinleyiciEklemeİşlemi);
			this.eklenecekler.clear();
		}
		synchronized (this.çıkarılacaklar) {
			this.çıkarılacaklar.forEach(this::dinleyiciÇıkarmaİşlemi);
			this.çıkarılacaklar.clear();
		}
		synchronized (this.olaySırası) {
			this.işlenenOlaylar.addAll(this.olaySırası);
			this.olaySırası.clear();
		}
		this.işlenenOlaylar.forEach(this::olayıİşle);
		this.işlenenOlaylar.clear();
	}
	
	/** Olayı işler. */
	private void olayıİşle(final Olay olay) {
		final Map<Öncelik, Set<DinleyiciBilgisi>> sınıfHaritası = this.dinleyiciler.get(olay.getClass());
		if (sınıfHaritası == null) {
			return;
		}
		for (final Öncelik öncelik : Öncelik.values()) {
			final Set<DinleyiciBilgisi> öncelikKümesi = sınıfHaritası.get(öncelik);
			final Iterator<DinleyiciBilgisi> yineleyici = öncelikKümesi.iterator();
			while (yineleyici.hasNext()) {
				final DinleyiciBilgisi bilgi = yineleyici.next();
				if (olay.kaldırılmış && !bilgi.kaldırılmışlarıDinler) {
					continue;
				}
				try {
					bilgi.yöntem.invoke(bilgi.nesne, olay);
				} catch (final Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/** Dinleyiciyi ekler. */
	private void dinleyiciEklemeİşlemi(final Object nesne) {
		for (final Method yöntem : nesne.getClass().getMethods()) {
			if (!yöntem.isAnnotationPresent(Dinleyici.class)) {
				continue;
			}
			final Class<?>[] etkenler = yöntem.getParameterTypes();
			if (etkenler.length != 1) {
				throw new RuntimeException("Dinleyici tek bir olay almalıdır!");
			}
			@SuppressWarnings("unchecked")
			final Class<? extends Olay> sınıf = (Class<? extends Olay>)etkenler[0];
			final Dinleyici dinleyici = yöntem.getAnnotation(Dinleyici.class);
			Map<Öncelik, Set<DinleyiciBilgisi>> sınıfHaritası = this.dinleyiciler.get(sınıf);
			if (sınıfHaritası == null) {
				sınıfHaritası = new HashMap<>();
				for (final Öncelik öncelik : Öncelik.values()) {
					sınıfHaritası.put(öncelik, new HashSet<>());
				}
				this.dinleyiciler.put(sınıf, sınıfHaritası);
			}
			sınıfHaritası.get(dinleyici.öncelik())
					.add(new DinleyiciBilgisi(nesne, yöntem, dinleyici.kaldırılmışlarıDinler()));
		}
	}
	
	/** Dinleyiciyi çıkarır. */
	private void dinleyiciÇıkarmaİşlemi(final Object nesne) {
		for (final Map<Öncelik, Set<DinleyiciBilgisi>> sınıfHaritası : this.dinleyiciler.values()) {
			for (final Öncelik öncelik : Öncelik.values()) {
				final Iterator<DinleyiciBilgisi> yineleyici = sınıfHaritası.get(öncelik).iterator();
				while (yineleyici.hasNext()) {
					if (yineleyici.next().nesne == nesne) {
						yineleyici.remove();
					}
				}
			}
		}
	}
}
