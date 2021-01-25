/**
 * başaşağıderebeyi.kütüphane.arayüz.Ekran.java
 * 0.7 / 19 Oca 2021 / 12:49:54
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.kütüphane.arayüz;

import başaşağıderebeyi.kütüphane.girdi.*;

public class Ekran extends Levha {
	public final ÇiğGirdi girdi;
	
	public Ekran(final Levha levha, final ÇiğGirdi girdi) {
		super(levha);
		this.girdi = girdi;
	}
}
