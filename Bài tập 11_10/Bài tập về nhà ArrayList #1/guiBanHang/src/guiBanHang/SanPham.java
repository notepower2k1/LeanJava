package guiBanHang;

public class SanPham {
	private String MaSP,TenSP;
	private float DonGia;
	
	public String getMaSP() {
		return MaSP;
	}
	public void setMaSP(String maSP) {
		MaSP = maSP;
	}
	public String getTenSP() {
		return TenSP;
	}
	public void setTenSP(String tenSP) {
		TenSP = tenSP;
	}
	public float getDonGia() {
		return DonGia;
	}
	public void setDonGia(float donGia) {
		DonGia = donGia;
	}
	
	public SanPham(String maSP, String tenSP, float donGia) {
		MaSP = maSP;
		TenSP = tenSP;
		DonGia = donGia;
	}
	
	public SanPham()
	{
		MaSP = "";
		TenSP = "";
		DonGia = 0;
		
		
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		 return MaSP + " --- " + TenSP + " --- " + DonGia + "\n"
        ;
	}
}
