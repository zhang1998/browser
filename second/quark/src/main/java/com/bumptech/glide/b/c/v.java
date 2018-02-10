package com.bumptech.glide.b.c;

import android.os.ParcelFileDescriptor;
import com.UCMobile.Apollo.MediaPlayer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/* compiled from: ProGuard */
final class v implements y<ParcelFileDescriptor> {
    v() {
    }

    public final /* synthetic */ void a(Object obj) throws IOException {
        ((ParcelFileDescriptor) obj).close();
    }

    public final Class<ParcelFileDescriptor> a() {
        return ParcelFileDescriptor.class;
    }

    public final /* synthetic */ Object a(File file) throws FileNotFoundException {
        return ParcelFileDescriptor.open(file, MediaPlayer.MEDIA_ERROR_UNKNOWN);
    }
}
