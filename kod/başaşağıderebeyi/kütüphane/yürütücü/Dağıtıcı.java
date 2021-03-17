/**
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 * 0.8 / 21 Şub 2021 / 10:37:13
 */
package başaşağıderebeyi.kütüphane.yürütücü;

import java.util.*;
import java.util.function.*;

/** Nesneleri takımlara eşit dağıtır ve onları aynı anda yürütür. */
@Deprecated
public class Dağıtıcı<T> {
	/** Toplam dağıtılmış nesne sayısı. Bu sayı her takıma kaç eleman düşeceğini
	 * hesaplamada kullanılır. */
	private int nesneSayısı;
	/** Nesneleri içeren takımlar. */
	private final Set<Takım<T>> takımlar;
	/** Kullanılan yürütme. */
	protected Consumer<T> yürütme;
	
	/** Boş tanımlar. */
	public Dağıtıcı() {
		// İşlem sayısı kadar takım oluştur.
		final int işlemSayısı = YürütücüSağlayıcısı.sağla().işlemSayısı();
		takımlar = new HashSet<>(işlemSayısı);
		for (int i = 0; i < işlemSayısı; i++)
			takımlar.add(new Takım<>(this));
	}
	
	/** Bütün takımları temizler. */
	public void hepsiniÇıkar() {
		nesneSayısı = 0;
		takımlar.forEach(takım -> takım.nesneler.clear());
	}
	
	/** Varlarsa nesneleri takımlardan çıkarır. */
	public void hepsiniÇıkar(final Collection<T> nesneler) {
		nesneler.forEach(this::çıkar);
	}
	
	/** Varsa nesneyi takımlardan çıkarır. */
	public void çıkar(final T nesne) {
		// Çıkarana kadar bütün takımları gez.
		for (final Takım<T> takım : takımlar)
			if (takım.nesneler.remove(nesne)) {
				nesneSayısı--;
				return;
			}
	}
	
	/** Nesneyi uygun bir takıma ekler. */
	public void dağıt(final T nesne) {
		// Yeni eleman sayısını hesapla.
		nesneSayısı++;
		final int işlemSayısı = YürütücüSağlayıcısı.sağla().işlemSayısı();
		final int elemanSayısı = nesneSayısı / işlemSayısı;
		
		ekle(nesne, elemanSayısı);
	}
	
	/** Nesneleri takımlara dağıtır. */
	public void hepsiniDağıt(final Collection<T> nesneler) {
		// Yeni eleman sayısını hesapla.
		nesneSayısı += nesneler.size();
		final int işlemSayısı = YürütücüSağlayıcısı.sağla().işlemSayısı();
		final int elemanSayısı = nesneSayısı / işlemSayısı;
		nesneler.forEach(nesne -> ekle(nesne, elemanSayısı));
	}
	
	/** Bütün takımları aynı anda yürütür. */
	public void yürüt() {
		takımlar.forEach(YürütücüSağlayıcısı.sağla()::yürüt);
		
		// Bütün takımlar bitene kadar dön.
		boolean bitmemişTakımVar;
		do {
			bitmemişTakımVar = false;
			for (final Takım<T> takım : takımlar)
				if (takım.yineleyici.hasNext()) {
					bitmemişTakımVar = true;
					break;
				}
		} while (bitmemişTakımVar);
	}
	
	/** Kullanılan yürütmeyi değiştirir. */
	public void yürütmeyiDeğiştir(final Consumer<T> yürütme) {
		this.yürütme = yürütme;
	}
	
	/** Nesneyi eleman sayısını geçmemiş bir takıma ekler. */
	private void ekle(final T nesne, final int elemanSayısı) {
		// Ekleyene kadar bütün takımları gez.
		for (final Takım<T> takım : takımlar)
			if (takım.nesneler.size() <= elemanSayısı) {
				takım.nesneler.add(nesne);
				return;
			}
	}
}
