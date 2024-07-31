package baitap123;

public class DemoApplicatioin {
	public static void main(String[] args) {
		HocSinh hocSinh1 = new HocSinh();
		hocSinh1.inputData();
		hocSinh1.exportInformation();
		hocSinh1.caculateAverage();
		
		
		XeHoi xehoi1 = new XeHoi();
		xehoi1.inputData();
		xehoi1.showInformation();
		
		
		TroChoi troChoi1 = new TroChoi();
		troChoi1.setName("Bắn súng");
		troChoi1.setTurn(4);
		troChoi1.batDau();
		troChoi1.ketThuc();
	}
}
