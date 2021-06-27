public class MinimumJumps {
    public static void main(String args[]) {
        MinimumJumps mj = new MinimumJumps();
        int arr[] = {1,3,5,3,2,2,6,1,6,8,9};
        int r[] = int[arr.length];
        System.out.println(mj.minimumJumps(arr,r));
    }
    int minimumJumps(int[] input, int[] result) {
        int jump[] = new [input.length+1];
        jump[0] = 0;
        for(i=1; i < jump.length; i++) 
            jump[i] = Integr.Max;
        for(i=0;i<arr.length;i++){
            for(j=0; j < i; j++) {
               if(input[j] + j >= i) {
                  if(jump[i] > jump[j] + 1){
                       result[i] = j;
                       jump[i] = jump[j] + 1;
               } 
            }
        }
       return jump[jump.length-1];
    }
}