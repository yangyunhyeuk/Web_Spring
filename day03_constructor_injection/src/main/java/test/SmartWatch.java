package test;

public class SmartWatch implements Watch{
	public SmartWatch() {
		System.out.println("갤럭시워치 기본 생성자 호출!");
	}

	@Override
	public void volumeUp() {
		System.out.println("갤,스마트워치 볼륨 업!");
	}

	@Override
	public void volumeDown() {
		System.out.println("갤,스마트워치 볼륨 다운!");
	}		
}
