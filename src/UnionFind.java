class UnionFind {

    private int[] id;
    private int[] treeSize;
    private int[] maxElement;

    UnionFind(int n) {
        id = new int[n];
        treeSize = new int[n];
        maxElement = new int[n];

        for (int i = 0; i < n; i++) {
            id[i] = i;
            treeSize[i] = 1;
            maxElement[i] = i;
        }
    }

    // Union-find with specific canonical element.
    int find(int i) {
      return maxElement[root(i)];
    }

    int treeSize(int i) {
        return treeSize[root(i)];
    }

    private int root(int i) {
        while(i != id[i]){
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }
    // I think this method should return the current size of the tree.
    void union(int p, int q) {
        int i = root(p);
        int j = root(q);

        // for find() method.
        int max = maxElement[i] < maxElement[j] ? maxElement[j] : maxElement[i];
        maxElement[i] = max;
        maxElement[j] = max;

        if (maxElement[i] < maxElement[j]) {

        }

        if  (treeSize[i] < treeSize[j]) {
            id[i] = j;
            treeSize[j] += treeSize[i];
        }  else{
            id[j] = i;
            treeSize[i] += treeSize[j];
        }
    }
}
