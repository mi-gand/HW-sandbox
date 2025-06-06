package org.example.designPatterns.proxy;

public class IpAddressGetterFromDNS implements IpAddressGetter {

    @Override
    public String getIp(String dns) {
        return "Запрос полетел в глобальную сеть до ближайшего DNS сервера и вернул какой-то Ip";
    }
}
