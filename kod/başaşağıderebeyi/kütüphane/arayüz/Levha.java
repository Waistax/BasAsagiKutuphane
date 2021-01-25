/**
 * başaşağıderebeyi.kütüphane.arayüz.Levha.java
 * 0.7 / 19 Oca 2021 / 12:50:09
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.kütüphane.arayüz;

import java.util.*;

public class Levha extends Öğe {
	public final List<Öğe> içerik;
	
	public Levha(final Levha levha) {
		super(levha);
		this.içerik = new ArrayList<>();
	}
}
