package basic.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// The time complexity of Collections.sort() is O(nlog(n)).
public class CollectionsSort {

    public static void main(String[] args)
    {
        // Create a list of strings
        ArrayList<Job> jobs = new ArrayList<>();
        jobs.add(new Job(0,15));
        jobs.add(new Job(1,30));
        jobs.add(new Job(2,15));
        jobs.add(new Job(3,5));
        jobs.add(new Job(4,10));

        System.out.println("Original List:\n" + jobs);

        /*
        * Original List: [0 15, 1 30, 2 15, 3 5, 4 10]
        * */

        sortCollectionUsingCustomIndexComparator(jobs);


        // Let us print the sorted list
        System.out.println("List after the use of" +
                " Collection.sort() on index:\n" + jobs);

        /*
         * List after the use of Collection.sort() on index: [0 15, 1 30, 2 15, 3 5, 4 10]
         * */



        sortCollectionUsingCustomReverseIndexComparator(jobs);

        // Let us print the sorted list
        System.out.println("List after the use of" +
                " Collection.sort() on reverse index:\n" + jobs);

        /*
        * List after the use of Collection.sort() on reverse index: [4 10, 3 5, 2 15, 1 30, 0 15]
        * */

        sortCollectionUsingCustomTimeComparator(jobs);

        // Let us print the sorted list
        System.out.println("List after the use of" +
                " Collection.sort() on time:\n" + jobs);

        /*
         * List after the use of Collection.sort() on time: [3 5, 4 10, 2 15, 0 15, 1 30]
         * */

        sortCollectionUsingCustomReverseTimeComparator(jobs);

        // Let us print the sorted list
        System.out.println("List after the use of" +
                " Collection.sort() on reverse time :\n" + jobs);

        /*
         * List after the use of Collection.sort() on reverse time : [1 30, 2 15, 0 15, 4 10, 3 5]
         * */

    }

    public  static class Job {
        Integer index;
        Integer time;
        public Job(int index, int time) {
            this.index = index;
            this.time = time;
        }

        @Override
        public String toString() {
            return index+" "+time;
        }
    }


    public static void sortCollectionUsingCustomReverseTimeComparator(List<Job> jobs) {
        Collections.sort(jobs, (o1, o2) -> Integer.compare(o2.time, o1.time));
    }

    public static void sortCollectionUsingCustomTimeComparator(List<Job> jobs) {
        Collections.sort(jobs, Comparator.comparingInt(o -> o.time));
    }

    public static void sortCollectionUsingCustomReverseIndexComparator(List<Job> jobs) {
        Collections.sort(jobs, (o1, o2) -> Integer.compare(o2.index, o1.index));
    }

    public static void sortCollectionUsingCustomIndexComparator(List<Job> jobs) {
        Collections.sort(jobs, Comparator.comparingInt(o -> o.index));
    }

}
