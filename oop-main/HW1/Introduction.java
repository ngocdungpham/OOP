public class Introduction {
    public static void main(String[] args) {
        String name = "PhamNgocDung";
        int StudentId = 24020094;
        String Class = "K69I_IT4";
        String username = "ngocdungpham";
        String email = "24020094@vnu.edu.vn";
        String tab = "\\";
        System.out.println(name + tab + StudentId + tab + Class + tab + username + tab + email);

        String s1 = " bottles of beer on the wall, ";
        String s2 = " bottles of beer.";
        String s3 = "Take one down, pass it around,";
        String end = "No more bottles of beer on the wall.";
        for (int i = 9; i >= 1; i--) {
            if (i == 1) {
                System.out.println(i + s1 + i + s2);
                System.out.println(s3);
                System.out.println(end);
            } else {
                System.out.println(i + s1 + i + s2);
                System.out.println(s3);
            }
        }
    }
}
