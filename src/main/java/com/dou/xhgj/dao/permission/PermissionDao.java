package com.dou.xhgj.dao.permission;

import com.dou.xhgj.domain.permission.Permission;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author: Francis Zhuge
 * @Description: 权限模块的权限Dao
 * @Date: Created in 2017/10/16, 9:52
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
@Mapper
public interface PermissionDao {
    String PERMISSION = " sys_permissions ";
    String ROLE_PERMISSION = " sys_roles_permissions ";
    String SELECT_FIELDS = " id, permission, description, available";
    String INSERT_FIELDS = " permission, description, available ";

    /**
     * Dao服务，新增一个权限
     * @param permission
     */
    @Insert({" insert into ", PERMISSION ,"( ",INSERT_FIELDS," ) values(#{permission.permission},#{permission.description},#{permission.available}) "})
    @Options(useGeneratedKeys = true,keyProperty = "permission.id")
    int savePermission(@Param("permission") Permission permission);

    /**
     * 删除role和permission中间表
     *
     * 在执行删除permission表操作时，先执行这步操作。
     * @param permissionId
     */
    @Delete({" delete from ", ROLE_PERMISSION ," where permission_id=#{permissionId} "})
    void deleteRoleAndPermission(@Param("permissionId") Long permissionId);

    /**
     * 删除权限表
     * @param permissionId
     */
    @Delete({" delete from ", PERMISSION ," where id=#{permissionId} "})
    void deletePermission(@Param("permissionId") Long permissionId);

    /**
     * 无条件统计总页数
     * @return
     */
    @Select({" select count(1) from ", PERMISSION })
    int count();

    /**
     * 无条件分页查询
     * @param start
     * @param limit
     * @return
     */
    @Select({" select ", SELECT_FIELDS ," from ", PERMISSION ," limit #{start}, #{limit} "})
    List<Permission> list(@Param("start") int start, @Param("limit") int limit);

    /**
     * 根据条件统计总页数
     * @param permission
     * @return
     */
    @Select({" select count(1) from ", PERMISSION ," where permission like concat(concat('%',#{permission},'%')) "})
    int countByPermission(@Param("permission") String permission);

    /**
     * 根据条件分页查找
     * @param permission
     * @param start
     * @param limit
     * @return
     */
    @Select({" select ", SELECT_FIELDS ," from ", PERMISSION ," where permission like concat(concat('%',#{permission},'%')) limit #{start}, #{limit} "})
    List<Permission> listByPermission(@Param("permission") String permission, @Param("start") int start, @Param("limit") int limit);

    /**
     * 根据permission查找Permission
     * @param permission
     * @return
     */
    @Select({" select ", SELECT_FIELDS ," from ", PERMISSION ," where permission=#{permission}"})
    Permission getByPermission(@Param("permission") String permission);

    /**
     * 根据主键查找
     * @param id
     * @return
     */
    @Select({" select ", SELECT_FIELDS ," from ", PERMISSION ," where id=#{id} "})
    Permission getPermissionById(@Param("id") long id);

    /**
     * 更新
     * @param permission
     */
    @Update({" update ", PERMISSION ," set permission=#{permission.permission},description=#{permission.description},available=#{permission.available} where id=#{permission.id} "})
    void update(@Param("permission") Permission permission);
}
