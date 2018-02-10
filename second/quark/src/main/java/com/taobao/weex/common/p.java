package com.taobao.weex.common;

import com.taobao.weex.i;
import com.taobao.weex.utils.WXLogUtils;
import com.uc.weex.a.b;

/* compiled from: ProGuard */
public final class p {
    public int A;
    public int B = 0;
    public long C;
    public String D = i.c;
    public String E = i.d;
    public String F = b.a;
    public String G;
    public String H;
    @Deprecated
    public String I;
    public String J = "";
    public String K;
    public String L;
    private StringBuilder M = new StringBuilder();
    public String a = WXLogUtils.WEEX_TAG;
    public String b;
    public String c;
    public double d;
    public String e = "default";
    public double f;
    public long g;
    public double h;
    public long i;
    public long j;
    public long k;
    public long l;
    public long m;
    public long n;
    public long o;
    public long p;
    public long q;
    public long r;
    public long s;
    public double t;
    public long u;
    public long v;
    public long w;
    public long x;
    public long y;
    public long z;

    public final String toString() {
        if (i.c()) {
            return "bizType:" + this.a + ",pageName:" + this.e + ",templateLoadTime" + this.i + ",localReadTime:" + this.d + ",JSLibInitTime:" + this.g + ",JSLibSize:" + this.f + ",templateUrl" + this.b + ",JSTemplateSize:" + this.h + ",communicateTime:" + this.j + ",viewCreateTime:" + this.k + ",screenRenderTime:" + this.l + ",firstScreenJSFExecuteTime:" + this.n + ",componentCount:" + this.C + ",syncTaskTime:" + this.z + ",pureNetworkTime:" + this.v + ",jsframeworkLoadTime:" + this.w + ",networkTime:" + this.u + ",actualNetworkTime:" + this.x + ",packageSpendTime:" + this.y + ",connectionType:" + this.K + ",requestType:" + this.L + ",initInvokeTime:" + i.s + ",initExecuteTime:" + i.t + ",SDKInitTime:" + i.u + ",totalTime:" + this.t + ",JSLibVersion:" + this.D + ",WXSDKVersion:" + this.E + ",UCWXSDKVersion:" + this.F + ",jsBundleVersion:" + this.c + ",errCode:" + this.H + ",renderFailedDetail:" + this.G + ",arg:" + this.J + ",errMsg:" + this.M.toString();
        }
        return super.toString();
    }

    public final void a(CharSequence charSequence) {
        this.M.append(charSequence);
    }
}
