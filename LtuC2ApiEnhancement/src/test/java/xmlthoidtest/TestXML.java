package xmlthoidtest;

import org.testng.annotations.Test;
import xml.thoidtestdemo.shipmentstatusupdate.ShipmentStatusUpdateService;

import javax.xml.bind.JAXBException;

public class TestXML {

    @Test
    public  void testShipmentStatusUpdate() throws JAXBException {
        ShipmentStatusUpdateService shipmentStatusUpdateService=new ShipmentStatusUpdateService();
        String xml = shipmentStatusUpdateService.shipmentstatusupdate();
        System.out.println(xml);
    }
}
