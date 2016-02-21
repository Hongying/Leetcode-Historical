import java.util.Arrays;

public class StrStr {
    /*
     * find needle in a hay, what if you are allowed to match permutation
     */
    public int strstr(String haystack, String needle) {
        if (needle == null || haystack == null) {
            return -1;
        }
        if (needle.equals("")) {
            return 0;
        }
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (compare(haystack.substring(i, needle.length() + i), needle)) {
                return i;
            }
        }
        return -1;
    }

    // check if they are permutations
    public boolean compare(String a, String b) {
        char[] c1 = a.toCharArray();
        char[] c2 = b.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        return (Arrays.toString(c1).equals(Arrays.toString(c2)));
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        StrStr sol = new StrStr();
        System.out.println(sol.strstr("abdcda", "cd"));
    }

}
