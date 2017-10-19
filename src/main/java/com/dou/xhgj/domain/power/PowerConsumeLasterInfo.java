package com.dou.xhgj.domain.power;

/**
 * @Author: qiao
 * @Description:
 * @Date: Created in 2017/10/19 8:42
 * @Modified By:
 * @Email: qiaokekeshu@163.com
 */
public class PowerConsumeLasterInfo {
    int companyId;
    String userName;
    String powerMeterParaId;
    String powerMeterId;
    String readValue;
    String readTime;

    public PowerConsumeLasterInfo() {
    }

    public PowerConsumeLasterInfo(int companyId, String userName, String powerMeterParaId, String powerMeterId, String readValue, String readTime) {
        this.companyId = companyId;
        this.userName = userName;
        this.powerMeterParaId = powerMeterParaId;
        this.powerMeterId = powerMeterId;
        this.readValue = readValue;
        this.readTime = readTime;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getReadValue() {
        return readValue;
    }

    public void setReadValue(String readValue) {
        this.readValue = readValue;
    }

    public String getReadTime() {
        return readTime;
    }

    public void setReadTime(String readTime) {
        this.readTime = readTime;
    }

    @Override
    public String toString() {
        return "PowerConsumeLasterInfo{" +
                "companyId=" + companyId +
                ", userName='" + userName + '\'' +
                ", powerMeterParaId='" + powerMeterParaId + '\'' +
                ", powerMeterId='" + powerMeterId + '\'' +
                ", readValue='" + readValue + '\'' +
                ", readTime='" + readTime + '\'' +
                '}';
    }
}
