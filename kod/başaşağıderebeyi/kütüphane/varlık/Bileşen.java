/**
 * başaşağıderebeyi.kütüphane.varlık.Bileşen.java
 * 0.8 / 17 Şub 2021 / 10:51:19
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 * 
 * BaşAşağıMotor'dan alındı.
 * 0.22 / 4 Kas 2020 / 18:10:59
 */
package başaşağıderebeyi.kütüphane.varlık;

public abstract class Bileşen {
	public final Varlık varlık;
	
	@SuppressWarnings("unchecked")
	public Bileşen(final Varlık varlık) {
		this.varlık = varlık;
		Class<? extends Bileşen> sınıf = this.getClass();
		do {
			varlık.bileşenler.put(sınıf, this);
			sınıf = (Class<? extends Bileşen>)sınıf.getSuperclass();
		} while (sınıf != Bileşen.class);
		for (final Soy soy : varlık.topluluk.soylar)
			soy.ekle(varlık);
	}
}
