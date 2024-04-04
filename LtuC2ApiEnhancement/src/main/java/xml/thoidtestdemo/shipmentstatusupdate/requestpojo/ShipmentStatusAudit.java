package xml.thoidtestdemo.shipmentstatusupdate.requestpojo;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlRootElement(name = "ShipmentStatusAudit")
@XmlAccessorType(XmlAccessType.FIELD)
public class ShipmentStatusAudit {
    @XmlAttribute(name = "StatusDate")
    private String StatusDate;
}
