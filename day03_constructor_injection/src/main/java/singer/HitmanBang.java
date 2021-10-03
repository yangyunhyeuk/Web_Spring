package singer;

public class HitmanBang implements Song{
	public HitmanBang() {
		System.out.println("방시혁 기본생성자 호출");
	}
	@Override
	public void Intro() {
		System.out.println("방시혁 듣는 중");		
	}

}
