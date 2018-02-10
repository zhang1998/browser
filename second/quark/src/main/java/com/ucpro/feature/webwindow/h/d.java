package com.ucpro.feature.webwindow.h;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import com.ucpro.ui.widget.TextView;

/* compiled from: ProGuard */
public interface d {
    void a();

    void a(float f, float f2, int i, int i2);

    void a(int i);

    void a(OnClickListener onClickListener, OnLongClickListener onLongClickListener);

    void a(String str, String str2, String str3);

    void a(boolean z);

    void b();

    void c();

    void d();

    View getBackBtn();

    View getContentView();

    View getHomeBtn();

    View getMenuBtn();

    View getMultiWindowBtn();

    int getStackCount();

    View getStopBtn();

    TextView getUrlText();

    void setUrlTextVisibility(int i);
}
