package project.iot.mapper;

import project.iot.model.SenderType;
import project.iot.model.Temperature;
import project.iot.web.request.TempCreateRequest;
import project.iot.web.response.TemperatureResponse;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TempMapper {
    public Temperature toTemperature(String value, SenderType senderType) {
        Temperature temperature = new Temperature();
        temperature.setTimestamp(Instant.now());
        temperature.setValue(Float.parseFloat(value));
        temperature.setSender(senderType);
        return temperature;
    }

    public TemperatureResponse toResponse(List<Temperature> temperatures) {
        TemperatureResponse response = new TemperatureResponse();
        Map<Instant, Float> temperatureMap = new HashMap<>();
        for (Temperature temperature : temperatures) {
            temperatureMap.put(temperature.getTimestamp(), temperature.getValue());
        }
        response.setTemperatures(temperatureMap);
        return response;
    }

}
