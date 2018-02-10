package com.ucpro.feature.c.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.media.ExifInterface;
import com.alibaba.wireless.security.SecExceptionCode;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: ProGuard */
public final class c {
    public static b a(String str, String str2) {
        FileOutputStream fileOutputStream;
        Throwable th;
        FileOutputStream fileOutputStream2 = null;
        b bVar = new b();
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        int i = options.outHeight;
        int i2 = options.outWidth;
        if (i > SecExceptionCode.SEC_ERROR_PKG_VALID || i2 > 480) {
            i = Math.round(((float) i) / 800.0f);
            i2 = Math.round(((float) i2) / 480.0f);
            if (i >= i2) {
                i = i2;
            }
        } else {
            i = 1;
        }
        options.inSampleSize = i;
        options.inJustDecodeBounds = false;
        Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
        i2 = a(str);
        if (!(i2 == 0 || decodeFile == null)) {
            Matrix matrix = new Matrix();
            matrix.postRotate((float) i2);
            decodeFile = Bitmap.createBitmap(decodeFile, 0, 0, decodeFile.getWidth(), decodeFile.getHeight(), matrix, true);
        }
        File file = new File(str2);
        try {
            if (file.exists()) {
                file.delete();
            } else {
                file.getParentFile().mkdirs();
            }
            OutputStream fileOutputStream3 = new FileOutputStream(file);
            try {
                decodeFile.compress(CompressFormat.JPEG, 30, fileOutputStream3);
                bVar.b = "image/jpeg";
                bVar.a = file.getPath();
                try {
                    fileOutputStream3.close();
                } catch (IOException e) {
                }
                return bVar;
            } catch (Exception e2) {
                OutputStream outputStream = fileOutputStream3;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e3) {
                    }
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                OutputStream outputStream2 = fileOutputStream3;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e4) {
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            fileOutputStream = null;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
            throw th;
        }
    }

    private static int a(String str) {
        try {
            switch (new ExifInterface(str).getAttributeInt("Orientation", 1)) {
                case 3:
                    return 180;
                case 6:
                    return 90;
                case 8:
                    return 270;
                default:
                    return 0;
            }
        } catch (IOException e) {
            return 0;
        }
    }
}
