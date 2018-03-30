package jiyun.com.xiongmao.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getLayoutId(), container,false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
        loadData();
    }

    //这是统一加载布局的
    protected abstract int getLayoutId();

    //这是统一加载初始化组件的方法
    protected abstract void init();

    //这是统一加载数据的
    protected abstract void loadData();

    /**
     * 更新标题
     */
    public abstract void updateTitle();

    /**
     * 当fragment隐藏显示状态发生变化时会触动这个方法
     *
     * @param hidden true 代表处于隐藏状态  false 代表处于显示状态
     */
    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden) {
            onHidden();
        } else {
            onShow();
        }

    }

    /**
     * 代表fragment 处于隐藏状态
     */
    private void onHidden() {
    }

    ;

    /**
     * 代表的是fragment处于显示状态
     */
    private void onShow() {
    }

    ;
}
