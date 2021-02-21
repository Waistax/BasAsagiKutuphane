/**
 * başaşağıderebeyi.kütüphane.yürütücü.Yürütme.java
 * 0.8 / 17 Şub 2021 / 12:36:25
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.kütüphane.yürütücü;

/** Belirli bir türün yürütülme şekli. */
public interface Yürütme<T> {
	/** Nesneyi yürütür. */
	void yürüt(T nesne);
}
