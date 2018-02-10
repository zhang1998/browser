package com.ucpro.feature.setting.view.item;

import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.widget.LinearLayout;
import com.quark.browser.R;
import com.ucpro.feature.setting.a.d;
import com.ucpro.ui.c.a;

/* compiled from: ProGuard */
public abstract class e extends LinearLayout implements h {
    private static long a;
    private c b;
    private d c;
    private String d;
    private int e;
    private String f;
    private String g;
    private boolean h;

    abstract void a(boolean z);

    public e(Context context, int i, String str, String str2, boolean z) {
        super(context);
        setTitle(str);
        setValue(str2);
        setKey(i);
        setStatus(z);
        b();
    }

    public e(Context context, int i, String str, String str2, boolean z, String str3) {
        super(context);
        setTitle(str);
        setValue(str2);
        setKey(i);
        setStatus(z);
        setUiAutoTag(str3);
        b();
    }

    public void b() {
        setOrientation(0);
        setOnClickListener(this);
    }

    public int getTitleTextColor() {
        return a.c("default_maintext_gray");
    }

    public float getTitleTextSize() {
        return a.a((int) R.dimen.setting_item_view_default_title_text_size);
    }

    public int getItemLeftPadding() {
        return a.c((int) R.dimen.setting_item_view_default_padding_left);
    }

    public int getItemRightPadding() {
        return a.c((int) R.dimen.setting_item_view_default_padding_right);
    }

    public int getKey() {
        return this.e;
    }

    public void setKey(int i) {
        this.e = i;
    }

    public String getTitle() {
        return this.g;
    }

    public void setTitle(String str) {
        this.g = str;
    }

    public void setValue(String str) {
        this.f = str;
    }

    public String getValue() {
        return this.f;
    }

    public void setStatus(boolean z) {
        this.h = z;
        a(z);
    }

    public boolean getStatus() {
        return this.h;
    }

    public final boolean c() {
        new StringBuilder("CoolingTime is: ").append(String.valueOf(getClickCoolingTime()));
        new StringBuilder("interval: ").append(String.valueOf(SystemClock.uptimeMillis() - a));
        return SystemClock.uptimeMillis() - a >= getClickCoolingTime();
    }

    public void onClick(View view) {
        a = SystemClock.uptimeMillis();
        if (this.b != null) {
            this.b.a(this, getKey(), getValue());
        }
    }

    public void setSettingItemViewCallback(c cVar) {
        this.b = cVar;
    }

    public String getUiAutoTag() {
        return this.d;
    }

    public void setUiAutoTag(String str) {
        this.d = str;
    }

    public View getSettingItemView() {
        return this;
    }

    public long getClickCoolingTime() {
        return 300;
    }

    public void setViewVisibility(int i) {
        setVisibility(i);
    }

    public d getSettingItemData() {
        return this.c;
    }

    public void setSettingItemData(d dVar) {
        this.c = dVar;
    }
}
