package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.BoardVO;

public interface BoardMapper {

    // 게시글 목록 조회 메서드 정의
    // @Select("select * from tbl_board where bno > 0")
    // XML 설정 파일에서 SQL 매핑을 사용하므로, 어노테이션은 주석 처리
    public List<BoardVO> getList();
    
    // 게시글 등록 메서드 정의
    public void insert(BoardVO board);
    
    // 게시글 등록 후 생성된 PK 값을 얻기 위한 메서드 정의
    public void insertSelectKey(BoardVO board);
    
    // 특정 게시글 조회 메서드 정의
    public BoardVO read(Long bno);
    
    // 게시글 삭제 메서드 정의, 삭제된 행의 수를 반환
    public int delete(Long bno);
    
    // 게시글 수정 메서드 정의, 수정된 행의 수를 반환
    public int update(BoardVO board);
}
