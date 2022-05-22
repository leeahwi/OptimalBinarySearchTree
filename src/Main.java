import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static int solution(int[] P, int n){

        int[][] C = new int[n+2][n+2];

        for(int i=1;i<=n+1;i++){
            C[i][i-1] = 0;
        }
        for(int s=0;s<=n-1;s++){
            for(int i=1;i<=n-s;i++){

                int sumP = 0;
                int min = 999999;

                for(int k=i;k<=i+s;k++){
                    sumP += P[k-1];
                    if(min>C[i][k-1]+C[k+1][i+s]) min = C[i][k-1]+C[k+1][i+s];
                }

                C[i][i+s] = sumP + min;
            }
        }

        return C[1][n];
    }

    public static void main(String[] args) {

        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int test = Integer.parseInt(br.readLine());

            for(int i=0;i<test;i++){

                int n = Integer.parseInt(br.readLine());

                int[] P = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

                System.out.println(solution(P,n));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
