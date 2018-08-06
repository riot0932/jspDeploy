package kr.or.ddit.cookie.util;

public class CookieUtil {

	/**
	* Method : getCookie
	* 최초작성일 : 2018. 7. 6.
	* 작성자 : PC15
	* 변경이력 :
	* @param cookie
	* @param name
	* @return
	* Method 설명 : 쿠키 조회
	*/
	public String getCookie(String cookie, String name) {
		//cookie : "userId=brown; rememberMe=y"
		
		String[] cookies = cookie.split("; ");
		String cookieResult = "";
		
//		for(int i = 0; i <split.length; i++){
//			System.out.println(split[i]);
//			
//		}
		for(String cookieStr : cookies){
			String[] cookieNameValue = cookieStr.split("=");
			
			String cookieName = cookieNameValue[0];
			String cookueValue = cookieNameValue[1];
			
			if(name.equals(cookieName)){
				cookieResult = cookueValue;
				break;
			}
		}
		
		return cookieResult;
	}

}
