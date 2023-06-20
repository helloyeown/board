package org.zerock.board.mappers;

import java.util.List;

import org.zerock.board.dto.BoardDTO;

public interface BoardMapper {
    
    List<BoardDTO> getList();

    int regist(BoardDTO boardDTO);

    BoardDTO getOne(int bno);

}
