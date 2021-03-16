/**
 * başaşağıderebeyi.kütüphane.arayüz.Etiket.java
 * 0.12.2 / 16 Mar 2021 / 17:52:24
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 * 
 * BaşAşağıMotor'dan biraz alındı.
 * 0.16 / 13 Eyl 2020 / 22:06:18
 * 
 * BaşAşağıMotor'dan biraz alındı.
 * 0.19 / 20 Eyl 2020 / 16:02:04
 */
package başaşağıderebeyi.kütüphane.arayüz;

import java.util.*;

/** Etkileşime geçmeyen hareketsiz bir yazı. */
public class Etiket extends Öğe {
	/** Etiketin yazısı. */
	public List<String> satırları;
	
	/** Verilen levhanın içinde tanımlar. */
	public Etiket(final Levha içerenLevha) {
		super(içerenLevha);
		satırları = new ArrayList<>(1);
	}
	
	@Override
	public void güncelle() {
	}
}
