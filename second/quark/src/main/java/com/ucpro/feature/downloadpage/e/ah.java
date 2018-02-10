package com.ucpro.feature.downloadpage.e;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.View;
import android.webkit.ValueCallback;
import com.quark.browser.R;
import com.uc.imagecodec.export.IPictureView;
import com.uc.quark.n;
import com.uc.quark.s;
import com.uc.quark.x;
import com.ucpro.base.c.b.g;
import com.ucpro.base.c.b.m;
import com.ucpro.base.system.b;
import com.ucpro.feature.downloadpage.a.d;
import com.ucpro.feature.downloadpage.a.k;
import com.ucpro.feature.downloadpage.a.l;
import com.ucpro.feature.downloadpage.e.c.a.a;
import com.ucpro.feature.downloadpage.e.c.a.e;
import com.ucpro.ui.widget.auto.theme.ATTextView;
import com.ucweb.c.a.c;
import java.util.List;
import okhttp3.Request.Builder;

/* compiled from: ProGuard */
public class ah implements d, a, j {
    private m a;
    private m b;
    x c = x.a();
    List<s> d = null;

    public ah(m mVar, m mVar2) {
        this.a = mVar;
        this.b = mVar2;
        if (this.a != null) {
            e a = e.a();
            if (!a.a.contains(this)) {
                a.a.add(this);
            }
        }
    }

    public final void a(ValueCallback valueCallback) {
        com.ucweb.common.util.h.m.a(0, new q(this), new k(this, valueCallback));
    }

    public final void a(int i, boolean z) {
        com.ucweb.common.util.h.m.a(0, new ac(this, i, z));
    }

    public final void a(String str, String str2) {
        if (!b.a.a(str, str2)) {
            com.ucpro.ui.b.e.a().a(com.ucpro.ui.c.a.d((int) R.string.download_open_file_fail_tips), 1);
        }
    }

    public final void a(int i) {
        this.c.a(i, true);
    }

    public final void a(boolean z) {
        d();
        this.b.a(z);
    }

    public final g a(g gVar) {
        return this.b.b(gVar);
    }

    public final void b() {
        d();
        com.ucpro.base.a.g.a().a(com.ucpro.base.a.e.v);
    }

    public final void c() {
        Object a = e.a();
        a.b.removeCallbacks(a);
        a.b.post(a);
        a.c = true;
    }

    public final void d() {
        e a = e.a();
        if (a.a.contains(this)) {
            a.a.remove(this);
        }
        Object a2 = e.a();
        a2.b.removeCallbacks(a2);
        a2.c = false;
    }

    public final void a(long j, long j2) {
        this.a.a(j, j2);
    }

    public final void a(int i, String str, com.ucpro.feature.downloadpage.e.a.b bVar) {
        if (this.c.b(bVar.k()) || !com.ucweb.common.util.n.a.b(bVar.k())) {
            CharSequence d;
            if (com.ucweb.common.util.n.a.b(bVar.k())) {
                d = com.ucpro.ui.c.a.d((int) R.string.download_rename_warn);
            } else {
                d = com.ucpro.ui.c.a.d((int) R.string.download_rename_not_null);
            }
            ATTextView aTTextView = bVar.b;
            if (TextUtils.isEmpty(d)) {
                d = "";
            }
            aTTextView.setText(d);
            View decorView = bVar.getWindow().getDecorView();
            if (decorView != null) {
                PropertyValuesHolder ofKeyframe = PropertyValuesHolder.ofKeyframe(View.SCALE_X, new Keyframe[]{Keyframe.ofFloat(IPictureView.DEFAULT_MIN_SCALE, IPictureView.DEFAULT_MIN_SCALE), Keyframe.ofFloat(IPictureView.DEFAULT_MIN_SCALE, IPictureView.DEFAULT_MIN_SCALE)});
                PropertyValuesHolder ofKeyframe2 = PropertyValuesHolder.ofKeyframe(View.SCALE_Y, new Keyframe[]{Keyframe.ofFloat(IPictureView.DEFAULT_MIN_SCALE, IPictureView.DEFAULT_MIN_SCALE), Keyframe.ofFloat(IPictureView.DEFAULT_MIN_SCALE, IPictureView.DEFAULT_MIN_SCALE)});
                PropertyValuesHolder ofKeyframe3 = PropertyValuesHolder.ofKeyframe(View.ROTATION, new Keyframe[]{Keyframe.ofFloat(0.0f, 0.0f), Keyframe.ofFloat(0.05f, -1.0f), Keyframe.ofFloat(0.1f, IPictureView.DEFAULT_MIN_SCALE), Keyframe.ofFloat(0.15f, -1.0f), Keyframe.ofFloat(0.2f, IPictureView.DEFAULT_MIN_SCALE), Keyframe.ofFloat(0.25f, -1.0f), Keyframe.ofFloat(0.3f, IPictureView.DEFAULT_MIN_SCALE), Keyframe.ofFloat(0.35f, -1.0f), Keyframe.ofFloat(0.4f, IPictureView.DEFAULT_MIN_SCALE), Keyframe.ofFloat(0.45f, -1.0f), Keyframe.ofFloat(0.5f, -1.0f), Keyframe.ofFloat(0.55f, IPictureView.DEFAULT_MIN_SCALE), Keyframe.ofFloat(0.6f, -1.0f), Keyframe.ofFloat(0.65f, IPictureView.DEFAULT_MIN_SCALE), Keyframe.ofFloat(0.7f, -1.0f), Keyframe.ofFloat(0.75f, IPictureView.DEFAULT_MIN_SCALE), Keyframe.ofFloat(0.8f, -1.0f), Keyframe.ofFloat(0.85f, IPictureView.DEFAULT_MIN_SCALE), Keyframe.ofFloat(0.9f, -1.0f), Keyframe.ofFloat(IPictureView.DEFAULT_MIN_SCALE, 0.0f)});
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(decorView, new PropertyValuesHolder[]{ofKeyframe, ofKeyframe2, ofKeyframe3});
                ofPropertyValuesHolder.setDuration(3000);
                ofPropertyValuesHolder.start();
                return;
            }
            return;
        }
        s c;
        x xVar = this.c;
        if (xVar.f.b(i)) {
            c = xVar.f.c(i);
        } else {
            c = null;
        }
        if (c == null) {
            bVar.dismiss();
            return;
        }
        this.c.b(i, false);
        String c2 = x.c(bVar.k());
        b.a.b(c.h(), c2);
        n nVar = new n();
        nVar.a = c.g();
        nVar.e = c2;
        nVar.d = bVar.k();
        nVar.b = c.j();
        nVar.c = c.i();
        c = this.c.a(nVar.a());
        com.uc.quark.a.m.a(new com.uc.quark.a(this.c, c.h(), c.a()));
        this.a.a();
        bVar.dismiss();
        com.ucpro.business.stat.m.a("download", "rename_succ", "rename_old", str, "rename_new", r1);
    }

