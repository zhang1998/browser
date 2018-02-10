package com.uc.framework.xml;

import android.content.res.XmlResourceParser;

/* compiled from: ProGuard */
public final class XmlBlockModify {
    private final int a;
    private final StringBlockModify b;
    private boolean c = true;
    private int d = 1;

    private static final native int nativeCreate(byte[] bArr, int i, int i2);

    private static final native int nativeCreateParseState(int i);

    private static final native void nativeDestroy(int i);

    private static final native void nativeDestroyParseState(int i);

    private static final native int nativeGetAttributeCount(int i);

    private static final native int nativeGetAttributeData(int i, int i2);

    private static final native int nativeGetAttributeDataType(int i, int i2);

    private static final native int nativeGetAttributeIndex(int i, String str, String str2);

    private static final native int nativeGetAttributeName(int i, int i2);

    private static final native int nativeGetAttributeNamespace(int i, int i2);

    private static final native int nativeGetAttributeResource(int i, int i2);

    private static final native int nativeGetAttributeStringValue(int i, int i2);

    private static final native int nativeGetClassAttribute(int i);

    private static final native int nativeGetIdAttribute(int i);

    private static final native int nativeGetLineNumber(int i);

    private static final native int nativeGetName(int i);

    private static final native int nativeGetNamespace(int i);

    private static final native int nativeGetStringBlock(int i);

    private static final native int nativeGetStyleAttribute(int i);

    private static final native int nativeGetText(int i);

    private static final native int nativeGetTextByAttrValue(int i, String str);

    private static final native int nativeNext(int i);

    public XmlBlockModify(byte[] bArr) {
        this.a = nativeCreate(bArr, 0, bArr.length);
        this.b = new StringBlockModify(nativeGetStringBlock(this.a));
    }

    private void b() {
        this.d--;
        if (this.d == 0) {
            nativeDestroy(this.a);
        }
    }

    public final XmlResourceParser a() {
        synchronized (this) {
            if (this.a != 0) {
                XmlResourceParser dVar = new d(this, nativeCreateParseState(this.a), this);
                return dVar;
            }
            return null;
        }
    }

    protected final void finalize() throws Throwable {
        synchronized (this) {
            if (this.c) {
                this.c = false;
                b();
            }
        }
    }
}
