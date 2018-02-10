package com.bumptech.glide.b.d.a;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.b.b.a.g;
import com.bumptech.glide.b.b.au;
import com.bumptech.glide.b.l;
import com.bumptech.glide.b.m;
import com.bumptech.glide.b.n;
import java.io.IOException;

/* compiled from: ProGuard */
public final class al implements n<ParcelFileDescriptor, Bitmap> {
    public static final l<Long> a = l.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", Long.valueOf(-1), new ai());
    public static final l<Integer> b = l.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", null, new aj());
    private static final ak c = new ak();
    private final g d;
    private final ak e;

    public final /* bridge */ /* synthetic */ au a(Object obj, int i, int i2, m mVar) throws IOException {
        return a((ParcelFileDescriptor) obj, mVar);
    }

    public al(g gVar) {
        this(gVar, c);
    }

    private al(g gVar, ak akVar) {
        this.d = gVar;
        this.e = akVar;
    }

    private au<Bitmap> a(ParcelFileDescriptor parcelFileDescriptor, m mVar) throws IOException {
        long longValue = ((Long) mVar.a(a)).longValue();
        if (longValue >= 0 || longValue == -1) {
            Integer num = (Integer) mVar.a(b);
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                Bitmap frameAtTime;
                mediaMetadataRetriever.setDataSource(parcelFileDescriptor.getFileDescriptor());
                if (longValue == -1) {
                    frameAtTime = mediaMetadataRetriever.getFrameAtTime();
                } else if (num == null) {
                    frameAtTime = mediaMetadataRetriever.getFrameAtTime(longValue);
                } else {
                    frameAtTime = mediaMetadataRetriever.getFrameAtTime(longValue, num.intValue());
                }
                mediaMetadataRetriever.release();
                parcelFileDescriptor.close();
                return e.a(frameAtTime, this.d);
            } catch (Throwable th) {
                mediaMetadataRetriever.release();
            }
        } else {
            throw new IllegalArgumentException("Requested frame must be non-negative, or DEFAULT_FRAME, given: " + longValue);
        }
    }

    private static boolean a(ParcelFileDescriptor parcelFileDescriptor) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(parcelFileDescriptor.getFileDescriptor());
            return true;
        } catch (RuntimeException e) {
            return false;
        } finally {
            mediaMetadataRetriever.release();
        }
    }
}
