package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: ProGuard */
public final class RatingCompat implements Parcelable {
    public static final Creator<RatingCompat> CREATOR = new v();
    private final int a;
    private final float b;

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: ProGuard */
    public @interface StarStyle {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: ProGuard */
    public @interface Style {
    }

    private RatingCompat(int i, float f) {
        this.a = i;
        this.b = f;
    }

    public final String toString() {
        return "Rating:style=" + this.a + " rating=" + (this.b < 0.0f ? "unrated" : String.valueOf(this.b));
    }

    public final int describeContents() {
        return this.a;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeFloat(this.b);
    }
}
