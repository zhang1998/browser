package com.tencent.tinker.loader.shareutil;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.tinker.loader.TinkerRuntimeException;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/* compiled from: ProGuard */
public class SharePatchInfo {
    public static final String CURRENT_VERSION = "currentVersion";
    public static final String FINGER_PRINT = "print";
    public static final int MAX_EXTRACT_ATTEMPTS = 2;
    public static final String NEW_VERSION_FILE_NAME = "currentFile";
    public static final String OLD_VERSION_FILE_NAME = "previousFile";
    public static final String PREVIOUS_VERSION = "previousVersion";
    private static final String TAG = "PatchInfo";
    public static final int TYPE_BASE = 3;
    public static final int TYPE_CURRENT = 0;
    public static final int TYPE_PREVIOUS = 2;
    public static final int TYPE_UPDATE = 1;
    public static final String UPDATE_VERSION = "updateVersion";
    public static final String UPDATE_VERSION_FILE_NAME = "updateFile";
    public String currentVersion;
    public String currentVersionFileName;
    public String fingerPrint;
    public String previousVersion;
    public String previousVersionFileName;
    public String updateVersion;
    public String updateVersionFileName;

    public SharePatchInfo(String str) {
        this("", "", "", "", "", "", str);
    }

    private SharePatchInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.previousVersion = str;
        this.currentVersion = str2;
        this.updateVersion = str3;
        this.previousVersionFileName = str4;
        this.currentVersionFileName = str5;
        this.updateVersionFileName = str6;
        this.fingerPrint = str7;
    }

    public static SharePatchInfo readAndCheckPropertyWithLock(File file, File file2) {
        ShareFileLockHelper fileLock;
        Throwable e;
        Throwable th;
        SharePatchInfo sharePatchInfo = null;
        if (file != null && file.exists() && file2 != null && file2.exists()) {
            File parentFile = file2.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            try {
                fileLock = ShareFileLockHelper.getFileLock(file2);
                try {
                    sharePatchInfo = readAndCheckProperty(file);
                    if (fileLock != null) {
                        try {
                            fileLock.close();
                        } catch (IOException e2) {
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    try {
                        throw new TinkerRuntimeException("readAndCheckPropertyWithLock fail", e);
                    } catch (Throwable th2) {
                        e = th2;
                        if (fileLock != null) {
                            try {
                                fileLock.close();
                            } catch (IOException e4) {
                            }
                        }
                        throw e;
                    }
                }
            } catch (Throwable e5) {
                th = e5;
                fileLock = null;
                e = th;
                throw new TinkerRuntimeException("readAndCheckPropertyWithLock fail", e);
            } catch (Throwable e52) {
                th = e52;
                fileLock = null;
                e = th;
                if (fileLock != null) {
                    fileLock.close();
                }
                throw e;
            }
        }
        return sharePatchInfo;
    }

    public static boolean rewritePatchInfoFileWithLock(File file, SharePatchInfo sharePatchInfo, File file2) {
        if (file == null || sharePatchInfo == null || file2 == null) {
            return false;
        }
        File parentFile = file2.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        ShareFileLockHelper shareFileLockHelper = null;
        try {
            shareFileLockHelper = ShareFileLockHelper.getFileLock(file2);
            boolean rewritePatchInfoFile = rewritePatchInfoFile(file, sharePatchInfo);
            if (shareFileLockHelper == null) {
                return rewritePatchInfoFile;
            }
            try {
                shareFileLockHelper.close();
                return rewritePatchInfoFile;
            } catch (IOException e) {
                return rewritePatchInfoFile;
            }
        } catch (Throwable e2) {
            throw new TinkerRuntimeException("rewritePatchInfoFileWithLock fail", e2);
        } catch (Throwable th) {
            if (shareFileLockHelper != null) {
                try {
                    shareFileLockHelper.close();
                } catch (IOException e3) {
                }
            }
        }
    }

    public void refreshByVersionChanged(int i, boolean z) {
        switch (i) {
            case 1:
                if (z) {
                    this.previousVersion = this.currentVersion;
                    this.previousVersionFileName = this.currentVersionFileName;
                } else {
                    this.previousVersion = "";
                    this.previousVersionFileName = "";
                }
                this.currentVersion = this.updateVersion;
                this.currentVersionFileName = this.updateVersionFileName;
                this.updateVersion = "";
                this.updateVersionFileName = "";
                return;
            case 2:
                if (z) {
                    this.currentVersion = this.previousVersion;
                    this.currentVersionFileName = this.previousVersionFileName;
                } else {
                    this.currentVersion = "";
                    this.currentVersionFileName = "";
                }
                this.previousVersion = "";
                this.previousVersionFileName = "";
                this.updateVersion = "";
                this.updateVersionFileName = "";
                return;
            case 3:
                this.previousVersion = "";
                this.previousVersionFileName = "";
                this.currentVersion = "";
                this.currentVersionFileName = "";
                this.updateVersion = "";
                this.updateVersionFileName = "";
                return;
            default:
                Log.e(TAG, "error change type:" + i);
                return;
        }
    }

    private static SharePatchInfo readAndCheckProperty(File file) {
        Closeable fileInputStream;
        Object e;
        String str;
        Closeable closeable;
        Throwable th;
        int i = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        Object obj = null;
        while (i < 2 && obj == null) {
            int i2 = i + 1;
            Properties properties = new Properties();
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    properties.load(fileInputStream);
                    str2 = properties.getProperty(PREVIOUS_VERSION);
                    str3 = properties.getProperty(CURRENT_VERSION);
                    str4 = properties.getProperty(UPDATE_VERSION);
                    str5 = properties.getProperty(OLD_VERSION_FILE_NAME);
                    str6 = properties.getProperty(NEW_VERSION_FILE_NAME);
                    str7 = properties.getProperty(UPDATE_VERSION_FILE_NAME);
                    str8 = properties.getProperty(FINGER_PRINT);
                    SharePatchFileUtil.closeQuietly(fileInputStream);
                } catch (IOException e2) {
                    e = e2;
                    Closeable closeable2 = fileInputStream;
                    str = str2;
                    closeable = closeable2;
                    try {
                        Log.e(TAG, "read property failed, e:" + e);
                        SharePatchFileUtil.closeQuietly(closeable);
                        str2 = str;
                        if (str2 != null) {
                        }
                        i = i2;
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = closeable;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (IOException e3) {
                e = e3;
                str = str2;
                closeable = null;
                Log.e(TAG, "read property failed, e:" + e);
                SharePatchFileUtil.closeQuietly(closeable);
                str2 = str;
                if (str2 != null) {
                }
                i = i2;
            } catch (Throwable th4) {
                th = th4;
                fileInputStream = null;
            }
            if (str2 != null || r2 == null || r3 == null || r4 == null || r5 == null || r6 == null || r7 == null) {
                i = i2;
            } else {
                obj = 1;
                i = i2;
            }
        }
        if (obj != null) {
            return new SharePatchInfo(str2, str3, str4, str5, str6, str7, str8);
        }
        return null;
        SharePatchFileUtil.closeQuietly(fileInputStream);
        throw th;
    }

    private static boolean rewritePatchInfoFile(File file, SharePatchInfo sharePatchInfo) {
        Closeable fileOutputStream;
        SharePatchInfo readAndCheckProperty;
        boolean z;
        Throwable th;
        if (file == null || sharePatchInfo == null) {
            return false;
        }
        if (ShareTinkerInternals.isNullOrNil(sharePatchInfo.fingerPrint)) {
            sharePatchInfo.fingerPrint = Build.FINGERPRINT;
        }
        new StringBuilder("rewritePatchInfoFile file path:").append(file.getAbsolutePath()).append(" , oldVer:").append(sharePatchInfo.previousVersion).append(", newVer:").append(sharePatchInfo.currentVersion).append(", newInstallVer:").append(sharePatchInfo.updateVersion).append(", previousVersionFileName:").append(sharePatchInfo.previousVersionFileName).append(", currentVersionFileName:").append(sharePatchInfo.currentVersionFileName).append(", updateVersionFileName:").append(sharePatchInfo.updateVersionFileName).append(", fingerprint:").append(sharePatchInfo.fingerPrint);
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        int i = 0;
        boolean z2 = false;
        while (i < 2 && !r3) {
            int i2 = i + 1;
            Properties properties = new Properties();
            properties.put(PREVIOUS_VERSION, sharePatchInfo.previousVersion);
            properties.put(CURRENT_VERSION, sharePatchInfo.currentVersion);
            properties.put(UPDATE_VERSION, sharePatchInfo.updateVersion);
            properties.put(OLD_VERSION_FILE_NAME, sharePatchInfo.previousVersionFileName);
            properties.put(NEW_VERSION_FILE_NAME, sharePatchInfo.currentVersionFileName);
            properties.put(UPDATE_VERSION_FILE_NAME, sharePatchInfo.updateVersionFileName);
            properties.put(FINGER_PRINT, sharePatchInfo.fingerPrint);
            try {
                fileOutputStream = new FileOutputStream(file, false);
                try {
                    properties.store(fileOutputStream, "from new version:" + sharePatchInfo.currentVersion + " to update version:" + sharePatchInfo.updateVersion);
                    SharePatchFileUtil.closeQuietly(fileOutputStream);
                } catch (Exception e) {
                    SharePatchFileUtil.closeQuietly(fileOutputStream);
                    readAndCheckProperty = readAndCheckProperty(file);
                    if (readAndCheckProperty == null) {
                    }
                    z = false;
                    if (z) {
                        z2 = z;
                        i = i2;
                    } else {
                        file.delete();
                        return false;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e2) {
                fileOutputStream = null;
                SharePatchFileUtil.closeQuietly(fileOutputStream);
                readAndCheckProperty = readAndCheckProperty(file);
                if (readAndCheckProperty == null) {
                }
                z = false;
                if (z) {
                    z2 = z;
                    i = i2;
                } else {
                    file.delete();
                    return false;
                }
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
            }
            readAndCheckProperty = readAndCheckProperty(file);
            if (readAndCheckProperty == null && TextUtils.equals(readAndCheckProperty.previousVersion, sharePatchInfo.previousVersion) && TextUtils.equals(readAndCheckProperty.currentVersion, sharePatchInfo.currentVersion) && TextUtils.equals(readAndCheckProperty.updateVersion, sharePatchInfo.updateVersion) && TextUtils.equals(readAndCheckProperty.previousVersionFileName, sharePatchInfo.previousVersionFileName) && TextUtils.equals(readAndCheckProperty.currentVersionFileName, sharePatchInfo.currentVersionFileName) && TextUtils.equals(readAndCheckProperty.updateVersionFileName, sharePatchInfo.updateVersionFileName)) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                file.delete();
                return false;
            }
            z2 = z;
            i = i2;
        }
        return true;
        SharePatchFileUtil.closeQuietly(fileOutputStream);
        throw th;
    }
}
