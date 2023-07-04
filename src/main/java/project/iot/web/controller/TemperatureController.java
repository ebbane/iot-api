package project.iot.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import project.iot.service.Esp32Service;
import project.iot.service.TempService;
import project.iot.web.request.TempCreateRequest;
import project.iot.web.response.ConfigResponse;
import project.iot.web.response.TemperatureResponse;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class TemperatureController {

    private final TempService tempService;

    @RequestMapping(method = RequestMethod.GET, value = "/api/v1/temperature", produces = MediaType.APPLICATION_JSON_VALUE)
    public TemperatureResponse getConfig() {
        return tempService.getEsp32Temperature();
    }

}
