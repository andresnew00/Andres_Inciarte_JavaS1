package com.company.AndresInciarteU1Capstone.Dto;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Objects;

public class Console {

    @NotNull
    private int consoleId;
    @NotNull
    @Size(max = 50, message = "model must be less than 50 characters long")
    private String model;
    @NotNull
    @Size(max = 50, message = "manufacturer must be less than 50 characters long")
    private String manufacturer;
    @Size(max = 50, message = "memory amount must be less than 50 characters long")
    private String memoryAmount;
    @Size(max = 20, message = "processor must be less than 20 characters long")
    private String processor;
    @NotNull
    @Digits(integer = 5, fraction = 2)
    private BigDecimal price;
    @NotNull
    @PositiveOrZero
    private int quantity;

    public int getConsoleId() {
        return consoleId;
    }

    public void setConsoleId(int consoleId) {
        this.consoleId = consoleId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getMemoryAmount() {
        return memoryAmount;
    }

    public void setMemoryAmount(String memoryAmount) {
        this.memoryAmount = memoryAmount;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Console console = (Console) o;
        return consoleId == console.consoleId &&
                quantity == console.quantity &&
                model.equals(console.model) &&
                manufacturer.equals(console.manufacturer) &&
                memoryAmount.equals(console.memoryAmount) &&
                processor.equals(console.processor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(consoleId, model, manufacturer, memoryAmount, processor, price, quantity);
    }
}
