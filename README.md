# xhgj
西湖国际主站

### 功能：权限分页查找
#### 接口：{host}/xhgj/ backend/permission/list
###### 输入参数：

|键|值|描述|
|---|---|---|
|searchPermission|“xhgj”|查询字段（非必须）|
|pageNo|0|查询的页面页号（从0开始）|
|pageSize|5|查询的页面大小|

###### 输出：
如果服务器出错
```java
{
	"code":500
}
```
如果服务器正常
``` java
{
    "code": 200,
    "data": {
        "data": {
            "items": [
                {
                    "available": false,
                    "description": "西湖国际，西湖国际01，公司01",
                    "id": 1,
                    "permission": "xhgj.xhgj01.company01.view"
                },
                {
                    "available": false,
                    "description": "西湖国际，西湖国际01，公司01",
                    "id": 2,
                    "permission": "xhgj.xhgj02.company01.view"
                },
                {
                    "available": false,
                    "description": "西湖国际，西湖国际01，公司01",
                    "id": 3,
                    "permission": "xhgj.xhgj03.company01.view"
                },
                {
                    "available": false,
                    "description": "西湖国际，西湖国际01，公司01",
                    "id": 4,
                    "permission": "xhgj.xhgj04.company01.view"
                },
                {
                    "available": false,
                    "description": "西湖国际，西湖国际01，公司01",
                    "id": 5,
                    "permission": "xhgj.xhgj05.company01.view"
                }
            ],
            "pageNo": 0,
            "pageSize": 5,
            "totalCount": 25,
            "totalPageCount": 5
        },
        "searchPermission": ""
    }
}
```

### 功能：增加一个权限
#### 接口：{host}/xhgj/ backend/permission/add
##### 输入参数：


键|值|描述|
|---|---|---|
|permission|“xhgj.xhgj02.company01.view”|权限名称|
|description|“西湖国际，西湖国际二号楼，公司1”|权限描述|

##### 输出参数：
如果permission为空
```java
{
    "code": 400
}
```
如果permission存在
```java
{
    "code": 500,
    "error": "该权限已经存在"
}
```
如果服务器出错
```java
{
    "code": 500
}
```
如果成功保存
```java
{
    "code": 200
}
```

### 功能：根据主键删除权限
#### 接口：{bathPath}/{园区名称(名称)}/ backend/permission/delete
##### 输入参数：



|键|值|描述|
|---|---|---|
|id|1|Id|

##### 输出：
删除成功
```java
{
    "code": 200
}
```
删除失败
```java
{
    "code": 500
}
```

### 功能：根据主键更新权限的状态
#### 接口：{bathPath}/{园区名称(名称)}/ backend/permission/change
##### 输入参数：



|键|值|描述|
|---|---|---|
|id|1|Id|

##### 输出：
删除成功
```java
{
    "code": 200
}
```
删除失败
```java
{
    "code": 500
}
```


### 功能：角色分页查找
#### 接口：{host}/xhgj/ backend/role/list
###### 输入参数：

|键|值|描述|
|---|---|---|
|searchRole|“xhgj”|查询字段（非必须）|
|pageNo|0|查询的页面页号（从0开始）|
|pageSize|5|查询的页面大小|

###### 输出：
如果服务器出错
```java
{
	"code":500
}
```
如果服务器正常
``` java
{
    "code": 200,
    "data": {
        "data": {
            "items": [
                {
                    "available": false,
                    "description": "西湖国际，西湖国际01，公司01",
                    "id": 6,
                    "role": "xhgj.xhgj01.company06"
                },
                {
                    "available": false,
                    "description": "西湖国际，西湖国际01，公司01",
                    "id": 7,
                    "role": "xhgj.xhgj01.company07"
                },
                {
                    "available": false,
                    "description": "西湖国际，西湖国际01，公司01",
                    "id": 8,
                    "role": "xhgj.xhgj01.company08"
                },
                {
                    "available": false,
                    "description": "西湖国际，西湖国际01，公司01",
                    "id": 9,
                    "role": "xhgj.xhgj01.company09"
                },
                {
                    "available": false,
                    "description": "西湖国际，西湖国际01，公司01",
                    "id": 10,
                    "role": "xhgj.xhgj02.company01"
                }
            ],
            "pageNo": 1,
            "pageSize": 5,
            "totalCount": 27,
            "totalPageCount": 6
        },
        "searchRole": ""
    }
}
```


### 功能：增加一个角色
#### 接口：{host}/xhgj/ backend/role/add
##### 输入参数：


键|值|描述|
|---|---|---|
|permission|“xhgj.xhgj02.company01”|角色名称|
|description|“西湖国际，西湖国际二号楼，公司1”|角色描述）|

