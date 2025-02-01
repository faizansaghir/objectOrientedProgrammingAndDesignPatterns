package io.github.faizansaghir.designPatterns.structural.proxy.common;


import java.awt.geom.Point2D;

public interface Image {
    void setLocation(Point2D location);
    Point2D getLocation();
    void render();
}
