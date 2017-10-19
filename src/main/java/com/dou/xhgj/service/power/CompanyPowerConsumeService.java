package com.dou.xhgj.service.power;

import com.dou.xhgj.domain.power.PowerLasterConsume;
import com.dou.xhgj.domain.power.PowerTswkConsume;
import com.dou.xhgj.domain.power.PowerTswkJFGConsume;

import java.util.List;

/**
 * @Author: qiao
 * @Description:
 * @Date: Created in 2017/10/18 21:42
 * @Modified By:
 * @Email: qiaokekeshu@163.com
 */
public interface CompanyPowerConsumeService {
    public List<PowerTswkConsume> getPowerTswkConsumeByCompanyId(int companyId);
    public List<PowerTswkJFGConsume> getPowerTswkJFGConsumeByCompanyId(int companyId);
    public List<PowerLasterConsume> getPowerLasterAllConsume();
}
