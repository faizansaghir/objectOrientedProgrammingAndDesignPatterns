package io.github.faizansaghir.designPatterns.behavioral.interpreter;

public class InterpreterPatternMain {
    public static void main(String[] args) {
        Report report1 = new Report("Cashflow report", "FINANCE_ADMIN OR ADMIN");
        ExpressionBuilder expressionBuilder = new ExpressionBuilder();
        PermissionExpression exp = expressionBuilder.build(report1);
        System.out.println(exp);

        User user1 = new User("Dave", "USER","DEVELOPER");
        System.out.println("User access report:"+exp.interpret(user1));
    }
}
