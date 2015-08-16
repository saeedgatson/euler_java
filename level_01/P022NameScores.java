// Using names.txt (right click and 'Save Link/Target As...'), a 46K line file containing over five-thousand first names, begin by sorting it into alphabetical order. Then working out the alphabetical value for each name, multiply this value by its alphabetical position in the list to obtain a name score.
// For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN would obtain a score of 938 × 53 = 49714.
// What is the total of all the name scores in the file?
import java.util.*;
import java.io.*;

public class P022NameScores {
  private static HashMap<Character, Integer> alphaHash;
  private static ArrayList<String> names;
  public static void main(String[] args) {
    initAlphaMap();
    readAndSortNames();
    int i = 1;
    int sum = 0;
    for(String name: names) {
      sum += getScore(name, i);
      i++;
    }
    System.out.println("The total name score is " + sum);
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

  private static void readAndSortNames() {
    names = new ArrayList<String>();
    File file = new File("P022Names.txt");
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
          names.add(lineNames[i]);
        }
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		Collections.sort(names);
	}
}
