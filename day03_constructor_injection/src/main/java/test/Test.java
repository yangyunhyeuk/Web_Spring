package test;

public class Test {
	int a;

	public Test() {
		System.out.println("기본 생성자 호출됨!");
	}

	public void print() {
		System.out.println("출력");
	}

	public void initFunc() {
		System.out.println("멤버변수 초기화");
		int a = 100;
	}

}