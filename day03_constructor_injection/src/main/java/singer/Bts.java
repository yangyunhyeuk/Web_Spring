package singer;

public class Bts implements PlaySong {
	private Song song;

	public Bts() {
		System.out.println("방탄 기본생성자 호출");
	}

	public Bts(Song song) {
		this.song = song;
		System.out.println("방탄 생성자 호출!");
	}

	@Override
	public void SongPlay() {
		System.out.println("방탄 노래가 시작합니다.");
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
		System.out.println("방탄 노래가 종료됩니다.");
	}

}
