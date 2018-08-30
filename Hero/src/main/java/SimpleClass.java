import java.util.ArrayList;

public class SimpleClass {
    public static void main(String[] args) {

        String element = ".field-size-large";
        String state = "focus";
        String cssValue = "background-color";

        System.out.println("return window.getComputedStyle(document.querySelector('"+element+"'),':"+state+"').getPropertyValue('"+cssValue+"')");

    }

}

