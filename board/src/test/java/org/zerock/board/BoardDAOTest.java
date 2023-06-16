package org.zerock.board;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.board.dto.BoardDTO;
import org.zerock.board.mappers.BoardMapper;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class BoardDAOTest {
    
    @Autowired (required = false)
    private BoardMapper boardMapper;

    // 목록
    @Test
    public void getListTest(){
        
        List<BoardDTO> list = boardMapper.getList();

        log.info(list);

    }

}
