//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.10.30 at 12:33:23 PM GMT+04:00 
//


package users_soap.api;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for userInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="userInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="username" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="firstName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="secondName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="age" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="socialList" type="{http://users-soap/api/}socialInfo" maxOccurs="unbounded"/>
 *         &lt;element name="roleList" type="{http://users-soap/api/}roleInfo" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "userInfo", propOrder = {
    "username",
    "firstName",
    "secondName",
    "age",
    "password",
    "socialList",
    "roleList"
})
public class UserInfo {

    @XmlElement(required = true)
    protected String username;
    @XmlElement(required = true)
    protected String firstName;
    @XmlElement(required = true)
    protected String secondName;
    protected int age;
    @XmlElement(required = true)
    protected String password;
    @XmlElement(required = true)
    protected List<SocialInfo> socialList;
    @XmlElement(required = true)
    protected List<RoleInfo> roleList;

    /**
     * Gets the value of the username property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the value of the username property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsername(String value) {
        this.username = value;
    }

    /**
     * Gets the value of the firstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the value of the firstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstName(String value) {
        this.firstName = value;
    }

    /**
     * Gets the value of the secondName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSecondName() {
        return secondName;
    }

    /**
     * Sets the value of the secondName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSecondName(String value) {
        this.secondName = value;
    }

    /**
     * Gets the value of the age property.
     * 
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the value of the age property.
     * 
     */
    public void setAge(int value) {
        this.age = value;
    }

    /**
     * Gets the value of the password property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the value of the password property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassword(String value) {
        this.password = value;
    }

    /**
     * Gets the value of the socialList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the socialList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSocialList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SocialInfo }
     * 
     * 
     */
    public List<SocialInfo> getSocialList() {
        if (socialList == null) {
            socialList = new ArrayList<SocialInfo>();
        }
        return this.socialList;
    }

    /**
     * Gets the value of the roleList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the roleList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRoleList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RoleInfo }
     * 
     * 
     */
    public List<RoleInfo> getRoleList() {
        if (roleList == null) {
            roleList = new ArrayList<RoleInfo>();
        }
        return this.roleList;
    }

}
