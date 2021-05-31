package sk.lina.msa.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sk.lina.msa.model.KafkaMessageDTO;
import sk.lina.msa.model.ProductDTO;
import sk.lina.msa.service.Interface.IKafkaMessageService;
import sk.lina.msa.service.Interface.ISearchProductService;

@Slf4j
@RestController
public class SampleController {

    @Autowired
    ISearchProductService searchProductService;
    @Autowired
    IKafkaMessageService  kafkaMessageService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public void testMethod() {
        log.debug("testMethod");
    }

    @RequestMapping(value = "/products/{productCode}", method = RequestMethod.POST)
    public ResponseEntity<ProductDTO> getProductsInfo(@PathVariable("productCode") String inputProductCode) {
        log.debug("getProducts inputProductCode : " + inputProductCode);
        ProductDTO outputProductDTO = searchProductService.getProductsInfo(inputProductCode);
        log.debug("searchProductService outputProductDTO : " + outputProductDTO);
        return new ResponseEntity<ProductDTO>(outputProductDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "/kafkaMessageProduce/{kafkaMessage}", method = RequestMethod.POST)
    public ResponseEntity<KafkaMessageDTO> produceKafkaMessage(@PathVariable("kafkaMessage") String kafkaMessage) {
        log.debug("getProducts kafkaMessage : " + kafkaMessage);
        KafkaMessageDTO inputKafkaMessageDTO = new KafkaMessageDTO();
        inputKafkaMessageDTO.setKafkaMessage1(kafkaMessage);

        kafkaMessageService.produceKafkaMessage(inputKafkaMessageDTO);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/productDel/{orderNumber},{productCode}", method = RequestMethod.POST)
    public ResponseEntity<ProductDTO> delProductsInfo(@PathVariable("orderNumber") String orderNumber, @PathVariable("productCode") String productCode) {
        log.debug("delProducts orderNumber : " + orderNumber);
        log.debug("delProducts productCode : " + productCode);
        ProductDTO productDTO = searchProductService.deleteAllOrderdetails(orderNumber, productCode);
        log.debug("deleteProductService productDTO : " + productDTO);
        return new ResponseEntity<ProductDTO>(productDTO, HttpStatus.OK);
    }
}
