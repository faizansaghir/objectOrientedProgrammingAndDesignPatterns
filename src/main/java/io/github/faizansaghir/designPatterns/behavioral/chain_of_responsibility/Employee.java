package io.github.faizansaghir.designPatterns.behavioral.chain_of_responsibility;

public abstract class Employee implements LeaveApprover {
    private final String role;
    private final LeaveApprover successor;

    public Employee(String role, LeaveApprover successor) {
        this.role = role;
        this.successor = successor;
    }

    @Override
    public void processLeaveApplication(LeaveApplication leaveApplication) {
        if(!processRequest(leaveApplication) && successor!=null){
            successor.processLeaveApplication(leaveApplication);
        }
    }
    protected abstract boolean processRequest(LeaveApplication application);

    @Override
    public String getApproverRole() {
        return role;
    }
}
