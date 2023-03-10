package main.artfix;

public class Main {
    public static void main(String[] args) {
        FileIng.read("banner");
        String ApplicationBanner = FileIng.ReadData;

        if (ApplicationBanner.equals("true")) {
            System.out.println("Support projects https://ko-fi.com/artfixprog.");
            Application.start();
        } else {
            Application.start();
        }


    }
}
