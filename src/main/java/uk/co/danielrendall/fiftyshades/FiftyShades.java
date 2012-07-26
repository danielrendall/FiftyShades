package uk.co.danielrendall.fiftyshades;
import uk.co.danielrendall.fiftyshades.impl.*;

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
        Color startColor1 = Color.RED;
        Color endColor1 = Color.CYAN;
        Color startColor2 = Color.GREEN;
        Color endColor2 = Color.MAGENTA;
        Color startColor3 = Color.BLUE;
        Color endColor3 = Color.YELLOW;
        ColorSupplier cs = new Interleaver(new SimpleShadeInterpolator(startColor1, endColor1, 16),
                new SimpleShadeInterpolator(startColor2, endColor2, 16),
                new SimpleShadeInterpolator(startColor3, endColor3, 16));
//        ColorSupplier cs = new Interleaver(new HsbInterpolator(startColor1, endColor1, 16, HsbInterpolator.Direction.Positive),
//                new HsbInterpolator(startColor2, endColor2, 16, HsbInterpolator.Direction.Positive),
//                new HsbInterpolator(startColor3, endColor3, 16, HsbInterpolator.Direction.Positive));

        int width = cs.getNumberOfColors() * 12;

        BufferedImage image =
          new BufferedImage(width, 450, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = image.createGraphics();
        for (int i=0; i<cs.getNumberOfColors(); i++) {
            int xLeft = i*12;
            g2.setColor(cs.getColor(i));
            g2.fillRect(xLeft, 0, 12, 450);
        }
        File outputFile = new File("fiftyshades.png");
        ImageIO.write(image, "png", outputFile);
    }
}
