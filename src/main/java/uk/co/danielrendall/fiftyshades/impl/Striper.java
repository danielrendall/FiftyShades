package uk.co.danielrendall.fiftyshades.impl;

import uk.co.danielrendall.fiftyshades.ColorSupplier;

import java.awt.*;

/**
 * @author Daniel Rendall
 */
public class Striper extends ColorSupplierDecorator {

    public Striper(ColorSupplier base, int stripeFactor) {
        super(base.getNumberOfColors());
        int colorPos = 0;
        for (int i=0; i<stripeFactor; i++) {
            for (int j = i; j < base.getNumberOfColors(); j+= stripeFactor) {
                colors[j] = base.getColor(colorPos);
                colorPos++;
            }
        }
    }
}
