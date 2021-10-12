   package model.member;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class MemberClient {
	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");

		BmemService bs = (BmemService) factory.getBean("memberService");
		BmemVO vo = new BmemVO();
		vo.setId("ronny");
		vo.setName("�δ� �ݸ�");
		vo.setRole("����");

		// bs.insertMember(vo);
		
		BmemVO data = bs.getMember(vo);
		System.out.println("data : "+data);
		System.out.println("vo : "+vo);
		if(data != null) {
			System.out.println("�α��� ����");
		}
		else if(data == null) {
			System.out.println("�α��� ����");
		}
		
		/*List<BmemVO> datas = bs.getMemberList(vo);
		System.out.println("bs.getmemberList(vo) ��� : " + datas);

		for (BmemVO data : datas) {
			System.out.println(data);
		}*/

		factory.close();
	}
}
