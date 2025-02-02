package io.github.faizansaghir.designPatterns.behavioral.chain_of_responsibility;

public class Manager extends Employee{
    public Manager(LeaveApprover successor) {
        super("Manager", successor);
    }

    @Override
    protected boolean processRequest(LeaveApplication application) {
        // If type is Sick then approve else check if Paid Time off and less than 5 days
        switch (application.getType()){
            case Sick:
                application.approve(getApproverRole());
                return true;
            case PTO:
                if(application.getNoOFDays()<=5){
                    application.approve(getApproverRole());
                    return true;
                }
        }
        return false;
    }
}
