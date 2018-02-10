package com.uc.base.wa.config;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.uc.base.wa.a.c;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/* compiled from: ProGuard */
public final class WaIpcHelper {
    public static BroadcastReceiver a;

    /* compiled from: ProGuard */
    public final class WaBroadcastReceiver extends BroadcastReceiver {
        private WaBroadcastReceiver() {
        }

        public final void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("com.UCMobile.intent.action.DISABLE_WA_CATEGORY")) {
                String a = WaIpcHelper.a();
                if (a != null) {
                    b.b(a);
                }
            }
        }
    }

    public static String a() {
        FileInputStream fileInputStream;
        Throwable th;
        String str = null;
        if (c.a() != null) {
            File file = new File(b.k() + "/dc");
            if (file.exists()) {
                try {
                    byte[] bArr = new byte[((int) file.length())];
                    fileInputStream = new FileInputStream(file);
                    try {
                        fileInputStream.read(bArr);
                        fileInputStream.close();
                        str = b.d(new String(bArr));
                        try {
                            fileInputStream.close();
                        } catch (IOException e) {
                        }
                    } catch (Exception e2) {
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e3) {
                            }
                        }
                        return str;
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e4) {
                            }
                        }
                        throw th;
                    }
                } catch (Exception e5) {
                    fileInputStream = str;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    return str;
                } catch (Throwable th3) {
                    Throwable th4 = th3;
                    fileInputStream = str;
                    th = th4;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw th;
                }
            }
        }
        return str;
    }
}
