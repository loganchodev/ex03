package org.zerock.persistence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.mapper.TimeMapper;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class) // 스프링의 테스트 지원 클래스와 JUnit 사이의 연결을 위해 사용
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml") // 스프링 설정 파일 위치 지정
@Log4j // 로깅을 위해 Lombok의 Log4j 어노테이션 사용
public class TimeMapperTests {
 
    @Autowired // 스프링 컨테이너가 TimeMapper 타입의 빈을 자동으로 주입
    private TimeMapper timeMapper;
    
    @Test // JUnit으로 이 메소드를 테스트 케이스로 인식하도록 함
    public void testGetTime() {
        // TimeMapper의 구현 클래스 이름과 현재 시간 정보를 로그로 출력
        log.info(timeMapper.getClass().getName()); // TimeMapper 구현체의 클래스 이름 로깅
        log.info(timeMapper.getTime()); // DB에서 조회한 현재 시간을 로깅
    }
}
