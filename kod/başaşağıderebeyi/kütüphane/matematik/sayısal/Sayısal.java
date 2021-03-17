/**
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 * 0.9 / 25 Şub 2021 / 18:29:37
 */
package başaşağıderebeyi.kütüphane.matematik.sayısal;

/** Sayı değeri olan, üstdüşüm ve doğrusallık kurallarına uyan bir nesne. */
public interface Sayısal {
	/** Bu sayısal nesneyi verilen sayısal nesnelerin üstdüşümlerine değiştirir.
	 * Bu sayısal nesneyi döndürür. */
	Sayısal topla(Sayısal soldaki, Sayısal sağdaki);
	
	/** Sağdaki sayısalın -1 ile oranlanmışı ile kısa yoldan üstdüşümler. */
	Sayısal çıkar(Sayısal soldaki, Sayısal sağdaki);
	
	/** Bu sayısal nesneyi verilen sayısal nesnenin doğrusal bir oranıyla
	 * değiştirir. Bu sayısal nesneyi döndürür. */
	Sayısal çarp(Sayısal öbürü, float sayı);
	
	/** Verilen sayının tersi ile kısayoldan oranlar. */
	Sayısal böl(Sayısal öbürü, float sayı);
}
