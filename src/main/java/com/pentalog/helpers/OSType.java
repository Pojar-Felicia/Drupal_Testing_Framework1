package com.pentalog.helpers;

import static java.lang.String.format;

public enum OSType {

    WINDOWS("windows", ".exe"),
    LINUX("linux", ""),
    MAC("macos", "");

    String name;
    String executableExtention;

    OSType(String name, String executableExtention) {
        this.name = name;
        this.executableExtention = executableExtention;
    }

    public static OSType detect() {
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("win")) {
            return WINDOWS;
        } else if (osName.contains("nix") || osName.contains("nux")) {
            return LINUX;
        } else if (osName.contains("mac")) {
            return MAC;
        } else {
            throw new RuntimeException(format("[%s] OS does not match with any of types in the [%s] enum", osName, OSType.class.getSimpleName()));
        }
    }
}
