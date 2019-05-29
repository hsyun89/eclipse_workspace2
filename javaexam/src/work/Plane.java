package work;

public abstract class Plane {
	private String planeName;
	private int fuelSize;

	// 생성자
	Plane() {
	}

	Plane(String planeName, int fuelSize) {
		this.planeName = planeName;
		this.fuelSize = fuelSize;
	}

	// 게터세터
	public String getPlaneName() {
		return planeName;
	}

	public void setPlaneName(String planeName) {
		this.planeName = planeName;
	}

	public int getFuelSize() {
		return fuelSize;
	}

	public void setFuelSize(int fuelSize) {
		this.fuelSize += fuelSize;
	}

	// 연료충전
	public void reFuel(int fuel) {
		fuelSize += fuel;
	}

	// 앱스트랙트
	public abstract void flight(int distance);

}
