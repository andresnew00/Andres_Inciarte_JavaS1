package com.company.AndresInciarteU1Capstone.Dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Objects;

public class Invoice {

    @NotNull
    private int invoiceId;
    @NotNull
    @Size(max = 80, message = "Name must be less than 80 characters long")
    private String name;
    @NotNull
    @Size(max = 30, message = "Title must be less than 30 characters long")
    private String street;
    @NotNull
    @Size(max = 30, message = "Title must be less than 30 characters long")
    private String city;
    @NotNull
    @Size(max = 2, message = "Please enter enter state in 2 char format ex. 'TX' ")
    private String state;
    @NotNull
    @Size(max = 5, message = "Zipcode must be less or 5 characters long")
    private String zipcode;
    @NotNull
    @Size(max = 20, message = "itemType must be less than 20 characters long")
    private String itemType;
    @NotNull
    private int itemId;
    private BigDecimal unitPrice;
    @NotNull
    private int quantity;
    private BigDecimal subtotal;
    private BigDecimal tax;
    private BigDecimal processingFee;
    private BigDecimal total;

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public BigDecimal getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(BigDecimal processingFee) {
        this.processingFee = processingFee;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return invoiceId == invoice.invoiceId &&
                itemId == invoice.itemId &&
                quantity == invoice.quantity &&
                name.equals(invoice.name) &&
                street.equals(invoice.street) &&
                city.equals(invoice.city) &&
                state.equals(invoice.state) &&
                zipcode.equals(invoice.zipcode) &&
                itemType.equals(invoice.itemType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(invoiceId, name, street, city, state, zipcode, itemType, itemId, unitPrice, quantity, subtotal, tax, processingFee, total);
    }
}
