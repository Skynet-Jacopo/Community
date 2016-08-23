package cn.usmaker.ben.view.dialog;

/**
 * Created by chenzhenyang on 2016/6/14.
 */
public interface ILoadingDialog {

    void show();

    void show(boolean force);

    void dismiss();

    interface OnTimeOutListener {
        void onTimeOut(String text);
    }
}
