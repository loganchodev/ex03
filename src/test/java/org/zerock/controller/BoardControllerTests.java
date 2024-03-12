package org.zerock.controller;

// Spring과 JUnit을 이용한 테스트 코드 설정
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import org.zerock.domain.BoardVO;
import org.zerock.service.BoardService;

// Lombok의 로그 기능 활용
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class) // JUnit 테스트 실행 방식을 지정
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"}) // 스프링 설정 파일 위치 지정
@Log4j // 로깅을 위한 Lombok 어노테이션 사용
@WebAppConfiguration // 웹 애플리케이션 컨텍스트 사용을 위한 어노테이션
public class BoardControllerTests {
	
	@Autowired // 스프링의 빈 주입
	private WebApplicationContext ctx; // 웹 애플리케이션 컨텍스트
	
	private MockMvc mockMvc; // MockMvc 인스턴스
	
	@Before // 테스트 실행 전에 실행될 메서드 지정
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build(); // MockMvc 인스턴스 초기화
	}
	
	@Test // 테스트 대상을 나타내는 어노테이션
	public void testList() throws Exception{
		log.info(    			      
		    	 mockMvc.perform(MockMvcRequestBuilders.get("/board/list")) // /board/list 경로로 GET 요청
		    			.andReturn() // 요청 결과 반환
		    			.getModelAndView() // ModelAndView 객체 반환
		    			.getModelMap());	// ModelMap 객체 반환하여 로그 출력
	}
	
	@Test // JUnit에서 제공하는 테스트 어노테이션
	public void testRegister() throws Exception{
	    
	    // MockMvc를 사용하여 /board/register 경로로 POST 요청을 보냄
	    // 게시글 등록을 위해 title, content, writer 파라미터를 포함시킴
	    String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/register")
	                               .param("title", "title.....") // title 파라미터 추가
	                               .param("content", "content.....") // content 파라미터 추가
	                               .param("writer", "writer.....")) // writer 파라미터 추가
	                               .andReturn() // 요청의 반환값을 받음
	                               .getModelAndView() // ModelAndView 객체를 가져옴
	                               .getViewName(); // 뷰 이름을 가져옴
	                                   
	    log.info(resultPage); // 결과 페이지의 뷰 이름을 로그로 출력
	}
	
	@Test // JUnit 테스트 케이스를 나타내는 어노테이션
	public void testGet() throws Exception {
	    // mockMvc 객체를 사용하여 '/board/get' 경로로 GET 요청을 실행. 요청 시 'bno' 파라미터에 '33' 값을 전달.
	    log.info(mockMvc.perform(MockMvcRequestBuilders
	                        .get("/board/get") // '/board/get' 경로에 대한 GET 요청을 생성
	                        .param("bno", "33")) // 요청에 'bno' 파라미터를 추가하고, 그 값으로 '33'을 지정
	                        .andReturn() // 요청의 실행 결과를 반환
	                        .getModelAndView() // 반환된 결과에서 ModelAndView 객체를 추출
	                        .getModelMap()); // ModelAndView 객체에서 ModelMap을 추출하여 로그로 출력
	}
	
	@Test // JUnit에서 테스트 메서드임을 나타내는 어노테이션
	public void testModify() throws Exception {
	    // MockMvc를 사용하여 '/board/modify' 경로에 POST 요청을 수행. 게시물 정보를 파라미터로 전달
	    String resultPage = mockMvc
	            .perform(MockMvcRequestBuilders.post("/board/modify") // '/board/modify' 경로에 대한 POST 요청 생성
	                .param("bno", "33") // 수정할 게시물 번호
	                .param("title", "수정된 테스트 새글 제목1") // 수정될 제목
	                .param("content", "수정된 테스트 새글 내용33") // 수정될 내용
	                .param("writer", "user03")) // 작성자
	            	.andReturn().getModelAndView().getViewName(); // 요청 처리 후 반환된 뷰 이름을 가져옴
	                 
	    log.info(resultPage); // 반환된 뷰 이름을 로그로 출력
	}


	


    
}
