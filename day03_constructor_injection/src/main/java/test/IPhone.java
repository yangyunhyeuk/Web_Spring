package test;

public class IPhone implements Phone {
	public IPhone() {
		System.out.println("������ �⺻ ������ ȣ��!");
	}
	
	public void powerOn() {
		System.out.println("������ ���� ON");
	}

	public void powerOff() {
		System.out.println("���� OFF");
	}

	public void volumeUp() {
		System.out.println("�Ҹ�++");
	}

	public void volumeDown() {
		System.out.println("�Ҹ�--");
	}

}
