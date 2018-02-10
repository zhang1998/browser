package com.ucpro.feature.webwindow;

import android.app.Activity;
import android.net.Uri;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.webkit.ValueCallback;
import android.widget.RelativeLayout;
import com.quark.browser.R;
import com.uc.imagecodec.export.IPictureView;
import com.uc.webview.export.WebChromeClient.FileChooserParams;
import com.ucpro.a.ac;
import com.ucpro.base.a.g;
import com.ucpro.base.c.a.a;
import com.ucpro.base.c.b;
import com.ucpro.base.e.e;
import com.ucpro.feature.webwindow.e.j;
import com.ucpro.feature.webwindow.e.p;
import com.ucpro.feature.webwindow.e.s;
import com.ucpro.feature.webwindow.e.t;
import com.ucpro.feature.webwindow.e.x;
import com.ucpro.feature.webwindow.h.h;
import com.ucpro.feature.z.g.b.n;
import com.ucweb.common.util.c;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.b.d;
import kotlin.b.k;
import kotlin.b.m;
import kotlin.jvm.a.f;

/* compiled from: ProGuard */
public class ax extends e implements a, com.ucpro.feature.m.e, at {
    private static boolean g = false;
    private ArrayList<WeakReference<Object>> c = new ArrayList();
    private boolean d = true;
    private ba e;
    private ValueCallback<Uri[]> f;

    protected final void a(b bVar) {
        super.a(bVar);
        t_().a((a) this);
    }

