import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ClassContainer kalsa = new DataGenerator().container;
        JFrame x = new ClassesForm("Klasa", kalsa);
        x.setVisible(true);
        x.setSize(600, 500);
        //all checked in project
    }
}