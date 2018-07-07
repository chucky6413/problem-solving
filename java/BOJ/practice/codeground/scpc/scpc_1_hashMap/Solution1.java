import java.util.Scanner;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.Collection;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.HashMap;

public class Solution1 {
    public static void main(String[] arg) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        int t = Integer.parseInt(st.nextToken()); //test case ��


        for (int i = 1; i <= t; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            int n = Integer.parseInt(st.nextToken()); //���� ��� ������..
            int result = 0; //���
            st = new StringTokenizer(in.readLine(), " ");
            HashMap<Integer, Item> map = new HashMap<Integer, Item>();
            while (st.hasMoreTokens()) {
                int num = Integer.parseInt(st.nextToken());
                if (map.containsKey(num)) { //�̹� ���� �� �ִٸ�.. ++
                    map.get(num).addCount();
                } else {
                    map.put(num, new Item(num, 1));
                }
            }
            Collection<Item> list = map.values();
            Iterator<Item> e = list.iterator();
            int j = -1; //ù���� ã�� ����
            while (e.hasNext()) {
                Item item = (Item) e.next();
                if (item.getCount() % 2 == 1) {
                    if (j == -1) {
                        result = item.getKey();
                        j = 0;
                    } else {
                        result ^= item.getKey();
                    }
                }
            }

            System.out.println("Case #" + i);
            System.out.println(result);
        }
    }

    public static class Item {
        private int key;
        private int count;

        public Item(int key, int count) {
            this.key = key;
            this.count = count;
        }

        public int getKey() {
            return key;
        }

        public int getCount() {
            return count;
        }

        public void addCount() {
            count++;
        }
    }
}