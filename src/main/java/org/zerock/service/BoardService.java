package org.zerock.service;

import java.util.List;
import org.zerock.domain.BoardVO;

public interface BoardService {
	
    // 게시물을 등록하기 위한 메서드. BoardVO 객체를 매개변수로 받음
    public void register(BoardVO board);
    
    // 특정 게시물을 조회하기 위한 메서드. 게시물 번호(Long)를 매개변수로 받고, BoardVO 객체를 반환함
    public BoardVO get(Long bno);
    
    // 게시물을 수정하기 위한 메서드. 수정할 정보가 담긴 BoardVO 객체를 매개변수로 받고, 성공 여부를 boolean으로 반환함
    public boolean modify(BoardVO board);
    
    // 특정 게시물을 삭제하기 위한 메서드. 게시물 번호(Long)를 매개변수로 받고, 성공 여부를 boolean으로 반환함
    public boolean remove(Long bno);
    
    // 모든 게시물의 목록을 조회하기 위한 메서드. 조회된 게시물 목록(List<BoardVO>)을 반환함
    public List<BoardVO> getList();
   
}
