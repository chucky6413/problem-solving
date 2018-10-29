public class Solution67 {
    public String addBinary(String a, String b) {
        int indexA = a.length() - 1;
        int indexB = b.length() - 1;

        StringBuilder rs = new StringBuilder();
        int sumvalue = 0;
        while (indexA >= 0 || indexB >= 0) {

            if (indexA >= 0) {
                sumvalue += (a.charAt(indexA--) - '0');
            }

            if (indexB >= 0) {
                sumvalue += (b.charAt(indexB--) - '0');
            }

            rs.append(sumvalue % 2);
            sumvalue = sumvalue >= 2 ? 1 : 0;
        }

        if (sumvalue != 0) {
            rs.append('1');
        }

        return rs.reverse().toString();
    }
}