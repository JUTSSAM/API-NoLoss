# API-NoLoss
所用到的相关知识
SpringBoot 
Mybatis
Maven
## 开发文档
### 首先声明
数据返回格式均为JSON格式
```json
{
  "code":"(int)",
  "msg":"(string)"
}
```
### 用户操作(/user)
* 登陆接口(/login) __GET__
@param:user,pass
* 修改密码接口(/resetPass) __PUT__
@param:user,pass,newpass

### 文章操作(/article)
* 获取文章列表(/list) __GET__
@param:utoken
* 获取回收站文章列表(/recycle) __GET__
@param:utoken
* 添加新的文章(/add) __GET__
@param:title,abstra,
* 根据文章id获取文章内容(/get) __GET__
@prarm:utoken,id
* 根据文章token获取文章内容(/Get) __GET__
@param:utoken,token
* 删除文章(/del) __DELETE__
@param:token
* 恢复文章(/recover) __GET__
@param:token
* 彻底删除文章(/redel) __DELETE__
@param:token