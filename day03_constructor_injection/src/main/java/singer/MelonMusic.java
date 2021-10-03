package singer;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MelonMusic {
	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");

		// 2. 객체를 요청하면, 해당 객체를 준다.
		// == Look up
		// Test t=(Test)factory.getBean("phone");
		// t.print();
		PlaySong psong = (PlaySong) factory.getBean("playsong");
		psong.SongPlay();
		psong.Intro();
		// 3. 스프링 컨테이너 종료
		factory.close();
	}
}
