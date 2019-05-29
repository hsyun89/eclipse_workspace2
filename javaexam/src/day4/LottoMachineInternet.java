package day4;

public class LottoMachineInternet {
	public static void main(String[] args) {
		int[] numbers = new int[6]; // 6개의 정수를 담는 배열 선언
		 
		// insertCur가 numbers 배열의 길이를 넘지 않을 때까지 반복합니다.
		// 중복이 생긴다면 반복 횟수가 늘어날 수 있습니다.
		for(int insertCur = 0; insertCur < numbers.length ; insertCur++){
		    // 1. 임의의 수 삽입
		    // Math.random()이 제공하는 0.0~0.999...의 수에 45를 곱해
		    // 0.0~44.xx의 수를 만들고 이를 정수로 바꾼다.
		    // 여기에 1을 더해서 1~45가 되도록 한다.
		    numbers[insertCur] = (int)(Math.random() * 45) + 1;
		 
		    // 2. 중복 검사
		    // 배열의 기존 원소(insertCur 이전까지)를
		    // 방금 삽입한 수와 비교해 같은 수가 있다면 insertCur를 앞으로 밀어
		    // 다음 반복에서 같은 칸에 다른 수를 쓰도록 합니다.
		    for(int searchCur = 0; searchCur < insertCur; searchCur ++){
		        if(numbers[insertCur] == numbers[searchCur]){
		            insertCur--; // insertCur를 앞으로 민다
		            break; // 다음 것을 검색할 필요가 없으므로 중복검사 반복을 나갑니다.
		        }
		    }
		}
		 
		// 3. 출력하기
		System.out.println("행운의 번호는 아래와 같습니다:");
		for(int i = 0; i < numbers.length; i ++){
		    if(i > 0){
		        // 맨 처음 원소가 아니라면 앞에 ", "문자열 추가
		        // 1, 2, 3, ..., 6 꼴로 나오게 함
		        System.out.print(", ");
		    }
		    System.out.print(numbers[i]);
		}
	}
}
