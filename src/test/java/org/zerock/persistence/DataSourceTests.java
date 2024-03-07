package org.zerock.persistence;
import static org.junit.Assert.fail;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class) // 스프링과 함께 JUnit을 사용하기 위해 설정
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml") // 스프링 설정 파일 위치 지정
@Log4j // 로그를 위한 Lombok 어노테이션
public class DataSourceTests {

    @Autowired // 스프링이 자동으로 bean을 주입
    private DataSource dataSource; // 데이터 소스 객체
    
    @Autowired
	private SqlSessionFactory sqlSessionFactory;

    @Test // JUnit에서 테스트 메서드임을 나타냄
    public void testConnection() {
        // 데이터베이스 연결 테스트
        try (Connection con = dataSource.getConnection()) {
            // 데이터 소스를 통해 DB 연결을 시도하고 연결 객체를 얻음
            log.info(con); // 연결 정보 로깅
        } catch (Exception e) {
            fail(e.getMessage()); // 연결 실패 시 테스트를 실패로 표시
        }
    }
    
    @Test
	public void mybatisConnection() {
		// MyBatis SqlSessionFactory를 사용하여 데이터베이스 연결을 시도하는 메서드
		try (SqlSession session = sqlSessionFactory.openSession(); Connection con = session.getConnection()) {
			log.info("session >>>>> " + session);
			log.info("con >>>>> " + con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
