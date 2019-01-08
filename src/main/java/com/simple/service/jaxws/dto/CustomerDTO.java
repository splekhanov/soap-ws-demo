package com.simple.service.jaxws.dto;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.*;
import java.io.Serializable;

@XmlRootElement(name = "CustomerDTO")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerDTO implements Serializable {

    private static final long serialVersionUID = -5577579081118070434L;

    @XmlElement(name = "CustomerId", required = true)
    private int id;

    @XmlElement(name = "CustomerFirstName", required = true)
    private String firstName;

    @XmlElement(name = "CustomerLastName", required = true)
    private String lastName;

    @NotNull
    @XmlElement(name = "CustomerEmail", required = true)
    private String email;

    public CustomerDTO() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
