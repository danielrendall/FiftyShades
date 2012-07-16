package uk.co.danielrendall.fiftyshades;

import java.awt.*;

/**
 * @author Daniel Rendall
 */
public interface ColorSupplier {

    public int getNumberOfColors();
    public Color getColor(int index);
}
