/**
 * başaşağıderebeyi.kütüphane.yürütücü.Dağıtıcı.java
 * 0.8 / 21 Şub 2021 / 10:37:13
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.kütüphane.yürütücü;

import java.util.*;

/** Nesneleri takımlara eşit dağıtır ve onları aynı anda yürütür. */
public class Dağıtıcı<T> {
	/** Nesneleri içeren takımlar. */
	private final Set<Takım<T>> takımlar;
	/** Toplam dağıtılmış nesne sayısı.
	 * Bu sayı her takıma kaç eleman düşeceğini hesaplamada kullanılır. */
	private int nesneSayısı;
	/** Kullanılan yürütme. */
	private Yürütme<T> yürütme;
	
	/** Boş tanımlar. */
	public Dağıtıcı() {
		// İşlem sayısı kadar takım oluştur.
		int işlemSayısı = YürütücüSağlayıcısı.sağla().işlemSayısı();
		takımlar = new HashSet<>(işlemSayısı);
		for (int i = 0; i < işlemSayısı; i++)
			takımlar.add(new Takım<>(this));
	}
	
	/** Kullanılan yürütmeyi değiştirir. */
	public void yürütmeyiDeğiştir(Yürütme<T> yürütme) {
		this.yürütme = yürütme;
	}
	
	/** Bütün takımları temizler. */
	public void temizle() {
		nesneSayısı = 0;
		for (Takım<T> takım : takımlar)
			takım.nesneler.clear();
	}
	
	/** Nesneyi eleman sayısını geçmemiş bir takıma ekler. */
	private void ekle(T nesne, int elemanSayısı) {
		// Ekleyene kadar bütün takımları gez.
		for (Takım<T> takım : takımlar)
			if (takım.nesneler.size() <= elemanSayısı) {
				takım.nesneler.add(nesne);
				return;
			}
	}
	
	/** Nesneyi uygun bir takıma ekler. */
	public void dağıt(T nesne) {
		// Yeni eleman sayısını hesapla.
		nesneSayısı++;
		int işlemSayısı = YürütücüSağlayıcısı.sağla().işlemSayısı();
		int elemanSayısı = nesneSayısı / işlemSayısı;
		
		ekle(nesne, elemanSayısı);
	}
	
	/** Nesneleri takımlara dağıtır. */
	public void hepsiniDağıt(Collection<T> nesneler) {
		// Yeni eleman sayısını hesapla.
		nesneSayısı += nesneler.size();
		int işlemSayısı = YürütücüSağlayıcısı.sağla().işlemSayısı();
		int elemanSayısı = nesneSayısı / işlemSayısı;
		
		for (T nesne : nesneler) {
			ekle(nesne, elemanSayısı);
		}
	}
	
	/** Varsa nesneyi takımlardan çıkarır. */
	public void çıkar(T nesne) {
		// Çıkarana kadar bütün takımları gez.
		for (Takım<T> takım : takımlar)
			if (takım.nesneler.remove(nesne)) {
				nesneSayısı--;
				return;
			}
	}
	
	/** Varlarsa nesneleri takımlardan çıkarır. */
	public void hepsiniÇıkar(Collection<T> nesneler) {
		for (T nesne : nesneler)
			çıkar(nesne);
	}
	
	/** Bütün takımları aynı anda yürütür. */
	public void yürüt() {
		Yürütücü yürütücü = YürütücüSağlayıcısı.sağla();
		
		for (Takım<T> takım : takımlar)
			yürütücü.yürüt(takım);
		
		// Bütün takımlar bitene kadar dön.
		boolean bitmemişTakımVar;
		do {
			bitmemişTakımVar = false;
			for (Takım<T> takım : takımlar)
				if (takım.yineleyici.hasNext()) {
					bitmemişTakımVar = true;
					break;
				}
		} while (bitmemişTakımVar);
	}
	
	/** Nesneyi yürüt.
	 * Bütün nesneler aynı anda yürütülür. */
	protected void yürüt(T nesne) {
		yürütme.yürüt(nesne);
	}
}
