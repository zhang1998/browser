package com.UCMobile.Apollo;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.UCMobile.Apollo.annotations.Keep;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: ProGuard */
public class MediaPreload {
    public static int PriorityHeight = 1;
    public static int PriorityLower = 3;
    public static int PriorityMid = 2;
    public static String TAG = "MediaPreload";
    private static MediaPreload a = null;
    private static IStatisticUploadListener b = null;
    private a c = null;
    private HashMap<String, IPreloadListener> d = null;

    /* compiled from: ProGuard */
    public interface IPreloadListener {
        void onInfo(String str, int i, int i2);
    }

    /* compiled from: ProGuard */
    public interface IStatisticUploadListener {
        boolean onUpload(HashMap<String, String> hashMap);
    }

    /* compiled from: ProGuard */
    final class a extends Handler {
        private MediaPreload a = null;

        public a(MediaPreload mediaPreload, Looper looper) {
            super(looper);
            this.a = mediaPreload;
        }

        public final void handleMessage(Message message) {
            String obj = message.obj.toString();
            synchronized (this.a.d) {
                IPreloadListener iPreloadListener = (IPreloadListener) this.a.d.get(obj);
            }
            if (iPreloadListener != null) {
                iPreloadListener.onInfo(obj, message.arg1, message.arg2);
            }
        }
    }

    private native void _nativeAdd(String str, String str2, String[] strArr, String[] strArr2);

    private native String _nativeGetOption(String str);

    private native void _nativeRemove(String str);

    private native int _nativeSetOption(String str, String str2);

    private native int _nativeSetPriority(String str, int i);

    private static MediaPreload a() {
        if (a == null) {
            a = new MediaPreload();
        }
        return a;
    }

    public static boolean supportPreloadBySo(Context context) {
        if (MediaPlayer.globalInitialization(context)) {
            return a().b();
        }
        return false;
    }

    private boolean b() {
        try {
            if (_nativeGetOption("rw.global.support_preload").equals("true")) {
                return true;
            }
            return false;
        } catch (UnsatisfiedLinkError e) {
            return false;
        }
    }

    public static void Add(String str, String str2, Map<String, String> map, IPreloadListener iPreloadListener) {
        String[] strArr;
        String[] strArr2 = null;
        MediaPreload a = a();
        synchronized (a.d) {
            a.d.put(str, iPreloadListener);
        }
        if (map != null) {
            String[] strArr3 = new String[map.size()];
            String[] strArr4 = new String[map.size()];
            int i = 0;
            for (Entry entry : map.entrySet()) {
                strArr3[i] = (String) entry.getKey();
                strArr4[i] = (String) entry.getValue();
                i++;
            }
            strArr2 = strArr3;
            strArr = strArr4;
        } else {
            strArr = null;
        }
        try {
            a._nativeAdd(str, str2, strArr2, strArr);
        } catch (UnsatisfiedLinkError e) {
        }
    }

    public static int SetPriority(String str, int i) {
        return a().a(str, i);
    }

    public static void Remove(String str) {
        MediaPreload a = a();
        synchronized (a.d) {
            a.d.remove(str);
        }
        try {
            a._nativeRemove(str);
        } catch (UnsatisfiedLinkError e) {
        }
    }

    public static int SetOption(String str, String str2) {
        return a().a(str, str2);
    }

    public static String GetOption(String str) {
        return a().a(str);
    }

    public static void SetStatisticUploadListener(IStatisticUploadListener iStatisticUploadListener) {
        b = iStatisticUploadListener;
    }

    public MediaPreload() {
        new StringBuilder("MediaPreload create: ").append(this);
        Looper myLooper = Looper.myLooper();
        if (myLooper == null) {
            myLooper = Looper.getMainLooper();
        }
        this.c = new a(this, myLooper);
        this.d = new HashMap();
    }

    private int a(String str, int i) {
        int i2 = -1;
        try {
            i2 = _nativeSetPriority(str, i);
        } catch (UnsatisfiedLinkError e) {
        }
        return i2;
    }

    private int a(String str, String str2) {
        new StringBuilder("setOption, key=").append(str).append(",value=").append(str2);
        int i = -1;
        try {
            i = _nativeSetOption(str, str2);
        } catch (UnsatisfiedLinkError e) {
        }
        return i;
    }

    private String a(String str) {
        String str2 = "";
        try {
            str2 = _nativeGetOption(str);
        } catch (UnsatisfiedLinkError e) {
        }
        return str2;
    }

    @Keep
    public boolean onStatistics(HashMap<String, String> hashMap) {
        if (b != null) {
            return b.onUpload(hashMap);
        }
        return false;
    }

    @Keep
    private void nativeCallback(String str, int i, int i2) {
        this.c.sendMessage(this.c.obtainMessage(i, i2, 0, str));
    }
}
