import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder in = new StringBuilder();
        int n = sc.nextInt();
        while(sc.hasNext()){
            in.append(sc.nextLine());
        }
        Pattern p = Pattern.compile("<a\\s*href\\s*=\\s*\"([^\"]*)\".*?>\\s*(<b>)?([^<]*)(</b>)?</a>");
        Matcher m = p.matcher(in);
        while(m.find())
            System.out.println(m.group(1)+","+m.group(3));
    }
}
