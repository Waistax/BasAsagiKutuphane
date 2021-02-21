/**
 * başaşağıderebeyi.kütüphane.olay.EtkisizOlayDağıtıcısı.java
 * 0.7 / 19 Oca 2021 / 12:31:34
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.kütüphane.olay;

/** Olayları ve dinleyicileri yok sayar. */
public class EtkisizOlayDağıtıcısı implements OlayDağıtıcısı {
	@Override
	public void dinleyiciÇıkar(final Object nesne) {
	}
	
	@Override
	public void dinleyiciEkle(final Object nesne) {
	}
	
	@Override
	public void güncelle() {
	}
	
	@Override
	public void olayEkle(final Olay olay) {
	}
}
