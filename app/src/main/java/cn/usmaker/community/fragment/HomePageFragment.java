package cn.usmaker.community.fragment;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jauker.widget.BadgeView;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.usmaker.ben.RushBuyCountDownTimerView;
import cn.usmaker.ben.util.ToastUtils;
import cn.usmaker.ben.view.baseadapter.ViewHolder;
import cn.usmaker.ben.view.baseadapter.recyclerview.CommonAdapter;
import cn.usmaker.ben.view.baseadapter.recyclerview.OnItemClickListener;
import cn.usmaker.ben.view.lunbotu.ADBean;
import cn.usmaker.ben.view.lunbotu.TuTu;
import cn.usmaker.community.useless.ItemGuessYouLikeAdapter;
import cn.usmaker.community.useless.ItemHotSaleAdapter;
import cn.usmaker.community.R;
import cn.usmaker.community.commons.ActivityUtils;

public class HomePageFragment extends Fragment {
    @Bind(R.id.iv_scan)
    LinearLayout   mIvScan;
    @Bind(R.id.etSearch)
    EditText       mEtSearch;
    @Bind(R.id.ll_info)
    LinearLayout   mIvInfo;
    @Bind(R.id.iv_info)
    ImageView mIvInformation;
    @Bind(R.id.rlSearchFrameDelete)
    RelativeLayout mRlSearchFrameDelete;
    @Bind(R.id.ad_viewPage)
    ViewPager      ad_viewPage;
    @Bind(R.id.tv_msg)
    TextView       tv_msg;
    /**
     * 添加小圆点的线性布局
     */
    @Bind(R.id.ll_dian)
    LinearLayout   ll_dian;

//    @Bind(R.id.grid_gallery)
//    GridViewGallery           mGridGallery;
    @Bind(R.id.timerView)
    RushBuyCountDownTimerView mTimerView;
    @Bind(R.id.time_count_down)
    LinearLayout              mTimeCountDown;
    @Bind(R.id.recycler_hot_buy)
    RecyclerView              mRecyclerHotBuy;
    @Bind(R.id.recycler_view)
    RecyclerView              mRecyclerView;
    @Bind(R.id.tv_title1)
    TextView                  mTvTitle1;
    @Bind(R.id.tv_des1)
    TextView                  mTvDes1;
    @Bind(R.id.iv_pic1)
    ImageView                 mIvPic1;
    @Bind(R.id.tv_title2)
    TextView                  mTvTitle2;
    @Bind(R.id.tv_des2)
    TextView                  mTvDes2;
    @Bind(R.id.iv_pic2)
    ImageView                 mIvPic2;
    @Bind(R.id.tv_title3)
    TextView                  mTvTitle3;
    @Bind(R.id.tv_des3)
    TextView                  mTvDes3;
    @Bind(R.id.iv_pic3)
    ImageView                 mIvPic3;
    @Bind(R.id.tv_affordable_title1)
    TextView                  mTvAffordableTitle1;
    @Bind(R.id.tv_affordable_des1)
    TextView                  mTvAffordableDes1;
    @Bind(R.id.iv_affordable_pic1)
    ImageView                 mIvAffordablePic1;
    @Bind(R.id.tv_affordable_title2)
    TextView                  mTvAffordableTitle2;
    @Bind(R.id.tv_affordable_des2)
    TextView                  mTvAffordableDes2;
    @Bind(R.id.iv_affordable_pic2)
    ImageView                 mIvAffordablePic2;
    @Bind(R.id.tv_affordable_title3)
    TextView                  mTvAffordableTitle3;
    @Bind(R.id.tv_affordable_des3)
    TextView                  mTvAffordableDes3;
    @Bind(R.id.iv_affordable_pic3)
    ImageView                 mIvAffordablePic3;
    @Bind(R.id.tv_affordable_title4)
    TextView                  mTvAffordableTitle4;
    @Bind(R.id.tv_affordable_des4)
    TextView                  mTvAffordableDes4;
    @Bind(R.id.iv_affordable_pic4)
    ImageView                 mIvAffordablePic4;
    @Bind(R.id.tv_offer1_title1)
    TextView                  mTvOffer1Title1;
    @Bind(R.id.tv_offer1_des1)
    TextView                  mTvOffer1Des1;
    @Bind(R.id.iv_offer1_pic1)
    ImageView                 mIvOffer1Pic1;
    @Bind(R.id.tv_offer1_title2)
    TextView                  mTvOffer1Title2;
    @Bind(R.id.iv_offer1_pic2)
    ImageView                 mIvOffer1Pic2;
    @Bind(R.id.tv_offer1_title4)
    TextView                  mTvOffer1Title4;
    @Bind(R.id.iv_offer1_pic4)
    ImageView                 mIvOffer1Pic4;
    @Bind(R.id.tv_offer1_title3)
    TextView                  mTvOffer1Title3;
    @Bind(R.id.iv_offer1_pic3)
    ImageView                 mIvOffer1Pic3;
    @Bind(R.id.tv_offer1_title5)
    TextView                  mTvOffer1Title5;
    @Bind(R.id.iv_offer1_pic5)
    ImageView                 mIvOffer1Pic5;
    @Bind(R.id.tv_offer2_title1)
    TextView                  mTvOffer2Title1;
    @Bind(R.id.tv_offer2_des1)
    TextView                  mTvOffer2Des1;
    @Bind(R.id.iv_offer2_pic1)
    ImageView                 mIvOffer2Pic1;
    @Bind(R.id.tv_offer2_title2)
    TextView                  mTvOffer2Title2;
    @Bind(R.id.tv_offer2_des2)
    TextView                  mTvOffer2Des2;
    @Bind(R.id.iv_offer2_pic2)
    ImageView                 mIvOffer2Pic2;
    @Bind(R.id.tv_offer2_title3)
    TextView                  mTvOffer2Title3;
    @Bind(R.id.tv_offer2_des3)
    TextView                  mTvOffer2Des3;
    @Bind(R.id.iv_offer2_pic3)
    ImageView                 mIvOffer2Pic3;
    @Bind(R.id.recycler_kinds)
    RecyclerView              mRecyclerKinds;
    /**
     * 轮播图对象列表
     */
    List<ADBean> listADbeans;
    /**
     * 显示文字
     */
    private String[] des  = {"1111111", "22222222", "3333333", "4444444444", "55555555555", "66",
            "77"};
    /**
     * 网络资源
     */
    private String[] urls = {
            "http://scimg.jb51.net/allimg/160815/103-160Q509544OC.jpg",
            "http://img4.imgtn.bdimg.com/it/u=98923187,3761999633&fm=11&gp=0.jpg",
            "http://a.hiphotos.baidu.com/image/pic/item/0bd162d9f2d3572ce98282e18e13632762d0c3af.jpg",
            "http://d.hiphotos.baidu.com/image/pic/item/1b4c510fd9f9d72aebede7a1d62a2834359bbb85.jpg",
            "http://h.hiphotos.baidu.com/image/pic/item/91ef76c6a7efce1be2f4f15cad51f3deb58f654c.jpg",
            "http://h.hiphotos.baidu.com/image/w%3D230/sign=3e9ec55457fbb2fb342b5f117f4b2043/e850352ac65c1038343303cbb0119313b07e896e.jpg",
            "http://e.hiphotos.baidu.com/image/pic/item/d53f8794a4c27d1e3625e52d18d5ad6edcc438dc.jpg"};

