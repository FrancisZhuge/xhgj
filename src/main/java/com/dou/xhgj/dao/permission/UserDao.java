package com.dou.xhgj.dao.permission;

import com.dou.xhgj.domain.UserInfo;
import com.dou.xhgj.domain.permission.UserRoleVo;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Set;

/**
 * @Author: Francis Zhuge
 * @Description:
 * @Date: Created in 2017/10/19, 15:09
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
@Mapper
public interface UserDao {
    String USER = "user_info";
    String USER_ROLE = "sys_users_roles";
    String ROLE = "sys_roles";
    String PERMISSION = "sys_permissions";
    String ROLE_PERMISSIONS = "sys_roles_permissions";
    String INSERT_FIELDS = "user_no username, area_id, building_id, password, salt, locked";
    String SELECT_FIELDS = "id, user_no as userNo, username, area_id as areaId, building_id as buildingId, password, salt, locked";

    /**
     * 查询总记录数
     * @return
     */
    @Select({" select count(1) from  ", USER})
    int count();

    /**
     * 分页查找（无任何条件查找）
     * @param start
     * @param limit
     * @return
     */
    @Select({" select ", SELECT_FIELDS ," from ", USER ," limit #{start} ,#{limit} "})
    List<UserInfo> list(@Param("start") int start, @Param("limit") int limit);

    /**
     * 根据username查找总记录数
     * @param username
     * @return
     */
    @Select({" select count(*) from  ", USER , "  where username like concat(concat('%',#{username},'%'))"})
    int countByUsername(@Param("username") String username);

    /**
     * 根据username分页查找
     * @param role
     * @param start
     * @param limit
     * @return
     */
    @Select({" select ", SELECT_FIELDS ," from  ", USER , "  where username like concat(concat('%',#{username},'%')) limit #{start} ,#{limit}"})
    List<UserInfo> listByUsername(@Param("username") String role,@Param("start") int start, @Param("limit") int limit);

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    @Select({" select ", SELECT_FIELDS ," from  ", USER , "  where username =#{username}"})
    UserInfo getByUsername(@Param("username") String username);

    /**
     * 增加一个用户
     * @param userInfo
     */
    @Insert({" insert into ", USER ," (", INSERT_FIELDS ,") values(#{userInfo.userNo}#{userInfo.username},#{userInfo.areaId},#{userInfo.buildingId},#{userInfo.password},#{userInfo.salt},#{userInfo.locked})"})
    @Options(useGeneratedKeys = true, keyProperty = "user.id")
    void saveUser(@Param("userInfo") UserInfo userInfo);

    /**
     * 根据主键删除一个用户
     * @param userInfoId
     */
    @Delete({" delete from ", USER ," where id=#{userInfoId} "})
    void deleteUserById(@Param("userInfoId") Long userInfoId);

    /**
     * 更新
     * @param userInfo
     */
    @Update({" update ", USER ," set user_no=#{userInfo.userNo} username=#{userInfo.username},area_id=#{userInfo.areaId},building_id=#{userInfo.buildingId},password=#{userInfo.password},salt=#{userInfo.salt},locked=#{userInfo.locked} where id=#{userInfo.id}"})
    void update(@Param("userInfo") UserInfo userInfo);

    /**
     * 根据主键查找用户
     * @param userId
     * @return
     */
    @Select({" select ", SELECT_FIELDS ," from ", USER ," where id=#{userId} "})
    UserInfo getUserById(@Param("userId") Long userId);

    /**
     * 增加用户和角色之间的关系
     * @param userId
     * @param roleId
     */
    @Insert({" insert into ", USER_ROLE ," (user_id, role_id) values(#{userId},#{roleId})"})
    void correlationRole(@Param("userId") Long userId, @Param("roleId") Long roleId);

    /**
     * 删除用户和角色之间的关系
     * @param userId
     * @param roleId
     */
    @Delete({" delete from ", USER_ROLE ," where user_id=#{userId} and role_id=#{roleId} "})
    void uncorrelationRole(@Param("userId") Long userId, @Param("roleId") Long roleId);

    /**
     * 检查指定的用户和指定的角色之间是否有关联关系
     * @param userId
     * @param roleId
     * @return 返回指定userId和roleId有关联关系的条数
     */
    @Select({" select count(1) from ", USER_ROLE ," where user_id=#{userId} and role_id=#{roleId} "})
    int exists(@Param("userId") Long userId, @Param("roleId") Long roleId);

    /**
     * 根据用户的用户名查找用户所有的角色
     * @param username
     * @return
     */
    @Select({" select role from ", USER ," u, ", ROLE ," r,", USER_ROLE ," ur where u.username=#{username} and u.id=ur.user_id and r.id=ur.role_id"})
    Set<String> findRoles(@Param("username") String username);

    /**
     * 根据用户的用户名查找用户所有可用的角色
     * @param username
     * @return
     */
    @Select({" select role from ", USER ," u, ", ROLE ," r,", USER_ROLE ," ur where u.username=#{username} and u.id=ur.user_id and r.id=ur.role_id and  r.available = 1"})
    Set<String> findRoleswithAvailable(@Param("username") String username);

    /**
     * 查找所有可用的Role
     * @return
     */
    @Select({" select r.id,r.role,r.description from ", ROLE ," r where r.available=1"})
    List<UserRoleVo> findAllRoleswithAvailable();

    /**
     * 根据用户的用户名查找到用户对应的权限
     * @param username
     * @return
     */
    @Select({" select permission from ", USER ," u, ", ROLE ," r, ", PERMISSION ," p, ", USER_ROLE," ur, ", ROLE_PERMISSIONS ," rp where u.username=#{username} and u.id=ur.user_id and r.id=ur.role_id and r.id=rp.role_id and p.id=rp.permission_id and p.available = 1"})
    Set<String> findPermissions(@Param("username") String username);

    /**
     * 查询跟指定ID的user有关联的role且角色有用的role id的集合。
     * @param id
     * @return
     */
    @Select({" select r.id from sys_roles r, ", USER_ROLE ," ur where ur.user_id=#{id} and ur.role_id=r.id and r.available=1 "})
    List<Integer> findRolesByUserId(@Param("id") Long id);

    /**
     * 根据指定的userId删除所有权限
     * @param userId
     */
    @Delete({" delete from ", USER_ROLE ," where user_id = #{userId}"})
    void uncorrelationByUserId(@Param("userId") Long userId);
}
