package android.mini.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import java.util.ArrayList;

/* compiled from: ProGuard */
final class BackStackState implements Parcelable {
    public static final Creator<BackStackState> CREATOR = new g();
    final int[] a;
    final int b;
    final int c;
    final String d;
    final int e;
    final int f;
    final CharSequence g;
    final int h;
    final CharSequence i;
    final ArrayList<String> j;
    final ArrayList<String> k;

    public BackStackState(f fVar) {
        int i = 0;
        for (d dVar = fVar.c; dVar != null; dVar = dVar.a) {
            if (dVar.i != null) {
                i += dVar.i.size();
            }
        }
        this.a = new int[(i + (fVar.e * 7))];
        if (fVar.l) {
            i = 0;
            for (d dVar2 = fVar.c; dVar2 != null; dVar2 = dVar2.a) {
                int i2 = i + 1;
                this.a[i] = dVar2.c;
                int i3 = i2 + 1;
                this.a[i2] = dVar2.d != null ? dVar2.d.p : -1;
                int i4 = i3 + 1;
                this.a[i3] = dVar2.e;
                i2 = i4 + 1;
                this.a[i4] = dVar2.f;
                i4 = i2 + 1;
                this.a[i2] = dVar2.g;
                i2 = i4 + 1;
                this.a[i4] = dVar2.h;
                if (dVar2.i != null) {
                    int size = dVar2.i.size();
                    i4 = i2 + 1;
                    this.a[i2] = size;
                    i2 = 0;
                    while (i2 < size) {
                        i3 = i4 + 1;
                        this.a[i4] = ((Fragment) dVar2.i.get(i2)).p;
                        i2++;
                        i4 = i3;
                    }
                    i = i4;
                } else {
                    i = i2 + 1;
                    this.a[i2] = 0;
                }
            }
            this.b = fVar.j;
            this.c = fVar.k;
            this.d = fVar.n;
            this.e = fVar.p;
            this.f = fVar.q;
            this.g = fVar.r;
            this.h = fVar.s;
            this.i = fVar.t;
            this.j = fVar.u;
            this.k = fVar.v;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    public BackStackState(Parcel parcel) {
        this.a = parcel.createIntArray();
        this.b = parcel.readInt();
        this.c = parcel.readInt();
        this.d = parcel.readString();
        this.e = parcel.readInt();
        this.f = parcel.readInt();
        this.g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.h = parcel.readInt();
        this.i = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.j = parcel.createStringArrayList();
        this.k = parcel.createStringArrayList();
    }

    public final f a(ab abVar) {
        f fVar = new f(abVar);
        int i = 0;
        int i2 = 0;
        while (i2 < this.a.length) {
            d dVar = new d();
            int i3 = i2 + 1;
            dVar.c = this.a[i2];
            if (ab.a) {
                new StringBuilder("Instantiate ").append(fVar).append(" op #").append(i).append(" base fragment #").append(this.a[i3]);
            }
            int i4 = i3 + 1;
            i2 = this.a[i3];
            if (i2 >= 0) {
                dVar.d = (Fragment) abVar.f.get(i2);
            } else {
                dVar.d = null;
            }
            i3 = i4 + 1;
            dVar.e = this.a[i4];
            i4 = i3 + 1;
            dVar.f = this.a[i3];
            i3 = i4 + 1;
            dVar.g = this.a[i4];
            int i5 = i3 + 1;
            dVar.h = this.a[i3];
            i4 = i5 + 1;
            int i6 = this.a[i5];
            if (i6 > 0) {
                dVar.i = new ArrayList(i6);
                i3 = 0;
                while (i3 < i6) {
                    if (ab.a) {
                        new StringBuilder("Instantiate ").append(fVar).append(" set remove fragment #").append(this.a[i4]);
                    }
                    i5 = i4 + 1;
                    dVar.i.add((Fragment) abVar.f.get(this.a[i4]));
                    i3++;
                    i4 = i5;
                }
            }
            fVar.f = dVar.e;
            fVar.g = dVar.f;
            fVar.h = dVar.g;
            fVar.i = dVar.h;
            fVar.a(dVar);
            i++;
            i2 = i4;
        }
        fVar.j = this.b;
        fVar.k = this.c;
        fVar.n = this.d;
        fVar.p = this.e;
        fVar.l = true;
        fVar.q = this.f;
        fVar.r = this.g;
        fVar.s = this.h;
        fVar.t = this.i;
        fVar.u = this.j;
        fVar.v = this.k;
        fVar.a(1);
        return fVar;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
        parcel.writeString(this.d);
        parcel.writeInt(this.e);
        parcel.writeInt(this.f);
        TextUtils.writeToParcel(this.g, parcel, 0);
        parcel.writeInt(this.h);
        TextUtils.writeToParcel(this.i, parcel, 0);
        parcel.writeStringList(this.j);
        parcel.writeStringList(this.k);
    }
}