    public final void a(int i, Message message) {
        int i2 = 0;
        String str;
        Object queryParameter;
        Object stringBuilder;
        bb a;
        if (i == com.ucpro.base.a.e.k) {
            boolean z;
            bo i3;
            Object obj;
            n nVar;
            CharSequence charSequence;
            Object[] objArr;
            Object asList;
            kotlin.c.e dVar;
            kotlin.jvm.b.a kVar;
            kotlin.c.e dVar2;
            CharSequence charSequence2;
            CharSequence charSequence3;
            CharSequence charSequence4;
            CharSequence charSequence5;
            c.b(message.obj instanceof aj);
            aj ajVar = (aj) message.obj;
            str = ajVar.o;
            if (com.ucpro.c.b.a() && com.ucweb.common.util.n.a.b(str) && str.contains("_wx_devtool")) {
                queryParameter = Uri.parse(str).getQueryParameter("_wx_devtool");
                if (queryParameter != null) {
                    g.a().a(com.ucpro.base.a.e.bM, queryParameter);
                    z = true;
                    if (z) {
                        i3 = i();
                        if (aj.e != ajVar.s || aj.f == ajVar.s || aj.k == ajVar.s) {
                            try {
                                obj = "";
                                if (com.ucweb.common.util.n.a.b(ajVar.p)) {
                                    obj = URLEncoder.encode(ajVar.p, "utf-8");
                                }
                                nVar = n.b;
                                f.b(obj, "keyword");
                                str = nVar.d().c;
                                f.b(str, "$receiver");
                                f.b("%s", "oldValue");
                                f.b(obj, "newValue");
                                charSequence = str;
                                queryParameter = new String[]{"%s"};
                                f.b(charSequence, "$receiver");
                                f.b(queryParameter, "delimiters");
                                objArr = (Object[]) queryParameter;
                                f.b(objArr, "$receiver");
                                asList = Arrays.asList(objArr);
                                f.a(asList, "ArraysUtilJVM.asList(this)");
                                dVar = new d(charSequence, new m(asList));
                                kVar = new k(charSequence);
                                f.b(dVar, "$receiver");
                                f.b(kVar, "transform");
                                dVar2 = new kotlin.c.d(dVar, kVar);
                                charSequence2 = (CharSequence) obj;
                                charSequence3 = "";
                                charSequence4 = "";
                                charSequence5 = "...";
                                f.b(dVar2, "$receiver");
                                f.b(charSequence2, "separator");
                                f.b(charSequence3, "prefix");
                                f.b(charSequence4, "postfix");
                                f.b(charSequence5, "truncated");
                                stringBuilder = ((StringBuilder) kotlin.c.a.a(dVar2, new StringBuilder(), charSequence2, charSequence3, charSequence4, charSequence5)).toString();
                                f.a(stringBuilder, "joinTo(StringBuilder(), …ed, transform).toString()");
                                ajVar.o = stringBuilder;
                                if (com.ucpro.business.a.a.b.a() || com.ucpro.business.a.a.b.b()) {
                                    g.a().b(com.ucpro.base.a.e.cj, new Object[]{obj, new aa(this, ajVar)});
                                }
                            } catch (UnsupportedEncodingException e) {
                            }
                        } else if (aj.g == ajVar.s) {
                            try {
                                CharSequence encode = URLEncoder.encode(ajVar.p, "utf-8");
                                str = ajVar.o;
                                if (TextUtils.isEmpty(str)) {
                                    str = n.b.d().c;
                                }
                                ajVar.o = str.replace("%s", encode);
                            } catch (UnsupportedEncodingException e2) {
                            }
                        }
                        if (aj.f == ajVar.s) {
                            a(ajVar.o, true, false, true, true);
                        } else if (!ajVar.q) {
                            if (ajVar.t) {
                                a(ajVar);
                            }
                            a = a(i3);
                            if (a != null) {
                                a.a(false, true);
                                a.b(ajVar.o);
                            }
                        } else if (i3 == null && i3.G() && (s_().a() instanceof bb)) {
                            a(ajVar);
                            i3.setShouldBackToCallerActivity(ajVar.r);
                            return;
                        } else {
                            a(ajVar.o, true, false, true, true).setShouldBackToCallerActivity(ajVar.r);
                        }
                    }
                }
            }
            if (str != null && str.startsWith("ext:a:")) {
                str = str.substring(6);
            }
            stringBuilder = com.uc.weex.d.a.b.a(str);
            if (stringBuilder != null) {
                g.a().a(com.ucpro.base.a.e.bN, stringBuilder);
                z = true;
            } else {
                z = false;
            }
            if (z) {
                i3 = i();
                if (aj.e != ajVar.s) {
                }
                obj = "";
                if (com.ucweb.common.util.n.a.b(ajVar.p)) {
                    obj = URLEncoder.encode(ajVar.p, "utf-8");
                }
                nVar = n.b;
                f.b(obj, "keyword");
                str = nVar.d().c;
                f.b(str, "$receiver");
                f.b("%s", "oldValue");
                f.b(obj, "newValue");
                charSequence = str;
                queryParameter = new String[]{"%s"};
                f.b(charSequence, "$receiver");
                f.b(queryParameter, "delimiters");
                objArr = (Object[]) queryParameter;
                f.b(objArr, "$receiver");
                asList = Arrays.asList(objArr);
                f.a(asList, "ArraysUtilJVM.asList(this)");
                dVar = new d(charSequence, new m(asList));
                kVar = new k(charSequence);
                f.b(dVar, "$receiver");
                f.b(kVar, "transform");
                dVar2 = new kotlin.c.d(dVar, kVar);
                charSequence2 = (CharSequence) obj;
                charSequence3 = "";
                charSequence4 = "";
                charSequence5 = "...";
                f.b(dVar2, "$receiver");
                f.b(charSequence2, "separator");
                f.b(charSequence3, "prefix");
                f.b(charSequence4, "postfix");
                f.b(charSequence5, "truncated");
                stringBuilder = ((StringBuilder) kotlin.c.a.a(dVar2, new StringBuilder(), charSequence2, charSequence3, charSequence4, charSequence5)).toString();
                f.a(stringBuilder, "joinTo(StringBuilder(), …ed, transform).toString()");
                ajVar.o = stringBuilder;
                g.a().b(com.ucpro.base.a.e.cj, new Object[]{obj, new aa(this, ajVar)});
                if (aj.f == ajVar.s) {
                    a(ajVar.o, true, false, true, true);
                } else if (!ajVar.q) {
                    if (i3 == null) {
                    }
                    a(ajVar.o, true, false, true, true).setShouldBackToCallerActivity(ajVar.r);
                } else if (ajVar.t) {
                    a(ajVar);
                } else {
                    a = a(i3);
                    if (a != null) {
                        a.a(false, true);
                        a.b(ajVar.o);
                    }
                }
            }
        } else if (i == com.ucpro.base.a.e.G) {
            a = d();
            Message obtain = Message.obtain();
            obtain.what = com.ucpro.base.a.e.J;
            obtain.obj = a;
            obtain.getData().putBoolean("IS_FOREGROUND", true);
            obtain.getData().putBoolean("NEED_RESTRICT_BY_COUNT", true);
            g.a().a(obtain);
        } else if (i == com.ucpro.base.a.e.H) {
            a(null, ((Boolean) message.obj).booleanValue(), true, false, true);
        } else if (i == com.ucpro.base.a.e.n) {
        } else {
            if (i == com.ucpro.base.a.e.o) {
                stringBuilder = i();
                c.a(stringBuilder);
                if (stringBuilder != null && stringBuilder.c()) {
                    stringBuilder.r();
                }
            } else if (i == com.ucpro.base.a.e.p) {
                boolean c;
                ValueCallback valueCallback = (ValueCallback) message.obj;
                queryParameter = i();
                c.a(queryParameter);
                if (queryParameter != null) {
                    c = queryParameter.c();
                } else {
                    c = false;
                }
                valueCallback.onReceiveValue(Boolean.valueOf(c));
            } else if (i == com.ucpro.base.a.e.s) {
                stringBuilder = i();
                c.a(stringBuilder);
                if (stringBuilder != null && !stringBuilder.G()) {
                    stringBuilder.p();
                    stringBuilder.u();
                }
            } else if (i == com.ucpro.base.a.e.t) {
                stringBuilder = i();
                c.a(stringBuilder);
                if (stringBuilder != null) {
                    r3 = com.ucpro.feature.d.a.b.a(com.ucpro.services.c.f.a.a.a(stringBuilder.getContext(), stringBuilder.getUrl()));
                    com.ucweb.c.b.a aVar = new com.ucweb.c.b.a();
                    aVar.a = stringBuilder.getUrl();
                    aVar.b = stringBuilder.getTitle();
                    if (stringBuilder.getContentDescription() != null) {
                        str = stringBuilder.getContentDescription().toString();
                    } else {
                        str = "";
                    }
                    aVar.c = str;
                    aVar.e = r3;
                    aVar.f = r3;
                    aVar.d = com.ucweb.c.a.c.c;
                    g.a().a(com.ucpro.base.a.e.bC, aVar.a());
                }
            } else if (i == com.ucpro.base.a.e.af) {
                a = i();
                if (a != null) {
                    com.ucpro.feature.webwindow.e.f webView = a.getWebView();
                    if (message.arg1 != 0) {
                        r2 = 1;
                    } else {
                        r2 = -1;
                    }
                    if (webView.a != null) {
                        t tVar = webView.a;
                        if (tVar.getUCExtension() != null) {
                            tVar.getUCExtension().moveCursorToTextInput(r2);
                        }
                    }
                }
            } else if (i == com.ucpro.base.a.e.Q) {
                a = i();
                if (a != null && a.getVisibility() != 8) {
                    a.setVisibility(8);
                }
            } else if (i == com.ucpro.base.a.e.P) {
                Object[] objArr2 = (Object[]) message.obj;
                r3 = (String) objArr2[0];
                com.ucpro.ui.a aVar2 = (com.ucpro.ui.a) objArr2[1];
                bb i4 = i();
                if (i4 != null) {
                    com.ucpro.feature.webwindow.n.e bannerManager = i4.getBannerManager();
                    if (bannerManager.c != null) {
                        bannerManager.c.a();
                    }
                    bannerManager.c = new com.ucpro.feature.webwindow.n.b(bannerManager.a.getContext(), r3, aVar2, bannerManager);
                    View view = bannerManager.c;
                    if (view != null) {
                        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                        layoutParams.addRule(12);
                        layoutParams.bottomMargin = com.ucpro.ui.c.a.c((int) R.dimen.homepage_searchbar_height);
                        bannerManager.b.addView(view, layoutParams);
                    }
                    com.ucpro.feature.webwindow.n.b bVar = bannerManager.c;
                    bVar.setAlpha(0.0f);
                    bVar.animate().alpha(IPictureView.DEFAULT_MIN_SCALE).setInterpolator(bVar.a).setDuration(200).start();
                    bVar.postDelayed(bVar.b, 4000);
                }
            } else if (i == com.ucpro.base.a.e.R) {
                a = i();
                if (a != null && a.getVisibility() != 0) {
                    a.setVisibility(0);
                }
            } else if (i == com.ucpro.base.a.e.bB) {
                Uri[] uriArr = (Uri[]) message.obj;
                if (this.f != null) {
                    this.f.onReceiveValue(uriArr);
                }
            } else if (i == com.ucpro.base.a.e.ch) {
                r2 = message.arg1;
                Activity activity = this.b;
                if (activity != null && activity.getRequestedOrientation() != r2) {
                    activity.setRequestedOrientation(r2);
                }
            } else if (i == com.ucpro.base.a.e.l) {
                c.b(message.obj instanceof aj);
                r3 = ((aj) message.obj).o;
                if (r3 != null) {
                    a(r3, true, true, false, false);
                }
            } else if (i == com.ucpro.base.a.e.cr) {
                c.a(message.obj);
                c.b(message.obj instanceof Boolean);
                r2 = (Boolean) message.obj;
                r4 = t_().a();
                while (i2 < r4) {
                    r3 = s_().c(i2);
                    if (r3 != null && (r3 instanceof bb)) {
                        if (r2.booleanValue()) {
                            ((bb) r3).L();
                        } else {
                            ((bb) r3).M();
                        }
                    }
                    i2++;
                }
            } else if (i == com.ucpro.base.a.e.q) {
                a = i();
                if (a != null) {
                    a.a();
                }
            } else if (i == com.ucpro.base.a.e.r) {
                r4 = this.a.c().a();
                for (int i5 = 0; i5 < r4; i5++) {
                    r2 = this.a.b().c(i5);
                    if (r2 instanceof bb) {
                        a = (bb) r2;
                        if (a.e != null) {
                            if (a.l != null) {
                                if (a.e.h()) {
                                    a.l.c = true;
                                } else {
                                    a.l.c = false;
                                }
                            }
                            if (a.i != null) {
                                h hVar = a.i;
                                r2 = a.e.i();
                                String url = hVar.getUrl();
                                int stackCount = hVar.a.getStackCount();
                                hVar.removeView(hVar.b);
                                hVar.c = r2;
                                hVar.e();
                                hVar.a(stackCount);
                                hVar.a(url);
                            }
                        }
                    }
                }
            } else if (com.ucpro.base.a.e.f == i) {
                c.a(message.obj);
                c.b(message.obj instanceof Boolean);
                r2 = (Boolean) message.obj;
                r4 = t_().a();
                while (i2 < r4) {
                    r3 = s_().c(i2);
                    if (r3 != null && (r3 instanceof bb)) {
                        if (r2.booleanValue()) {
                            ((bb) r3).N();
                        } else {
                            ((bb) r3).O();
                        }
                    }
                    i2++;
                }
            } else if (com.ucpro.base.a.e.dd == i) {
                c.b(message.obj instanceof Boolean);
                r4 = t_().a();
                while (i2 < r4) {
                    r2 = s_().c(i2);
                    if (r2 instanceof bb) {
                        ((bb) r2).e(((Boolean) message.obj).booleanValue());
                    }
                    i2++;
                }
            }
        }
    }

