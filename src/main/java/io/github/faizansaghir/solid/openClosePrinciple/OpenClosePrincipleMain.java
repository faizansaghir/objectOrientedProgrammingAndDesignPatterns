package io.github.faizansaghir.solid.openClosePrinciple;

public class OpenClosePrincipleMain {
    public static void main(String[] args) {
        SubscriberUsageRegistry subscriberUsageRegistry = new SubscriberUsageRegistry();

        Long idPhone = 1L;
        Subscriber phoneSubscriber = new PhoneSubscriber(
                idPhone, 0.5f, subscriberUsageRegistry
        );

        Long idInternet = 5L;
        Subscriber internetSubscriber = new InternetSubscriber(
                idInternet, 0.3f, 12.5f, subscriberUsageRegistry
        );

        Float phoneSubscriberCurrentUsageOct = subscriberUsageRegistry.recordUsage(12.3f, phoneSubscriber);
        System.out.printf("Phone subscriber current usage: %.2f\n", phoneSubscriberCurrentUsageOct);
        Float internetSubscriberCurrentUsageOct = subscriberUsageRegistry.recordUsage(10.0f, internetSubscriber);
        System.out.printf("Internet subscriber current usage: %.2f\n", internetSubscriberCurrentUsageOct);


        System.out.printf("Phone subscriber bill: %.2f\n", phoneSubscriber.calculateBill());
        System.out.printf("Internet subscriber bill: %.2f\n", internetSubscriber.calculateBill());

        Float phoneSubscriberCurrentUsageNov = subscriberUsageRegistry.recordUsage(1.8f, phoneSubscriber);
        System.out.printf("Phone subscriber current usage: %.2f\n", phoneSubscriberCurrentUsageNov);
        phoneSubscriberCurrentUsageNov = subscriberUsageRegistry.recordUsage(10.2f, phoneSubscriber);
        System.out.printf("Phone subscriber current usage: %.2f\n", phoneSubscriberCurrentUsageNov);
        phoneSubscriberCurrentUsageNov = subscriberUsageRegistry.recordUsage(18.5f, phoneSubscriber);
        System.out.printf("Phone subscriber current usage: %.2f\n", phoneSubscriberCurrentUsageNov);

        Float internetSubscriberCurrentUsageNov = subscriberUsageRegistry.recordUsage(5.0f, internetSubscriber);
        System.out.printf("Internet subscriber current usage: %.2f\n", internetSubscriberCurrentUsageNov);
        internetSubscriberCurrentUsageNov = subscriberUsageRegistry.recordUsage(8.0f, internetSubscriber);
        System.out.printf("Internet subscriber current usage: %.2f\n", internetSubscriberCurrentUsageNov);
        internetSubscriberCurrentUsageNov = subscriberUsageRegistry.recordUsage(18.0f, internetSubscriber);
        System.out.printf("Internet subscriber current usage: %.2f\n", internetSubscriberCurrentUsageNov);

        System.out.printf("Phone subscriber bill: %.2f\n", phoneSubscriber.calculateBill());
        System.out.printf("Internet subscriber bill: %.2f\n", internetSubscriber.calculateBill());

    }
}
