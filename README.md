# webFinalWork  
---
这是我们的团队日志，用于彼此间的版本控制  
请大家每次更改记得在这里按照以下格式记录！  
# 版本日志
日期|时间|名字|操作  
---|:--:|---:|:--:  
2020.01.16|22：01|郑明煊|创建此仓库  
2020.01.16|22：20|郑明煊|搭建环境，已集成【MySQL，Hibernate，SpringJPA，Elasticsearch】  
2020.01.18|23：45|郑明煊|创建Information、Label实体类  
2020.01.19|18：57|郑明煊|集成JSP，测试成功  
2020.01.21|12：36|郑明煊|InformationService初步测试成功（高级检索未实现）  
2020.01.26|00：42|孙静彤|创建Admin、Major类，AdminRepository，AdminService及实现，有一些被注释的方法
2020.01.26|15: 54|李歆然|创建User、UserFavor、Comment类，及相应的repository和service实现  
2020.01.26|20: 11|李歆然|补充并实现InformationService的两个关于用户收藏、用户推荐的功能  
2020.02.01|15：20|孙静彤|重新提交Admin的entity、repository、service  
2020.02.04|22：07|郑明煊|信息展示界面完全集成！【/info/job,/info/policy,/info/notice,/info/other及其内容】  
2020.02.06|23：39|郑明煊|InfoController完结撒花！  
2020.02.07|01：35|李歆然|UserSpaceController和MainController完成~  

2020.2.13 郑明煊、喻润一、苏秋萍、刘源、孙静彤、孙佳慧、李歆然：项目完结撒花~

  
（注意：本文件（MD文件）的换行符为在当行结束后加两个空格）  
### 版本控制步骤：  
1. 准备开发前先在群里报一下“XX开始开发，预计进行多久”  
2. 打开IntelliJ首先更新项目：VCS-》Git-》Pull。然后就可以开始你的工作  
3. 上传之前请保证自己上传的部分没有BUG！并在本文件第一部分记录自己的工作~  
4. 上传方法：  
    第一步（向Git提交变更）-VCS-》Commit；  
    第二步（将Git中的变更上传到GitHub）-VCS-》Git-》Push  
5. 每次完成上述四件事后请在群里说一声“XX干了啥，已经上传”  
6. 注意：第一次下载本项目请从IntelliJ内部用URL克隆（否则可能会有一堆麻烦），我们的整个开发过程基本只在IntelliJ内执行，不需要打开别的软件  
7. JSP文件放在webapp/WEB-INF中；JS或CSS文件放在static中；图片放在static/img中  
## 分工  
### （一）前端分工 
需要完成的JSP文件：  
1.登录界面  
2.平台首页  
3.就业信息板块  
4.通知公告板块  
5:政策信息板块  
6.普通用户header  
7.留言板  
8.个人主页-最新通知  
9.修改个人资料界面  
10.管理员首页  
11.师生信息统计界面  
12.消息信息统计界面  
13.人员管理界面  
14.消息管理界面  
15.实习信息上传界面  
16.政策规章上传界面  
17.通知公告上传界面  
18.其他信息上传界面  
19.footer  
20.管理员导航栏  
21.高级检索  
22.检索结果  
23.个人主页-我的收藏  
24.个人主页-我发布的留言  
25.留言管理  
  
A:15,16,17,18,6,21,22（秋萍）  
B:1,2,3,4,5,24（佳慧）  
C:11,12,7,8,19,23（润一）  
D:13,14,9,10,20,25（刘源）  
  
  ### （二）后端分工  
歆然：  
MainController：PPT1-3  
UserSpaceController：PPT17-21  
明煊：  
InformationController：PPT4-16  
静彤：  
AdminController：PPT22-31  
  

