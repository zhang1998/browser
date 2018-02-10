package com.ucpro.feature.downloadpage.e.c;

import android.content.Context;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.bd;
import android.support.v7.widget.bh;
import android.view.ViewGroup;
import com.uc.quark.h;
import com.uc.quark.s;
import com.uc.quark.x;
import com.uc.webview.browser.interfaces.SettingKeys;
import com.ucpro.ui.contextmenu.b;
import com.ucweb.common.util.c;
import com.ucweb.common.util.h.m;
import hugo.weaving.DebugLog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public final class n extends bd<s> implements h, u, b {
    public List<s> c;
    public h d;
    public boolean e = false;
    public boolean f = false;
    private Context g;

    @DebugLog
    public final /* synthetic */ void a(bh bhVar, int i) {
        Object obj = (s) bhVar;
        s sVar = (s) this.c.get(i);
        sVar.a(obj);
        obj.n = sVar.a();
        obj.m = i;
        obj.l.setPosition(i);
        obj.l.setTag(obj);
        obj.l.setTitle(sVar.b());
        if (this.f) {
            boolean z;
            Object obj2 = sVar.c;
            if (obj2 != null && (obj2 instanceof Boolean) && ((Boolean) obj2).booleanValue()) {
                z = true;
            } else {
                z = false;
            }
            t tVar = obj.l;
            tVar.c.setSelected(z);
            tVar.c.setImageDrawable(z ? tVar.e : tVar.d);
            tVar.g = true;
            if (!tVar.i || tVar.j == 0.0f) {
                tVar.a();
            }
        } else {
            t tVar2 = obj.l;
            tVar2.g = false;
            if (tVar2.c.isSelected()) {
                tVar2.c.setImageDrawable(tVar2.d);
            }
            if (tVar2.i && tVar2.j > 0.0f) {
                tVar2.b();
            }
        }
        obj.p.a = obj;
        obj.p.b = sVar;
        m.a(obj.p);
    }

    public n(Context context) {
        this.g = context;
        this.c = new ArrayList();
        x.a((h) this);
    }

    public final int a() {
        return this.c.size();
    }

    public final void a(int i, Object obj, boolean z) {
        if (this.d != null && i < this.c.size()) {
            m.a(0, new r(this, (s) this.c.get(i), z, obj));
        }
    }

    public final void a(boolean z, int i) {
        s sVar = (s) this.c.get(i);
        if (sVar != null) {
            sVar.c = Boolean.valueOf(z);
        }
        if (this.d != null) {
            this.d.n();
        }
    }

    public final void b(int i) {
        if (this.d != null && !this.f) {
            this.d.c();
            a(true, i);
        }
    }

    public final void a(List<s> list) {
        c.a((Object) list);
        this.c = list;
    }

    public final void d() {
    }

    public final void e() {
    }

    public final void a(com.ui.edittext.c cVar, Object obj) {
        if ((obj instanceof Integer) && cVar != null) {
            int intValue = ((Integer) obj).intValue();
            try {
                s sVar = (s) this.c.get(intValue);
                if (sVar != null) {
                    switch (cVar.a) {
                        case 100001:
                            if (this.d != null) {
                                this.d.a(sVar.a(), sVar.e() != -3);
                                this.c.remove(intValue);
                                this.d.c(this.c.size());
                                this.a.a();
                                com.ucpro.business.stat.m.a("download", "click_delete", new String[0]);
                                return;
                            }
                            return;
                        case 100002:
                            x.a().a(((s) this.c.get(intValue)).a(), true);
                            com.ucpro.business.stat.m.a("download", sVar.e() == -3 ? "click_redownload" : "click_cont_download", new String[0]);
                            return;
                        case 100003:
                            return;
                        case 100004:
                            if (this.d != null) {
                                this.d.a(sVar.a(), true);
                                this.c.remove(intValue);
                                this.d.c(this.c.size());
                                this.a.a();
                                com.ucpro.business.stat.m.a("download", "click_delete", new String[0]);
                                return;
                            }
                            return;
                        case 100005:
                            if (this.d != null) {
                                this.d.a(sVar.a(), sVar.b());
                                com.ucpro.business.stat.m.a("download", "rename", new String[0]);
                                return;
                            }
                            return;
                        case 100006:
                            if (this.d != null) {
                                this.d.b(sVar.g(), sVar.b());
                                com.ucpro.business.stat.m.a("download", SettingKeys.NetworkShareServerUrl, new String[0]);
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @hugo.weaving.DebugLog
    public final void a(com.uc.quark.s r14, int r15, long r16, long r18) {
        /*
        r13 = this;
        r2 = new java.lang.StringBuilder;
        r3 = "status = ";
        r2.<init>(r3);
        r2 = r2.append(r15);
        r3 = "  sofar = ";
        r2 = r2.append(r3);
        r4 = r14.d();
        r2 = r2.append(r4);
        r3 = "  total = ";
        r2 = r2.append(r3);
        r0 = r18;
        r2.append(r0);
        r2 = r13.e;
        if (r2 != 0) goto L_0x002c;
    L_0x0028:
        r2 = -3;
        if (r15 == r2) goto L_0x002c;
    L_0x002b:
        return;
    L_0x002c:
        r2 = r14.b;
        r2 = r2 instanceof com.ucpro.feature.downloadpage.e.c.s;
        if (r2 == 0) goto L_0x0056;
    L_0x0032:
        r2 = r14.b;
        r2 = (com.ucpro.feature.downloadpage.e.c.s) r2;
        if (r2 == 0) goto L_0x0042;
    L_0x0038:
        r3 = r2.n;
        r4 = r14.a();
        if (r3 != r4) goto L_0x0056;
    L_0x0042:
        if (r2 == 0) goto L_0x002b;
    L_0x0044:
        r8 = r14.f();
        r10 = 1;
        r11 = r14.r();
        r3 = r15;
        r4 = r16;
        r6 = r18;
        r2.a(r3, r4, r6, r8, r10, r11);
        goto L_0x002b;
    L_0x0056:
        r2 = 0;
        goto L_0x0042;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ucpro.feature.downloadpage.e.c.n.a(com.uc.quark.s, int, long, long):void");
    }

    public final ArrayList<s> b() {
        ArrayList<s> arrayList = new ArrayList();
        if (this.c != null) {
            for (s sVar : this.c) {
                if ((sVar.c instanceof Boolean) && ((Boolean) sVar.c).booleanValue()) {
                    arrayList.add(sVar);
                }
            }
        }
        return arrayList;
    }

    public final /* synthetic */ bh a(ViewGroup viewGroup, int i) {
        t tVar = new t(this.g);
        tVar.setLayoutParams(new LayoutParams(-1, -2));
        tVar.setListener(this);
        return new s(tVar, this, new j());
    }
}
