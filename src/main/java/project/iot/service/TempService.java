package project.iot.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import project.iot.mapper.TempMapper;
import project.iot.model.SenderType;
import project.iot.model.Temperature;
import project.iot.repository.TempRepository;
import project.iot.web.request.TempCreateRequest;
import project.iot.web.response.Esp32TemperatureResponse;

@Service
@AllArgsConstructor
public class TempService {

    private final TempRepository tempRepository;
    private static final TempMapper tempMapper = new TempMapper();
    public void saveTemperature (TempCreateRequest request) {
        save(request.getValue(), SenderType.HTTP);
    }
    public void saveTemperature (String value) {
        save(value, SenderType.MQTT);
    }
    private void save(String temp, SenderType type) {
        Temperature temperatureToSave = tempMapper.toTemperature(temp, type);
        tempRepository.save(temperatureToSave);
    }
    public Esp32TemperatureResponse getEsp32Temperature(){
        return tempMapper.toResponse(tempRepository.findAll());
    }
}
