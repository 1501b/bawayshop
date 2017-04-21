package shop.bawei.com.view.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import shop.bawei.com.R;
import shop.bawei.com.presenter.HomePresenter;
import shop.bawei.com.view.viewbase.HomeView;

/**
 * Created by cj on 2016/12/28.
 */

public class HomeFragment extends BaseFragment implements HomeView{

    private HomePresenter homePresenter;
    private RecyclerView recyclerView;

    @Override
    View initSelfView() {
        return View.inflate(getActivity(),R.layout.fragment_home,null);
    }

    @Override
    void initView(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.recycle_view);
    }

    public void initData() {
        homePresenter = new HomePresenter();
        homePresenter.loadData();
        Glide.with(this).load("").placeholder(null).into(new ImageView(getActivity()));
    }

    @Override
    public void onSuccess() {

    }

    @Override
    public void onError() {

    }
}
