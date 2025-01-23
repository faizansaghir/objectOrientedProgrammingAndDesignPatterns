package io.github.faizansaghir.designPatterns.structural.adapter.common;

// Client
public class BusinessCardDesigner {
    public String designBusinessCard(Customer customer){
        String card = "";
        card += customer.getName()+'\n';
        card += customer.getDesignation()+'\n';
        card += customer.getAddress()+'\n';
        return card;
    }
}
