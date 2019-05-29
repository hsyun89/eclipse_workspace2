package mobile;

public class Ltab extends Mobile {
	public Ltab() {
	}
	public Ltab(String mobileName, int batterySize, String osType) {
		super(mobileName, batterySize, osType);
	}
	public void operate(int time) {
		super.setBatterySize(-10*time); //1분에 -10
	}
	public void charge(int time) {
		super.setBatterySize(10*time); //1분에 +10
	}
}
