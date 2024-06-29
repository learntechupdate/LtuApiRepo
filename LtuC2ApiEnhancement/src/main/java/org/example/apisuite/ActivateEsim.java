package org.example.apisuite;

import java.util.Map;

public class ActivateEsim extends Activate {
    private String esimSpecificAttribute;

    // Getters and setters for specific attributes

    @Override
    public void setAttributes(Map<String, String> attributes) {
        super.setAttributes(attributes);
        this.esimSpecificAttribute = attributes.getOrDefault("esimSpecificAttribute", "defaultEsim");
    }
}
