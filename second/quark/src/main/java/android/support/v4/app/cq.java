package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.RemoteViews;
import java.util.ArrayList;

/* compiled from: ProGuard */
public final class cq {
    Notification A;
    public Notification B = new Notification();
    public ArrayList<String> C;
    public Context a;
    public CharSequence b;
    public CharSequence c;
    public PendingIntent d;
    PendingIntent e;
    RemoteViews f;
    public Bitmap g;
    public CharSequence h;
    public int i;
    public int j;
    boolean k = true;
    public boolean l;
    public cl m;
    public CharSequence n;
    int o;
    int p;
    boolean q;
    String r;
    boolean s;
    String t;
    public ArrayList<bf> u = new ArrayList();
    boolean v = false;
    String w;
    Bundle x;
    int y = 0;
    int z = 0;

    public cq(Context context) {
        this.a = context;
        this.B.when = System.currentTimeMillis();
        this.B.audioStreamType = -1;
        this.j = 0;
        this.C = new ArrayList();
    }

    public final cq a(CharSequence charSequence) {
        this.b = d(charSequence);
        return this;
    }

    public final cq b(CharSequence charSequence) {
        this.c = d(charSequence);
        return this;
    }

    public final cq c(CharSequence charSequence) {
        this.n = d(charSequence);
        return this;
    }

    public final cq a(int i, int i2, boolean z) {
        this.o = i;
        this.p = i2;
        this.q = z;
        return this;
    }

    public final void a(int i, boolean z) {
        if (z) {
            Notification notification = this.B;
            notification.flags |= i;
            return;
        }
        notification = this.B;
        notification.flags &= i ^ -1;
    }

    protected static CharSequence d(CharSequence charSequence) {
        if (charSequence != null && charSequence.length() > 5120) {
            return charSequence.subSequence(0, 5120);
        }
        return charSequence;
    }

    @Deprecated
    public final Notification a() {
        av a = ap.a;
        cx cxVar = new cx();
        return a.a(this);
    }
}
