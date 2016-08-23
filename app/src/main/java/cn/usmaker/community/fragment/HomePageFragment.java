package cn.usmaker.community.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
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

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.usmaker.ben.RushBuyCountDownTimerView;
import cn.usmaker.ben.view.gridviewgallery.GridViewGallery;
import cn.usmaker.ben.view.imageindicator.AutoPlayManager;
import cn.usmaker.ben.view.imageindicator.NetworkImageIndicatorView;
import cn.usmaker.community.ItemGuessYouLikeAdapter;
import cn.usmaker.community.ItemHotSaleAdapter;
import cn.usmaker.community.R;
import cn.usmaker.community.commons.ActivityUtils;

public class HomePageFragment extends Fragment implements ItemHotSaleAdapter.OnRecyclerViewListener, ItemGuessYouLikeAdapter.OnRecyclerViewListener {
    @Bind(R.id.iv_scan)
    ImageView                 mIvScan;
    @Bind(R.id.etSearch)
    EditText                  mEtSearch;
    @Bind(R.id.iv_info)
    ImageView                 mIvInfo;
    @Bind(R.id.rlSearchFrameDelete)
    RelativeLayout            mRlSearchFrameDelete;
    @Bind(R.id.network_indicate_view)
    NetworkImageIndicatorView mNetworkIndicateView;
    @Bind(R.id.grid_gallery)
    GridViewGallery           mGridGallery;
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

    ActivityUtils mActivityUtils;
    private RushBuyCountDownTimerView timerView;

    private List<String> datas = new ArrayList<>();
    private ItemHotSaleAdapter      mAdapter;
    private ItemGuessYouLikeAdapter mItemGuessYouLikeAdapter;
    List<String> urls = new ArrayList<>();
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
        timerView = (RushBuyCountDownTimerView) view.findViewById(R.id.timerView);
        // 设置时间(hour,min,sec)
        timerView.setTime(10, 0, 10);
        // 开始倒计时
        timerView.start();
        initFirstRecyclerView();//第一个RecyclerView
        initSeconRecyclerView();//第二个RecyclerView

        urls.add("http://scimg.jb51.net/allimg/160716/105-160G61F250436.jpg");
        urls.add("http://scimg.jb51.net/allimg/160815/103-160Q509544OC.jpg");
        urls.add("http://love.doghouse.com.tw/image/wallpaper/011102/bf1554.jpg");
//        String[] urls ={
//                                "http://scimg.jb51.net/allimg/160716/105-160G61F250436.jpg",
//                "http://scimg.jb51.net/allimg/160815/103-160Q509544OC.jpg",
//                "http://love.doghouse.com.tw/image/wallpaper/011102/bf1554.jpg"
//        };
//                "http://scimg.jb51.net/allimg/160716/105-160G61F250436.jpg",
//                "http://scimg.jb51.net/allimg/160815/103-160Q509544OC.jpg",
//                "http://love.doghouse.com.tw/image/wallpaper/011102/bf1554.jpg"
        mNetworkIndicateView.setupLayoutByImageUrl(urls);
        mNetworkIndicateView.show();
        AutoPlayManager autoBrocastManager = new AutoPlayManager(mNetworkIndicateView);
        autoBrocastManager.setBroadcastEnable(true);
        autoBrocastManager.setBroadCastTimes(5);//loop times
        autoBrocastManager.setBroadcastTimeIntevel(2 * 1000,2 * 1000);//set first play time and interval
        autoBrocastManager.loop();

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
        //线性宫格显示 类似于瀑布流
//        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, OrientationHelper.VERTICAL));
        mRecyclerHotBuy.setItemAnimator(new DefaultItemAnimator());
        for (int i = 0; i < 6; i++) {
            datas.add("" + i);
        }
        mAdapter = new ItemHotSaleAdapter(datas);
        mRecyclerHotBuy.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
        mAdapter.setOnRecyclerViewListener(this);
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
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
//        for (int i = 0; i < 20; i++) {
//            datas.add("" + i);
//        }
        mItemGuessYouLikeAdapter = new ItemGuessYouLikeAdapter(datas);
        mRecyclerView.setAdapter(mItemGuessYouLikeAdapter);
        mItemGuessYouLikeAdapter.notifyDataSetChanged();
        mItemGuessYouLikeAdapter.setOnRecyclerViewListener(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onItemClick(int position, View rootView) {
        mActivityUtils.showToast("点击了" +rootView.getParent().getClass().getName()+"的"+
                position);
    }

    @Override
    public boolean onItemLongClick(int position) {
        return false;
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
