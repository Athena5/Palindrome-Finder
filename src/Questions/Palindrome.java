package Questions;

import javax.swing.JOptionPane;

public class Palindrome {
	
	public static String leaveOnlyAlphanumerics(String phrase)
	{
		int phraseLength = phrase.length();
		for (int index = 0; index < phraseLength; index++) {
			char aCharacter = phrase.charAt(index);
			
			if (!Character.isLetter(aCharacter) && !Character.isDigit(aCharacter)) {
				phrase = phrase.substring(0, index) + phrase.substring(index+1);
				phraseLength = phrase.length();
				index--;
			}
		}
		
		return phrase;
	}
	
	public static boolean isAPalindrome(String aPhrase) {
		String phrase = leaveOnlyAlphanumerics(aPhrase);
		phrase = " " + phrase.toLowerCase() + " ";
		boolean isAPalindrome = true;
		int phraseLength = phrase.length();

		for (int index = 1; index <= phraseLength/2; index++) {
			char aLetter = phrase.charAt(index);
			char correspondingLetter = phrase.charAt(phraseLength - index - 1);
			
			if (aLetter != correspondingLetter) {
				isAPalindrome = false;
				break;
			}
		}
		
		return isAPalindrome;
	}
	
	public static String largestPalindrome(String line) {
		String longestPalindrome = "";
		
		int lineLength = line.length();
		
		for (int startIndex = 0; startIndex <= lineLength; startIndex++) {
			for (int endIndex = startIndex; endIndex <= lineLength; endIndex++)  {
				String currentString = line.substring(startIndex, endIndex);
				
				if (isAPalindrome(currentString)) {
					if (currentString.length() > longestPalindrome.length()) {
						longestPalindrome = currentString;
					}
				}
			}
		}
		
		return longestPalindrome;
	}

	public static void main(String[] args) {
		
		String input = JOptionPane.showInputDialog("Enter a phrase to find the largest palindrome in it");
		System.out.println(largestPalindrome(input));
	}
} 
