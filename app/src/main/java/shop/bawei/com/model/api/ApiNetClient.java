package shop.bawei.com.model.api;

import android.util.Log;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.bind.DateTypeAdapter;

import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import shop.bawei.com.model.bean.BaseListResponse;
import shop.bawei.com.model.bean.CategroyBean;


/**
 * Created by cj on 2017/2/7.
 */

public class ApiNetClient {

    private static Retrofit getRetrofit() {
//        GsonBuilder builder = new GsonBuilder();
//        builder.setFieldNamingStrategy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
//                .registerTypeAdapter(Date.class, new DateTypeAdapter());
//        Gson gson = builder.create();
        GsonConverterFactory gsonConverterFactory = GsonConverterFactory.create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.56.1/")
                .addConverterFactory(gsonConverterFactory)
                .build();
        return retrofit;
    }

    public static ApiDataService getApiDataService() {
        ApiDataService apiDataService = getRetrofit().create(ApiDataService.class);
        return apiDataService;
    }

    public static void getGoodsClass(String param) {
        Call<CategroyBean> listCall = getApiDataService().listRepos("goods_class");

    }

    public static void enqueue(Call<CategroyBean> call ) {
        call.enqueue(new Callback<CategroyBean>() {
            @Override
            public void onResponse(Call<CategroyBean> call, Response<CategroyBean> response) {
                Log.e("myMessage"," code "+response.body().getCode());
            }

            @Override
            public void onFailure(Call<CategroyBean> call, Throwable t) {

            }
        });
    }
}
