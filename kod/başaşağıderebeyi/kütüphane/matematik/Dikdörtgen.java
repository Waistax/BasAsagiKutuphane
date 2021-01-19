/**
 * başaşağıderebeyi.kütüphane.matematik.Dikdörtgen.java
 * 0.4 / 17 Oca 2021 / 12:08:18
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 * 
 * BaşAşağıMotor'dan alındı.
 * 0.13 / 8 Eyl 2020 / 09:37:00
 */
package başaşağıderebeyi.kütüphane.matematik;

/** İki boyutlu bir dikdörtgen.
 * Bileşenler ondalıklı sayılar olarak saklanır. */
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
		k = new Yöney2();
		b = new Yöney2();
		o = new Yöney2();
		u = new Yöney2();
	}
	
	/** Küçük olan köşeyi değiştirir.
	 * Dikdörtgeni döndürür. */
	public Dikdörtgen yazK(Yöney2 k) {
		this.k.yaz(k);
		return this;
	}
	
	/** Büyük olan köşeyi değiştirir.
	 * Dikdörtgeni döndürür. */
	public Dikdörtgen yazB(Yöney2 b) {
		this.b.yaz(b);
		return this;
	}
	
	/** Orta noktayı değiştirir.
	 * Dikdörtgeni döndürür. */
	public Dikdörtgen yazO(Yöney2 o) {
		this.o.yaz(o);
		return this;
	}
	
	/** Uzunluğu değiştirir.
	 * Dikdörtgeni döndürür. */
	public Dikdörtgen yazU(Yöney2 u) {
		this.u.yaz(u);
		return this;
	}
	
	/** Verilen dikdörtgeni buna yazar.
	 * Bu dikdörtgeni döndürür. */
	public Dikdörtgen yaz(Dikdörtgen ö) {
		return
				yazK(ö.k).
				yazB(ö.b).
				yazO(ö.o).
				yazU(ö.u);
	}
	
	/** Verilen dikdörtgenin verilerini ayrı ayrı yuvarlayıp buna yazar.
	 * Bu dikdörtgeni döndürür. */
	public Dikdörtgen yuvarla(Dikdörtgen ö) {
		k.yuvarla(ö.k);
		b.yuvarla(ö.b);
		o.yuvarla(ö.o);
		u.yuvarla(ö.u);
		return this;
	}
	
	/** Dikdörtgenin verilerini ayrı ayrı yuvarlar.
	 * Dikdörtgeni döndürür. */
	public Dikdörtgen yuvarla() {
		return yuvarla(this);
	}
	
	/** Verilen dikdörtgenin verilerini ayrı ayrı yukarı yuvarlayıp buna yazar.
	 * Bu dikdörtgeni döndürür. */
	public Dikdörtgen tavan(Dikdörtgen ö) {
		k.tavan(ö.k);
		b.tavan(ö.b);
		o.tavan(ö.o);
		u.tavan(ö.u);
		return this;
	}
	
	/** Dikdörtgenin verilerini ayrı ayrı yukarı yuvarlar.
	 * Dikdörtgeni döndürür. */
	public Dikdörtgen tavan() {
		return tavan(this);
	}
	
	/** Verilen dikdörtgenin verilerini ayrı ayrı aşağı yuvarlayıp buna yazar.
	 * Bu dikdörtgeni döndürür. */
	public Dikdörtgen taban(Dikdörtgen ö) {
		k.taban(ö.k);
		b.taban(ö.b);
		o.taban(ö.o);
		u.taban(ö.u);
		return this;
	}
	
	/** Dikdörtgenin verilerini ayrı ayrı aşağı yuvarlar.
	 * Dikdörtgeni döndürür. */
	public Dikdörtgen taban() {
		return taban(this);
	}
	
	/** Verilen dikdörtgenlerin aradeğerini buna yazar.
	 * Bu dikdörtgeni döndürür.
	 * Mesafelerin toplamının bir olduğunu varsayar. */
	public Dikdörtgen aradeğer(Dikdörtgen sol, Dikdörtgen sağ, float solaUzaklık, float sağaUzaklık) {
		k.aradeğer(sol.k, sağ.k, solaUzaklık, sağaUzaklık);
		b.aradeğer(sol.b, sağ.b, solaUzaklık, sağaUzaklık);
		o.aradeğer(sol.o, sağ.o, solaUzaklık, sağaUzaklık);
		u.aradeğer(sol.u, sağ.u, solaUzaklık, sağaUzaklık);
		return this;
	}
	
	/** Verilen dikdörtgenle bu yöneyin aradeğerini buna yazar.
	 * Bu dikdörtgeni döndürür.
	 * Mesafelerin toplamının bir olduğunu varsayar. */
	public Dikdörtgen aradeğer(Dikdörtgen ö, float uzaklık, float yakınlık) {
		return aradeğer(this, ö, uzaklık, yakınlık);
	}
	
	/** Verilen dikdörtgenin bu dikdörtgene eşit olup olmadığını hesaplar. */
	public boolean eşittir(Dikdörtgen ö) {
		return
				k.eşittir(ö.k) &&
				b.eşittir(ö.b) &&
				o.eşittir(ö.o) &&
				u.eşittir(ö.u);
	}
	
	/** Yöneyin dikdörtgenin içinde olup olmadığını hesaplar. */
	public boolean içinde(Yöney2 ö) {
		return
				k.x <= ö.x &&
				k.y <= ö.y &&
				b.x >= ö.x &&
				b.y >= ö.y;
	}
	
	/** Dikdörtgeni dizeye ekler. */
	public StringBuilder dize(StringBuilder dize) {
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
	
	/** Dikdörtgeni dizeye çevirir. */
	public String dize() {
		return dize(new StringBuilder()).toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		return eşittir((Dikdörtgen)obj);
	}
	
	@Override
	public String toString() {
		return dize();
	}
}
