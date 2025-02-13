package io.github.faizansaghir.designPatterns.iterator;

public class IteratorPatternMain {
    public static void main(String[] args) {
        Iterator<ThemeColor> itr = ThemeColor.getIterator();
        while(itr.hasNext())
            System.out.println(itr.next());
    }

}
