import java.net.PasswordAuthentication;
import java.util.Arrays;

/**
 * A WordGram represents a sequence of strings
 * just as a String represents a sequence of characters
 * 
 * @author OLIVIAFAN
 *
 */
public class WordGram {
	
	private String[] myWords;   
	private String myToString;  // cached string
	private int myHash;         // cached hash value

	/**
	 * Create WordGram by creating instance variable myWords and copying
	 * size strings from source starting at index start
	 * @param source is array of strings from which copying occurs
	 * @param start starting index in source for strings to be copied
	 * @param size the number of strings copied
	 */
	public WordGram(String[] source, int start, int size) {
		myWords = new String[size];
		for (int k =0 ; k< myWords.length; k++){
			myWords[k] = source [start];
			start+=1;
		}
		myToString = null;
		myHash = 0;

		// TODO: initialize all instance variable
	}

	/**
	 * Return string at specific index in this WordGram
	 * @param index in range [0..length() ) for string 
	 * @return string at index
	 */
	public String wordAt(int index) {
		if (index < 0 || index >= myWords.length) {
			throw new IndexOutOfBoundsException("bad index in wordAt "+index);
		}
		return myWords[index];
	}

	/**
	 * Return the length of WordGram
	 * @return length of WordGram
	 */
	public int length(){
		return myWords.length;
	}


	/**
	 * Checks if two WordGram objects are equal to each other
	 * @param o is another WordGram object
	 * @return true if when the parameter passed is a WordGram object with the same strings in the same order as this object, return false otherwise.
	 */
	@Override
	public boolean equals(Object o) {
		if (! (o instanceof WordGram) || o == null){
			return false;
		}
		else {
			WordGram wg = (WordGram) o;
			if (wg.length()!= this.length()){
				return false;
			}
			else {
				for (int k =0 ; k<this.length(); k++){
					if (!(this.wordAt(k).equals(((WordGram) o).wordAt(k)))){
						return false;
					}
				}
			}
		}
		return true;
	}

	//return an int value based on all the strings in instance variable myWords
	@Override
	public int hashCode(){
		myHash = this.toString().hashCode();
		return myHash;
	}
	

	/**
	 * @param last is last String of returned WordGram
	 * @return a new WordGram object with k entries (where k is the order of this WordGram) whose first k-1 entries are the same as the last k-1 entries of this WordGram, and whose last entry is the parameter last.
	 */

	public WordGram shiftAdd(String last) {
		String[] newWords = new String [myWords.length + 1];
		for (int i = 0; i<myWords.length; i ++){
			newWords[i] = myWords[i];
		}
		newWords[myWords.length] = last;
		WordGram wg = new WordGram(newWords, 1, newWords.length -1);
		return wg;
	}

	//return a printable String representing all the strings stored in the WordGram
	@Override
	public String toString() {
		if (myToString==null) {
			myToString = String.join(" ", myWords);
		}
			return myToString;
	}
}
