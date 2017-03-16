/*
 * @github https://github.com/chucky6413
 * @author chucky3
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Quadtree{  
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine());
        while( T-- > 0 ){
            String quadTree = new String(br.readLine());
             
            System.out.println(reverse(quadTree));
        } 
    }
     
    public static String reverse(String quadTree){
        if( quadTree.charAt(0) != 'x' )
            return quadTree.charAt(0) + "";
         
        // reverseQuadTree
        String rqt[] = new String[4];
         
        // 왼쪽 위 조각
        int beginIndex = 1;
        rqt[0] = reverse(quadTree.substring(beginIndex));
         
        // 오른쪽 위 조각
        beginIndex += rqt[0].length();
        rqt[1] = reverse(quadTree.substring(beginIndex));
         
        // 왼쪽 아래 조각
        beginIndex += rqt[1].length();
        rqt[2] = reverse(quadTree.substring(beginIndex));
         
        // 오른쪽 아래 조각
        beginIndex += rqt[2].length();
        rqt[3] = reverse(quadTree.substring(beginIndex));
         
        return 'x' + rqt[2] + rqt[3] + rqt[0] + rqt[1];
    }
}