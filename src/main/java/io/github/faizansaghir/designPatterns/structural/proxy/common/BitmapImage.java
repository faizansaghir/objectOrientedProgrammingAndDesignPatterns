package io.github.faizansaghir.designPatterns.structural.proxy.common;

import java.awt.geom.Point2D;

public class BitmapImage implements Image {
    private Point2D location;
    private final String name;

    public BitmapImage(String name) {
        System.out.println("Loaded from disk:"+name);
        this.name = name;
    }

    @Override
    public void setLocation(Point2D location) {
        this.location = location;
    }

    @Override
    public Point2D getLocation() {
        return location;
    }

    @Override
    public void render() {
        System.out.println("Rendered "+this.name);
    }
}
