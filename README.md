# EmptyListVisew
一个带有加载动画与数据为空时显示EmptyView的ListView，用FrameLayout与ListView实现。

##使用方法
```
@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);


elv = new EmptyListVisew(this);
lv = elv.getListView();
elv.setProgressView("正在加载中...");
setContentView(elv);
post();


}

int i = 0;

void post() {
new Handler().postDelayed(new Runnable() {

@Override
public void run() {

if (i == 2) {

lv.setAdapter(new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, new String[]{"hello", "world"}));


}

elv.setEmptyView(R.mipmap.ic_launcher, "加载失败,点击刷新", new View.OnClickListener() {

@Override
public void onClick(View arg0) {

elv.setProgressView("继续加载...");
i++;


post();

}
});

}
}, 2000);

}
```
##使用效果
![Example Image][1]
----------

[1]: https://raw.github.com/canyinghao2/EmptyListVisew/master/EmptyListVisew.gif

