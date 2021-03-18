/**
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 * 0.12.2 / 16 Mar 2021 / 18:01:49
 * 
 * BaşAşağıMotor'dan alındı.
 * 0.17 / 15 Eyl 2020 / 17:03:13
 */
package başaşağıderebeyi.kütüphane.arayüz;

import static başaşağıderebeyi.kütüphane.matematik.dikdörtgen.DikdörtgenVerisi.*;

import başaşağıderebeyi.kütüphane.matematik.sayısal.*;
import başaşağıderebeyi.kütüphane.matematik.yerleşim.*;

/** Göründüğünden daha büyük olabilen, içinde başka öğeleri barındırabilen ve
 * kayabilen bir öğe. */
public class KayanLevha extends Levha {
	/** Görünen alanının görünmeyen alanının üstündeki ne kadar kaydığı. */
	public final Yöney2 kayması;
	
	/** Görünen alanını yatayda kaydıran çubuk. */
	public final KaydırmaÇubuğu yataydakiÇubuğu;
	/** Görünen alanını dikeyde kaydıran çubuk. */
	public final KaydırmaÇubuğu dikeydekiÇubuğu;
	
	private final GöreliKural yatayKonumununKuralı;
	private final TersGöreliKural dikeyKonumununKuralı;
	private final Yöney2 konumu;
	
	/** Verilen levhanın içinde yeni levhalar ile tanımlar. */
	public KayanLevha(
		final Levha içerenLevha,
		final float asılGenişliği,
		final float asılYüksekliği) {
		super(new Levha(new Levha(içerenLevha)));
		kayması = new Yöney2();
		
		this.içerenLevha.yerleşimi
			.kurallarıDeğiştir(
				new GöreliKural(KÜÇÜK_KÖŞESİ),
				new TersGöreliKural(BÜYÜK_KÖŞESİ, KaydırmaÇubuğu.KALINLIĞI),
				new TersGöreliKural(BÜYÜK_KÖŞESİ),
				new GöreliKural(KÜÇÜK_KÖŞESİ, KaydırmaÇubuğu.KALINLIĞI));
		
		yerleşimi
			.kurallarıDeğiştir(
				yatayKonumununKuralı = new GöreliKural(KÜÇÜK_KÖŞESİ),
				new SerbestKural(UZUNLUKLARI, asılGenişliği),
				dikeyKonumununKuralı = new TersGöreliKural(BÜYÜK_KÖŞESİ),
				new SerbestKural(UZUNLUKLARI, asılYüksekliği));
		
		yataydakiÇubuğu = new KaydırmaÇubuğu(this, false);
		dikeydekiÇubuğu = new KaydırmaÇubuğu(this, true);
		
		konumu = new Yöney2();
	}
	
	@Override
	protected void imleçtenİlgiGörmesiniBul() {
		imleçtenİlgiGörmesi = içerenLevha.alanı
			.içindeOlmasınıBul(içerenEkran.girdi.imlecininKonumu) &&
			içerenEkran.solTık.kullanmayıDene(this);
	}
	
	@Override
	public void yerleştir() {
		konumu
			.çıkar(içerenLevha.alanı.uzunlukları, alanı.uzunlukları)
			.çarp(kayması);
		yatayKonumununKuralı.uzaklığı = konumu.birinciBileşeni;
		dikeyKonumununKuralı.uzaklığı = konumu.ikinciBileşeni;
		super.yerleştir();
	}
}
