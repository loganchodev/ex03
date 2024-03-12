package org.zerock.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j // Lombok 라이브러리를 이용해 로그 기능을 클래스에 추가
@Service // 스프링의 Service 계층을 나타내며, 이 클래스를 빈으로 등록
@AllArgsConstructor // Lombok 라이브러리로 모든 필드 값을 파라미터로 받는 생성자를 자동 생성
public class BoardServiceImpl implements BoardService{
	
	@Autowired // 스프링의 의존성 주입 기능을 이용해 BoardMapper 인터페이스 타입의 빈을 자동 주입
	private BoardMapper mapper;

	@Override
	public void register(BoardVO board) {
	    // 게시물 등록 기능 구현
	    log.info("register....." + board); // 등록하는 게시물 정보를 로깅
	    mapper.insertSelectKey(board); // mapper를 사용해 게시물을 데이터베이스에 등록하고, 등록된 게시물의 키(일반적으로는 ID)를 조회
	}

	@Override
	public BoardVO get(Long bno) {
	    log.info("get....." + bno); // 특정 게시물 조회 로그 출력, 조회하려는 게시물 번호(bno) 포함
	    return mapper.read(bno); // BoardMapper 인터페이스의 read 메서드를 호출하여 특정 번호(bno)의 게시물 정보를 조회하고, 조회된 BoardVO 객체 반환
	}


	@Override
	public boolean modify(BoardVO board) {
	    log.info("modify.... " + board);
	    return mapper.update(board)==1;
	}

	@Override
	public boolean remove(Long bno) {
		log.info("remove...." + bno);
	    return mapper.delete(bno)==1;
	}
	
	@Override
	public List<BoardVO> getList() {
	    log.info("getList....."); // getList 메서드 호출 시 로깅
	    return mapper.getList(); // BoardMapper 인터페이스의 getList 메서드를 호출하여 게시글 목록을 조회하고 반환
	}	

}
