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

public class Reader {

	/**
	 * 
	 * @return the list of standardized words in the text (lower case, without
	 *         accents)
	 */
	public List<String> manageFile() {
		ArrayList<String> listOfWords = new ArrayList<String>();

		File file = new File("file.txt");
		String str;
		/**
		 * 
		 */
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
				 * Replace non-alphabetics characters by a space Replace the
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

		// System.out.println(listOfWords);
		return listOfWords;

	}

	/**
	 * Remove all duplicated words in a list
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
		 * I tried that
		 */
		System.out.println("What I tried...");
		for (int i = 0; i < listOfWords.size(); i++) {
			for (int j = 1; j < listOfWords.size(); j++) {
				if (listOfWords.get(i).compareTo(listOfWords.get(j)) == 0) {
					listOfWords.remove(i);

				}

			}

		}

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
		List listOfWords = read.manageFile();
		read.removeDuplicationWords(listOfWords);

	}

}
