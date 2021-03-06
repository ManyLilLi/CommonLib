package com.march.lib.core.mvp.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

/**
 * Project  : Reaper
 * Package  : com.march.reaper.base.mvp.view
 * CreateAt : 2016/10/13
 * Describe :
 *
 * @author chendong
 */

public interface BaseView {
    Context getContext();

    Activity getActivity();

    Bundle getData();
}
