package com.dou.xhgj.domain.power;

/**
 * @Author: qiao
 * @Description:
 * @Date: Created in 2017/10/18 20:57
 * @Modified By:
 * @Email: qiaokekeshu@163.com
 */
public class PowerTswkConsume {
    int id;
    double value;

    public PowerTswkConsume() {
    }

    public PowerTswkConsume(int id, double value) {
        this.id = id;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "PowerTswkConsume{" +
                "id=" + id +
                ", value=" + value +
                '}';
    }
}
