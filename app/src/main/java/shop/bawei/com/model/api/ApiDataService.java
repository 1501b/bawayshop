package shop.bawei.com.model.api;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import shop.bawei.com.model.bean.CategroyBean;
import shop.bawei.com.model.bean.JokeData;

/**
 * Created by cj on 2017/2/7.
 */

public interface ApiDataService {
    @GET("mobile/index.php")
    Call<CategroyBean> listRepos(@Query("act") String user);
}
