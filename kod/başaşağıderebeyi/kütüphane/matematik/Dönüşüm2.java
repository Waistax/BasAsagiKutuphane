/**
 * başaşağıderebeyi.kütüphane.matematik.Dönüşüm2.java
 * 0.9 / 27 Şub 2021 / 00:16:01
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.kütüphane.matematik;

/** İki boyutlu bir nesnenin üç boyutlu uzayın içindeki konumunu ve biçimini
 * temsil eden bir dönüşüm dizeyi. */
public class Dönüşüm2 {
	/** Nesnenin üç boyutlu uzaydaki konumu. Üçüncü bileşeni, nesnenin ekranın
	 * içine doğru olan derinliğidir. */
	public final Yöney3 konumu;
	/** Nesnenin iki boyutlu uzaydaki biçimi. Üçüncü bileşeni dönme açısıdır.
	 * Ekranın içine doğru olan eksende saat yönünün tersinedir ve radyan
	 * birimindendir. */
	public final Yöney3 biçimi;
	/** Dönüşümü gerçekleştirecek dizey. */
	public final Dizey4 dizeyi;
	
	/** Etkisiz tanımlar. */
	public Dönüşüm2() {
		konumu = new Yöney3();
		biçimi = new Yöney3().bileşenleriniDeğiştir(1.0F, 1.0F, 0.0F);
		dizeyi = new Dizey4().birimDizeyeÇevir();
	}
	
	/** Konumu ve biçimi kullanarak dizeyi günceller. */
	public void güncelle() {
		dizeyi.dönüşümDizeyiniGüncelle(konumu, biçimi);
	}
	
	/** Bu dönüşümü baştaki ve sondaki dönüşümlerin verilen uzaklığa göre
	 * aradeğerlerine değiştirir. Verilen dönüşümlerin bu dönüşümden farklı
	 * olduğunu varsayar. Bu dönüşümü döndürür. */
	public Dönüşüm2 aradeğerleriniBul(
		final Dönüşüm2 baştaki,
		final Dönüşüm2 sondaki,
		final float uzaklık) {
		konumu.aradeğerleriniBul(baştaki.konumu, sondaki.konumu, uzaklık);
		biçimi.aradeğerleriniBul(baştaki.biçimi, sondaki.biçimi, uzaklık);
		return this;
	}
}
