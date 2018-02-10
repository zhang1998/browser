package com.taobao.weex.ui.component;

import android.content.Context;
import android.mini.support.annotation.NonNull;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.taobao.weex.ac;
import com.taobao.weex.ad;
import com.taobao.weex.annotation.Component;
import com.taobao.weex.c.ae;
import com.taobao.weex.ui.view.WXVideoView;
import com.taobao.weex.ui.view.WXVideoView.Wrapper;
import com.taobao.weex.utils.ah;
import java.util.HashMap;
import java.util.Map;

@Component(lazyload = false)
/* compiled from: ProGuard */
public class ca extends ab<FrameLayout> {
    boolean a;
    private boolean b;
    private Wrapper c;
    private boolean d;
    private boolean e;

    @Deprecated
    public ca(ac acVar, ae aeVar, bv bvVar, String str, boolean z) {
        this(acVar, aeVar, bvVar, z);
    }

    public ca(ac acVar, ae aeVar, bv bvVar, boolean z) {
        super(acVar, aeVar, bvVar, z);
    }

    public void bindData(ab abVar) {
        super.bindData(abVar);
        addEvent("appear");
    }

    public void notifyAppearStateChange(String str, String str2) {
        super.notifyAppearStateChange(str, str2);
        this.c.c();
    }

    public void destroy() {
        super.destroy();
    }

    protected boolean setProperty(String str, Object obj) {
        boolean z = true;
        switch (str.hashCode()) {
            case 114148:
                if (str.equals("src")) {
                    z = false;
                    break;
                }
                break;
            case 1438608771:
                if (str.equals("autoPlay")) {
                    z = true;
                    break;
                }
                break;
            case 1582764102:
                if (str.equals("playStatus")) {
                    z = true;
                    break;
                }
                break;
        }
        String a;
        switch (z) {
            case false:
                a = ah.a(obj, null);
                if (a == null) {
                    return true;
                }
                setSrc(a);
                return true;
            case true:
                Boolean a2 = ah.a(obj, null);
                if (a2 == null) {
                    return true;
                }
                setAutoPlay(a2.booleanValue());
                return true;
            case true:
                a = ah.a(obj, null);
                if (a == null) {
                    return true;
                }
                setPlaystatus(a);
                return true;
            default:
                return super.setProperty(str, obj);
        }
    }

    @WXComponentProp(name = "src")
    public void setSrc(String str) {
        if (!TextUtils.isEmpty(str) && getHostView() != null && !TextUtils.isEmpty(str)) {
            this.c.setVideoURI(getInstance().a(Uri.parse(str)));
            this.c.getProgressBar().setVisibility(0);
        }
    }

    @WXComponentProp(name = "autoPlay")
    public void setAutoPlay(boolean z) {
        this.b = z;
        if (z) {
            Wrapper wrapper = this.c;
            if (wrapper.a == null) {
                wrapper.b();
            }
            WXVideoView wXVideoView = wrapper.a;
            this.c.a();
        }
    }

    @WXComponentProp(name = "playStatus")
    public void setPlaystatus(String str) {
        Wrapper wrapper;
        if (!this.a || this.d || this.e) {
            if ((this.d || this.e) && str.equals("play")) {
                this.d = false;
                wrapper = this.c;
                if (wrapper.a != null) {
                    wrapper.a.resume();
                }
                this.c.getProgressBar().setVisibility(0);
            }
        } else if (str.equals("play")) {
            this.c.a();
        } else if (str.equals("pause")) {
            wrapper = this.c;
            if (wrapper.a != null) {
                wrapper.a.pause();
            }
        } else if (str.equals("stop")) {
            wrapper = this.c;
            if (wrapper.a != null) {
                wrapper.a.stopPlayback();
            }
            this.e = true;
        }
    }

    protected /* synthetic */ View initComponentHostView(@NonNull Context context) {
        View wrapper = new Wrapper(context);
        wrapper.setOnErrorListener(new bw(this, wrapper));
        wrapper.setOnPreparedListener(new bx(this, wrapper));
        wrapper.setOnCompletionListener(new by(this));
        wrapper.setOnVideoPauseListener(new bz(this));
        this.c = wrapper;
        return wrapper;
    }

    static /* synthetic */ void a(ca caVar, String str, String str2) {
        Map hashMap = new HashMap(2);
        hashMap.put("playStatus", str2);
        hashMap.put("timeStamp", Long.valueOf(System.currentTimeMillis()));
        Map hashMap2 = new HashMap();
        Map hashMap3 = new HashMap();
        hashMap3.put("playStatus", str2);
        hashMap2.put("attrs", hashMap3);
        ad.a().a(caVar.getInstanceId(), caVar.getRef(), str, hashMap, hashMap2);
    }
}
