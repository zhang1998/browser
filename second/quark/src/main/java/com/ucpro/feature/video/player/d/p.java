package com.ucpro.feature.video.player.d;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.quark.browser.R;
import com.ucpro.feature.video.player.a.b;
import com.ucpro.feature.video.player.a.g;
import com.ucpro.feature.video.player.a.j;
import com.ucpro.feature.video.player.b.h;
import com.ucpro.feature.video.player.b.m;
import com.ucpro.feature.video.player.b.n;
import com.ucpro.feature.video.player.b.r;
import com.ucpro.feature.video.player.b.s;
import com.ucpro.feature.video.player.q;
import com.ucpro.feature.video.player.view.af;
import com.ucpro.feature.video.player.view.al;
import com.ucpro.feature.video.player.view.ap;
import com.ucpro.feature.video.player.view.au;
import com.ucpro.feature.video.player.view.d;
import com.ucpro.feature.video.player.view.f;
import com.ucpro.feature.video.player.view.u;
import com.ucpro.services.networkstate.a;
import com.ucweb.common.util.i.c;
import java.util.Date;
import java.util.List;

/* compiled from: ProGuard */
public final class p extends q<b> implements a {
    public FrameLayout a = new h(this, this.q);
    public u b;
    public au c;
    ap d;
    d e;
    ImageView f;
    ImageView g;
    Handler h = null;
    Runnable i = null;
    public f j;
    public af k = null;
    com.ucpro.feature.video.player.a.d l = null;
    j m = null;
    com.ucpro.feature.video.player.a.d n = null;
    j o = null;

    public p(Context context, g gVar, com.ucpro.feature.video.player.e.a aVar) {
        super(context, gVar, aVar);
        this.a.setId(1);
        this.j = new f(this.q, this, this.r);
        this.a.addView(this.j.a, new LayoutParams(-1, -1));
        this.b = new u(this.q, this);
        this.c = new au(this.q, this, this.r);
        this.f = new ImageView(this.q);
        this.f.setId(24);
        this.f.setBackgroundDrawable(com.ucpro.ui.c.a.a("new_video_lock_bg.svg"));
        this.f.setOnClickListener(new l(this));
        this.g = new ImageView(this.q);
        this.g.setId(42);
        this.g.setBackgroundDrawable(com.ucpro.ui.c.a.a("new_video_play_bg.svg"));
        this.g.setOnClickListener(new d(this));
        this.d = new ap(this.q);
        this.d.setId(21);
        this.e = new d(this.q, this.r);
        this.e.setId(23);
        int a = (int) com.ucpro.ui.c.a.a((int) R.dimen.player_topbar_height);
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, a);
        layoutParams.gravity = 48;
        this.a.addView(this.b, layoutParams);
        layoutParams = new LayoutParams(-1, a);
        layoutParams.gravity = 80;
        layoutParams.bottomMargin = 1;
        this.a.addView(this.c.a, layoutParams);
        ViewGroup.LayoutParams layoutParams2 = new LayoutParams(-1, -2);
        layoutParams2.gravity = 48;
        this.a.addView(this.d, layoutParams2);
        layoutParams2 = new LayoutParams(-1, (int) com.ucpro.ui.c.a.a((int) R.dimen.player_seek_bar_height));
        layoutParams2.gravity = 80;
        layoutParams2.bottomMargin = 1;
        this.a.addView(this.e, layoutParams2);
        a = (int) com.ucpro.ui.c.a.a((int) R.dimen.player_lock_switch_button_width);
        int a2 = (int) com.ucpro.ui.c.a.a((int) R.dimen.player_lock_switch_button_height);
        int c = com.ucpro.ui.c.a.c((int) R.dimen.player_lock_switch_button_inner_width);
        int c2 = com.ucpro.ui.c.a.c((int) R.dimen.player_lock_switch_button_padding_left);
        int i = (a2 - c) - c2;
        c = (a2 - c) / 2;
        ViewGroup.LayoutParams layoutParams3 = new LayoutParams(a, a2);
        layoutParams3.gravity = 19;
        this.f.setPadding(c2, c, i, c);
        this.a.addView(this.f, layoutParams3);
        layoutParams3 = new LayoutParams(a, a2);
        layoutParams3.gravity = 21;
        this.g.setPadding(i, c, c2, c);
        this.a.addView(this.g, layoutParams3);
        this.k = new af(this.q, this, this.r);
        this.a.addView(this.k.a, new LayoutParams(-1, -1));
        c();
        x_();
        this.h = new Handler(Looper.getMainLooper());
        this.i = new a(this);
    }

    public final boolean b(int i, b bVar, b bVar2) {
        return false;
    }

    public final boolean a(int i, b bVar, b bVar2) {
        return this.p.a(i, bVar, bVar2);
    }

    protected final void a(List<Class<?>> list) {
        list.add(s.class);
        list.add(m.class);
        list.add(n.class);
        list.add(r.class);
    }

    protected final void a(h<b> hVar) {
        hVar.a(20, 21, 22, 23, 24, 42).b(s.HoverOff.c, m.d, n.g, r.f).a(new b(false, null)).a(24).b(s.HoverOn.c, m.UnLock.c, n.g, r.f).a(new b(true, "new_video_unlock.svg")).b(s.HoverOn.c, m.Locked.c, n.g, r.f).a(new b(true, "new_video_lock.svg")).a(42).b(s.HoverOn.c, m.UnLock.c, n.g, r.Playing.e).a(new b(true, "new_video_pause.svg")).b(s.HoverOn.c, m.UnLock.c, n.g, r.Playing.e ^ -1).a(new b(true, "new_video_play.svg")).b(s.HoverOn.c, m.UnLock.c ^ -1, n.g, r.f).a(new b(false, null)).a(20, 22).b(s.HoverOn.c, m.UnLock.c, n.g, r.f).a(new b(true, null)).b(s.HoverOn.c, m.UnLock.c ^ -1, n.g, r.f).a(new b(false, null)).a(21, 23).b(s.HoverOn.c, m.UnLock.c, n.g, r.f).a(new b(false, null)).b(s.HoverOn.c, m.UnLock.c ^ -1, n.g, r.f).a(new b(true, null)).a(41).b(s.HoverOn.c, m.UnLock.c, n.g, r.f).a(new b(true, null)).b(s.HoverOn.c, m.UnLock.c ^ -1, n.g, r.f).a(new b(false, null));
        hVar.a(new e(this));
    }

    final void x_() {
        b();
        CharSequence charSequence = "";
        try {
            charSequence = com.ucweb.common.util.f.a("HH:mm").format(new Date());
        } catch (Exception e) {
        }
        this.b.setTime(charSequence);
        this.d.setTime(charSequence);
        new c(this.q, this).execute(new String[0]);
    }

    private void b() {
        int i = al.a;
        if (!c.b()) {
            i = al.b;
        }
        this.b.setNetworkType$2ea18d7c(i);
        this.d.setNetworkType$2ea18d7c(i);
    }

    public final void p_() {
        b();
    }

    static /* synthetic */ void a(p pVar) {
        pVar.h.removeCallbacks(pVar.i);
        pVar.h.postDelayed(pVar.i, 60000);
    }
}
