package baitap04;

public class Oto extends PhuongTienGiaoThong {
	private int n;
	private Oto[] oto;

	public Oto() {
		// TODO Auto-generated constructor stub
	}

	public Oto(String hangSanXuat, String tenPhuongTien, int namSanXuat, double vanTocToiDa) {
		super(hangSanXuat, tenPhuongTien, namSanXuat, vanTocToiDa);// hangSanXuat, tenPhuongTien, namSanXuat,
																	// VanTocToiDa//
		this.oto = new Oto[n];
	}

	public void inputAndShowData() {
		// TODO Auto-generated method stub
		int n;
		System.out.println("Nhập số oto bạn muốn nhập: ");
		n = Integer.parseInt(sc.nextLine());
		oto = new Oto[n];
		for (int i = 0; i < oto.length; i++) {
			System.out.println("xe số #" + (i + 1) + "/" + oto.length);
			super.inputData();
			oto[i] = new Oto(getHangSanXuat(), getTenPhuongTien(), getNamSanXuat(), getVanTocToiDa());
		}

		System.out.println("Thông tin các xe đã nhập: ");
		for (int i = 0; i < oto.length; i++) {
			oto[i].displayInfo();
		}

	}

	public void cungVanToc() {
		System.out.println("Nhập vận tốc của xe mà bạn muốn tìm: ");
		double timVanToc = Double.parseDouble(sc.nextLine());
		System.out.println("Thông tin các xe cùng vận tốc: ");
		for (int i = 0; i < oto.length; i++) {
			if (oto[i].getVanTocToiDa() == timVanToc) {
				oto[i].displayInfo();
			}
		}

	}

}
