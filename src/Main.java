import javafx.util.Pair;

public class Main {

    public static void main(String[] args) {
	    // Create a data structure to simulate a sorted log file.
        // Cell number = the time of the formation of friendly relations between couples.
        Pair[] logTime = {
                // Who made friends at this moment?
                new Pair<>(3, 7),// moment 0
                new Pair<>(3, 8),// moment 1
                new Pair<>(6, 12),// moment 2
                new Pair<>(0, 2),// moment 3
                new Pair<>(1, 4),// moment ...
                new Pair<>(1, 3),
                new Pair<>(2, 5),
                new Pair<>(2, 6),
                new Pair<>(5, 11),
                new Pair<>(5, 10),
                new Pair<>(4, 9),
                new Pair<>(0, 1),
                new Pair<>(6, 13),
                new Pair<>(4, 14)
        };
        int nMembers = 15;// Including member number 0.

        UnionFind unionFind = new UnionFind(nMembers);


        int LOG_TIME_LENGTH = logTime.length;
        // Also "i" is equal to the timestamp.
        for (int i = 0; i < LOG_TIME_LENGTH; i++) {
            System.out.println("Time is: " +i);
            // According to the time log, I invoke the merge method.
            // The merge method returns the size of the merged tree.
            int sizeTree = unionFind.union((Integer) logTime[i].getKey(), (Integer) logTime[i].getValue());

            // If, after the current merge,
            // the size of the tree is equal to the number of network members,
            // then all network members are connected.
            if (nMembers == sizeTree) {
                System.out.println("Completeness occurs when time is equal to: " +i);
                System.out.println("sizeTree: " +sizeTree);
                System.out.println("nMembers: " +nMembers);
            }
        }
    }
}
