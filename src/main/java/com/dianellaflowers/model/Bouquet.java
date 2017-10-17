/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dianellaflowers.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.voodoodyne.jackson.jsog.JSOGGenerator;
import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Mahmoud
 */
@Entity
@Table(name = "tbl_bouquet")
@XmlRootElement
@JsonIdentityInfo(generator = JSOGGenerator.class)
public class Bouquet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "NAME")
    @Size(min = 5, max = 20, message = "Name should be between 5 and 20 characters")
    @NotBlank(message = "Name is required")
    private String name;
    @Basic(optional = false)
    @Column(name = "PRICE")
    private String price;
    @Basic(optional = false)
    @Column(name = "OLD_PRICE")
    private String oldPrice;
    @Basic(optional = false)
    @Column(name = "ORIGINAL_IMAGE_PATH")
    private String originalImagePath;
    @Basic(optional = false)
    @Column(name = "COMPRESSED_IMAGE_PATH")
    private String compressedImagePath;
    @Column(name = "CREATED_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "REMOVED_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date removedAt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PUBLISHED")
    private boolean published;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HOME_PAGE_PRODUCT")
    private boolean homePageProduct;
    @JoinTable(name = "tbl_bouquet_color", inverseJoinColumns = {
        @JoinColumn(name = "COLOR_ID", referencedColumnName = "ID")}, joinColumns = {
        @JoinColumn(name = "BOUQUET_ID", referencedColumnName = "ID")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Color> colorCollection;
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    private UserProfile userProfileID;
    @JoinColumn(name = "CATEGORY_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Category categoryID;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "bouquetID", cascade = CascadeType.ALL)
    private Collection<UserCart> userCartCollection;

    public Bouquet() {
    }

    public Bouquet(Integer id) {
        this.id = id;
    }

    public Bouquet(Integer id, String name, String price, String oldPrice, Date createdAt, Date removedAt, boolean published, boolean homePageProduct, UserProfile userProfileID, Category categoryID) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.oldPrice = oldPrice;
        this.createdAt = createdAt;
        this.removedAt = removedAt;
        this.published = published;
        this.homePageProduct = homePageProduct;
        this.userProfileID = userProfileID;
        this.categoryID = categoryID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(String oldPrice) {
        this.oldPrice = oldPrice;
    }

    public String getOriginalImage() {
        return originalImagePath;
    }

    public void setOriginalImagePath(String originalImagePath) {
        this.originalImagePath = originalImagePath;
    }

    public String getCompressedImagePath() {
        return compressedImagePath;
    }

    public void setCompressedImagePath(String compressedImagePath) {
        this.compressedImagePath = compressedImagePath;
    }

    public boolean getPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public boolean getHomePageProduct() {
        return homePageProduct;
    }

    public void setHomePageProduct(boolean homePageProduct) {
        this.homePageProduct = homePageProduct;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getRemovedAt() {
        return removedAt;
    }

    public void setRemovedAt(Date removedAt) {
        this.removedAt = removedAt;
    }

    @XmlTransient
    public Collection<Color> getColorCollection() {
        return colorCollection;
    }

    public void setColorCollection(List<Color> colorCollection) {
        this.colorCollection = colorCollection;
    }
    
    @XmlTransient
    public UserProfile getUserProfileID() {
        return userProfileID;
    }

    public void setUserProfileID(UserProfile userProfileID) {
        this.userProfileID = userProfileID;
    }
    
    @XmlTransient
    public Category getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Category categoryID) {
        this.categoryID = categoryID;
    }
    
    @XmlTransient
    public Collection<UserCart> getUserCartCollection() {
        return userCartCollection;
    }

    public void setUserCartCollection(Collection<UserCart> userCartCollection) {
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
        if (!(object instanceof Bouquet)) {
            return false;
        }
        Bouquet other = (Bouquet) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "{\"id\" : \"" + id + "\","
                + "\"name\" : \"" + name + "\","
                + "\"price\" : \"" + price + "\","
                + "\"oldPrice\" : \"" + oldPrice + "\","
                + "\"originalImagePath\" : \"" + originalImagePath + "\","
                + "\"compressedImagePath\" : \"" + compressedImagePath + "\"}";
    }

}
