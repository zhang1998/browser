package com.loc;

import android.content.Context;
import android.text.TextUtils;
import com.uc.crashsdk.export.LogType;
import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* compiled from: ProGuard */
public final class bu {
    String a;
    private Context b;
    private String c;
    private String d;
    private String e;

    public bu(Context context, String str, String str2, String str3) throws dw {
        if (TextUtils.isEmpty(str3) || str3.length() > LogType.UNEXP) {
            throw new dw("无效的参数 - IllegalArgumentException");
        }
        this.b = context.getApplicationContext();
        this.d = str;
        this.e = str2;
        this.c = str3;
    }

    public final byte[] a() {
        Throwable th;
        Throwable th2;
        byte[] bArr = new byte[0];
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byte[] bArr2;
                eq.a(byteArrayOutputStream, this.d);
                eq.a(byteArrayOutputStream, this.e);
                eq.a(byteArrayOutputStream, this.c);
                eq.a(byteArrayOutputStream, String.valueOf(ei.m(this.b)));
                new SimpleDateFormat("SSS").format(new Date());
                int i = Calendar.getInstance().get(14);
                byteArrayOutputStream.write(new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)});
                Object obj = this.a;
                if (TextUtils.isEmpty(obj)) {
                    bArr2 = new byte[]{(byte) 0, (byte) 0};
                } else {
                    byte length = (byte) (obj.length() % LogType.UNEXP);
                    bArr2 = new byte[]{(byte) (obj.length() / LogType.UNEXP), length};
                }
                byteArrayOutputStream.write(bArr2);
                byteArrayOutputStream.write(eq.a(this.a));
                bArr = byteArrayOutputStream.toByteArray();
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th3) {
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                try {
                    es.a(th, "StatisticsEntity", "toDatas");
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    return bArr;
                } catch (Throwable th5) {
                    th2 = th5;
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Throwable th6) {
                        }
                    }
                    throw th2;
                }
            }
        } catch (Throwable th7) {
            th2 = th7;
            byteArrayOutputStream = null;
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            throw th2;
        }
        return bArr;
    }
}
