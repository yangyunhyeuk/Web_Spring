package test;

public class AppleWatch implements Watch {

	public void Watch() {
		System.out.println("애플워치 기본 생성자 호출");
	}
	
	
	@Override
	public void volumeUp() {
		System.out.println("애플워치로 소리업");
	}

	@Override
	public void volumeDown() {
		System.out.println("애플워치로 소리다운");
	}

}
