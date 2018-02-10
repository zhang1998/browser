package com.uc.aerie.updater.a.a;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.uc.aerie.loader.AerieLoaderContext;
import com.uc.aerie.updater.b;
import com.uc.aerie.updater.e;
import java.io.File;
import java.util.HashMap;

/* compiled from: ProGuard */
public final class f implements b {
    public final int a(Context context, String str, String str2, String str3, String str4, String str5, String str6, e eVar) {
        File file = new File(str2);
        if (SharePatchFileUtil.isLegalFile(file)) {
            HashMap hashMap = new HashMap();
            if (SharePatchFileUtil.verifyAndGetPatchMetaInfo(context, file, hashMap)) {
                Long l;
                int a;
                long elapsedRealtime;
                long elapsedRealtime2;
                long elapsedRealtime3;
                Long valueOf = Long.valueOf(0);
                String str7 = (String) hashMap.get(ShareConstants.SO_META_FILE);
                if (TextUtils.isEmpty(str7)) {
                    l = valueOf;
                } else {
                    long elapsedRealtime4 = SystemClock.elapsedRealtime();
                    a = e.a(context.getApplicationInfo().nativeLibraryDir, str7, str, str6, file, com.uc.aerie.updater.b.b.a(context));
                    if (a != 0) {
                        Log.e("TinkerMerge", "lib recover fail. errorCode : " + a);
                        return a;
                    }
                    l = Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime4);
                }
                Long valueOf2 = Long.valueOf(0);
                String str8 = (String) hashMap.get(ShareConstants.RES_META_FILE);
                if (!TextUtils.isEmpty(str8)) {
                    elapsedRealtime = SystemClock.elapsedRealtime();
                    a = d.a(str8, str, str5, file);
                    if (a != 0) {
                        Log.e("TinkerMerge", "res recover fail. errorCode : " + a);
                        return a;
                    }
                    valueOf2 = Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime);
                }
                Long valueOf3 = Long.valueOf(0);
                Long valueOf4 = Long.valueOf(0);
                str8 = (String) hashMap.get(ShareConstants.DEX_META_FILE);
                if (TextUtils.isEmpty(str8)) {
                    valueOf = valueOf4;
                    valueOf4 = valueOf3;
                } else {
                    elapsedRealtime2 = SystemClock.elapsedRealtime();
                    a = a.a(str, str3, str8, file, AerieLoaderContext.isEnableClassN());
                    if (a != 0) {
                        Log.e("TinkerMerge", "merge dex fail. errorCode : " + a);
                        return a;
                    }
                    valueOf4 = Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime2);
                    elapsedRealtime3 = SystemClock.elapsedRealtime();
                    a = c.a(str3, str4);
                    if (a != 0) {
                        Log.e("TinkerMerge", "dex optimize fail. errorCode : " + a);
                        return a;
                    }
                    a = c.a();
                    if (a != 0) {
                        Log.e("TinkerMerge", "check dex opt file fail.");
                        return a;
                    }
                    valueOf = Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime3);
                }
                elapsedRealtime3 = valueOf4.longValue();
                elapsedRealtime2 = valueOf.longValue();
                long longValue = l.longValue();
                elapsedRealtime = valueOf2.longValue();
                eVar.a = elapsedRealtime3;
                eVar.b = elapsedRealtime2;
                eVar.c = longValue;
                eVar.d = elapsedRealtime;
                Log.w("TinkerMerge", "TinkerMerge merge : done, it is ok");
                return 0;
            }
            Log.w("TinkerMerge", "merge:verifyPatchMetaSignature fail.");
            return -502;
        }
        Log.e("TinkerMerge", "UpgradePatch tryPatch:patch file is not found, just return");
        return -501;
    }
}
