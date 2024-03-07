package org.zerock.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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

}