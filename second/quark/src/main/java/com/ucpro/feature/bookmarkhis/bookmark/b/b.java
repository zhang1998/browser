package com.ucpro.feature.bookmarkhis.bookmark.b;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.quark.browser.R;
import com.ucpro.ui.c.a;

/* compiled from: ProGuard */
public final class b extends RelativeLayout {
    public ValueAnimator a = ValueAnimator.ofInt(new int[]{0, 360});
    private View b = null;
    private ImageView c = null;
    private TextView d = null;
    private TextView e = null;
    private TextView f = null;

    public b(Context context) {
        super(context);
        LayoutInflater.from(getContext()).inflate(R.layout.bookmark_cloud_bar, this);
        this.c = (ImageView) findViewById(R.id.cloud_bar_sync_btn);
        this.d = (TextView) findViewById(R.id.cloud_bar_sync_tip);
        this.e = (TextView) findViewById(R.id.cloud_bar_sync_name);
        this.f = (TextView) findViewById(R.id.cloud_bar_sync_time);
        this.b = findViewById(R.id.cloud_bar_divider);
        setBackgroundColor(a.c("default_background_white"));
        this.c.setImageDrawable(a.a("cloud_bar_sync_btn.svg"));
        this.d.setTextColor(a.c("default_maintext_gray"));
        this.e.setTextColor(a.c("default_commentstext_gray"));
        this.f.setTextColor(a.c("default_commentstext_gray"));
        this.b.setBackgroundColor(a.c("default_cutting_line"));
    }

    public final void setLoginName(String str) {
        this.e.setText("／" + str);
    }

    public final void setSyncTime(String str) {
        this.f.setText(str);
    }

    public final ImageView getSyncBtn() {
        return this.c;
    }

    public final TextView getSyncName() {
        return this.e;
    }

    public final TextView getSyncTip() {
        return this.d;
    }

    public final void setSyncClickListener(OnClickListener onClickListener) {
        this.c.setOnClickListener(onClickListener);
        this.e.setOnClickListener(onClickListener);
        this.d.setOnClickListener(onClickListener);
    }
}