##### 输出参数：
如果role为空
```java
{
    "code": 400
}
```
如果role存在
```java
{
    "code": 500,
    "error": "该角色已经存在"
}
```
如果服务器出错
```java
{
    "code": 500
}
```
如果成功保存
```java
{
    "code": 200
}
```


### 功能：根据主键更新权限的状态
#### 接口：{bathPath}/{园区名称(名称)}/ backend/role/change
##### 输入参数：



|键|值|描述|
|---|---|---|
|id|1|Id|

##### 输出：
删除成功
```java
{
    "code": 200
}
```
删除失败
```java
{
    "code": 500
}
```



### 功能：获取指定的roleId的权限信息
#### 接口：{bathPath}/{园区名称(名称)}/ backend/role/permissionsWithSelected
##### 输入参数：




|键|值|描述|
|---|---|---|
|roleid|1|role的id|

##### 输出：
服务器报错
```java
{
    "code": 500
}
```
服务器成功
```java
{
    "code": 200,
    "data": {
        "permissions": [
            {
                "description": "西湖国际，西湖国际01，公司01",
                "id": 1,
                "permission": "xhgj.xhgj01.company01.view",
                "selected": true
            },
            {
                "description": "西湖国际，西湖国际01，公司01",
                "id": 2,
                "permission": "xhgj.xhgj02.company01.view",
                "selected": false
            },
            {
                "description": "西湖国际，西湖国际01，公司01",
                "id": 3,
                "permission": "xhgj.xhgj03.company01.view",
                "selected": false
            },
            {
                "description": "西湖国际，西湖国际01，公司01",
                "id": 4,
                "permission": "xhgj.xhgj04.company01.view",
                "selected": false
            },
            {
                "description": "西湖国际，西湖国际01，公司01",
                "id": 5,
                "permission": "xhgj.xhgj05.company01.view",
                "selected": false
            },
            {
                "description": "西湖国际，西湖国际01，公司01",
                "id": 6,
                "permission": "xhgj.xhgj06.company01.view",
                "selected": false
            },
            {
                "description": "西湖国际，西湖国际01，公司01",
                "id": 7,
                "permission": "xhgj.xhgj07.company01.view",
                "selected": false
            },
            {
                "description": "西湖国际，西湖国际01，公司01",
                "id": 8,
                "permission": "xhgj.xhgj08.company01.view",
                "selected": false
            },
            {
                "description": "西湖国际，西湖国际01，公司01",
                "id": 9,
                "permission": "xhgj.xhgj09.company01.view",
                "selected": false
            },
            {
                "description": "西湖国际，西湖国际01，公司01",
                "id": 10,
                "permission": "xhgj.xhgj10.company01.view",
                "selected": false
            },
            {
                "description": "西湖国际，西湖国际01，公司01",
                "id": 11,
                "permission": "xhgj.xhgj11.company01.view",
                "selected": false
            },
            {
                "description": "西湖国际，西湖国际01，公司01",
                "id": 12,
                "permission": "xhgj.xhgj12.company01.view",
                "selected": false
            },
            {
                "description": "西湖国际，西湖国际01，公司01",
                "id": 13,
                "permission": "xhgj.xhgj13.company01.view",
                "selected": false
            }
        ]
    }
}
```


### 功能：跟新角色的权限信息
#### 接口：{bathPath}/{园区名称(名称)}/ backend/role/savePermissions
##### 输入参数：



|键|值|描述|
|---|---|---|
|roleid|1|roleId的值(单个值)|
|permissionid|1 2 3 4 5|后台是用数组接收的，前端直接很多个复选框，name都叫permissionid就可以了|

##### 输出：
删除成功
```java
{
    "code": 200
}
```
删除失败
```java
{
    "code": 500
}
```


### 功能：用户分页查找
#### 接口：{host}/xhgj/ backend/user/list
###### 输入参数：

|键|值|描述|
|---|---|---|
|searchUsername|“admin”|查询字段（非必须）|
|pageNo|0|查询的页面页号（从0开始）|
|pageSize|5|查询的页面大小(默认是10)|

