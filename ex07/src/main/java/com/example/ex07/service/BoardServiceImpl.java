package com.example.ex07.service;

import com.example.ex07.dto.BoardDTO;
import com.example.ex07.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final BoardMapper boardMapper;

    @Override
    public List<BoardDTO> findBoardList() {
        List<BoardDTO> boardList = boardMapper.selectAll();
        return boardList;
    }

    @Override
    public BoardDTO findBoardDetail(Long boardId) {
        boardMapper.updateViewCnt(boardId);

//        BoardDTO boardDTO = boardMapper.selectBoard(boardId);
        Optional<BoardDTO> opt = boardMapper.selectOne(boardId);
        BoardDTO boardDTO =
                opt.orElseThrow(() -> new IllegalStateException("존재하지 않는 게시물 번호"));

        return boardDTO;
    }

}
