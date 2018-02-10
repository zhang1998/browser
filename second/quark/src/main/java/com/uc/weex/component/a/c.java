package com.uc.weex.component.a;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.mini.support.annotation.NonNull;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.taobao.weex.ac;
import com.taobao.weex.ui.component.WXComponentProp;
import com.taobao.weex.ui.component.ae;
import com.taobao.weex.ui.component.bv;
import com.taobao.weex.ui.view.l;
import com.taobao.weex.utils.af;
import com.tencent.tinker.loader.shareutil.ShareElfFile.SectionHeader;
import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
public class c extends ae {
    private Animator a = null;
    private int b = 200;
    private int c = SectionHeader.SHT_LOUSER;
    private int d = SectionHeader.SHT_LOUSER;
    private String e = "transparent";
    private float f = -1.0f;
    private float h = IPictureView.DEFAULT_MIN_SCALE;
    private boolean i = false;

    protected /* synthetic */ View initComponentHostView(@NonNull Context context) {
        return a(context);
    }

    public c(ac acVar, com.taobao.weex.c.ae aeVar, bv bvVar, boolean z) {
        super(acVar, aeVar, bvVar);
    }

    public void setBackgroundColor(String str) {
        super.setBackgroundColor(str);
        this.e = str;
    }

    public void setOpacity(float f) {
        super.setOpacity(f);
        this.h = f;
    }

    @WXComponentProp(name = "pressedBackgroundColor")
    public void setPressedBackgroundColor(String str) {
        this.c = af.a(str);
    }

    @WXComponentProp(name = "pressedbackgroundcolor")
    public void setPressedBackgroundColor2(String str) {
        setPressedBackgroundColor(str);
    }

    @WXComponentProp(name = "pressedStartBackgroundColor")
    public void setPressedStartBackgroundColor(String str) {
        this.d = af.a(str);
    }

    @WXComponentProp(name = "pressedstartbackgroundcolor")
    public void setPressedStartBackgroundColor2(String str) {
        setPressedStartBackgroundColor(str);
    }

    @WXComponentProp(name = "pressedOpacity")
    public void setPressedOpacity(float f) {
        this.f = f;
    }

    @WXComponentProp(name = "pressedopacity")
    public void setPressedOpacity2(float f) {
        setPressedOpacity(f);
    }

    @WXComponentProp(name = "animatorDuration")
    public void setAnimatorDuration(int i) {
        this.b = i;
    }

    @WXComponentProp(name = "animatorduration")
    public void setAnimatorDuration2(int i) {
        setAnimatorDuration(i);
    }

    private void a(int i) {
        if (getHostView() != null) {
            getOrCreateBorder().a(i);
        }
    }

    final void a(boolean z) {
        if (this.i != z) {
            if (this.c != SectionHeader.SHT_LOUSER) {
                if (this.f == -1.0f) {
                    this.f = 0.8f;
                }
                if (z) {
                    if (this.d == SectionHeader.SHT_LOUSER) {
                        a(this.c);
                    } else {
                        if (this.a != null && this.a.isRunning()) {
                            this.a.cancel();
                        }
                        this.a = a(this.d, this.c, this.b, null);
                    }
                } else if (this.a != null) {
                    if (this.a.isRunning()) {
                        this.a.cancel();
                    }
                    this.a = a(this.c, this.d, this.b, this.e);
                } else {
                    super.setBackgroundColor(this.e);
                }
            }
            if (this.f != -1.0f) {
                if (z) {
                    super.setOpacity(this.f);
                } else {
                    super.setOpacity(this.h);
                }
            }
            this.i = z;
        }
    }

    protected final l a(@NonNull Context context) {
        return new e(context, this);
    }

    private Animator a(int i, int i2, int i3, String str) {
        Animator ofObject = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        ofObject.addUpdateListener(new a(this));
        ofObject.addListener(new b(this, str));
        ofObject.setInterpolator(new LinearInterpolator());
        ofObject.setDuration((long) i3);
        ofObject.start();
        return ofObject;
    }
}
