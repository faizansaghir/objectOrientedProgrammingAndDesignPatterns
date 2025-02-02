package io.github.faizansaghir.designPatterns.behavioral.chain_of_responsibility;

import java.time.LocalDate;

public class ChainOfResponsibilityMain {
    public static void main(String[] args) {
        LeaveApplication leaveApplication = LeaveApplication.getBuilder()
                .withType(LeaveApplication.Type.Sick)
                .from(LocalDate.now())
                .to(LocalDate.now().plusDays(20))
                .build();
        System.out.println(leaveApplication);
        System.out.println("***************************");
        LeaveApprover approver = createChain();
        approver.processLeaveApplication(leaveApplication);
        System.out.println(leaveApplication);
    }
    private static LeaveApprover createChain(){
        Director director = new Director(null);
        Manager manager = new Manager(director);
        return new ProjectLead(manager);
    }
}
