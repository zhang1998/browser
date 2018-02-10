package android.support.v7.graphics;

import android.support.v4.d.b;
import android.util.SparseBooleanArray;
import com.uc.imagecodec.export.IPictureView;
import java.util.List;
import java.util.Map;

/* compiled from: ProGuard */
public final class i {
    private static final c f = new e();
    public final List<b> a;
    private final List<g> b;
    private final Map<g, b> c;
    private final SparseBooleanArray d;
    private final int e;

    private i(List<b> list, List<g> list2) {
        this.a = list;
        this.b = list2;
        this.d = new SparseBooleanArray();
        this.c = new b();
        this.e = b();
    }

    private int b() {
        int size = this.a.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i = Math.max(((b) this.a.get(i2)).b, i);
        }
        return i;
    }

    public static /* synthetic */ void a(i iVar) {
        int size = iVar.b.size();
        for (int i = 0; i < size; i++) {
            int i2;
            int length;
            float f;
            g gVar = (g) iVar.b.get(i);
            float f2 = 0.0f;
            for (float f3 : gVar.i) {
                if (f3 > 0.0f) {
                    f2 += f3;
                }
            }
            if (f2 != 0.0f) {
                length = gVar.i.length;
                for (i2 = 0; i2 < length; i2++) {
                    if (gVar.i[i2] > 0.0f) {
                        float[] fArr = gVar.i;
                        fArr[i2] = fArr[i2] / f2;
                    }
                }
            }
            Map map = iVar.c;
            float f4 = 0.0f;
            b bVar = null;
            int size2 = iVar.a.size();
            int i3 = 0;
            while (i3 < size2) {
                Object obj;
                float f5;
                b bVar2 = (b) iVar.a.get(i3);
                fArr = bVar2.a();
                if (fArr[1] < gVar.g[0] || fArr[1] > gVar.g[2] || fArr[2] < gVar.h[0] || fArr[2] > gVar.h[2] || iVar.d.get(bVar2.a)) {
                    obj = null;
                } else {
                    obj = 1;
                }
                if (obj != null) {
                    float[] a = bVar2.a();
                    f3 = 0.0f;
                    float f6 = 0.0f;
                    float f7 = 0.0f;
                    if (gVar.i[0] > 0.0f) {
                        f3 = gVar.i[0] * (IPictureView.DEFAULT_MIN_SCALE - Math.abs(a[1] - gVar.g[1]));
                    }
                    if (gVar.i[1] > 0.0f) {
                        f6 = gVar.i[1] * (IPictureView.DEFAULT_MIN_SCALE - Math.abs(a[2] - gVar.h[1]));
                    }
                    if (gVar.i[2] > 0.0f) {
                        f7 = gVar.i[2] * (((float) bVar2.b) / ((float) iVar.e));
                    }
                    f3 = (f3 + f6) + f7;
                    if (bVar == null || f3 > f4) {
                        f5 = f3;
                        i3++;
                        f4 = f5;
                        bVar = bVar2;
                    }
                }
                bVar2 = bVar;
                f5 = f4;
                i3++;
                f4 = f5;
                bVar = bVar2;
            }
            if (bVar != null && gVar.j) {
                iVar.d.append(bVar.a, true);
            }
            map.put(gVar, bVar);
        }
        iVar.d.clear();
    }
}
