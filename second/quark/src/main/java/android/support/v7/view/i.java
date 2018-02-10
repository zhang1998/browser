package android.support.v7.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.XmlResourceParser;
import android.support.v4.e.a.c;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;

/* compiled from: ProGuard */
public final class i extends MenuInflater {
    private static final Class<?>[] a;
    private static final Class<?>[] b;
    private final Object[] c;
    private final Object[] d = this.c;
    private Context e;
    private Object f;

    static {
        Class[] clsArr = new Class[]{Context.class};
        a = clsArr;
        b = clsArr;
    }

    public i(Context context) {
        super(context);
        this.e = context;
        this.c = new Object[]{context};
    }

    public final void inflate(int i, Menu menu) {
        if (menu instanceof c) {
            XmlResourceParser xmlResourceParser = null;
            try {
                xmlResourceParser = this.e.getResources().getLayout(i);
                a(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
                if (xmlResourceParser != null) {
                    xmlResourceParser.close();
                }
            } catch (Throwable e) {
                throw new InflateException("Error inflating menu XML", e);
            } catch (Throwable e2) {
                throw new InflateException("Error inflating menu XML", e2);
            } catch (Throwable th) {
                if (xmlResourceParser != null) {
                    xmlResourceParser.close();
                }
            }
        } else {
            super.inflate(i, menu);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(org.xmlpull.v1.XmlPullParser r11, android.util.AttributeSet r12, android.view.Menu r13) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
        r10 = this;
        r4 = new android.support.v7.view.j;
        r4.<init>(r10, r13);
        r0 = r11.getEventType();
        r3 = 0;
        r2 = 0;
    L_0x000b:
        r1 = 2;
        if (r0 != r1) goto L_0x0046;
    L_0x000e:
        r0 = r11.getName();
        r1 = "menu";
        r1 = r0.equals(r1);
        if (r1 == 0) goto L_0x0031;
    L_0x001a:
        r0 = r11.next();
    L_0x001e:
        r1 = 0;
    L_0x001f:
        if (r1 != 0) goto L_0x022f;
    L_0x0021:
        switch(r0) {
            case 1: goto L_0x0227;
            case 2: goto L_0x004e;
            case 3: goto L_0x01be;
            default: goto L_0x0024;
        };
    L_0x0024:
        r0 = r1;
        r1 = r2;
        r2 = r3;
    L_0x0027:
        r3 = r11.next();
        r9 = r0;
        r0 = r3;
        r3 = r2;
        r2 = r1;
        r1 = r9;
        goto L_0x001f;
    L_0x0031:
        r1 = new java.lang.RuntimeException;
        r2 = new java.lang.StringBuilder;
        r3 = "Expecting menu, got ";
        r2.<init>(r3);
        r0 = r2.append(r0);
        r0 = r0.toString();
        r1.<init>(r0);
        throw r1;
    L_0x0046:
        r0 = r11.next();
        r1 = 1;
        if (r0 != r1) goto L_0x000b;
    L_0x004d:
        goto L_0x001e;
    L_0x004e:
        if (r3 != 0) goto L_0x0024;
    L_0x0050:
        r0 = r11.getName();
        r5 = "group";
        r5 = r0.equals(r5);
        if (r5 == 0) goto L_0x00a3;
    L_0x005c:
        r0 = r4.z;
        r0 = r0.e;
        r5 = android.support.v7.c.h.MenuGroup;
        r0 = r0.obtainStyledAttributes(r12, r5);
        r5 = android.support.v7.c.h.MenuGroup_android_id;
        r6 = 0;
        r5 = r0.getResourceId(r5, r6);
        r4.b = r5;
        r5 = android.support.v7.c.h.MenuGroup_android_menuCategory;
        r6 = 0;
        r5 = r0.getInt(r5, r6);
        r4.c = r5;
        r5 = android.support.v7.c.h.MenuGroup_android_orderInCategory;
        r6 = 0;
        r5 = r0.getInt(r5, r6);
        r4.d = r5;
        r5 = android.support.v7.c.h.MenuGroup_android_checkableBehavior;
        r6 = 0;
        r5 = r0.getInt(r5, r6);
        r4.e = r5;
        r5 = android.support.v7.c.h.MenuGroup_android_visible;
        r6 = 1;
        r5 = r0.getBoolean(r5, r6);
        r4.f = r5;
        r5 = android.support.v7.c.h.MenuGroup_android_enabled;
        r6 = 1;
        r5 = r0.getBoolean(r5, r6);
        r4.g = r5;
        r0.recycle();
        r0 = r1;
        r1 = r2;
        r2 = r3;
        goto L_0x0027;
    L_0x00a3:
        r5 = "item";
        r5 = r0.equals(r5);
        if (r5 == 0) goto L_0x01a4;
    L_0x00ab:
        r0 = r4.z;
        r0 = r0.e;
        r5 = android.support.v7.c.h.MenuItem;
        r5 = r0.obtainStyledAttributes(r12, r5);
        r0 = android.support.v7.c.h.MenuItem_android_id;
        r6 = 0;
        r0 = r5.getResourceId(r0, r6);
        r4.i = r0;
        r0 = android.support.v7.c.h.MenuItem_android_menuCategory;
        r6 = r4.c;
        r0 = r5.getInt(r0, r6);
        r6 = android.support.v7.c.h.MenuItem_android_orderInCategory;
        r7 = r4.d;
        r6 = r5.getInt(r6, r7);
        r7 = -65536; // 0xffffffffffff0000 float:NaN double:NaN;
        r0 = r0 & r7;
        r7 = 65535; // 0xffff float:9.1834E-41 double:3.23786E-319;
        r6 = r6 & r7;
        r0 = r0 | r6;
        r4.j = r0;
        r0 = android.support.v7.c.h.MenuItem_android_title;
        r0 = r5.getText(r0);
        r4.k = r0;
        r0 = android.support.v7.c.h.MenuItem_android_titleCondensed;
        r0 = r5.getText(r0);
        r4.l = r0;
        r0 = android.support.v7.c.h.MenuItem_android_icon;
        r6 = 0;
        r0 = r5.getResourceId(r0, r6);
        r4.m = r0;
        r0 = android.support.v7.c.h.MenuItem_android_alphabeticShortcut;
        r0 = r5.getString(r0);
        r0 = android.support.v7.view.j.a(r0);
        r4.n = r0;
        r0 = android.support.v7.c.h.MenuItem_android_numericShortcut;
        r0 = r5.getString(r0);
        r0 = android.support.v7.view.j.a(r0);
        r4.o = r0;
        r0 = android.support.v7.c.h.MenuItem_android_checkable;
        r0 = r5.hasValue(r0);
        if (r0 == 0) goto L_0x0190;
    L_0x0111:
        r0 = android.support.v7.c.h.MenuItem_android_checkable;
        r6 = 0;
        r0 = r5.getBoolean(r0, r6);
        if (r0 == 0) goto L_0x018e;
    L_0x011a:
        r0 = 1;
    L_0x011b:
        r4.p = r0;
    L_0x011d:
        r0 = android.support.v7.c.h.MenuItem_android_checked;
        r6 = 0;
        r0 = r5.getBoolean(r0, r6);
        r4.q = r0;
        r0 = android.support.v7.c.h.MenuItem_android_visible;
        r6 = r4.f;
        r0 = r5.getBoolean(r0, r6);
        r4.r = r0;
        r0 = android.support.v7.c.h.MenuItem_android_enabled;
        r6 = r4.g;
        r0 = r5.getBoolean(r0, r6);
        r4.s = r0;
        r0 = android.support.v7.c.h.MenuItem_showAsAction;
        r6 = -1;
        r0 = r5.getInt(r0, r6);
        r4.t = r0;
        r0 = android.support.v7.c.h.MenuItem_android_onClick;
        r0 = r5.getString(r0);
        r4.x = r0;
        r0 = android.support.v7.c.h.MenuItem_actionLayout;
        r6 = 0;
        r0 = r5.getResourceId(r0, r6);
        r4.u = r0;
        r0 = android.support.v7.c.h.MenuItem_actionViewClass;
        r0 = r5.getString(r0);
        r4.v = r0;
        r0 = android.support.v7.c.h.MenuItem_actionProviderClass;
        r0 = r5.getString(r0);
        r4.w = r0;
        r0 = r4.w;
        if (r0 == 0) goto L_0x0195;
    L_0x0168:
        r0 = 1;
    L_0x0169:
        if (r0 == 0) goto L_0x0197;
    L_0x016b:
        r6 = r4.u;
        if (r6 != 0) goto L_0x0197;
    L_0x016f:
        r6 = r4.v;
        if (r6 != 0) goto L_0x0197;
    L_0x0173:
        r0 = r4.w;
        r6 = b;
        r7 = r4.z;
        r7 = r7.d;
        r0 = r4.a(r0, r6, r7);
        r0 = (android.support.v4.view.bl) r0;
        r4.y = r0;
    L_0x0183:
        r5.recycle();
        r0 = 0;
        r4.h = r0;
        r0 = r1;
        r1 = r2;
        r2 = r3;
        goto L_0x0027;
    L_0x018e:
        r0 = 0;
        goto L_0x011b;
    L_0x0190:
        r0 = r4.e;
        r4.p = r0;
        goto L_0x011d;
    L_0x0195:
        r0 = 0;
        goto L_0x0169;
    L_0x0197:
        if (r0 == 0) goto L_0x01a0;
    L_0x0199:
        r0 = "SupportMenuInflater";
        r6 = "Ignoring attribute 'actionProviderClass'. Action view already specified.";
        android.util.Log.w(r0, r6);
    L_0x01a0:
        r0 = 0;
        r4.y = r0;
        goto L_0x0183;
    L_0x01a4:
        r5 = "menu";
        r5 = r0.equals(r5);
        if (r5 == 0) goto L_0x01b8;
    L_0x01ac:
        r0 = r4.b();
        r10.a(r11, r12, r0);
        r0 = r1;
        r1 = r2;
        r2 = r3;
        goto L_0x0027;
    L_0x01b8:
        r2 = 1;
        r9 = r1;
        r1 = r0;
        r0 = r9;
        goto L_0x0027;
    L_0x01be:
        r0 = r11.getName();
        if (r3 == 0) goto L_0x01d1;
    L_0x01c4:
        r5 = r0.equals(r2);
        if (r5 == 0) goto L_0x01d1;
    L_0x01ca:
        r2 = 0;
        r0 = 0;
        r9 = r1;
        r1 = r0;
        r0 = r9;
        goto L_0x0027;
    L_0x01d1:
        r5 = "group";
        r5 = r0.equals(r5);
        if (r5 == 0) goto L_0x01e1;
    L_0x01d9:
        r4.a();
        r0 = r1;
        r1 = r2;
        r2 = r3;
        goto L_0x0027;
    L_0x01e1:
        r5 = "item";
        r5 = r0.equals(r5);
        if (r5 == 0) goto L_0x021a;
    L_0x01e9:
        r0 = r4.h;
        if (r0 != 0) goto L_0x0024;
    L_0x01ed:
        r0 = r4.y;
        if (r0 == 0) goto L_0x0201;
    L_0x01f1:
        r0 = r4.y;
        r0 = r0.e();
        if (r0 == 0) goto L_0x0201;
    L_0x01f9:
        r4.b();
        r0 = r1;
        r1 = r2;
        r2 = r3;
        goto L_0x0027;
    L_0x0201:
        r0 = 1;
        r4.h = r0;
        r0 = r4.a;
        r5 = r4.b;
        r6 = r4.i;
        r7 = r4.j;
        r8 = r4.k;
        r0 = r0.add(r5, r6, r7, r8);
        r4.a(r0);
        r0 = r1;
        r1 = r2;
        r2 = r3;
        goto L_0x0027;
    L_0x021a:
        r5 = "menu";
        r0 = r0.equals(r5);
        if (r0 == 0) goto L_0x0024;
    L_0x0222:
        r0 = 1;
        r1 = r2;
        r2 = r3;
        goto L_0x0027;
    L_0x0227:
        r0 = new java.lang.RuntimeException;
        r1 = "Unexpected end of document";
        r0.<init>(r1);
        throw r0;
    L_0x022f:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.view.i.a(org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.view.Menu):void");
    }

    static /* synthetic */ Object b(i iVar) {
        if (iVar.f == null) {
            Object obj = iVar.e;
            while (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) {
                obj = ((ContextWrapper) obj).getBaseContext();
            }
            iVar.f = obj;
        }
        return iVar.f;
    }
}
