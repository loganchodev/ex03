package org.zerock.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
    // MyBatis 어노테이션을 사용하여 SQL 쿼리를 정의
    @Select("SELECT sysdate FROM dual")
    // 현재 시스템의 날짜와 시간을 조회하는 SQL 쿼리를 실행
    public String getTime(); // 데이터베이스로부터 현재 시간을 문자열로 가져오는 메서드
}

