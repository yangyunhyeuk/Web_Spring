package controller.action;

// 1. ������ ���޹�� 
// 2. ��� ����

// �ڷ��� �� Ŭ���� ����
// �������� ������ �� �ִ� �ڷ��� ���̶� �� �� �ִ�. 
public class ActionForward {
	private String path; // 경로
	private boolean redirect; // 방식

	public boolean isRedirect() {
		return redirect;
	}

	public void setRedirect(boolean redirect) {
		this.redirect = redirect;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
