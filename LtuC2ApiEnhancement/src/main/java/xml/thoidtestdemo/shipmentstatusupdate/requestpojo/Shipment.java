package xml.thoidtestdemo.shipmentstatusupdate.requestpojo;

import lombok.Data;


import javax.xml.bind.annotation.*;

@Data
@XmlRootElement(name = "Shipment")
@XmlAccessorType(XmlAccessType.FIELD)
    public class Shipment {

    @XmlElement(name = "ShipmentStatusAudit" )
    private ShipmentStatusAudit ShipmentStatusAudit; 

    @XmlAttribute(name = "ShipmentNo" )
    private String ShipmentNo;
    @XmlAttribute(name = "TrackingNo" )
    private String TrackingNo;  
    @XmlAttribute(name = "BaseDropStatus" )
    private String BaseDropStatus;  
    @XmlAttribute(name = "CarrierCode" )
    private String CarrierCode;  
    @XmlAttribute(name = "ShipNode" )
    private String ShipNode;
    @XmlAttribute(name = "SellerOrganizationCode" )
    private String SellerOrganizationCode;  
    @XmlAttribute(name = "DocumentType" )
    private String DocumentType;
}


