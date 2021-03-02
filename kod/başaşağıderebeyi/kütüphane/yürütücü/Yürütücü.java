/**
 * başaşağıderebeyi.kütüphane.yürütücü.Yürütücü.java
 * 0.8 / 17 Şub 2021 / 11:02:33
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.kütüphane.yürütücü;

/** Bir ya da daha fazla işlem ile aynı anda yürütür. */
@Deprecated
public interface Yürütücü {
	/** Sahip olduğu işlem sayısını döndürür. */
	int işlemSayısı();
	
	/** Yürütür. */
	void yürüt(Runnable yürütme);
}
