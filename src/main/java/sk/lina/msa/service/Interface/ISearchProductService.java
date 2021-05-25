package sk.lina.msa.service.Interface;

import sk.lina.msa.model.ProductDTO;

public interface ISearchProductService {
    ProductDTO getProductsInfo(String productCode);
}
