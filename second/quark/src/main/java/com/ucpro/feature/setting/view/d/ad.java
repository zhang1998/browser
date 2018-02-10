package com.ucpro.feature.setting.view.d;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import com.airbnb.lottie.LottieAnimationView;
import com.quark.browser.R;
import com.ucpro.business.stat.a.d;
import com.ucpro.feature.setting.a.b;
import com.ucpro.feature.setting.a.g;
import com.ucpro.feature.setting.a.h;
import com.ucpro.feature.setting.c.a.a;
import com.ucpro.feature.setting.c.a.e;
import com.ucpro.feature.setting.view.c.c;
import com.ucpro.feature.setting.view.c.f;
import java.util.List;
import org.json.JSONObject;

/* compiled from: ProGuard */
public final class ad extends ac implements OnClickListener, d {
    private c f;
    private b g;
    private g h;
    private LottieAnimationView i = null;
    private String j = "";
    private String k = "";
    private String l = "";

    public ad(Context context, i iVar) {
        super(context, iVar);
        this.h = iVar;
        this.f = new f(getContext());
        this.f.setSettingViewCallback(this);
        a();
        getContentLayer().addView(this.f.getSettingView(), new LayoutParams(-1, -1));
        List d = e.e().d();
        boolean z = (d == null || d.size() == 0) ? false : System.currentTimeMillis() / 1000 < ((a) d.get(0)).t && !((a) d.get(0)).c;
        if (z) {
            String str = "lottie/quest_survey/data.json";
            String str2 = "lottie/quest_survey/images";
            String str3 = "lottie/quest_survey/images_night";
            if (this.i == null) {
                this.i = new LottieAnimationView(getContext());
                this.i.a(false);
                this.i.setOnClickListener(this);
                ViewGroup.LayoutParams layoutParams = new LayoutParams(-2, -2);
                layoutParams.gravity = 81;
                layoutParams.bottomMargin = 225;
                getContentLayer().addView(this.i, layoutParams);
            }
            if (!this.j.equals(str)) {
                try {
                    this.i.a(new JSONObject(com.ucweb.common.util.k.a.a(str, getContext())), 480);
                } catch (Throwable th) {
                }
                this.j = str;
                this.k = str2;
                this.l = str3;
                this.i.b();
                l();
            }
        }
        n();
    }

    public final String getTitleText() {
        return com.ucpro.ui.c.a.d((int) R.string.main_setting_window_title);
    }

    public final void l() {
        super.l();
        m();
        if (this.g != null) {
            this.g.c();
        }
        if (this.i == null) {
            return;
        }
        if (com.ucpro.ui.c.a.b() && !TextUtils.isEmpty(this.l)) {
            this.i.setImageAssetsFolder(this.l);
        } else if (!TextUtils.isEmpty(this.k)) {
            this.i.setImageAssetsFolder(this.k);
        }
    }

    public final void m() {
        setBackgroundColor(0);
        getContentLayer().setBackgroundColor(com.ucpro.ui.c.a.c("setting_window_background_color"));
    }

    public final void a() {
        if (this.f != null) {
            if (this.g == null) {
                this.g = new b(getContext(), this.h);
                b bVar = this.g;
                com.ucpro.feature.setting.a.e a = com.ucpro.feature.setting.a.f.a;
                getContext();
                bVar.a(a.a((byte) 0));
                this.f.setAdapter(this.g);
            }
            this.g.b();
            this.g.d();
            this.g.a();
        }
    }

    public final void a(String str) {
        if (this.e != null && this.e.getKey() == h.b) {
            this.e.setValue(str);
        }
    }

    public final void a(com.ucpro.feature.setting.view.item.h hVar, int i, Object obj) {
        i settingWindowCallback = getSettingWindowCallback();
        if (settingWindowCallback != null) {
            if (h.b == i) {
                this.e = hVar;
            }
            settingWindowCallback.a(i, obj);
        }
    }

    public final void onClick(View view) {
        i settingWindowCallback = getSettingWindowCallback();
        if (settingWindowCallback != null) {
            settingWindowCallback.a(h.R, null);
        }
    }

    public final String getSpm() {
        return com.ucpro.business.stat.a.a.a("9503168");
    }

    public final String getPageName() {
        return "Page_set";
    }
}
