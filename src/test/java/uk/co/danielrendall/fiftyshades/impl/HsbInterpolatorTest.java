package uk.co.danielrendall.fiftyshades.impl;

import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

/**
 * @author Daniel Rendall
 */

public class HsbInterpolatorTest {

    private final Color red = new Color(255, 0, 0);
    private final Color yellow = new Color(255, 255, 0);
    private final Color green = new Color(0, 255, 0);
    private final Color cyan = new Color(0, 255, 255);
    private final Color blue = new Color(0, 0, 255);
    private final Color magenta = new Color(255, 0, 255);

    private final float hueRed = getHue(red);
    private final float hueYellow = getHue(yellow);
    private final float hueGreen = getHue(green);
    private final float hueCyan = getHue(cyan);
    private final float hueBlue = getHue(blue);
    private final float hueMagenta = getHue(magenta);

    private final static float DELTA = 0.0001f;

    private static float getHue(Color aColor) {
        return Color.RGBtoHSB(aColor.getRed(), aColor.getGreen(), aColor.getBlue(), null)[0];
    }

    @Test
    public void testPositive1() {
        HsbInterpolator interpolator = new HsbInterpolator(red, green, 3, HsbInterpolator.Direction.Positive);
        Assert.assertEquals(hueRed, getHue(interpolator.getColor(0)), DELTA);
        Assert.assertEquals(hueYellow, getHue(interpolator.getColor(1)), DELTA);
        Assert.assertEquals(hueGreen, getHue(interpolator.getColor(2)), DELTA);
    }

    @Test
    public void testPositive2() {
        HsbInterpolator interpolator = new HsbInterpolator(red, magenta, 6, HsbInterpolator.Direction.Positive);
        Assert.assertEquals(hueRed, getHue(interpolator.getColor(0)), DELTA);
        Assert.assertEquals(hueYellow, getHue(interpolator.getColor(1)), DELTA);
        Assert.assertEquals(hueGreen, getHue(interpolator.getColor(2)), DELTA);
        Assert.assertEquals(hueCyan, getHue(interpolator.getColor(3)), DELTA);
        Assert.assertEquals(hueBlue, getHue(interpolator.getColor(4)), DELTA);
        Assert.assertEquals(hueMagenta, getHue(interpolator.getColor(5)), DELTA);
    }

    @Test
    public void testPositive3() {
        HsbInterpolator interpolator = new HsbInterpolator(cyan, magenta, 3, HsbInterpolator.Direction.Positive);
        Assert.assertEquals(hueCyan, getHue(interpolator.getColor(0)), DELTA);
        Assert.assertEquals(hueBlue, getHue(interpolator.getColor(1)), DELTA);
        Assert.assertEquals(hueMagenta, getHue(interpolator.getColor(2)), DELTA);
    }

    @Test
    public void testPositive4() {
        HsbInterpolator interpolator = new HsbInterpolator(blue, red, 3, HsbInterpolator.Direction.Positive);
        Assert.assertEquals(hueBlue, getHue(interpolator.getColor(0)), DELTA);
        Assert.assertEquals(hueMagenta, getHue(interpolator.getColor(1)), DELTA);
        Assert.assertEquals(hueRed, getHue(interpolator.getColor(2)), DELTA);
    }

    @Test
    public void testPositive5() {
        HsbInterpolator interpolator = new HsbInterpolator(cyan, green, 6, HsbInterpolator.Direction.Positive);
        Assert.assertEquals(hueCyan, getHue(interpolator.getColor(0)), DELTA);
        Assert.assertEquals(hueBlue, getHue(interpolator.getColor(1)), DELTA);
        Assert.assertEquals(hueMagenta, getHue(interpolator.getColor(2)), DELTA);
        Assert.assertEquals(hueRed, getHue(interpolator.getColor(3)), DELTA);
        Assert.assertEquals(hueYellow, getHue(interpolator.getColor(4)), DELTA);
        Assert.assertEquals(hueGreen, getHue(interpolator.getColor(5)), DELTA);
    }

    @Test
    public void testNegative1() {
        HsbInterpolator interpolator = new HsbInterpolator(green, red, 3, HsbInterpolator.Direction.Negative);
        Assert.assertEquals(hueGreen, getHue(interpolator.getColor(0)), DELTA);
        Assert.assertEquals(hueYellow, getHue(interpolator.getColor(1)), DELTA);
        Assert.assertEquals(hueRed, getHue(interpolator.getColor(2)), DELTA);
    }

    @Test
    public void testNegative2() {
        HsbInterpolator interpolator = new HsbInterpolator(magenta, red, 6, HsbInterpolator.Direction.Negative);
        Assert.assertEquals(hueMagenta, getHue(interpolator.getColor(0)), DELTA);
        Assert.assertEquals(hueBlue, getHue(interpolator.getColor(1)), DELTA);
        Assert.assertEquals(hueCyan, getHue(interpolator.getColor(2)), DELTA);
        Assert.assertEquals(hueGreen, getHue(interpolator.getColor(3)), DELTA);
        Assert.assertEquals(hueYellow, getHue(interpolator.getColor(4)), DELTA);
        Assert.assertEquals(hueRed, getHue(interpolator.getColor(5)), DELTA);
    }

    @Test
    public void testNegative3() {
        HsbInterpolator interpolator = new HsbInterpolator(magenta, cyan, 3, HsbInterpolator.Direction.Negative);
        Assert.assertEquals(hueMagenta, getHue(interpolator.getColor(0)), DELTA);
        Assert.assertEquals(hueBlue, getHue(interpolator.getColor(1)), DELTA);
        Assert.assertEquals(hueCyan, getHue(interpolator.getColor(2)), DELTA);
    }

    @Test
    public void testNegative4() {
        HsbInterpolator interpolator = new HsbInterpolator(red, blue, 3, HsbInterpolator.Direction.Negative);
        Assert.assertEquals(hueRed, getHue(interpolator.getColor(0)), DELTA);
        Assert.assertEquals(hueMagenta, getHue(interpolator.getColor(1)), DELTA);
        Assert.assertEquals(hueBlue, getHue(interpolator.getColor(2)), DELTA);
    }

    @Test
    public void testNegative5() {
        HsbInterpolator interpolator = new HsbInterpolator(green, cyan, 6, HsbInterpolator.Direction.Negative);
        Assert.assertEquals(hueGreen, getHue(interpolator.getColor(0)), DELTA);
        Assert.assertEquals(hueYellow, getHue(interpolator.getColor(1)), DELTA);
        Assert.assertEquals(hueRed, getHue(interpolator.getColor(2)), DELTA);
        Assert.assertEquals(hueMagenta, getHue(interpolator.getColor(3)), DELTA);
        Assert.assertEquals(hueBlue, getHue(interpolator.getColor(4)), DELTA);
        Assert.assertEquals(hueCyan, getHue(interpolator.getColor(5)), DELTA);
    }
}
