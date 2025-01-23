package io.github.faizansaghir.designPatterns.structural.adapter.objectBased;

import io.github.faizansaghir.designPatterns.structural.adapter.common.BusinessCardDesigner;
import io.github.faizansaghir.designPatterns.structural.adapter.common.Employee;

public class AdapterObjectMain {
    public static void main(String[] args) {
        Employee employee = new Employee();
        populateEmployee(employee);
        CustomerObjectAdapter customerObjectAdapter = new CustomerObjectAdapter(employee);
        BusinessCardDesigner designer = new BusinessCardDesigner();
        String card = designer.designBusinessCard(customerObjectAdapter);
        System.out.println(card);
    }

    private static void populateEmployee(Employee employee) {
        employee.setFullName("Faizan Saghir");
        employee.setJobTitle("Software Engineer");
        employee.setOfficeLocation("India");
    }
}
