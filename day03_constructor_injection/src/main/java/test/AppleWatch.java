package test;

public class AppleWatch implements Watch {

	public void Watch() {
		System.out.println("���ÿ�ġ �⺻ ������ ȣ��");
	}
	
	
	@Override
	public void volumeUp() {
		System.out.println("���ÿ�ġ�� �Ҹ���");
	}

	@Override
	public void volumeDown() {
		System.out.println("���ÿ�ġ�� �Ҹ��ٿ�");
	}

}
