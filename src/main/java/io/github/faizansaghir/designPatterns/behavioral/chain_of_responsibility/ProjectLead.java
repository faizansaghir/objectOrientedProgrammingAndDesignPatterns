package io.github.faizansaghir.designPatterns.behavioral.chain_of_responsibility;

public class ProjectLead extends Employee {
    public ProjectLead(LeaveApprover successor) {
        super("Project Lead", successor);
    }

    @Override
    protected boolean processRequest(LeaveApplication application) {
        // Type is sick leave and duration is less than or equal to 2 days
        if(application.getType() == LeaveApplication.Type.Sick) {
            if(application.getNoOFDays()<=2){
                application.approve(getApproverRole());
                return true;
            }
        }
        return false;
    }
}
