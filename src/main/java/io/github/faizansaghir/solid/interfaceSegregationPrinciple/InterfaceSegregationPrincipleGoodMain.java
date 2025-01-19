package io.github.faizansaghir.solid.interfaceSegregationPrinciple;

import io.github.faizansaghir.solid.interfaceSegregationPrinciple.good.OrderPersistenceService;
import io.github.faizansaghir.solid.interfaceSegregationPrinciple.good.UserPersistenceService;
import io.github.faizansaghir.solid.interfaceSegregationPrinciple.common.Order;
import io.github.faizansaghir.solid.interfaceSegregationPrinciple.common.User;

public class InterfaceSegregationPrincipleGoodMain {
    public static void main(String[] args) {
        OrderPersistenceService orderPersistenceService = new OrderPersistenceService();
        UserPersistenceService userPersistenceService = new UserPersistenceService();

        Order o1 = new Order(1, 2011);
        Order o2 = new Order(2, 1578);

        orderPersistenceService.save(o1);
        orderPersistenceService.save(o2);

        User u1 = new User(1, "John");
        User u2 = new User(2, "Wick");
        User u3 = new User(3, "John");

        userPersistenceService.save(u1);
        userPersistenceService.save(u2);
        userPersistenceService.save(u3);

        System.out.printf("Order with id 2: %s\n",orderPersistenceService.getById(2).toString());
        System.out.printf("User with id 1: %s\n",userPersistenceService.getById(1).toString());

        // getByName not available in orderPersistenceService
        System.out.printf("Users with name \"John\": %s\n",userPersistenceService.getByName("John").toString());
    }
}
