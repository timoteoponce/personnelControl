/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.timo.personnel.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;

/**
 *
 * @author timoteo
 */
@Entity
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "BIRTH_DATE")
    private Date birthDate;

    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "CREATED")
    private Date created;

    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "MODIFIED")
    private Date modified;

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public Date getCreated() {
        return created;
    }

    public Date getModified() {
        return modified;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    @PrePersist
    protected void prePersist() {
        this.created = new Date();
    }

    @PreUpdate
    protected void preUpdate() {
        this.modified = new Date();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if ((this.firstName == null) ? (other.firstName != null) : !this.firstName.
                equals(other.firstName)) {
            return false;
        }
        if ((this.lastName == null) ? (other.lastName != null) : !this.lastName.
                equals(other.lastName)) {
            return false;
        }
        if (this.birthDate != other.birthDate && (this.birthDate == null || !this.birthDate.
                equals(other.birthDate))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 71 * hash + (this.firstName != null ? this.firstName.hashCode() : 0);
        hash = 71 * hash + (this.lastName != null ? this.lastName.hashCode() : 0);
        hash = 71 * hash + (this.birthDate != null ? this.birthDate.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ",firstName=" + firstName + ",lastName=" + lastName + ",birthDate=" + birthDate + ",created=" + created + ",modified=" + modified + '}';
    }
}
