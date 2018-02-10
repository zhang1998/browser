package com.ucpro.feature.video.player.view;

import android.app.Activity;
import android.media.AudioManager;
import com.uc.imagecodec.export.IPictureView;
import com.uc.webview.export.utility.Utils;
import com.ucpro.feature.video.p;
import com.ucpro.feature.video.player.a.b;
import com.ucpro.feature.video.player.e;
import com.ucpro.model.a.a;

/* compiled from: ProGuard */
final class ak implements q {
    final /* synthetic */ f a;

    ak(f fVar) {
        this.a = fVar;
    }

    public final void a() {
        this.a.b = a.a.a("video_full_screen_brightness_key");
        if (this.a.b == -1.0f) {
            this.a.b = 0.5f;
        }
        this.a.a.setLightAreaInfo((int) (this.a.b * 100.0f));
        this.a.p.a(10062, null, null);
    }

    public final void a(int i) {
        float f = IPictureView.DEFAULT_MIN_SCALE;
        float f2 = this.a.b + (((float) i) / 100.0f);
        if (f2 < IPictureView.DEFAULT_MIN_SCALE) {
            f = f2;
        }
        if (f <= 0.0f) {
            f = 0.0f;
        }
        p.a((Activity) this.a.q, f);
        this.a.a.setLightAreaInfo((int) (f * 100.0f));
        this.a.c = f;
    }

    public final void b() {
        Activity activity = (Activity) this.a.q;
        float f = this.a.c;
        a.a.a.edit().putFloat("video_full_screen_brightness_key", f).apply();
        p.a(activity, f);
        this.a.p.a(10069, null, null);
    }

    public final void c() {
        int b = p.b(this.a.q);
        if (this.a.e != -1 && b != -1) {
            this.a.d = (((float) b) * IPictureView.DEFAULT_MIN_SCALE) / ((float) this.a.e);
            this.a.a.setVolumeAreaInfo((int) (this.a.d * 100.0f));
            this.a.p.a(10063, null, null);
        }
    }

    public final void b(int i) {
        float f = IPictureView.DEFAULT_MIN_SCALE;
        if (this.a.e != -1) {
            float f2 = this.a.d + (((float) i) / 100.0f);
            if (f2 < IPictureView.DEFAULT_MIN_SCALE) {
                f = f2;
            }
            if (f <= 0.0f) {
                f = 0.0f;
            }
            try {
                ((AudioManager) this.a.q.getSystemService("audio")).setStreamVolume(3, (int) (((float) this.a.e) * f), 0);
            } catch (Exception e) {
            }
            this.a.a.setVolumeAreaInfo((int) (f * 100.0f));
        }
    }

    public final void d() {
        this.a.p.a(10069, null, null);
    }

    public final void e() {
        this.a.f = -1;
        this.a.g = -1;
        e f = this.a.r.f();
        if (f != null) {
            Object obj;
            if (f.g > 0 && f.l && f.k) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                this.a.p.a(10037, null, null);
                this.a.p.a(10064, null, null);
                this.a.f = this.a.r.f().h;
            }
        }
    }

    public final void c(int i) {
        e f = this.a.r.f();
        if (this.a.f != -1 && f != null) {
            Object obj;
            int i2 = f.g;
            int i3 = (int) ((((float) i) / 120.0f) * ((float) this.a.h));
            if (this.a.f + i3 >= i2) {
                i3 = i2 - this.a.f;
            } else if (this.a.f + i3 <= 0) {
                i3 = -this.a.f;
            }
            this.a.g = this.a.f + i3;
            a aVar = this.a.a;
            int i4 = this.a.g;
            if (i3 > 0) {
                obj = 1;
            } else {
                obj = null;
            }
            aVar.c.setText(Utils.timeFormat(i4));
            if (obj != null) {
                aVar.c.setImage(aVar.f);
            } else {
                aVar.c.setImage(aVar.g);
            }
        }
    }

    public final void f() {
        b a;
        if (this.a.g != -1) {
            a = b.a().a(10, Integer.valueOf(this.a.g));
        } else {
            a = null;
        }
        this.a.p.a(10069, a, null);
        this.a.f = -1;
        this.a.g = -1;
    }

    public final void g() {
        this.a.p.a(10000, null, null);
    }
}
