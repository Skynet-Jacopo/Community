package cn.usmaker.community;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by liuqun on 8/22/2016.
 */
public class ItemGuessYouLikeAdapter extends RecyclerView.Adapter<ItemGuessYouLikeAdapter.ViewHolder> {

    private List<String> datas = null;

    public ItemGuessYouLikeAdapter(List<String> datas) {
        this.datas = datas;
    }

    public static interface OnRecyclerViewListener {
        void onItemClick(int position, View rootView);
        boolean onItemLongClick(int position);
    }

    private OnRecyclerViewListener onRecyclerViewListener;

    public void setOnRecyclerViewListener(OnRecyclerViewListener onRecyclerViewListener) {
        this.onRecyclerViewListener = onRecyclerViewListener;
    }

    //创建新View，被LayoutManager所调用
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_guess_you_like, viewGroup,
                false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    //将数据与界面进行绑定的操作

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.tvNewPrice.setText("¥"+datas.get(position));
    }

    //获取数据的数量
    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        //自定义的ViewHolder，持有每个Item的的所有界面元素
        public View mRootView;

        private    ImageView ivHotSale;
        private    TextView  tvDes;
        private    TextView  tvNewPrice;

        public ViewHolder(View view) {
            super(view);
            ivHotSale = (ImageView) view.findViewById(R.id.iv_hot_sale);
            tvDes = (TextView) view.findViewById(R.id.tv_des);
            tvNewPrice = (TextView) view.findViewById(R.id.tv_new_price);
            mRootView = view.findViewById(R.id.card_view);
            mRootView.setOnClickListener(this);
            mRootView.setOnLongClickListener(this);
        }
        @Override
        public void onClick(View v) {
            if (null != onRecyclerViewListener) {
                onRecyclerViewListener.onItemClick(this.getAdapterPosition(),mRootView);
            }
        }

        @Override
        public boolean onLongClick(View v) {
            if (null != onRecyclerViewListener) {
                return onRecyclerViewListener.onItemLongClick(this.getAdapterPosition());
            }
            return false;
        }
    }
}
