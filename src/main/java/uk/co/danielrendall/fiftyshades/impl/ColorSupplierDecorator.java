package uk.co.danielrendall.fiftyshades.impl;

import uk.co.danielrendall.fiftyshades.ColorSupplier;

import java.awt.*;

/**
 * @author Daniel Rendall
 */
public abstract class ColorSupplierDecorator implements ColorSupplier {

    protected final Color[] colors;

    protected ColorSupplierDecorator(int numberOfColors) {
        this.colors = new Color[numberOfColors];
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
