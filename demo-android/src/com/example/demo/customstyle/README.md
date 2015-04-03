# 说明
---


参考资料

-  [Android中自定义样式与View的构造函数中的第三个参数defStyle的意义](http://www.cnblogs.com/angeldevil/p/3479431.html#one)


> 根据log理解：
> 
> TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.Customize, defStyle, R.style.DefaultCustomizeStyle);
> 
对于上面方法的理解，结论：直接在XML中定义>style定义>由defStyleAttr和defStyleRes指定的默认值>直接在Theme中指定的值。