    public final void h() {
        super.h();
        com.ucpro.feature.m.h.a.a(0, this);
    }

    public final bb a(String str, boolean z, boolean z2, boolean z3, boolean z4) {
        bb d = d();
        d.setOpenInBackground(!z4);
        Message obtain = Message.obtain();
        obtain.what = com.ucpro.base.a.e.J;
        obtain.obj = d;
        obtain.getData().putBoolean("IS_FOREGROUND", z4);
        obtain.getData().putBoolean("NEED_RESTRICT_BY_COUNT", z);
        obtain.getData().putBoolean("NEED_SHOW_MAX_COUNT_TIP", z2);
        g.a().a(obtain);
        if (!TextUtils.isEmpty(str)) {
            if (z4) {
                if (i() == d) {
                    d.b(str);
                    return d;
                } else if (z3) {
                    bb i = i();
                    if (i == null) {
                        return i;
                    }
                    i.b(str);
                    return i;
                }
            } else if (d.getParent() != null) {
                d.b(str);
            }
        }
        return d;
    }

    private void a(aj ajVar) {
        boolean z;
        Object i = i();
        if (ajVar.o != null && ajVar.o.startsWith("qk://")) {
            CharSequence charSequence = ajVar.o;
            c.a(i);
            c.a(charSequence);
            c.b(charSequence.startsWith("qk://"));
            String substring = charSequence.substring(5);
            z = true;
            switch (substring.hashCode()) {
                case 3237038:
                    if (substring.equals("info")) {
                        z = false;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("<head><title>app info</title><head><body><font size=\"8\" face=\"Times\">VERSION NAME: <span style=\"background:yellow\">2.4.1.985</span><br>SUB VERSION: <span style=\"background:yellow\">").append("release</span><br>VERSION CODE: <span style=\"background:yellow\">50</span><br>").append("BUILD SEQ: <span style=\"background:yellow\">180123054500</span><br>BID: <span style=\"background:yellow\">").append(com.ucpro.c.a.a()).append("</span><br>BUILD TYPE: <span style=\"background:yellow\">release</span><br>FLAVOR: ").append("<span style=\"background:yellow\">standard</span><br></font></body>");
                    i.a(true, false);
                    i.a(1);
                    i.f.a(charSequence, stringBuilder.toString(), "text/html", null, null);
                    i.j.a(charSequence, false, null);
                    z = true;
                    break;
                default:
                    z = false;
                    break;
            }
            if (!z) {
                ajVar.s = aj.e;
                ajVar.p = ajVar.o;
            } else {
                return;
            }
        }
        if (i != null) {
            String str = ajVar.o;
            z = ajVar.s == aj.e || ajVar.s == aj.g;
            i.a(str, z, ajVar.p);
        }
    }

    private bb d() {
        bo bbVar = new bb(this.b, this);
        bbVar.setWebViewCallback(new j(this.b, this, bbVar, s_(), t_()));
        bbVar.setTextSelectionClient(new s(bbVar));
        bbVar.setIBackForwardListListener(new x(bbVar));
        bbVar.setDownloadListener(new com.ucpro.feature.webwindow.e.g());
        bbVar.setPictureViewListener(new p(bbVar, s_()));
        bbVar.setPresenter(new y(this.b, bbVar, s_(), t_(), this));
        return bbVar;
    }

    public final ba c() {
        if (this.e == null) {
            this.e = new ba(this.b, this);
        }
        return this.e;
    }

    public final boolean a(ValueCallback<Uri[]> valueCallback, FileChooserParams fileChooserParams) {
        this.f = valueCallback;
        try {
            this.b.startActivityForResult(fileChooserParams.createIntent(), 1);
            return true;
        } catch (Throwable e) {
            Log.w("WebController", "warning:", e);
            return false;
        }
    }

    public final void g() {
        super.g();
        int a = t_().a();
        for (int i = 0; i < a; i++) {
            com.ucpro.base.c.b.g c = s_().c(i);
            if (c instanceof bb) {
                ((bb) c).J();
            }
        }
    }

    public final void b(int i, Message message) {
        boolean z = true;
        int i2 = 0;
        if (i == com.ucpro.base.a.j.f) {
            int a = this.a.c().a();
            while (i2 < a) {
                com.ucpro.base.c.b.g c = this.a.b().c(i2);
                if (c != null) {
                    c.l();
                }
                i2++;
            }
        } else if (i == com.ucpro.base.a.j.h) {
            com.ucpro.feature.i.k a2 = com.ucpro.feature.i.f.a;
            a2.a(this.b);
            if (a2.a()) {
                a2.a(0);
            } else {
                a2.a(8);
            }
            for (i2 = a2.a.size() - 1; i2 >= 0; i2--) {
                if (((WeakReference) a2.a.get(i2)).get() == null) {
                    a2.a.remove(i2);
                }
            }
        } else if (com.ucpro.base.a.j.i == i) {
            z = com.ucpro.feature.e.b.a.a;
            int a3 = this.a.c().a();
            while (i2 < a3) {
                com.ucpro.base.c.b.g c2 = this.a.b().c(i2);
                if (c2 != null) {
                    c2.c(z);
                }
                i2++;
            }
        } else if (i == com.ucpro.base.a.j.q) {
            com.ucweb.common.util.h.m.a(1, new bq(this));
        } else if (com.ucpro.base.a.j.y == i) {
            if (Looper.getMainLooper() != Looper.myLooper()) {
                z = false;
            }
            c.b(z);
            bb i3 = i();
            if (i3 != null && i3.g) {
                i3.v();
            }
        }
    }

    private void e() {
        int a = t_().a();
        for (int i = 0; i < a; i++) {
            com.ucpro.base.c.b.g c = s_().c(i);
            if (c instanceof bb) {
                bb bbVar = (bb) c;
                bbVar.k = a;
                if (bbVar.h != null) {
                    bbVar.h.setMultiWindowNum(a);
                }
                if (bbVar.j != null) {
                    bbVar.j.a(a);
                }
            }
        }
    }

    public final void a() {
        e();
    }

    public final void a(com.ucpro.base.c.b.g gVar) {
        e();
        if (gVar instanceof bb) {
            ((bb) gVar).J();
        }
    }

    public final bb a(bo boVar) {
        bb d = d();
        int c = s_().c((com.ucpro.base.c.b.g) boVar);
        d.m = new WeakReference(boVar);
        d.n = c;
        Message obtain = Message.obtain();
        obtain.what = com.ucpro.base.a.e.J;
        obtain.obj = d;
        obtain.getData().putBoolean("IS_FOREGROUND", true);
        obtain.getData().putBoolean("NEED_RESTRICT_BY_COUNT", true);
        g.a().a(obtain);
        return d;
    }

    public final com.ucpro.feature.m.b b() {
        com.ucpro.feature.m.b bVar = new com.ucpro.feature.m.b();
        bVar.a = new ArrayList();
        ArrayList c = t_().c();
        for (int i = 0; i < c.size(); i++) {
            com.ucpro.base.c.b.g c2 = s_().c(((Integer) c.get(i)).intValue());
            if (c2 instanceof bb) {
                String url = ((bb) c2).getUrl();
                if (!"ext:lp:home".equals(url)) {
                    bVar.a.add(url);
                }
            }
        }
        return bVar;
    }

    private bb i() {
        com.ucpro.base.c.b.g a = s_().a();
        while (!(a instanceof bb)) {
            if (a == null) {
                return null;
            }
            a = s_().b(a);
        }
        return (bb) a;
    }

    static /* synthetic */ void b(ax axVar) {
        if (!g) {
            g = true;
            ac.b().c();
            if (!com.ucpro.business.a.a.c.c()) {
                ai.a.a(axVar.b);
            }
        }
    }
}
