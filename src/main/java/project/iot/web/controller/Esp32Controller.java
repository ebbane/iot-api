package project.iot.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import project.iot.service.Esp32Service;
import project.iot.service.TempService;
import project.iot.web.request.TempCreateRequest;
import project.iot.web.response.ConfigResponse;
import project.iot.web.response.Esp32TemperatureResponse;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class Esp32Controller {

    private final TempService tempService;
    private final Esp32Service esp32Service;

    @RequestMapping(method = RequestMethod.POST, value = "/api/v1/esp32", produces = MediaType.APPLICATION_JSON_VALUE)
    public void register(@Valid @RequestBody TempCreateRequest request) {
        tempService.saveTemperature(request);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/api/v1/esp32/config", produces = MediaType.APPLICATION_JSON_VALUE)
    public ConfigResponse getConfig() {
        return esp32Service.getConfig();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/api/v1/esp32/temperature", produces = MediaType.APPLICATION_JSON_VALUE)
    public Esp32TemperatureResponse getEspTemperature() {
        return tempService.getEsp32Temperature();
    }

}
