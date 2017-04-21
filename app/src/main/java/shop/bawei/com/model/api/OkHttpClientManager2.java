package shop.bawei.com.model.api;

import android.os.AsyncTask;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpClientManager2 {
    // 超时时间
    public static final int TIMEOUT = 1000 * 60;
    private static final OkHttpClient mOkHttpClient = new OkHttpClient();

    /**
     * 同步请求
     *
     * @param request
     * @return
     * @throws IOException
     */
    public static Response execute(Request request) throws IOException {
        return mOkHttpClient.newCall(request).execute();
    }

    /**
     * 开启异步线程访问网络
     *
     * @param request
     * @param responseCallback
     */
    public static void enqueue(Request request, Callback responseCallback) {
        mOkHttpClient.newBuilder().connectTimeout(TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(TIMEOUT, TimeUnit.SECONDS).build();


        mOkHttpClient.newCall(request).enqueue(responseCallback);
    }

    /**
     *
     * @param url 请求地址
     * @param params 参数 键值对
     * @param responseCallback  回调
     */
    public static void get(String url, Map<String, String> params, Callback responseCallback) {
        StringBuffer sb = new StringBuffer();
        if (params != null && params.size() > 0) {
            sb.append("?");
            Set<Map.Entry<String, String>> entries = params.entrySet();
            for (Map.Entry<String, String> entry:entries) {
                sb.append(entry.getKey());
                sb.append("=");
                try {
                    sb.append(URLEncoder.encode(entry.getValue(),"UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                sb.append("&");
            }
            sb.deleteCharAt(sb.length() - 1);
        }
        Request request = new Request.Builder().url(url+sb.toString()).build();
        mOkHttpClient.newCall(request).enqueue(responseCallback);
    }

    public void post(String url,Map<String, String> params, Callback responseCallback) {
        FormBody.Builder formBodyBuilder = new FormBody.Builder();
        if (params !=null && params.size() > 0) {
           Set<Map.Entry<String, String>> entries = params.entrySet();
           for (Map.Entry<String, String> entry:entries) {
               formBodyBuilder.add(entry.getKey(),entry.getValue());
           }
       }
        Request request = new Request.Builder().url(url).post(formBodyBuilder.build()).build();
        mOkHttpClient.newCall(request).enqueue(responseCallback);
    }

    /**
     * 开启异步线程访问网络, 且不在意返回结果（实现空callback）
     *
     * @param request
     */
    public static void enqueue(Request request) {
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });
    }

    public static String getStringFromServer(String url) throws IOException {
        Request request = new Request.Builder().url(url).build();
        Response response = execute(request);
        if (response.isSuccessful()) {
            String responseUrl = response.body().string();
            return responseUrl;
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }

    /**
     * 从网络获取json数据,(String byte[})
     *
     * @param path
     * @return
     */
    public static String getJsonByInternet(String path) {
        new AsyncTask<String, Void, String>() {
            @Override
            protected String doInBackground(String... params) {
                try {
                    URL url = new URL(params[0]);
                    //打开连接
                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                    if (200 == urlConnection.getResponseCode()) {
                        //得到输入流
                        InputStream is = urlConnection.getInputStream();
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        byte[] buffer = new byte[1024];
                        int len = 0;
                        while (-1 != (len = is.read(buffer))) {
                            baos.write(buffer, 0, len);
                            baos.flush();
                        }
                        return baos.toString("utf-8");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(String s) {
                Log.e("myMessage", " " + s);
            }
        }.execute(path);


        return null;
    }

}