package org.zerock.board.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.zerock.board.dto.BoardDTO;

@Transactional
public interface BoardService {

    // 목록
    public List<BoardDTO> getList();

    // 등록
    public int insert(BoardDTO dto);

    // 조회
    public BoardDTO read(int bno);

    // 삭제
    public void delete(int bno);
    
}
