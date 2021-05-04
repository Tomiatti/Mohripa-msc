package Alocador;

import java.util.Properties;

public class SessionProperties {

    public Properties SessionProperties() {
        java.util.Properties config = new java.util.Properties();
        config.put("PreferredAuthentications", "password");
        config.put("StrictHostKeyChecking", "no");
        return config;
    }
}
