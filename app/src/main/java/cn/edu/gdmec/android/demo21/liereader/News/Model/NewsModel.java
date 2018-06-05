package cn.edu.gdmec.android.demo21.liereader.News.Model;

import android.util.Log;

import cn.edu.gdmec.android.demo21.liereader.Bean.NewBean;
import cn.edu.gdmec.android.demo21.liereader.Http.Api;
import cn.edu.gdmec.android.demo21.liereader.Http.RetrofitHelper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by apple on 18/5/29.
 */

public class NewsModel implements INewsModel{


    @Override
    public void loadNews( final String hostType,  final int startPage,
                          final String id,  final IOnLoadListener iOnLoadListener) {
        RetrofitHelper retrofitHelper=new RetrofitHelper(Api.NEWS_HOST);
        retrofitHelper.getNews(hostType,id,startPage).enqueue(new Callback<NewBean>() {
            @Override
            public void onResponse(Call<NewBean> call, Response<NewBean> response) {
                Log.i("onResponse", "onResponse: "+response.body());
                if (response.isSuccessful()){
                    iOnLoadListener.success(response.body());
                }else {
                    iOnLoadListener.fail("");
                }
            }

            @Override
            public void onFailure(Call<NewBean> call, Throwable t) {
             iOnLoadListener.fail(t.toString());
            }
        });

    }
}
