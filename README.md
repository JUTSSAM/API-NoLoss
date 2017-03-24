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
* 添加新的文章(add) __GET__
@param:title,abstra,
* 根据文章id获取文章内容 __GET__
@prarm:utoken,id

_此接口返回内容:_
```json
{
  "id": 1,
  "title": "1",
  "abstra": "1",
  "content": "1",
  "token": "1"
}
```