package project.iot.web.response;

import java.util.List;

public class SoilDataResponse {
    private List<SoilMoistureResponse> soilMoistures;
    private List<TempSoilResponse> tempSoils;
    private List<ConductSoilResponse> conductSoils;

    public List<SoilMoistureResponse> getSoilMoistures() {
        return soilMoistures;
    }

    public void setSoilMoistures(List<SoilMoistureResponse> soilMoistures) {
        this.soilMoistures = soilMoistures;
    }

    public List<TempSoilResponse> getTempSoils() {
        return tempSoils;
    }

    public void setTempSoils(List<TempSoilResponse> tempSoils) {
        this.tempSoils = tempSoils;
    }

    public List<ConductSoilResponse> getConductSoils() {
        return conductSoils;
    }

    public void setConductSoils(List<ConductSoilResponse> conductSoils) {
        this.conductSoils = conductSoils;
    }
}
