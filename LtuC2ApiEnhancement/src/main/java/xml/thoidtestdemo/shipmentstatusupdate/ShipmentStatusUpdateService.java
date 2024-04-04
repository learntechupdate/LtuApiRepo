package xml.thoidtestdemo.shipmentstatusupdate;

import xml.thoidtestdemo.shipmentstatusupdate.requestpojo.Shipment;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

public class ShipmentStatusUpdateService {

      public String shipmentstatusupdate() throws JAXBException {

          ShipmentStatusBuilder shipmentStatusBuilder=new ShipmentStatusBuilder();
          Shipment shipment = shipmentStatusBuilder.shipmentStatusUpdate();

          System.out.println(shipment);
//       JAXB marshaller


       // Create JAXB context and marshaller
       JAXBContext jaxbContext = JAXBContext.newInstance(Shipment.class);
       Marshaller marshaller = jaxbContext.createMarshaller();

       // Convert object to XML and capture it as a string
       StringWriter stringWriter = new StringWriter();
       marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);//formatting
       marshaller.marshal(shipment, stringWriter);

       // Get the XML as a string
       String xmlString = stringWriter.toString();

       // Print or use the XML string as needed
       System.out.println(xmlString);

       return  xmlString;


       /*// Convert object to XML
       marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

       marshaller.marshal(shipment, System.out);*/


    }
}
