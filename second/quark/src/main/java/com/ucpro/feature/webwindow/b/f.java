package com.ucpro.feature.webwindow.b;

import com.UCMobile.Apollo.Global;
import com.quark.browser.R;
import com.uc.apollo.impl.SettingsConst;
import com.uc.webview.browser.interfaces.BrowserExtension;
import com.uc.webview.browser.interfaces.PictureViewer.ClickType;
import com.uc.webview.browser.interfaces.PictureViewer.OnClickListener;
import com.uc.webview.browser.interfaces.PictureViewer.OnTabChangeListener;
import com.ucpro.base.a.j;
import com.ucpro.base.system.b;
import com.ucpro.business.stat.m;
import com.ucpro.c.c;
import com.ucpro.ui.b.e;
import com.ucpro.ui.c.a;
import com.ucweb.common.util.d;
import java.io.File;
import java.util.Calendar;

/* compiled from: ProGuard */
public final class f implements OnClickListener, OnTabChangeListener, g {
    c a;
    private int b = 0;
    private int c = 0;

    public f(k kVar) {
        this.a = kVar;
    }

    public final void onTabCountChanged(int i) {
        this.b = i;
        this.a.a(this.c + 1, this.b);
    }

    public final void onTabChanged(int i, int i2) {
        this.c = i;
        this.a.a(this.c + 1, this.b);
    }

    public final boolean onClick(ClickType clickType, String str) {
        return false;
    }

    public final void a() {
        com.ucpro.base.a.f.a().a(j.y, 0, null);
        e.a(SettingsConst.FALSE);
    }

    public static void a(boolean z, String str, String str2) {
        m.a("pic_viewer", "download", BrowserExtension.BUNDLE_KEY_IMAGE_URL, str2);
        if (z) {
            b.a.b(d.a(), str);
            e.a().a(String.format(a.d((int) R.string.pic_viewer_download_current_success_toast), new Object[]{str}), 1);
        }
    }

    public final void a(boolean z) {
        m.a("pic_viewer", "download_all", "dialog_result", String.valueOf(z));
        if (z && this.a != null && this.a.b() != null) {
            String e = c.e();
            String str = this.a.b().a;
            if (com.ucweb.common.util.n.a.a(str)) {
                Calendar instance = Calendar.getInstance();
                int i = instance.get(2);
                int i2 = instance.get(5);
                int i3 = instance.get(11);
                int i4 = instance.get(12);
                str = String.format("pic_uc_%02d%02d%02d%02d", new Object[]{Integer.valueOf(i + 1), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            } else {
                str = w.a(str);
                if (str.length() > 10) {
                    str = str.substring(0, 10);
                }
            }
            this.a.a(new File(e, str).getAbsolutePath());
        }
    }

    public final void b() {
        if (this.a != null) {
            String e = c.e();
            if (!(com.ucweb.common.util.n.a.a(this.a.a()) && (this.a.b() == null || com.ucweb.common.util.n.a.a(this.a.b().c)))) {
                this.a.a(e, "pic_quark_" + System.currentTimeMillis() + ".jpg");
            }
        }
        e.a(SettingsConst.TRUE);
    }

    public final void c() {
        e.a(Global.APOLLO_SERIES);
        if (this.a != null) {
            this.a.c();
        }
    }
}
