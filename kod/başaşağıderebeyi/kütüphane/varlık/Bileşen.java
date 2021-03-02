/**
 * başaşağıderebeyi.kütüphane.varlık.Bileşen.java
 * 0.8 / 17 Şub 2021 / 10:51:19
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 * 
 * BaşAşağıMotor'dan alındı.
 * 0.22 / 4 Kas 2020 / 18:10:59
 */
package başaşağıderebeyi.kütüphane.varlık;

/** Bir varlığı tanımlayan ve oluşturan parçacık. */
public abstract class Bileşen {
	/** Bileşenin tanımladığı varlık. */
	public final Varlık içerenVarlık;
	
	/** Verilen varlığın içinde tanımlar. */
	public Bileşen(final Varlık içerenVarlık) {
		this.içerenVarlık = içerenVarlık;
		içerenVarlık.bileşeniEkle(this);
	}
}
