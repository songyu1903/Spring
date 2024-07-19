package com.example.finalapp.service.board;

import com.example.finalapp.dto.board.BoardDetailDTO;
import com.example.finalapp.dto.board.BoardListDTO;
import com.example.finalapp.dto.board.BoardModifyDTO;
import com.example.finalapp.dto.board.BoardWriteDTO;
import com.example.finalapp.dto.page.PageRequestDTO;
import com.example.finalapp.mapper.board.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {
    private final BoardMapper boardMapper;

    public void addBoard(BoardWriteDTO boardWriteDTO){
        boardMapper.insertBoard(boardWriteDTO);
    }

    public void removeBoard(Long boardId){
        boardMapper.deleteBoard(boardId);
    }

    public void updateBoard(BoardModifyDTO boardModifyDTO){
        boardMapper.updateBoard(boardModifyDTO);
    }

    public BoardDetailDTO findBoard(Long boardId){
        return boardMapper.selectBoard(boardId)
                .orElseThrow(() -> new IllegalStateException("존재하지 않는 게시물 정보"));
    }

    public List<BoardListDTO> findBoardList(){
        return boardMapper.selectList();
    }

    public List<BoardListDTO> findListWithPage(PageRequestDTO pageRequestDTO){
        return boardMapper.selectListWithPage(pageRequestDTO);
    }
    public int findTotal(){
        return boardMapper.selectTotal();
    }

}
