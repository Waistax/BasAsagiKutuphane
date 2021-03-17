/**
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 * 0.8 / 17 Şub 2021 / 11:00:29
 */
package başaşağıderebeyi.kütüphane.yürütücü;

/** Genel bir yürütücü sağlar. */
@Deprecated
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
	
	/** Bu sınıfın bir nesnesini tanımlamayı engeller. */
	private YürütücüSağlayıcısı() {
	}
}
