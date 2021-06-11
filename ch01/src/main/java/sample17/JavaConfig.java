package sample17;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
// Configuration파일을 xml에서 java로 변경
@Configuration
public class JavaConfig {
	@Bean
	public MemberDao memberDao() {
		return new MemberDaoImpl();
	}
	@Bean
	public MemberService memberService() {
		return new MemberServiceImpl();
	}
}
