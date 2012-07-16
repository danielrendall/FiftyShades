package uk.co.danielrendall.fiftyshades;
import uk.co.danielrendall.fiftyshades.impl.SimpleShadeInterpolator;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author Daniel Rendall
 */
public class FiftyShades {

    public static void main(String[] args) throws IOException {
        BufferedImage image =
          new BufferedImage(600, 450, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = image.createGraphics();
        Color startColor = new Color(0.15f, 0.15f, 0.15f);
        Color endColor = new Color(0.85f, 0.85f, 0.85f);
        ColorSupplier cs = new SimpleShadeInterpolator(startColor, endColor, 50);
        for (int i=0; i<25; i++) {
            int xLeft = i*24;
            g2.setColor(cs.getColor(i));
            g2.fillRect(xLeft, 0, 12, 450);
        }
        for (int i=0; i<25; i++) {
            int xLeft = i*24 + 12;
            g2.setColor(cs.getColor(i+25));
            g2.fillRect(xLeft, 0, 12, 450);
        }
        File outputFile = new File("fiftyshades.png");
        ImageIO.write(image, "png", outputFile);
    }
}
