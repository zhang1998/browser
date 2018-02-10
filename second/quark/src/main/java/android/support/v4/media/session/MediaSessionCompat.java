package android.support.v4.media.session;

import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: ProGuard */
public final class MediaSessionCompat {

    /* compiled from: ProGuard */
    public final class QueueItem implements Parcelable {
        public static final Creator<QueueItem> CREATOR = new b();
        private final MediaDescriptionCompat a;
        private final long b;

        private QueueItem(Parcel parcel) {
            this.a = (MediaDescriptionCompat) MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
            this.b = parcel.readLong();
        }

        public final void writeToParcel(Parcel parcel, int i) {
            this.a.writeToParcel(parcel, i);
            parcel.writeLong(this.b);
        }

        public final int describeContents() {
            return 0;
        }

        public final String toString() {
            return "MediaSession.QueueItem {Description=" + this.a + ", Id=" + this.b + " }";
        }
    }

    /* compiled from: ProGuard */
    final class ResultReceiverWrapper implements Parcelable {
        public static final Creator<ResultReceiverWrapper> CREATOR = new c();
        private ResultReceiver a;

        ResultReceiverWrapper(Parcel parcel) {
            this.a = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            this.a.writeToParcel(parcel, i);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: ProGuard */
    public @interface SessionFlags {
    }

    /* compiled from: ProGuard */
    public final class Token implements Parcelable {
        public static final Creator<Token> CREATOR = new a();
        private final Object a;

        Token(Object obj) {
            this.a = obj;
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            if (VERSION.SDK_INT >= 21) {
                parcel.writeParcelable((Parcelable) this.a, i);
            } else {
                parcel.writeStrongBinder((IBinder) this.a);
            }
        }
    }
}
