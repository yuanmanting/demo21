package cn.edu.gdmec.android.demo21.liereader.News.View;

import cn.edu.gdmec.android.demo21.liereader.Bean.NewBean;

/**
 * Created by apple on 18/5/29.
 */

public interface INewsView {
    void showNews(NewBean newBean);
    void hideDialog();
    void showDialog();
    void showErrorMsg(String error);
}
