package org.zerock.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Builder
public class PageRequestDTO {
    
    @Builder.Default
	private int page = 1;
	@Builder.Default
	private int size = 10;

    public void setPage(int page){
        if(page<=0){
            this.page = 1;
        } else {
            this.page = page;
        }
    }

    public void setSize(int size){
        if(size > 100 || size <= 0) {
            this.size = 10;
        } else {
            this.size = size;
        }
    }

    public int getSkip(){
        return (this.page - 1) * this.size;
    }

    // 다음 버튼을 출력하기 위해 필요한 아이템 수
    public int getCountEnd(){
        int temp = (int)(Math.ceil(this.page / 10.0)) * (10 * this.size);

        return temp + 1;
    }

}
