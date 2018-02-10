package com.uc.framework.resources;

import android.content.res.AssetManager;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: ProGuard */
final class a {
    static AssetManager a;
    private static a b;

    private a() {
    }

    static a a() {
        if (a == null) {
            throw new RuntimeException("Please invoke initAssetsFile function before use getInstance!");
        }
        if (b == null) {
            b = new a();
        }
        return b;
    }

    static InputStream a(String str) {
        try {
            return a.open(str);
        } catch (FileNotFoundException e) {
            return null;
        } catch (Exception e2) {
            return null;
        }
    }

    static boolean b(String str) {
        try {
            InputStream open = a.open(str);
            if (open != null) {
                open.close();
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
