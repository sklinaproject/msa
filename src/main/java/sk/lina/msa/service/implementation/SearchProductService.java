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

    @Override
    public ProductDTO deleteAllOrderdetails(String orderNumber, String productCode) {
        log.debug("delProductsInfo orderNumber :" + orderNumber);
        log.debug("delProductsInfo productCode :" + productCode);

        ProductDTO productDTO = new ProductDTO();
        ProductVO productVO = new ProductVO();

        productVO = productMapper.deleteAllOrderdetails(orderNumber, productCode);

        log.debug("delProductsInfo accountVO :" + productVO);

        productDTO.setOrderNumber(orderNumber);
        productDTO.setProductCode(productCode);
        productDTO.setProductStatus("삭제");

        log.debug("delProductsInfo productDTO :" + productDTO);

        return productDTO;
    }
}
