package com.uc.apollo.media.impl;

import android.util.Log;
import com.UCMobile.Apollo.Apollo;
import com.UCMobile.Apollo.Global;
import com.UCMobile.Apollo.MediaPlayer;
import com.uc.apollo.Settings;
import com.uc.apollo.media.CodecLibUpgrader;
import com.uc.apollo.util.f;
import java.io.File;

/* compiled from: ProGuard */
public final class a {
    private static final String a = (e.a + "ApolloLibChecker");
    private static int b = 0;
    private static int c = -1;
    private static String d;

    /* compiled from: ProGuard */
    final class a {
        public String a;
        public boolean b;

        a(String str, boolean z) {
            this.a = str;
            this.b = z;
        }
    }

    public static int a() {
        return c;
    }

    private static void a(int i, int i2) {
        c = ((i + 1) * 10) + i2;
    }

    public static String b() {
        return d;
    }

    public static boolean c() {
        if (b == 0) {
            if (f.a(Global.gApolloSoPath) && f.b(CodecLibUpgrader.getApolloSoPath())) {
                Global.gApolloSoPath = CodecLibUpgrader.getApolloSoPath();
            }
            a[] aVarArr = new a[]{new a(Global.gApolloSoPath, false), new a(Settings.getContext().getApplicationInfo().dataDir + "/lib", true)};
            for (int i = 0; i < 2; i++) {
                a aVar = aVarArr[i];
                if (!f.a(aVar.a)) {
                    String str;
                    if (aVar.a.endsWith("/")) {
                        str = aVar.a + "libffmpeg.so";
                    } else {
                        str = aVar.a + "/libffmpeg.so";
                    }
                    File file = new File(str);
                    if (!file.exists() || file.isDirectory()) {
                        a(i, 1);
                    } else {
                        try {
                            System.load(str);
                            b = 2;
                            Apollo.setLoadLibraryFromAppLibPath(aVar.b);
                            if (!MediaPlayer.globalInitialization(r6)) {
                                a(i, 3);
                                d = MediaPlayer.globalInitializationFailDesc();
                                break;
                            }
                            b bVar = new b();
                            new StringBuilder("apollo version ").append(bVar);
                            com.uc.apollo.a.E();
                            int i2 = bVar.a() ? 1 : 2;
                            b = i2;
                            if (i2 == 1) {
                                a(i, 0);
                            } else {
                                a(i, 5);
                                d = bVar.toString();
                            }
                            if (b != 1) {
                                Log.w(a, "unsupport apollo version " + bVar);
                            }
                        } catch (Throwable th) {
                            b = 0;
                            new StringBuilder("System.load(").append(str).append(") exception: ").append(th);
                            a(i, 2);
                            d = th.getMessage() + ";" + th.getCause();
                        }
                    }
                }
            }
            if (b == 1) {
                return true;
            }
            return false;
        } else if (b == 1) {
            return true;
        } else {
            return false;
        }
    }
}
