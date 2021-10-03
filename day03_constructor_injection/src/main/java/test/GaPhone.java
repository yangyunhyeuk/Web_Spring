package test;

public class GaPhone implements Phone {
	// private SmartWatch sw;
	// 스마트워치가 생성되어있지않다면 하단에서 nullPointException발생하니는게문제이다!!

	private Watch sw;

	public GaPhone() {
		System.out.println("갤럭시 기본 생성자 호출!");
	}

	public GaPhone(Watch sw) {
		// 인자가 이따구면 결합도가 높다(인자,대체 교체가 어렵다)

		// 갤럭시 생성 당시에 스마트워치도 생성
		this.sw = sw;

		System.out.println("갤럭시 생성자 호출!");
	}

	@Override
	public void powerOn() {
		System.out.println("갤럭시 전원 켜짐");
	}

	@Override
	public void powerOff() {
		System.out.println("전원 꺼짐");
	}

	@Override
	public void volumeUp() {
		// SmartWatch sw = new SmartWatch();

		sw.volumeUp();
		// System.out.println("소리 +=10");
	}

	@Override
	public void volumeDown() {
		// SmartWatch sw = new SmartWatch();
		// 갤럭시가 스마트워치 가짐을 상단에 명시하여 해당 생성코드 삭제 가능

		sw.volumeDown();
		// System.out.println("소리 -=10");
	}
}
