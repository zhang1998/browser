package com.loc;

/* compiled from: ProGuard */
public final class aa {
    String a;
    String b;
    String c;
    String d;
    String e;
    String f;
    String g;
    int h;
    int i;

    public aa(String str, String str2) {
        this.a = str;
        this.b = str2;
        try {
            String[] split = str.split("/");
            int length = split.length;
            if (length > 1) {
                this.c = split[length - 1];
                split = this.c.split("_");
                this.d = split[0];
                this.e = split[2];
                this.f = split[1];
                this.h = Integer.parseInt(split[3]);
                this.i = Integer.parseInt(split[4].split("\\.")[0]);
            }
        } catch (Throwable th) {
            es.a(th, "DexDownloadItem", "DexDownloadItem");
        }
    }
}
