package singer;

public class BlackPink implements PlaySong {
	private Song song;

	public BlackPink() {
		System.out.println("����ũ �⺻������ ȣ��");
	}

	public BlackPink(Song song) {
		this.song = song;
		System.out.println("���� ������ ȣ��!");
	}

	@Override
	public void SongPlay() {
		System.out.println("���� �뷡�� �����մϴ�.");
	}

	@Override
	public void Intro() {
		song.Intro();
		// System.out.println("BLACKPINK_How You Like That");
		// 23��°���� ���߿� selectAll �� dao �۾��� ����� ����
	}

	@Override
	public void Sing() {
		System.out.println("BLACKPINK in your area");
	}

	@Override
	public void SongEnd() {
		System.out.println("���� �뷡�� ����˴ϴ�.");
	}

}
