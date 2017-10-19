package com.dou.xhgj.domain.company;

/**
 * @Author: qiao
 * @Description:
 * @Date: Created in 2017/10/17 19:35
 * @Modified By:
 * @Email: qiaokekeshu@163.com
 */
public class CompanyBaseInfo {
    int companyId;
    String companyName;

    public CompanyBaseInfo() {
    }

    public CompanyBaseInfo(int companyId, String companyName) {
        this.companyId = companyId;
        this.companyName = companyName;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "CompanyBaseInfo{" +
                "companyId=" + companyId +
                ", companyName=" + companyName +
                '}';
    }
}
