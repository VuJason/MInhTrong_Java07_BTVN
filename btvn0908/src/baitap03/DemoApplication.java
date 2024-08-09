package baitap03;

public class DemoApplication {
	public static void main(String[] args) {
		NhanVien nv1 = new NhanVienSanXuat();
		nv1.inputData();
		nv1.displayInfo();
		
		NhanVien nv2 = new NhanVienVanPhong();
		nv2.inputData();
		nv2.displayInfo();
		
	}
}
