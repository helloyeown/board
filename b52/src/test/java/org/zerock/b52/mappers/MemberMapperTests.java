package org.zerock.b52.mappers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class MemberMapperTests {
    
    @Autowired
    private MemberMapper memberMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void getTime(){
        log.info(memberMapper.getTime());
    }


    @Commit
	@Transactional
	@Test
	public void testInsert(){
		
		String email = "dbrudthdus@daum.net";
		String mpw = passwordEncoder.encode("1111");
		String mname = "조조";

		String rolename = "ADMIN";

		memberMapper.insertMember(email, mpw, mname);
		memberMapper.insertMemberRole(email, rolename);
		memberMapper.insertMemberRole(email, "USER");

	}

}
