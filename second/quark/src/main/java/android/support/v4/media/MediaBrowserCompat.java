package android.support.v4.media;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.os.ResultReceiver;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: ProGuard */
public final class MediaBrowserCompat {

    /* compiled from: ProGuard */
    class ItemReceiver extends ResultReceiver {
        protected final void a(int i, Bundle bundle) {
            bundle.setClassLoader(MediaBrowserCompat.class.getClassLoader());
            if (i == 0 && bundle != null && bundle.containsKey("media_item")) {
                bundle.getParcelable("media_item");
            }
        }
    }

    /* compiled from: ProGuard */
    public class MediaItem implements Parcelable {
        public static final Creator<MediaItem> CREATOR = new g();
        private final int a;
        private final MediaDescriptionCompat b;

        @Retention(RetentionPolicy.SOURCE)
        /* compiled from: ProGuard */
        public @interface Flags {
        }

        private MediaItem(Parcel parcel) {
            this.a = parcel.readInt();
            this.b = (MediaDescriptionCompat) MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.a);
            this.b.writeToParcel(parcel, i);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("MediaItem{");
            stringBuilder.append("mFlags=").append(this.a);
            stringBuilder.append(", mDescription=").append(this.b);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }
}
