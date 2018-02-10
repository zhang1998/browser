package android.support.a.a;

import android.graphics.Matrix;
import android.support.v4.d.b;
import com.uc.imagecodec.export.IPictureView;
import java.util.ArrayList;

/* compiled from: ProGuard */
final class g {
    final Matrix a = new Matrix();
    final ArrayList<Object> b = new ArrayList();
    float c = 0.0f;
    float d = 0.0f;
    float e = 0.0f;
    float f = IPictureView.DEFAULT_MIN_SCALE;
    float g = IPictureView.DEFAULT_MIN_SCALE;
    float h = 0.0f;
    float i = 0.0f;
    final Matrix j = new Matrix();
    int k;
    int[] l;
    String m = null;

    public g(g gVar, b<String, Object> bVar) {
        this.c = gVar.c;
        this.d = gVar.d;
        this.e = gVar.e;
        this.f = gVar.f;
        this.g = gVar.g;
        this.h = gVar.h;
        this.i = gVar.i;
        this.l = gVar.l;
        this.m = gVar.m;
        this.k = gVar.k;
        if (this.m != null) {
            bVar.put(this.m, this);
        }
        this.j.set(gVar.j);
        ArrayList arrayList = gVar.b;
        for (int i = 0; i < arrayList.size(); i++) {
            Object obj = arrayList.get(i);
            if (obj instanceof g) {
                this.b.add(new g((g) obj, bVar));
            } else {
                k fVar;
                if (obj instanceof f) {
                    fVar = new f((f) obj);
                } else if (obj instanceof m) {
                    fVar = new m((m) obj);
                } else {
                    throw new IllegalStateException("Unknown object in the tree!");
                }
                this.b.add(fVar);
                if (fVar.n != null) {
                    bVar.put(fVar.n, fVar);
                }
            }
        }
    }
}
