/**
 * başaşağıderebeyi.kütüphane.yürütücü.Takım.java
 * 0.8 / 21 Şub 2021 / 12:24:06
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.kütüphane.yürütücü;

import java.util.*;

/** Bir takım nesneyi ard arda yürütür. */
public class Takım<T> implements Runnable {
	/** Takıma nesneleri dağıtan. */
	private final Dağıtıcı<T> dağıtıcı;
	/** Yürütülecek nesneler. */
	protected final Set<T> nesneler;
	/** En son yürütülen nesneyi işaret eden yineleyici. */
	protected Iterator<T> yineleyici;
	
	/** Boş tanımlar. */
	public Takım(Dağıtıcı<T> dağıtıcı) {
		this.dağıtıcı = dağıtıcı;
		nesneler = new HashSet<>();
	}
	
	@Override
	public void run() {
		// Bütün nesneleri yürüt.
		yineleyici = nesneler.iterator();
		while (yineleyici.hasNext())
			dağıtıcı.yürüt(yineleyici.next());
	}
}
