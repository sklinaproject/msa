package sk.lina.msa.service.implementation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.lina.msa.model.ProductDTO;
import sk.lina.msa.repository.mapper.IProductMapper;
import sk.lina.msa.repository.rvo.ProductVO;
import sk.lina.msa.service.Interface.ISearchProductService;

@Slf4j
@Service
public class SearchProductService implements ISearchProductService {

    @Autowired
    private IProductMapper productMapper;

    @Override
    public ProductDTO getProductsInfo(String productCode) {
        log.debug("getProductsInfo productCode :" + productCode);

        ProductDTO productDTO = new ProductDTO();
        ProductVO productVO = new ProductVO();

        productVO = productMapper.findAllProducts(productCode);

        log.debug("getProductsInfo accountVO :" + productVO);

        productDTO.setProductName(productVO.getProductName());

        log.debug("findAllProducts productDTO :" + productDTO);

        return productDTO;
    }
}
