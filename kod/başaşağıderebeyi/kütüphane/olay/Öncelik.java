/**
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 * 0.6 / 19 Oca 2021 / 07:54:04
 *
 * BaşAşağıMotor'dan alındı.
 * 0.28 / 9 Kas 2020 / 15:37:05
 */
package başaşağıderebeyi.kütüphane.olay;

/** Dinleyici önceliği sıralaması. */
public enum Öncelik {
		/** Olayları birinci olarak dinleyenlerin önceliği. */
		ÇOK_ÖNCE,
		/** Olayları ikinci olarak dinleyenlerin önceliği. */
		ÖNCE,
		/** Olayları üçüncü olarak dinleyenlerin önceliği. Öncelik belirtmemiş
		 * bütün dinleyicilerin varsayılan olarak sahip olduğu önceliktir. */
		VARSAYILAN,
		/** Olayları dördüncü olarak dinleyenlerin önceliği. */
		SONRA,
		/** Olayları beşinci olarak ve en son dinleyenlerin önceliği. */
		ÇOK_SONRA;
}
