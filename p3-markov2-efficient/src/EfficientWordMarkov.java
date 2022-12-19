import java.util.*;

public class EfficientWordMarkov extends BaseWordMarkov {
    private HashMap<WordGram, ArrayList<String>> myMap;

    /**
     * default constructor when the order is 2
     */
    public EfficientWordMarkov() {
        this(2);
        myMap = new HashMap<>();
    }

    /**
     * initializes the EfficientWordMarkov object
     * @param order An order-k Markov model uses strings of k-letters to predict text, these are called k-grams.
     */
    public EfficientWordMarkov(int order) {
        myOrder = order;
        myMap = new HashMap<>();
    }

    /**
     * The value for each key in the map is set
     * @param text is the text that we use to train the EfficientMarkov object
     */
    @Override
    public void setTraining(String text) {
        super.setTraining(text);
        myMap.clear();

        for (int index = 0; index < myWords.length - myOrder + 1; index++) {
            WordGram wg = new WordGram(myWords, index, myOrder);
            myMap.putIfAbsent(wg, new ArrayList<String>());
            if (index == myWords.length - myOrder) {
                myMap.get(wg).add(PSEUDO_EOS);
            } else {
                myMap.get(wg).add(myWords[index + myOrder]);
            }
        }
    }

    /**
     * looks up the key in a map and returns the associated value
     * @param key is a key in the HashMap
     * @return ArrayList of WordGram objects that was created when setTraining is calle
     */
    @Override
    public ArrayList<String> getFollows(WordGram key) {
        if (!myMap.containsKey(key)) {
            throw new NoSuchElementException(key + " not contained in map");
        }
        return myMap.get(key);
    }
}
