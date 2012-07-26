package uk.co.danielrendall.fiftyshades.impl;

import uk.co.danielrendall.fiftyshades.ColorSupplier;

import java.awt.*;

/**
 * @author Daniel Rendall
 */
public class Interleaver extends ColorSupplierDecorator {

    public Interleaver(ColorSupplier... bases) {
        super(getTotalLength(bases));
        int totalLength = getTotalLength(bases);
        int index=0;
        int colorCount=0;
        while (colorCount < totalLength) {
            for (int j=0; j<bases.length; j++) {
                if (index < bases[j].getNumberOfColors()) {
                    colors[colorCount] = bases[j].getColor(index);
                    colorCount++;
                }
            }
            index++;
        }
    }

    private static int getTotalLength(ColorSupplier... bases) {
        int i=0;
        for (ColorSupplier base : bases) {
            i+= base.getNumberOfColors();
        }
        return i;
    }
}
