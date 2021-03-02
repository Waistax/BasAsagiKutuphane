/**
 * başaşağıderebeyi.kütüphane.yürütücü.BoşYürütücü.java
 * 0.8 / 17 Şub 2021 / 11:06:55
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.kütüphane.yürütücü;

/** Olmayan yürütücü. */
@Deprecated
public class BoşYürütücü implements Yürütücü {
	@Override
	public int işlemSayısı() {
		// Çağıran işlem.
		return 1;
	}
	
	@Override
	public void yürüt(final Runnable yürütme) {
		// Çağıran işlemin üzerinde yürüt.
		yürütme.run();
	}
}
