package test;

public class GaPhone implements Phone {
	// private SmartWatch sw;
	// ����Ʈ��ġ�� �����Ǿ������ʴٸ� �ϴܿ��� nullPointException�߻��ϴϴ°Թ����̴�!!

	private Watch sw;

	public GaPhone() {
		System.out.println("������ �⺻ ������ ȣ��!");
	}

	public GaPhone(Watch sw) {
		// ���ڰ� �̵����� ���յ��� ����(����,��ü ��ü�� ��ƴ�)

		// ������ ���� ��ÿ� ����Ʈ��ġ�� ����
		this.sw = sw;

		System.out.println("������ ������ ȣ��!");
	}

	@Override
	public void powerOn() {
		System.out.println("������ ���� ����");
	}

	@Override
	public void powerOff() {
		System.out.println("���� ����");
	}

	@Override
	public void volumeUp() {
		// SmartWatch sw = new SmartWatch();

		sw.volumeUp();
		// System.out.println("�Ҹ� +=10");
	}

	@Override
	public void volumeDown() {
		// SmartWatch sw = new SmartWatch();
		// �����ð� ����Ʈ��ġ ������ ��ܿ� ����Ͽ� �ش� �����ڵ� ���� ����

		sw.volumeDown();
		// System.out.println("�Ҹ� -=10");
	}
}
