package com.bumptech.glide.b.d.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.support.v4.os.e;
import android.util.Log;
import com.bumptech.glide.b.b.au;
import com.bumptech.glide.b.l;
import com.bumptech.glide.b.m;
import com.bumptech.glide.b.o;
import com.bumptech.glide.util.f;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: ProGuard */
public final class d implements o<Bitmap> {
    public static final l<Integer> a = l.a("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", Integer.valueOf(90));
    public static final l<CompressFormat> b = l.a("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat");

    private static boolean a(au<Bitmap> auVar, File file, m mVar) {
        CompressFormat compressFormat;
        boolean z;
        Throwable th;
        Bitmap bitmap = (Bitmap) auVar.b();
        CompressFormat compressFormat2 = (CompressFormat) mVar.a(b);
        if (compressFormat2 != null) {
            compressFormat = compressFormat2;
        } else if (bitmap.hasAlpha()) {
            compressFormat = CompressFormat.PNG;
        } else {
            compressFormat = CompressFormat.JPEG;
        }
        e.a("encode: [" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + compressFormat);
        try {
            long a = f.a();
            int intValue = ((Integer) mVar.a(a)).intValue();
            OutputStream fileOutputStream;
            try {
                fileOutputStream = new FileOutputStream(file);
                try {
                    bitmap.compress(compressFormat, intValue, fileOutputStream);
                    fileOutputStream.close();
                    try {
                        fileOutputStream.close();
                        z = true;
                    } catch (IOException e) {
                        z = true;
                    }
                } catch (IOException e2) {
                    try {
                        Log.isLoggable("BitmapEncoder", 3);
                        if (fileOutputStream == null) {
                            z = false;
                        } else {
                            try {
                                fileOutputStream.close();
                                z = false;
                            } catch (IOException e3) {
                                z = false;
                            }
                        }
                        if (Log.isLoggable("BitmapEncoder", 2)) {
                            new StringBuilder("Compressed with type: ").append(compressFormat).append(" of size ").append(com.bumptech.glide.util.l.a(bitmap)).append(" in ").append(f.a(a)).append(", options format: ").append(mVar.a(b)).append(", hasAlpha: ").append(bitmap.hasAlpha());
                        }
                        e.a();
                        return z;
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e4) {
                            }
                        }
                        throw th;
                    }
                }
            } catch (IOException e5) {
                fileOutputStream = null;
                Log.isLoggable("BitmapEncoder", 3);
                if (fileOutputStream == null) {
                    fileOutputStream.close();
                    z = false;
                } else {
                    z = false;
                }
                if (Log.isLoggable("BitmapEncoder", 2)) {
                    new StringBuilder("Compressed with type: ").append(compressFormat).append(" of size ").append(com.bumptech.glide.util.l.a(bitmap)).append(" in ").append(f.a(a)).append(", options format: ").append(mVar.a(b)).append(", hasAlpha: ").append(bitmap.hasAlpha());
                }
                e.a();
                return z;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw th;
            }
            if (Log.isLoggable("BitmapEncoder", 2)) {
                new StringBuilder("Compressed with type: ").append(compressFormat).append(" of size ").append(com.bumptech.glide.util.l.a(bitmap)).append(" in ").append(f.a(a)).append(", options format: ").append(mVar.a(b)).append(", hasAlpha: ").append(bitmap.hasAlpha());
            }
            e.a();
            return z;
        } catch (Throwable th4) {
            e.a();
        }
    }

    public final com.bumptech.glide.b.d a(m mVar) {
        return com.bumptech.glide.b.d.TRANSFORMED;
    }
}
