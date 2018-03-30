package jiyun.com.xiongmao.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import jiyun.com.xiongmao.App.App;
import jiyun.com.xiongmao.R;

public abstract class BaseActivity extends AppCompatActivity {
    //记录上一次的加载的fragment
    private BaseFragment lastFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        init();
        loadData();
    }

    //这使用来加载布局文件的
    protected abstract int getLayoutId();

    //这是用来初始化统一初始化的
    protected abstract void init();

    //这是用来加载数据的
    protected abstract void loadData();

    //这个方法是用来同意管理布局的
    protected BaseFragment setContentView(Class<? extends BaseFragment> fragmentClass) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        //获取Fragment的类名 用作Tag
        String fragmentName = fragmentClass.getSimpleName();
        /*
        1.如何创建fragment对象
        2.创建过的就直接查询,如果没有创建就直接查询
         */
        //根据Tag值来查找Fragment
        BaseFragment fragment = (BaseFragment) fragmentManager.findFragmentByTag(fragmentName);

        try {
            if (fragment == null) {
                fragment = fragmentClass.newInstance();
                //如果fragment等于null代表没有创建  采用java的代理进行添加
                transaction.add(R.id.fl_content, fragment,fragmentName);
            }
            //隐藏上一个fragment
            if (lastFragment != null) {
                transaction.hide(lastFragment);
            }
            transaction.show(fragment);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        lastFragment = fragment;
        transaction.commit();
        return fragment;
    }

    @Override
    protected void onResume() {
        super.onResume();
        App.context = this;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        App.context = null;
    }
}

