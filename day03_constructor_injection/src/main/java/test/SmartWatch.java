package test;

public class SmartWatch implements Watch{
	public SmartWatch() {
		System.out.println("�����ÿ�ġ �⺻ ������ ȣ��!");
	}

	@Override
	public void volumeUp() {
		System.out.println("��,����Ʈ��ġ ���� ��!");
	}

	@Override
	public void volumeDown() {
		System.out.println("��,����Ʈ��ġ ���� �ٿ�!");
	}		
}
