package com.ucpro.feature.setting.view.item;

import android.view.View;
import android.view.View.OnClickListener;
import com.ucpro.feature.setting.a.d;

/* compiled from: ProGuard */
public interface h extends OnClickListener {
    void a();

    void a(String str);

    int getKey();

    d getSettingItemData();

    View getSettingItemView();

    String getValue();

    void setSettingItemData(d dVar);

    void setSettingItemViewCallback(c cVar);

    void setStatus(boolean z);

    void setValue(String str);

    void setViewVisibility(int i);
}
