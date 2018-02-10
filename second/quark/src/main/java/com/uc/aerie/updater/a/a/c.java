package com.uc.aerie.updater.a.a;

import android.os.Build.VERSION;
import android.util.Log;
import com.tencent.tinker.loader.TinkerDexOptimizer;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.ShareElfFile;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/* compiled from: ProGuard */
final class c {
    private static ThreadLocal<ArrayList<File>> a = new ThreadLocal();

    public static int a(String str, String str2) {
        Collection arrayList = new ArrayList();
        for (File file : new File(str).listFiles()) {
            if (file.getName().endsWith(ShareConstants.DEX_SUFFIX) || file.getName().equalsIgnoreCase(ShareConstants.CLASS_N_APK_NAME)) {
                arrayList.add(file);
            }
        }
        a.set(new ArrayList());
        if (!arrayList.isEmpty()) {
            File file2 = new File(str2);
            if (file2.exists() || file2.mkdirs()) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((ArrayList) a.get()).add(new File(SharePatchFileUtil.optimizedPathFor((File) it.next(), file2)));
                }
                String.format("patch recover, try to optimize dex file count:%d, optimizeDexDirectory:%s", new Object[]{Integer.valueOf(arrayList.size()), str2});
                List vector = new Vector();
                TinkerDexOptimizer.optimizeAll(arrayList, file2, new b(vector, new Throwable[1]));
                if (!vector.isEmpty()) {
                    return -202;
                }
            }
            Log.w("DexOptimizeInternal", "patch recover, make optimizeDexDirectoryFile fail");
            return -201;
        }
        return 0;
    }

    protected static int a() {
        ArrayList arrayList = (ArrayList) a.get();
        if (arrayList.isEmpty()) {
            return 0;
        }
        int size = arrayList.size() * 8;
        if (size > 30) {
            size = 30;
        }
        String.format("dex count: %d, final wait time: %d", new Object[]{Integer.valueOf(arrayList.size()), Integer.valueOf(size)});
        for (int i = 0; i < size; i++) {
            int i2;
            int i3 = i + 1;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (!SharePatchFileUtil.isLegalFile((File) it.next())) {
                    Log.e("DexOptimizeInternal", String.format("parallel dex optimizer file %s is not exist, just wait %d times", new Object[]{((File) it.next()).getName(), Integer.valueOf(i3)}));
                    i2 = 0;
                    break;
                }
            }
            i2 = 1;
            if (i2 == 0) {
                try {
                    Thread.sleep(20000);
                } catch (InterruptedException e) {
                    Log.e("DexOptimizeInternal", "thread sleep InterruptedException e:" + e);
                }
            }
        }
        List arrayList2 = new ArrayList();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            File file = (File) it2.next();
            String.format("check dex optimizer file %s, size %d", new Object[]{file.getName(), Long.valueOf(file.length())});
            if (!SharePatchFileUtil.isLegalFile(file)) {
                Log.e("DexOptimizeInternal", String.format("final parallel dex optimizer file %s is not exist, return false", new Object[]{file.getName()}));
                arrayList2.add(file);
            }
        }
        if (!arrayList2.isEmpty()) {
            return -203;
        }
        if (VERSION.SDK_INT >= 21) {
            Iterator it3 = arrayList.iterator();
            while (it3.hasNext()) {
                File file2 = (File) it3.next();
                String.format("check dex optimizer file format: %s, size %d", new Object[]{file2.getName(), Long.valueOf(file2.length())});
                try {
                    if (ShareElfFile.getFileTypeByMagic(file2) == 1) {
                        try {
                            try {
                                new ShareElfFile(file2).close();
                            } catch (IOException e2) {
                            }
                        } catch (Throwable th) {
                            Log.e("DexOptimizeInternal", String.format("final parallel dex optimizer file %s is not elf format, return false", new Object[]{file2.getName()}));
                            arrayList2.add(file2);
                        }
                    } else {
                        continue;
                    }
                } catch (IOException e3) {
                }
            }
            if (!arrayList2.isEmpty()) {
                return -204;
            }
        }
        return 0;
    }
}
