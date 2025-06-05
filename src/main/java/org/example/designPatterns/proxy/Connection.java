package org.example.designPatterns.proxy;

/*
    Не до конца понял задание, но уловил его вайб и суть паттерна
    Сымитировал запрос операционнной системы к DNS в глобальной сети через локальный
    файл hosts, который кэширует IP часто запрашиваемых доменов

*/

public class Connection {
    public static final String GOOGLE = "google.com";
    public static final String FACEBOOK = "facebook.com";
    public static final String STACKOVERFLOW = "stackoverflow.com";

    public static void main(String[] args) {
        IpAddressGetter ipAddressViaHosts = new IpAddressGetterProxy();
        System.out.println(ipAddressViaHosts.getIp(GOOGLE));
        System.out.println(ipAddressViaHosts.getIp(FACEBOOK));
        System.out.println(ipAddressViaHosts.getIp("Some site"));
    }
}
