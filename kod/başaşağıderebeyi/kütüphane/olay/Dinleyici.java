/**
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 * 0.6 / 19 Oca 2021 / 07:53:21
 *
 * BaşAşağıMotor'dan alındı.
 * 0.28 / 9 Kas 2020 / 15:35:12
 */
package başaşağıderebeyi.kütüphane.olay;

import java.lang.annotation.*;

/** Yöntemi dinleyici yöntem olarak belirleyen arayüz. */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Dinleyici {
	/** Susturulmuş olayları dinleyip dinlemediği. */
	boolean susturulmuşlarıDinlemesi() default false;
	
	/** Dinleyicinin öncelik sırası. */
	Öncelik önceliği() default Öncelik.VARSAYILAN;
}
