package io.github.faizansaghir.designPatterns.structural.flyweight;

import java.time.Duration;

public class UserBannedErrorMessage implements ErrorMessage {
    private final String caseId;
    private String msg;

    public UserBannedErrorMessage(String caseId) {
        this.caseId = caseId;
        String remarks = "You violated terms of use.";
        Duration duration = Duration.ofDays(2);
        msg = "You are BANNED. Sorry.\nMore information:\n";
        msg+=caseId+"\n";
        msg+= remarks +"\n";
        msg+="Banned For:"+ duration.toHours()+"Hours";
    }

    @Override
    public String getText(String code) {
        return msg;
    }

    public String getCaseNo() {
        return caseId;
    }
}
