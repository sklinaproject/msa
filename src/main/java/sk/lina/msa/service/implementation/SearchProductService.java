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
    public ProductDTO getProductsInfo(String inputProductCode) {
        log.debug("getProductsInfo inputProductCode :" + inputProductCode);

        ProductDTO outputProductDTO = new ProductDTO();

        ProductVO outputProductVO = productMapper.findAllProducts(inputProductCode);

        log.debug("getProductsInfo outputProductVO :" + outputProductVO);

        outputProductDTO.setProductName(outputProductVO.getProductName());

        log.debug("findAllProducts outputProductDTO :" + outputProductDTO);

        return outputProductDTO;
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
