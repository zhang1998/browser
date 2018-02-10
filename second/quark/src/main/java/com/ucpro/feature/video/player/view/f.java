package com.ucpro.feature.video.player.view;

import android.content.Context;
import com.ucpro.feature.video.p;
import com.ucpro.feature.video.player.a.b;
import com.ucpro.feature.video.player.a.g;
import com.ucpro.feature.video.player.b.h;
import com.ucpro.feature.video.player.b.l;
import com.ucpro.feature.video.player.e.a;
import com.ucpro.feature.video.player.q;
import java.util.List;

/* compiled from: ProGuard */
public final class f extends q<ab> {
    public a a = null;
    float b = 0.0f;
    float c = 0.0f;
    float d = 0.0f;
    int e = 0;
    int f = -1;
    int g = -1;
    int h = 120000;
    private q i = new ak(this);

    public f(Context context, g gVar, a aVar) {
        super(context, gVar, aVar);
        this.e = p.a(context);
        this.a = new a(this.q, this.p);
        this.a.setId(41);
        this.a.setGestureListener(this.i);
    }

    protected final void a(List<Class<?>> list) {
        list.add(l.class);
    }

    protected final void a(h<ab> hVar) {
        hVar.a(41).b(l.Idle.e).a(new ab(0)).b(l.LightChange.e).a(new ab(1)).b(l.VolumeChange.e).a(new ab(2)).b(l.SeekChange.e).a(new ab(3));
        hVar.a(new j(this));
    }

    public final boolean b(int i, b bVar, b bVar2) {
        return false;
    }

    public final boolean a(int i, b bVar, b bVar2) {
        return false;
    }
}
