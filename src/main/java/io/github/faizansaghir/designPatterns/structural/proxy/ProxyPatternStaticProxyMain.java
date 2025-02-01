package io.github.faizansaghir.designPatterns.structural.proxy;

import io.github.faizansaghir.designPatterns.structural.proxy.common.Image;
import io.github.faizansaghir.designPatterns.structural.proxy.staticProxy.ImageFactory;

import java.awt.geom.Point2D;

public class ProxyPatternStaticProxyMain {
    public static void main(String[] args) {
        Image image = ImageFactory.getImage("img.bmp");
        image.setLocation(new Point2D.Double(0,0));
        System.out.println("Image location :"+image.getLocation());
        System.out.println("Rendering image now....");
        image.render();
    }
}
