package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import java.util.ArrayList;

/* compiled from: ProGuard */
final class BackStackState implements Parcelable {
    public static final Creator<BackStackState> CREATOR = new ce();
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

    public BackStackState(an anVar) {
        int i = 0;
        for (ae aeVar = anVar.c; aeVar != null; aeVar = aeVar.a) {
            if (aeVar.i != null) {
                i += aeVar.i.size();
            }
        }
        this.a = new int[(i + (anVar.e * 7))];
        if (anVar.l) {
            i = 0;
            for (ae aeVar2 = anVar.c; aeVar2 != null; aeVar2 = aeVar2.a) {
                int i2 = i + 1;
                this.a[i] = aeVar2.c;
                int i3 = i2 + 1;
                this.a[i2] = aeVar2.d != null ? aeVar2.d.k : -1;
                int i4 = i3 + 1;
                this.a[i3] = aeVar2.e;
                i2 = i4 + 1;
                this.a[i4] = aeVar2.f;
                i4 = i2 + 1;
                this.a[i2] = aeVar2.g;
                i2 = i4 + 1;
                this.a[i4] = aeVar2.h;
                if (aeVar2.i != null) {
                    int size = aeVar2.i.size();
                    i4 = i2 + 1;
                    this.a[i2] = size;
                    i2 = 0;
                    while (i2 < size) {
                        i3 = i4 + 1;
                        this.a[i4] = ((Fragment) aeVar2.i.get(i2)).k;
                        i2++;
                        i4 = i3;
                    }
                    i = i4;
                } else {
                    i = i2 + 1;
                    this.a[i2] = 0;
                }
            }
            this.b = anVar.j;
            this.c = anVar.k;
            this.d = anVar.n;
            this.e = anVar.p;
            this.f = anVar.q;
            this.g = anVar.r;
            this.h = anVar.s;
            this.i = anVar.t;
            this.j = anVar.u;
            this.k = anVar.v;
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

    public final an a(ah ahVar) {
        an anVar = new an(ahVar);
        int i = 0;
        int i2 = 0;
        while (i2 < this.a.length) {
            ae aeVar = new ae();
            int i3 = i2 + 1;
            aeVar.c = this.a[i2];
            if (ah.a) {
                new StringBuilder("Instantiate ").append(anVar).append(" op #").append(i).append(" base fragment #").append(this.a[i3]);
            }
            int i4 = i3 + 1;
            i2 = this.a[i3];
            if (i2 >= 0) {
                aeVar.d = (Fragment) ahVar.f.get(i2);
            } else {
                aeVar.d = null;
            }
            i3 = i4 + 1;
            aeVar.e = this.a[i4];
            i4 = i3 + 1;
            aeVar.f = this.a[i3];
            i3 = i4 + 1;
            aeVar.g = this.a[i4];
            int i5 = i3 + 1;
            aeVar.h = this.a[i3];
            i4 = i5 + 1;
            int i6 = this.a[i5];
            if (i6 > 0) {
                aeVar.i = new ArrayList(i6);
                i3 = 0;
                while (i3 < i6) {
                    if (ah.a) {
                        new StringBuilder("Instantiate ").append(anVar).append(" set remove fragment #").append(this.a[i4]);
                    }
                    i5 = i4 + 1;
                    aeVar.i.add((Fragment) ahVar.f.get(this.a[i4]));
                    i3++;
                    i4 = i5;
                }
            }
            anVar.f = aeVar.e;
            anVar.g = aeVar.f;
            anVar.h = aeVar.g;
            anVar.i = aeVar.h;
            anVar.a(aeVar);
            i++;
            i2 = i4;
        }
        anVar.j = this.b;
        anVar.k = this.c;
        anVar.n = this.d;
        anVar.p = this.e;
        anVar.l = true;
        anVar.q = this.f;
        anVar.r = this.g;
        anVar.s = this.h;
        anVar.t = this.i;
        anVar.u = this.j;
        anVar.v = this.k;
        anVar.a(1);
        return anVar;
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
