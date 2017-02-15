package element;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * Reads a text file and create a list of the different words used in the text. It also
 * removes duplication like a set does
 */
public class Reader {

	/**
	 * Reads a file and extracts all the words from the text (in lower case)
	 * 
	 * @return the list of standardized words in the text (lower case, without
	 *         accents)
	 */
	public List<String> manageFile() {
		ArrayList<String> listOfWords = new ArrayList<>();

		File file = new File("file.txt");
		String str;

		try {
			/**
			 * We use UTF-8 so we could read accented characters
			 */
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));

			while ((str = in.readLine()) != null) {
				/**
				 * Converts all accented characters into their deAccented
				 * counterparts followed by their combining diacritics.
				 */
				String strTemp = Normalizer.normalize(str, Normalizer.Form.NFD);
				Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
				str = pattern.matcher(strTemp).replaceAll("");

				/**
				 * Replaces non-alphabetics characters by a space Replaces the
				 * duplication spaces by only one space Puts all the letters in
				 * lower case
				 */
				String[] words = str.replaceAll("[^'a-zA-Z0-9]", " ").replaceAll("( ){2,}", " ").toLowerCase()
						.split(" ");
				listOfWords.addAll(Arrays.asList(words));
			}

		} catch (UnsupportedEncodingException e) {
			throw new IllegalStateException(e);
		} catch (FileNotFoundException e) {
			throw new IllegalStateException(e);
		} catch (IOException e) {
			throw new IllegalStateException(e);
		}

		return listOfWords;

	}

	/**
	 * Removes all duplicated words in a list of words
	 * 
	 * @param listOfWords
	 *            list of words we want to treat
	 */
	public void removeDuplicationWords(List<String> listOfWords) {
		System.out.println("Begining: The first list");
		System.out.println(listOfWords);
		System.out.println(listOfWords.size());
		/**
		 * HashSet creates a list without duplicated elements
		 */
		Set<String> rightList = new HashSet<String>();
		for (String word : listOfWords) {
			rightList.add(word);
		}

		System.out.println("What we want: Test with Hashset");
		System.out.println(rightList.size());
		System.out.println(rightList);
		/**
		 * Removes the duplications from the list of words
		 */
		System.out.println("What we do...");
		for (int i = listOfWords.size() - 1; i >= 0; i--) {
			for (int j = listOfWords.size() - 2; j >= 0; j--) {
				if (listOfWords.get(i).compareTo(listOfWords.get(j)) == 0 && j != i) {
					listOfWords.remove(i);
					i++;

				}

			}

		}
		/**
		 * A comparison just to add some excitement
		 */
		System.out.println(listOfWords);
		System.out.println(listOfWords.size());
		if (listOfWords.size() == rightList.size()) {
			System.out.println("We found the right count of words. We are happy !!");
		} else {
			System.out.println("We did not find the right count of words. Something went wrong..");
		}

	}

	public static void main(String[] args) {
		Reader read = new Reader();
		List<String> listOfWords = read.manageFile();
		read.removeDuplicationWords(listOfWords);

	}

}
