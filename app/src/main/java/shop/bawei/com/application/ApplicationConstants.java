package shop.bawei.com.application;

import android.util.Log;

import java.util.Date;

/**
 * Created by cj on 2016/12/4.
 */

public class ApplicationConstants {
   // private static final String LINK_MAIN = "http://192.168.1.105/";
    private static final String LINK_MAIN = "http://192.168.56.1/";
    //private static final String LINK_MAIN = "http://169.254.2.120/";
    private static final String LINK_MOBILE = LINK_MAIN + "mobile/index.php?act=";
    public static final String LINK_MOBILE_CLASS = LINK_MOBILE + "goods_class";
    private static int pageSize = 15;
    //public static final String APP_KEY = "5b18ba290247b97a94ec10fe5dd7d761";
    public static final String APP_KEY = "a0f19c0e92c82045c9cc4f7e716e6c33";
   // public static final String URL_PICTURE = "http://japi.juhe.cn/funny/list.from?key="+APP_KEY;
    public static final String URL_PICTURE = "http://japi.juhe.cn/joke/content/list.from?key="+APP_KEY;

    public static String getUrl(int currentPage) {
        //String url = URL_PICTURE+"&cat="+currentPage+"&count="+pageSize+"&st=0";
        String url = URL_PICTURE + "&page="+currentPage+"&pagesize="+pageSize+"&sort=asc&time="+getTimeStr();
        Log.e("time",""+getTimeStr());
        return url;
    }

    public static String getTimeStr() {
        return String.valueOf(new Date().getTime()).substring(0,10);
    }
}
