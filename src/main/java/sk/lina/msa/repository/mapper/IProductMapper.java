package sk.lina.msa.repository.mapper;

import org.apache.ibatis.annotations.Mapper;
import sk.lina.msa.repository.rvo.ProductVO;

@Mapper
public interface IProductMapper {
    ProductVO findAllProducts(String productCode);
    ProductVO deleteAllOrderdetails(String orderNumber,String productCode);
}
