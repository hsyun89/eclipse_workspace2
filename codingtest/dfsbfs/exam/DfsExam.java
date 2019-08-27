package exam;

public class DfsExam {
	// 노드의 수
	int n = 7;
	int arr[][] = { { 0, 0, 0, 0, 0, 0, 0, 0 }, 
			{ 0, 0, 1, 1, 0, 0, 0, 0 }, 
			{ 0, 1, 0, 0, 1, 1, 0, 0 },
			{ 0, 1, 0, 0, 0, 0, 0, 0 }, 
			{ 0, 0, 1, 0, 0, 0, 0, 1 }, 
			{ 0, 0, 1, 0, 0, 0, 1, 0 },
			{ 0, 0, 0, 0, 0, 1, 0, 0 }, 
			{ 0, 0, 0, 0, 1, 0, 0, 0 } };
	// 탐색한 곳을 확인하기 위함
	int[] f = new int[n + 1];
	public static void main(String[] args) {
		new DfsExam().seach(1);
		System.out.println("end");
	}
	public void seach(int i) {
		f[i] = 1;
		for (int j = 1; j <= n; j++) {
			if (arr[i][j] == 1 && f[j] == 0) {
				System.out.println(i + " -> " + j);
				seach(j);
			}
		}
	}
}
