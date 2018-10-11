package com.ly.newFeature;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: liyan
 * @Description:
 * @Date: Created in 13:34 2018/9/18
 * @Modified By:
 */
public class Widget {
    private final Color color;
    private final int weight;

    public Widget(Color color, int weight) {
        this.color = color;
        this.weight = weight;
    }

    public enum Color{
        RED,BLUE, BLACK
    }

    public Color getColor() {
        return color;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "[ color: " + color + ", " + "weight: " + weight + " ]";
    }

    public static void main(String[] args){
        List<Widget> widght = new ArrayList<>();
        widght.add(new Widget(Color.RED, 1));
        widght.add(new Widget(Color.BLUE, 2));
        widght.add(new Widget(Color.BLACK, 3));
        widght.add(new Widget(Color.RED, 4));
        widght.add(new Widget(Color.RED, 8));


        int sum =
            widght.parallelStream()
                    .filter(color -> color.getColor() == Color.RED)
                    .mapToInt(Widget::getWeight)
                    .sum();
        System.out.println("sum = " + sum);

    }
}
