/**
 * başaşağıderebeyi.kütüphane.yürütücü.YürütücüSağlayıcısı.java
 * 0.8 / 17 Şub 2021 / 11:00:29
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.kütüphane.yürütücü;

/** Genel bir yürütücü sağlar. */
public class YürütücüSağlayıcısı {
	/** Genel yürütücü. */
	private static Yürütücü yürütücü = new BoşYürütücü();
	
	/** Verilen yürütücüyü genel yürütücü olarak ayarlar. */
	public static void değiştir(final Yürütücü yürütücü) {
		YürütücüSağlayıcısı.yürütücü = yürütücü;
	}
	
	/** Genel yürütücüyü döndürür. */
	public static Yürütücü sağla() {
		return YürütücüSağlayıcısı.yürütücü;
	}
}
