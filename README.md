# API-NoLoss
## 开发文档
### 几个声明
数据返回格式均为JSON格式
```json
{
code:(int),
msg:(string)
}
```
### 用户操作(/user)
* 登陆接口(login) GET
@param:user,pass
* 修改密码接口(resetPass) PUT
@param:user,pass,newpass

