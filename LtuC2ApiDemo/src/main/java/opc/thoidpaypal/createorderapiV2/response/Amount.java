package opc.thoidpaypal.createorderapiV2.response;

import lombok.Data;

@Data
public class Amount {
    String currency_code;
    String value;
    Breakdown breakdown;
}
