package shop.bawei.com.view.test;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.widget.RadioGroup;
import java.util.ArrayList;
import java.util.List;

import shop.bawei.com.R;
import shop.bawei.com.view.adapter.FragmentTabAdapter;

public class MainActivity extends FragmentActivity {
    private RadioGroup rgs;
    public List<Fragment> fragments = new ArrayList<Fragment>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        fragments.add(new MainTabFragment());
//        fragments.add(new CategoryBaseFragment());
//        fragments.add(new ActionTabFragment());
//        fragments.add(new BrandTabFragment());
//        fragments.add(new MyTabFragment());
//
//        rgs = (RadioGroup) findViewById(R.id.tabs_all);
        FragmentTabAdapter tabAdapter = new FragmentTabAdapter(this, fragments, R.id.tab_content, rgs);
        tabAdapter.setOnRgsExtraCheckedChangedListener(new FragmentTabAdapter.OnRgsExtraCheckedChangedListener(){
            @Override
            public void OnRgsExtraCheckedChanged(RadioGroup radioGroup, int checkedId, int index) {
            }
        });
    }
}

