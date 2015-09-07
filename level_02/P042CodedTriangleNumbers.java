// The nth term of the sequence of triangle numbers is given by, tn = ½n(n+1); so the first ten triangle numbers are:
// 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
// By converting each letter in a word to a number corresponding to its alphabetical position and adding these values we form a word value.
// For example, the word value for SKY is 19 + 11 + 25 = 55 = t10. If the word value is a triangle number then we shall call the word a triangle word.

import java.util.*;
import java.io.*;

public class P042CodedTriangleNumbers {
  private static HashMap<Character, Integer> alphaHash;
  private static ArrayList<String> words;

  private static void initAlphaMap() {
    alphaHash = new HashMap<Character, Integer>();
    Integer i = 1;
    for(Character alphabet = 'A'; alphabet <= 'Z'; alphabet++, i++) {
      alphaHash.put(alphabet, i);
    }
  }

  private static int wordValue(String word) {
    int sum = 0;
    for (char ch: word.toCharArray()) {
      sum += alphaHash.get(ch);
    }
    return sum;
  }

  private static boolean isTriangle(int number) {
    for (int i = 1; ; i++) {
			int triangle = i * (i + 1) / 2;
			if (triangle == number)
				return true;
			if (triangle > number)
				return false;
		}
  }

  private static void readWords() {
    words = new ArrayList<String>();
    File file = new File("P042Words.txt");
		try
		{
			StringBuffer contents = new StringBuffer();
			String line = null;
			BufferedReader reader = new BufferedReader(new FileReader(file));
			while ((line = reader.readLine()) != null)
			{
				line = line.replace("\"", "");
        String[] lineNames = line.split(",");
        for(int i = 0; i < lineNames.length; i++) {
          words.add(lineNames[i]);
        }
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

  public static void main(String[] args) {
    initAlphaMap();
    readWords();
    int count = 0;
    for(String word: words) {
      int value = wordValue(word);
      if(isTriangle(value)) {
        count += 1;
      }
    }
    System.out.format("There are %d triangle words in the file.%n", count);
  }
}
