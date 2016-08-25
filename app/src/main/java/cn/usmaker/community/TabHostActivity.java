package cn.usmaker.community;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.zhy.autolayout.AutoLayoutActivity;

import butterknife.Bind;
import butterknife.BindColor;
import butterknife.ButterKnife;
import cn.usmaker.community.commons.ActivityUtils;
import cn.usmaker.community.fragment.FourthFragment;
import cn.usmaker.community.fragment.HomePageFragment;
import cn.usmaker.community.fragment.SecondFragment;
import cn.usmaker.community.fragment.ThirdFragment;


public class TabHostActivity extends AutoLayoutActivity {

    @Bind(R.id.fl_content)
    FrameLayout     mFlContent;
    @Bind(R.id.fth_tab_host)
    FragmentTabHost mFragmentTabHost;
    @BindColor(R.color.red)
    int             colorRed;
    @BindColor(R.color.darkgrey)
    int             colorDarkGrey;
    /**
     * 布局填充器
     */
    private LayoutInflater mInflater;

    /**
     * Fragment数组界面
     */
    private Class  mFragmentArray[] = {HomePageFragment.class, SecondFragment.class,
            ThirdFragment.class, FourthFragment.class};
    /**
     * 存放图片数组
     */
    private int    mImageArray[]    = {R.drawable.selector_business, R.drawable.selector_community,
            R.drawable.selector_shopping_cart, R.drawable.selector_mine};
    /**
     * 选项卡文字
     */
    private String mTextArray[]     = {"首页", "社区", "购物车", "我的"};

    private Context       context;
    private TextView      mTextView;
    private ActivityUtils mActivityUtils;

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_host);
        mActivityUtils = new ActivityUtils(this);
        context = getBaseContext();
        //透明状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        //透明导航栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);

    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();
        ButterKnife.bind(this);


        mInflater = LayoutInflater.from(this);
        // 找到TabHost
        mFragmentTabHost.setup(this, getSupportFragmentManager(), R.id.fl_content);
        // 得到fragment的个数
        final int count = mFragmentArray.length;

        for (int i = 0; i < count; i++) {
            // 给每个Tab按钮设置图标、文字和内容
            TabHost.TabSpec tabSpec = mFragmentTabHost.newTabSpec(mTextArray[i]).setIndicator
                    (getTabItemView(i));
            // 将Tab按钮添加进Tab选项卡中
            mFragmentTabHost.addTab(tabSpec, mFragmentArray[i], null);

            mFragmentTabHost.getTabWidget().setDividerDrawable(R.color.white);
        }
        mFragmentTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                mActivityUtils.showToast("换到了" + tabId);
            }
        });
    }

    /**
     * 给每个Tab按钮设置图标和文字
     */
    private View getTabItemView(int index) {
        View      view      = mInflater.inflate(R.layout.tab_item_view, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageview);
        imageView.setImageResource(mImageArray[index]);
        mTextView = (TextView) view.findViewById(R.id.textview);
        mTextView.setText(mTextArray[index]);
        mTextView.setTextSize(15);
        return view;
    }
}
