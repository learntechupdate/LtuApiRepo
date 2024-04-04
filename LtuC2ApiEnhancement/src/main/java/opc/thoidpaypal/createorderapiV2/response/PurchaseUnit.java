package opc.thoidpaypal.createorderapiV2.response;

import lombok.Data;

import java.util.ArrayList;

@Data
public class PurchaseUnit {
    String reference_id;
    Amount amount;
    Payee payee;
    String soft_descriptor;
    ArrayList
            <Item> items;
}
