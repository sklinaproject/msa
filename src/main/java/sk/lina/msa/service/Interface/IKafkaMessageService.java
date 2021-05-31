package sk.lina.msa.service.Interface;

import sk.lina.msa.model.KafkaMessageDTO;

public interface IKafkaMessageService {
    void produceKafkaMessage(KafkaMessageDTO kafkaMessageDTO);
}
