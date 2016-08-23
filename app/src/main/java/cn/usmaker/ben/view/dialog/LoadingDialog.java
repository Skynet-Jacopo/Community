package cn.usmaker.ben.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.github.ybq.android.spinkit.SpinKitView;
import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.ChasingDots;
import com.github.ybq.android.spinkit.style.Circle;
import com.github.ybq.android.spinkit.style.CubeGrid;
import com.github.ybq.android.spinkit.style.DoubleBounce;
import com.github.ybq.android.spinkit.style.FadingCircle;
import com.github.ybq.android.spinkit.style.FoldingCube;
import com.github.ybq.android.spinkit.style.Pulse;
import com.github.ybq.android.spinkit.style.RotatingPlane;
import com.github.ybq.android.spinkit.style.ThreeBounce;
import com.github.ybq.android.spinkit.style.WanderingCubes;
import com.github.ybq.android.spinkit.style.Wave;

import cn.usmaker.community.R;


/**
 * 加载Dialog
 * Created by chenzhenyang on 2016/6/4.
 */
public class LoadingDialog extends Dialog {

    public LoadingDialog(Context context) {
        super(context, R.style.LoadingDialogStyle);
    }

    public static class Builder {
        public Builder(Context context) {
            this.context = context;
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            contentView = inflater.inflate(R.layout.dialog_common_loading, null);
            spinKitView = (SpinKitView) contentView.findViewById(R.id.spin_kit);
            container = (RelativeLayout) contentView.findViewById(R.id.container);
        }

        private SpinKitView spinKitView;
        private Context     context;

        private OnClickListener submitOnClickListener;
        private View            contentView;
        private RelativeLayout  container;

        private int position;

        public int getPosition() {
            return position;
        }

        public Builder setPosition(int position) {
            this.position = position;
            return this;
        }

        public Context getContext() {
            return context;
        }

        public Builder setContext(Context context) {
            this.context = context;
            return this;
        }

        public Builder setBackgroundResource(int resid) {
            container.setBackgroundResource(resid);
            return this;
        }

        public Builder setBackgroundColor(int color) {
            container.setBackgroundColor(color);
            return this;
        }

        public Builder setBackgroundColor(Drawable background) {
            container.setBackground(background);
            return this;
        }

        public Builder setTitanOnClickListener(OnClickListener submitOnClickListener) {
            this.submitOnClickListener = submitOnClickListener;
            return this;
        }

        public LoadingDialog create() {

            final LoadingDialog dialog = new LoadingDialog(context);


            Sprite drawable = null;
            switch (position) {
                case 0:
                    drawable = new RotatingPlane();
                    break;
                case 1:
                    drawable = new DoubleBounce();
                    break;
                case 2:
                    drawable = new Wave();
                    break;
                case 3:
                    drawable = new WanderingCubes();
                    break;
                case 4:
                    drawable = new Pulse();
                    break;
                case 5:
                    drawable = new ChasingDots();
                    drawable.setColor(ContextCompat.getColor(getContext(), R.color.colorAccent));
                    break;
                case 6:
                    drawable = new ThreeBounce();
                    break;
                case 7:
                    drawable = new Circle();
                    break;
                case 8:
                    drawable = new CubeGrid();
                    break;
                case 9:
                    drawable = new FadingCircle();
                    break;
                case 10:
                    drawable = new FoldingCube();
                    break;
                default:
                    drawable = new RotatingPlane();
                    break;
            }

            spinKitView.setIndeterminateDrawable(drawable);

            if (contentView != null) {
                dialog.setContentView(contentView);
            }
            return dialog;
        }
    }
}
