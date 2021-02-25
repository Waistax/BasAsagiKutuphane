/**
 * başaşağıderebeyi.kütüphane.matematik.Sayısal.java
 * 0.9 / 25 Şub 2021 / 18:29:37
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.kütüphane.matematik;

/** Sayı değeri olan, üstdüşüm ve doğrusallık kurallarına uyan bir nesne. Bu
 * nesnelerle hesaplama yapmanın az işlem ve bellek gerektiren bir yolu bulunana
 * kadar kullanımda olmayacak. Eğer bulunamazsa silinecek. */
@Deprecated
public interface Sayısal {
	/** Bu sayısal nesneyi verilen sayısal nesnelerin üstdüşümlerine değiştirir.
	 * Bu sayısal nesneyi döndürür. */
	Sayısal üstdüşümleriniBul(Sayısal soldakiSayısal, Sayısal sağdakiSayısal);
	
	/** Bu sayısal nesneyi verilen sayısal nesnenin doğrusal bir oranıyla
	 * değiştirir. Bu sayısal nesneyi döndürür. */
	Sayısal doğrusalOlarakOranla(Sayısal öbürü, float oran);
}
