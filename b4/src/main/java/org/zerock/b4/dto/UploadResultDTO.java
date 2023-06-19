package org.zerock.b4.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UploadResultDTO {
    
    private String uuid;
    private String fileName;
    private boolean img;

    public String getLink(){
        if(img){
            return "s_" + uuid + "_" + fileName;
        } else {
            return "default.png";
        }
    }

}
