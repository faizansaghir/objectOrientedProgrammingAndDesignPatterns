package io.github.faizansaghir.designPatterns.behavioral.chain_of_responsibility;

public interface LeaveApprover {
    void processLeaveApplication(LeaveApplication leaveApplication);
    String getApproverRole();
}
