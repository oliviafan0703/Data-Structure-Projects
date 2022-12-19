import java.lang.reflect.Array;
import java.util.*;

public class EfficientMarkov extends BaseMarkov {
    private static Map<String, ArrayList<String>> myMap;

    /**
     * initializes the EfficientMarkov object when order is 3
     */
    public EfficientMarkov() {
        this(3);
    }

    /**
     * initializes the EfficientMarkov object
     * @param order An order-k Markov model uses strings of k-letters to predict text, these are called k-grams.
     */
    public EfficientMarkov(int order) {
        super(order);
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

        for (int index = 0; index < text.length() - myOrder + 1; index++) {
            String key = myText.substring(index, index + myOrder);
            myMap.putIfAbsent(key, new ArrayList<String>());

            if (index == text.length() - myOrder) {
                myMap.get(key).add(PSEUDO_EOS);
                break;
            } else {
                myMap.get(key).add(myText.substring(index + myOrder, index + myOrder + 1));
            }
        }
    }

    /**
     * looks up the key in a map and returns the associated value
     * @param key is a key in the HashMap
     * @return ArrayList of single-character strings that was created when setTraining is calle
     */
    @Override
    public ArrayList<String> getFollows(String key) {
        if (!myMap.containsKey(key)) {
            throw new NoSuchElementException(key + " not in map");
        }
        return myMap.get(key);
    }
}
