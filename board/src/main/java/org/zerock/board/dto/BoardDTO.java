package org.zerock.board.dto;

import groovy.transform.ToString;
import groovy.transform.builder.Builder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Builder
public class BoardDTO {
    
    private int bno;
    private String title;
    private String content;
    private String writer;
    private String dueDate;
    private String updateDate;

}
