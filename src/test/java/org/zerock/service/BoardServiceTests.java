package org.zerock.service;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.persistence.DataSourceTests;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class) // SpringJUnit4ClassRunner를 사용하여 Spring 테스트 환경에서 JUnit 테스트 실행
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml") // Spring 설정 파일 위치 지정
@Log4j // Lombok의 Log4j를 사용하여 로깅 기능 활성화
public class BoardServiceTests {
    @Autowired // Spring의 의존성 주입 기능을 사용하여 BoardService 인터페이스의 구현체 자동 주입
    private BoardService service;
    
//    @Test 
//    public void testExist() {
//        log.info(service); // 로그를 통해 service 객체의 참조값 출력
//        assertNotNull(service); // service 객체가 null이 아님을 검증, null인 경우 테스트 실패
//    } 
    
//    @Test
//    public void testRegister() {
//         BoardVO board = new BoardVO();
//         board.setTitle("새로 시작하는 글");
//         board.setContent("새로 작성하는 내용");
//         board.setWriter("newbie");
//         service.register(board);		
//         log.info("생성된 게시물의 번호: " +  board.getBno());
//    }
    
//    @Test
//    public void testGetList() {
//       service.getList().forEach(board ->log.info(board));
//    }
    
//    @Test
//    public void testGet() {
//        log.info(service.get(22L));
//    }    
    
    @Test
    public void testUpdate() {
    	// 번호가 있는지 확인
    	BoardVO board = service.get(15L);

    	if (board == null) {
    			return;
    	}

    	board.setTitle("제목 수정합니다.");
    	log.info("MODIFY RESULT: " + service.modify(board));
    }
}