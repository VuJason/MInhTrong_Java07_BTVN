package baitap02;

public class DemoApplication {
	public static void main(String[] args) {
		VanDongVien vdv1 = new VanDongVien();
		vdv1.inputData();
		vdv1.displayInfo();
		
		VanDongVien vdv2 = new VanDongVien();
		vdv2.inputData();
		vdv2.displayInfo();
		
		if (vdv1.lonHon(vdv2)) {
			System.out.println(vdv1.getHoTen()+ " lớn hơn " +vdv2.getHoTen());
		}else {
			System.out.println(vdv2.getHoTen()+ " lớn hơn " +vdv1.getHoTen());
		}
	}
}
