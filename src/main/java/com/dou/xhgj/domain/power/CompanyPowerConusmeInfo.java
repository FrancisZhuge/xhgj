package com.dou.xhgj.domain.power;

/**
 * @Author: qiao
 * @Description:
 * @Date: Created in 2017/10/18 21:30
 * @Modified By:
 * @Email: qiaokekeshu@163.com
 */
public class CompanyPowerConusmeInfo {
    String companyId;
    String powerMeterId;
    double readValue;
    String readDate;
    String readTime;

    public CompanyPowerConusmeInfo() {
    }
    public CompanyPowerConusmeInfo(String companyId, String powerMeterId, double readValue, String readDate, String readTime) {
        this.companyId = companyId;
        this.powerMeterId = powerMeterId;
        this.readValue = readValue;
        this.readDate = readDate;
        this.readTime = readTime;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
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
        return "CompanyPowerConusmeInfo{" +
                "companyId='" + companyId + '\'' +
                ", powerMeterId='" + powerMeterId + '\'' +
                ", readValue='" + readValue + '\'' +
                ", readDate='" + readDate + '\'' +
                ", readTime='" + readTime + '\'' +
                '}';
    }
}
