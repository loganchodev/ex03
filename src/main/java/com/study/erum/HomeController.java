package com.study.erum;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 애플리케이션 홈 페이지에 대한 요청을 처리하는 컨트롤러.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	// 로거 인스턴스 초기화
	
	/**
	 * 홈 뷰를 렌더링하기 위해 그 이름을 반환함으로써 홈 페이지 요청을 처리함.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		// 홈 페이지 경로("/")에 대한 GET 요청을 처리
		logger.info("Welcome home! The client locale is {}.", locale);
		// 클라이언트의 로케일 정보를 로깅
		
		Date date = new Date();
		// 현재 날짜와 시간을 가져옴
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		// 로케일에 맞는 날짜/시간 형식을 가져옴
		
		String formattedDate = dateFormat.format(date);
		// 현재 날짜/시간을 지정된 형식으로 포맷팅
		
		model.addAttribute("serverTime", formattedDate );
		// 모델에 "serverTime" 속성으로 포맷된 날짜/시간을 추가. 이 값은 뷰에서 사용됨
		
		return "home";
		// "home" 뷰 이름을 반환하여 홈 페이지 뷰를 렌더링
	}
	
}
