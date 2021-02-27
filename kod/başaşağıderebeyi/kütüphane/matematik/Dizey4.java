/**
 * başaşağıderebeyi.kütüphane.matematik.Matris.java
 * 0.3 / 16 Oca 2021 / 20:31:28
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 *
 * Waistax Framework'den biraz alındı.
 * ? / ? / ?
 */
package başaşağıderebeyi.kütüphane.matematik;

import java.io.*;

/** Dörde dört boyutlu bir dizey. Girdileri ondalıklı sayılar olarak
 * saklanır. */
public class Dizey4 implements Serializable {
	@Serial
	private static final long serialVersionUID = 8678752283053183894L;
	
	/** Çapraz olarak birlere sahip olan dizey. */
	public static final Dizey4 BİRİM = new Dizey4().birimDizeyeÇevir();
	/** Elemanlarının hepsi sıfır olan dizey. */
	public static final Dizey4 SIFIR = new Dizey4();
	
	/** Dizeyin girdilerini içeren dizi. */
	public final float[] girdileri;
	
	/** Sıfır dizeyi tanımlar. */
	public Dizey4() {
		girdileri = new float[16];
	}
	
	/** Verilen dizeyle aynı tanımlar. */
	public Dizey4(final Dizey4 öbürü) {
		this();
		değiştir(öbürü);
	}
	
	/** Dizeyin bütün girdilerini sıfıra değiştirir. Dizeyi döndürür. */
	public Dizey4 sıfırDizeyineÇevir() {
		girdileri[0] = 0.0F;
		girdileri[1] = 0.0F;
		girdileri[2] = 0.0F;
		girdileri[3] = 0.0F;
		girdileri[4] = 0.0F;
		girdileri[5] = 0.0F;
		girdileri[6] = 0.0F;
		girdileri[7] = 0.0F;
		girdileri[8] = 0.0F;
		girdileri[9] = 0.0F;
		girdileri[10] = 0.0F;
		girdileri[11] = 0.0F;
		girdileri[12] = 0.0F;
		girdileri[13] = 0.0F;
		girdileri[14] = 0.0F;
		girdileri[15] = 0.0F;
		return this;
	}
	
	/** Dizeyin çaprazdaki girdilerini bire, diğer girdilerini sıfıra
	 * değiştirir. Dizeyi döndürür. */
	public Dizey4 birimDizeyeÇevir() {
		girdileri[0] = 1.0F;
		girdileri[1] = 0.0F;
		girdileri[2] = 0.0F;
		girdileri[3] = 0.0F;
		girdileri[4] = 0.0F;
		girdileri[5] = 1.0F;
		girdileri[6] = 0.0F;
		girdileri[7] = 0.0F;
		girdileri[8] = 0.0F;
		girdileri[9] = 0.0F;
		girdileri[10] = 1.0F;
		girdileri[11] = 0.0F;
		girdileri[12] = 0.0F;
		girdileri[13] = 0.0F;
		girdileri[14] = 0.0F;
		girdileri[15] = 1.0F;
		return this;
	}
	
	/** Dizeyi izdüşüm dizeyine değiştirir. Üç boyutlu uzayın sağını genişliğin
	 * yarısına, üstünü yüksekliğin yarısına oranlar. Dizeyi döndürür. */
	public Dizey4 izdüşümDizeyineÇevir(
		final float genişliği,
		final float yüksekliği,
		final float derinliği) {
		girdileri[0] = 2.0F / genişliği;
		girdileri[1] = 0.0F;
		girdileri[2] = 0.0F;
		girdileri[3] = 0.0F;
		girdileri[4] = 0.0F;
		girdileri[5] = 2.0F / yüksekliği;
		girdileri[6] = 0.0F;
		girdileri[7] = 0.0F;
		girdileri[8] = 0.0F;
		girdileri[9] = 0.0F;
		girdileri[10] = 2.0F / -derinliği;
		girdileri[11] = 0.0F;
		girdileri[12] = 0.0F;
		girdileri[13] = 0.0F;
		girdileri[14] = 0.0F;
		girdileri[15] = 1.0F;
		return this;
	}
	
