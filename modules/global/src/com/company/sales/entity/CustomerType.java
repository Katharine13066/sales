package com.company.sales.entity;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum CustomerType implements EnumClass<Integer> {

    VIP(10),
    SIMPLE(20);

    private Integer id;

    CustomerType(Integer value) {
        this.id = value;
    }

    public Integer getId() {
        return id;
    }

    @Nullable
    public static CustomerType fromId(Integer id) {
        for (CustomerType at : CustomerType.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}