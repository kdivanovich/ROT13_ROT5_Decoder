
public class Decode {

	private static String Decipher(String input) {

		String decoded = "";

		/*
		 * Since the first half of the alphabet shifts forward and the second
		 * moves "back", the easiest way to add the encoding is to manipulate
		 * the character's ascii number with simple addition and subtraction,
		 * same goes for the 10 numbers (split in 5s).
		 * 
		 * Other approaches include putting all the letters in a list, same for
		 * the numbers, and get from the list the (n +/- 13/5 )th element, the
		 * pro is that it's straightforward and is probably the first thing that
		 * comes to mind, but the con is that we are using slightly more memory
		 * this way, another approach is the same as below, but working with the
		 * the ascii numbers, which requires casting to an integer, the KISS
		 * principle however suggests the idea below is the best of the ones
		 * listed.
		 */

		for (int i = 0; i < input.length(); i++) {

			// get the currently scanned character
			char current = input.charAt(i);

			// check if the current character is a number
			if (current >= '0' && current <= '9') {
				if (current >= '0' && current <= '4')
					current += 5;

				else if (current >= '5' && current <= '9')
					current -= 5;
			}

			// check if the current character is a letter
			else {
				// first half of the alphabet:
				if (current >= 'a' && current <= 'm')
					current += 13;

				else if (current >= 'A' && current <= 'M')
					current += 13;

				// second half of the alphabet:
				else if (current >= 'n' && current <= 'z')
					current -= 13;

				else if (current >= 'N' && current <= 'Z')
					current -= 13;
			}

			decoded += current;
		}

		return decoded;
	}

	public static void main(String[] args) {

		String input = "Ceboyrz fbyivat vf 35 creprag bs gur wbo";

		// String input = "28guvf vf zl 390 grfg ZrfFntr55"; // my test

		// Call the function and print the result:
		System.out.print(Decipher(input));
	}
}
