package com.example.finalapp.controller.board;

import com.example.finalapp.dto.board.BoardDetailDTO;
import com.example.finalapp.dto.board.BoardListDTO;
import com.example.finalapp.dto.board.BoardModifyDTO;
import com.example.finalapp.dto.board.BoardWriteDTO;
import com.example.finalapp.dto.page.PageRequestDTO;
import com.example.finalapp.dto.page.PageSetDTO;
import com.example.finalapp.service.board.BoardService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    // 게시물 리스트
    @GetMapping("/list")
    public String list(PageRequestDTO pageRequestDTO, Model model) {
//        List<BoardListDTO> boardList = boardService.findBoardList();
        List<BoardListDTO> listWithPage = boardService.findListWithPage(pageRequestDTO);
        int total = boardService.findTotal();
        PageSetDTO pageSetDTO = new PageSetDTO(total, pageRequestDTO);

        model.addAttribute("boardList", listWithPage);
        model.addAttribute("pageSetDTO", pageSetDTO);
        return "board/list";
    }


    // 게시물 작성
    @GetMapping("/write")
    public String write(HttpSession session) {
        Long memberId = (Long)session.getAttribute("memberId");

        if(memberId == null) {
            return "redirect:/member/login";
        }

        return "board/write";
    }
    // 게시물 작성 후 게시물 리스트 페이지 이동
    @PostMapping("/write")
    public String write(@SessionAttribute("memberId") Long memberId, BoardWriteDTO boardWriteDTO){

        boardWriteDTO.setMemberId(memberId);
        log.info("boardWriteDTO: {}", boardWriteDTO);

        boardService.addBoard(boardWriteDTO);

        return "redirect:/board/list";
    }
    // 게시물 상세보기
    @GetMapping("/detail")
    public String detail(Long boardId, Model model) {
        BoardDetailDTO board = boardService.findBoard(boardId);
        model.addAttribute("board", board);
        return "board/detail";
    }

    // 게시물 삭제
    @GetMapping("/remove")
    public String remove(Long boardId) {
        boardService.removeBoard(boardId);
        return "redirect:/board/list";
    }

    // 게시물 수정
    @GetMapping("/modify")
    public String modify(Long boardId, Model model) {
        BoardDetailDTO board = boardService.findBoard(boardId);
        model.addAttribute("board", board);
        return "board/modify";
    }

    // 게시물 수정 후 게시물 상세페이지 이동
    @PostMapping("/modify")
    public String modify(BoardModifyDTO boardModifyDTO, RedirectAttributes redirectAttributes) {
        log.info("boardModifyDTO: {}", boardModifyDTO);

        redirectAttributes.addAttribute("boardId", boardModifyDTO.getBoardId());
        boardService.updateBoard(boardModifyDTO);
        return "redirect:/board/detail";
    }

}
