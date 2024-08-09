package baitap03;

public class NhanVienSanXuat extends NhanVien {
	private double luongCanBan;
	private int soSanPham;

	public NhanVienSanXuat() {
		// TODO Auto-generated constructor stub
	}

	public NhanVienSanXuat(int soSanPham) {
		super();
		this.soSanPham = soSanPham;
	}

	public int getSoSanPham() {
		return soSanPham;
	}

	public void setSoSanPham(int soSanPham) {
		this.soSanPham = soSanPham;
	}

	@Override
	public void inputData() {
		// TODO Auto-generated method stub
		super.inputData();
		while (true) {
			System.out.println("Nhập lương căn bản: ");
			try {
				this.luongCanBan = Double.parseDouble(sc.nextLine());
				if (this.luongCanBan > 0) {
					break;
				} else {
					System.err.println("Lương không âm !!!");
				}
			} catch (Exception e) {
				System.out.println("Ai cho nhập chữ!!!");
			}

		}
		while (true) {
			System.out.println("Nhập số sản phẩm bán ra: ");
			try {
				this.soSanPham = Integer.parseInt(sc.nextLine());
				if (this.soSanPham > 0) {
					break;
				} else {
					System.err.println("Số sản phẩm không âm !!!");
				}
			} catch (Exception e) {
				System.out.println("Ai cho nhập chữ!!!");
			}

		}

	}

	@Override
	public void displayInfo() {
		System.out.printf("|Họ và tên: %-12s|Ngày sinh: %-12s|Lương: %4.1f VND|", super.getHoTen(), super.getNgaySinh(),
				tinhLuong());
		System.out.println("");

	}

	public double tinhLuong() {
		double total = this.luongCanBan + this.soSanPham * 5000;
		return total;
	}
}
