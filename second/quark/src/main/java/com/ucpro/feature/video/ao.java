package com.ucpro.feature.video;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.quark.browser.R;
import com.uc.webview.export.internal.setup.UCAsyncTask;
import com.uc.webview.export.internal.setup.UCMPackageInfo;
import com.ucpro.base.a.g;
import com.ucpro.feature.i.f;
import com.ucpro.feature.video.player.a.b;
import com.ucpro.ui.b.e;
import com.ucweb.common.util.n.a;

/* compiled from: ProGuard */
public final class ao extends f {
    ag m = null;
    int n = 0;
    boolean o = false;
    ViewGroup p = null;

    public ao(Context context, int i) {
        super(context);
        this.n = i;
    }

    public final void a(t tVar) {
        super.a(tVar);
        if (this.n == 2) {
            View r = this.a.r();
            for (int i = 0; i < this.k.size(); i++) {
                View findViewById = r.findViewById(((Integer) this.k.get(i)).intValue());
                if (findViewById != null) {
                    findViewById.setVisibility(8);
                }
            }
        } else if (this.n != 3) {
            a(null);
        } else if (this.p != null) {
            this.p.addView(tVar.r());
        }
    }

    public final void a(String str, String str2) {
        a(str, str2, false, -1);
    }

    public final void a(String str, String str2, boolean z, int i) {
        if (this.a != null) {
            String e = this.a.e();
            String b = this.a.b();
            this.h.put(str2, str);
            if (!z) {
                i = this.a.q();
            } else if (i == -1) {
                i = 0;
            }
            this.a.a(str, null);
            this.a.l();
            if (!a.a(str2)) {
                this.a.a(str2);
            }
            this.a.a(e, b);
            b(i);
            if (!z) {
                e.a().a(com.ucpro.ui.c.a.d((int) R.string.video_switch_quliaty_success_pre) + p.a(str2, false), 0);
            }
        }
    }

    public final void a(String str) {
        this.a.a(str, null);
        this.a.l();
    }

    public final boolean a(int i, b bVar, b bVar2) {
        if (!super.a(i, bVar, bVar2)) {
            switch (i) {
                case UCAsyncTask.inThread /*10016*/:
                    if (this.n == 3 && this.p != null) {
                        this.p.removeView(this.a.r());
                        if (this.m != null) {
                            this.m.e();
                        }
                        a(true);
                        a();
                        break;
                    }
                case UCMPackageInfo.getLibFilter /*10023*/:
                    g.a().b(com.ucpro.base.a.e.bo, -1, 0, new boolean[]{null});
                    break;
                case 10074:
                    if (bVar != null) {
                        a((String) bVar.a(18), (String) bVar.a(22));
                        break;
                    }
                    break;
                default:
                    break;
            }
        }
        return false;
    }

    final boolean a(int i) {
        if (this.n != 2) {
            return super.a(i);
        }
        return true;
    }

    public final void e() {
        if (this.n == 3 && this.p != null) {
            this.p.removeView(this.a.r());
        }
        super.e();
    }

    public final void a(boolean z) {
        if (!f.a.b()) {
            if (z) {
                f.a.b((Activity) this.b);
            } else {
                f.a.a((Activity) this.b);
            }
        }
    }
}