	/** Birim dizeyi ya da dönüşüm dizeyini verilen konum ve biçim ile
	 * değiştirir. Biçimin son bileşeni, ekranın içine doğru olan eksende saat
	 * yönünün tersine dönmesinin açısıdır. Dizeyi döndürür. */
	public Dizey4 dönüşümDizeyiniGüncelle(
		final Yöney3 konumu,
		final Yöney3 biçimi) {
		return ötelemeBölümünüGüncelle(konumu).biçimBölümünüGüncelle(biçimi);
	}
	
	/** Birim dizeyi ya da dönüşüm dizeyini verilen konum ve biçim ile
	 * değiştirir. Yatay ve dikey boyutları aynıdır. Biçimin son bileşeni,
	 * ekranın içine doğru olan eksende saat yönünün tersine dönmesinin
	 * açısıdır. Dizeyi döndürür. */
	public Dizey4 dönüşümDizeyiniGüncelle(
		final Yöney3 konumu,
		final Yöney2 biçimi) {
		return ötelemeBölümünüGüncelle(konumu).biçimBölümünüGüncelle(biçimi);
	}
	
	/** Birim dizeyin ya da dönüşüm dizeyinin noktayı dönüştürüp
	 * dönüştürmediğini değiştirir. Noktayı dönüştüren dizeylerin son girdisi
	 * birken, yöneyi dönüştüren dizeylerin son girdisi sıfırdır. Yöneyi
	 * döndürür. */
	public Dizey4 noktayıDönüştürmesiniGüncelle(
		final boolean noktayıDönüştürmesi) {
		girdileri[15] = noktayıDönüştürmesi ? 1.0F : 0.0F;
		return this;
	}
	
	/** Birim dizeyi ya da dönüşüm dizeyini verilen konum ile değiştirir. Dizeyi
	 * döndürür. */
	public Dizey4 ötelemeBölümünüGüncelle(final Yöney3 konumu) {
		return ötelemeBölümünüGüncelle(
			konumu.birinciBileşeni,
			konumu.ikinciBileşeni,
			konumu.üçüncüBileşeni);
	}
	
	/** Birim dizeyi ya da dönüşüm dizeyini verilen konum ile değiştirir.
	 * Derinliği sıfırdır. Dizeyi döndürür. */
	public Dizey4 ötelemeBölümünüGüncelle(final Yöney2 konumu) {
		return ötelemeBölümünüGüncelle(
			konumu.birinciBileşeni,
			konumu.ikinciBileşeni,
			0.0F);
	}
	
	/** Birim dizeyi ya da dönüşüm dizeyini verilen konum ile değiştirir. Dizeyi
	 * döndürür. Derinlik, ekranın içine doğru olan eksendeki konumdur. Daha
	 * derinde olan nesneler derinlik tamponu sayesinde altta çizilir. */
	public Dizey4 ötelemeBölümünüGüncelle(
		final float yataydakiKonumu,
		final float dikeydekiKonumu,
		final float derinliği) {
		girdileri[12] = yataydakiKonumu;
		girdileri[13] = dikeydekiKonumu;
		girdileri[14] = derinliği;
		return this;
	}
	
	/** Birim dizeyi ya da dönüşüm dizeyini verilen biçim ile değiştirir. Dizeyi
	 * döndürür. */
	public Dizey4 biçimBölümünüGüncelle(final Yöney3 biçimi) {
		return biçimBölümünüGüncelle(
			biçimi.birinciBileşeni,
			biçimi.ikinciBileşeni,
			biçimi.üçüncüBileşeni);
	}
	
	/** Birim dizeyi ya da dönüşüm dizeyini verilen biçim ile değiştirir. Dönüş
	 * açısı, ekranın içine doğru olan eksende saat yönünün tersinedir ve radyan
	 * birimindendir. Dizeyi döndürür. */
	public Dizey4 biçimBölümünüGüncelle(
		final Yöney2 boyutu,
		final float dönüşAçısı) {
		return biçimBölümünüGüncelle(
			boyutu.birinciBileşeni,
			boyutu.ikinciBileşeni,
			dönüşAçısı);
	}
	
