package com.uc.framework.xml;

import android.content.res.XmlResourceParser;
import android.util.TypedValue;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: ProGuard */
public final class d implements XmlResourceParser {
    public int a;
    public final /* synthetic */ XmlBlockModify b;
    private final XmlBlockModify c;
    private boolean d = false;
    private boolean e = false;
    private int f = 0;
    private int g = 0;

    d(XmlBlockModify xmlBlockModify, int i, XmlBlockModify xmlBlockModify2) {
        this.b = xmlBlockModify;
        this.a = i;
        this.c = xmlBlockModify2;
        xmlBlockModify2.d = xmlBlockModify2.d + 1;
    }

    public final void setFeature(String str, boolean z) throws XmlPullParserException {
        if (!"http://xmlpull.org/v1/doc/features.html#process-namespaces".equals(str) || !z) {
            if (!"http://xmlpull.org/v1/doc/features.html#report-namespace-prefixes".equals(str) || !z) {
                throw new XmlPullParserException("Unsupported feature: " + str);
            }
        }
    }

    public final boolean getFeature(String str) {
        if ("http://xmlpull.org/v1/doc/features.html#process-namespaces".equals(str) || "http://xmlpull.org/v1/doc/features.html#report-namespace-prefixes".equals(str)) {
            return true;
        }
        return false;
    }

    public final void setProperty(String str, Object obj) throws XmlPullParserException {
        throw new XmlPullParserException("setProperty() not supported");
    }

    public final Object getProperty(String str) {
        return null;
    }

    public final void setInput(Reader reader) throws XmlPullParserException {
        throw new XmlPullParserException("setInput() not supported");
    }

    public final void setInput(InputStream inputStream, String str) throws XmlPullParserException {
        throw new XmlPullParserException("setInput() not supported");
    }

    public final void defineEntityReplacementText(String str, String str2) throws XmlPullParserException {
        throw new XmlPullParserException("defineEntityReplacementText() not supported");
    }

    public final String getNamespacePrefix(int i) throws XmlPullParserException {
        throw new XmlPullParserException("getNamespacePrefix() not supported");
    }

    public final String getInputEncoding() {
        return null;
    }

    public final String getNamespace(String str) {
        throw new RuntimeException("getNamespace() not supported");
    }

    public final int getNamespaceCount(int i) throws XmlPullParserException {
        throw new XmlPullParserException("getNamespaceCount() not supported");
    }

    public final String getPositionDescription() {
        return "Binary XML file line #" + getLineNumber();
    }

    public final String getNamespaceUri(int i) throws XmlPullParserException {
        throw new XmlPullParserException("getNamespaceUri() not supported");
    }

    public final int getColumnNumber() {
        return -1;
    }

    public final int getDepth() {
        return this.f;
    }

    public final String getText() {
        int a = XmlBlockModify.nativeGetText(this.a);
        return a >= 0 ? this.b.b.a(a).toString() : null;
    }

    public final int getLineNumber() {
        return XmlBlockModify.nativeGetLineNumber(this.a);
    }

    public final int getEventType() throws XmlPullParserException {
        return this.g;
    }

    public final boolean isWhitespace() throws XmlPullParserException {
        return false;
    }

    public final String getPrefix() {
        throw new RuntimeException("getPrefix not supported");
    }

    public final char[] getTextCharacters(int[] iArr) {
        String text = getText();
        if (text == null) {
            return null;
        }
        iArr[0] = 0;
        iArr[1] = text.length();
        char[] cArr = new char[text.length()];
        text.getChars(0, text.length(), cArr, 0);
        return cArr;
    }

    public final String getNamespace() {
        int c = XmlBlockModify.nativeGetNamespace(this.a);
        return c >= 0 ? this.b.b.a(c).toString() : "";
    }

    public final String getName() {
        int d = XmlBlockModify.nativeGetName(this.a);
        return d >= 0 ? this.b.b.a(d).toString() : null;
    }

