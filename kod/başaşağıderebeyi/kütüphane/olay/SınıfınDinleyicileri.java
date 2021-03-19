/**
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 * 1.0.1 / 19 Mar 2021 / 23:12:00
 */
package başaşağıderebeyi.kütüphane.olay;

import java.util.*;

class SınıfınDinleyicileri<T extends Olay> {
	private final List<Set<DinleyiciBilgisi<T>>> öncelikKümeleri;
	
	SınıfınDinleyicileri() {
		öncelikKümeleri = new ArrayList<>(Öncelik.values().length);
		
		for (int i = 0; i < Öncelik.values().length; i++)
			öncelikKümeleri.add(new HashSet<>(1));
	}
	
	void dağıt(T olay) {
		for (Öncelik öncelik : Öncelik.values())
			for (DinleyiciBilgisi<T> dinleyiciBilgisi : öncelikKümeleri
				.get(öncelik.ordinal()))
				if (dinleyiciBilgisi.susturulmuşlarıDinlemesi ||
					!olay.susturulması)
					dinleyiciBilgisi.dinleyicisi.accept(olay);
	}
	
	void ekle(DinleyiciBilgisi<T> dinleyiciBilgisi) {
		öncelikKümeleri
			.get(dinleyiciBilgisi.önceliği.ordinal())
			.add(dinleyiciBilgisi);
	}
	
	void çıkar(DinleyiciBilgisi<T> dinleyiciBilgisi) {
		öncelikKümeleri
			.get(dinleyiciBilgisi.önceliği.ordinal())
			.remove(dinleyiciBilgisi);
	}
}
