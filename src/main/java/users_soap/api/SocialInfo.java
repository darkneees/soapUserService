//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.10.30 at 12:33:23 PM GMT+04:00 
//


package users_soap.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for socialInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="socialInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="nameSocial" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="identifierSocial" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "socialInfo", propOrder = {
    "id",
    "nameSocial",
    "identifierSocial"
})
public class SocialInfo {

    protected long id;
    @XmlElement(required = true)
    protected String nameSocial;
    @XmlElement(required = true)
    protected String identifierSocial;

    /**
     * Gets the value of the id property.
     * 
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(long value) {
        this.id = value;
    }

    /**
     * Gets the value of the nameSocial property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameSocial() {
        return nameSocial;
    }

    /**
     * Sets the value of the nameSocial property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameSocial(String value) {
        this.nameSocial = value;
    }

    /**
     * Gets the value of the identifierSocial property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentifierSocial() {
        return identifierSocial;
    }

    /**
     * Sets the value of the identifierSocial property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentifierSocial(String value) {
        this.identifierSocial = value;
    }

}
