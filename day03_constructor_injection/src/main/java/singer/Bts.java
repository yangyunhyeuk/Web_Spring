package singer;

public class Bts implements PlaySong {
	private Song song;

	public Bts() {
		System.out.println("��ź �⺻������ ȣ��");
	}

	public Bts(Song song) {
		this.song = song;
		System.out.println("��ź ������ ȣ��!");
	}

	@Override
	public void SongPlay() {
		System.out.println("��ź �뷡�� �����մϴ�.");
	}

	@Override
	public void Intro() {
		song.Intro();
		// System.out.println("Coldplay,BTS_My Universe");
	}

	@Override
	public void Sing() {
		System.out.println("You, you are My Universe and I just want to put you first");
	}

	@Override
	public void SongEnd() {
		System.out.println("��ź �뷡�� ����˴ϴ�.");
	}

}
