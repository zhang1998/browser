package com.ucpro.feature.video.player.d;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.ucpro.feature.video.player.a.d;
import com.ucpro.feature.video.player.a.j;
import com.ucpro.feature.video.player.b.v;
import com.ucpro.feature.video.player.view.au;
import com.ucpro.ui.c.a;

/* compiled from: ProGuard */
final class e implements v<b> {
    final /* synthetic */ p a;

    e(p pVar) {
        this.a = pVar;
    }

    public final /* synthetic */ void a(int i, Object obj) {
        b bVar = (b) obj;
        if (bVar != null) {
            View findViewById = this.a.a.findViewById(i);
            if (findViewById == null) {
                return;
            }
            if (i == 24) {
                if (bVar.a && !TextUtils.isEmpty(bVar.b)) {
                    ((ImageView) findViewById).setImageDrawable(a.a(bVar.b));
                }
                if (bVar.a) {
                    if (this.a.l == null) {
                        this.a.l = new d(this.a.f);
                    }
                    this.a.f.animate().translationX(0.0f).setDuration(300).setListener(this.a.l).start();
                    return;
                }
                if (this.a.m == null) {
                    this.a.m = new j(this.a.f);
                }
                this.a.f.animate().translationX((float) (-this.a.f.getMeasuredWidth())).setDuration(300).setListener(this.a.m).start();
            } else if (i == 42) {
                if (bVar.a && !TextUtils.isEmpty(bVar.b)) {
                    ((ImageView) findViewById).setImageDrawable(a.a(bVar.b));
                }
                if (bVar.a) {
                    if (this.a.n == null) {
                        this.a.n = new d(this.a.g);
                    }
                    this.a.g.animate().translationX(0.0f).setDuration(300).setListener(this.a.n).start();
                    return;
                }
                if (this.a.o == null) {
                    this.a.o = new j(this.a.g);
                }
                this.a.g.animate().translationX((float) this.a.g.getMeasuredWidth()).setDuration(300).setListener(this.a.o).start();
            } else if (i == 20) {
                if (bVar.a) {
                    findViewById = this.a.b;
                    findViewById.animate().cancel();
                    if (findViewById.a == null) {
                        findViewById.a = new d(findViewById);
                    }
                    findViewById.animate().translationY(0.0f).setDuration(300).setListener(findViewById.a).start();
                    return;
                }
                findViewById = this.a.b;
                findViewById.animate().cancel();
                if (findViewById.b == null) {
                    findViewById.b = new j(findViewById);
                }
                findViewById.animate().translationY((float) (-findViewById.getMeasuredHeight())).setDuration(300).setListener(findViewById.b).start();
            } else if (i == 22) {
                au auVar;
                if (bVar.a) {
                    auVar = this.a.c;
                    auVar.a.animate().cancel();
                    if (auVar.e == null) {
                        auVar.e = new d(auVar.a);
                    }
                    auVar.a.animate().translationY(0.0f).setDuration(300).setListener(auVar.e).start();
                    return;
                }
                auVar = this.a.c;
                auVar.a.animate().cancel();
                if (auVar.f == null) {
                    auVar.f = new j(auVar.a);
                }
                auVar.a.animate().translationY((float) auVar.a.getMeasuredHeight()).setDuration(300).setListener(auVar.f).start();
            } else if (i == 21) {
                if (bVar.a) {
                    findViewById = this.a.d;
                    findViewById.animate().cancel();
                    if (findViewById.a == null) {
                        findViewById.a = new d(findViewById);
                    }
                    findViewById.animate().translationY(0.0f).setDuration(300).setListener(findViewById.a).start();
                    return;
                }
                findViewById = this.a.d;
                findViewById.animate().cancel();
                if (findViewById.b == null) {
                    findViewById.b = new j(findViewById);
                }
                findViewById.animate().translationY((float) (-findViewById.getMeasuredHeight())).setDuration(300).setListener(findViewById.b).start();
            } else if (i != 23) {
                findViewById.setVisibility(bVar.a ? 0 : 8);
            } else if (bVar.a) {
                findViewById = this.a.e;
                findViewById.animate().cancel();
                if (findViewById.a == null) {
                    findViewById.a = new d(findViewById);
                }
                findViewById.animate().translationY(0.0f).setDuration(300).setListener(findViewById.a).start();
            } else {
                findViewById = this.a.e;
                findViewById.animate().cancel();
                if (findViewById.b == null) {
                    findViewById.b = new j(findViewById);
                }
                findViewById.animate().translationY((float) findViewById.getMeasuredHeight()).setDuration(300).setListener(findViewById.b).start();
            }
        }
    }
}
