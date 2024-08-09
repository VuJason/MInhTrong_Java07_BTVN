package baitap01;

public class DemoApplication {
	public static void main(String[] args) {
		PhanSo ps = new PhanSo();
		ps.inputData();
		ps.displayInfo(ps.Cong(ps.getTuSo(), ps.getMauSo()), "+");
		ps.displayInfo(ps.Tru(ps.getTuSo(), ps.getMauSo()), "-");
		ps.displayInfo(ps.Nhan(ps.getTuSo(), ps.getMauSo()), "x");
		ps.displayInfo(ps.Chia(ps.getTuSo(), ps.getMauSo()), ":");
		
	}
}
