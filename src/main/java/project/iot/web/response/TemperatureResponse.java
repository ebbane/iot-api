package project.iot.web.response;

import java.time.Instant;

public class TemperatureResponse {
    private Float value;
    private Instant timestamp;

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public TemperatureResponse(Float value, Instant timestamp) {
        this.value = value;
        this.timestamp = timestamp;
    }
}
