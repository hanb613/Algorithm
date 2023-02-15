import java.io.*;
import java.util.*;

public class Main {

    static int n, m, r;
    static int[][] arr;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<r; i++) {
        	
            switch(st.nextToken()) {
                case "1":
                    solve1(); break;
                case "2":
                    solve2(); break;
                case "3":
                    solve3(); break;
                case "4":
                    solve4(); break;
                case "5":
                    solve5(); break;
                case "6":
                    solve6(); break;
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    private static void solve1() {
        int[][] result = new int[n][m];
        int idx=n-1;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
            	result[i][j] = arr[idx][j];
            }
            idx--;
        }
        arr = result;
    }

    private static void solve2() {
        int[][] result = new int[n][m];
        for(int i=0; i<n; i++) {
            int idx=m-1;
            for(int j=0; j<m; j++) {
            	result[i][j] = arr[i][idx];
                idx--;
            }
        }
        arr = result;
    }

    private static void solve3() {
        int[][] result = new int[m][n];

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                result[j][n-1-i] = arr[i][j];
            }
        }
        int tmp = n; n=m; m=tmp;

        arr = result;
    }

    private static void solve4() {
        int[][] result = new int[m][n];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                result[i][j] = arr[j][m-1-i];
            }
        }
        int tmp = m; m=n; n=tmp;

        arr = result;
    }

    private static void solve5() {
        int[][] result = new int[n][m];
        for(int i=0; i<n/2; i++) {
            for(int j=0; j<m/2; j++) {
            	result[i][m/2+j] = arr[i][j];
            }
        }

        for(int i=0; i<n/2; i++) {
            for(int j=m/2; j<m; j++) {
            	result[n/2+i][j] = arr[i][j];
            }
        }

        for(int i=n/2; i<n; i++) {
            for(int j=m/2; j<m; j++) {
            	result[i][j-m/2] = arr[i][j];
            }
        }

        for(int i=n/2; i<n; i++) {
            for(int j=0; j<m/2; j++) {
            	result[i-n/2][j] = arr[i][j];
            }
        }

        arr = result;
    }

    private static void solve6() {
        int[][] result = new int[n][m];
        for(int i=0; i<n/2; i++) {
            for(int j=0; j<m/2; j++) {
            	result[n/2+i][j] = arr[i][j];
            }
        }

        for(int i=n/2; i<n; i++) {
            for(int j=0; j<m/2; j++) {
            	result[i][m/2+j] = arr[i][j];
            }
        }

        for(int i=n/2; i<n; i++) {
            for(int j=m/2; j<m; j++) {
            	result[i-n/2][j] = arr[i][j];
            }
        }

        for(int i=0; i<n/2; i++) {
            for(int j=m/2; j<m; j++) {
            	result[i][j-m/2] = arr[i][j];
            }
        }

        arr = result;
    }
}