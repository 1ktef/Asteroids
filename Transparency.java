package com.asteroids;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;
import java.awt.image.RGBImageFilter;

public class Transparency {
  public static Image makeColorTransparent(Image im, final Color color) {
    ImageFilter filter = new RGBImageFilter() {
      // the color we are looking for... Alpha bits are set to opaque
      public int markerRGB = color.getRGB() | 0xFF000000;
      @Override
      public final int filterRGB(int x, int y, int rgb) {
        if ((rgb | 0xFF000000) == markerRGB) {
          // Mark the alpha bits as zero - transparent
          return 0x00FFFFFF & rgb;
        } else {
          // nothing to do
          return rgb;
        }
      }
    };

    ImageProducer ip = new FilteredImageSource(im.getSource(), filter);
    return Toolkit.getDefaultToolkit().createImage(ip);
  }
}