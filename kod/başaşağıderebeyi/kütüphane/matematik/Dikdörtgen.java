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
	/** Konumunun değerleri küçük olan köşe. */
	public final Yöney2 k;
	/** Konumunun değerleri büyük olan köşe. */
	public final Yöney2 b;
	/** Orta noktası. */
	public final Yöney2 o;
	/** Kenarların uzunluklarını içeren yöney. */
	public final Yöney2 u;
	
	/** Sıfır dikdörtgeni tanımlar. */
	public Dikdörtgen() {
		this.k = new Yöney2();
		this.b = new Yöney2();
		this.o = new Yöney2();
		this.u = new Yöney2();
	}
	
	/** Küçük olan köşeyi değiştirir. Dikdörtgeni döndürür. */
	public Dikdörtgen yazK(final Yöney2 k) {
		this.k.yaz(k);
		return this;
	}
	
	/** Büyük olan köşeyi değiştirir. Dikdörtgeni döndürür. */
	public Dikdörtgen yazB(final Yöney2 b) {
		this.b.yaz(b);
		return this;
	}
	
	/** Orta noktayı değiştirir. Dikdörtgeni döndürür. */
	public Dikdörtgen yazO(final Yöney2 o) {
		this.o.yaz(o);
		return this;
	}
	
	/** Uzunluğu değiştirir. Dikdörtgeni döndürür. */
	public Dikdörtgen yazU(final Yöney2 u) {
		this.u.yaz(u);
		return this;
	}
	
	/** Verilen dikdörtgeni buna yazar. Bu dikdörtgeni döndürür. */
	public Dikdörtgen yaz(final Dikdörtgen ö) {
		return this.yazK(ö.k).yazB(ö.b).yazO(ö.o).yazU(ö.u);
	}
	
	/** Verilen dikdörtgenin verilerini ayrı ayrı yuvarlayıp buna yazar. Bu
	 * dikdörtgeni döndürür. */
	public Dikdörtgen yuvarla(final Dikdörtgen ö) {
		this.k.yuvarla(ö.k);
		this.b.yuvarla(ö.b);
		this.o.yuvarla(ö.o);
		this.u.yuvarla(ö.u);
		return this;
	}
	
	/** Dikdörtgenin verilerini ayrı ayrı yuvarlar. Dikdörtgeni döndürür. */
	public Dikdörtgen yuvarla() {
		return this.yuvarla(this);
	}
	
	/** Verilen dikdörtgenin verilerini ayrı ayrı yukarı yuvarlayıp buna yazar. Bu
	 * dikdörtgeni döndürür. */
	public Dikdörtgen tavan(final Dikdörtgen ö) {
		this.k.tavan(ö.k);
		this.b.tavan(ö.b);
		this.o.tavan(ö.o);
		this.u.tavan(ö.u);
		return this;
	}
	
	/** Dikdörtgenin verilerini ayrı ayrı yukarı yuvarlar. Dikdörtgeni döndürür. */
	public Dikdörtgen tavan() {
		return this.tavan(this);
	}
	
	/** Verilen dikdörtgenin verilerini ayrı ayrı aşağı yuvarlayıp buna yazar. Bu
	 * dikdörtgeni döndürür. */
	public Dikdörtgen taban(final Dikdörtgen ö) {
		this.k.taban(ö.k);
		this.b.taban(ö.b);
		this.o.taban(ö.o);
		this.u.taban(ö.u);
		return this;
	}
	
	/** Dikdörtgenin verilerini ayrı ayrı aşağı yuvarlar. Dikdörtgeni döndürür. */
	public Dikdörtgen taban() {
		return this.taban(this);
	}
	
	/** Verilen dikdörtgenlerin aradeğerini buna yazar. Bu dikdörtgeni döndürür.
	 * Mesafelerin toplamının bir olduğunu varsayar. */
	public Dikdörtgen aradeğer(final Dikdörtgen sol, final Dikdörtgen sağ, final float solaUzaklık,
			final float sağaUzaklık) {
		this.k.aradeğer(sol.k, sağ.k, solaUzaklık, sağaUzaklık);
		this.b.aradeğer(sol.b, sağ.b, solaUzaklık, sağaUzaklık);
		this.o.aradeğer(sol.o, sağ.o, solaUzaklık, sağaUzaklık);
		this.u.aradeğer(sol.u, sağ.u, solaUzaklık, sağaUzaklık);
		return this;
	}
	
	/** Verilen dikdörtgenle bu yöneyin aradeğerini buna yazar. Bu dikdörtgeni
	 * döndürür. Mesafelerin toplamının bir olduğunu varsayar. */
	public Dikdörtgen aradeğer(final Dikdörtgen ö, final float uzaklık, final float yakınlık) {
		return this.aradeğer(this, ö, uzaklık, yakınlık);
	}
	
	/** Verilen dikdörtgenin bu dikdörtgene eşit olup olmadığını hesaplar. */
	public boolean eşittir(final Dikdörtgen ö) {
		return this.k.eşittir(ö.k) && this.b.eşittir(ö.b) && this.o.eşittir(ö.o) && this.u.eşittir(ö.u);
	}
	
	/** Yöneyin dikdörtgenin içinde olup olmadığını hesaplar. */
	public boolean içinde(final Yöney2 ö) {
		return this.k.x <= ö.x && this.k.y <= ö.y && this.b.x >= ö.x && this.b.y >= ö.y;
	}
	
	/** Dikdörtgeni dizeye ekler. */
	public StringBuilder dize(final StringBuilder dize) {
		return dize.append('[').append(this.k).append(", ").append(this.b).append(", ").append(this.o).append(", ")
				.append(this.u).append(']');
	}
	
	/** Dikdörtgeni dizeye çevirir. */
	public String dize() {
		return this.dize(new StringBuilder()).toString();
	}
	
	@Override
	public boolean equals(final Object obj) {
		return this.eşittir((Dikdörtgen)obj);
	}
	
	@Override
	public String toString() {
		return this.dize();
	}
}
