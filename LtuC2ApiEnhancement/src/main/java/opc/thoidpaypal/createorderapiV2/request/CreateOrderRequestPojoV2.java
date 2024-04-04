package opc.thoidpaypal.createorderapiV2.request;

import lombok.Data;

import java.util.ArrayList;

@Data
    public class CreateOrderRequestPojoV2 {
    String intent;
    ArrayList<PurchaseUnit> purchase_units;
    ApplicationContext application_context;
    }


@Data
    class Amount {
    String currency_code;
    String value;
    Breakdown breakdown;
    }

@Data
    class ApplicationContext {
    String return_url;
    String cancel_url;
    }

@Data
    class Breakdown {
    ItemTotal item_total;
    }

@Data
    class Item {
    String name;
    String description;
    String quantity;
    UnitAmount unit_amount;
    }

@Data
    class ItemTotal {
    String currency_code;
    String value;
    }

@Data
    class PurchaseUnit {
    ArrayList<Item> items;
    Amount amount;
    }

@Data
    class UnitAmount {
    String currency_code;
    String value;
    }

