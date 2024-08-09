package baitap04;

import java.util.Scanner;

public class DemoApplication {
	public static void main(String[] args) {
		PhuongTienGiaoThong ptgt = new PhuongTienGiaoThong();
		ptgt.inputData();
		ptgt.displayInfo();

		Oto oto = new Oto();
		oto.inputAndShowData();
		oto.cungVanToc();
	}

}
