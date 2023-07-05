package project.iot.mapper;

import project.iot.model.SenderType;
import project.iot.model.Temperature;
import project.iot.web.response.Esp32TemperatureResponse;
import project.iot.web.response.TemperatureResponse;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TempMapper {
    public Temperature toTemperature(String value, SenderType senderType) {
        Temperature temperature = new Temperature();
        temperature.setTimestamp(Instant.now());
        temperature.setValue(Float.parseFloat(value));
        temperature.setSender(senderType);
        return temperature;
    }

    public Esp32TemperatureResponse toResponse(List<Temperature> temperatures) {
        Esp32TemperatureResponse esp32TemperatureResponse = new Esp32TemperatureResponse();
        List<TemperatureResponse> temperatureResponses = new ArrayList<>();
        for (Temperature temperature : temperatures) {
            TemperatureResponse response = new TemperatureResponse(
                    temperature.getValue(),
                    temperature.getTimestamp()
            );
            temperatureResponses.add(response);
        }
        esp32TemperatureResponse.setTemperatures(temperatureResponses);
        return esp32TemperatureResponse;
    }

}
