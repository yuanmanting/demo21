package cn.edu.gdmec.android.demo21.liereader.Http;

import java.util.concurrent.TimeUnit;

import cn.edu.gdmec.android.demo21.liereader.Bean.NewBean;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by apple on 18/5/29.
 */

public class RetrofitHelper {
    private static OkHttpClient okHttpClient;
    private RetrofitService retrofitService;

    public RetrofitHelper(String host){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(host)
                .client(getOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofitService=retrofit.create(RetrofitService.class);
    }

    public Call<NewBean> getNews(String type, String id , int startPage){
        return  retrofitService.getNews(type,id,startPage);
    }

    public OkHttpClient getOkHttpClient() {
        if (okHttpClient==null){
            okHttpClient=new OkHttpClient.Builder()
                    .retryOnConnectionFailure(true)
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .build();
        }
        return okHttpClient;
    }
}
