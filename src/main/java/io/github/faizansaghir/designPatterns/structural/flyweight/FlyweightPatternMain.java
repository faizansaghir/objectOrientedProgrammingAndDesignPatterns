package io.github.faizansaghir.designPatterns.structural.flyweight;

public class FlyweightPatternMain {
    public static void main(String[] args) {
        SystemErrorMessage msg1 = ErrorMessageFactory.getInstance().getError(ErrorMessageFactory.ErrorType.GenericSystemError);
        System.out.println(msg1.getText("4056"));

        UserBannedErrorMessage msg2 = ErrorMessageFactory.getInstance().getUserBannedErrorMessage("1202");
        System.out.println(msg2.getText(null));
    }
}
