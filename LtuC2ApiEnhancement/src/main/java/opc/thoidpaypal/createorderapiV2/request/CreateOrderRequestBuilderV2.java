package opc.thoidpaypal.createorderapiV2.request;

import java.util.ArrayList;

/**
 * The type Create order request builder v 2.
 */
public class CreateOrderRequestBuilderV2 {

    /**
     * Set create order request builder create order request pojo v 2.
     *
     * @return the create order request pojo v 2
     */
    public CreateOrderRequestPojoV2 setCreateOrderRequestBuilder(){

        CreateOrderRequestPojoV2 createOrderRequest=new CreateOrderRequestPojoV2();

        createOrderRequest.setIntent("CAPTURE");

        ArrayList<PurchaseUnit> purchaseUnitsList=new ArrayList<PurchaseUnit>();

        PurchaseUnit purchaseUnit=new PurchaseUnit();

        ArrayList<Item> itemArrayList = new ArrayList<Item>();
        Item item=new Item();
        item.setName("T-Shirt");
        item.setDescription("Green XL");
        item.setQuantity("1");
        itemArrayList.add(item);
        purchaseUnit.setItems(itemArrayList);

        UnitAmount unitAmount=new UnitAmount();
        unitAmount.setCurrency_code("USD");
        unitAmount.setValue("100.00");
        item.setUnit_amount(unitAmount);

        Amount amount=new Amount();
        amount.setCurrency_code("USD");
        amount.setValue("100.00");
        Breakdown breakdown=new Breakdown();
        ItemTotal itemTotal=new ItemTotal();
        itemTotal.setCurrency_code("USD");
        itemTotal.setValue("100.00");
        breakdown.setItem_total(itemTotal);

        amount.setBreakdown(breakdown);
        purchaseUnit.setAmount(amount);

        purchaseUnitsList.add(purchaseUnit);
        createOrderRequest.setPurchase_units(purchaseUnitsList);

        ApplicationContext applicationContext=new ApplicationContext();
        applicationContext.setReturn_url("https://example.com/return");
        applicationContext.setCancel_url("https://example.com/cancel");

        createOrderRequest.setApplication_context(applicationContext);

        return createOrderRequest;
    }
}