###### 输出：
如果服务器出错
```java
{
	"code":500
}
```
如果服务器正常
``` java
{
    "code": 200,
    "data": {
        "data": {
            "items": [
                {
                    "areaId": 1,
                    "buildingId": 1,
                    "credentialsSalt": "admin8d78869f470951332959580424d4bf4f",
                    "id": 1,
                    "locked": false,
                    "password": "d3c59d25033dbf980d29554025c23a75",
                    "salt": "8d78869f470951332959580424d4bf4f",
                    "username": "admin"
                },
                {
                    "areaId": 1,
                    "buildingId": 1,
                    "credentialsSalt": "admin18d78869f470951332959580424d4bf4f",
                    "id": 2,
                    "locked": false,
                    "password": "d3c59d25033dbf980d29554025c23a75",
                    "salt": "8d78869f470951332959580424d4bf4f",
                    "username": "admin1"
                },
                {
                    "areaId": 1,
                    "buildingId": 1,
                    "credentialsSalt": "admin28d78869f470951332959580424d4bf4f",
                    "id": 3,
                    "locked": false,
                    "password": "d3c59d25033dbf980d29554025c23a75",
                    "salt": "8d78869f470951332959580424d4bf4f",
                    "username": "admin2"
                },
                {
                    "areaId": 1,
                    "buildingId": 1,
                    "credentialsSalt": "admin38d78869f470951332959580424d4bf4f",
                    "id": 4,
                    "locked": false,
                    "password": "d3c59d25033dbf980d29554025c23a75",
                    "salt": "8d78869f470951332959580424d4bf4f",
                    "username": "admin3"
                },
                {
                    "areaId": 1,
                    "buildingId": 1,
                    "credentialsSalt": "admin48d78869f470951332959580424d4bf4f",
                    "id": 5,
                    "locked": true,
                    "password": "d3c59d25033dbf980d29554025c23a75",
                    "salt": "8d78869f470951332959580424d4bf4f",
                    "username": "admin4"
                },
                {
                    "credentialsSalt": "admin58d78869f470951332959580424d4bf4f",
                    "id": 6,
                    "locked": false,
                    "password": "d3c59d25033dbf980d29554025c23a75",
                    "salt": "8d78869f470951332959580424d4bf4f",
                    "username": "admin5"
                },
                {
                    "areaId": 1,
                    "buildingId": 1,
                    "credentialsSalt": "test018d78869f470951332959580424d4bf4f",
                    "id": 7,
                    "locked": false,
                    "password": "d3c59d25033dbf980d29554025c23a75",
                    "salt": "8d78869f470951332959580424d4bf4f",
                    "username": "test01"
                },
                {
                    "areaId": 1,
                    "buildingId": 1,
                    "credentialsSalt": "test028d78869f470951332959580424d4bf4f",
                    "id": 8,
                    "locked": false,
                    "password": "d3c59d25033dbf980d29554025c23a75",
                    "salt": "8d78869f470951332959580424d4bf4f",
                    "username": "test02"
                },
                {
                    "credentialsSalt": "test002c0674683979081d9b47c96a29f19d514",
                    "id": 10,
                    "locked": true,
                    "password": "69f19ce12e6d01c41d08bd6aa861ac8a",
                    "salt": "c0674683979081d9b47c96a29f19d514",
                    "username": "test002"
                }
            ],
            "pageNo": 0,
            "pageSize": 10,
            "totalCount": 9,
            "totalPageCount": 1
        },
        "searchUsername": ""
    }
}
```



### 功能：新增一个用户（只有两个参数，账户和密码）
#### 接口：{host}/xhgj/ backend/user/add
###### 输入参数：


|键|值|描述|
|---|---|---|
|username|"zhangsan"|用户名，必须有（后台检查）|
|password|"zhangsan"|密码，必须有（后台检查）|

##### 输出参数：
username为空：
```java
{
    "code": 400,
    "error": "用户名为空"
}
```

username不为空，password为空：
```java
{
    "code": 400,
    "error": "密码为空"
}
```
username不为空，且password不为空，但是账号已经存在
```java
{
    "code": 400,
    "error": "该角色已经存在"
}
```
如果保存成功
```java
{
    "code": 200,
}
```
如果服务器出错
```java
{
    "code": 500,
}
```


### 功能：根据主键删除用户
#### 接口：{host}/xhgj/ backend/user/delete
###### 输入参数：


|键|值|描述|
|---|---|---|
|id|1|主键，必须有（后台检查）|

##### 输出参数：
如果id值没有
```java
{
    "code": 400
}
```
如果删除失败
```java
{
    "code": 500
}
```
如果删除成功
```java
{
    "code":200
}
```


### 功能：根据主键更改用于的锁定状态
#### 接口：{host}/xhgj/ backend/user/change
###### 输入参数：


|键|值|描述|
|---|---|---|
|id|1|主键，必须有（后台检查）|

##### 输出参数：
如果id值没有
```java
{
    "code": 400
}
```
如果更改失败
```java
{
    "code": 500
}
```
如果更改成功
```java
{
    "code":200
}

