package demobasic;

public class DemoExample {
    public static void main(String[] args) {
        String locatorXpath = "//input[@type='radio' and @value='%s']"; // động chuỗi %s (%s là placeholder)
        String locatorButton1 = String.format(locatorXpath, "Button1");
        System.out.println(locatorButton1);
    }
}
