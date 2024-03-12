package org.zerock.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller // 컨트롤러 선언
@Log4j // 로깅을 위한 Lombok 어노테이션
//@AllArgsConstructor // 모든 필드 값을 매개변수로 받는 생성자를 생성하는 Lombok 어노테이션, 현재는 비활성화 상태
@RequestMapping("/board/*") // '/board/'로 시작하는 모든 요청을 처리
@RequiredArgsConstructor // final이나 @NonNull 필드만을 매개변수로 받는 생성자를 생성
public class BoardController {
        
	// @Autowired // 스프링의 의존성 주입 어노테이션, 현재는 Lombok으로 대체되어 비활성화 상태
    private final BoardService boardService; // 게시판 서비스 의존성 주입
    @GetMapping("/list") // '/list' 경로로 GET 요청을 처리
    public void list(Model model) { // 모델에 데이터를 추가하여 뷰로 전달
        log.info("list..............."); // 리스트 로깅
        model.addAttribute("list", boardService.getList()); // 게시판 목록을 모델에 추가
    }
        
}
