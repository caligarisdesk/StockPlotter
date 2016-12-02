package com.cdsk.stocks;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * Created by johnmcnamara on 11/30/16.
 */
public class Main {

    public static void main(String[] args) {
        PieChart demo = new PieChart("Which operating system are you using?");
        File f = new File("thing.png");
        try {
            demo.write(f);
        } catch (IOException ioe) {

        }
    }

}
