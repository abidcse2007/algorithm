package algorithm.collection.columnar;

import java.util.ArrayList;
import java.util.Arrays;

/***
 * Implement a collections that can have multiple collections of different length
 */

public class DemoColumnarCollection {
    public static void main(String[] args) {
        ArrayList<Integer> one = new ArrayList<>(Arrays.asList(1, 4, 6));
        ArrayList<Integer> two = new ArrayList<>(Arrays.asList(2));
        ArrayList<Integer> three = new ArrayList<>(Arrays.asList(3, 5));


        ArrayList<ArrayList<Integer>> collections = new ArrayList<ArrayList<Integer>>();
        collections.add(one);
        collections.add(two);
        collections.add(three);

        ColumnarCollection collection = new ColumnarCollectionImpl(collections);
        ColumnarIterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.print(" " + iterator.next());
        }
    }
}
