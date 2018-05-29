package cn.edu.gdmec.android.demo21.liereader.News.Presenter;

import cn.edu.gdmec.android.demo21.liereader.Bean.NewBean;
import cn.edu.gdmec.android.demo21.liereader.Http.Api;
import cn.edu.gdmec.android.demo21.liereader.News.Model.INewsModel;
import cn.edu.gdmec.android.demo21.liereader.News.Model.IOnLoadListener;
import cn.edu.gdmec.android.demo21.liereader.News.Model.NewsModel;
import cn.edu.gdmec.android.demo21.liereader.News.View.FgNewsFragment;
import cn.edu.gdmec.android.demo21.liereader.News.View.INewsView;

/**
 * Created by apple on 18/5/29.
 */

public class NewsPresenter implements INewsPresenter,IOnLoadListener{
    private INewsModel iNewsModel;
    private INewsView iNewsView;

    public NewsPresenter(INewsView iNewsView){
        this.iNewsView=iNewsView;
        this.iNewsModel=new NewsModel();
    }

    @Override
    public void loadNews(int type, int startPage) {
        iNewsView.hideDialog();
        switch (type){
            case FgNewsFragment.NEWS_TYPE_TOP:
                iNewsModel.loadNews("headline",startPage, Api.HEADLINE_ID,this);
                break;
            case FgNewsFragment.NEWS_TYPE_NBA:
                iNewsModel.loadNews("list",startPage,Api.NBA_ID,this);
                break;
                case FgNewsFragment.NEWS_TYPE_JOKES:
                    iNewsModel.loadNews("list",startPage,Api.JOKE_ID,this);
                    break;

        }

    }

    @Override
    public void success(NewBean newBean) {
        iNewsView.hideDialog();
        if (newBean !=null){
            iNewsView.showNews(newBean);
        }

    }

    @Override
    public void fail(String error) {
        iNewsView.hideDialog();
        iNewsView.showErrorMsg(error);
    }
}
