package com.march.lib.core.mvp.view.impl;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import com.march.lib.core.activity.BaseActivity;
import com.march.lib.core.mvp.presenter.BasePresenter;
import com.march.lib.core.mvp.view.BaseView;

/**
 * Project  : Reaper
 * Package  : com.march.reaper.base.activity
 * CreateAt : 2016/10/14
 * Describe :
 *
 * @author chendong
 */
public abstract class BaseMVPActivity
        <P extends BasePresenter> extends BaseActivity
        implements BaseView {

    protected P mPresenter;

    protected abstract P createPresenter();

    @Override
    protected String[] getPermission2Check() {
        return new String[0];
    }

    @Override
    public void onInitDatas() {
        super.onInitDatas();
        mPresenter = createPresenter();
    }

    @Override
    public void onStartWorks() {
        super.onStartWorks();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null)
            mPresenter.detachView();
    }

    @Override
    protected boolean isInitTitle() {
        return false;
    }

    @Override
    public Context getContext() {
        return mContext;
    }

    @Override
    public Activity getActivity() {
        return mActivity;
    }

    @Override
    public Bundle getData() {
        return getIntent().getBundleExtra(INTENT_DEFAULT_DATA);
    }
}
