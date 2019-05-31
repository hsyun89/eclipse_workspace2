package codeTest;

class Solution {
  public int[] solution(int[] arr) {
	  if(arr.length==1) {
		  int[] answer = {-1};
			return answer;
	  }
	  else {
	  //최소값구하기
	  int min = arr[0];
	  for(int i=1;i<arr.length; i++) {
		  if (min>arr[i]) {
			  min=arr[i];
		  }
	  }
	  //넣기
	  int[] arr2= new int[arr.length-1];
	  for(int i=0;i<arr.length; i++) {
		  if (min<arr[i]) {
			  for(int j=0;j<arr.length-1;j++) {
			  arr2[j]=arr[i];
			  }
		  }
	  }
      int[] answer = arr2;
  		return answer;
	  }
  }
}
