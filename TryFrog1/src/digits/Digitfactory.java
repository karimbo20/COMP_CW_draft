package digits;
/**
 * This is where the coordinates of the digit is positioned
 */

public class Digitfactory {
	public static Digit createDigit(int n, int dim, int x, int y) {
		return new Digit(n, dim, x, y);
	}

}
