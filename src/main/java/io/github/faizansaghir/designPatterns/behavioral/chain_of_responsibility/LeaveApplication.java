package io.github.faizansaghir.designPatterns.behavioral.chain_of_responsibility;

import java.time.Duration;
import java.time.LocalDate;

public class LeaveApplication {
    public enum Type {Sick, PTO, LOP};
    public enum Status {Pending, Approved, Rejected}
    private final Type type;
    private final LocalDate from;
    private final LocalDate to;
    private String processedBy;
    private Status status;

    public LeaveApplication(Type type, LocalDate from, LocalDate to, Status status) {
        this.type = type;
        this.from = from;
        this.to = to;
        this.status = status;
    }

    public Type getType() {
        return type;
    }

    public Long getNoOFDays() {
        return Duration.between(from.atStartOfDay(), to.atStartOfDay()).toDays();
    }

    public void approve(String approver){
        this.status = Status.Approved;
        this.processedBy = approver;
    }

    public static class LeaveApplicationBuilder{
        private Type type;
        private LocalDate from;
        private LocalDate to;
        public LeaveApplicationBuilder withType(Type type){
            this.type = type;
            return this;
        }
        public LeaveApplicationBuilder from(LocalDate from){
            this.from = from;
            return this;
        }
        public LeaveApplicationBuilder to(LocalDate to){
            this.to = to;
            return this;
        }
        public LeaveApplication build() {
            return new LeaveApplication(type, from, to, Status.Pending);
        }
    }
    public static LeaveApplicationBuilder getBuilder(){
        return new LeaveApplicationBuilder();
    }

    @Override
    public String toString() {
        return "LeaveApplication{" +
                "type=" + type +
                ", from=" + from +
                ", to=" + to +
                ", processedBy='" + processedBy + '\'' +
                ", status=" + status +
                '}';
    }
}
