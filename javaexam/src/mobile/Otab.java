package mobile;

public class Otab extends Mobile {
	public Otab() {
	}
	public Otab(String mobileName, int batterySize, String osType) {
		super(mobileName, batterySize, osType);
	}
	public void operate(int time) {
		super.setBatterySize(-12*time); //-12/1분 사용
	}
	public void charge(int time) {
		super.setBatterySize(8*time); // 8/1분 충전
	}
}
