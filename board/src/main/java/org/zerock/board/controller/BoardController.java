package org.zerock.board.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.board.dto.BoardDTO;
import org.zerock.board.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/board/")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;
    
    // 목록
    @GetMapping("list")
    public void getList(Model model){
        log.info("list...............");

        List<BoardDTO> list = boardService.getList();

        model.addAttribute("list", list);
    }

    // 등록
    @PostMapping("regist")
    public String register(BoardDTO boardDTO){
        
        boardService.insert(boardDTO);

        return "redirect:/board/list";
    }

    // 등록 폼
    @GetMapping("regist")
    public void registForm(){
        log.info("GET registForm.................");
    }


    // 조회
    @GetMapping("read/{bno}")
    public String readPage(@PathVariable int bno, Model model){
        
        log.info("GET read................");

        BoardDTO dto = boardService.read(bno);
        model.addAttribute("board", dto);

        return "/board/read";

    }


    // 삭제
    @PostMapping("delete/{bno}")
    public String deleteBoard(@PathVariable int bno){
        
        boardService.delete(bno);

        return "redirect:/board/list";

    }

}
