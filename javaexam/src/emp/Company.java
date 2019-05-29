package emp;

public class Company {

	public static void main(String[] args) {
		Employee[] emp = new Employee[2];
		emp[0] = new Secretary("Duke", 1, "secretary", 800);
		emp[1] = new Sales("Tuxi", 2, "sales", 1200);
		printEmployee(emp, false); // 세금 없이 출력

		// 부서에 따른 인센티브 지급
		for (int i = 0; i < emp.length; i++) {
//			if (emp[i] instanceof Sales)
//				((Sales) emp[i]).incentive(100);
//			else
//				((Secretary) emp[i]).incentive(100);
			((Bonus) emp[i]).incentive(100);  //인터페이스를 사용하면 더 편하다!!
		}
		// 인센티브 지급
		System.out.println("\n[인센티브100지급]");

		// 세금포함 출력
		printEmployee(emp, true);
	}

	public static void printEmployee(Employee[] emp, boolean isTax) {
		//세금 받는버전
		if (isTax == true) {
			System.out.println("name\tdepartment\tsalary\ttax\textra pay\t");
			System.out.println("-----------------------------------------------");
			for (int i = 0; i < emp.length; i++) {
				System.out.print(emp[i].getName() + "\t");
				System.out.print(emp[i].getDepartment() + "\t");
				// 줄맞추기
				if (emp[i] instanceof Sales) {
					System.out.print("\t");
				}
				// 줄맞추기
				System.out.print(emp[i].getSalary() + "\t");
				System.out.print(emp[i].tax() + "\t");
				if (emp[i] instanceof Sales) {
					System.out.println(((Sales) emp[i]).getExtraPay());
				} else
					System.out.println();
			}
			//세금 없는버전
		} else {
			System.out.println("name\tdepartment\tsalary\textra pay\t");
			System.out.println("-----------------------------------------");
			for (int i = 0; i < emp.length; i++) {
				System.out.print(emp[i].getName() + "\t");
				System.out.print(emp[i].getDepartment() + "\t");
				// 줄맞추기
				if (emp[i] instanceof Sales) {
					System.out.print("\t");
				}
				// 줄맞추기
				System.out.print(emp[i].getSalary() + "\t");
				if (emp[i] instanceof Sales) {
					System.out.println(((Sales) emp[i]).getExtraPay());
				} else
					System.out.println();
			}
		}

	}

}
