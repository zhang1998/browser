package com.ucpro.feature.setting.b.d.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.quark.browser.R;
import com.ucpro.ui.c.a;
import com.ucpro.ui.widget.auto.theme.ATTextView;

/* compiled from: ProGuard */
public abstract class h extends RelativeLayout implements OnClickListener {
    protected RelativeLayout a = ((RelativeLayout) findViewById(R.id.dev_container));
    protected ATTextView b = ((ATTextView) findViewById(R.id.dev_setting_item_title));
    protected ATTextView c = ((ATTextView) findViewById(R.id.dev_setting_item_value));
    protected ImageView d = ((ImageView) findViewById(R.id.main_icon));

    public abstract void b();

    protected abstract void c();

    public h(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.dev_setting_item, this, true);
        this.a.setOnClickListener(this);
        this.a.setClickable(true);
    }

    protected void a() {
        if (this.b != null) {
            this.b.setTextColor(a.c("default_maintext_gray"));
        }
        if (this.c != null) {
            this.c.setTextColor(a.c("dev_setting_item_text_value_color"));
        }
    }

    public final void onClick(View view) {
        switch (view.getId()) {
            case R.id.dev_container:
                c();
                return;
            default:
                return;
        }
    }

    public final void d() {
        a();
    }
}
