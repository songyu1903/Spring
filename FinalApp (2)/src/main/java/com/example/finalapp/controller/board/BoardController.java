package com.example.finalapp.controller.board;

import com.example.finalapp.dto.board.BoardDetailDTO;
import com.example.finalapp.dto.board.BoardListDTO;
import com.example.finalapp.dto.board.BoardModifyDTO;
import com.example.finalapp.dto.board.BoardWriteDTO;
import com.example.finalapp.dto.page.PageRequestDTO;
import com.example.finalapp.dto.page.PageSetDTO;
import com.example.finalapp.service.board.BoardService;
import jakarta.servlet.http.HttpSession;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/list")
    public String list(PageRequestDTO pageRequestDTO, Model model){
//        List<BoardListDTO> list = boardService.findList();
        List<BoardListDTO> list = boardService.findListWithPage(pageRequestDTO);
        int total = boardService.findTotal();
        PageSetDTO pageSetDTO = new PageSetDTO(total, pageRequestDTO);


        model.addAttribute("list", list);
        model.addAttribute("pageSetDTO", pageSetDTO);

        return "board/list";
    }

    @GetMapping("/detail")
    public String detail(Long boardId, Model model){
        BoardDetailDTO board = boardService.findBoard(boardId);
        model.addAttribute("board", board);
        return "board/detail";
    }

    @GetMapping("/write")
    public String write(HttpSession session){

        Long memberId = (Long)session.getAttribute("memberId");

        if(memberId == null){
            return "redirect:/member/login";
        }

        return "board/write";
    }

    @PostMapping("/write")
    public String write(BoardWriteDTO boardWriteDTO,
                        @SessionAttribute("memberId") Long memberId,
                        @RequestParam("boardFile") List<MultipartFile> files){
        boardWriteDTO.setMemberId(memberId);
        log.info("boardWriteDTO: {}", boardWriteDTO);

//        boardService.addBoard(boardWriteDTO);
        try {
            boardService.addBoardWithFiles(boardWriteDTO, files);
        } catch (IOException e) {
            log.error(e.getMessage());
            return "redirect:/board/write";
        }

        return "redirect:/board/list";
    }

    @GetMapping("/remove")
    public String remove(Long boardId){
        boardService.removeBoard(boardId);

        return "redirect:/board/list";
    }

    @GetMapping("/modify")
    public String modify(Long boardId, Model model){
        BoardDetailDTO board = boardService.findBoard(boardId);
        model.addAttribute("board", board);

        return "board/modify";
    }

    @PostMapping("/modify")
    public String modify(BoardModifyDTO boardModifyDTO, RedirectAttributes redirectAttributes) {
        log.info("boardModifyDTO : {}", boardModifyDTO);

        boardService.modifyBoard(boardModifyDTO);

        redirectAttributes.addAttribute("boardId", boardModifyDTO.getBoardId());

        return "redirect:/board/detail";
    }

}










