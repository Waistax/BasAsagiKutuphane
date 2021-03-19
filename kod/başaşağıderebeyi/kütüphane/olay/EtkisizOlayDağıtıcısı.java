/**
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 * 0.7 / 19 Oca 2021 / 12:31:34
 */
package başaşağıderebeyi.kütüphane.olay;

/** Olayları ve dinleyicileri yok sayar. */
public class EtkisizOlayDağıtıcısı extends OlayDağıtıcısı {
	@Override
	public void dağıt(final Olay olay) {
	}
	
	@Override
	public <T extends Olay> void dinleyiciyiEkle(
		DinleyiciBilgisi<T> dinleyiciBilgisi) {
	}
	
	@Override
	public <T extends Olay> void dinleyiciyiÇıkar(
		DinleyiciBilgisi<T> dinleyiciBilgisi) {
	}
}
