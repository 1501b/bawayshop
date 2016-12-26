package shop.bawei.com.presenter;

import android.util.Log;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;
import shop.bawei.com.application.ApplicationConstants;
import shop.bawei.com.model.api.OkHttpClientManager;
import shop.bawei.com.view.viewbase.HomeView;

/**
 * Created by cj on 2016/12/25.
 */

public class HomePresenter extends BasePresenter<HomeView>{

    public void loadData() {
        final Request request = new Request.Builder().url(ApplicationConstants.LINK_MOBILE_CLASS).build();
        OkHttpClientManager.enqueue(request, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("myMessage","err");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.e("myMessage",""+response.body().string().toString());
            }
        });
    }
}
