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
permission|“西湖国际，西湖国际二号楼，公司1”|查询的页面页号（从0开始）|

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



