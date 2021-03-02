/**
 * başaşağıderebeyi.kütüphane.varlık.Soy.java
 * 0.8 / 17 Şub 2021 / 10:53:54
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 * 
 * BaşAşağıMotor'dan alındı.
 * 0.22 / 4 Kas 2020 / 19:00:40
 */
package başaşağıderebeyi.kütüphane.varlık;

import java.util.*;
import java.util.function.*;

/** Belli birtakım bileşeni içeren varlıkların bütünü. */
public abstract class Soy {
	/** Soyun içinde bulunduğu topluluk. */
	public final Topluluk içerenTopluluk;
	/** Topluluktan bu soyun gerektirdiği bileşenleri sağlayan varlıklar. */
	public final Set<Varlık> varlıkları;
	
	private final Class<? extends Bileşen>[] gerekliSınıflar;
	
	/** Verilen topluluğun içinde, verilen bileşen sınıfları için tanımlar. */
	@SafeVarargs
	public Soy(
		final Topluluk topluluk,
		final Class<? extends Bileşen>... gerekliSınıflar) {
		içerenTopluluk = topluluk;
		varlıkları = new HashSet<>();
		this.gerekliSınıflar = gerekliSınıflar;
		topluluk.soyuEkle(this);
	}
	
	/** Soyu günceller. */
	public abstract void güncelle();
	
	/** Soyu çizer. */
	public abstract void çiz();
	
	/** Verilen varlığı soya ekler. Eğer varlık eklenebilirse true döndürür. Ama
	 * eğer varlık gerekli bileşenleri sağlamıyorsa ya da zaten ekliyse false
	 * döndürür. */
	protected boolean varlığıEkle(final Varlık varlık) {
		return varlığınGerekliBileşenleriSağlamasınıBul(varlık) &&
			varlıkları.add(varlık);
	}
	
	/** Verilen varlığı soydan çıkarır. Eğer varlık çıkarilabilinirse true
	 * döndürür. Ama eğer varlık zaten ekli değilse false döndürür. */
	protected boolean varlığınıÇıkar(final Varlık varlığı) {
		return varlıkları.remove(varlığı);
	}
	
	/** Verilen yürütmeyi soydaki bütün varlıklar için aynı anda yürütür. */
	protected void yürüt(final Consumer<Varlık> yürütme) {
		varlıkları.parallelStream().forEach(yürütme);
	}
	
	private boolean varlığınGerekliBileşenleriSağlamasınıBul(
		final Varlık varlık) {
		for (final Class<? extends Bileşen> sınıf : gerekliSınıflar)
			if (varlık.bileşeniniEdin(sınıf) == null)
				return false;
		return true;
	}
}
