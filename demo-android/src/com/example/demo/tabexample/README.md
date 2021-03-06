# TabExample
---
- com.example.demo.tabexample.activitygroup： ActivityGroup，将pager的Activiy DecorView`win.getDecorView`作为子view添加到主Activity中。
- com.example.demo.tabexample.tabhost： ActivityGroup配合TabHost使用，TabHost，TabWidget。
- com.example.demo.tabexample.fragment： Framelayout中添加fragment，配合FragmentManager使用。
- com.example.demo.tabexample.fragment2： 与上面的区别是继承了FragmentActivity。
- com.example.demo.tabexample.viewpager： 使用ViewPager配合PagerAdapter来使用，Adapter里面的iten是view。
- com.example.demo.tabexample.viewpagerfragment： 使用ViewPager配合FragmentPagerAdapter来使用，Adapter里面的item是Fragment。
- com.example.demo.tabexample.ViewPagerIndicator：使用ViewPagerIndicator实现tab样式，构建的时候要引用ViewPagerIndicator开源库，support-v4.jar包的版本要保持一致。

##参考
* [Android Fragment应用实战，使用碎片向ActivityGroup说再见](http://blog.csdn.net/guolin_blog/article/details/13171191)</p>

> 这里注意一个细节，我们添加Fragment的时候并没有使用replace()方法，而是会先判断一下该Fragment是否为空，如果是空的则调用add()方法添加一个进来，如果不是空的则直接调用show()方法显示出来即可。那么为什么没有使用replace()方法呢？这是因为replace()方法会将被替换掉的那个Fragment彻底地移除掉，该Fragment的生命周期就结束了。当再次点击刚才那个Tab项的时候，就会让该Fragment的生命周期重新开始，onCreate()、onCreateView()等方法都会重新执行一遍。这显然不是我们想要的，也和ActivityGroup的工作原理不符，因此最好的解决方案就是使用hide()和show()方法来隐藏和显示Fragment，这就不会让Fragment的生命周期重走一遍了。

