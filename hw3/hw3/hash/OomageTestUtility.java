package hw3.hash;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

public class OomageTestUtility {
    public static boolean haveNiceHashCodeSpread(List<Oomage> oomages, int M) {
        /* TODO:
         * Write a utility function that returns true if the given oomages
         * have hashCodes that would distribute them fairly evenly across
         * M buckets. To do this, convert each oomage's hashcode in the
         * same way as in the visualizer, i.e. (& 0x7FFFFFFF) % M.
         * and ensure that no bucket has fewer than N / 50
         * Oomages and no bucket has more than N / 2.5 Oomages.
         */

        // Initialize array of array
        ArrayList[] a = new ArrayList[M];
        for (int i = 0; i < M; i++) {
            a[i] = new ArrayList<SimpleOomage>();
        }

        // Add Oomages into the list
        for (Oomage i : oomages) {
            int bucketNum = (i.hashCode() & 0x7FFFFFFF) % M;
            a[bucketNum].add(i);
        }

        // Check Load factor
        double N = oomages.size();
        for (ArrayList j : a) {
            double size = j.size();
            if (size < N / 50 || size > N / 2.5) {
                return false;
            }
        }
        return true;
    }
}
