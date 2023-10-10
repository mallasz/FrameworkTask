package model;

import com.opencsv.bean.CsvBindByName;

public class CalculatorSettings {
    @CsvBindByName
    private String numberOfInstances;
    @CsvBindByName
    private String operatingSystem;
    @CsvBindByName
    private String provisioningModel;
    @CsvBindByName
    private String machineFamily;
    @CsvBindByName
    private String series;
    @CsvBindByName
    private String machineType;
    @CsvBindByName
    private String gpuType;
    @CsvBindByName
    private String gpuCount;
    @CsvBindByName
    private String ssd;
    @CsvBindByName
    private String location;
    @CsvBindByName
    private String committedUsage;

    public String getNumberOfInstances() {
        return numberOfInstances;
    }

    public void setNumberOfInstances(String numberOfInstances) {
        this.numberOfInstances = numberOfInstances;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getProvisioningModel() {
        return provisioningModel;
    }

    public void setProvisioningModel(String provisioningModel) {
        this.provisioningModel = provisioningModel;
    }

    public String getMachineFamily() {
        return machineFamily;
    }

    public void setMachineFamily(String machineFamily) {
        this.machineFamily = machineFamily;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getMachineType() {
        return machineType;
    }

    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    public String getGpuType() {
        return gpuType;
    }

    public void setGpuType(String gpuType) {
        this.gpuType = gpuType;
    }

    public String getGpuCount() {
        return gpuCount;
    }

    public void setGpuCount(String gpuCount) {
        this.gpuCount = gpuCount;
    }

    public String getSsd() {
        return ssd;
    }

    public void setSsd(String ssd) {
        this.ssd = ssd;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCommittedUsage() {
        return committedUsage;
    }

    public void setCommittedUsage(String committedUsage) {
        this.committedUsage = committedUsage;
    }
}
