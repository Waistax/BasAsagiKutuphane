/**
 * başaşağıderebeyi.kütüphane.olay.OlayDağıtıcısı.java
 * 0.7 / 19 Oca 2021 / 12:28:25
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.kütüphane.olay;

/** Olayları dinleyicilere dağıtır. */
public interface OlayDağıtıcısı {
	/** Dinleyiciyi çıkarma sırasına koyar. */
	void dinleyiciÇıkar(Object nesne);
	
	/** Dinleyiciyi ekleme sırasına koyar. */
	void dinleyiciEkle(Object nesne);
	
	/** Dinleyicileri günceller, olayları işler. */
	void güncelle();
	
	/** Olayı sıraya ekler. */
	void olayEkle(Olay olay);
}
