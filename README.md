# ComponentGradlePlugin
插件的作用：<br>
1.每个Module之间实现真正的解耦。<br>
最初Module之间的依赖是在*build.gradle*中*dependencies{}*进行配置，这样Module之间的类就可以相互调用，虽然在要求上是不允许的，但是没有在编译阶段解决这个问题，没有实现真正的解耦，留下了误操作的隐患。<br>
在开发阶段使用这个插件可以实现Module之间的真正解耦，在编译的时候Module之间是没有任何依赖的，在Run Module时期自动添加依赖，这样就可以保证在写代码时期Module之间没有依赖，所以就不能相互调用类。<br>
2.在开发阶段每个Module都可以在不经过任何配置的情况下独立运行。<br>
组件化的另一个意义就是在开发阶段可以单独运行每个Module，这样可以提高调试运行速度，不需要的Module没有编译，省去编译时间。<br>
但是网上很多文章都是需要更改配置，这样在开发阶段太复杂了，使用当前插件可以使每个Module在不更改配置的情况下直接运行。<br>

简书地址：<br>
[Android组件化架构实现（一）](http://www.jianshu.com/p/8f3c21e1ebcf) <br>
[Android组件化架构实现（二）](http://www.jianshu.com/p/87c7db1c4c06)
