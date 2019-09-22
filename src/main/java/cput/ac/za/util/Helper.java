package cput.ac.za.util;

import java.util.UUID;

public class Helper {
    public static String generateRandomGivenSuffix(String suffix) {
        return suffix + "-" + UUID.randomUUID().toString();
    }

    public static String getClassName(Class<?>  aClass) {
        return aClass.getSimpleName();
    }

    public static String getSuffixFromClassName(Class<?> aClass) {

        String className = getClassName(aClass);
        return className
                .chars()
                .filter((c) -> Character.isUpperCase(c))
                .collect(StringBuilder::new,
                        StringBuilder::appendCodePoint,
                        StringBuilder::append)
                .toString();

    }
}
