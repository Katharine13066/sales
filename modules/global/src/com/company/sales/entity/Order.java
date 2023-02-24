package com.company.sales.entity;

import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.TimeSource;

import javax.annotation.PostConstruct;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "SALES_ORDER")
@Entity(name = "sales_Order")
public class Order extends StandardEntity {
    private static final long serialVersionUID = -285088349586480375L;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_", nullable = false)
    @NotNull
    private Date date;

    @Column(name = "AMOUNT")
    private BigDecimal amount;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @PostConstruct
    public void postConstruct() {
        this.setDate(AppBeans.get(TimeSource.class).currentTimestamp());
    }
}