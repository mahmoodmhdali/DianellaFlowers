/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dianellaflowers.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.voodoodyne.jackson.jsog.JSOGGenerator;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Mahmoud
 */
@Entity
@Table(name = "tbl_contact_us")
@XmlRootElement
@JsonIdentityInfo(generator = JSOGGenerator.class)
public class ContactUs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "NAME")
    @Size (min = 3, max = 50, message = "Name should be between 3 and 20 characters")
    @NotBlank(message = "Name is required")
    private String name;
    @Basic(optional = false)
    @Column(name = "EMAIL")
    @Email
    @NotBlank(message = "Email is required")
    private String email;
    @Basic(optional = false)
    @Column(name = "SUBJECT")
    @Size (min = 3, max = 50, message = "Subject should be between 3 and 20 characters")
    @NotBlank(message = "Subject is required")
    private String subject;
    @Basic(optional = false)
    @Column(name = "CATEGORY")
    private String category;
    @Basic(optional = false)
    @Column(name = "QUESTION")
    @Size (max = 2000, message = "QUESTION should be maximum 2000 characters")
    @NotBlank(message = "Question is required")
    private String question;

    public ContactUs() {
    }

    public ContactUs(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
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
        if (!(object instanceof ContactUs)) {
            return false;
        }
        ContactUs other = (ContactUs) object;
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
