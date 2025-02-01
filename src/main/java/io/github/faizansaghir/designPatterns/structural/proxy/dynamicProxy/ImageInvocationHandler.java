package io.github.faizansaghir.designPatterns.structural.proxy.dynamicProxy;

import io.github.faizansaghir.designPatterns.structural.proxy.common.BitmapImage;
import io.github.faizansaghir.designPatterns.structural.proxy.common.Image;

import java.awt.geom.Point2D;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ImageInvocationHandler implements InvocationHandler {
    private BitmapImage bitmapImage;
    private final String name;
    private Point2D location;
    private static final Method setLocationMethod;
    private static final Method getLocationMethod;
    private static final Method renderMethod;

    public ImageInvocationHandler(String name) {
        this.name = name;
    }

    static {
        try{
            setLocationMethod = Image.class.getMethod("setLocation", new Class[]{Point2D.class});
            getLocationMethod = Image.class.getMethod("getLocation", new Class[]{});
            renderMethod = Image.class.getMethod("render", new Class[]{});
        }
        catch (NoSuchMethodException e){
            throw new RuntimeException(e.getMessage());
        }
    }
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.equals(setLocationMethod)){
            return handleSetLocation(args);
        }
        else if(method.equals(getLocationMethod)){
            return handleGetLocation(args);
        }
        else if(method.equals(renderMethod)){
            return handleRender();
        }
        return null;
    }

    private Object handleRender() {
        if(bitmapImage==null){
            this.bitmapImage = new BitmapImage(name);
            if(location!=null)
                bitmapImage.setLocation(location);
        }
        bitmapImage.render();
        return null;
    }

    private Object handleGetLocation(Object[] args) {
        if(bitmapImage==null)
            return this.location;
        else
            return bitmapImage.getLocation();
    }

    private Object handleSetLocation(Object[] args) {
        Point2D location = (Point2D) args[0];
        if(bitmapImage==null)
            this.location = location;
        else
            bitmapImage.setLocation(location);
        return null;
    }
}
