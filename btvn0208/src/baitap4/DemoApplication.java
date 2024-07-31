package baitap4;

public class DemoApplication {
	public static void main(String[] args) {
		PhuongTienGiaoThong p1 = new PhuongTienGiaoThong();
		p1.setManufacturer("Honda");
		p1.setColor("Màu Trắng");
		p1.setYear(2021);
		p1.showInfo();
		
		XeHoi xeHoi1 = new XeHoi();
		xeHoi1.setManufacturer("Mercedez-Benz");
		xeHoi1.setColor("Màu Đen");
		xeHoi1.setYear(2024);
		xeHoi1.showInfo();
		
		XeMay xeMay1 = new XeMay();
		xeMay1.inputData();
		xeMay1.showInfo();
	}
}
