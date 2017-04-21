package shop.bawei.com.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import shop.bawei.com.R;

/**
 * Created by cj on 2016/12/28.
 */

public class CategoryFragment extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_category,container,false);
    }

    @Override
    View initSelfView() {
        return View.inflate(getActivity(),R.layout.fragment_category,null);
    }

    @Override
    void initData() {
    }

    @Override
    void initView(View view) {
    }
}