	/** Birim dizeyi ya da dönüşüm dizeyini verilen biçim ile değiştirir. Dönüş
	 * açısı, ekranın içine doğru olan eksende saat yönünün tersinedir ve radyan
	 * birimindendir. Dizeyi döndürür. */
	public Dizey4 biçimBölümünüGüncelle(
		final float yataydakiBoyutu,
		final float dikeydekiBoyutu,
		final float dönüşAçısı) {
		final float dikmeliği = MatematikAracı.dikmeliğiniBul(dönüşAçısı);
		final float eşdikmeliği = MatematikAracı.eşdikmeliğiniBul(dönüşAçısı);
		
		girdileri[0] = eşdikmeliği * yataydakiBoyutu;
		girdileri[1] = dikmeliği * yataydakiBoyutu;
		girdileri[4] = -dikmeliği * dikeydekiBoyutu;
		girdileri[5] = eşdikmeliği * dikeydekiBoyutu;
		return this;
	}
	
	/** Birim dizeyi ya da dönüşüm dizeyini verilen biçim ile günceller. Yatay
	 * ve dikey boyutları aynıdır. Biçimin son bileşeni, ekranın içine doğru
	 * olan eksende saat yönünün tersine dönmesinin açısıdır. Dizeyi
	 * döndürür. */
	public Dizey4 biçimBölümünüGüncelle(final Yöney2 biçimi) {
		return biçimBölümünüGüncelle(
			biçimi.birinciBileşeni,
			biçimi.ikinciBileşeni);
	}
	
	/** Birim dizeyi ya da dönüşüm dizeyini verilen biçim ile değiştirir. Yatay
	 * ve dikey boyutları aynıdır. Dönüş açısı, ekranın içine doğru olan eksende
	 * saat yönünün tersinedir ve radyan birimindendir. Dizeyi döndürür. */
	public Dizey4 biçimBölümünüGüncelle(
		final float boyutu,
		final float dönüşAçısı) {
		final float oranlanmışDikmeliği =
			MatematikAracı.dikmeliğiniBul(dönüşAçısı) * boyutu;
		final float oranlanmışEşdikmeliği =
			MatematikAracı.eşdikmeliğiniBul(dönüşAçısı) * boyutu;
		
		girdileri[0] = oranlanmışEşdikmeliği;
		girdileri[1] = oranlanmışDikmeliği;
		girdileri[4] = -oranlanmışDikmeliği;
		girdileri[5] = oranlanmışEşdikmeliği;
		return this;
	}
	
