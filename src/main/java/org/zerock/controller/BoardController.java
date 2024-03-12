package org.zerock.controller;

import java.util.List;

// 스프링 MVC 컨트롤러 관련 기본 설정
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.service.BoardService;

// Lombok 어노테이션으로 필요한 코드(생성자, 로그 등) 자동 생성
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller // 이 클래스를 웹 요청을 처리하는 컨트롤러로 등록
@Log4j // 로깅을 위한 Lombok 어노테이션
@RequestMapping("/board") // 이 컨트롤러의 기본 경로 설정
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
    
}
