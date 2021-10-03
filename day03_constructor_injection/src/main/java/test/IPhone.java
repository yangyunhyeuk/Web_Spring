package test;

public class IPhone implements Phone {
	public IPhone() {
		System.out.println("아이폰 기본 생성자 호출!");
	}
	
	public void powerOn() {
		System.out.println("아이폰 전원 ON");
	}

	public void powerOff() {
		System.out.println("전원 OFF");
	}

	public void volumeUp() {
		System.out.println("소리++");
	}

	public void volumeDown() {
		System.out.println("소리--");
	}

}
