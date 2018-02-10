package com.uc.webview.export.internal.utility;

import android.content.Context;
import android.net.TrafficStats;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.system.Os;
import android.util.Pair;
import com.alibaba.wireless.security.SecExceptionCode;
import com.uc.apollo.impl.SettingsConst;
import com.uc.webview.export.Build;
import com.uc.webview.export.cyclone.UCCyclone;
import com.uc.webview.export.cyclone.UCElapseTime;
import com.uc.webview.export.cyclone.UCKnownException;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.SDKFactory;
import com.uc.webview.export.internal.setup.UCMPackageInfo;
import com.uc.webview.export.internal.setup.UCSetupException;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: ProGuard */
public final class d {
    public static int a = 5000;
    public static int b = 5000;
    public static boolean c = false;
    public static String d = "3032";
    private static final Long e = Long.valueOf(10000);
    private static final HashMap<String, Pair<Long, Object>> f = new HashMap();
    private static final Map<String, String> g = new e();
    private static final String[] h = new String[]{d};
    private static boolean i = false;
    private static boolean j = false;

    /* compiled from: ProGuard */
    public final class a {
        private static String a = null;

        public static String a(Context context) {
            if (!d.a(a)) {
                return a;
            }
            if (SDKFactory.c == null || context == null) {
                return null;
            }
            try {
                Class cls = Class.forName("com.ta.utdid2.device.UTDevice", true, SDKFactory.c);
                String str = (String) ReflectionUtil.invoke(cls, "getUtdid", new Class[]{Context.class}, new Object[]{context});
                Log.d("Utils", "getUtdidBySdk time: " + (System.currentTimeMillis() - System.currentTimeMillis()) + " milliseconds");
                Log.d("Utils", "getUtdidBySdk utdid: " + str);
                if (d.a(str)) {
                    return str;
                }
                a = str;
                return str;
            } catch (Throwable th) {
                Log.d("Utils", "getUtdidBySdk cd exception : " + th);
                return null;
            }
        }
    }

    public static boolean a(String str) {
        return str == null || str.length() == 0;
    }

    public static String a() {
        try {
            File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(new f());
            Log.d("Utils", "CPU Count: " + listFiles.length);
            return String.valueOf(listFiles.length);
        } catch (Throwable th) {
            Log.d("Utils", "CPU Count: Failed.");
            return SettingsConst.TRUE;
        }
    }

    public static String b() {
        return String.valueOf(b(d("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq").trim()));
    }

