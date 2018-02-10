package android.support.v4.os;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: ProGuard */
public class ResultReceiver implements Parcelable {
    public static final Creator<ResultReceiver> CREATOR = new k();
    public final boolean a = false;
    public final Handler b = null;
    public f c;

    public void a(int i, Bundle bundle) {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        synchronized (this) {
            if (this.c == null) {
                this.c = new h(this);
            }
            parcel.writeStrongBinder(this.c.asBinder());
        }
    }

    ResultReceiver(Parcel parcel) {
        this.c = c.a(parcel.readStrongBinder());
    }
}
