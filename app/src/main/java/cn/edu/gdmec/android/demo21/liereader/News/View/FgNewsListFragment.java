package cn.edu.gdmec.android.demo21.liereader.News.View;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.TimerTask;

import cn.edu.gdmec.android.demo21.R;
import cn.edu.gdmec.android.demo21.liereader.Bean.NewBean;
import cn.edu.gdmec.android.demo21.liereader.News.Presenter.NewsPresenter;

/**
 * Created by apple on 18/5/29.
 */

public class FgNewsListFragment extends Fragment implements INewsView {
    private NewsPresenter presenter;
    private SwipeRefreshLayout srl_news;
    private int type;
    private TextView tv_news;
    public static FgNewsListFragment newInstance(int type){
        Bundle args=new Bundle();
        FgNewsListFragment fragment=new FgNewsListFragment();
        args.putInt("type",type);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fg_new_list,null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        type = getArguments().getInt("type");
        tv_news = view.findViewById(R.id.tv_news);
        srl_news = view.findViewById(R.id.srl_news);
        srl_news.setColorSchemeColors(Color.parseColor("#ffce3d3a"));
        presenter = new NewsPresenter(this);
        srl_news.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.loadNews(type, 0);
            }
        });
    }



    @Override
    public void showNews( final NewBean newBean) {
        getActivity().runOnUiThread(new TimerTask() {
            @Override
            public void run() {
                switch (type){
                    case FgNewsFragment.NEWS_TYPE_TOP:
                        tv_news.setText(newBean.getTop().get(0).getTitle()+" "
                        +newBean.getTop().get(0).getMtime());
                        break;
                    case FgNewsFragment.NEWS_TYPE_NBA:
                        tv_news.setText(newBean.getNba().get(0).getTitle()+" "
                                +newBean.getNba().get(0).getMtime());
                        break;
                    case FgNewsFragment.NEWS_TYPE_JOKES:
                        tv_news.setText(newBean.getJoke().get(0).getTitle()+" "
                                +newBean.getJoke().get(0).getMtime());
                        break;
                }
            }
        });

    }

    @Override
    public void hideDialog() {
        srl_news.setRefreshing(false);

    }

    @Override
    public void showDialog() {
        srl_news.setRefreshing(true);

    }

    @Override
    public void showErrorMsg(String error) {
tv_news.setText("加载失败"+error);
    }
}

