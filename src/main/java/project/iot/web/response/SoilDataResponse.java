package project.iot.web.response;

import java.util.List;

public class SoilDataResponse {
    private List<SoilMoistureResponse> soilMoistures;
    private List<TemperatureResponse> tempSoils;
    private List<ConductSoilResponse> conductSoils;

    public List<SoilMoistureResponse> getSoilMoistures() {
        return soilMoistures;
    }

    public void setSoilMoistures(List<SoilMoistureResponse> soilMoistures) {
        this.soilMoistures = soilMoistures;
    }

    public List<TemperatureResponse> getTempSoils() {
        return tempSoils;
    }

    public void setTempSoils(List<TemperatureResponse> tempSoils) {
        this.tempSoils = tempSoils;
    }

    public List<ConductSoilResponse> getConductSoils() {
        return conductSoils;
    }

    public void setConductSoils(List<ConductSoilResponse> conductSoils) {
        this.conductSoils = conductSoils;
    }
}
