
public class Test5 {

	public static void main(String[] args) {
		String[] strings = {"mv.song.mp3 11b", "greatSong.flac 1000b", "not3.txt 5b",
			"video.mp4 200b", "game.exe 100b", "mov1e.mkv 10000b"};

		int[] answer = solution(strings);
		for (int n : answer) {
			System.out.print(n + ", ");
		}
	}

	public static int[] solution(String[] strings) {
		int[] answer = new int[4];
		String[] str;

		for (int i = 0; i < strings.length; i++) {
			str = strings[i].split(" ");
			if (str[0].contains("mp3") || str[0].contains("aac") ||
				str[0].contains("flac")) {
				answer[0] += Integer.parseInt(str[1].replace("b", ""));
			} else if (str[0].contains("jpg") || str[0].contains("bmp") ||
				str[0].contains("gif")) {
				answer[1] += Integer.parseInt(str[1].replace("b", ""));
			} else if (str[0].contains("mp4") || str[0].contains("avi") ||
				str[0].contains("mkv")) {
				answer[2] += Integer.parseInt(str[1].replace("b", ""));
			} else {
				answer[3] += Integer.parseInt(str[1].replace("b", ""));
			}
		}

		return answer;
	}
}
