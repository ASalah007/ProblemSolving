import java.util.Scanner;

public class Main {

    public

    static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();


        for (int i = 0; i < t; i++) {
            StringBuilder out = new StringBuilder();
            int n = sc.nextInt();
            int p = sc.nextInt();
            int edges = 0;

            loop:
            for (int j = 1; j <= n; j++) {
                for (int k = j + 1; k <= n; k++) {
                    out.append(j + " " + k + "\n");
                    edges++;
                    if (edges == 2 * n + p) {
                        break loop;
                    }
                }
            }
            System.out.println(out);
        }
    }
}
