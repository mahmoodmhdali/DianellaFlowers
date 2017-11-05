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
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Mahmoud
 */
@Entity
@Table(name = "tbl_helper_checkout")
@XmlRootElement
@JsonIdentityInfo(generator = JSOGGenerator.class)
public class HelperCheckOut implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "FIRST_NAME")
    @Size (min = 3, max = 50, message = "First Name should be between 3 and 20 characters")
    @NotBlank(message = "First Name is required")
    private String firstName;
    @Basic(optional = false)
    @Column(name = "LAST_NAME")
    @Size (min = 3, max = 50, message = "Last Name should be between 3 and 20 characters")
    @NotBlank(message = "Last Name is required")
    private String lastName;
    @Basic(optional = false)
    @Column(name = "EMAIL")
    @Email
    @NotBlank(message = "Email is required")
    private String email;
    @Basic(optional = false)
    @Column(name = "PHONE_NUMBER")
    @NotBlank(message = "Phone Number is required")
    private String phoneNumber;
    @Basic(optional = false)
    @Column(name = "CITY")
    @NotBlank(message = "City is required")
    private String city;
    @Basic(optional = false)
    @Column(name = "CARD_TEXT")
    @Size (max = 2500, message = "Card Text should be maximum 2500 characters")
    private String cardText;
    @Basic(optional = false)
    @Column(name = "ADDITIONAL_DETAILS")
    private String additionalDetails;
    @Basic(optional = false)
    @Column(name = "ADDRESS")
    @Size (max = 1000, message = "Address should be maximum 1000 characters")
    @NotBlank(message = "Address is required")
    private String address;
    @Column(name = "SHIPPING_DATE_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "MMM, dd yyyy")
    @NotNull(message = "Shipping Date is required")
    private Date shippingDateTime;

    public HelperCheckOut() {
    }

    public HelperCheckOut(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public void setAdditionalDetails(String additionalDetails) {
        this.additionalDetails = additionalDetails;
    }

    public String getAdditionalDetails() {
        return additionalDetails;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setShippingDateTime(Date shippingDateTime) {
        this.shippingDateTime = shippingDateTime;
    }

    public Date getShippingDateTime() {
        return shippingDateTime;
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
        if (!(object instanceof HelperCheckOut)) {
            return false;
        }
        HelperCheckOut other = (HelperCheckOut) object;
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
