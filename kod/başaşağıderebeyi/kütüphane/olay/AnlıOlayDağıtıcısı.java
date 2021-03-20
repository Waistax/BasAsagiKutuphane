/**
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 * 0.6 / 19 Oca 2021 / 08:08:05
 *
 * BaşAşağıMotor'dan biraz alındı.
 * 0.28 / 9 Kas 2020 / 15:27:51
 *
 * Waistax Engine'den biraz alındı.
 * 1.1.? / ? Ağu 2016 / ?
 */
package başaşağıderebeyi.kütüphane.olay;

import java.util.*;

/** Verilen olayları ve dinleyicileri bekleme sırasına alır. Her an
 * güncellendiğinde sıradaki olayları dağıtır. */
public class AnlıOlayDağıtıcısı extends OlayDağıtıcısı {
	private final List<Runnable> bekleyenİşlemler;
	private final List<Runnable> yapılacakİşlemler;
	
	/** Boş dağıtıcı tanımlar. */
	public AnlıOlayDağıtıcısı() {
		bekleyenİşlemler = new ArrayList<>();
		yapılacakİşlemler = new ArrayList<>();
	}
	
	/** Bu anın olaylarını dağıtır ve dinleyicilerini ekler veya çıkarır. */
	public void güncelle() {
		synchronized (bekleyenİşlemler) {
			yapılacakİşlemler.addAll(bekleyenİşlemler);
			bekleyenİşlemler.clear();
		}
		yapılacakİşlemler.forEach(Runnable::run);
		yapılacakİşlemler.clear();
	}
	
	@Override
	public void dağıt(final Olay olay) {
		synchronized (bekleyenİşlemler) {
			bekleyenİşlemler.add(() -> super.dağıt(olay));
		}
	}
	
	@Override
	public <T extends Olay> void dinleyiciyiEkle(
		final DinleyiciBilgisi<T> dinleyiciBilgisi) {
		synchronized (bekleyenİşlemler) {
			bekleyenİşlemler.add(() -> super.dinleyiciyiEkle(dinleyiciBilgisi));
		}
	}
	
	@Override
	public <T extends Olay> void dinleyiciyiÇıkar(
		final DinleyiciBilgisi<T> dinleyiciBilgisi) {
		synchronized (bekleyenİşlemler) {
			bekleyenİşlemler
				.add(() -> super.dinleyiciyiÇıkar(dinleyiciBilgisi));
		}
	}
}
