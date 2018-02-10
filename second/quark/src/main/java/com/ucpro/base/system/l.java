package com.ucpro.base.system;

import com.ucweb.common.util.d;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public final class l {
    public static List<String> a() {
        int i = 0;
        String[] strArr = new String[]{"/native/", "/lib"};
        List<String> arrayList = new ArrayList();
        while (i < 2) {
            arrayList.add(d.a().getApplicationInfo().dataDir + strArr[i]);
            i++;
        }
        try {
            arrayList.add(d.a().getPackageManager().getApplicationInfo(d.a().getPackageName(), 1024).nativeLibraryDir);
        } catch (Exception e) {
        }
        return arrayList;
    }
}
