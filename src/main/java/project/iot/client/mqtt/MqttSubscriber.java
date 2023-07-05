package project.iot.client.mqtt;

import org.eclipse.paho.client.mqttv3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import project.iot.properties.MqttProperties;
import project.iot.service.TempService;

@Component
public class MqttSubscriber implements MqttCallback, ApplicationRunner {
    Logger logger = LoggerFactory.getLogger(MqttSubscriber.class);

    private final TempService tempService;

    @Autowired
    MqttProperties mqttProperties;

    public MqttSubscriber(TempService tempService, MqttProperties mqttProperties) {
        this.tempService = tempService;
        this.mqttProperties = mqttProperties;
    }

    @Override
    public void run(ApplicationArguments args) {
        try (MqttClient mqttClient = new MqttClient(mqttProperties.getBroker(), mqttProperties.getClient())) {
            mqttClient.setCallback(this);
            mqttClient.connect();
            mqttClient.subscribe(mqttProperties.getTopic());
        } catch (MqttException e) {
            logger.warn(e.getMessage());
        }
    }

    @Override
    public void connectionLost(Throwable cause) {
        logger.error("Connection lost: " + cause.getMessage());
    }

    @Override
    public void messageArrived(String topic, MqttMessage message) throws Exception {
        logger.info("Received message on topic '" + topic + "': " + new String(message.getPayload()));
        tempService.saveTemperature(new String(message.getPayload()));

    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
        // Not used in subscriber
    }

}
