import java.time.LocalTime;

public class WordsClock {

	public static void main(String[] args) {
		
		char[][] wordsclock = {
				{'I','T','l','I','S','a','s','a','m','p','m'},
				{'a','c','q','u','a','r','t','e','r','d','c'},
				{'t','w','e','n','t','y','f','i','v','e','x'},
				{'h','a','l','f','s','t','e','n','f','t','o'},
				{'p','a','s','t','e','r','u','n','i','n','e'},
				{'o','n','e','s','i','x','t','h','r','e','e'},
				{'f','o','u','r','f','i','v','e','t','w','o'},
				{'e','i','g','h','t','e','l','e','v','e','n'},
				{'s','e','v','e','n','t','w','e','l','v','e'},
				{'t','e','n','s','e','o','c','l','o','c','k'}
		};
		
		System.out.println(LocalTime.now().toString());
		int hour = LocalTime.now().getHour();
		int minutes = LocalTime.now().getMinute(); 
		
		wordsclock = getHour(wordsclock, hour, minutes);
		printClock(wordsclock);

	}

	private static char[][] getMinutes(char[][] wordsclock, int minutes) {
		if (minutes > 57 || minutes < 4) {
			wordsclock = oClock(wordsclock);
		}
		if (minutes > 3 && minutes < 33) {
			wordsclock = past(wordsclock);
			if (minutes > 3 && minutes < 8) {
				wordsclock = fiveMinutes(wordsclock);
			}
			if (minutes > 7 && minutes < 13) {
				wordsclock = tenMinutes(wordsclock);
			}
			if (minutes > 12 && minutes < 18) {
				wordsclock = quarter(wordsclock);
			}
			if (minutes > 17 && minutes < 23) {
				wordsclock = twenty(wordsclock);
			}
			if (minutes > 22 && minutes < 28) {
				wordsclock = twentyFive(wordsclock);
			}
			if (minutes > 27 && minutes < 33) {
				wordsclock = half(wordsclock);
			}
		}
		if (minutes > 32 && minutes < 58) {
			wordsclock = to(wordsclock);
			if (minutes > 32 && minutes < 38) {
				wordsclock = twentyFive(wordsclock);
			}
			if (minutes > 37 && minutes < 43) {
				wordsclock = twenty(wordsclock);
			}
			if (minutes > 42 && minutes < 48) {
				wordsclock = quarter(wordsclock);
			}
			if (minutes > 47 && minutes < 53) {
				wordsclock = tenMinutes(wordsclock);
			}
			if (minutes > 52 && minutes < 58) {
				wordsclock = fiveMinutes(wordsclock);
			}
		}
		
		return wordsclock;
	}

	private static char[][] getHour(char[][] wordsclock, int hour, int minutes) {
		wordsclock = getMinutes(wordsclock, minutes);
		wordsclock = (hour < 11) ? am(wordsclock) : pm(wordsclock);
		if (hour == 0) {
			hour += 12;
		}
		if (hour > 12) {
			hour -= 12; 
		}
		if (minutes > 32) {
			hour++;
		}
		switch (hour) {
		case 1 -> wordsclock = one(wordsclock);
		case 2 -> wordsclock = two(wordsclock);
		case 3 -> wordsclock = three(wordsclock);
		case 4 -> wordsclock = four(wordsclock);
		case 5 -> wordsclock = five(wordsclock);
		case 6 -> wordsclock = six(wordsclock);
		case 7 -> wordsclock = seven(wordsclock);
		case 8 -> wordsclock = eight(wordsclock);
		case 9 -> wordsclock = nine(wordsclock);
		case 10 -> wordsclock = ten(wordsclock);
		case 11 -> wordsclock = eleven(wordsclock);
		case 12 -> wordsclock = twelve(wordsclock);
		default ->
		throw new IllegalArgumentException("Unexpected value: " + hour);
		}
		return wordsclock;
	}

	private static char[][] twelve(char[][] wordsclock) {
		for (int i = 5; i < 11; i++) {
			wordsclock[8][i] = Character.toUpperCase(wordsclock[8][i]);
		}
		return wordsclock;
	}
	
	private static char[][] eleven(char[][] wordsclock) {
		for (int i = 5; i < 11; i++) {
			wordsclock[7][i] = Character.toUpperCase(wordsclock[7][i]);
		}
		return wordsclock;
	}

	private static char[][] ten(char[][] wordsclock) {
		for (int i = 0; i < 3; i++) {
			wordsclock[9][i] = Character.toUpperCase(wordsclock[9][i]);
		}
		return wordsclock;
	}

	private static char[][] nine(char[][] wordsclock) {
		for (int i = 7; i < 11; i++) {
			wordsclock[4][i] = Character.toUpperCase(wordsclock[4][i]);
		}
		return wordsclock;
	}

	private static char[][] eight(char[][] wordsclock) {
		for (int i = 0; i < 5; i++) {
			wordsclock[7][i] = Character.toUpperCase(wordsclock[7][i]);
		}
		return wordsclock;
	}

