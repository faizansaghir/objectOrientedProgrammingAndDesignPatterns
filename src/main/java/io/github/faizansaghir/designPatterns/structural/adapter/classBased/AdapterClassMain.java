package io.github.faizansaghir.designPatterns.structural.adapter.classBased;

import io.github.faizansaghir.designPatterns.structural.adapter.common.BusinessCardDesigner;
import io.github.faizansaghir.designPatterns.structural.adapter.common.Employee;

public class AdapterClassMain {
    public static void main(String[] args) {
        CustomerClassAdapter customerClassAdapter = new CustomerClassAdapter();
        populateEmployee(customerClassAdapter);
        BusinessCardDesigner designer = new BusinessCardDesigner();
        String card = designer.designBusinessCard(customerClassAdapter);
        System.out.println(card);
    }

    private static void populateEmployee(Employee employee) {
        employee.setFullName("Faizan Saghir");
        employee.setJobTitle("Software Engineer");
        employee.setOfficeLocation("India");
    }
}
