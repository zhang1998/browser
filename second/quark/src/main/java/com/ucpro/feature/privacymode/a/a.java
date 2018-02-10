package com.ucpro.feature.privacymode.a;

import com.ucpro.c.c;
import com.ucweb.common.util.d;
import com.yunos.faceunlock.facemanager.RegisteredFaceManager;
import java.io.File;

/* compiled from: ProGuard */
public final class a {
    public static boolean a() {
        return RegisteredFaceManager.getInstance(d.a()).getRegisteredCount() > 0;
    }

    public static String b() {
        return c.a().getAbsolutePath() + "/faceres/";
    }

    public static String c() {
        return b() + "MN.mid";
    }

    public static String d() {
        return b() + "Face.mid";
    }

    private static String a(String str) {
        return new File(b() + str).getAbsolutePath();
    }

    public static boolean e() {
        File file = new File(a("MN.mid"));
        File file2 = new File(a("Face.mid"));
        return file.exists() && file.isFile() && file2.exists() && file2.isFile();
    }
}
