/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dianellaflowers.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.voodoodyne.jackson.jsog.JSOGGenerator;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author Mahmoud
 */
@Entity
@Table(name = "tbl_user_profiles")
@XmlRootElement
@JsonIdentityInfo(generator = JSOGGenerator.class)
public class UserProfile implements Serializable, UserDetails {

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
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotBlank(message = "Email is required")
    @Column(name = "EMAIL")
    @Email(message = "Not a well-formed email address")
    private String email;
    @Basic(optional = false)
    @NotBlank(message = "Password is required")
    @Column(name = "PASSWORD")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ENABLED")
    private boolean enabled;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACCOUNT_EXPIRED")
    private boolean accountExpired;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACCOUNT_LOCKED")
    private boolean accountLocked;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREDENTIAL_EXPIRED")
    private boolean credentialExpired;
    @Column(name = "RESET_PASSWORD_TOKEN")
    private String resetPasswordToken;
    @Column(name = "RESET_PASSWORD_TOKEN_VALIDITY")
    @Temporal(TemporalType.TIMESTAMP)
    private Date resetPasswordTokenValidity;
    @Column(name = "DELETED_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedAt;
    @Column(name = "CREATION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @JoinTable(name = "TBL_USER_PROFILE_ROLES", inverseJoinColumns = {
        @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID")}, joinColumns = {
        @JoinColumn(name = "USER_PROFILE_ID", referencedColumnName = "ID")})
    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Role> roleCollection;
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "userProfileId", cascade = CascadeType.ALL)
    private UserAttempt userAttemptCollection;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userProfileID", cascade = CascadeType.ALL)
    private Collection<Bouquet> bouquetCollection;
    
    private transient Collection<GrantedAuthority> authorities;

    public UserProfile() {
    }

    public UserProfile(Integer id) {
        this.id = id;
    }

    public UserProfile(Integer id, String name, String email, String password, boolean enabled, boolean accountExpired, boolean accountLocked, boolean credentialExpired) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.enabled = enabled;
        this.accountExpired = accountExpired;
        this.accountLocked = accountLocked;
        this.credentialExpired = credentialExpired;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean getAccountExpired() {
        return accountExpired;
    }

    public void setAccountExpired(boolean accountExpired) {
        this.accountExpired = accountExpired;
    }

    public boolean getAccountLocked() {
        return accountLocked;
    }

    public void setAccountLocked(boolean accountLocked) {
        this.accountLocked = accountLocked;
    }

    public boolean getCredentialExpired() {
        return credentialExpired;
    }

    public void setCredentialExpired(boolean credentialExpired) {
        this.credentialExpired = credentialExpired;
    }

    public String getResetPasswordToken() {
        return resetPasswordToken;
    }

    public void setResetPasswordToken(String resetPasswordToken) {
        this.resetPasswordToken = resetPasswordToken;
    }

    public Date getResetPasswordTokenValidity() {
        return resetPasswordTokenValidity;
    }

    public void setResetPasswordTokenValidity(Date resetPasswordTokenValidity) {
        this.resetPasswordTokenValidity = resetPasswordTokenValidity;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    @XmlTransient
    public UserAttempt getUserAttemptCollection() {
        return userAttemptCollection;
    }

    public void setUserAttemptCollection(UserAttempt userAttemptCollection) {
        this.userAttemptCollection = userAttemptCollection;
    }

    @XmlTransient
    public Collection<Role> getRoleCollection() {
        return roleCollection;
    }

    public void setRoleCollection(Collection<Role> roleCollection) {
        this.roleCollection = roleCollection;
    }

    @XmlTransient
    public Collection<Bouquet> getBouquetSet() {
        return bouquetCollection;
    }

    public void setBouquetSet(Collection<Bouquet> bouquetCollection) {
        this.bouquetCollection = bouquetCollection;
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
        if (!(object instanceof UserProfile)) {
            return false;
        }
        UserProfile other = (UserProfile) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dianellaflowers.model.TblUserProfiles[ id=" + id + " ]";
    }

    public void setUserAuthorities(Collection<Role> roles) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        for (Role role : this.getRoleCollection()) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRole()));
        }
        this.authorities = (Collection<GrantedAuthority>) authorities;
    }
    
    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    public void setAccountNonExpired(boolean accountExpired) {
        this.accountExpired = accountExpired;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.accountExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
}
