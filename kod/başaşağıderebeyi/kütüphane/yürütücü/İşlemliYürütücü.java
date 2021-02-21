/**
 * başaşağıderebeyi.kütüphane.yürütücü.İşlemliYürütücü.java
 * 0.8 / 21 Şub 2021 / 11:24:56
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.kütüphane.yürütücü;

import java.util.concurrent.*;

public class İşlemliYürütücü implements Yürütücü {
	private final int işlemSayısı;
	private final ExecutorService yürütmeHizmeti;
	
	public İşlemliYürütücü(int işlemSayısı) {
		this.işlemSayısı = işlemSayısı;
		this.yürütmeHizmeti = Executors.newFixedThreadPool(işlemSayısı);
	}
	
	public İşlemliYürütücü() {
		this(Runtime.getRuntime().availableProcessors());
	}

	@Override
	public int işlemSayısı() {
		return işlemSayısı;
	}

	@Override
	public void yürüt(Runnable yürütme) {
		yürütmeHizmeti.execute(yürütme);
	}
}
