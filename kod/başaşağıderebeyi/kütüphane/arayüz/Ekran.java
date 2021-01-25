/**
 * başaşağıderebeyi.kütüphane.arayüz.Ekran.java
 * 0.7 / 19 Oca 2021 / 12:49:54
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.kütüphane.arayüz;

import başaşağıderebeyi.kütüphane.girdi.*;

/** Arayüzün içinde bulunduğu ekran. */
public class Ekran extends Levha {
	public static final int SOL_TIK = 1;
	
	final ÇiğGirdi girdi;
	public final float genişlik;
	public final float yükseklik;
	public final Tuş solTık;
	
	public Ekran(final Levha levha, final ÇiğGirdi girdi, float genişlik, float yükseklik) {
		super(levha);
		this.girdi = girdi;
		this.genişlik = genişlik;
		this.yükseklik = yükseklik;
		this.solTık = girdi.fareTuşuAl(SOL_TIK);
	}
}
