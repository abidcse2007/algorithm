package algorithm.collection.columnar;

import java.util.ArrayList;

public class ColumnarCollectionImpl implements ColumnarCollection {
    private ArrayList<ArrayList<Integer>> collections = new ArrayList<ArrayList<Integer>>();

    public ColumnarCollectionImpl(ArrayList<ArrayList<Integer>> collections) {
        this.collections = collections;
    }

    @Override
    public ColumnarIterator iterator() {
        return new ColumnarIteratorImpl(collections);
    }


    private class ColumnarIteratorImpl implements ColumnarIterator {
        private int row;
        private int column;
        private ArrayList<ArrayList<Integer>> collections = new ArrayList<>();

        public ColumnarIteratorImpl(ArrayList<ArrayList<Integer>> collections) {
            this.row = 0;
            this.column = 0;
            this.collections = collections;
        }

        @Override
        public boolean hasNext() {
            int iteratorCount = 0;
            while (true) {
                if (collections.get(row).size() > column) {
                    return true;
                }
                iteratorCount++;
                if (iteratorCount >= collections.size()) {
                    return false;
                }
                row = (row + 1) % collections.size();
                if (row == 0) {
                    column++;
                }
            }
        }

        @Override
        public Integer next() {
            Integer  data = collections.get(row).get(column);

            row = (row + 1) % collections.size();
            if (row == 0) {
                column++;
            }

            return data;
        }
    }
}
