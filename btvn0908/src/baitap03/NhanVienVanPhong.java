package baitap03;

public class NhanVienVanPhong extends NhanVien {
	private int soNgayLamViec;
	
	public NhanVienVanPhong() {
		// TODO Auto-generated constructor stub
	}

	public NhanVienVanPhong(int soNgayLamViec) {
		super();
		this.soNgayLamViec = soNgayLamViec;
	}

	public int getSoNgayLamViec() {
		return soNgayLamViec;
	}

	public void setSoNgayLamViec(int soNgayLamViec) {
		this.soNgayLamViec = soNgayLamViec;
	}

	@Override
	public void inputData() {
		// TODO Auto-generated method stub
		super.inputData();
		while (true) {
			System.out.println("Nhập số ngày làm việc: ");
			try {
				this.soNgayLamViec = Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				System.err.println("Ai cho nhập chữ!!");
			}
			
			if(this.soNgayLamViec > 0) {
				break;
			}else {
				System.err.println("Số ngày làm việc không âm!!");
			}
		}
	
	}

	@Override
	public void displayInfo() {
		System.out.printf("|Họ và tên: %-12s|Ngày sinh: %-12s|Lương: %4.1f VND|", super.getHoTen(), super.getNgaySinh(), tinhLuong() );
		System.out.println("");
	}
	
	public double tinhLuong() {
		double total = this.soNgayLamViec * 100000;
		return total;
	}
	
}
