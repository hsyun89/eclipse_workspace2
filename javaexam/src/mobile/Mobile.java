package mobile;
//모바일 클래스
public abstract class Mobile {
	private String mobileName;
	private int batterySize;
	private String osType;
//생성자
	public Mobile() {

	}

	public Mobile(String mobileName, int batterySize, String osType) {
		this.mobileName=mobileName;
		this.batterySize=batterySize;
		this.osType=osType;
	}
	//게터세터
	public String getMobileName() {
		return mobileName;
	}

	public void setMobileName(String mobileName) {
		this.mobileName = mobileName;
	}

	public int getBatterySize() {
		return batterySize;
	}

	public void setBatterySize(int batterySize) {
		this.batterySize += batterySize;
	}

	public String getOsType() {
		return osType;
	}

	public void setOsType(String osType) {
		this.osType = osType;
	}
//앱스트랙트
	public abstract void operate(int time);
	public abstract void charge(int time);
}
