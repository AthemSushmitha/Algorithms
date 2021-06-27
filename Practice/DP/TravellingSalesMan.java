 /* Held Karp/DP method of finding tour of traveling salesman. Find the minimum cost tour for the given map such that it touches all vertices once.
 *
 * Time complexity - O(2^n * n^2)
 * Space complexity - O(2^n)
 *
 /
 public class TravellingSalesMan {
     public const INFINITY = 100000;
     public static void main (String args[]) {
         TravellingSalesMan tsp = new TravellingSalesMan();
         int graph[][] = {{0, 1, 15, 6},{2, 0, 7, 3},{9, 6, 0, 12}, {10, 4, 8, 0}};
         System.out.println(tsp.minCostDP(graph));
    }
    
    private int minCostDP(int[][] distance) {
        Map<Index, Integer> minCostDP = new HashMap<>();
        Map<Index, Integer> parent = new HashMap<>();
        List<Set<Integer>> allSets = generateCombinations(distance.length -1);
        for(Set<Integer> set: allSets) {
            for(int currentVertex = 1; currentVertex < distance.length; currentVertex++) {
                if(set.contains(currentVertex) {
                    continue;
                }
                int minCost = INFINITY;
                int minPrevVertex = 0;
                Index = createIndex(currentVertex,set);
                Set<Integer> copySet = new HashSet<>(set);
                if (set.size == 0) {
                    minCost = distance[0][currentVertex];
                    minPrevVertex = 0;
                }
                for(int prevVertex: set) {
                    cost = distance[prevVertex][currentVertex] + getCost(copySet,prevVertex,minCostDP);
                    if(minCost < cost) {
                        minCost = cost;
                        minPrevVertex = prevVertex;
                    }
                }
                minCostDP.put(index,minCost);
                parent.put(index,minPrevVertex);
            }
            
        }
        Set<Integer> set = new HashSet<>();
        for(int i =1; i < distance.length; i++) {
            set.add(i);
        }
        int min = Integer.MAX_VALUE;
        int prevVetex = -1;
        Set<Integer> copySet = new HashSet<>(set);
        for(int k : set) {
            int cost = distance[k][0] + getCost(copySet, k, minCostDP);
            if(cost < min) {
                min = cost;
                prevVetex = k;
            }
        }
        parent.put(Index.createIndex(0,set), prevVetex);
        printTour(parent, distance.length);
        return min;
    }
    
    private int getCost(Set<Integer> set, int prevVertex, Map<Index, Integer> minCostDP){
        set.remove(prevVertex);
        Index index = Index.createIndex(prevVertex,set);
        int cost = minCostDP.get(index);
        set.add(prevVertex);
        return cost;
        
    }
    
    public List<Set<Integer>> generateCombinations(int n){
       int input[] = new int[n];
       int result = new int[input.length];
       for(int i=0; i < input.length; i++){
           input[i] = i +1;
       }
       List<Set<Integer>> allSets = new ArrayList<>();
       generateCombinations(allSets, 0, 0, input, result);
       collections.sort(allSets, new SetSizeComparator());
       return allSets;
    }
    
    pubic void generateCombinations(List<Set<Integer>> allSets, int start, int pos, int[] input, int[] result){
        if(pos == input.length) {
            return;
        }       
        Set<Integer> set = createSet(result, pos);
        allSets.add(set);
        for(int i = pos; pos < input.length; i++) {
            result[pos] = input[i];
            generateCombinations(allSets, i+1, pos+1, input, result);
        }
    }
    
    public Set<Integer> createSet(int input[], int pos) {
        if(pos == 0){
            return new HashSet<>();
        }
        Set<Integer> set = new HashSet<>();
        for(i=0; i < pos; i++){
            set.add(input[i]);
        }
        return set;
    }
    
    private void printTour(Map<Index, Integer> parent, int totalVertices) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < totalVertices; i++) {
            set.add(i);
        }
        Integer start = 0;
        Deque<Integer> stack = new LinkedList<>();
        while(true) {
            stack.push(start);
            set.remove(start);
            start = parent.get(Index.createIndex(start,set));
            if(start == null) {
                break;
            }
        }
        StringJoiner joiner = new StringJoiner("->");
        stack.forEach( v -> joiner.add(String.valueOf(v)));
        System.out.println("\nTSP tour");
        System.out.println(joiner.toString());
    }   
    
    private static class SetSizeComparator implements Comparator<Set<Integer>>{
       public int compare(Set<Integer> o1, Set<Integer> o2) {
           return o1.size() - o2.size();
       }
    }
    
    private static class Index {
        Set<Integer>  currentVertexSet;
        int currentVertex;
        
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Index index = (Index) o;

            if (currentVertex != index.currentVertex) return false;
            return !(vertexSet != null ? !vertexSet.equals(index.vertexSet) : index.vertexSet != null);
        }

        public int hashCode() {
            int result = currentVertex;
            result = 31 * result + (vertexSet != null ? vertexSet.hashCode() : 0);
            return result;
        }
        
        public Index createIndex(Set<Integer> s, int v) {
            Index i = new Index();
            i.currentVertexSet = s;
            i.currentVertex = v;
            return i;
        }
    }
    
 }
