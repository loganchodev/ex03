package org.zerock.persistence;
import static org.junit.Assert.fail;
import java.sql.Connection;
import java.sql.DriverManager;
import org.junit.Test;
import lombok.extern.log4j.Log4j;

@Log4j // 로깅을 위한 Lombok 어노테이션 적용
public class JDBCTests {

    static {
        // 클래스 로딩 시 오라클 JDBC 드라이버 로드
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (Exception e) {
            // 드라이버 로드 실패 시 예외 출력
            e.printStackTrace();
        }
    }

    @Test // JUnit 테스트 메서드
    public void testConnection() {
        // 데이터베이스 연결 테스트
        try (Connection con = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:XE", // DB 연결 URL
                "book_ex", // 사용자 이름
                "1234")) { // 비밀번호

            log.info(con); // 연결 성공 시 로그 출력
        } catch (Exception e) {
            fail(e.getMessage()); // 연결 실패 시 테스트 실패
        }
    }

}
