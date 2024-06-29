package org.example.jsonfiletopojo.javapojo;

import lombok.Data;

@Data
public class Amount {
    private String currency_code;
    private String value;
    private Breakdown breakdown;
}
