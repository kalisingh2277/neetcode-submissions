class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        int open_count = 0;
        int closing_count = 0;

        generate(n, open_count, closing_count, list, new StringBuilder());
        return list;
    }

    public static void generate(int n, int o_c, int c_c, List<String> list, StringBuilder current_set) {
        if (current_set.length() == n * 2) {
            if (o_c == c_c && o_c == n) {//this if loop is not necesaary here because if list length is == n*2 then automatically open_count and Close _count and n*2 are equal
                list.add(current_set.toString());
                return;
            }
        }

        if (o_c < n) {
            current_set.append("(");
            generate(n, o_c + 1, c_c, list, current_set);
            //undoing the choice
            current_set.deleteCharAt(current_set.length() - 1);
        }
        if (c_c < o_c) {
            current_set.append(")");
            generate(n, o_c, c_c + 1, list, current_set);
            //undoing the choice
            current_set.deleteCharAt(current_set.length() - 1);
        }

    }
}