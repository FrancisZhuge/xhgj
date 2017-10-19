package com.dou.xhgj.domain.power;

/**
 * @Author: qiao
 * @Description:
 * @Date: Created in 2017/10/18 23:39
 * @Modified By:
 * @Email: qiaokekeshu@163.com
 */
public class PowerTswkJFGConsume {
    int id;
    double jianValue;
    double fengValue;
    double guValue;
    double zongValue;

    public PowerTswkJFGConsume() {
    }

    public PowerTswkJFGConsume(int id, double jianValue, double fengValue, double guValue, double zongValue) {
        this.id = id;
        this.jianValue = jianValue;
        this.fengValue = fengValue;
        this.guValue = guValue;
        this.zongValue = zongValue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getJianValue() {
        return jianValue;
    }

    public void setJianValue(double jianValue) {
        this.jianValue = jianValue;
    }

    public double getFengValue() {
        return fengValue;
    }

    public void setFengValue(double fengValue) {
        this.fengValue = fengValue;
    }

    public double getGuValue() {
        return guValue;
    }

    public void setGuValue(double guValue) {
        this.guValue = guValue;
    }

    public double getZongValue() {
        return zongValue;
    }

    public void setZongValue(double zongValue) {
        this.zongValue = zongValue;
    }

    @Override
    public String toString() {
        return "PowerTswkJFGConsume{" +
                "id=" + id +
                ", jianValue=" + jianValue +
                ", fengValue=" + fengValue +
                ", guValue=" + guValue +
                ", zongValue=" + zongValue +
                '}';
    }
}
