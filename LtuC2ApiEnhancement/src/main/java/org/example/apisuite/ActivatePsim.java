package org.example.apisuite;

import java.util.Map;

public class ActivatePsim extends Activate {
    private String psimSpecificAttribute;

    // Getters and setters for specific attributes

    @Override
    public void setAttributes(Map<String, String> attributes) {
        super.setAttributes(attributes);
        this.psimSpecificAttribute = attributes.getOrDefault("psimSpecificAttribute", "defaultPsim");
    }
}
