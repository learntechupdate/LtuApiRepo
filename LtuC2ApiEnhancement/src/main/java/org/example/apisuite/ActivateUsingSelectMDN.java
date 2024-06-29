package org.example.apisuite;

import java.util.Map;

public class ActivateUsingSelectMDN extends Activate {
    private String mdnSpecificAttribute;

    // Getters and setters for specific attributes

    @Override
    public void setAttributes(Map<String, String> attributes) {
        super.setAttributes(attributes);
        this.mdnSpecificAttribute = attributes.getOrDefault("mdnSpecificAttribute", "defaultMDN");
    }
}
