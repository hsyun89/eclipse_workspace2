package porb1;

public class Target {
	static int[] nums;
	static int tar;

	public static void main(String[] args) {
		int[] numbers = { 1, 2, 3 };
		System.out.println(solution(numbers, 2));
	}

	public static int solution(int[] numbers, int target) {
		int answer = 0;
		nums = numbers;
		tar = target;
		answer += bfs(0, 0, 1);
		answer += bfs(0, 0, -1);
		return answer;
	}

	public static int bfs(int sum, int index, int flag) {
		int answer = 0;
		sum += nums[index] * flag;
		if (index == nums.length - 1) {
			if (sum == tar)
				return 1;
		} else {
			index++;
			answer += bfs(sum, index, 1);
			answer += bfs(sum, index, -1);
		}
		return answer;
	}
}

// 프로그래머스 풀이
//class Solution {
//    public int solution(int[] numbers, int target) {
//        int answer = 0;
//        answer = dfs(numbers, 0, 0, target);
//        return answer;
//    }
//    int dfs(int[] numbers, int n, int sum, int target) {
//        if(n == numbers.length) {
//            if(sum == target) {
//                return 1;
//            }
//            return 0;
//        }
//        return dfs(numbers, n + 1, sum + numbers[n], target) + dfs(numbers, n + 1, sum - numbers[n], target);
//    }
//}