    public final String getAttributeNamespace(int i) {
        int a = XmlBlockModify.nativeGetAttributeNamespace(this.a, i);
        if (a >= 0) {
            return this.b.b.a(a).toString();
        }
        if (a == -1) {
            return "";
        }
        throw new IndexOutOfBoundsException(String.valueOf(i));
    }

    public final String getAttributeName(int i) {
        int b = XmlBlockModify.nativeGetAttributeName(this.a, i);
        if (b >= 0) {
            return this.b.b.a(b).toString();
        }
        throw new IndexOutOfBoundsException(String.valueOf(i));
    }

    public final String getAttributePrefix(int i) {
        throw new RuntimeException("getAttributePrefix not supported");
    }

    public final boolean isEmptyElementTag() throws XmlPullParserException {
        return false;
    }

    public final int getAttributeCount() {
        return this.g == 2 ? XmlBlockModify.nativeGetAttributeCount(this.a) : -1;
    }

    public final String getAttributeValue(int i) {
        int c = XmlBlockModify.nativeGetAttributeStringValue(this.a, i);
        if (c >= 0) {
            return this.b.b.a(c).toString();
        }
        c = XmlBlockModify.nativeGetAttributeDataType(this.a, i);
        if (c != 0) {
            return TypedValue.coerceToString(c, XmlBlockModify.nativeGetAttributeData(this.a, i));
        }
        throw new IndexOutOfBoundsException(String.valueOf(i));
    }

    public final String getAttributeType(int i) {
        return "CDATA";
    }

    public final boolean isAttributeDefault(int i) {
        return false;
    }

    public final int nextToken() throws XmlPullParserException, IOException {
        return next();
    }

    public final String getAttributeValue(String str, String str2) {
        int a = XmlBlockModify.nativeGetAttributeIndex(this.a, str, str2);
        if (a >= 0) {
            return getAttributeValue(a);
        }
        return null;
    }

    public final int next() throws XmlPullParserException, IOException {
        if (!this.d) {
            this.d = true;
            return 0;
        } else if (this.a == 0) {
            return 1;
        } else {
            int f = XmlBlockModify.nativeNext(this.a);
            if (this.e) {
                this.f--;
                this.e = false;
            }
            switch (f) {
                case 2:
                    this.f++;
                    break;
                case 3:
                    this.e = true;
                    break;
            }
            this.g = f;
            if (f == 1) {
                close();
            }
            return f;
        }
    }

    public final void require(int i, String str, String str2) throws XmlPullParserException, IOException {
        if (i != getEventType() || ((str != null && !str.equals(getNamespace())) || (str2 != null && !str2.equals(getName())))) {
            throw new XmlPullParserException("expected " + TYPES[i] + getPositionDescription());
        }
    }

    public final String nextText() throws XmlPullParserException, IOException {
        if (getEventType() != 2) {
            throw new XmlPullParserException(getPositionDescription() + ": parser must be on START_TAG to read next text", this, null);
        }
        int next = next();
        if (next == 4) {
            String text = getText();
            if (next() == 3) {
                return text;
            }
            throw new XmlPullParserException(getPositionDescription() + ": event TEXT it must be immediately followed by END_TAG", this, null);
        } else if (next == 3) {
            return "";
        } else {
            throw new XmlPullParserException(getPositionDescription() + ": parser must be on START_TAG or TEXT to read text", this, null);
        }
    }

    public final int nextTag() throws XmlPullParserException, IOException {
        int next = next();
        if (next == 4 && isWhitespace()) {
            next = next();
        }
        if (next == 2 || next == 3) {
            return next;
        }
        throw new XmlPullParserException(getPositionDescription() + ": expected start or end tag", this, null);
    }

    public final int getAttributeNameResource(int i) {
        return XmlBlockModify.nativeGetAttributeResource(this.a, i);
    }

    public final int getAttributeListValue(String str, String str2, String[] strArr, int i) {
        int a = XmlBlockModify.nativeGetAttributeIndex(this.a, str, str2);
        if (a >= 0) {
            return getAttributeListValue(a, strArr, i);
        }
        return i;
    }

