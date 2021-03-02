/**
 * başaşağıderebeyi.kütüphane.yürütücü.İşlemliYürütücü.java
 * 0.8 / 21 Şub 2021 / 11:24:56
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.kütüphane.yürütücü;

import java.util.concurrent.*;

@Deprecated
public class İşlemliYürütücü implements Yürütücü {
	private final int işlemSayısı;
	private final ExecutorService yürütmeHizmeti;
	
	public İşlemliYürütücü() {
		this(Runtime.getRuntime().availableProcessors());
	}
	
	public İşlemliYürütücü(final int işlemSayısı) {
		this.işlemSayısı = işlemSayısı;
		yürütmeHizmeti = Executors.newFixedThreadPool(işlemSayısı);
	}
	
	@Override
	public int işlemSayısı() {
		return işlemSayısı;
	}
	
	@Override
	public void yürüt(final Runnable yürütme) {
		yürütmeHizmeti.execute(yürütme);
	}
}
