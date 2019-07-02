import java.util.Arrays;

public class KMP {
    public static void main(String[] args) {
        String t = "ababababca";
        String p = "abababca";

        int[] next = createNext(p);
        System.out.println(Arrays.toString(next));
        int idx = find(t, p, next);
        System.out.println(idx);
    }

    private static int find(String t, String p, int[] next) {
        int i = 0;
        int j = 0;
        while (i < t.length() && j < p.length()) {
            if (t.charAt(i) == p.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == p.length()) {
            return i - p.length();
        }
        return -1;
    }

    private static int[] createNext(String p) {
        int[] next = new int[p.length()];
        int i = 0;
        int j = -1;
        next[0] = -1;
        while (i < p.length() - 1) {
            if (j == -1 || p.charAt(i) == p.charAt(j)) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
        return next;

    }
}
