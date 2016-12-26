package shop.bawei.com.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import shop.bawei.com.R;
import shop.bawei.com.presenter.HomePresenter;
import shop.bawei.com.view.viewbase.HomeView;

public class MainActivity extends AppCompatActivity implements HomeView{

    private HomePresenter homePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        loadData();
    }

    private void initData() {
        homePresenter = new HomePresenter();
        homePresenter.attachView(this);
    }

    private void loadData(){
        homePresenter.loadData();
    }

    @Override
    public void onSuccess() {

    }

    @Override
    public void onError() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        homePresenter.detachView();
    }
}
