package sk.lina.msa.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sk.lina.msa.model.ProductDTO;
import sk.lina.msa.service.Interface.ISearchProductService;

@Slf4j
@RestController
public class SampleController {

    @Autowired
    ISearchProductService searchProductService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public void testMethod() {
        log.debug("testMethod");
    }

    @RequestMapping(value = "/product/{productCode}", method = RequestMethod.POST)
    public ResponseEntity<ProductDTO> getProductsInfo(@PathVariable("productCode") String productCode) {
        log.debug("getProducts productCode : " + productCode);
        ProductDTO productDTO = searchProductService.getProductsInfo(productCode);
        log.debug("searchProductService productDTO : " + productDTO);
        return new ResponseEntity<ProductDTO>(productDTO, HttpStatus.OK);
    }
}
