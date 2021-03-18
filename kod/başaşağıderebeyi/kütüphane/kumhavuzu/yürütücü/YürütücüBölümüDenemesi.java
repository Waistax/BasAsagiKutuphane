/**
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 * 0.14.1 / 18 Mar 2021 / 22:21:33
 */
package başaşağıderebeyi.kütüphane.kumhavuzu.yürütücü;

import başaşağıderebeyi.kütüphane.matematik.ortalama.*;
import başaşağıderebeyi.kütüphane.yürütücü.*;

import java.util.*;
import java.util.stream.*;

/** Yürütücü bölümünü dener. */
public class YürütücüBölümüDenemesi {
	/** Yürütücü bölümünün hızını dener. */
	public static void yürütücüBölümünüDene() {
		final int nesneSayısı = 1000000;
		final Set<DenemeNesnesi> nesneleri = new HashSet<>(nesneSayısı);
		
		IntStream
			.range(0, nesneSayısı)
			.forEach(
				i -> nesneleri.add(new DenemeNesnesi().değeriniDeğiştir(i)));
		
		System.out
			.println(
				nesneleri.size() + " nesne için paralel yürütme deneniyor...");
		
		final Süreç yürütücüOlmadan = new Süreç();
		yürütücüOlmadan.başla(zamanıEdin());
		nesneleri
			.parallelStream()
			.forEach(nesne -> nesne.değeriniDeğiştir(nesne.değeri * 2));
		yürütücüOlmadan.dur(zamanıEdin());
		
		YürütücüSağlayıcısı.değiştir(new İşlemliYürütücü());
		
		final Süreç yürütücüİle = new Süreç();
		yürütücüİle.başla(zamanıEdin());
		final Dağıtıcı<DenemeNesnesi> dağıtıcı = new Dağıtıcı<>();
		dağıtıcı.hepsiniDağıt(nesneleri);
		dağıtıcı
			.yürütmeyiDeğiştir(
				nesne -> nesne.değeriniDeğiştir(nesne.değeri * 2));
		dağıtıcı.yürüt();
		yürütücüİle.dur(zamanıEdin());
		
		System.out
			.println("Yürütücü Olmadan: " + yürütücüOlmadan.toplamınıEdin());
		System.out.println("Yürütücü İle: " + yürütücüİle.toplamınıEdin());
	}
	
	private static float zamanıEdin() {
		return System.nanoTime() / 1000000000.0F;
	}
}
