package Task6;

import java.math.BigDecimal;

public class StockItem {
    private String productName;
    private int quantity;
    private BigDecimal unitPrice;

    public StockItem(String productName, int quantity, BigDecimal unitPrice) {
        this.productName = productName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "StockItem{" +
                "productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                '}';
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;


    }


}
