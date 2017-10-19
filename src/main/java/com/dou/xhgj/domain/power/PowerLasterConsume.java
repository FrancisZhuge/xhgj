package com.dou.xhgj.domain.power;

/**
 * @Author: qiao
 * @Description:
 * @Date: Created in 2017/10/19 8:44
 * @Modified By:
 * @Email: qiaokekeshu@163.com
 */
public class PowerLasterConsume {
    int id;
    String company;
    double aDainya;
    double bDainYa;
    double cDianya;
    double aDianliu;
    double bDianliu;
    double cDianliu;
    double youGongGonglv;
    double zongGonglv;
    double zongDianNeng;
    double jianDianNeng;
    double fengDianNeng;
    double guDianNeng;
    double beiLv;
    String readTime;

    public PowerLasterConsume() {
    }

    public PowerLasterConsume(int id,String company, double aDainya, double bDainYa, double cDianya, double aDianliu, double bDianliu, double cDianliu, double youGongGonglv, double zongGonglv, double zongDianNeng, double jianDianNeng, double fengDianNeng, double guDianNeng, double beiLv, String readTime) {
        this.id=id;
        this.company = company;
        this.aDainya = aDainya;
        this.bDainYa = bDainYa;
        this.cDianya = cDianya;
        this.aDianliu = aDianliu;
        this.bDianliu = bDianliu;
        this.cDianliu = cDianliu;
        this.youGongGonglv = youGongGonglv;
        this.zongGonglv = zongGonglv;
        this.zongDianNeng = zongDianNeng;
        this.jianDianNeng = jianDianNeng;
        this.fengDianNeng = fengDianNeng;
        this.guDianNeng = guDianNeng;
        this.beiLv = beiLv;
        this.readTime = readTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public double getaDainya() {
        return aDainya;
    }

    public void setaDainya(double aDainya) {
        this.aDainya = aDainya;
    }

    public double getbDainYa() {
        return bDainYa;
    }

    public void setbDainYa(double bDainYa) {
        this.bDainYa = bDainYa;
    }

    public double getcDianya() {
        return cDianya;
    }

    public void setcDianya(double cDianya) {
        this.cDianya = cDianya;
    }

    public double getaDianliu() {
        return aDianliu;
    }

    public void setaDianliu(double aDianliu) {
        this.aDianliu = aDianliu;
    }

    public double getbDianliu() {
        return bDianliu;
    }

    public void setbDianliu(double bDianliu) {
        this.bDianliu = bDianliu;
    }

    public double getcDianliu() {
        return cDianliu;
    }

    public void setcDianliu(double cDianliu) {
        this.cDianliu = cDianliu;
    }

    public double getYouGongGonglv() {
        return youGongGonglv;
    }

    public void setYouGongGonglv(double youGongGonglv) {
        this.youGongGonglv = youGongGonglv;
    }

    public double getZongGonglv() {
        return zongGonglv;
    }

    public void setZongGonglv(double zongGonglv) {
        this.zongGonglv = zongGonglv;
    }

    public double getZongDianNeng() {
        return zongDianNeng;
    }

    public void setZongDianNeng(double zongDianNeng) {
        this.zongDianNeng = zongDianNeng;
    }

    public double getJianDianNeng() {
        return jianDianNeng;
    }

    public void setJianDianNeng(double jianDianNeng) {
        this.jianDianNeng = jianDianNeng;
    }

    public double getFengDianNeng() {
        return fengDianNeng;
    }

    public void setFengDianNeng(double fengDianNeng) {
        this.fengDianNeng = fengDianNeng;
    }

    public double getGuDianNeng() {
        return guDianNeng;
    }

    public void setGuDianNeng(double guDianNeng) {
        this.guDianNeng = guDianNeng;
    }

    public double getBeiLv() {
        return beiLv;
    }

    public void setBeiLv(double beiLv) {
        this.beiLv = beiLv;
    }

    public String getReadTime() {
        return readTime;
    }

    public void setReadTime(String readTime) {
        this.readTime = readTime;
    }

    @Override
    public String toString() {
        return "PowerLasterConsume{" +
                "id=" + id +
                ", company='" + company + '\'' +
                ", aDainya=" + aDainya +
                ", bDainYa=" + bDainYa +
                ", cDianya=" + cDianya +
                ", aDianliu=" + aDianliu +
                ", bDianliu=" + bDianliu +
                ", cDianliu=" + cDianliu +
                ", youGongGonglv=" + youGongGonglv +
                ", zongGonglv=" + zongGonglv +
                ", zongDianNeng=" + zongDianNeng +
                ", jianDianNeng=" + jianDianNeng +
                ", fengDianNeng=" + fengDianNeng +
                ", guDianNeng=" + guDianNeng +
                ", beiLv=" + beiLv +
                ", readTime='" + readTime + '\'' +
                '}';
    }
}
