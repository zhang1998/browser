package android.mini.support.v7.widget;

import android.util.Log;
import android.view.animation.Interpolator;
import com.tencent.tinker.loader.shareutil.ShareElfFile.SectionHeader;

/* compiled from: ProGuard */
public final class bb {
    int a;
    private int b;
    private int c;
    private int d;
    private Interpolator e;
    private boolean f;
    private int g;

    static /* synthetic */ void a(bb bbVar, RecyclerView recyclerView) {
        if (bbVar.a >= 0) {
            int i = bbVar.a;
            bbVar.a = -1;
            RecyclerView.c(recyclerView, i);
            bbVar.f = false;
        } else if (!bbVar.f) {
            bbVar.g = 0;
        } else if (bbVar.e != null && bbVar.d <= 0) {
            throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
        } else if (bbVar.d <= 0) {
            throw new IllegalStateException("Scroll duration must be a positive number");
        } else {
            if (bbVar.e != null) {
                recyclerView.ai.a(bbVar.b, bbVar.c, bbVar.d, bbVar.e);
            } else if (bbVar.d == SectionHeader.SHT_LOUSER) {
                recyclerView.ai.a(bbVar.b, bbVar.c);
            } else {
                recyclerView.ai.a(bbVar.b, bbVar.c, bbVar.d);
            }
            bbVar.g++;
            if (bbVar.g > 10) {
                Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
            }
            bbVar.f = false;
        }
    }

    public bb() {
        this((byte) 0);
    }

    private bb(byte b) {
        this.a = -1;
        this.f = false;
        this.g = 0;
        this.b = 0;
        this.c = 0;
        this.d = SectionHeader.SHT_LOUSER;
        this.e = null;
    }

    public final void a(int i, int i2, int i3, Interpolator interpolator) {
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = interpolator;
        this.f = true;
    }
}
