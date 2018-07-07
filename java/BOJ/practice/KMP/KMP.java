/*
 * 2017.04.14
 * KMP - �˰��� practice..
 * 
 * @github https://github.com/chucky6413
 * @author chucky3
 */

import java.util.*;
import java.io.*;

public class KMP {
    static char obj[]; //�˻� ���
    static char st[]; //ã�� ���ڿ�
    static int fail[]; //��ó��

    public static void main(String arg[]) throws IOException {

        obj = "aabcdabcdabcwzabcdabcwz".toCharArray(); //�˻� ���
        st = "abcdabcwz".toCharArray(); //ã�� ���ڿ�
        //obj = "ababacababab".toCharArray(); //�˻� ���
        //st = "ababab".toCharArray(); //ã�� ���ڿ�
        fail = new int[st.length];
        fail();
        System.out.println(obj);
        System.out.println(st);
        System.out.println(Arrays.toString(fail));
        comp();
    }

    public static void comp() {
        int count = 0;
        for (int i = 0, j = 0; i < obj.length; i++) {
            count++;
            while (j > 0 && st[j] != obj[i]) {
                count++;
                j = fail[j - 1];
            }
            if (st[j] == obj[i])
                j++;
            if (j == st.length) {
                System.out.println(i - st.length + 1);
                j = fail[st.length - 1];
            }
        }
        System.out.println(count);
    }

    public static void fail() {
        for (int i = 1; i < st.length; i++) {
            int index = fail[i - 1];
            while (index > 0 && st[index] != st[i]) {
                index = fail[index - 1];
            }
            if (st[index] == st[i]) {
                fail[i] = index + 1;
            } else {
                fail[i] = 0;
            }
        }
    }
}