	/** Bu dizeyi verilen dizeylerin çarpımına değiştirir. Verilen dizeylerin bu
	 * dizeyden farklı olduğunu varsayar. Bu dizeyi döndürür. */
	public Dizey4 çarp(final Dizey4 soldaki, final Dizey4 sağdaki) {
		girdileri[0] = soldaki.girdileri[0] * sağdaki.girdileri[0] +
			soldaki.girdileri[4] * sağdaki.girdileri[1] +
			soldaki.girdileri[8] * sağdaki.girdileri[2] +
			soldaki.girdileri[12] * sağdaki.girdileri[3];
		girdileri[1] = soldaki.girdileri[1] * sağdaki.girdileri[0] +
			soldaki.girdileri[5] * sağdaki.girdileri[1] +
			soldaki.girdileri[9] * sağdaki.girdileri[2] +
			soldaki.girdileri[13] * sağdaki.girdileri[3];
		girdileri[2] = soldaki.girdileri[2] * sağdaki.girdileri[0] +
			soldaki.girdileri[6] * sağdaki.girdileri[1] +
			soldaki.girdileri[10] * sağdaki.girdileri[2] +
			soldaki.girdileri[14] * sağdaki.girdileri[3];
		girdileri[3] = soldaki.girdileri[3] * sağdaki.girdileri[0] +
			soldaki.girdileri[7] * sağdaki.girdileri[1] +
			soldaki.girdileri[11] * sağdaki.girdileri[2] +
			soldaki.girdileri[15] * sağdaki.girdileri[3];
		girdileri[4] = soldaki.girdileri[0] * sağdaki.girdileri[4] +
			soldaki.girdileri[4] * sağdaki.girdileri[5] +
			soldaki.girdileri[8] * sağdaki.girdileri[6] +
			soldaki.girdileri[12] * sağdaki.girdileri[7];
		girdileri[5] = soldaki.girdileri[1] * sağdaki.girdileri[4] +
			soldaki.girdileri[5] * sağdaki.girdileri[5] +
			soldaki.girdileri[9] * sağdaki.girdileri[6] +
			soldaki.girdileri[13] * sağdaki.girdileri[7];
		girdileri[6] = soldaki.girdileri[2] * sağdaki.girdileri[4] +
			soldaki.girdileri[6] * sağdaki.girdileri[5] +
			soldaki.girdileri[10] * sağdaki.girdileri[6] +
			soldaki.girdileri[14] * sağdaki.girdileri[7];
		girdileri[7] = soldaki.girdileri[3] * sağdaki.girdileri[4] +
			soldaki.girdileri[7] * sağdaki.girdileri[5] +
			soldaki.girdileri[11] * sağdaki.girdileri[6] +
			soldaki.girdileri[15] * sağdaki.girdileri[7];
		girdileri[8] = soldaki.girdileri[0] * sağdaki.girdileri[8] +
			soldaki.girdileri[4] * sağdaki.girdileri[9] +
			soldaki.girdileri[8] * sağdaki.girdileri[10] +
			soldaki.girdileri[12] * sağdaki.girdileri[11];
		girdileri[9] = soldaki.girdileri[1] * sağdaki.girdileri[8] +
			soldaki.girdileri[5] * sağdaki.girdileri[9] +
			soldaki.girdileri[9] * sağdaki.girdileri[10] +
			soldaki.girdileri[13] * sağdaki.girdileri[11];
		girdileri[10] = soldaki.girdileri[2] * sağdaki.girdileri[8] +
			soldaki.girdileri[6] * sağdaki.girdileri[9] +
			soldaki.girdileri[10] * sağdaki.girdileri[10] +
			soldaki.girdileri[14] * sağdaki.girdileri[11];
		girdileri[11] = soldaki.girdileri[3] * sağdaki.girdileri[8] +
			soldaki.girdileri[7] * sağdaki.girdileri[9] +
			soldaki.girdileri[11] * sağdaki.girdileri[10] +
			soldaki.girdileri[15] * sağdaki.girdileri[11];
		girdileri[12] = soldaki.girdileri[0] * sağdaki.girdileri[12] +
			soldaki.girdileri[4] * sağdaki.girdileri[13] +
			soldaki.girdileri[8] * sağdaki.girdileri[14] +
			soldaki.girdileri[12] * sağdaki.girdileri[15];
		girdileri[13] = soldaki.girdileri[1] * sağdaki.girdileri[12] +
			soldaki.girdileri[5] * sağdaki.girdileri[13] +
			soldaki.girdileri[9] * sağdaki.girdileri[14] +
			soldaki.girdileri[13] * sağdaki.girdileri[15];
		girdileri[14] = soldaki.girdileri[2] * sağdaki.girdileri[12] +
			soldaki.girdileri[6] * sağdaki.girdileri[13] +
			soldaki.girdileri[10] * sağdaki.girdileri[14] +
			soldaki.girdileri[14] * sağdaki.girdileri[15];
		girdileri[15] = soldaki.girdileri[3] * sağdaki.girdileri[12] +
			soldaki.girdileri[7] * sağdaki.girdileri[13] +
			soldaki.girdileri[11] * sağdaki.girdileri[14] +
			soldaki.girdileri[15] * sağdaki.girdileri[15];
		return this;
	}
	
	/** Bu dizeyi verilen dizeye değiştirir. Bu dizeyi döndürür. */
	public Dizey4 değiştir(final Dizey4 öbürü) {
		System.arraycopy(öbürü.girdileri, 0, girdileri, 0, 16);
		return this;
	}
}
