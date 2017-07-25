package de.hochschule_bochum.matrixtable.ledmatrix;

import de.hochschule_bochum.matrixtable.ledmatrix.objects.Color;
import de.hochschule_bochum.matrixtable.ledmatrix.objects.ColorType;
import de.hochschule_bochum.matrixtable.ledmatrix.objects.Display;
import de.hochschule_bochum.matrixtable.ledmatrix.objects.SevenSegment;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by nikla on 04.07.2017.
 */
public class Examples {

    public void RGBFade() {
        Display display = new Display(53, 1);
        int r = 255;
        int g = 0;
        int b = 0;
        while (true) {
            int loops = 255 * 3;
            while (loops > 0) {
                if (r > 0 && b == 0) {
                    r--;
                    g++;
                }
                if (g > 0 && r == 0) {
                    g--;
                    b++;
                }
                if (b > 0 && g == 0) {
                    r++;
                    b--;
                }
                loops--;
                display.setAll(new Color((byte) r, (byte) g, (byte) b));
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
                }
            }
            display.clear();

        }
    }

    public void colorLoop() {
        Display display = new Display(53, 1);
        try {
            while (true) {

                for (ColorType color : ColorType.values()) {
                    display.setAll(new Color(color));

                    for (double d = 0D; d <= 1D; d += 0.05) {
                        display.setGlobal_brightness(d);
                        Thread.sleep(100);
                    }

                    for (double d = 1D; d >= 0D; d -= 0.05) {
                        display.setGlobal_brightness(d);

                        Thread.sleep(100);
                    }
                }
            }
        } catch (InterruptedException e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
        }
    }

    public void maxCurrent() {
        Display display = new Display(53, 1);
        display.setAll(new Color((byte)255,(byte)255,(byte)255));
        display.setGlobal_brightness(1d);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        display.clear();
    }

    public void sevenSegmentCount() {
        try {
            SevenSegment segement = new SevenSegment();
            for (SevenSegment.Number number : SevenSegment.Number.values()) {
                segement.setNumber(number, new Color(ColorType.BLUE));
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
        }

    }
}