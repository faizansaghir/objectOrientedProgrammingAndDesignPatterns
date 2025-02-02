package io.github.faizansaghir.designPatterns.behavioral.chain_of_responsibility;

public class Director extends Employee{

    public Director(LeaveApprover successor) {
        super("Director", successor);
    }

    @Override
    protected boolean processRequest(LeaveApplication application) {
        if(application.getType() == LeaveApplication.Type.PTO){
            application.approve(getApproverRole());
            return true;
        }
        return false;
    }
}
