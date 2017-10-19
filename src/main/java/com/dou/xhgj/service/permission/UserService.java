package com.dou.xhgj.service.permission;

import com.dou.xhgj.domain.PageResult;
import com.dou.xhgj.domain.UserInfo;
import com.dou.xhgj.domain.permission.UserRoleVo;

import java.util.List;
import java.util.Set;

/**
 * @Author: Francis Zhuge
 * @Description:
 * @Date: Created in 2017/10/19, 15:08
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
public interface UserService {
    /**
     * 新增
     * @param userInfo
     */
     UserInfo save(UserInfo userInfo);

    /**
     * 更新
     * @param userInfo
     */
    void update(UserInfo userInfo);

    /**
     * 根据主键删除
     * @param id
     */
    void deleteById(Long id);

    /**
     * 根据主键查找
     * @param id
     * @return
     */
    UserInfo getUserById(Long id);


    /**
     * 分页查找
     * @param pageNo
     * @param pageSize
     * @return
     */
    PageResult<UserInfo> getPageResult(int pageNo, int pageSize);

    /**
     * 根据用户名分页查找
     * @param username
     * @param pageNo
     * @param pageSize
     * @return
     */
    PageResult<UserInfo> getPageResultByUsername(String username, int pageNo, int pageSize);

    /**
     * 添加用户-角色关系
     * @param userId
     * @param roleIds
     */
    void correlationRoles(Long userId, Long... roleIds);


    /**
     * 移除用户-角色关系
     * @param userId
     * @param roleIds
     */
    void uncorrelationRoles(Long userId, Long... roleIds);

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    UserInfo getByUsername(String username);

    /**
     * 根据用户名查找其角色,角色不能使用的也会被查找出来
     * @param username
     * @return
     */
    Set<String> findRoles(String username);

    /**
     * 根据用户名查找其角色，只查找出能够使用的角色。
     * @param username
     * @return
     */
    Set<String> findRoleswithAvailable(String username);

    /**
     * 根据用户ID查找其角色，只查找出能够使用的角色。
     * @return
     */
    List<UserRoleVo> findAllRoleswithAvailable();

    /**
     * 根据用户名查找其权限
     * @param username
     * @return
     */
    Set<String> findPermissions(String username);

    /**
     * 更改用户的可用状态
     * @param id
     */
    void changeState(long id);

    /**
     * 查询跟指定ID的user有关联的role且角色有用的role id的集合。
     * @param id
     * @return
     */
    List<Integer> findRolesByUserId(Long id);

    /**
     * 根据页面的数据更新用户的权限信息
     * @param userId
     * @param roleIds
     */
    void updateRoles(Long userId, List<Long> roleIds);
}
