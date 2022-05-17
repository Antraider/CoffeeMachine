import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int o = n;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) { 
                if (o == 0) {
                    break;
                } else {
                    System.out.print(i + " ");
                    o--;
                }
            }
            
        }
    }
}
