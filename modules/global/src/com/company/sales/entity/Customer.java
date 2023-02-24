package com.company.sales.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.EmbeddedParameters;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Table(name = "SALES_CUSTOMER")
@Entity(name = "sales_Customer")
@NamePattern("%s|name")
public class Customer extends StandardEntity {
    private static final long serialVersionUID = -8513008255286429677L;

    @NotNull
    @Column(name = "NAME", nullable = false, length = 100)
    private String name;

    @Column(name = "EMAIL", length = 50)
    @Email
    private String email;

    @Embedded
    @EmbeddedParameters(nullAllowed = false)
    @AttributeOverrides({
            @AttributeOverride(name = "city", column = @Column(name = "ADDRESS_CITY")),
            @AttributeOverride(name = "street", column = @Column(name = "ADDRESS_STREET")),
            @AttributeOverride(name = "number", column = @Column(name = "ADDRESS_NUMBER_"))
    })
    private Address address;

    @Column(name = "CUSTOMER_TYPE")
    private Integer customerType;

    public CustomerType getCustomerType() {
        return customerType == null ? null : CustomerType.fromId(customerType);
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType == null ? null : customerType.getId();
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}