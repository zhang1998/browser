package android.support.v4.media;

import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.media.MediaDescription.Builder;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;

/* compiled from: ProGuard */
public final class MediaDescriptionCompat implements Parcelable {
    public static final Creator<MediaDescriptionCompat> CREATOR = new i();
    private final String a;
    private final CharSequence b;
    private final CharSequence c;
    private final CharSequence d;
    private final Bitmap e;
    private final Uri f;
    private final Bundle g;
    private final Uri h;
    private Object i;

    private MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.a = str;
        this.b = charSequence;
        this.c = charSequence2;
        this.d = charSequence3;
        this.e = bitmap;
        this.f = uri;
        this.g = bundle;
        this.h = uri2;
    }

    private MediaDescriptionCompat(Parcel parcel) {
        this.a = parcel.readString();
        this.b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.c = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.d = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.e = (Bitmap) parcel.readParcelable(null);
        this.f = (Uri) parcel.readParcelable(null);
        this.g = parcel.readBundle();
        this.h = (Uri) parcel.readParcelable(null);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        if (VERSION.SDK_INT < 21) {
            parcel.writeString(this.a);
            TextUtils.writeToParcel(this.b, parcel, i);
            TextUtils.writeToParcel(this.c, parcel, i);
            TextUtils.writeToParcel(this.d, parcel, i);
            parcel.writeParcelable(this.e, i);
            parcel.writeParcelable(this.f, i);
            parcel.writeBundle(this.g);
            parcel.writeParcelable(this.h, i);
            return;
        }
        Object obj;
        if (this.i != null || VERSION.SDK_INT < 21) {
            obj = this.i;
        } else {
            Bundle bundle;
            Builder builder = new Builder();
            builder.setMediaId(this.a);
            builder.setTitle(this.b);
            builder.setSubtitle(this.c);
            builder.setDescription(this.d);
            builder.setIconBitmap(this.e);
            builder.setIconUri(this.f);
            Bundle bundle2 = this.g;
            if (VERSION.SDK_INT >= 23 || this.h == null) {
                bundle = bundle2;
            } else {
                if (bundle2 == null) {
                    bundle2 = new Bundle();
                    bundle2.putBoolean("android.support.v4.media.description.NULL_BUNDLE_FLAG", true);
                }
                bundle2.putParcelable("android.support.v4.media.description.MEDIA_URI", this.h);
                bundle = bundle2;
            }
            builder.setExtras(bundle);
            if (VERSION.SDK_INT >= 23) {
                builder.setMediaUri(this.h);
            }
            this.i = builder.build();
            obj = this.i;
        }
        ((MediaDescription) obj).writeToParcel(parcel, i);
    }

    public final String toString() {
        return this.b + ", " + this.c + ", " + this.d;
    }

    public static MediaDescriptionCompat a(Object obj) {
        if (obj == null || VERSION.SDK_INT < 21) {
            return null;
        }
        Uri uri;
        Bundle bundle;
        MediaDescriptionCompat mediaDescriptionCompat;
        r rVar = new r();
        rVar.a = ((MediaDescription) obj).getMediaId();
        rVar.b = ((MediaDescription) obj).getTitle();
        rVar.c = ((MediaDescription) obj).getSubtitle();
        rVar.d = ((MediaDescription) obj).getDescription();
        rVar.e = ((MediaDescription) obj).getIconBitmap();
        rVar.f = ((MediaDescription) obj).getIconUri();
        Bundle extras = ((MediaDescription) obj).getExtras();
        if (extras == null) {
            uri = null;
        } else {
            uri = (Uri) extras.getParcelable("android.support.v4.media.description.MEDIA_URI");
        }
        if (uri != null) {
            if (extras.containsKey("android.support.v4.media.description.NULL_BUNDLE_FLAG") && extras.size() == 2) {
                bundle = null;
                rVar.g = bundle;
                if (uri != null) {
                    rVar.h = uri;
                } else if (VERSION.SDK_INT >= 23) {
                    rVar.h = ((MediaDescription) obj).getMediaUri();
                }
                mediaDescriptionCompat = new MediaDescriptionCompat(rVar.a, rVar.b, rVar.c, rVar.d, rVar.e, rVar.f, rVar.g, rVar.h);
                mediaDescriptionCompat.i = obj;
                return mediaDescriptionCompat;
            }
            extras.remove("android.support.v4.media.description.MEDIA_URI");
            extras.remove("android.support.v4.media.description.NULL_BUNDLE_FLAG");
        }
        bundle = extras;
        rVar.g = bundle;
        if (uri != null) {
            rVar.h = uri;
        } else if (VERSION.SDK_INT >= 23) {
            rVar.h = ((MediaDescription) obj).getMediaUri();
        }
        mediaDescriptionCompat = new MediaDescriptionCompat(rVar.a, rVar.b, rVar.c, rVar.d, rVar.e, rVar.f, rVar.g, rVar.h);
        mediaDescriptionCompat.i = obj;
        return mediaDescriptionCompat;
    }
}
