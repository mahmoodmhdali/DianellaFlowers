/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dianellaflowers.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.voodoodyne.jackson.jsog.JSOGGenerator;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Mahmoud
 */
@Entity
@Table(name = "tbl_checkout_request")
@XmlRootElement
@JsonIdentityInfo(generator = JSOGGenerator.class)
public class CheckoutRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "RESPONSE_CODE")
    private String responseCode;
    @Basic(optional = false)
    @Column(name = "RESPONSE_MESSAGE")
    private String responseMessage;
    @Basic(optional = false)
    @Column(name = "TRACK_ID")
    private String trackId;
    @Basic(optional = false)
    @Column(name = "SESSION_ID")
    private String sessionID;
    @Basic(optional = false)
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Basic(optional = false)
    @Column(name = "LAST_NAME")
    private String lastName;
    @Basic(optional = false)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
    @Basic(optional = false)
    @Column(name = "CITY")
    private String city;
    @Basic(optional = false)
    @Column(name = "CARD_TEXT")
    private String cardText;
    @Basic(optional = false)
    @Column(name = "ADDRESS")
    private String address;
    @Basic(optional = false)
    @Column(name = "CARD_NUMBER")
    private String cardNumber;
    @Basic(optional = false)
    @Column(name = "CUSTOMER_IP")
    private String customerIP;
    @Basic(optional = false)
    @Column(name = "USER_STATUS")
    private String userStatus;
    @Basic(optional = false)
    @Column(name = "LAST_STATUS_UPDATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastStatusUpdateDate;
    @Column(name = "SHIPPING_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "MMM, dd yyyy")
    private Date shippingDateTime;
    @Basic(optional = false)
    @Column(name = "SHIPPING_TIME")
    private String shippingTime;
    @Column(name = "CHECKOUT_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkoutDate;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "checkoutRequestId", cascade = CascadeType.ALL)
    private List<UserCart> userCartCollection;

    public CheckoutRequest() {
    }

    public CheckoutRequest(Integer id) {
        this.id = id;
    }

    public CheckoutRequest(String responseCode, String responseMessage, String trackId, List<UserCart> userCartCollection, String sessionID, Date lastStatusUpdateDate) {
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
        this.trackId = trackId;
        this.userCartCollection = userCartCollection;
        this.sessionID = sessionID;
        this.lastStatusUpdateDate = lastStatusUpdateDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }
    
    public String getTrackId() {
        return trackId;
    }

    public void setTrackId(String trackId) {
        this.trackId = trackId;
    }
    
    public Date getLastStatusUpdateDate() {
        return lastStatusUpdateDate;
    }

    public void setLastStatusUpdateDate(Date lastStatusUpdateDate) {
        this.lastStatusUpdateDate = lastStatusUpdateDate;
    }
    
    public Date getShippingDateTime() {
        return shippingDateTime;
    }

    public void setShippingDateTime(Date shippingDateTime) {
        this.shippingDateTime = shippingDateTime;
    }
    
    public Date getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(Date checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public String getSessionID() {
        return sessionID;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setCardText(String cardText) {
        this.cardText = cardText;
    }

    public String getCardText() {
        return cardText;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCustomerIP(String customerIP) {
        this.customerIP = customerIP;
    }

    public String getCustomerIP() {
        return customerIP;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setShippingTime(String shippingTime) {
        this.shippingTime = shippingTime;
    }

    public String getShippingTime() {
        return shippingTime;
    }

    @XmlTransient
    public List<UserCart> getUserCartCollectionn() {
        return userCartCollection;
    }

    public void setUserCartCollection(List<UserCart> userCartCollection) {
        this.userCartCollection = userCartCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CheckoutRequest)) {
            return false;
        }
        CheckoutRequest other = (CheckoutRequest) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dianellaflowers.model.TblRoles[ id=" + id + " ]";
    }

}
