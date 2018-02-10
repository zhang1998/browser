package com.ucpro.feature.video;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.uc.apollo.android.GuideDialog;
import com.uc.media.interfaces.IProxyHandler;
import com.ucpro.feature.video.player.a.b;
import com.ucpro.feature.video.player.a.g;
import com.ucpro.feature.video.player.d.p;
import com.ucpro.feature.video.player.e;
import com.ucpro.feature.video.player.f;
import com.ucpro.feature.video.player.h;
import com.ucpro.feature.video.player.r;
import com.ucweb.common.util.c;
import hugo.weaving.DebugLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: ProGuard */
public final class av implements t {
    public h a;
    private Bundle b;
    private ah c;
    private List<au> d;

    public av(Context context, g gVar, Integer num, boolean z) {
        this(context, gVar, num, z, 0);
    }

    public av(Context context, g gVar, Integer num, boolean z, int i) {
        this.c = null;
        this.d = new ArrayList();
        this.a = new h(context, gVar, num, z, i);
        this.b = new Bundle();
    }

    @DebugLog
    public final void l() {
        this.a.a();
    }

    @DebugLog
    public final void m() {
        this.a.b();
    }

    @DebugLog
    public final boolean n() {
        h hVar = this.a;
        return hVar.c != null && hVar.c.e();
    }

    @DebugLog
    public final void o() {
        for (int i = 0; i < this.d.size(); i++) {
            if (this.d.get(i) != null) {
                ((au) this.d.get(i)).onDestory();
            }
        }
        this.d.clear();
        h hVar = this.a;
        if (hVar.c != null) {
            hVar.c.k();
            hVar.c = null;
        }
        hVar.j();
    }

    @DebugLog
    public final int p() {
        return this.a.c();
    }

    @DebugLog
    public final int q() {
        return this.a.d();
    }

    @DebugLog
    public final View r() {
        return this.a.e();
    }

    @DebugLog
    public final void a(String str, Map<String, String> map) {
        if (this.b.containsKey(IProxyHandler.KEY_PAGE_URL) && this.b.containsKey(GuideDialog.TITLE)) {
            this.b.putString(IProxyHandler.KEY_VIDEO_URL, str);
            e eVar = this.a.e;
            eVar.a = 0;
            eVar.b = false;
            eVar.c = false;
            eVar.d = 0;
            eVar.e = 0;
            eVar.g = -1;
            eVar.h = 0;
            eVar.i = false;
            eVar.j = true;
            eVar.f = true;
            eVar.r = false;
            eVar.m = 0;
            eVar.n = 0;
            eVar.b();
            eVar.a();
            eVar.c(false);
            this.a.a(this.b);
        }
        this.b.clear();
        this.a.a(str, null);
    }

    @DebugLog
    public final void a(String str, String str2) {
        this.b.putString(GuideDialog.TITLE, str);
        this.b.putString(IProxyHandler.KEY_PAGE_URL, str2);
        h hVar = this.a;
        if (hVar.c != null) {
            hVar.c.a(str, str2);
        }
    }

    public final void a(au auVar) {
        this.d.add(auVar);
    }

    public final boolean a(int i, b bVar, b bVar2) {
        return this.a.a(i, bVar, bVar2);
    }

    public final void setPresenter(com.ucpro.base.d.b bVar) {
        c.a((Object) bVar);
        c.b(bVar instanceof ah);
        this.c = (ah) bVar;
    }

    public final void a(Bundle bundle) {
        this.a.a(bundle);
    }

    public final void a() {
        this.a.a(10002, null, null);
    }

    public final String b() {
        return this.a.e.o;
    }

    public final String c() {
        return this.a.e.p;
    }

    public final void a(List<String> list) {
        this.a.e.x = list;
    }

    public final String d() {
        return this.a.e.w;
    }

    public final String e() {
        return this.a.e.q;
    }

    public final void a(int i) {
        this.a.e.z = i;
    }

    public final void a(String str) {
        e eVar = this.a.e;
        eVar.w = str;
        for (int i = 0; i < eVar.u.size(); i++) {
            ((f) eVar.u.get(i)).y_();
        }
    }

    public final boolean f() {
        return this.a.k();
    }

    public final int g() {
        return this.a.e.m;
    }

    public final int h() {
        return this.a.e.n;
    }

    public final void i() {
        h hVar = this.a;
        if (hVar.d != null) {
            r rVar = hVar.d;
            if (rVar.c != null) {
                p pVar = rVar.c;
                if (pVar.j != null) {
                    pVar.j.a.a();
                }
            }
        }
    }

    public final boolean j() {
        h hVar = this.a;
        if (hVar.c != null) {
            return hVar.c.j();
        }
        return false;
    }

    public final int k() {
        return this.a.e.h;
    }
}
