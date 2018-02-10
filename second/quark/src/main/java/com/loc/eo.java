package com.loc;

import com.uc.aerie.loader.stable.AerieLoaderConfig;

/* compiled from: ProGuard */
public final class eo {
    String a;
    String b;
    String c;
    boolean d = true;
    String e = AerieLoaderConfig.UPDATER_TYPE_STANDARD;
    String[] f = null;

    public eo(String str, String str2, String str3) {
        this.a = str2;
        this.c = str3;
        this.b = str;
    }

    public final eo a(String[] strArr) {
        this.f = (String[]) strArr.clone();
        return this;
    }

    public final ep a() throws dw {
        if (this.f != null) {
            return new ep();
        }
        throw new dw("sdk packages is null");
    }
}
