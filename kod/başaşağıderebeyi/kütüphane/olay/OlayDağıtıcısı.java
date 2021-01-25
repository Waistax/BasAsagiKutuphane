/**
 * başaşağıderebeyi.kütüphane.olay.OlayDağıtıcısı.java
 * 0.7 / 19 Oca 2021 / 12:28:25
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.kütüphane.olay;

/** Olayları dinleyicilere dağıtır. */
public interface OlayDağıtıcısı {
	/** Olayı sıraya ekler. */
	void olayEkle(Olay olay);
	
	/** Dinleyiciyi ekleme sırasına koyar. */
	void dinleyiciEkle(Object nesne);
	
	/** Dinleyiciyi çıkarma sırasına koyar. */
	void dinleyiciÇıkar(Object nesne);
	
	/** Dinleyicileri günceller, olayları işler. */
	void güncelle();
}
