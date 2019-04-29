public class LongPressedName {
    public boolean isLongPressedName(String name, String typed) {
        int nameIndex = 0;

        if (typed.charAt(0) != name.charAt(0)) return false;
        if (typed.charAt(typed.length() - 1) != name.charAt(name.length() - 1)) return false;

        for (int i = 0; i < typed.length(); i++) {
            if (typed.charAt(i) == name.charAt(nameIndex)) {
                if (nameIndex < name.length() - 1) {
                    nameIndex ++;
                }
            } else if (typed.charAt(i) != name.charAt(nameIndex - 1)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        LongPressedName lpn = new LongPressedName();
        System.out.println(lpn.isLongPressedName("abcd", "aaabcccc"));
    }
}
