package org.zerock.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class) // JUnit4를 사용하여 스프링 테스트 실행
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml") // 스프링 설정 파일 위치 지정
@Log4j // Lombok의 Log4j 어노테이션을 사용하여 로깅 기능 활성화
public class BoardMapperTests {

    @Autowired // 스프링의 의존성 주입 기능을 사용하여 BoardMapper 인터페이스의 구현체 자동 주입
    private BoardMapper mapper;
    
    @Test // 테스트 애너테이션
    public void testGetList() {
        // BoardMapper 인터페이스의 getList 메소드를 테스트. 게시물 목록 조회 기능 검증
        mapper.getList().forEach(board -> log.info(board)); // 조회된 게시물 목록을 로그로 출력
    }
    
    @Test
    public void testInsert() {
        BoardVO board = new BoardVO(); // BoardVO 객체 생성
        board.setTitle("새로 작성하는 글"); // 제목 설정
        board.setContent("새로 작성하는 내용"); // 내용 설정
        board.setWriter("newbie"); // 작성자 설정
        
        mapper.insert(board); // insert 메소드 실행, 게시글 추가
        log.info(board); // 로그에 게시글 정보 출력
    }
    
    @Test
    public void testInsertSelectKey() {
        BoardVO board = new BoardVO(); // BoardVO 객체 생성
        board.setTitle("새로 작성하는 글 select key"); // 제목 설정
        board.setContent("새로 작성하는 내용 select key"); // 내용 설정
        board.setWriter("newbie"); // 작성자 설정
        
        mapper.insertSelectKey(board); // insertSelectKey 메소드 실행, 게시글 추가 및 ID 조회
        log.info(board); // 로그에 게시글 정보 출력   	
    }
    
    @Test
    public void testRead() {
        BoardVO board = mapper.read(25L); // read 메소드 실행, ID가 25인 게시글 조회
        log.info(board); // 로그에 조회된 게시글 정보 출력
    }
    
    @Test
    public void testDelete() {
        // 실행 전 삭제번호 확인
        log.info("DELETE COUNT :" + mapper.delete(32L)); // delete 메소드 실행, ID가 21인 게시글 삭제, 삭제된 행의 수 로그 출력
    }
    
    @Test
    public void testUpdate() {
        BoardVO board = new BoardVO(); // BoardVO 객체 생성
        // 실행 전 존재하는 번호인지 확인할 것
        board.setBno(25L); // 게시글 번호 설정
        board.setTitle("수정된 제목"); // 수정할 제목 설정
        board.setContent("수정된 내용"); // 수정할 내용 설정
        board.setWriter("user00"); // 수정할 작성자 설정
        
        int count = mapper.update(board); // update 메소드 실행, 게시글 정보 업데이트, 업데이트된 행의 수 반환
        log.info("UPDATE COUNT: " + count); // 업데이트된 행의 수 로그 출력
    }
}
