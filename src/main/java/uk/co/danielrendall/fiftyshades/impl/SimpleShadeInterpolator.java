package uk.co.danielrendall.fiftyshades.impl;

import uk.co.danielrendall.fiftyshades.ColorSupplier;

import java.awt.*;

/**
 * @author Daniel Rendall
 */
public class SimpleShadeInterpolator implements ColorSupplier {

    private final Color startColor;
    private final Color endColor;
    private final int numberOfShades;
    private final float[] startArray;
    private final float rInc;
    private final float gInc;
    private final float bInc;

    public SimpleShadeInterpolator(Color startColor, Color endColor, int numberOfShades) {
        this.startColor = startColor;
        this.endColor = endColor;
        this.numberOfShades = numberOfShades;
        if (numberOfShades < 2) {
            throw new IllegalArgumentException("Should be at least two shades");
        }
        float steps = (float) numberOfShades - 1.0f;
        startArray = startColor.getRGBColorComponents(null);
        float[] endArray = endColor.getRGBColorComponents(null);
        rInc = (endArray[0] - startArray[0]) / steps;
        gInc = (endArray[1] - startArray[1]) / steps;
        bInc = (endArray[2] - startArray[2]) / steps;
    }

    public Color getColor(int index) {
        float i = (float) index;
        float r = startArray[0] + i * rInc;
        float g = startArray[1] + i * gInc;
        float b = startArray[2] + i * bInc;
        return new Color(r, g, b);
    }

    public int getNumberOfColors() {
        return numberOfShades;
    }
}
