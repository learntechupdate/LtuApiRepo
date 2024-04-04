package xml.thoidtestdemo.shipmentstatusupdate;
import xml.thoidtestdemo.shipmentstatusupdate.requestpojo.ShipmentStatusAudit;

import xml.thoidtestdemo.shipmentstatusupdate.requestpojo.Shipment;

public class ShipmentStatusBuilder {

    public  Shipment shipmentStatusUpdate(){

        Shipment shipment=new Shipment();

        ShipmentStatusAudit shipmentStatusAudit=new ShipmentStatusAudit();

        shipmentStatusAudit.setStatusDate("2023-10-19T11:19:00");
        shipment.setShipmentStatusAudit(shipmentStatusAudit);
        shipment.setShipmentNo("DI100224270");
        shipment.setTrackingNo("GF0000100001974");
        shipment.setBaseDropStatus("1500");
        shipment.setCarrierCode("ECOM");
        shipment.setShipNode("R396");
        shipment.setSellerOrganizationCode("LTU");
        shipment.setDocumentType("0001");
        return shipment;
    }

}