    public final boolean getAttributeBooleanValue(String str, String str2, boolean z) {
        int a = XmlBlockModify.nativeGetAttributeIndex(this.a, str, str2);
        if (a >= 0) {
            return getAttributeBooleanValue(a, z);
        }
        return z;
    }

    public final int getAttributeResourceValue(String str, String str2, int i) {
        int a = XmlBlockModify.nativeGetAttributeIndex(this.a, str, str2);
        if (a >= 0) {
            return getAttributeResourceValue(a, i);
        }
        return i;
    }

    public final int getAttributeIntValue(String str, String str2, int i) {
        int a = XmlBlockModify.nativeGetAttributeIndex(this.a, str, str2);
        if (a >= 0) {
            return getAttributeIntValue(a, i);
        }
        return i;
    }

    public final int getAttributeUnsignedIntValue(String str, String str2, int i) {
        int a = XmlBlockModify.nativeGetAttributeIndex(this.a, str, str2);
        if (a >= 0) {
            return getAttributeUnsignedIntValue(a, i);
        }
        return i;
    }

    public final float getAttributeFloatValue(String str, String str2, float f) {
        int a = XmlBlockModify.nativeGetAttributeIndex(this.a, str, str2);
        if (a >= 0) {
            return getAttributeFloatValue(a, f);
        }
        return f;
    }

    public final int getAttributeListValue(int i, String[] strArr, int i2) {
        int d = XmlBlockModify.nativeGetAttributeDataType(this.a, i);
        int e = XmlBlockModify.nativeGetAttributeData(this.a, i);
        if (d != 3) {
            return e;
        }
        CharSequence a = this.b.b.a(e);
        if (a != null) {
            for (e = 0; e < strArr.length; e++) {
                if (a.equals(strArr[e])) {
                    return e;
                }
            }
        }
        return i2;
    }

    public final boolean getAttributeBooleanValue(int i, boolean z) {
        int d = XmlBlockModify.nativeGetAttributeDataType(this.a, i);
        if (d < 16 || d > 31) {
            return z;
        }
        return XmlBlockModify.nativeGetAttributeData(this.a, i) != 0;
    }

    public final int getAttributeResourceValue(int i, int i2) {
        if (XmlBlockModify.nativeGetAttributeDataType(this.a, i) == 1) {
            return XmlBlockModify.nativeGetAttributeData(this.a, i);
        }
        return i2;
    }

    public final int getAttributeIntValue(int i, int i2) {
        int d = XmlBlockModify.nativeGetAttributeDataType(this.a, i);
        if (d < 16 || d > 31) {
            return i2;
        }
        return XmlBlockModify.nativeGetAttributeData(this.a, i);
    }

    public final int getAttributeUnsignedIntValue(int i, int i2) {
        int d = XmlBlockModify.nativeGetAttributeDataType(this.a, i);
        if (d < 16 || d > 31) {
            return i2;
        }
        return XmlBlockModify.nativeGetAttributeData(this.a, i);
    }

    public final float getAttributeFloatValue(int i, float f) {
        if (XmlBlockModify.nativeGetAttributeDataType(this.a, i) == 4) {
            return Float.intBitsToFloat(XmlBlockModify.nativeGetAttributeData(this.a, i));
        }
        throw new RuntimeException("not a float!");
    }

    public final String getIdAttribute() {
        int g = XmlBlockModify.nativeGetIdAttribute(this.a);
        return g >= 0 ? this.b.b.a(g).toString() : null;
    }

    public final String getClassAttribute() {
        int h = XmlBlockModify.nativeGetClassAttribute(this.a);
        return h >= 0 ? this.b.b.a(h).toString() : null;
    }

    public final int getIdAttributeResourceValue(int i) {
        return getAttributeResourceValue(null, "id", i);
    }

    public final int getStyleAttribute() {
        return XmlBlockModify.nativeGetStyleAttribute(this.a);
    }

    public final void close() {
        synchronized (this.c) {
            if (this.a != 0) {
                XmlBlockModify.nativeDestroyParseState(this.a);
                this.a = 0;
                this.c.b();
            }
        }
    }

    protected final void finalize() throws Throwable {
        close();
    }
}
