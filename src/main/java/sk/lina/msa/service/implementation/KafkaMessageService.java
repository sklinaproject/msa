package sk.lina.msa.service.implementation;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import sk.lina.msa.model.KafkaMessageDTO;
import sk.lina.msa.service.Interface.IKafkaMessageService;

import java.util.Properties;

@Slf4j
@Service
public class KafkaMessageService implements IKafkaMessageService {

    @Value(value = "${kafka.bootstrapServers}")
    private String bootstrapServers;

    @Override
    public void produceKafkaMessage(KafkaMessageDTO inputKafkaMessageDTO) {
        Properties properties = new Properties();

        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);

        ProducerRecord<String, String> record =
                new ProducerRecord<String, String>("test", inputKafkaMessageDTO.getKafkaMessage1());

        producer.send(record,
                new Callback() {
                    public void onCompletion(RecordMetadata metadata, Exception e) {
                        if(e != null) {
                            e.printStackTrace();
                        } else {
                            log.info("The offset of the record we just sent is: " + metadata.offset());
                        }
                    }
                });

        producer.flush();
        producer.close();
    }
}
