package project.iot.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import project.iot.mapper.TempMapper;
import project.iot.model.SenderType;
import project.iot.model.Temperature;
import project.iot.repository.TempRepository;
import project.iot.web.request.TempCreateRequest;
import project.iot.web.response.TemperatureResponse;

@Service
@AllArgsConstructor
public class TempService {

    private final TempRepository tempRepository;
    private static final TempMapper tempMapper = new TempMapper();
    public void saveTemperature (TempCreateRequest request) {
        save(request.getValue());
    }
    public void saveTemperature (String value) {
        save(value);
    }
    private void save(String temp) {
        Temperature temperatureToSave = tempMapper.toTemperature(temp, SenderType.HTTP);
        tempRepository.save(temperatureToSave);
    }
    public TemperatureResponse getEsp32Temperature(){
        return tempMapper.toResponse(tempRepository.findAll());
    }
}
