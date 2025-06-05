package org.example.designPatterns.proxy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class IpAddressGetterProxy implements IpAddressGetter {
    IpAddressGetter ipAddressGetterFromDNS = new IpAddressGetterFromDNS();

    @Override
    public String getIp(String dns) {
        String ip = checkHostsFile(dns);
        if(ip == null) {
            return ipAddressGetterFromDNS.getIp(dns);
        }
        return ip;
    }

    private String checkHostsFile(String dns){

        Path hostsPath = Path.of("src", "main", "java", "org", "example","designPatterns", "proxy", "hosts");

        try (Stream<String> lines = Files.lines(hostsPath)) {
            return lines
                    .map(String::trim)
                    .map(line -> line.split("\\s+"))
                    .filter(parts -> parts.length >= 2)
                    .filter(parts -> {
                        for (int i = 1; i < parts.length; i++) {
                            if (parts[i].equalsIgnoreCase(dns)) {
                                return true;
                            }
                        }
                        return false;
                    })
                    .map(parts -> parts[0])
                    .findFirst()
                    .orElse(null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
