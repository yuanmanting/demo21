package cn.edu.gdmec.android.demo21.liereader.News.Model;

import cn.edu.gdmec.android.demo21.liereader.Bean.NewBean;

/**
 * Created by apple on 18/5/29.
 */

public interface IOnLoadListener {
    void success(NewBean newBean);
    void fail(String error);
}
