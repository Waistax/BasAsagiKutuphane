/**
 * başaşağıderebeyi.kütüphane.kumhavuzu.KodDeneme.java
 * 0.6 / 19 Oca 2021 / 08:09:17
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.kütüphane.kumhavuzu;

import başaşağıderebeyi.kütüphane.olay.*;

import java.util.*;

/** Farklı yöntemlerin çalışıp çalışmadığını dener. */
public class KodDeneme {
	/** Olayların ve dağıtıcının çalışmasını dener. */
	@SuppressWarnings("unused")
	private static void olayDenemesi() {
		final OlayYöneticisi dağıtıcı = new OlayYöneticisi();
		final DenemeDinleyicisi dinleyici = new DenemeDinleyicisi();
		dağıtıcı.dinleyiciEkle(dinleyici);
		dağıtıcı.olayEkle(new DenemeOlayı("Merhaba ben Cem!"));
		dağıtıcı.olayEkle(new DenemeOlayı("Bu Cem kötüdür!"));
		dağıtıcı.güncelle();
		dağıtıcı.dinleyiciÇıkar(dinleyici);
		dağıtıcı.olayEkle(new DenemeOlayı("Cem çok iyi birisidir!"));
		dağıtıcı.güncelle();
	}
	
	/** Sınıf nesnesinin hangi sınıf olduğunun kontrol edilip edilemeyeceğini dener. */
	@SuppressWarnings("unused")
	private static void sınıfTürüKontrolüDenemesi() {
		/*
		 * HATA: Cannot perform instanceof check against parameterized type Class<? extends Olay>. Use the form Class<?>
		 * instead since further generic type information will be erased at runtime
		 */
		// System.out.println(KodDeneme.class instanceof Class<?
		// extends
		// Olay>);
	}
	
	/** Yineleyici nesnesinin nasıl ilerlediğini dener. */
	@SuppressWarnings("unused")
	private static void yineleyiciİlerlemeDenemesi() {
		final Set<String> küme = new HashSet<>();
		küme.add("Cem");
		küme.add("GEÇGEL");
		küme.add("mükemmel");
		küme.add("birisidir.");
		final Iterator<String> yineleyici = küme.iterator();
		while (yineleyici.hasNext())
			System.out.print(yineleyici.next());
	}
	
	/** Denemenin başlangıcı. */
	public static void main(final String[] args) {
		olayDenemesi();
	}
}
