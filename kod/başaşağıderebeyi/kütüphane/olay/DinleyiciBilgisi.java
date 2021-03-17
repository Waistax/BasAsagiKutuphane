/**
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 * 0.6 / 19 Oca 2021 / 07:56:58
 *
 * BaşAşağıMotor'dan alındı.
 * 0.28 / 11 Kas 2020 / 21:35:37
 */
package başaşağıderebeyi.kütüphane.olay;

import java.lang.invoke.*;
import java.lang.reflect.*;

/** Dinleyicinin yöneticideki bilgileri. */
class DinleyiciBilgisi {
	final Object nesnesi;
	final MethodHandle çağırıcısı;
	final boolean susturulmuşlarıDinlemesi;
	
	DinleyiciBilgisi(
		final Object nesne,
		final Method yöntem,
		final boolean susturulmuşlarıDinlemesi)
		throws IllegalAccessException {
		nesnesi = nesne;
		çağırıcısı = MethodHandles.lookup().unreflect(yöntem).bindTo(nesne);
		this.susturulmuşlarıDinlemesi = susturulmuşlarıDinlemesi;
	}
}
