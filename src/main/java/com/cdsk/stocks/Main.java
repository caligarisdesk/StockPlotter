package com.cdsk.stocks;

import java.io.File;
import java.io.IOException;
import java.util.stream.IntStream;

import org.jcodec.api.awt.SequenceEncoder;
import org.jcodec.common.model.Picture;

/**
 * Created by johnmcnamara on 11/30/16.
 */
public class Main {

    public static void main(String[] args) {
        try {
            SequenceEncoder enc = new SequenceEncoder(new File("filename.mp4"));
            for(int i = 0; i < 100; i++) {
                DayScatter demo = new DayScatter("Which operating system are you using?");
                try {
                    enc.encodeImage(demo.createBufferedImage());
                } catch (IOException ioe) {

                }
            }
            enc.finish();
        } catch (IOException ioe) {

        }


    }

}
