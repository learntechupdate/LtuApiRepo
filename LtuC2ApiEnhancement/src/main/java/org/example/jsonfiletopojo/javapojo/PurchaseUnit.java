package org.example.jsonfiletopojo.javapojo;

import lombok.Data;

import java.util.ArrayList;

@Data
public class PurchaseUnit {
    private ArrayList<Item> items;
    private Amount amount;
}
