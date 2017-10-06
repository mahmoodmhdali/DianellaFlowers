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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Mahmoud
 */
@Entity
@Table(name = "tbl_user_cart")
@XmlRootElement
@JsonIdentityInfo(generator = JSOGGenerator.class)
public class UserCart implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Session_ID")
    private String sessionID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SUCCESS")
    private boolean success;
    @Column(name = "CREATED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @JoinColumn(name = "BOUQUET_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Bouquet bouquetID;

    public UserCart() {
    }

    public UserCart(Integer id) {
        this.id = id;
    }

    public UserCart(String sessionID, boolean success, Date createdDate, Bouquet bouquetID) {
        this.sessionID = sessionID;
        this.success = success;
        this.createdDate = createdDate;
        this.bouquetID = bouquetID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSessionID() {
        return sessionID;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean getSuccess() {
        return success;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @XmlTransient
    public Bouquet getBouquetID() {
        return bouquetID;
    }

    public void setBouquetID(Bouquet bouquetID) {
        this.bouquetID = bouquetID;
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
        if (!(object instanceof UserCart)) {
            return false;
        }
        UserCart other = (UserCart) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dianellaflowers.model.tbluserprofiles[ id=" + id + " ]";
    }

}