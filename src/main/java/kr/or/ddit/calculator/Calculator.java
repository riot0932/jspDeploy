package kr.or.ddit.calculator;

public class Calculator {
	
	public static void main(String[] args) {
		Calculator cal = new Calculator();
		
		//덧셈
		int addResult = cal.add(5,6);
		if(addResult == 11){
			System.out.println("덧셈결과가 올바릅니다.");
		}else{
			System.out.println("덧셈결과가 틀렸습니다.");
			
		}
		//////////////////////////////////////////////
		//뺄셈
		int minusResult = cal.minus(6,4);
		if(minusResult == 2){
			System.out.println("뺄셈 결과가 올바릅니다.");
		}else {
			System.out.println("뺄셈 결과가 틀렸습니다.");
			
		}
		
		//////////////////////////////////////////////
		//mul : 곱하기 ,div : 나누기
		
		int mulResult = cal.mul(2,2);
		if(mulResult == 4){
			System.out.println("곱셈 결과가 올바릅니다.");
		}else{
			System.out.println("곱셈 결과가 틀렸습니다.");
		}
		
		
		int divResult = cal.div(10,2);
		if(divResult == 5){
			System.out.println("나눗셈 결과가 올바릅니다.");
		}else {
			System.out.println("나눗셈 결과가 틀렸습니다.");
		}
	}


	/**
	* Method : div
	* 최초작성일 : 2018. 7. 6.
	* 작성자 : PC15
	* 변경이력 :
	* @param param1
	* @param param2
	* @return
	* Method 설명 :
	*/
	public int div(int param1, int param2) {
		return param1 / param2;
	}


	/**
	* Method : mul
	* 최초작성일 : 2018. 7. 6.
	* 작성자 : PC15
	* 변경이력 :
	* @param param1
	* @param param2
	* @return
	* Method 설명 :
	*/
	public int mul(int param1, int param2) {
		
		return param1 * param2;
	}


	/**
	* Method : add
	* 최초작성일 : 2018. 7. 6.
	* 작성자 : PC15
	* 변경이력 :
	* @param param1
	* @param param2
	* @return
	* Method 설명 : 
	*/
	public int add(int param1, int param2) {
		return param1 + param2;
	}
	
	/**
	* Method : minus
	* 최초작성일 : 2018. 7. 6.
	* 작성자 : PC15
	* 변경이력 :
	* @param param1
	* @param param2
	* @return
	* Method 설명 :
	*/
	public int minus(int param1, int param2) {
		
		return param1 - param2;
	}
	

}
