package cn.usmaker.ben.view.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.os.Message;
import android.view.Window;
import android.widget.ImageView;

import com.orhanobut.logger.Logger;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

import cn.usmaker.community.R;


public class LoadingDialogPopular implements ILoadingDialog {

    public final static int OUT_TIME = 10 * 1000; // 超时时间
    private AlertDialog       dlg;
    private Context           mContext;
    private OnTimeOutListener mTimeOutListener;
    private final static String text = "数据加载超时，网络出现异常";
    private Timer timer;
    private AtomicInteger count = new AtomicInteger(0);


    public Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    mTimeOutListener.onTimeOut(text);
                    count.set(0);
                    dismiss();
                    break;
            }
        }

        ;
    };

    public LoadingDialogPopular(Context context, OnTimeOutListener onTimeOutListener) {
        mContext = context;
        mTimeOutListener = onTimeOutListener;
    }

    public void show() {
        show(false);
    }

    public void show(boolean force) {
        if (force) {
            count.set(0);
        }
        count.getAndIncrement();
        if (count.get() == 1) {
            showLoadDialog();
        }
    }


    public void dismiss() {
        count.decrementAndGet();
        if (count.get() < 0) {
            count.set(0);
        }
        if (count.get() == 0 && dlg != null && dlg.isShowing()) {
            Logger.d("LoadingDialog-Dismiss", "Dismiss");
            dlg.dismiss();
            timer.cancel();
        }
    }

    public void showLoadDialog() {
        Logger.d("LoadingDialog-Show", "Show");
        dlg = new AlertDialog.Builder(mContext).create();
        dlg.setCancelable(false); // 点击dlg之外的区域dlg是否消失
        dlg.show();

        Window window = dlg.getWindow();
        window.setContentView(R.layout.layout_loadingdialog_popular);

        // 旋转动画
        ImageView load_iv = (ImageView) window.findViewById(R.id.load_iv);
        // 代码写动画
        final AnimationDrawable mAnimation = (AnimationDrawable) load_iv.getBackground();
        load_iv.post(new Runnable() {
            @Override
            public void run() {
                mAnimation.start();
            }
        });

        // 计时
        timer = new Timer();
        TimerTask task = new TimerTask() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                mHandler.sendEmptyMessage(0);
            }
        };
        timer.schedule(task, OUT_TIME);
    }
}
