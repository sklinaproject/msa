package sk.lina.msa.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDTO {
    String productCode;
    String productName;
    String productLine;
    String productScale;
    String productVendor;
    String productDescription;
    int quantityInStock;
    BigDecimal buyPrice;
    BigDecimal MSRP;
    String orderNumber;
    String productStatus;
}
