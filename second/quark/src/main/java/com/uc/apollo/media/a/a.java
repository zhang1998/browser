package com.uc.apollo.media.a;

import android.net.Uri;
import com.uc.apollo.impl.SettingsConst;
import java.util.ArrayList;
import java.util.Iterator;
import org.android.spdy.TnetStatusCode;

/* compiled from: ProGuard */
public class a {
    private static a a = null;
    private ArrayList<b> b = new ArrayList();
    private final int c = 128;

    public static a a() {
        if (a == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = new a();
                }
            }
        }
        return a;
    }

    public final b a(String str, Uri uri, int i) {
        if (!(uri == null || uri.toString().length() == 0 || str == null || str.length() == 0)) {
            int i2;
            if ((uri == null || uri.getScheme() != "file") && ((long) i) < 50000) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            if (i2 == 0) {
                if (str == null || str.length() == 0 || uri == null || uri.toString().length() == 0) {
                    return null;
                }
                b bVar;
                Iterator it = this.b.iterator();
                while (it.hasNext()) {
                    bVar = (b) it.next();
                    if (!bVar.a().equals(str) || !bVar.b().equals(uri.toString()) || bVar.c() != i) {
                        if (!bVar.a().equals(str) || !bVar.b().equals(uri.toString())) {
                            if (bVar.a().equals(str) && bVar.c() == i) {
                                bVar.a(uri);
                                break;
                            }
                        } else {
                            bVar.a(i);
                            break;
                        }
                    }
                    break;
                }
                bVar = null;
                if (bVar != null) {
                    return bVar;
                }
                bVar = new b(str, uri, i);
                this.b.add(bVar);
                while (128 < this.b.size()) {
                    this.b.remove(0);
                }
                return bVar;
            }
        }
        return null;
    }

    public static int a(b bVar) {
        if (bVar == null) {
            return -1;
        }
        int d = bVar.d();
        if (d <= SettingsConst.SDK_SETTINGS || d > bVar.c() - 5000) {
            return 0;
        }
        return d + TnetStatusCode.EASY_REASON_HANDSHAKE_ERROR;
    }
}
