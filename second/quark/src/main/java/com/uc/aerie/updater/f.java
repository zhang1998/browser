package com.uc.aerie.updater;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.uc.aerie.updater.b.a;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/* compiled from: ProGuard */
final class f {
    HashMap<String, File> a = new HashMap();
    HashMap<String, e> b = new HashMap();
    private Context c;
    private l d;
    private ZipFile e;
    private j f;
    private File g;
    private File h;
    private File i;
    private HashMap<String, File> j = new HashMap();

    f(Context context, l lVar, ZipFile zipFile, j jVar, File file, File file2) {
        this.c = context;
        this.d = lVar;
        this.e = zipFile;
        this.f = jVar;
        this.g = file;
        this.h = file2;
        this.i = new File(file2, "zip_modules");
    }

    final void a() throws d {
        for (i iVar : this.f.c.values()) {
            ZipEntry entry = this.e.getEntry("modules/" + iVar.b);
            if (entry == null) {
                Log.e("aerieUpdate", String.format("get %s zipEntry fail.", new Object[]{iVar.b}));
                throw new d("get zipEntry fail.", -3, iVar.b, iVar.d, iVar.e);
            } else if (TextUtils.equals(iVar.b, "master")) {
                if (!this.g.exists()) {
                    SharePatchFileUtil.deleteDir(this.g);
                }
                this.g.mkdirs();
                File file = new File(this.g, this.f.b + ShareConstants.PATCH_SUFFIX);
                String absolutePath = this.g.getAbsolutePath();
                SharePatchFileUtil.ensureFileDirectory(file);
                if (a.a(this.e, entry, file)) {
                    b a = c.a(iVar.d, iVar.e);
                    if (a == null) {
                        Log.e("aerieUpdate", String.format("get %s algorithm fail.", new Object[]{iVar.d}));
                        throw new d("get algorithm fail.", -1, iVar.b, iVar.d, iVar.e);
                    }
                    String str = this.c.getApplicationInfo().sourceDir;
                    String str2 = absolutePath + File.separator + ShareConstants.DEX_PATH;
                    String str3 = absolutePath + File.separator + ShareConstants.DEFAULT_DEX_OPTIMIZE_PATH;
                    String str4 = absolutePath + File.separator + ShareConstants.RES_PATH;
                    e eVar = new e();
                    int a2 = a.a(this.c, str, file.getAbsolutePath(), str2, str3, str4, absolutePath, eVar);
                    if (a2 != 0) {
                        Log.e("aerieUpdate", "merge fail. module:" + iVar.b);
                        throw new d("merge module fail.", a2, iVar.b, iVar.d, iVar.e);
                    }
                    this.a.put(iVar.b, new File(absolutePath));
                    this.b.put(iVar.b, eVar);
                    new StringBuilder("merge : ").append(iVar.b).append(" success. ").append(eVar.toString());
                } else {
                    throw new d("extract master fail.", -2, iVar.b, iVar.d, iVar.e);
                }
            } else if (TextUtils.equals(iVar.d, "none")) {
                r1 = new File(this.i, iVar.b);
                SharePatchFileUtil.ensureFileDirectory(r1);
                if (a.a(this.e, entry, r1)) {
                    this.a.put(iVar.b, r1);
                    new StringBuilder("full modules extract success. name:").append(iVar.b);
                } else {
                    throw new d("extract module fail.", -2, iVar.b, iVar.d, iVar.e);
                }
            } else {
                r1 = new File(this.h, iVar.b + ShareConstants.PATCH_SUFFIX);
                new StringBuilder().append(this.h.getAbsolutePath()).append(File.separator).append(iVar.b);
                SharePatchFileUtil.ensureFileDirectory(r1);
                if (!a.a(this.e, entry, r1)) {
                    throw new d("extract module fail.", -2, iVar.b, iVar.d, iVar.e);
                } else if (c.a(iVar.d, iVar.e) == null) {
                    Log.e("aerieUpdate", String.format("get %s algorithm fail.", new Object[]{iVar.d}));
                    throw new d("get algorithm fail.", -1, iVar.b, iVar.d, iVar.e);
                } else {
                    Log.e("aerieUpdate", "get originalApkFile fail.");
                    throw new d("merge module fail.", -4, iVar.b, iVar.d, iVar.e);
                }
            }
        }
        if (!this.j.isEmpty()) {
            for (Entry entry2 : this.j.entrySet()) {
                File file2 = new File(this.i, (String) entry2.getKey());
                SharePatchFileUtil.ensureFileDirectory(file2);
                try {
                    String absolutePath2 = ((File) entry2.getValue()).getAbsolutePath();
                    ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(file2.getAbsolutePath()));
                    a.a(new File(absolutePath2), "", zipOutputStream);
                    zipOutputStream.finish();
                    zipOutputStream.close();
                    this.a.put(entry2.getKey(), file2);
                } catch (Exception e) {
                    throw new d("merge module fail.", -5, (String) entry2.getKey(), "", "");
                }
            }
        }
    }
}
