package io.github.faizansaghir.designPatterns.structural.proxy.staticProxy;

import io.github.faizansaghir.designPatterns.structural.proxy.common.BitmapImage;
import io.github.faizansaghir.designPatterns.structural.proxy.common.Image;

import java.awt.geom.Point2D;

public class ImageProxy implements Image {
    private BitmapImage bitmapImage;
    private final String name;
    private Point2D location;
    public ImageProxy(String name) {
        this.name = name;
    }
    @Override
    public void setLocation(Point2D location) {
        if(bitmapImage!=null)
            bitmapImage.setLocation(location);
        else
            this.location=location;
    }

    @Override
    public Point2D getLocation() {
        if(bitmapImage!=null)
            return bitmapImage.getLocation();
        else
            return location;
    }

    @Override
    public void render() {
        if(bitmapImage==null){
            bitmapImage = new BitmapImage(name);
            if(location!=null)
                bitmapImage.setLocation(location);
        }
        bitmapImage.render();
    }
}
