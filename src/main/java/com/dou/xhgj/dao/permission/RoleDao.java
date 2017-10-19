package com.dou.xhgj.dao.permission;

import com.dou.xhgj.domain.permission.Role;
import com.dou.xhgj.domain.permission.RolePermissionVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author: Francis Zhuge
 * @Description:
 * @Date: Created in 2017/10/16, 22:22
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
@Mapper
public interface RoleDao {
    String ROLE = " sys_roles ";
    String USER_ROLE = " sys_users_roles ";
    String ROLE_PERMISSION = " sys_roles_permissions ";
    String PERMISSION = " sys_permissions ";
    String SELECT_FIELDS = " id, role, description, available";
    String INSERT_FIELDS = " role, description, available ";

    /**
     * 增加一个权限
     * @param role
     */
    @Insert({" insert into ", ROLE ," (", INSERT_FIELDS ,") values(#{role.role},#{role.description},#{role.available})"})
    @Options(useGeneratedKeys = true, keyProperty = "role.id")
    void saveRole(@Param("role") Role role );

    /**
     * 删除一个权限
     * @param roleId
     */
    @Delete({" delete from ", ROLE ," where id=#{roleId} "})
    void deleteRole(@Param("roleId") Long roleId);

    /**
     * 删除中间表数据
     * @param roleId
     */
    @Delete({" delete from ", USER_ROLE ," where role_id=#{roleId} "})
    void deleteUserAndRole(@Param("roleId") Long roleId);

    /**
     * 插入role表和permission中间表
     * @param roleId
     * @param permissionId
     */
    @Insert({" insert into ", ROLE_PERMISSION ," (role_id,permission_id) values(#{roleId},#{permissionId})"})
    void correlationPermission(@Param("roleId") Long roleId,@Param("permissionId") Long permissionId);

    /**
     * 删除role和permission中间表
     * @param roleId
     * @param permissionId
     */
    @Delete({" delete from ", ROLE_PERMISSION ," where role_id=#{roleId} and permission_id=#{permissionId} "})
    void uncorrelationPermission(@Param("roleId") Long roleId, @Param("permissionId") Long permissionId);

    /**
     * 检查指定的角色和指定的权限之间是否有关联关系
     * @param roleId
     * @param permissionId
     * @return 返回指定roleId和permissionId有关联关系的条数
     */
    @Select({" select count(1) from ",ROLE_PERMISSION," where role_id=#{roleId} and permission_id=#{permissionId} "})
    int exists(@Param("roleId") Long roleId, @Param("permissionId") Long permissionId);

    /**
     * 查询总记录数
     * @return
     */
    @Select({" select count(1) from  ", ROLE})
    int count();

    /**
     * 分页查找（无任何条件查找）
     * @param start
     * @param limit
     * @return
     */
    @Select({" select ", SELECT_FIELDS ," from ", ROLE ," limit #{start} ,#{limit} "})
    List<Role> list(@Param("start") int start, @Param("limit") int limit);

    /**
     * 根据条件查找总记录数
     * @param role
     * @return
     */
    @Select({" select count(*) from  ", ROLE , "  where role like concat(concat('%',#{role},'%'))"})
    int countByRole(@Param("role") String role);

    /**
     * 根据rolename分页查找
     * @param role
     * @param start
     * @param limit
     * @return
     */
    @Select({" select ", SELECT_FIELDS ," from  ", ROLE , "  where role like concat(concat('%',#{role},'%')) limit #{start} ,#{limit}"})
    List<Role> listByRole(@Param("role") String role,@Param("start") int start, @Param("limit") int limit);

    /**
     * 根据属性名查找
     * @param role
     * @return
     */
    @Select({" select ", SELECT_FIELDS ," from  ", ROLE , "  where role=#{role} "})
    Role getByRole(@Param("role") String role);

    /**
     * 根据主键查找
     * @param id
     * @return
     */
    @Select({" select ", SELECT_FIELDS ," from  ", ROLE , "  where id=#{id} "})
    Role getRoleById(@Param("id") long id);

    /**
     * 更新角色
     * @param role
     */
    @Update({" update ", ROLE ," set role=#{role.role},description=#{role.description},available=#{role.available} where id=#{role.id} "})
    void update(@Param("role") Role role);

    /**
     * 查找系统中所有可用的权限
     * @return
     */
    @Select({" select id, permission, description from sys_permissions where available=1 "})
    List<RolePermissionVo> findAllPermissionswithAvailable();

    /**
     * 查询与指定roleId可用的permission集合
     * @param id
     * @return
     */
    @Select({" select p.id from ", ROLE_PERMISSION ," rp, ", PERMISSION ," p where rp.role_id=#{id} and rp.permission_id=p.id and p.available=1 "})
    List<Integer> findPermissionsByRoleId(@Param("id") Long id);

    /**
     * 删除指定roleId所有权限
     * @param roleId
     */
    @Delete({" delete from ", ROLE_PERMISSION ," where role_id=#{roleId} "})
    void uncorrelationPermissions(@Param("roleId") Long roleId);
}
