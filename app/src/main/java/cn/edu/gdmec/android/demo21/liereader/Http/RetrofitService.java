package cn.edu.gdmec.android.demo21.liereader.Http;

import cn.edu.gdmec.android.demo21.liereader.Bean.NewBean;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by apple on 18/5/29.
 */

public interface RetrofitService {
    @GET("nc/article/{type}/{id}/{startPage}-20.html")
    Call<NewBean> getNews(@Path("type") String type,
                          @Path("id") String id,
                          @Path("startPage") int startPage);
}
