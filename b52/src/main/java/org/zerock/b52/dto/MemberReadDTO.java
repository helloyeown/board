package org.zerock.b52.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MemberReadDTO {
    
    private String email;
	private String mpw;
	private String mname;

	private List<String> rolenames;

}
