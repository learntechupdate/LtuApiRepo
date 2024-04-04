package opc.thoidpaypal.createorderapiV2.response;

import lombok.Data;

@Data
public class Item {
    String name;
    UnitAmount unit_amount;
    String quantity;
    String description;
}
