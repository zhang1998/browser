package com.uc.weex.i;

import com.taobao.weex.m;
import java.io.File;
import java.io.FileInputStream;
import java.io.RandomAccessFile;

/* compiled from: ProGuard */
final class g implements Runnable {
    final /* synthetic */ h a;

    g(h hVar) {
        this.a = hVar;
    }

    public final void run() {
        RuntimeException runtimeException;
        File file;
        File file2;
        FileInputStream fileInputStream;
        RandomAccessFile randomAccessFile;
        try {
            String mapLibraryName = System.mapLibraryName(m.b());
            h hVar = this.a;
            if (!hVar.a && !hVar.b && !n.a(hVar.c) && d.b(mapLibraryName)) {
                File file3;
                File file4;
                String mapLibraryName2 = System.mapLibraryName("v8uc");
                String mapLibraryName3 = System.mapLibraryName("v9uc");
                String c = d.c(mapLibraryName2);
                if (c == null) {
                    mapLibraryName2 = System.mapLibraryName("v8uc.cr");
                    c = d.c(mapLibraryName2);
                    if (c == null) {
                        mapLibraryName2 = System.mapLibraryName("V8_UC");
                        mapLibraryName3 = System.mapLibraryName("V9_UC");
                        c = d.c(mapLibraryName2);
                    }
                }
                if (c != null && c.length() > 0) {
                    file3 = new File(c + File.separator + mapLibraryName2);
                    if (file3.exists()) {
                        file4 = new File(hVar.c + hVar.d);
                        if (file4.isDirectory() || file4.mkdirs()) {
                            file = new File(file4.getAbsolutePath() + File.separator + mapLibraryName3);
                            if (!file.exists()) {
                                n.a(file3, file);
                                j.a(file, mapLibraryName2, mapLibraryName3);
                                n.a(file, file3.lastModified());
                            }
                        }
                    } else {
                        throw new RuntimeException("clone v8 so not exist." + file3.getAbsolutePath());
                    }
                }
                c = d.c(mapLibraryName);
                if (c != null && c.length() > 0) {
                    file3 = new File(c + File.separator + mapLibraryName);
                    if (file3.exists()) {
                        file4 = new File(hVar.c + hVar.d);
                        if (file4.isDirectory() || file4.mkdirs()) {
                            file2 = new File(file4.getAbsolutePath() + File.separator + mapLibraryName);
                            if (!file2.exists()) {
                                n.a(file3, file2);
                                if (!(mapLibraryName2 == null || mapLibraryName3 == null || mapLibraryName2.length() != mapLibraryName3.length())) {
                                    fileInputStream = new FileInputStream(file2);
                                    randomAccessFile = new RandomAccessFile(file2.getAbsoluteFile(), "rw");
                                    j.a(fileInputStream.getChannel(), randomAccessFile.getChannel(), mapLibraryName2, mapLibraryName3);
                                    fileInputStream.close();
                                    randomAccessFile.close();
                                }
                                n.a(file2, file3.lastModified());
                            }
                        }
                    } else if (!new File(hVar.c + hVar.d + mapLibraryName).getAbsolutePath().equalsIgnoreCase(file3.getAbsolutePath())) {
                        throw new RuntimeException("The shared library weexv8 doesn't exist." + file3.getAbsolutePath());
                    }
                }
            }
        } catch (RuntimeException e) {
            com.uc.weex.g.b.b.a("null", "cloneStarkSoFiles() failed!", e.toString());
        } catch (Throwable th) {
            if (file2.exists()) {
                file2.delete();
            }
            runtimeException = new RuntimeException(th);
        }
    }
}
