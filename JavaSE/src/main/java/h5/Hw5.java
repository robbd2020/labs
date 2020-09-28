package h5;

public class Hw5 {
    public static class Fibo {
        int run(int n) {
            if ( n < 2) return n;
            return run(n - 2) + run(n - 1);
        }

        public void printFiboRec(int n){
            for (int i =1; i <=n; i++){
                System.out.print(run(i) + " ");
            }
        }
    }


}


