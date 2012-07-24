package uk.co.danielrendall.fiftyshades.impl;

import uk.co.danielrendall.fiftyshades.ColorSupplier;

import java.awt.*;
import java.awt.color.ColorSpace;

/**
 * @author Daniel Rendall
 */
public class HsbInterpolator implements ColorSupplier {

    public enum Direction {
        Longest,
        Shortest,
        Positive,
        Negative
    }

    private final Color startColor;
    private final Color endColor;
    private final int numberOfShades;
    private final float[] startArray;
    private final float hInc;
    private final float sInc;
    private final float bInc;

    public HsbInterpolator(Color startColor, Color endColor, int numberOfShades, Direction direction) {
        this.startColor = startColor;
        this.endColor = endColor;
        this.numberOfShades = numberOfShades;
        if (numberOfShades < 2) {
            throw new IllegalArgumentException("Should be at least two shades");
        }
        float steps = (float) numberOfShades - 1.0f;
        startArray = Color.RGBtoHSB(startColor.getRed(), startColor.getGreen(), startColor.getBlue(), null);
        float[] endArray = Color.RGBtoHSB(endColor.getRed(), endColor.getGreen(), endColor.getBlue(), null);

        float startHue = startArray[0];
        float endHue = endArray[0];
        final float difference = endHue - startHue;
        if (difference >= 0) {
            switch (direction) {
                case Positive:
                    // fine, do nothing
                    break;
                case Negative:
                    endHue -= 1.0f;
                    break;
                default:
                    if (difference < 0.5) {
                        switch (direction) {
                            case Longest:
                                endHue -= 1.0f;
                                break;
                            case Shortest:
                                // fine
                                break;
                        }
                    } else {
                        switch (direction) {
                            case Longest:
                                break;
                            case Shortest:
                                endHue -= 1.0f;
                                break;
                        }
                    }
                    break;
            }
        } else {
            switch (direction) {
                case Positive:
                    startHue -= 1.0f;
                    break;
                case Negative:
                    // fine, do nothing
                    break;
                default:
                    if (difference < 0.5) {
                        switch (direction) {
                            case Longest:
                                startHue -= 1.0f;
                                break;
                            case Shortest:
                                // fine
                                break;
                        }
                    } else {
                        switch (direction) {
                            case Longest:
                                break;
                            case Shortest:
                                startHue -= 1.0f;
                                break;
                        }
                    }
                    break;
            }
        }

        startArray[0] = startHue;
        endArray[0] = endHue;

        hInc = (endArray[0] - startArray[0]) / steps;
        sInc = (endArray[1] - startArray[1]) / steps;
        bInc = (endArray[2] - startArray[2]) / steps;
    }


    public Color getColor(int index) {
        float i = (float) index;
        float h = startArray[0] + i * hInc;
        float s = startArray[1] + i * sInc;
        float b = startArray[2] + i * bInc;
        return Color.getHSBColor(h, s, b);
    }

    public int getNumberOfColors() {
        return numberOfShades;
    }

    public Color getStartColor() {
        return startColor;
    }

    public Color getEndColor() {
        return endColor;
    }
}
