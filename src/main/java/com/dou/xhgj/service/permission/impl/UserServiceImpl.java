package com.dou.xhgj.service.permission.impl;

import com.dou.xhgj.dao.permission.UserDao;
import com.dou.xhgj.domain.PageResult;
import com.dou.xhgj.domain.UserInfo;
import com.dou.xhgj.domain.permission.UserRoleVo;
import com.dou.xhgj.service.PasswordService;
import com.dou.xhgj.service.permission.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * @Author: Francis Zhuge
 * @Description:
 * @Date: Created in 2017/10/19, 15:09
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
@Service
public class UserServiceImpl implements UserService{

    private final static Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordService passwordService;


    @Override
    public UserInfo save(UserInfo userInfo) {
        try {
            passwordService.encryptPassword(userInfo);
            userDao.saveUser(userInfo);
        } catch (Exception e) {
            LOGGER.error("save failed, ",e);
        }
        return userInfo;
    }

    @Override
    public void update(UserInfo userInfo) {
        try {
            passwordService.encryptPassword(userInfo);
            userDao.update(userInfo);
        } catch (Exception e) {
            LOGGER.error("update failed, ",e);
        }
    }

    @Override
    public void deleteById(Long id) {
        try {
            userDao.deleteUserById(id);
        } catch (Exception e) {
            LOGGER.error("deleteById failed, ",e);
        }
    }

    @Override
    public UserInfo getUserById(Long id) {
        UserInfo userById = null;
        try {
            userById = userDao.getUserById(id);
        } catch (Exception e) {
            LOGGER.error("getUserById failed, ",e);
        }
        if(userById == null){
            return null;
        }else {
            return userById;
        }
    }

    @Override
    public PageResult<UserInfo> getPageResult(int pageNo, int pageSize) {
        int start = pageNo*pageSize;
        int limit = pageSize;
        int totalCount = 0;
        List<UserInfo> users = null;
        try {
            totalCount = userDao.count();
            users = userDao.list(start, limit);
        } catch (Exception e) {
            LOGGER.error("getPageResult failed, ",e);
        }
        return new PageResult<>(totalCount,pageNo,pageSize,users);
    }

    @Override
    public PageResult<UserInfo> getPageResultByUsername(String username, int pageNo, int pageSize) {
        int start = pageNo*pageSize;
        int limit = pageSize;
        int count = 0;
        List<UserInfo> users = null;
        try {
            count = userDao.countByUsername(username);
            users = userDao.listByUsername(username, start, limit);
        } catch (Exception e) {
            LOGGER.error("getPageResult failed, ",e);
        }
        return new PageResult<>(count,pageNo,pageSize,users);
    }

    @Override
    public void correlationRoles(Long userId, Long... roleIds) {
        if(roleIds == null || roleIds.length == 0) {
            return;
        }
        for(Long roleId:roleIds){
            if(!exists(userId,roleId)){
                userDao.correlationRole(userId,roleId);
            }
        }
    }

    @Override
    public void uncorrelationRoles(Long userId, Long... roleIds) {
        if(roleIds == null || roleIds.length == 0) {
            return;
        }

        for(Long roleId:roleIds){
            if(exists(userId,roleId)){
                userDao.uncorrelationRole(userId,roleId);
            }
        }
    }

    @Override
    public UserInfo getByUsername(String username) {
        UserInfo byUsername = null;
        try {
            byUsername = userDao.getByUsername(username);
        } catch (Exception e) {
            LOGGER.error("findByUsername failed, ",e);
        }
        return byUsername;
    }

    @Override
    public Set<String> findRoles(String username) {
        Set<String> roles = null;
        try {
            roles = userDao.findRoles(username);
        } catch (Exception e) {
            LOGGER.error("findRoles failed, ",e);
        }
        return roles;
    }

    @Override
    public Set<String> findRoleswithAvailable(String username) {
        Set<String> roles = null;
        try {
            roles = userDao.findRoleswithAvailable(username);
        } catch (Exception e) {
            LOGGER.error("findRoles failed, ",e);
        }
        return roles;
    }

    @Override
    public List<UserRoleVo> findAllRoleswithAvailable() {
        List<UserRoleVo> roles = null;
        try {
            roles = userDao.findAllRoleswithAvailable();
        } catch (Exception e) {
            LOGGER.error("findRoles failed, ",e);
        }
        return roles;
    }

    @Override
    public Set<String> findPermissions(String username) {
        Set<String> permissions = null;
        try {
            permissions = userDao.findPermissions(username);
        } catch (Exception e) {
            LOGGER.error("findPermissions failed, ",e);
        }
        return permissions;
    }

    @Override
    public void changeState(long id) {
        try {
            UserInfo user = getUserById(id);
            System.out.println(user);
            if(user.getLocked().equals(true)){
                user.setLocked(false);
            }else {
                user.setLocked(true);
            }
            userDao.update(user);
        } catch (Exception e) {
            LOGGER.error("changeState failed, ",e);
        }
    }

    @Override
    public List<Integer> findRolesByUserId(Long id) {
        List<Integer> byUserId = null;
        try {
            byUserId = userDao.findRolesByUserId(id);
        } catch (Exception e) {
            LOGGER.error("findRolesByUserId failed, ",e);
        }
        return byUserId;
    }

    @Override
    public void updateRoles(Long userId, List<Long> roleIds) {
        try {
            userDao.uncorrelationByUserId(userId);
            for(Long roleId:roleIds){
                userDao.correlationRole(userId,roleId);
            }
        } catch (Exception e) {
            LOGGER.error("updateRoles failed, ",e);
        }
    }

    /**
     * 中间表是否存在值userId和roleId
     * @param userId
     * @param roleId
     * @return
     */
    private boolean exists(Long userId, Long roleId){
        int exists = userDao.exists(userId,roleId);
        if(exists==0)
            return false;
        else
            return true;
    }
}
