import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("27880.txt"));
        String[] firstLine = br.readLine().split(" ");
        int S = Integer.parseInt(firstLine[0]);
        int N = Integer.parseInt(firstLine[1]);
        
        int[] files = new int[N];
        for (int i = 0; i < N; i++) {
            files[i] = Integer.parseInt(br.readLine());
        }
        br.close();
        
        Arrays.sort(files);
        
        int count = 0;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            if (sum + files[i] <= S) {
                sum += files[i];
                count++;
            } else {
                break;
            }
        }
   
        int maxFileSize = 0;
        
        if (count > 0) {
            int sumWithoutLast = 0;
            for (int i = 0; i < count - 1; i++) {
                sumWithoutLast += files[i];
            }
            
            for (int i = count - 1; i < N; i++) {
                if (sumWithoutLast + files[i] <= S) {
                    maxFileSize = Math.max(maxFileSize, files[i]);
                }
            }
            
            if (maxFileSize == 0) {
                maxFileSize = files[count - 1];
            }
        }
        
        System.out.println(count + " " + maxFileSize);
    }
}
