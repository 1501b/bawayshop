package shop.bawei.com.presenter;

import shop.bawei.com.view.viewbase.MvpView;

/**
 * Created by cj on 2016/12/25.
 */

public class BasePresenter <T extends MvpView>{
    private T mvpView;
    public T getView() {
        return mvpView;
    }
    public void attachView(T t) {
        this.mvpView = t;
    }
    public void detachView() {
        mvpView = null;
    }
}
