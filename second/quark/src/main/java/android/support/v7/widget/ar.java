package android.support.v7.widget;

import android.util.Log;
import android.view.animation.Interpolator;
import com.tencent.tinker.loader.shareutil.ShareElfFile.SectionHeader;

/* compiled from: ProGuard */
public final class ar {
    int a;
    private int b;
    private int c;
    private int d;
    private Interpolator e;
    private boolean f;
    private int g;

    static /* synthetic */ void a(ar arVar, RecyclerView recyclerView) {
        if (arVar.a >= 0) {
            int i = arVar.a;
            arVar.a = -1;
            RecyclerView.c(recyclerView, i);
            arVar.f = false;
        } else if (!arVar.f) {
            arVar.g = 0;
        } else if (arVar.e != null && arVar.d <= 0) {
            throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
        } else if (arVar.d <= 0) {
            throw new IllegalStateException("Scroll duration must be a positive number");
        } else {
            if (arVar.e != null) {
                recyclerView.o.a(arVar.b, arVar.c, arVar.d, arVar.e);
            } else if (arVar.d == SectionHeader.SHT_LOUSER) {
                recyclerView.o.a(arVar.b, arVar.c);
            } else {
                recyclerView.o.a(arVar.b, arVar.c, arVar.d);
            }
            arVar.g++;
            if (arVar.g > 10) {
                Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
            }
            arVar.f = false;
        }
    }
}
