package com.ucpro.feature.video.player;

import android.content.Context;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.ucpro.feature.video.player.a.b;
import com.ucpro.feature.video.player.a.g;
import com.ucpro.feature.video.player.b.f;
import com.ucpro.feature.video.player.b.h;
import com.ucpro.feature.video.player.d.j;
import com.ucpro.feature.video.player.d.o;
import com.ucpro.feature.video.player.d.p;
import com.ucpro.feature.video.player.e.a;
import com.ucpro.feature.video.player.view.v;
import java.util.List;

/* compiled from: ProGuard */
public final class r extends q<d> {
    FrameLayout a;
    v b;
    public p c;
    o d;
    private int e = 0;
    private j f;

    public r(Context context, g gVar, a aVar, int i) {
        super(context, gVar, aVar);
        this.e = i;
        this.a = new FrameLayout(this.q);
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.c = new p(this.q, this, this.r);
        this.a.addView(this.c.a, layoutParams);
        if (this.e == 0) {
            this.d = new o(this.q, this, this.r);
            this.a.addView(this.d.a, layoutParams);
        } else {
            this.f = new j(this.q, this, this.r, this.e);
            this.a.addView(this.f.a, layoutParams);
        }
        this.b = new v(this.q, this, this.r);
        layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.a.addView(this.b.a, layoutParams);
        this.a.setOnClickListener(new b(this));
        c();
    }

    public final boolean a(int i, b bVar, b bVar2) {
        return this.p.a(i, bVar, bVar2);
    }

    public final boolean b(int i, b bVar, b bVar2) {
        switch (i) {
            case 12:
                if (this.d == null) {
                    return true;
                }
                this.d.b(i, bVar, bVar2);
                return true;
            default:
                return false;
        }
    }

    protected final void a(List<Class<?>> list) {
        list.add(f.class);
    }

    protected final void a(h<d> hVar) {
        hVar.a(1).b(f.FullScreen.c).a(new d(true)).b(f.FullScreen.c ^ -1).a(new d(false)).a(2).b(f.MiniScreen.c).a(new d(true)).b(f.MiniScreen.c ^ -1).a(new d(false)).a(4).b(f.MiniScreen.c).a(new d(f.MiniScreen)).b(f.FullScreen.c).a(new d(f.FullScreen));
        hVar.a(new g(this));
    }
}
