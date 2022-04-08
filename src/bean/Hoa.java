package bean;

public class Hoa {
	private int idHoa;
	private String tenHoa;
	private int soLuong;
	private int giaBan;
	public Hoa() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdHoa() {
		return idHoa;
	}
	public void setIdHoa(int idHoa) {
		this.idHoa = idHoa;
	}
	public String getTenHoa() {
		return tenHoa;
	}
	public void setTenHoa(String tenHoa) {
		this.tenHoa = tenHoa;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public int getGiaBan() {
		return giaBan;
	}
	public void setGiaBan(int giaBan) {
		this.giaBan = giaBan;
	}
	public Hoa(int idHoa, String tenHoa, int soLuong, int giaBan) {
		super();
		this.idHoa = idHoa;
		this.tenHoa = tenHoa;
		this.soLuong = soLuong;
		this.giaBan = giaBan;
	}
	@Override
	public String toString() {
		return "Hoa [idHoa=" + idHoa + ", tenHoa=" + tenHoa + ", soLuong=" + soLuong + ", giaBan=" + giaBan + "]";
	}
	
}
