package singer;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MelonMusic {
	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");

		// 2. ��ü�� ��û�ϸ�, �ش� ��ü�� �ش�.
		// == Look up
		// Test t=(Test)factory.getBean("phone");
		// t.print();
		PlaySong psong = (PlaySong) factory.getBean("playsong");
		psong.SongPlay();
		psong.Intro();
		// 3. ������ �����̳� ����
		factory.close();
	}
}
