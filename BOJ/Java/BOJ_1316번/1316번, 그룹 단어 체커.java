import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int cnt = num;

        for(int i = 0; i < num; i++){
            boolean check[] = new boolean[26];
            String str = sc.next();

            for(int j = 0; j < str.length() - 1; j++){
                if(str.charAt(j) != str.charAt(j + 1)){
                    if(check[str.charAt(j + 1) - 97] == true){
                        cnt--;
                        break;
                    }
                }
                check[str.charAt(j) - 97]=true;
            }
        }
        System.out.println(cnt);
    }
}