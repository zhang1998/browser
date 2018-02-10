package com.uc.aerie.updater.b;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/* compiled from: ProGuard */
public final class a {
    public static byte[] a(File file) throws IOException {
        if (!file.exists()) {
            throw new IOException(file + ": file not found");
        } else if (!file.isFile()) {
            throw new IOException(file + ": not a file");
        } else if (file.canRead()) {
            long length = file.length();
            int i = (int) length;
            if (((long) i) != length) {
                throw new IOException(file + ": file too long");
            }
            byte[] bArr = new byte[i];
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                int i2 = 0;
                while (i > 0) {
                    int read = fileInputStream.read(bArr, i2, i);
                    if (read == -1) {
                        throw new IOException(file + ": unexpected EOF");
                    }
                    i2 += read;
                    i -= read;
                }
                fileInputStream.close();
                return bArr;
            } catch (Throwable e) {
                throw new IOException(file + ": trouble reading", e);
            }
        } else {
            throw new IOException(file + ": file not readable");
        }
    }

    public static boolean a(ZipFile zipFile, ZipEntry zipEntry, File file) {
        Closeable bufferedInputStream;
        Closeable bufferedOutputStream;
        Throwable e;
        Closeable closeable = null;
        try {
            bufferedInputStream = new BufferedInputStream(zipFile.getInputStream(zipEntry));
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                try {
                    String.format("try extract %s to %s", new Object[]{zipEntry.getName(), file.getName()});
                    byte[] bArr = new byte[16384];
                    while (true) {
                        int read = bufferedInputStream.read(bArr);
                        if (read != -1) {
                            bufferedOutputStream.write(bArr, 0, read);
                        } else {
                            SharePatchFileUtil.closeQuietly(bufferedInputStream);
                            SharePatchFileUtil.closeQuietly(bufferedOutputStream);
                            return true;
                        }
                    }
                } catch (IOException e2) {
                    e = e2;
                    closeable = bufferedInputStream;
                    try {
                        Log.e("FileUtil", String.format("extract zipFile:%s, zipEntry:%s, extractTo:%s exception.", new Object[]{zipFile.getName(), zipEntry.getName(), file.getName()}), e);
                        SharePatchFileUtil.closeQuietly(closeable);
                        SharePatchFileUtil.closeQuietly(bufferedOutputStream);
                        return false;
                    } catch (Throwable th) {
                        e = th;
                        bufferedInputStream = closeable;
                        SharePatchFileUtil.closeQuietly(bufferedInputStream);
                        SharePatchFileUtil.closeQuietly(bufferedOutputStream);
                        throw e;
                    }
                } catch (Throwable th2) {
                    e = th2;
                    SharePatchFileUtil.closeQuietly(bufferedInputStream);
                    SharePatchFileUtil.closeQuietly(bufferedOutputStream);
                    throw e;
                }
            } catch (IOException e3) {
                e = e3;
                bufferedOutputStream = null;
                closeable = bufferedInputStream;
                Log.e("FileUtil", String.format("extract zipFile:%s, zipEntry:%s, extractTo:%s exception.", new Object[]{zipFile.getName(), zipEntry.getName(), file.getName()}), e);
                SharePatchFileUtil.closeQuietly(closeable);
                SharePatchFileUtil.closeQuietly(bufferedOutputStream);
                return false;
            } catch (Throwable th3) {
                e = th3;
                bufferedOutputStream = null;
                SharePatchFileUtil.closeQuietly(bufferedInputStream);
                SharePatchFileUtil.closeQuietly(bufferedOutputStream);
                throw e;
            }
        } catch (IOException e4) {
            e = e4;
            bufferedOutputStream = null;
            Log.e("FileUtil", String.format("extract zipFile:%s, zipEntry:%s, extractTo:%s exception.", new Object[]{zipFile.getName(), zipEntry.getName(), file.getName()}), e);
            SharePatchFileUtil.closeQuietly(closeable);
            SharePatchFileUtil.closeQuietly(bufferedOutputStream);
            return false;
        } catch (Throwable th4) {
            e = th4;
            bufferedOutputStream = null;
            bufferedInputStream = null;
            SharePatchFileUtil.closeQuietly(bufferedInputStream);
            SharePatchFileUtil.closeQuietly(bufferedOutputStream);
            throw e;
        }
    }

    public static void a(File file, String str, ZipOutputStream zipOutputStream) throws Exception {
        int i = 0;
        if (!file.isFile()) {
            String[] list = file.list();
            if (list != null) {
                if (list.length <= 0) {
                    zipOutputStream.putNextEntry(new ZipEntry(str + File.separator));
                    zipOutputStream.closeEntry();
                }
                while (i < list.length) {
                    if (TextUtils.isEmpty(str)) {
                        a(new File(file, list[i]), list[i], zipOutputStream);
                    } else {
                        a(new File(file, list[i]), str + File.separator + list[i], zipOutputStream);
                    }
                    i++;
                }
            }
        } else if (!TextUtils.isEmpty(str)) {
            ZipEntry zipEntry = new ZipEntry(str);
            FileInputStream fileInputStream = new FileInputStream(file);
            zipOutputStream.putNextEntry(zipEntry);
            byte[] bArr = new byte[16384];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read != -1) {
                    zipOutputStream.write(bArr, 0, read);
                } else {
                    zipOutputStream.closeEntry();
                    return;
                }
            }
        }
    }
}