    private static String d(String str) {
        Closeable fileReader;
        Closeable bufferedReader;
        Throwable th;
        Closeable closeable = null;
        String str2 = "";
        try {
            fileReader = new FileReader(str);
            try {
                bufferedReader = new BufferedReader(fileReader);
                try {
                    StringBuilder stringBuilder = new StringBuilder();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        stringBuilder.append(readLine);
                    }
                    str2 = stringBuilder.toString();
                    UCCyclone.close(fileReader);
                    UCCyclone.close(bufferedReader);
                } catch (Throwable th2) {
                    th = th2;
                    if (fileReader != null) {
                        UCCyclone.close(fileReader);
                    }
                    if (bufferedReader != null) {
                        UCCyclone.close(bufferedReader);
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
                if (fileReader != null) {
                    UCCyclone.close(fileReader);
                }
                if (bufferedReader != null) {
                    UCCyclone.close(bufferedReader);
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
            fileReader = null;
            if (fileReader != null) {
                UCCyclone.close(fileReader);
            }
            if (bufferedReader != null) {
                UCCyclone.close(bufferedReader);
            }
            throw th;
        }
        return str2;
    }

    public static boolean a(Boolean bool) {
        return bool == null || !bool.booleanValue();
    }

    private static void a(File file, File file2) throws IOException {
        FileChannel channel;
        Throwable th;
        FileChannel fileChannel = null;
        try {
            FileChannel channel2;
            channel = new FileInputStream(file).getChannel();
            try {
                channel2 = new FileOutputStream(file2).getChannel();
            } catch (Throwable th2) {
                th = th2;
                fileChannel = channel;
                channel = null;
                if (fileChannel != null) {
                    try {
                        fileChannel.close();
                    } catch (Throwable th3) {
                    }
                }
                if (channel != null) {
                    try {
                        channel.close();
                    } catch (Throwable th4) {
                    }
                }
                throw th;
            }
            try {
                if (channel2.transferFrom(channel, 0, channel.size()) != file.length()) {
                    file2.delete();
                    throw new RuntimeException("Size mismatch.");
                }
                if (channel != null) {
                    try {
                        channel.close();
                    } catch (Throwable th5) {
                    }
                }
                if (channel2 != null) {
                    try {
                        channel2.close();
                    } catch (Throwable th6) {
                    }
                }
            } catch (Throwable th7) {
                Throwable th8 = th7;
                fileChannel = channel;
                channel = channel2;
                th = th8;
                if (fileChannel != null) {
                    fileChannel.close();
                }
                if (channel != null) {
                    channel.close();
                }
                throw th;
            }
        } catch (Throwable th9) {
            th = th9;
            channel = null;
            if (fileChannel != null) {
                fileChannel.close();
            }
            if (channel != null) {
                channel.close();
            }
            throw th;
        }
    }

    public static File a(File file, File file2, File file3, boolean z) {
        File file4;
        if (file2.exists() && !z) {
            return file2;
        }
        if (file3.exists() && file.length() == file3.length() && file.lastModified() == file3.lastModified()) {
            return file3;
        }
        File file5 = new File(file3.getParent(), "bak_" + file3.getName());
        if (file5.exists()) {
            if (file.length() == file5.length()) {
                file5.setLastModified(file.lastModified());
                if (file5.lastModified() != file.lastModified()) {
                    return file5;
                }
            }
            file5.delete();
        }
        if (z) {
            throw new Throwable();
        }
        if (VERSION.SDK_INT >= 21) {
            try {
                Os.symlink(file.getAbsolutePath(), file2.getAbsolutePath());
                return file2;
            } catch (Exception e) {
            }
        }
        try {
            Process exec = Runtime.getRuntime().exec("ln -s " + file.getAbsolutePath() + " " + file2.getAbsolutePath());
            UCElapseTime uCElapseTime = new UCElapseTime();
            while (uCElapseTime.getMilis() < 500) {
                try {
                    if (exec.exitValue() != 0) {
                        throw new Throwable();
                    }
                } catch (IllegalThreadStateException e2) {
                }
            }
            if (!file.getName().equals("libar_pak_kr_uc.so")) {
                return file2;
            }
            new StringBuilder("linkOrCopyFile Time:").append(uCElapseTime.getMilis());
            return file2;
        } catch (Throwable th) {
            UCSetupException uCSetupException = new UCSetupException(1007, th);
        }
    }

    public static File[] a(File[] fileArr, File[] fileArr2, File[] fileArr3) {
        int i;
        Object obj = 1;
        File[] fileArr4 = new File[fileArr.length];
        try {
            if (VERSION.SDK_INT >= 21) {
                for (i = 0; i < fileArr.length; i++) {
                    if (fileArr2[i].exists()) {
                        fileArr4[i] = fileArr2[i];
                    } else {
                        Os.symlink(fileArr[i].getAbsolutePath(), fileArr2[i].getAbsolutePath());
                        fileArr4[i] = fileArr2[i];
                    }
                }
            } else {
                UCElapseTime uCElapseTime = new UCElapseTime();
                Process process = null;
                try {
                    process = Runtime.getRuntime().exec("sh");
                    DataOutputStream dataOutputStream = new DataOutputStream(process.getOutputStream());
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                    for (int i2 = 0; i2 < fileArr.length; i2++) {
                        if (fileArr2[i2].exists()) {
                            fileArr4[i2] = fileArr2[i2];
                        } else {
                            dataOutputStream.writeBytes(String.format("ln -s %s %s", new Object[]{fileArr[i2].getAbsolutePath(), fileArr2[i2].getAbsolutePath()}));
                            dataOutputStream.writeBytes("\n");
                            dataOutputStream.flush();
                            fileArr4[i2] = fileArr2[i2];
                        }
                    }
                    dataOutputStream.writeBytes("exit\n");
                    dataOutputStream.flush();
                    process.waitFor();
                    dataOutputStream.close();
                    if (process != null) {
                        process.destroy();
                    }
                } catch (Throwable e) {
                    Log.e("Utils", "symlink exception.", e);
                    if (process != null) {
                        process.destroy();
                        obj = null;
                    } else {
                        obj = null;
                    }
                } catch (Throwable th) {
                    if (process != null) {
                        process.destroy();
                    }
                }
                if (obj != null) {
                    Log.e("Utils", "link success! Time:" + uCElapseTime.getMilis());
                } else {
                    throw new Throwable();
                }
            }
        } catch (Throwable th2) {
            UCSetupException uCSetupException = new UCSetupException(1007, th2);
        }
        return fileArr4;
    }

    public static Pair<Long, Long> a(String str, URL url) throws UCSetupException {
        Object obj;
        Pair<Long, Long> pair;
        URL url2;
        HttpURLConnection httpURLConnection;
        int responseCode;
        Pair pair2 = (Pair) f.get(str);
        if (pair2 != null) {
            if (Long.valueOf(SystemClock.uptimeMillis() - ((Long) pair2.first).longValue()).longValue() < e.longValue()) {
                obj = pair2.second;
                pair = (Pair) obj;
                if (pair == null) {
                    try {
                        if (!SDKFactory.f && Boolean.parseBoolean(UCCore.getParam(UCCore.CD_ENABLE_TRAFFIC_STAT)) && VERSION.SDK_INT >= 14) {
                            TrafficStats.setThreadStatsTag(40962);
                        }
                    } catch (Throwable th) {
                    }
                    try {
                        url2 = new URL(url, str);
                        httpURLConnection = (HttpURLConnection) url2.openConnection();
                        httpURLConnection.setConnectTimeout(a);
                        httpURLConnection.setReadTimeout(b);
                        httpURLConnection.setInstanceFollowRedirects(false);
                        httpURLConnection.setRequestMethod("HEAD");
                        httpURLConnection.connect();
                        responseCode = httpURLConnection.getResponseCode();
                        if (responseCode >= 200 || responseCode > SecExceptionCode.SEC_ERROR_STA_NO_DATA_FILE) {
                            throw new UCKnownException(4021, "httpcode:" + responseCode + " not correct.");
                        }
                        if (responseCode == SecExceptionCode.SEC_ERROR_STA_ENC || responseCode == SecExceptionCode.SEC_ERROR_STA_INVALID_PARAM || responseCode == SecExceptionCode.SEC_ERROR_STA_DATA_FILE_MISMATCH || responseCode == SecExceptionCode.SEC_ERROR_STA_NO_DATA_FILE) {
                            String headerField = httpURLConnection.getHeaderField("Location");
                            if (a(headerField)) {
                                throw new UCKnownException(4022, "Redirect location is null.");
                            }
                            pair = a(headerField, url2);
                        } else {
                            long lastModified;
                            if (c) {
                                lastModified = httpURLConnection.getLastModified();
                            } else {
                                lastModified = 0;
                            }
                            long contentLength = (long) httpURLConnection.getContentLength();
                            if (contentLength <= 0) {
                                throw new UCKnownException(4023, "Total size is not correct:" + contentLength);
                            }
                            httpURLConnection.disconnect();
                            pair = new Pair(Long.valueOf(contentLength), Long.valueOf(lastModified));
                        }
                        f.put(str, new Pair(Long.valueOf(SystemClock.uptimeMillis()), pair));
                    } catch (UCKnownException e) {
                        throw e;
                    } catch (Throwable th2) {
                        UCSetupException uCSetupException = new UCSetupException(2009, th2);
                    }
                }
                return pair;
            }
        }
        obj = null;
        pair = (Pair) obj;
        if (pair == null) {
            TrafficStats.setThreadStatsTag(40962);
            url2 = new URL(url, str);
            httpURLConnection = (HttpURLConnection) url2.openConnection();
            httpURLConnection.setConnectTimeout(a);
            httpURLConnection.setReadTimeout(b);
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setRequestMethod("HEAD");
            httpURLConnection.connect();
            responseCode = httpURLConnection.getResponseCode();
            if (responseCode >= 200) {
            }
            throw new UCKnownException(4021, "httpcode:" + responseCode + " not correct.");
        }
        return pair;
    }

    public static Boolean a(ConcurrentHashMap<String, Object> concurrentHashMap, String str) {
        Object obj = concurrentHashMap.get(str);
        if (obj == null) {
            return null;
        }
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof String) {
            return Boolean.valueOf(Boolean.parseBoolean((String) obj));
        }
        throw new UCSetupException((int) SettingsConst.PAUSE_PLAY_WHEN_AUDIOFOCUS_LOSS_TRANSIENT, String.format("\"true\" or \"false\" or boolean expected with key:[%s], now is [%s]", new Object[]{str, obj}));
    }

    public static boolean a(File file) {
        try {
            if (!file.exists()) {
                return true;
            }
            if (VERSION.SDK_INT >= 9) {
                return file.setReadable(true, false);
            }
            Runtime.getRuntime().exec("chmod 644 " + file.getAbsolutePath());
            return true;
        } catch (Throwable e) {
            Log.e("Utils", "setReadable", e);
            return false;
        }
    }

    public static boolean b(File file) {
        try {
            if (file.exists()) {
                return file.canRead();
            }
        } catch (Throwable e) {
            Log.e("Utils", "canRead", e);
        }
        return false;
    }

    public static boolean c(File file) {
        if (file != null) {
            try {
                if (file.exists()) {
                    if (VERSION.SDK_INT >= 9) {
                        return file.setExecutable(true, false);
                    }
                    Runtime.getRuntime().exec("chmod 711 " + file.getAbsolutePath());
                }
            } catch (Throwable e) {
                Log.e("Utils", "setExecutable", e);
                return false;
            }
        }
        return true;
    }

    public static boolean d(File file) {
        boolean z = false;
        try {
            if (file.exists() && VERSION.SDK_INT >= 9) {
                z = file.canExecute();
            }
        } catch (Throwable e) {
            Log.e("Utils", "canExecute", e);
        }
        return z;
    }

    public static int b(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            return 0;
        }
    }

    public static long c(String str) {
        try {
            return Long.parseLong(str);
        } catch (Exception e) {
            return 0;
        }
    }

    private static String e(String str) {
        String str2 = null;
        try {
            Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", new Class[]{String.class});
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, new Object[]{str});
            if (invoke != null) {
                str2 = invoke.toString();
            }
        } catch (Throwable th) {
        }
        return str2;
    }

