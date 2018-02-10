package com.ucweb.common.util.f;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* compiled from: ProGuard */
public final class a {
    public static List<File> a(String str, boolean z) throws Throwable {
        Throwable th;
        List<File> arrayList = new ArrayList();
        File file = new File(str);
        Closeable zipInputStream;
        try {
            zipInputStream = new ZipInputStream(new FileInputStream(file));
            while (true) {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry != null) {
                    String name = nextEntry.getName();
                    if (name.contains("../")) {
                        throw new SecurityException("Invalid zip entry found!");
                    }
                    try {
                        if (com.ucweb.common.util.k.a.a(new File(str + File.separator + name), file)) {
                            if (nextEntry.isDirectory()) {
                                File file2 = new File(name.substring(0, name.length() - 1));
                                if (z) {
                                    arrayList.add(file2);
                                }
                            } else {
                                arrayList.add(new File(name));
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } else {
                    com.ucweb.common.util.o.a.a(zipInputStream);
                    return arrayList;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            zipInputStream = null;
            com.ucweb.common.util.o.a.a(zipInputStream);
            throw th;
        }
    }

    public static void a(String str, String str2) throws Throwable {
        Throwable th;
        Closeable closeable = null;
        try {
            Closeable fileOutputStream;
            Closeable zipInputStream = new ZipInputStream(new FileInputStream(str));
            while (true) {
                try {
                    ZipEntry nextEntry = zipInputStream.getNextEntry();
                    if (nextEntry == null) {
                        break;
                    }
                    String name = nextEntry.getName();
                    if (!name.contains("../")) {
                        if (!nextEntry.isDirectory()) {
                            File file = new File(str2 + File.separator + name);
                            if (!com.ucweb.common.util.k.a.a(file, new File(str2))) {
                                break;
                            }
                            if (!file.getParentFile().exists()) {
                                file.getParentFile().mkdirs();
                            }
                            file.createNewFile();
                            try {
                                fileOutputStream = new FileOutputStream(file);
                                try {
                                    byte[] bArr = new byte[1024];
                                    while (true) {
                                        int read = zipInputStream.read(bArr);
                                        if (read == -1) {
                                            break;
                                        }
                                        fileOutputStream.write(bArr, 0, read);
                                        fileOutputStream.flush();
                                    }
                                    com.ucweb.common.util.o.a.a(fileOutputStream);
                                } catch (Throwable th2) {
                                    th = th2;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                fileOutputStream = null;
                            }
                        } else {
                            new File(str2 + File.separator + name.substring(0, name.length() - 1)).mkdirs();
                        }
                    } else {
                        throw new SecurityException("Invalid zip entry found!");
                    }
                } catch (Throwable th4) {
                    th = th4;
                    closeable = zipInputStream;
                }
            }
            com.ucweb.common.util.o.a.a(zipInputStream);
            return;
            com.ucweb.common.util.o.a.a(fileOutputStream);
            throw th;
        } catch (Throwable th5) {
            th = th5;
            com.ucweb.common.util.o.a.a(closeable);
            throw th;
        }
    }
}
