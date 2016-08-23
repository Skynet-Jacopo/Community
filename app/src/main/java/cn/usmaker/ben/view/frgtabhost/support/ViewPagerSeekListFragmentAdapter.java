//
//package cn.usmaker.ben.view.frgtabhost.support;
//
//import android.support.v4.app.Fragment;
//import android.support.v4.app.FragmentManager;
//import android.support.v4.app.FragmentPagerAdapter;
//
//import java.util.List;
//
//
//
///**
// * Created by Administrator on 2016/6/7.
// */
//public class ViewPagerSeekListFragmentAdapter extends FragmentPagerAdapter {
//    private List<SeekListFragment> list_fragment;                         //fragment列表
//    private List<String>           list_Title;                              //tab名的列表
//
//    public ViewPagerSeekListFragmentAdapter(FragmentManager fm, List<SeekListFragment> list_fragment, List<String> list_Title) {
//        super(fm);
//        this.list_fragment = list_fragment;
//        this.list_Title = list_Title;
//    }
//
//    @Override
//    public Fragment getItem(int position) {
//        return list_fragment.get(position);
//    }
//
//    @Override
//    public int getCount() {
//        return list_Title.size();
//    }
//
//    //此方法用来显示tab上的名字
//    @Override
//    public CharSequence getPageTitle(int position) {
//        return list_Title.get(position % list_Title.size());
//    }
//
//    @Override
//    public int getItemPosition(Object object) {
//        if(object instanceof SeekListFragment){
//           ((SeekListFragment)object).reserach();
//        }
//        return super.getItemPosition(object);
//    }
//}