	private static char[][] seven(char[][] wordsclock) {
		for (int i = 0; i < 5; i++) {
			wordsclock[8][i] = Character.toUpperCase(wordsclock[8][i]);
		}
		return wordsclock;
	}

	private static char[][] six(char[][] wordsclock) {
		for (int i = 3; i < 6; i++) {
			wordsclock[5][i] = Character.toUpperCase(wordsclock[5][i]);
		}
		return wordsclock;
	}

	private static char[][] five(char[][] wordsclock) {
		for (int i = 4; i < 8; i++) {
			wordsclock[6][i] = Character.toUpperCase(wordsclock[6][i]);
		}
		return wordsclock;
	}

	private static char[][] four(char[][] wordsclock) {
		for (int i = 0; i < 4; i++) {
			wordsclock[6][i] = Character.toUpperCase(wordsclock[6][i]);
		}
		return wordsclock;
	}

	private static char[][] three(char[][] wordsclock) {
		for (int i = 6; i < 11; i++) {
			wordsclock[5][i] = Character.toUpperCase(wordsclock[5][i]);
		}
		return wordsclock;
	}

	private static char[][] two(char[][] wordsclock) {
		for (int i = 8; i < 11; i++) {
			wordsclock[6][i] = Character.toUpperCase(wordsclock[6][i]);
		}
		return wordsclock;
	}

	private static char[][] one(char[][] wordsclock) {
		for (int i = 0; i < 3; i++) {
			wordsclock[5][i] = Character.toUpperCase(wordsclock[5][i]);
		}
		return wordsclock;
	}

	private static char[][] quarter(char[][] wordsclock) {
		for (int i = 2; i < 9; i++) {
			wordsclock[1][i] = Character.toUpperCase(wordsclock[1][i]);
		}
		return wordsclock;
	}
	
	private static char[][] twenty(char[][] wordsclock) {
		for (int i = 0; i < 6; i++) {
			wordsclock[2][i] = Character.toUpperCase(wordsclock[2][i]);
		}
		return wordsclock;
	}

	private static char[][] twentyFive(char[][] wordsclock) {
		for (int i = 0; i < 10; i++) {
			wordsclock[2][i] = Character.toUpperCase(wordsclock[2][i]);
		}
		return wordsclock;
	}
	
	private static char[][] fiveMinutes(char[][] wordsclock) {
		for (int i = 6; i < 10; i++) {
			wordsclock[2][i] = Character.toUpperCase(wordsclock[2][i]);
		}
		return wordsclock;
	}
	
	private static char[][] half(char[][] wordsclock) {
		for (int i = 0; i < 4; i++) {
			wordsclock[3][i] = Character.toUpperCase(wordsclock[3][i]);
		}
		return wordsclock;
	}
	
	private static char[][] tenMinutes(char[][] wordsclock) {
		for (int i = 5; i < 8; i++) {
			wordsclock[3][i] = Character.toUpperCase(wordsclock[3][i]);
		}
		return wordsclock;
	}
	
	private static char[][] past(char[][] wordsclock) {
		for (int i = 0; i < 4; i++) {
			wordsclock[4][i] = Character.toUpperCase(wordsclock[4][i]);
		}
		return wordsclock;
	}
	
	private static char[][] to(char[][] wordsclock) {
		for (int i = 9; i < 11; i++) {
			wordsclock[3][i] = Character.toUpperCase(wordsclock[3][i]);
		}
		return wordsclock;
	}

	private static char[][] am(char[][] wordsclock) {
		wordsclock[0][7] = Character.toUpperCase(wordsclock[0][7]);
		wordsclock[0][8] = Character.toUpperCase(wordsclock[0][8]);
		return wordsclock;
	}
	
	private static char[][] pm(char[][] wordsclock) {
		wordsclock[0][9] = Character.toUpperCase(wordsclock[0][9]);
		wordsclock[0][10] = Character.toUpperCase(wordsclock[0][10]);
		return wordsclock;
	}
	
	private static char[][] oClock(char[][] wordsclock) {
		for (int i = 5; i < 11; i++) {
			wordsclock[9][i] = Character.toUpperCase(wordsclock[9][i]);
		}
		return wordsclock;
	}

	public static void printClock(char[][] wordsclock) {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 11; j++) {
				System.out.print(wordsclock[i][j] + " ");
			}
			System.out.println();
		}
		wordsToLowerCase(wordsclock);
	}

	private static void wordsToLowerCase(char[][] wordsclock) {
		for (int i = 7; i < 11; i++) {
			wordsclock[0][i] = Character.toUpperCase(wordsclock[0][i]);
		}
		for (int i = 1; i < 10; i++) {
			for (int j = 0; j < 11; j++) {
				wordsclock[i][j] = Character.toLowerCase(wordsclock[i][j]);
			}
		}	
	}

}
