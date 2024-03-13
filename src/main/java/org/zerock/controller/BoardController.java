package org.zerock.controller;

import java.util.List;

// 스프링 MVC 컨트롤러 관련 기본 설정
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.service.BoardService;

// Lombok 어노테이션으로 필요한 코드(생성자, 로그 등) 자동 생성
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller // 이 클래스를 웹 요청을 처리하는 컨트롤러로 등록
@Log4j // 로깅을 위한 Lombok 어노테이션
@RequestMapping("/board/*") // 이 컨트롤러의 기본 경로 설정
@RequiredArgsConstructor // final 또는 @NonNull 필드에 대한 생성자 자동 생성(Lombok)
public class BoardController {

    // 스프링이 관리하는 Bean 주입(BoardService)
    private final BoardService boardservice;
    
    @GetMapping("/list") // /board/list 경로에 대한 GET 요청을 처리
    public void list(Model model) {
        log.info("list..............."); // 로그 출력
        List<BoardVO> list = boardservice.getList(); // 게시물 목록 조회
        
        list.forEach(board -> log.info(board)); // 조회된 게시물 로깅
        model.addAttribute("list", list); // 모델에 게시물 목록 추가
    }
    
    @PostMapping("/register") // /board/register 경로에 대한 POST 요청을 처리
    public String register(BoardVO vo, RedirectAttributes rttr) {
        log.info("register......." + vo); // 등록 로그 출력
        
        boardservice.register(vo); // 게시물 등록
        
        rttr.addFlashAttribute("result", vo.getBno()); // RedirectAttributes를 사용하여 등록된 게시물의 번호 전달
        return "redirect:/board/list"; // 게시물 목록 페이지로 리다이렉트
    }
        
    @GetMapping("/get") // '/get' 경로에 대한 GET 요청을 처리하는 메소드
    public void testget(@RequestParam("bno") Long bno, Model model) {
        log.info("/get : " + bno); // 요청받은 게시글 번호를 로깅

        BoardVO vo = boardservice.get(bno); // 요청받은 번호에 해당하는 게시글 정보를 조회
        
        log.info(vo); // 조회된 게시글 정보를 로깅
        
        model.addAttribute("board", boardservice.get(bno)); // 조회된 게시글 정보를 모델에 추가. 뷰에서 사용할 수 있도록 함
    }
    
    @PostMapping("/modify") // '/modify' 경로에 대한 POST 요청을 처리하는 메서드
    public String modify(BoardVO board, RedirectAttributes rttr) {
        log.info("modify:" + board); // 수정 작업 로그 기록. board 객체의 정보를 출력
        
        if(boardservice.modify(board)) { // boardservice의 modify 메서드를 호출하여 게시물 수정 시도
            rttr.addFlashAttribute("result", "success"); // 수정이 성공하면, 리다이렉트 시 'result'라는 이름으로 'success' 메시지 전달
        }
        return "redirect:/board/list"; // 수정 작업 후 게시물 목록 페이지로 리다이렉션
    }

    @PostMapping("/remove")
    public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr ) {
   	    log.info("remove...." +bno);
   	   
   	    if(boardservice.remove(bno)) {
   	    	rttr.addFlashAttribute("result", "success");
   	    }
   	    return "redirect:/board/list";
    }
}
