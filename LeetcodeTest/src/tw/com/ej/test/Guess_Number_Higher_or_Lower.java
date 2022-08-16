package tw.com.ej.test;

import org.junit.Test;

public class Guess_Number_Higher_or_Lower {

	@Test
	public void aa() {
		System.out.println(guessNumber(2));
	}

	public int guessNumber(int n) {
		int min = 1, max = n;
		while (min < max) {
			int mid = min + (max - min) / 2;
			if (guess(mid) == 0) {
				return mid;
			} else if (guess(mid) == 1) {
				min = mid + 1;
			} else {
				max = mid;
			}
		}
		return min;
	}

	private int guess(int n) {
		if (n == 2)
			return 0;
		else if (n > 2)
			return -1;
		return 1;
	}

}
