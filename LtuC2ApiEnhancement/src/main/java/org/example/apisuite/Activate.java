package org.example.apisuite;

/**
 * Activate class
 *
 * @author touheed.aslam#Realme
 * @version 4.8
 * @updated 29-Jun-24
 * @since 4.8
 */

import java.util.Map;

public class Activate {
    private String commonAttribute1;
    private String commonAttribute2;

    // Getters and setters for common attributes

    public void setAttributes(Map<String, String> attributes) {
        this.commonAttribute1 = attributes.getOrDefault("commonAttribute1", "defaultCommon1");
        this.commonAttribute2 = attributes.getOrDefault("commonAttribute2", "defaultCommon2");
    }
}

