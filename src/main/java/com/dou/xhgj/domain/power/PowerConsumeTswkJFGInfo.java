package com.dou.xhgj.domain.power;

/**
 * @Author: qiao
 * @Description:
 * @Date: Created in 2017/10/18 23:30
 * @Modified By:
 * @Email: qiaokekeshu@163.com
 */
public class PowerConsumeTswkJFGInfo {
    int companyId;
    String powerMeterParaId;
    String powerMeterId;
    double readValue;
    String readDate;
    String readTime;

    public PowerConsumeTswkJFGInfo() {
    }

    public PowerConsumeTswkJFGInfo(int companyId, String powerMeterParaId, String powerMeterId, double readValue, String readDate, String readTime) {
        this.companyId = companyId;
        this.powerMeterParaId = powerMeterParaId;
        this.powerMeterId = powerMeterId;
        this.readValue = readValue;
        this.readDate = readDate;
        this.readTime = readTime;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getPowerMeterParaId() {
        return powerMeterParaId;
    }

    public void setPowerMeterParaId(String powerMeterParaId) {
        this.powerMeterParaId = powerMeterParaId;
    }

    public String getPowerMeterId() {
        return powerMeterId;
    }

    public void setPowerMeterId(String powerMeterId) {
        this.powerMeterId = powerMeterId;
    }

    public double getReadValue() {
        return readValue;
    }

    public void setReadValue(double readValue) {
        this.readValue = readValue;
    }

    public String getReadDate() {
        return readDate;
    }

    public void setReadDate(String readDate) {
        this.readDate = readDate;
    }

    public String getReadTime() {
        return readTime;
    }

    public void setReadTime(String readTime) {
        this.readTime = readTime;
    }

    @Override
    public String toString() {
        return "PowerConsumeTswkJFGInfo{" +
                "companyId=" + companyId +
                ", powerMeterParaId='" + powerMeterParaId + '\'' +
                ", powerMeterId='" + powerMeterId + '\'' +
                ", readValue=" + readValue +
                ", readDate='" + readDate + '\'' +
                ", readTime='" + readTime + '\'' +
                '}';
    }
}
