/**
 * başaşağıderebeyi.kütüphane.matematik.Dikdörtgen.java
 * 0.4 / 17 Oca 2021 / 12:08:18
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 *
 * BaşAşağıMotor'dan alındı.
 * 0.13 / 8 Eyl 2020 / 09:37:00
 */
package başaşağıderebeyi.kütüphane.matematik;

/** İki boyutlu bir dikdörtgen. Bileşenler ondalıklı sayılar olarak saklanır. */
public class Dikdörtgen {
	/** Konumunun değerleri büyük olan köşe. */
	public final Yöney2 b;
	/** Konumunun değerleri küçük olan köşe. */
	public final Yöney2 k;
	/** Orta noktası. */
	public final Yöney2 o;
	/** Kenarların uzunluklarını içeren yöney. */
	public final Yöney2 u;
	
	/** Sıfır dikdörtgeni tanımlar. */
	public Dikdörtgen() {
		k = new Yöney2();
		b = new Yöney2();
		o = new Yöney2();
		u = new Yöney2();
	}
	
	/** Verilen dikdörtgenlerin aradeğerini buna yazar. Bu dikdörtgeni döndürür.
	 * Mesafelerin toplamının bir olduğunu varsayar. */
	public Dikdörtgen aradeğer(
		final Dikdörtgen sol,
		final Dikdörtgen sağ,
		final float solaUzaklık,
		final float sağaUzaklık) {
		k.aradeğerleriniBul(sol.k, sağ.k, solaUzaklık, sağaUzaklık);
		b.aradeğerleriniBul(sol.b, sağ.b, solaUzaklık, sağaUzaklık);
		o.aradeğerleriniBul(sol.o, sağ.o, solaUzaklık, sağaUzaklık);
		u.aradeğerleriniBul(sol.u, sağ.u, solaUzaklık, sağaUzaklık);
		return this;
	}
	
	/** Verilen dikdörtgenle bu yöneyin aradeğerini buna yazar. Bu dikdörtgeni
	 * döndürür. Mesafelerin toplamının bir olduğunu varsayar. */
	public Dikdörtgen aradeğer(
		final Dikdörtgen ö,
		final float uzaklık,
		final float yakınlık) {
		return this.aradeğer(this, ö, uzaklık, yakınlık);
	}
	
	/** Dikdörtgeni dizeye çevirir. */
	public String dize() {
		return this.dize(new StringBuilder()).toString();
	}
	
	/** Dikdörtgeni dizeye ekler. */
	public StringBuilder dize(final StringBuilder dize) {
		return dize
			.append('[')
			.append(k)
			.append(", ")
			.append(b)
			.append(", ")
			.append(o)
			.append(", ")
			.append(u)
			.append(']');
	}
	
	@Override
	public boolean equals(final Object obj) {
		if (obj instanceof Dikdörtgen ö)
			return eşittir(ö);
		return false;
	}
	
	/** Verilen dikdörtgenin bu dikdörtgene eşit olup olmadığını hesaplar. */
	public boolean eşittir(final Dikdörtgen ö) {
		return k.eşitOlmalarınıBul(ö.k) &&
			b.eşitOlmalarınıBul(ö.b) &&
			o.eşitOlmalarınıBul(ö.o) &&
			u.eşitOlmalarınıBul(ö.u);
	}
	
	/** Yöneyin dikdörtgenin içinde olup olmadığını hesaplar. */
	public boolean içinde(final Yöney2 ö) {
		return k.birinciBileşeni <= ö.birinciBileşeni &&
			k.ikinciBileşeni <= ö.ikinciBileşeni &&
			b.birinciBileşeni >= ö.birinciBileşeni &&
			b.ikinciBileşeni >= ö.ikinciBileşeni;
	}
	
	/** Dikdörtgenin verilerini ayrı ayrı aşağı yuvarlar. Dikdörtgeni
	 * döndürür. */
	public Dikdörtgen taban() {
		return this.taban(this);
	}
	
	/** Verilen dikdörtgenin verilerini ayrı ayrı aşağı yuvarlayıp buna yazar.
	 * Bu dikdörtgeni döndürür. */
	public Dikdörtgen taban(final Dikdörtgen ö) {
		k.aşağıYuvarla(ö.k);
		b.aşağıYuvarla(ö.b);
		o.aşağıYuvarla(ö.o);
		u.aşağıYuvarla(ö.u);
		return this;
	}
	
	/** Dikdörtgenin verilerini ayrı ayrı yukarı yuvarlar. Dikdörtgeni
	 * döndürür. */
	public Dikdörtgen tavan() {
		return this.tavan(this);
	}
	
	/** Verilen dikdörtgenin verilerini ayrı ayrı yukarı yuvarlayıp buna yazar.
	 * Bu dikdörtgeni döndürür. */
	public Dikdörtgen tavan(final Dikdörtgen ö) {
		k.yukarıYuvarla(ö.k);
		b.yukarıYuvarla(ö.b);
		o.yukarıYuvarla(ö.o);
		u.yukarıYuvarla(ö.u);
		return this;
	}
	
	@Override
	public String toString() {
		return this.dize();
	}
	
	/** Verilen dikdörtgeni buna yazar. Bu dikdörtgeni döndürür. */
	public Dikdörtgen yaz(final Dikdörtgen ö) {
		return yazK(ö.k).yazB(ö.b).yazO(ö.o).yazU(ö.u);
	}
	
	/** Büyük olan köşeyi değiştirir. Dikdörtgeni döndürür. */
	public Dikdörtgen yazB(final Yöney2 b) {
		this.b.değiştir(b);
		return this;
	}
	
	/** Küçük olan köşeyi değiştirir. Dikdörtgeni döndürür. */
	public Dikdörtgen yazK(final Yöney2 k) {
		this.k.değiştir(k);
		return this;
	}
	
	/** Orta noktayı değiştirir. Dikdörtgeni döndürür. */
	public Dikdörtgen yazO(final Yöney2 o) {
		this.o.değiştir(o);
		return this;
	}
	
	/** Uzunluğu değiştirir. Dikdörtgeni döndürür. */
	public Dikdörtgen yazU(final Yöney2 u) {
		this.u.değiştir(u);
		return this;
	}
	
	/** Dikdörtgenin verilerini ayrı ayrı yuvarlar. Dikdörtgeni döndürür. */
	public Dikdörtgen yuvarla() {
		return this.yuvarla(this);
	}
	
	/** Verilen dikdörtgenin verilerini ayrı ayrı yuvarlayıp buna yazar. Bu
	 * dikdörtgeni döndürür. */
	public Dikdörtgen yuvarla(final Dikdörtgen ö) {
		k.yuvarla(ö.k);
		b.yuvarla(ö.b);
		o.yuvarla(ö.o);
		u.yuvarla(ö.u);
		return this;
	}
}
