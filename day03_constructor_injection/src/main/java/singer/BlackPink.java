package singer;

public class BlackPink implements PlaySong {
	private Song song;

	public BlackPink() {
		System.out.println("블랙핑크 기본생성자 호출");
	}

	public BlackPink(Song song) {
		this.song = song;
		System.out.println("블핑 생성자 호출!");
	}

	@Override
	public void SongPlay() {
		System.out.println("블핑 노래가 시작합니다.");
	}

	@Override
	public void Intro() {
		song.Intro();
		// System.out.println("BLACKPINK_How You Like That");
		// 23번째줄은 나중에 selectAll 등 dao 작업이 진행될 예정
	}

	@Override
	public void Sing() {
		System.out.println("BLACKPINK in your area");
	}

	@Override
	public void SongEnd() {
		System.out.println("블핑 노래가 종료됩니다.");
	}

}
