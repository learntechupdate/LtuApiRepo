package org.example.jsonfiletopojo.javapojo;

import lombok.Data;

@Data
public class Item {
    private String name;
    private String description;
    private String quantity;
    private UnitAmount unit_amount;
}
