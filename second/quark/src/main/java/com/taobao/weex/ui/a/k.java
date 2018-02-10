package com.taobao.weex.ui.a;

import android.mini.support.annotation.IntRange;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.taobao.weex.ad;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.WXJSObject;
import com.taobao.weex.bridge.s;
import com.taobao.weex.bridge.t;
import com.taobao.weex.c.a.c;
import com.taobao.weex.common.a;
import com.taobao.weex.common.o;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.v;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: ProGuard */
public class k extends o implements Callback, a {
    private Handler a;

    public k() {
        s a = s.a();
        Looper looper = null;
        if (a.b != null) {
            looper = a.b.getLooper();
        }
        this.a = new Handler(looper, this);
    }

    @JSMethod(uiThread = false)
    public void setTimeout(@IntRange(from = 1) int i, @IntRange(from = 0) int i2) {
        if (this.b != null) {
            b(11, i, i2, Integer.parseInt(this.b.e));
        }
    }

    @JSMethod(uiThread = false)
    public void setInterval(@IntRange(from = 1) int i, @IntRange(from = 0) int i2) {
        if (this.b != null) {
            b(12, i, i2, Integer.parseInt(this.b.e));
        }
    }

    @JSMethod(uiThread = false)
    public void clearTimeout(@IntRange(from = 1) int i) {
        if (i > 0) {
            a(11, i);
        }
    }

    @JSMethod(uiThread = false)
    public void clearInterval(@IntRange(from = 1) int i) {
        if (i > 0) {
            a(12, i);
        }
    }

    public final void a() {
        if (this.a != null) {
            WXLogUtils.d("timer", "Timer Module removeAllMessages: ");
            this.a.removeCallbacksAndMessages(null);
        }
    }

    public boolean handleMessage(Message message) {
        if (message != null) {
            int i = message.what;
            WXLogUtils.d("timer", "Timer Module handleMessage : " + message.what);
            switch (i) {
                case 11:
                    if (message.obj != null) {
                        s.a().a(String.valueOf(message.arg1), null, "callJS", a(message.arg1, ((Integer) message.obj).intValue(), false), true);
                        return true;
                    }
                    break;
                case 12:
                    if (message.obj != null) {
                        a(12, ((Integer) message.obj).intValue(), message.arg2, message.arg1);
                        s.a().a(String.valueOf(message.arg1), null, "callJS", a(message.arg1, ((Integer) message.obj).intValue(), true), true);
                        return true;
                    }
                    break;
            }
        }
        return false;
    }

    private static WXJSObject[] a(int i, int i2, boolean z) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(i2));
        arrayList.add(new HashMap());
        arrayList.add(Boolean.valueOf(z));
        t tVar = new t();
        tVar.put("method", "callback");
        tVar.put("args", arrayList);
        Object obj = new Object[]{tVar};
        return new WXJSObject[]{new WXJSObject(2, String.valueOf(i)), new WXJSObject(3, v.a(obj, false))};
    }

    private void a(int i, @IntRange(from = 1) int i2, @IntRange(from = 0) int i3, int i4) {
        if (i3 < 0 || i2 <= 0) {
            WXLogUtils.e("timer", "interval < 0 or funcId <=0");
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = i;
        obtain.arg1 = i4;
        obtain.arg2 = i3;
        obtain.obj = Integer.valueOf(i2);
        this.a.sendMessageDelayed(obtain, (long) i3);
    }

    private void b(int i, int i2, int i3, int i4) {
        if (this.b.v) {
            ad.a().a.a(this.b.e, c.a(new i(this, i, i2, i3, i4)), false);
        } else {
            a(i, i2, i3, i4);
        }
    }

    private void a(int i, int i2) {
        if (this.b.v) {
            ad.a().a.a(this.b.e, c.a(new j(this, i, i2)), false);
        } else {
            this.a.removeMessages(i, Integer.valueOf(i2));
        }
    }
}
