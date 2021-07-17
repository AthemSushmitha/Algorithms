package EggDrop;

public class EggDrop {
    int calculateMinAttemptsEggNotBreakDP(int eggs, int floors) {
        int temp[][] = new int[eggs+1][floors+1];
        int res = 0;
        for(int i =0; i <= eggs; i++) {
            temp[i][0]=0; // when there are 0 floors, then 0 attempts
            temp[i][1]=1; // when there is only one floor, then it requires only 1 attempt
        }
        for(int j= 0; j <= floors; j++) {
            temp[1][j]= j;
        }
        for(int i=2; i <= eggs; i ++){
            for(int j = 2; j <= floors; j++){
                temp[i][j]= Integer.MAX_VALUE;
                for(int k = 2; k <= j; k++) {
                    res = 1+ Math.max(temp[i-1][k-1], temp[i][j-k]);
                    if(res < temp[i][j]) {
                        temp[i][j] = res;
                    }
                }
            }
        }
        return temp[eggs][floors];
    }
    int calculateMinAttemptsEggNotBreakRecursive(int eggs, int floors) {
        int res = 0;
        if(eggs == 1){
            return floors;
        }
        if(floors == 0 || floors == 1) {
            return floors;
        }
        int min = Integer.MAX_VALUE;
        for(int k = 2; k <= floors; k++) {
            res = 1+ Math.max(calculateMinAttemptsEggNotBreakRecursive(eggs-1,k-1), calculateMinAttemptsEggNotBreakRecursive(eggs,floors-k));
            if(res < min) {
                min = res;
            }
        }
        return min;
    }
    public static void main (String args[]) {
        EggDrop ed = new EggDrop();
        int eggs = 2, floors = 10;
        System.out.println("Minimum number of attempts required to find from which floor egg will break is "+ ed.calculateMinAttemptsEggNotBreakDP(eggs, floors));
        System.out.println("Minimum number of attempts required to find from which floor egg will break is "+ ed.calculateMinAttemptsEggNotBreakRecursive(eggs, floors));

    }
}
