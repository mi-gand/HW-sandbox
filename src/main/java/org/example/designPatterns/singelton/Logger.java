package org.example.designPatterns.singelton;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Logger {
    private static volatile Logger logger;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    private Logger() {
    }

    public static Logger getInstance() {
        if (logger == null) {
            synchronized (Logger.class) {
                if (logger == null) {
                    logger = new Logger();
                }
            }
        }
        return logger;
    }

    public void classLogg(Object obj, String info) {
        System.out.printf(" Log info: %s - %s - %s",
                LocalDate.now().format(FORMATTER), obj.getClass().getSimpleName(), info);
    }

    public static void main(String[] args) {
        Logger.getInstance().classLogg(new String[1], "String array example");
    }
}