    public static String c() {
        for (Entry entry : g.entrySet()) {
            String e = e((String) entry.getKey());
            if (e != null && e.length() > 0) {
                return (String) entry.getValue();
            }
        }
        return "UNKNOWN";
    }

    public static boolean d() {
        boolean z = false;
        if (j) {
            return i;
        }
        for (Object equals : h) {
            if (Build.SDK_PROFILE_ID.equals(equals)) {
                z = true;
                break;
            }
        }
        i = z;
        j = true;
        return i;
    }

    public static String[] a(UCMPackageInfo uCMPackageInfo) {
        try {
            Class cls = Class.forName("com.uc.webview.browser.shell.NativeLibraries", true, uCMPackageInfo.mSdkShellClassLoader);
            if (cls != null) {
                Field declaredField = cls.getDeclaredField("LIBRARIES");
                declaredField.setAccessible(true);
                String[][] strArr = (String[][]) declaredField.get(null);
                ArrayList arrayList = new ArrayList();
                for (Object[] objArr : strArr) {
                    if (!(objArr == null || objArr[0] == null)) {
                        arrayList.add(objArr[0]);
                    }
                }
                return (String[]) arrayList.toArray(new String[arrayList.size()]);
            }
        } catch (IllegalAccessException e) {
        } catch (NoSuchFieldException e2) {
        } catch (ClassNotFoundException e3) {
        }
        return null;
    }
}
