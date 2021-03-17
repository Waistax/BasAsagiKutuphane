/**
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 * 0.8 / 17 Şub 2021 / 10:54:36
 * 
 * BaşAşağıMotor'dan alındı.
 * 0.22 / 4 Kas 2020 / 18:47:22
 */
package başaşağıderebeyi.kütüphane.varlık;

import java.util.*;

/** Varlıkların birleşmesiyle ortaya çıkan oluşum. */
public class Topluluk {
	/** İçerdiği varlıklar. */
	public final Set<Varlık> varlıkları;
	/** İçerdiği soylar. */
	public final Set<Soy> soyları;
	
	/** Boş topluluk tanımlar. */
	public Topluluk() {
		varlıkları = new HashSet<>();
		soyları = new HashSet<>();
	}
	
	/** Verilen varlığı topluluktan çıkarır. */
	public void varlığınıÇıkar(final Varlık varlığı) {
		if (varlıkları.remove(varlığı))
			soyları
				.parallelStream()
				.forEach(soyu -> soyu.varlığınıÇıkar(varlığı));
	}
	
	/** Verilen soyu topluluktan çıkarır. */
	public void soyunuÇıkar(final Soy soyu) {
		soyları.remove(soyu);
	}
	
	/** Topluluktaki bütün soyları günceller. */
	public void güncelle() {
		soyları.forEach(Soy::güncelle);
	}
	
	/** Topluluktaki bütün soyları çizer. */
	public void çiz() {
		soyları.forEach(Soy::çiz);
	}
	
	void varlığınıTekrarSoylarınaEklemeyiDene(final Varlık varlığı) {
		soyları
			.parallelStream()
			.filter(soyu -> !soyu.varlıkları.contains(varlığı))
			.forEach(soyu -> soyu.varlığıEkle(varlığı));
	}
	
	void varlığıEkle(final Varlık varlık) {
		varlıkları.add(varlık);
	}
	
	void soyuEkle(final Soy soy) {
		if (soyları.add(soy))
			varlıkları.forEach(soy::varlığıEkle);
	}
}
