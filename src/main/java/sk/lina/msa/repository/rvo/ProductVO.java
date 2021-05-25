package sk.lina.msa.repository.rvo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductVO {
    String productCode;
    String productName;
    String productLine;
    String productScale;
    String productVendor;
    String productDescription;
    int quantityInStock;
    BigDecimal buyPrice;
    BigDecimal MSRP;
}
