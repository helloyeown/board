package org.zerock.board.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.board.dto.BoardDTO;
import org.zerock.board.mappers.BoardMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    
    private final BoardMapper boardMapper;


    // 목록
    @Override
    public List<BoardDTO> getList() {
        return boardMapper.getList();
    }

    // 등록
    @Override
    public int insert(BoardDTO dto) {
        
        return boardMapper.regist(dto);

    }

    // 조회
    @Override
    public BoardDTO read(int bno) {

        return boardMapper.getOne(bno);

    }

    @Override
    public void delete(int bno) {

        boardMapper.delete(bno);

    }


}