    private TuTu tu;

    ActivityUtils mActivityUtils;
    private List<String> datas = new ArrayList<>();
    private ItemHotSaleAdapter      mAdapter;
    private ItemGuessYouLikeAdapter mItemGuessYouLikeAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_page, null);
        ButterKnife.bind(this, view);
        mActivityUtils = new ActivityUtils(this);
        return view;

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //假数据
        for (int i = 0; i < 6; i++) {
            datas.add("" + i);
        }
        // 设置时间(hour,min,sec)
        mTimerView.setTime(100*24-1, 0, 10);
        // 开始倒计时
        mTimerView.start();
        initFirstRecyclerView();//第一个RecyclerView
        initSeconRecyclerView();//第二个RecyclerView
        initThirdRecyclerView();
        initAD();//轮播图
        initInfoNumber();//消息图标上显示的数字
    }

    private void initInfoNumber() {
        BadgeView badgeView =new BadgeView(getContext());
        badgeView.setTargetView(mIvInformation);
        badgeView.setBadgeCount(2);
        badgeView.setBackground(100, Color.WHITE);
        badgeView.setTextColor(Color.RED);
        badgeView.setTextSize(8);
    }

    /**
     * 初始化轮播图
     */
    private void initAD() {
        listADbeans = new ArrayList<ADBean>();
        for (int i = 0; i < urls.length; i++) {
            ADBean bean = new ADBean();
            bean.setAdName(des[i]);
            bean.setId(i + "");
            bean.setImgUrl(urls[i]);
            //bean.setImgPath(ids[i]);
            listADbeans.add(bean);
        }
        tu = new TuTu(ad_viewPage, tv_msg, ll_dian, getContext(), listADbeans);
        tu.startViewPager(4000);//动态设置滑动间隔，并且开启轮播图
    }

    private void initFirstRecyclerView() {
        //抢购RecyclerVIew
        if (mRecyclerHotBuy != null) {
            //在回收时可以提高性能
            mRecyclerHotBuy.setHasFixedSize(true);
        }
//        mRecyclerView.setLayoutManager(new GridLayoutManager(this,3));
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerHotBuy.setLayoutManager(manager);

        CommonAdapter commonAdapter = new CommonAdapter<String>(getContext(),R.layout
                .item_hot_sale,datas) {

            @Override
            public void onBindViewHolder(ViewHolder holder, int position) {
                super.onBindViewHolder(holder, position);

            }

            @Override
            public void convert(ViewHolder holder, String s) {
                TextView tvOldPrice = (TextView) holder.getConvertView().findViewById(R.id.tv_old_price);
                tvOldPrice.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG);//中划线
                holder.setText(R.id.tv_new_price,"¥"+s);
                holder.setImageResource(R.id.iv_hot_sale,R.drawable.tuijian);
                //适配屏幕
                AutoUtils.autoSize(holder.getConvertView());
            }
        };
        mRecyclerHotBuy.setAdapter(commonAdapter);
        commonAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(ViewGroup parent, View view, Object o, int position) {
                mActivityUtils.showToast("限时抢购"+position);
            }

            @Override
            public boolean onItemLongClick(ViewGroup parent, View view, Object o, int position) {
                return false;
            }
        });

    }

    private void initSeconRecyclerView() {
        /**
         * 第二个RecyclerView
         */
        if (mRecyclerView != null) {
            //在回收时可以提高性能
            mRecyclerView.setHasFixedSize(true);
        }
//        mRecyclerView.setLayoutManager(new GridLayoutManager(this,3));
        LinearLayoutManager manager1 = new GridLayoutManager(getContext(), 2);
        manager1.setOrientation(GridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(manager1);
//        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
//        mItemGuessYouLikeAdapter = new ItemGuessYouLikeAdapter(datas);
//        mRecyclerView.setAdapter(mItemGuessYouLikeAdapter);
//        mItemGuessYouLikeAdapter.notifyDataSetChanged();
//        mItemGuessYouLikeAdapter.setOnRecyclerViewListener(this);
        CommonAdapter adapter =new CommonAdapter<String>(getContext(),R.layout
                .item_guess_you_like,datas) {

            @Override
            public void convert(ViewHolder holder, String s) {
                holder.setText(R.id.tv_new_price,s);
                holder.setImageResource(R.id.iv_hot_sale,R.drawable.tuijian);
                AutoUtils.auto(holder.getConvertView());
            }
        };
        mRecyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(ViewGroup parent, View view, Object o, int position) {
//                mActivityUtils.showToast("猜你喜欢"+position);
                ToastUtils.showToast(getContext(),R.drawable.shoujishuma,"猜你喜欢"+position);
            }

            @Override
            public boolean onItemLongClick(ViewGroup parent, View view, Object o, int position) {
                return false;
            }
        });
    }

    private void initThirdRecyclerView() {
        if (mRecyclerKinds != null) {
            //在回收时可以提高性能
            mRecyclerKinds.setHasFixedSize(true);
        }
//        mRecyclerView.setLayoutManager(new GridLayoutManager(this,3));
        GridLayoutManager manager = new GridLayoutManager(getContext(), 2);
        manager.setOrientation(GridLayoutManager.HORIZONTAL);
        mRecyclerKinds.setLayoutManager(manager);
        List<String> datas = new ArrayList<>();
        datas.clear();
        datas.add("手机数码");
        datas.add("新品上市");
        datas.add("靓号选择");
        datas.add("促销活动");
        datas.add("数码配件");
        datas.add("民营自贸");
        datas.add("售后维修");
        datas.add("搭配销售");
        datas.add("应用商店");
        datas.add("全部分类");
        final int[] pics = {
                R.drawable.xinpinshangshi, R.drawable.shouhouweixiu, R.drawable.lianghaoxuanze, R
                .drawable.cuxiao, R.drawable.shumapeijian, R.drawable.minyingziying, R.drawable
                .shouhouweixiu, R.drawable.dapeixiaoshou, R.drawable.yingyongshangdian, R.drawable.fenlei
        };
        final CommonAdapter adapter = new CommonAdapter<String>(getContext(), R.layout.item_kinds,
                datas) {
            @Override
            public void convert(ViewHolder holder, String s) {
                holder.setText(R.id.tv_title,s);
                    holder.setImageResource(R.id.iv_pic,pics[holder.getItemPosition()]);
            }
        };
        mRecyclerKinds.setAdapter(adapter);
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(ViewGroup parent, View view, Object o, int position) {
                mActivityUtils.showToast("点击了" + position + "个");
            }

            @Override
            public boolean onItemLongClick(ViewGroup parent, View view, Object o, int position) {
                return false;
            }
        });
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
        /**
         * 销毁轮播图
         */
        if (tu != null) {
            tu.destroyView();
        }
        super.onDestroy();
    }

    @OnClick({R.id.iv_scan, R.id.etSearch, R.id.iv_info, R.id.time_count_down, R.id.tv_title1, R
            .id.tv_des1, R.id.iv_pic1, R.id.tv_title2, R.id.tv_des2, R.id.iv_pic2, R.id.tv_title3, R.id.tv_des3, R.id.iv_pic3, R.id.tv_affordable_title1, R.id.tv_affordable_des1, R.id.iv_affordable_pic1, R.id.tv_affordable_title2, R.id.tv_affordable_des2, R.id.iv_affordable_pic2, R.id.tv_affordable_title3, R.id.tv_affordable_des3, R.id.iv_affordable_pic3, R.id.tv_affordable_title4, R.id.tv_affordable_des4, R.id.iv_affordable_pic4, R.id.tv_offer1_title1, R.id.tv_offer1_des1, R.id.iv_offer1_pic1, R.id.tv_offer1_title2, R.id.iv_offer1_pic2, R.id.tv_offer1_title4, R.id.iv_offer1_pic4, R.id.tv_offer1_title3, R.id.iv_offer1_pic3, R.id.tv_offer1_title5, R.id.iv_offer1_pic5, R.id.tv_offer2_title1, R.id.tv_offer2_des1, R.id.iv_offer2_pic1, R.id.tv_offer2_title2, R.id.tv_offer2_des2, R.id.iv_offer2_pic2, R.id.tv_offer2_title3, R.id.tv_offer2_des3, R.id.iv_offer2_pic3})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_scan:
                mActivityUtils.showToast("扫一扫");
                break;
            case R.id.etSearch:
                mActivityUtils.showToast("搜索");
                break;
            case R.id.iv_info:
                mActivityUtils.showToast("消息");
                break;
            case R.id.time_count_down:
                mActivityUtils.showToast("倒计时");
                break;
            case R.id.tv_title1:
            case R.id.tv_des1:
            case R.id.iv_pic1:
                mActivityUtils.showToast("第一个活动");
                break;
            case R.id.tv_title2:
            case R.id.tv_des2:
            case R.id.iv_pic2:
                mActivityUtils.showToast("第二个活动");
                break;
            case R.id.tv_title3:
            case R.id.tv_des3:
            case R.id.iv_pic3:
                mActivityUtils.showToast("第三个活动");
                break;
            case R.id.tv_affordable_title1:
            case R.id.tv_affordable_des1:
            case R.id.iv_affordable_pic1:
                mActivityUtils.showToast("特优惠第一个活动");
                break;
            case R.id.tv_affordable_title2:
            case R.id.tv_affordable_des2:
            case R.id.iv_affordable_pic2:
                mActivityUtils.showToast("特优惠第二个活动");
                break;
            case R.id.tv_affordable_title3:
            case R.id.tv_affordable_des3:
            case R.id.iv_affordable_pic3:
                mActivityUtils.showToast("特优惠第三个活动");
                break;
            case R.id.tv_affordable_title4:
            case R.id.tv_affordable_des4:
            case R.id.iv_affordable_pic4:
                mActivityUtils.showToast("特优惠第四个活动");
                break;
            case R.id.tv_offer1_title1:
            case R.id.tv_offer1_des1:
            case R.id.iv_offer1_pic1:
                mActivityUtils.showToast("活动1第一个活动");
                break;
            case R.id.tv_offer1_title2:
            case R.id.iv_offer1_pic2:
                mActivityUtils.showToast("活动1第二个活动");
                break;
            case R.id.tv_offer1_title3:
            case R.id.iv_offer1_pic3:
                mActivityUtils.showToast("活动1第三个活动");
                break;
            case R.id.tv_offer1_title4:
            case R.id.iv_offer1_pic4:
                mActivityUtils.showToast("活动1第四个活动");
                break;
            case R.id.tv_offer1_title5:
            case R.id.iv_offer1_pic5:
                mActivityUtils.showToast("活动1第五个活动");
                break;
            case R.id.tv_offer2_title1:
            case R.id.tv_offer2_des1:
            case R.id.iv_offer2_pic1:
                mActivityUtils.showToast("活动2第一个活动");
                break;
            case R.id.tv_offer2_title2:
            case R.id.tv_offer2_des2:
            case R.id.iv_offer2_pic2:
                mActivityUtils.showToast("活动2第二个活动");
                break;
            case R.id.tv_offer2_title3:
            case R.id.tv_offer2_des3:
            case R.id.iv_offer2_pic3:
                mActivityUtils.showToast("活动2第三个活动");
                break;
        }
    }
}
