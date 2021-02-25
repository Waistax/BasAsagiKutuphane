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
	/** Sonraki güncellemeyi bekleyen işlemler. */
	private final List<Runnable> bekleyenİşlemler;
	/** Kayıtlı dinleyicilerin bilgileri. */
	private final Map<
		Class<? extends Olay>,
		Map<Öncelik, Set<DinleyiciBilgisi>>> dinleyiciler;
	/** İşlenmekte olan olaylar. */
	private final List<Olay> işlenenOlaylar;
	
	/** Boş dağıtıcı tanımlar. */
	public OlayYöneticisi() {
		dinleyiciler = new HashMap<>();
		işlenenOlaylar = new ArrayList<>();
		bekleyenİşlemler = new ArrayList<>();
	}
	
	@SuppressWarnings("unchecked")
	private Class<? extends Olay> dinlediğiSınıfıBul(final Method yöntem) {
		final Class<?> sınıf = yöntem.getParameterTypes()[0];
		return sınıf.isInstance(Olay.class) ?
			(Class<? extends Olay>)sınıf :
			null;
	}
	
	private boolean dinleyenYöntemMi(final Method yöntem) {
		return yöntem.isAnnotationPresent(Dinleyici.class) &&
			yöntem.getParameterTypes().length == 1;
	}
	
	/** Dinleyiciyi çıkarır. */
	private void dinleyiciÇıkarmaİşlemi(final Object nesne) {
		// Bütün olay sınıflarını ve öncelikleri tara.
		for (final Map<
			Öncelik,
			Set<DinleyiciBilgisi>> sınıfHaritası : dinleyiciler.values())
			for (final Öncelik öncelik : Öncelik.values()) {
				final Iterator<DinleyiciBilgisi> yineleyici = sınıfHaritası
					.get(öncelik)
					.iterator();
				while (yineleyici.hasNext())
					if (yineleyici.next().nesne == nesne)
						yineleyici.remove();
			}
	}
	
	/** Dinleyiciyi ekler. */
	private void dinleyiciEklemeİşlemi(final Object nesne) {
		for (final Method yöntem : nesne.getClass().getMethods()) {
			if (!dinleyenYöntemMi(yöntem))
				continue;
			
			final Class<? extends Olay> sınıf = dinlediğiSınıfıBul(yöntem);
			if (sınıf == null)
				continue;
			
			final Dinleyici dinleyici = yöntem.getAnnotation(Dinleyici.class);
			sınıfHaritasınıAl(sınıf)
				.get(dinleyici.öncelik())
				.add(
					new DinleyiciBilgisi(
						nesne,
						yöntem,
						dinleyici.kaldırılmışlarıDinler()));
		}
	}
	
	/** Olayı işler. */
	private void olayıİşle(final Olay olay) {
		final Map<Öncelik, Set<DinleyiciBilgisi>> sınıfHaritası = dinleyiciler
			.get(olay.getClass());
		
		// Eklenmiş bir dinleyici yoksa atla.
		if (sınıfHaritası == null)
			return;
		
		for (final Öncelik öncelik : Öncelik.values()) {
			final Set<
				DinleyiciBilgisi> öncelikKümesi = sınıfHaritası.get(öncelik);
			final Iterator<
				DinleyiciBilgisi> yineleyici = öncelikKümesi.iterator();
			
			while (yineleyici.hasNext()) {
				final DinleyiciBilgisi bilgi = yineleyici.next();
				
				// Kaldırılmadıysa dinleyen yöntemi çağır.
				if (bilgi.kaldırılmışlarıDinler || !olay.kaldırılmış)
					try {
						bilgi.yöntem.invoke(bilgi.nesne, olay);
					} catch (final Exception e) {
						new Exception("Olay işlenirken bir hata oluştu!", e)
							.printStackTrace();
					}
			}
		}
	}
	
	private Map<Öncelik, Set<DinleyiciBilgisi>> sınıfHaritasınıAl(
		final Class<? extends Olay> sınıf) {
		Map<
			Öncelik,
			Set<DinleyiciBilgisi>> sınıfHaritası = dinleyiciler.get(sınıf);
		
		// Olay sınıfı için harita yoksa yeni bir tane oluştur.
		if (sınıfHaritası == null) {
			sınıfHaritası = new HashMap<>();
			for (final Öncelik öncelik : Öncelik.values())
				sınıfHaritası.put(öncelik, new HashSet<>());
			dinleyiciler.put(sınıf, sınıfHaritası);
		}
		
		return sınıfHaritası;
	}
	
	@Override
	public void dinleyiciÇıkar(final Object nesne) {
		synchronized (bekleyenİşlemler) {
			bekleyenİşlemler.add(() -> dinleyiciÇıkarmaİşlemi(nesne));
		}
	}
	
	@Override
	public void dinleyiciEkle(final Object nesne) {
		synchronized (bekleyenİşlemler) {
			bekleyenİşlemler.add(() -> dinleyiciEklemeİşlemi(nesne));
		}
	}
	
	@Override
	public void güncelle() {
		synchronized (bekleyenİşlemler) {
			bekleyenİşlemler.forEach(Runnable::run);
			bekleyenİşlemler.clear();
		}
		işlenenOlaylar.forEach(this::olayıİşle);
		işlenenOlaylar.clear();
	}
	
	@Override
	public void olayEkle(final Olay olay) {
		synchronized (bekleyenİşlemler) {
			bekleyenİşlemler.add(() -> işlenenOlaylar.add(olay));
		}
	}
}