    public final void b(String str, String str2) {
        String a = com.ucpro.feature.d.a.b.a(BitmapFactory.decodeResource(this.a.getActivity().getResources(), R.mipmap.ic_launcher));
        com.ucweb.c.b.a aVar = new com.ucweb.c.b.a();
        aVar.a = str;
        aVar.c = String.format(com.ucpro.ui.c.a.d((int) R.string.share_content_download), new Object[]{com.ucpro.ui.c.a.d((int) R.string.app_name), str2});
        aVar.b = str2;
        aVar.e = a;
        aVar.f = a;
        aVar.d = c.c;
        com.ucpro.base.a.g.a().a(com.ucpro.base.a.e.bC, aVar.a());
    }

    public final boolean a(String str) {
        boolean z = this.c.b(str) || com.ucweb.common.util.n.a.a(str);
        if (z) {
            com.ucpro.ui.b.e.a().a(com.ucweb.common.util.n.a.b(str) ? com.ucpro.ui.c.a.d((int) R.string.download_rename_warn) : com.ucpro.ui.c.a.d((int) R.string.download_rename_not_null), 1);
        }
        return z;
    }

    public final boolean e() {
        return com.ucpro.services.download.b.a();
    }

    public final void b(boolean z) {
        com.ucpro.business.stat.m.a("download", "open_only_wifi", "open_only_wifi_value", String.valueOf(z));
        com.uc.quark.filedownloader.contentprovider.a.a(z);
        com.ucpro.model.a.a.a.b("download_wifi_switch", z);
    }

    public final boolean f() {
        return com.ucpro.services.download.b.c();
    }

    public final void c(boolean z) {
        com.ucpro.business.stat.m.a("download", "open_thread_set", "open_thread_value", String.valueOf(z));
        com.ucpro.model.a.a.a.b("download_open_thread_switch", z);
    }

    public final int g() {
        return com.ucpro.services.download.b.b();
    }

    public final void b(int i) {
        com.ucpro.business.stat.m.a("download", "open_thread_set_num", "open_thread_num", String.valueOf(i));
        com.ucpro.model.a.a.a.b("download_cur_thread_num", i);
    }

    public final void a(String str, ValueCallback<String[]> valueCallback) {
        if (!TextUtils.isEmpty(str) && str.trim().indexOf("http") == 0) {
            try {
                com.ucpro.services.f.g.a().newCall(new Builder().url(str).build()).enqueue(new aa(this, valueCallback));
            } catch (Exception e) {
            }
        }
    }

    public final void a(String str, String str2, long j, int i) {
        if (com.ucweb.common.util.n.a.a(str) || com.ucweb.common.util.n.a.a(str2)) {
            com.ucpro.ui.b.e.a().a(com.ucpro.ui.c.a.d((int) R.string.download_add_task_url_or_filename_null), 1);
            return;
        }
        com.ucpro.business.stat.m.a("download", "add_new_task_ok", new String[0]);
        String a = com.ucweb.common.util.l.d.a(com.ucweb.common.util.l.d.d(com.ucweb.common.util.l.d.a(str, "", "")));
        boolean a2 = com.ucpro.services.download.b.a();
        if (com.ucweb.common.util.n.a.a(a)) {
            a = com.ucweb.common.util.l.d.a(com.ucweb.common.util.l.d.d(str2));
        }
        n nVar = new n();
        nVar.a = str;
        nVar.d = str2;
        nVar.b = str;
        nVar.c = a;
        nVar.o = i;
        if (j <= 0) {
            j = -1;
        }
        nVar.p = j;
        nVar.m = a2;
        x.a().a(nVar.a()).k();
        if (this.a != null) {
            this.a.a();
        }
    }

    public final void h() {
        com.ucpro.business.stat.m.a("download", "select_download_dir", new String[0]);
        com.ucpro.base.a.g.a().a(com.ucpro.base.a.e.df);
    }

    public final String i() {
        return com.ucpro.services.download.b.d();
    }

    public final void j() {
        com.ucpro.business.stat.m.a("download", "open_setting", new String[0]);
        new k(this.a.getActivity(), this).show();
    }

    public final void k() {
        new l(this.a.getActivity(), this, com.ucpro.services.download.b.c(), com.ucpro.services.download.b.b()).show();
    }

    public String a() {
        String b = com.ucpro.services.e.e.a.b();
        if (com.ucweb.common.util.n.a.b(b)) {
            return b;
        }
        return com.ucpro.services.e.e.a.c();
    }
}
