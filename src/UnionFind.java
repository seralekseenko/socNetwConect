class UnionFind {

    private int[] id;
    private int[] treeSize;

    UnionFind(int n) {
        id = new int[n];
        treeSize = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
            treeSize[i] = 1;

        }
    }

    int find(int i) {
      return i;
    }

    private int root(int i) {
        while(i != id[i]){
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }
    // I think this method should return the current size of the tree.
    int union(int p, int q) {
        int i = root(p);
        int j = root(q);

        if (i == j) return treeSize[i];
        if  (treeSize[i] < treeSize[j]) {
            id[i] = j;
            treeSize[j] += treeSize[i];
            return treeSize[j];// The current size of the tree.
        }  else{
            id[j] = i;
            treeSize[i] += treeSize[j];
            return treeSize[i];// The current size of the tree.
        }
    }
}
