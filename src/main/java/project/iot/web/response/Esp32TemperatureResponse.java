package project.iot.web.response;

import java.time.Instant;
import java.util.List;
import java.util.Map;

public class Esp32TemperatureResponse {

    List<TemperatureResponse> temperatures;

    public List<TemperatureResponse> getTemperatures() {
        return temperatures;
    }

    public void setTemperatures(List<TemperatureResponse> temperatures) {
        this.temperatures = temperatures;
    }
}
