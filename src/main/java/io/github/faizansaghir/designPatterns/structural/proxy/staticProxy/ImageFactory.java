package io.github.faizansaghir.designPatterns.structural.proxy.staticProxy;

import io.github.faizansaghir.designPatterns.structural.proxy.common.Image;

public class ImageFactory {
    public static Image getImage(String name){
        return new ImageProxy(name);
    }
}
