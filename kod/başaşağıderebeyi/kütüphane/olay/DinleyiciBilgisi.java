/**
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 * 0.6 / 19 Oca 2021 / 07:56:58
 * 
 * BaşAşağıMotor'dan biraz alındı.
 * 0.28 / 9 Kas 2020 / 15:35:12
 */
package başaşağıderebeyi.kütüphane.olay;

import java.util.function.*;

/** Dinleyicinin yöneticideki bilgileri. */
public class DinleyiciBilgisi<T extends Olay> {
	final Class<T> dinlediğiOlay;
	final Consumer<T> dinleyicisi;
	boolean susturulmuşlarıDinlemesi;
	Öncelik önceliği;
	
	/** Verilen dinleyiciyle tanımlar. */
	public DinleyiciBilgisi(
		final Class<T> dinlediğiOlay,
		final Consumer<T> dinleyicisi) {
		this.dinlediğiOlay = dinlediğiOlay;
		this.dinleyicisi = dinleyicisi;
		önceliği = Öncelik.VARSAYILAN;
	}
	
	/** Dinleyicinin susturulmuş olayları dinleyip dinlemediğini değiştirir. */
	public DinleyiciBilgisi<T> susturulmuşlarıDinlemesiniDeğiştir(
		final boolean susturulmuşlarıDinlemesi) {
		this.susturulmuşlarıDinlemesi = susturulmuşlarıDinlemesi;
		return this;
	}
	
	/** Dinleyicinin öncelik sırasını değiştirir. */
	public DinleyiciBilgisi<T> önceliğiniDeğiştir(final Öncelik önceliği) {
		this.önceliği = önceliği;
		return this;
	}
}
