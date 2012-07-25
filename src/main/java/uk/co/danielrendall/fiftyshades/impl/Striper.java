package uk.co.danielrendall.fiftyshades.impl;

import uk.co.danielrendall.fiftyshades.ColorSupplier;

import java.awt.*;

/**
 * @author Daniel Rendall
 */
public class Striper implements ColorSupplier {

    private final Color[] colors;

    public Striper(ColorSupplier base, int stripeFactor) {
        colors = new Color[base.getNumberOfColors()];
        int colorPos = 0;
        for (int i=0; i<stripeFactor; i++) {
            for (int j = i; j < base.getNumberOfColors(); j+= stripeFactor) {
                colors[j] = base.getColor(colorPos);
                colorPos++;
            }
        }
    }

    public int getNumberOfColors() {
        return colors.length;
    }

    public Color getColor(int index) {
        return colors[index];
    }

    public Color getStartColor() {
        return getColor(0);
    }

    public Color getEndColor() {
        return getColor(getNumberOfColors() - 1);
    }
}
