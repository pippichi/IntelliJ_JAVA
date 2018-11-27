# IntelliJ_JAVA

GitHub操作代码:
1、cd进入目录
2、把当前目录变成git可以管理的仓库:git init
3、添加文件: git add readme.txt   git add .
4、提交修改: git commit -m "备注"
5、查看是否还有未提交: git status
6、查看最近日志: git log
7、版本回退操作: 回退一个: git reset -hard HEAD^   回退两个: git reset -hard HEAD^^    回退多个: git reset -hard HEAD~100
8、(第一次连接)远程仓库的提交: git remote add origin 复制的地址
    仓库关联: git push -u origin master
9、(第二次以后)远程仓库的提交: git push
