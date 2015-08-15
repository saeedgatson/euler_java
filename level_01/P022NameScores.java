// Using names.txt (right click and 'Save Link/Target As...'), a 46K text file containing over five-thousand first names, begin by sorting it into alphabetical order. Then working out the alphabetical value for each name, multiply this value by its alphabetical position in the list to obtain a name score.
// For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN would obtain a score of 938 × 53 = 49714.
// What is the total of all the name scores in the file?
import java.util.*;
import java.io.*;

public class P022NameScores {
  private static  HashMap<Character, Integer> alphaHash;
  public static void main(String[] args) {
    initAlphaMap();
    System.out.println(alphaHash);
    System.out.println(getScore("COLIN",938));
    System.out.println(readFile());
  }

  private static void initAlphaMap() {
    alphaHash = new HashMap<Character, Integer>();
    Integer i = 1;
    for(Character alphabet = 'A'; alphabet <= 'Z'; alphabet++, i++) {
      alphaHash.put(alphabet, i);
    }
  }

  private static int getScore(String name, int index) {
    int sum = 0;
    for(int i = 0; i < name.length(); i++) {
      sum += alphaHash.get(name.charAt(i));
    }
    return sum * index;
  }

  private static String readFile() {
    File file = new File("P022Names.txt");
    String list;
		try
		{
			StringBuffer contents = new StringBuffer();
			String text = null;
			BufferedReader reader = new BufferedReader(new FileReader(file));
			while ((text = reader.readLine()) != null)
			{
				contents.append(text).append(System.getProperty("line.separator"));
			}
			list = contents.toString();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return list;
	}
}
