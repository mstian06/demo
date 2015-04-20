# 说明（重要！！）
---

参考资料

-  [Android中自定义样式与View的构造函数中的第三个参数defStyle的意义](http://www.cnblogs.com/angeldevil/p/3479431.html#one)


> 根据log理解：
> 
> TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.Customize, defStyle, R.style.DefaultCustomizeStyle);
> 
对于上面方法的理解，结论：直接在XML中定义>style定义>由defStyleAttr和defStyleRes指定的默认值>直接在Theme中指定的值。


两个地方的理解：

## 1.构造函数

    // 代码中创建的时候一般调用此构造函数
	public CustomTextView(Context context) {
		// super(context);
        this(context, null);
    }

	// 在布局文件创建的时候调用此构造函数
    public CustomTextView(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.CustomizeStyle);
    }
    
	// 不直接被调用，由上面两个函数调用
    public CustomTextView(Context context, AttributeSet attrs, int defStyle) {
		// 在确定属性时，布局文件直接确定的属性 > 布局文件中style定义的属性 > 主题thream中定义的属性
        super(context, attrs, defStyle);
	}

## 2.运行中获取属性值

    public CustomTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.Customize, defStyle, 0
                /*R.style.DefaultCustomizeStyle*/);
        String one = a.getString(R.styleable.Customize_attr_one);
        String two = a.getString(R.styleable.Customize_attr_two);
        String three = a.getString(R.styleable.Customize_attr_three);
        String four = a.getString(R.styleable.Customize_attr_four);
        String five = a.getString(R.styleable.Customize_attr_five);
        Log.i(TAG, "one:" + one);
        Log.i(TAG, "two:" + two);
        Log.i(TAG, "three:" + three);
        Log.i(TAG, "four:" + four);
        Log.i(TAG, "five:" + five);
        a.recycle();
    }


解释:

```
TypedArray android.content.Context.obtainStyledAttributes(AttributeSet set, int[] attrs, int defStyleAttr, int defStyleRes)
```

	布局文件activity.xml
    <com.example.demo.customstyle.CustomTextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        **ad:attr_one="attr one in xml"**
        style="@style/ThroughStyle"
        android:text="@string/hello_world" />

	自定义属性文件attr.xml
    <declare-styleable name="Customize">
        <attr name="attr_one" format="string" />
        <attr name="attr_two" format="string" />
        <attr name="attr_three" format="string" />
        <attr name="attr_four" format="string" />
        <attr name="attr_five" format="string" />
    </declare-styleable>
    <attr name="CustomizeStyle" format="reference" />

	样式，在style.xml中定义
    <style name="ThroughStyle">
        <item name="attr_one">attr one from style</item>
        **<item name="attr_two">attr two from style</item>**
    </style>

	主题文件theme在style.xml中定义。（Application中使用了此主题）
    <style name="AppTheme" parent="AppBaseTheme">
        <!-- All customizations that are NOT specific to a particular API-level can go here. -->
        <item name="attr_one">attr one from theme</item>
        <item name="attr_two">attr two from theme</item>
        **<item name="attr_three">attr three from theme</item>**
		<item name="attr_four">attr four from theme</item>
        <item name="CustomizeStyle">@style/CustomizeStyleInTheme</item>
    </style>
    <style name="CustomizeStyleInTheme"> 主题中引用了此样式
        <item name="attr_one">attr one from theme reference</item>
        <item name="attr_two">attr two from theme reference</item>
        **<item name="attr_four">attr four from theme reference</item>**
    </style>

	函数obtainStyledAttributes调用，使用的defStyleRes默认参数
    <style name="DefaultCustomizeStyle">
        <item name="attr_one">attr one from defalut style res</item>
        <item name="attr_two">attr two from defalut style res</item>
        <item name="attr_three">attr three from defalut style res</item>
        <item name="attr_four">attr four from defalut style res</item>
        <item name="attr_five">attr five from defalut style res</item>
    </style>

	以此obtainStyledAttributes函数调用为例：
	TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.Customize, defStyle, /*0*/
		R.style.DefaultCustomizeStyle);

> set：属性值的集合，也就是从布局文件中获取的属性的集合；**这里就是第二个构造函数中的set参数。** </p>
> attrs：我们要获取的属性的资源ID的一个数组；**这里就是自定义属性的数组R.styleable.Customize。** </p>
> defStyleAttr：这个是当前Theme中的一个attribute，是指向style的一个引用，当在layout xml中和style中都没有为View指定属性时，会从Theme中这个attribute指向的Style中查找相应的属性值，这就是defStyle的意思，如果没有指定属性值，就用这个值，所以是默认值，但这个attribute要在Theme中指定，且是指向一个Style的引用，如果这个参数传入0表示不向Theme中搜索默认值；**也就是根据这个attribute在theme中查找对应的style，从中确定属性值。** </p>
>defStyleRes：这个也是指向一个Style的资源ID，但是仅在defStyleAttr为0或defStyleAttr不为0但Theme中没有为defStyleAttr属性赋值时起作用；**也就是当defStyleAttr查找theme无效时，defStyleRes才会有效。** </p> </p>
>
>**总的确定属性的优先级：** </p>
>优先级1-直接在XML中定义（从布局文件中直接指定 </p>
>优先级2-style定义（从布局文件中style指定） </p>
>优先级3-由defStyleAttr（见AppTheme中的CustomizeStyle条目）和defStyleRes指定的默认值（当defStyleAttr无效时defStyleRes才会有效）  </p>
>优先级4-直接在Theme中指定的值（见AppTheme中直接定义的属性） </p>


上面的调用log如下（可根据代码自行调整查看log以助理解）：

	04-20 21:26:08.782: I/Timeline(27200): Timeline: Activity_launch_request id:com.example.demo time:264669449
	04-20 21:26:08.842: I/CustomTextView(27200): one:attr one in xml
	04-20 21:26:08.842: I/CustomTextView(27200): two:attr two from style
	04-20 21:26:08.842: I/CustomTextView(27200): three:attr three from theme
	04-20 21:26:08.842: I/CustomTextView(27200): four:attr four from theme reference（注：由defStyleAttr在theme中找到的值优先级大于直接在theme中定义的）
	04-20 21:26:08.842: I/CustomTextView(27200): five:null（注：因为defStyleAttr有效，所以defStyleRes无效）
	04-20 21:26:08.912: I/Timeline(27200): Timeline: Activity_idle id: android.os.BinderProxy@430636e0 time:264669578
