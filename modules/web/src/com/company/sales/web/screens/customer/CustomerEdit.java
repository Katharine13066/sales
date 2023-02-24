package com.company.sales.web.screens.customer;

import com.haulmont.cuba.gui.screen.*;
import com.company.sales.entity.Customer;

@UiController("sales_Customer.edit")
@UiDescriptor("customer-edit.xml")
@EditedEntityContainer("customerDc")
@LoadDataBeforeShow
public class CustomerEdit extends StandardEditor<Customer> {
}