/**
 * başaşağıderebeyi.kütüphane.olay.OlayDağıtıcısı.java
 * 0.7 / 19 Oca 2021 / 12:28:25
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

/** Olayları dinleyicilere dağıtır. */
public class OlayDağıtıcısı {
	private final Map<
		Class<? extends Olay>,
		Set<DinleyiciBilgisi>[]> dinleyicilerininBilgileri;
	
	/** Boş dağıtıcı tanımlar. */
	public OlayDağıtıcısı() {
		dinleyicilerininBilgileri = new HashMap<>();
	}
	
	/** Verilen olayı dağıtır. */
	public void dağıt(final Olay olay) {
		final Set<DinleyiciBilgisi>[] sınıfDizisi =
			dinleyicilerininBilgileri.get(olay.getClass());
		if (sınıfDizisi == null)
			return;
		
		for (final Öncelik öncelik : Öncelik.values()) {
			final Set<DinleyiciBilgisi> öncelikKümesi =
				sınıfDizisi[öncelik.ordinal()];
			
			for (final DinleyiciBilgisi bilgi : öncelikKümesi)
				// Susturulmadıysa dinleyen yöntemi çağır.
				if (bilgi.susturulmuşlarıDinlemesi || !olay.susturulması)
					try {
						bilgi.çağırıcısı.invoke(olay);
					} catch (final Throwable hata) {
						new Exception("Olay işlenirken bir hata oluştu!", hata)
							.printStackTrace();
					}
		}
	}
	
	/** Verilen nesnenin bütün dinleyicilerini ekler. */
	public void dinleyicileriniEkle(final Object nesne) {
		for (final Method yöntem : nesne.getClass().getMethods()) {
			final Class<? extends Olay> dinlediğiSınıf =
				dinlediğiSınıfıBul(yöntem);
			if (dinlediğiSınıf == null)
				continue;
			
			final Dinleyici dinleyici = yöntem.getAnnotation(Dinleyici.class);
			try {
				sınıfDizisiniEdin(
					dinlediğiSınıf)[dinleyici.önceliği().ordinal()]
						.add(
							new DinleyiciBilgisi(
								nesne,
								yöntem,
								dinleyici.susturulmuşlarıDinlemesi()));
			} catch (final IllegalAccessException hata) {
				new Exception(
					"Dinleyici yöntem işlenirken bir hata oluştu! Yöntem: " +
						yöntem,
					hata).printStackTrace();
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	private Class<? extends Olay> dinlediğiSınıfıBul(final Method yöntem) {
		if (!yöntem.isAnnotationPresent(Dinleyici.class))
			return null;
		
		final Class<?>[] etkenleri = yöntem.getParameterTypes();
		
		if (etkenleri.length != 1)
			return null;
		
		return (Class<? extends Olay>)etkenleri[0];
	}
	
	@SuppressWarnings("unchecked")
	private Set<DinleyiciBilgisi>[] sınıfDizisiniEdin(
		final Class<? extends Olay> sınıf) {
		Set<DinleyiciBilgisi>[] sınıfDizisi =
			dinleyicilerininBilgileri.get(sınıf);
		
		if (sınıfDizisi == null) {
			sınıfDizisi =
				(Set<DinleyiciBilgisi>[])new Set<?>[Öncelik.values().length];
			for (int i = 0; i < sınıfDizisi.length; i++)
				sınıfDizisi[i] = new HashSet<>();
			dinleyicilerininBilgileri.put(sınıf, sınıfDizisi);
		}
		
		return sınıfDizisi;
	}
	
	/** Verilen nesnenin bütün dinleyicilerini çıkarır. */
	public void dinleyicileriniÇıkar(final Object nesne) {
		for (final Set<
			DinleyiciBilgisi>[] sınıfDizisi : dinleyicilerininBilgileri
				.values())
			for (final Set<DinleyiciBilgisi> öncelikKümesi : sınıfDizisi) {
				final Iterator<DinleyiciBilgisi> yineleyici =
					öncelikKümesi.iterator();
				while (yineleyici.hasNext())
					if (yineleyici.next().nesnesi == nesne)
						yineleyici.remove();
			}
	}
}
