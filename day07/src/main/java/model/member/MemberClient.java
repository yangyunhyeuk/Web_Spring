   package model.member;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class MemberClient {
	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");

		BmemService bs = (BmemService) factory.getBean("memberService");
		BmemVO vo = new BmemVO();
		vo.setId("ronny");
		vo.setName("로니 콜먼");
		vo.setRole("경찰");

		// bs.insertMember(vo);
		
		BmemVO data = bs.getMember(vo);
		System.out.println("data : "+data);
		System.out.println("vo : "+vo);
		if(data != null) {
			System.out.println("로그인 성공");
		}
		else if(data == null) {
			System.out.println("로그인 실패");
		}
		
		/*List<BmemVO> datas = bs.getMemberList(vo);
		System.out.println("bs.getmemberList(vo) 출력 : " + datas);

		for (BmemVO data : datas) {
			System.out.println(data);
		}*/

		factory.close();
	}
}
