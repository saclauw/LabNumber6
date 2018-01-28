
/* Task: Translate from English to Pig Latin
 * 
 * What will the application do:
 * -Prompt the user for a word
 * -Translate the test to Pig Latin and display it on the console
 * -Ask the user if they want to translate another word
 * 
 * BUILD SPECS
 * -Convert each word to lowercase before translating.
 * -If a word starts with a vowel, just add "way" onto the ending.
 * -If a word starts with a consonant, move all of the consonants that appear
 * before the first vowel to the end of the word, then add "ay" to the end of the word
 * 
 * HINTS
 * -Treat Y as a consonant
 * -ZyBook 3.7-3.9
 * 
 * XTRA XTRA
 * 1.  Keep the case of the word whether its uppercase, title, caser, or lowercase.
 * 2.Allow punctuation in the input string..
 * 3.Translate words with contractions. Ex can't becomes an'tcay
 * 4.Don't translate words that have numbers or symbols.
 * 5.Check that the user has actually entered text before translating.
 * 6.Make the application take a line instead of a single word, then find the Pig Latin
 * for each word in the line.
 * 
 */

import java.util.Scanner;

public class LabNumber6 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String cont = "y";
		String userInput; // string for userInput
		int vowPos = -1; // position of first vowel
		char x;
		int spacePos = -1;
		String a;
		String b;
		String a2;
		String b2;
		String pigLat;

		System.out.println("Welcome to the Pig Lating Trasnlator!");
		System.out.println("");

		while (cont.equalsIgnoreCase("y")) {
			System.out.print("Enter a word to be translated: ");
			userInput = scan.nextLine();
			userInput = userInput.toLowerCase();

			for (int i = 0; i < userInput.length(); i++) {
				x = userInput.charAt(i);
				if (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u') {
					vowPos = i; // vowPos now stored the index of first vowel
					break;
				}
			}
			if ((userInput.charAt(0) == 'a') || (userInput.charAt(0) == 'e') || (userInput.charAt(0) == 'i')
					|| (userInput.charAt(0) == 'o') || (userInput.charAt(0) == 'u')) {
				pigLat = userInput + "way";
				System.out.println("");
				System.out.println("The Pig Latin Translation is: " + pigLat);
			} else if (vowPos != -1) {
				a = userInput.substring(vowPos);
				b = userInput.substring(0, vowPos);
				pigLat = a + b + "ay";
				System.out.println("");
				System.out.println("The Pig Latin Translation is: " + pigLat);
			} else if (spacePos != -1) {
				a = userInput.substring(vowPos);
				b = userInput.substring(0, vowPos);
				a2 = userInput.substring(spacePos);
				b2 = userInput.substring(vowPos, spacePos);
				pigLat = a + b + "ay" + " " + a2 + b2 + "ay";
			}

			System.out.println("");
			System.out.print("Translate another word? (y/n) ");
			cont = scan.nextLine();
			if (!cont.equalsIgnoreCase("y")) {
				System.out.println("Goodbye!");
			}
		}

		scan.close();
	}


	}

