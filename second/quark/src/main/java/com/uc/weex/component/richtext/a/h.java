package com.uc.weex.component.richtext.a;

import com.uc.apollo.impl.SettingsConst;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.DTDHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.XMLReader;
import org.xml.sax.ext.LexicalHandler;
import org.xml.sax.helpers.DefaultHandler;

/* compiled from: ProGuard */
public final class h extends DefaultHandler implements i, XMLReader, LexicalHandler {
    private static char[] M = new char[]{'<', '/', '>'};
    private static String O = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-'()+,./:=?;!*#@$_%";
    private static boolean i = true;
    private static boolean j = false;
    private static boolean k = false;
    private static boolean l = true;
    private static boolean m = true;
    private static boolean n = false;
    private static boolean o = true;
    private static boolean p = false;
    private static boolean q = true;
    private HashMap A = new HashMap();
    private c B;
    private String C;
    private boolean D;
    private String E;
    private String F;
    private String G;
    private String H;
    private c I;
    private c J;
    private c K;
    private int L;
    private boolean N;
    private char[] P;
    private ContentHandler a = this;
    private LexicalHandler b = this;
    private DTDHandler c = this;
    private ErrorHandler d = this;
    private EntityResolver e = this;
    private k f;
    private j g;
    private b h;
    private boolean r = i;
    private boolean s = j;
    private boolean t = k;
    private boolean u = l;
    private boolean v = m;
    private boolean w = n;
    private boolean x = o;
    private boolean y = p;
    private boolean z = q;

    public h() {
        this.A.put("http://xml.org/sax/features/namespaces", a(i));
        this.A.put("http://xml.org/sax/features/namespace-prefixes", Boolean.FALSE);
        this.A.put("http://xml.org/sax/features/external-general-entities", Boolean.FALSE);
        this.A.put("http://xml.org/sax/features/external-parameter-entities", Boolean.FALSE);
        this.A.put("http://xml.org/sax/features/is-standalone", Boolean.FALSE);
        this.A.put("http://xml.org/sax/features/lexical-handler/parameter-entities", Boolean.FALSE);
        this.A.put("http://xml.org/sax/features/resolve-dtd-uris", Boolean.TRUE);
        this.A.put("http://xml.org/sax/features/string-interning", Boolean.TRUE);
        this.A.put("http://xml.org/sax/features/use-attributes2", Boolean.FALSE);
        this.A.put("http://xml.org/sax/features/use-locator2", Boolean.FALSE);
        this.A.put("http://xml.org/sax/features/use-entity-resolver2", Boolean.FALSE);
        this.A.put("http://xml.org/sax/features/validation", Boolean.FALSE);
        this.A.put("http://xml.org/sax/features/xmlns-uris", Boolean.FALSE);
        this.A.put("http://xml.org/sax/features/xmlns-uris", Boolean.FALSE);
        this.A.put("http://xml.org/sax/features/xml-1.1", Boolean.FALSE);
        this.A.put("http://www.ccil.org/~cowan/tagsoup/features/ignore-bogons", a(j));
        this.A.put("http://www.ccil.org/~cowan/tagsoup/features/bogons-empty", a(k));
        this.A.put("http://www.ccil.org/~cowan/tagsoup/features/root-bogons", a(l));
        this.A.put("http://www.ccil.org/~cowan/tagsoup/features/default-attributes", a(m));
        this.A.put("http://www.ccil.org/~cowan/tagsoup/features/translate-colons", a(n));
        this.A.put("http://www.ccil.org/~cowan/tagsoup/features/restart-elements", a(o));
        this.A.put("http://www.ccil.org/~cowan/tagsoup/features/ignorable-whitespace", a(p));
        this.A.put("http://www.ccil.org/~cowan/tagsoup/features/cdata-elements", a(q));
        this.B = null;
        this.C = null;
        this.D = false;
        this.E = null;
        this.F = null;
        this.G = null;
        this.H = null;
        this.I = null;
        this.J = null;
        this.K = null;
        this.L = 0;
        this.N = true;
        this.P = new char[SettingsConst.GLOBAL_SETTINGS];
    }

    private static Boolean a(boolean z) {
        return z ? Boolean.TRUE : Boolean.FALSE;
    }

    public final boolean getFeature(String str) throws SAXNotRecognizedException, SAXNotSupportedException {
        Boolean bool = (Boolean) this.A.get(str);
        if (bool != null) {
            return bool.booleanValue();
        }
        throw new SAXNotRecognizedException("Unknown feature " + str);
    }

    public final void setFeature(String str, boolean z) throws SAXNotRecognizedException, SAXNotSupportedException {
        if (((Boolean) this.A.get(str)) == null) {
            throw new SAXNotRecognizedException("Unknown feature " + str);
        }
        if (z) {
            this.A.put(str, Boolean.TRUE);
        } else {
            this.A.put(str, Boolean.FALSE);
        }
        if (str.equals("http://xml.org/sax/features/namespaces")) {
            this.r = z;
        } else if (str.equals("http://www.ccil.org/~cowan/tagsoup/features/ignore-bogons")) {
            this.s = z;
        } else if (str.equals("http://www.ccil.org/~cowan/tagsoup/features/bogons-empty")) {
            this.t = z;
        } else if (str.equals("http://www.ccil.org/~cowan/tagsoup/features/root-bogons")) {
            this.u = z;
        } else if (str.equals("http://www.ccil.org/~cowan/tagsoup/features/default-attributes")) {
            this.v = z;
        } else if (str.equals("http://www.ccil.org/~cowan/tagsoup/features/translate-colons")) {
            this.w = z;
        } else if (str.equals("http://www.ccil.org/~cowan/tagsoup/features/restart-elements")) {
            this.x = z;
        } else if (str.equals("http://www.ccil.org/~cowan/tagsoup/features/ignorable-whitespace")) {
            this.y = z;
        } else if (str.equals("http://www.ccil.org/~cowan/tagsoup/features/cdata-elements")) {
            this.z = z;
        }
    }

    public final Object getProperty(String str) throws SAXNotRecognizedException, SAXNotSupportedException {
        if (str.equals("http://xml.org/sax/properties/lexical-handler")) {
            return this.b == this ? null : this.b;
        } else {
            if (str.equals("http://www.ccil.org/~cowan/tagsoup/properties/scanner")) {
                return this.g;
            }
            if (str.equals("http://www.ccil.org/~cowan/tagsoup/properties/schema")) {
                return this.f;
            }
            if (str.equals("http://www.ccil.org/~cowan/tagsoup/properties/auto-detector")) {
                return this.h;
            }
            throw new SAXNotRecognizedException("Unknown property " + str);
        }
    }

    public final void setProperty(String str, Object obj) throws SAXNotRecognizedException, SAXNotSupportedException {
        if (str.equals("http://xml.org/sax/properties/lexical-handler")) {
            if (obj == null) {
                this.b = this;
            } else if (obj instanceof LexicalHandler) {
                this.b = (LexicalHandler) obj;
            } else {
                throw new SAXNotSupportedException("Your lexical handler is not a LexicalHandler");
            }
        } else if (str.equals("http://www.ccil.org/~cowan/tagsoup/properties/scanner")) {
            if (obj instanceof j) {
                this.g = (j) obj;
                return;
            }
            throw new SAXNotSupportedException("Your scanner is not a Scanner");
        } else if (str.equals("http://www.ccil.org/~cowan/tagsoup/properties/schema")) {
            if (obj instanceof k) {
                this.f = (k) obj;
                return;
            }
            throw new SAXNotSupportedException("Your schema is not a Schema");
        } else if (!str.equals("http://www.ccil.org/~cowan/tagsoup/properties/auto-detector")) {
            throw new SAXNotRecognizedException("Unknown property " + str);
        } else if (obj instanceof b) {
            this.h = (b) obj;
        } else {
            throw new SAXNotSupportedException("Your auto-detector is not an AutoDetector");
        }
    }

    public final void setEntityResolver(EntityResolver entityResolver) {
        if (entityResolver == null) {
            entityResolver = this;
        }
        this.e = entityResolver;
    }

    public final EntityResolver getEntityResolver() {
        return this.e == this ? null : this.e;
    }

    public final void setDTDHandler(DTDHandler dTDHandler) {
        if (dTDHandler == null) {
            dTDHandler = this;
        }
        this.c = dTDHandler;
    }

    public final DTDHandler getDTDHandler() {
        return this.c == this ? null : this.c;
    }

    public final void setContentHandler(ContentHandler contentHandler) {
        if (contentHandler == null) {
            contentHandler = this;
        }
        this.a = contentHandler;
    }

    public final ContentHandler getContentHandler() {
        return this.a == this ? null : this.a;
    }

    public final void setErrorHandler(ErrorHandler errorHandler) {
        if (errorHandler == null) {
            errorHandler = this;
        }
        this.d = errorHandler;
    }

    public final ErrorHandler getErrorHandler() {
        return this.d == this ? null : this.d;
    }

    public final void parse(InputSource inputSource) throws IOException, SAXException {
        if (this.f == null) {
            this.f = new f();
        }
        if (this.g == null) {
            this.g = new e();
        }
        if (this.h == null) {
            this.h = new g(this);
        }
        this.I = new c(this.f.a("<root>"), this.v);
        this.K = new c(this.f.a("<pcdata>"), this.v);
        this.B = null;
        this.C = null;
        this.H = null;
        this.J = null;
        this.L = 0;
        this.N = true;
        this.F = null;
        this.E = null;
        this.G = null;
        Reader a = a(inputSource);
        this.a.startDocument();
        this.g.a(inputSource.getPublicId(), inputSource.getSystemId());
        if (this.g instanceof Locator) {
            this.a.setDocumentLocator((Locator) this.g);
        }
        if (!this.f.b.equals("")) {
            this.a.startPrefixMapping(this.f.c, this.f.b);
        }
        this.g.a(a, (i) this);
    }

    public final void parse(String str) throws IOException, SAXException {
        parse(new InputSource(str));
    }

    private Reader a(InputSource inputSource) throws SAXException, IOException {
        Reader characterStream = inputSource.getCharacterStream();
        InputStream byteStream = inputSource.getByteStream();
        String encoding = inputSource.getEncoding();
        inputSource.getPublicId();
        String systemId = inputSource.getSystemId();
        if (characterStream != null) {
            return characterStream;
        }
        if (byteStream == null) {
            byteStream = new URL(new URL("file", "", System.getProperty("user.dir") + "/."), systemId).openConnection().getInputStream();
        }
        if (encoding == null) {
            return this.h.a(byteStream);
        }
        try {
            return new InputStreamReader(byteStream, encoding);
        } catch (UnsupportedEncodingException e) {
            return new InputStreamReader(byteStream);
        }
    }

    public final void a() throws SAXException {
        if (this.B != null && this.C != null) {
            this.B.a(this.C, this.C);
            this.C = null;
        }
    }

    public final void a(char[] cArr, int i) throws SAXException {
        if (this.B != null) {
            this.C = b(cArr, 0, i).toLowerCase();
        }
    }

    public final void b(char[] cArr, int i) throws SAXException {
        if (this.B != null && this.C != null) {
            this.B.a(this.C, a(new String(cArr, 0, i)));
            this.C = null;
        }
    }

    private String a(String str) {
        int length = str.length();
        char[] cArr = new char[length];
        int i = 0;
        int i2 = 0;
        int i3 = -1;
        while (i < length) {
            char charAt = str.charAt(i);
            int i4 = i2 + 1;
            cArr[i2] = charAt;
            if (charAt == '&' && i3 == -1) {
                i3 = i4;
            } else if (!(i3 == -1 || Character.isLetter(charAt) || Character.isDigit(charAt) || charAt == '#')) {
                if (charAt == ';') {
                    i2 = a(cArr, i3, (i4 - i3) - 1);
                    if (i2 > 65535) {
                        i4 = i2 - 65536;
                        cArr[i3 - 1] = (char) ((i4 >> 10) + 55296);
                        cArr[i3] = (char) ((i4 & 1023) + 56320);
                        i3++;
                    } else if (i2 != 0) {
                        cArr[i3 - 1] = (char) i2;
                    } else {
                        i3 = i4;
                    }
                    i4 = i3;
                    i3 = -1;
                } else {
                    i3 = -1;
                }
            }
            i++;
            i2 = i4;
        }
        return new String(cArr, 0, i2);
    }

    public final void c(char[] cArr, int i) throws SAXException {
        this.L = a(cArr, 1, i);
    }

    private int a(char[] cArr, int i, int i2) {
        if (i2 <= 0) {
            return 0;
        }
        if (cArr[i] != '#') {
            k kVar = this.f;
            Integer num = (Integer) kVar.a.get(new String(cArr, i, i2));
            if (num == null) {
                return 0;
            }
            return num.intValue();
        } else if (i2 <= 1 || !(cArr[i + 1] == 'x' || cArr[i + 1] == 'X')) {
            try {
                return Integer.parseInt(new String(cArr, i + 1, i2 - 1), 10);
            } catch (NumberFormatException e) {
                return 0;
            }
        } else {
            try {
                return Integer.parseInt(new String(cArr, i + 2, i2 - 2), 16);
            } catch (NumberFormatException e2) {
                return 0;
            }
        }
    }

    public final void b() throws SAXException {
        if (this.N) {
            c(this.K);
        }
        while (this.I.c != null) {
            d();
        }
        if (!this.f.b.equals("")) {
            this.a.endPrefixMapping(this.f.c);
        }
        this.a.endDocument();
    }

    public final void d(char[] cArr, int i) throws SAXException {
        int i2 = 1;
        String str = this.I.a.a;
        if (this.z && (this.I.a.f & 2) != 0) {
            int i3 = i == str.length() ? 1 : 0;
            if (i3 != 0) {
                for (int i4 = 0; i4 < i; i4++) {
                    if (Character.toLowerCase(cArr[i4 + 0]) != Character.toLowerCase(str.charAt(i4))) {
                        i3 = 0;
                        break;
                    }
                }
            }
            if (i3 == 0) {
                this.a.characters(M, 0, 2);
                this.a.characters(cArr, 0, i);
                this.a.characters(M, 2, 1);
                this.g.a();
                if (i2 != 0) {
                    m(cArr, i);
                }
            }
        }
        i2 = 0;
        if (i2 != 0) {
            m(cArr, i);
        }
    }

    private void m(char[] r8, int r9) throws org.xml.sax.SAXException {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:37)
	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:61)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r7 = this;
        r5 = 0;
        r2 = 1;
        r3 = 0;
        r7.B = r5;
        if (r9 == 0) goto L_0x0033;
    L_0x0007:
        r0 = r7.b(r8, r3, r9);
        r1 = r7.f;
        r0 = r1.a(r0);
        if (r0 != 0) goto L_0x0014;
    L_0x0013:
        return;
    L_0x0014:
        r0 = r0.a;
    L_0x0016:
        r1 = r7.I;
        r6 = r1;
        r1 = r3;
        r3 = r6;
    L_0x001b:
        if (r3 == 0) goto L_0x003a;
    L_0x001d:
        r4 = r3.a;
        r4 = r4.a;
        r4 = r4.equals(r0);
        if (r4 != 0) goto L_0x003a;
    L_0x0027:
        r4 = r3.a;
        r4 = r4.f;
        r4 = r4 & 4;
        if (r4 == 0) goto L_0x0030;
    L_0x002f:
        r1 = r2;
    L_0x0030:
        r3 = r3.c;
        goto L_0x001b;
    L_0x0033:
        r0 = r7.I;
        r0 = r0.a;
        r0 = r0.a;
        goto L_0x0016;
    L_0x003a:
        if (r3 == 0) goto L_0x0013;
    L_0x003c:
        r0 = r3.c;
        if (r0 == 0) goto L_0x0013;
    L_0x0040:
        r0 = r3.c;
        r0 = r0.c;
        if (r0 == 0) goto L_0x0013;
    L_0x0046:
        if (r1 == 0) goto L_0x0054;
    L_0x0048:
        r3.d = r2;
    L_0x004a:
        r0 = r7.I;
        r0 = r0.d;
        if (r0 != 0) goto L_0x005c;
    L_0x0050:
        r7.a(r5);
        goto L_0x0013;
    L_0x0054:
        r0 = r7.I;
        if (r0 == r3) goto L_0x005c;
    L_0x0058:
        r7.e();
        goto L_0x0054;
    L_0x005c:
        r7.d();
        goto L_0x004a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.weex.component.richtext.a.h.m(char[], int):void");
    }

    private void a(c cVar) throws SAXException {
        while (this.J != null && this.I.a(this.J)) {
            if (cVar == null || this.J.a(cVar)) {
                c cVar2 = this.J.c;
                b(this.J);
                this.J = cVar2;
            } else {
                return;
            }
        }
    }

    private void d() throws SAXException {
        if (this.I != null) {
            String str = this.I.a.a;
            String str2 = this.I.a.c;
            String str3 = this.I.a.b;
            String b = b(str);
            if (!this.r) {
                str3 = "";
                str2 = str3;
            }
            this.a.endElement(str3, str2, str);
            if (a(b, str3)) {
                this.a.endPrefixMapping(b);
            }
            Attributes attributes = this.I.b;
            for (int length = attributes.getLength() - 1; length >= 0; length--) {
                str = attributes.getURI(length);
                b = b(attributes.getQName(length));
                if (a(b, str)) {
                    this.a.endPrefixMapping(b);
                }
            }
            this.I = this.I.c;
        }
    }

    private void e() throws SAXException {
        c cVar = this.I;
        d();
        if (this.x && (cVar.a.f & 1) != 0) {
            int length = cVar.b.getLength() - 1;
            while (length >= 0) {
                if (cVar.b.getType(length).equals("ID") || cVar.b.getQName(length).equals("name")) {
                    cVar.b.a(length);
                }
                length--;
            }
            cVar.c = this.J;
            this.J = cVar;
        }
    }

    private void b(c cVar) throws SAXException {
        int length;
        String str = cVar.a.a;
        String str2 = cVar.a.c;
        String str3 = cVar.a.b;
        String b = b(str);
        for (length = cVar.b.getLength() - 1; length >= 0; length--) {
            String localName = cVar.b.getLocalName(length);
            if (cVar.b.getValue(length) == null || localName == null || localName.length() == 0) {
                cVar.b.a(length);
            }
        }
        if (!this.r) {
            str3 = "";
            str2 = str3;
        }
        if (this.N && str2.equalsIgnoreCase(this.G)) {
            try {
                this.e.resolveEntity(this.E, this.F);
            } catch (IOException e) {
            }
        }
        if (a(b, str3)) {
            this.a.startPrefixMapping(b, str3);
        }
        Attributes attributes = cVar.b;
        int length2 = attributes.getLength();
        for (length = 0; length < length2; length++) {
            String uri = attributes.getURI(length);
            String b2 = b(attributes.getQName(length));
            if (a(b2, uri)) {
                this.a.startPrefixMapping(b2, uri);
            }
        }
        this.a.startElement(str3, str2, str, cVar.b);
        cVar.c = this.I;
        this.I = cVar;
        this.N = false;
        if (this.z && (this.I.a.f & 2) != 0) {
            this.g.a();
        }
    }

    private static String b(String str) {
        int indexOf = str.indexOf(58);
        String str2 = "";
        if (indexOf != -1) {
            return str.substring(0, indexOf);
        }
        return str2;
    }

    private boolean a(String str, String str2) {
        return (str.equals("") || str2.equals("") || str2.equals(this.f.b)) ? false : true;
    }

    public final void e(char[] cArr, int i) throws SAXException {
        String str;
        String str2;
        String str3 = null;
        String[] d = d(new String(cArr, 0, i));
        if (d.length > 0 && "DOCTYPE".equals(d[0])) {
            if (!this.D) {
                this.D = true;
                if (d.length > 1) {
                    str = d[1];
                    if (d.length > 3 && "SYSTEM".equals(d[2])) {
                        str2 = d[3];
                        str3 = c(str3);
                        str2 = c(str2);
                        if (str == null) {
                            str3 = e(str3);
                            this.b.startDTD(str, str3, str2);
                            this.b.endDTD();
                            this.G = str;
                            this.E = str3;
                            if (!(this.g instanceof Locator)) {
                                this.F = ((Locator) this.g).getSystemId();
                                this.F = new URL(new URL(this.F), str2).toString();
                            }
                        }
                    } else if (d.length <= 3 || !"PUBLIC".equals(d[2])) {
                        str2 = null;
                        str3 = c(str3);
                        str2 = c(str2);
                        if (str == null) {
                            str3 = e(str3);
                            this.b.startDTD(str, str3, str2);
                            this.b.endDTD();
                            this.G = str;
                            this.E = str3;
                            if (!(this.g instanceof Locator)) {
                                this.F = ((Locator) this.g).getSystemId();
                                try {
                                    this.F = new URL(new URL(this.F), str2).toString();
                                } catch (Exception e) {
                                    return;
                                }
                            }
                        }
                    } else {
                        str3 = d[3];
                        str2 = d.length > 4 ? d[4] : "";
                        str3 = c(str3);
                        str2 = c(str2);
                        if (str == null) {
                            str3 = e(str3);
                            this.b.startDTD(str, str3, str2);
                            this.b.endDTD();
                            this.G = str;
                            this.E = str3;
                            if (!(this.g instanceof Locator)) {
                                this.F = ((Locator) this.g).getSystemId();
                                this.F = new URL(new URL(this.F), str2).toString();
                            }
                        }
                    }
                }
            }
            return;
        }
        str = null;
        str2 = null;
        str3 = c(str3);
        str2 = c(str2);
        if (str == null) {
            str3 = e(str3);
            this.b.startDTD(str, str3, str2);
            this.b.endDTD();
            this.G = str;
            this.E = str3;
            if (!(this.g instanceof Locator)) {
                this.F = ((Locator) this.g).getSystemId();
                this.F = new URL(new URL(this.F), str2).toString();
            }
        }
    }

    private static String c(String str) {
        if (str == null) {
            return str;
        }
        int length = str.length();
        if (length == 0) {
            return str;
        }
        char charAt = str.charAt(0);
        if (charAt != str.charAt(length - 1)) {
            return str;
        }
        if (charAt == '\'' || charAt == '\"') {
            return str.substring(1, str.length() - 1);
        }
        return str;
    }

    private static String[] d(String str) throws IllegalArgumentException {
        String trim = str.trim();
        if (trim.length() == 0) {
            return new String[0];
        }
        ArrayList arrayList = new ArrayList();
        int length = trim.length();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i4 < length) {
            char charAt = trim.charAt(i4);
            if (i2 == 0 && charAt == '\'' && r6 != 92) {
                if (i3 == 0) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                if (i5 < 0) {
                    i5 = i4;
                }
            } else if (i3 == 0 && charAt == '\"' && r6 != 92) {
                if (i2 == 0) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                if (i5 < 0) {
                    i5 = i4;
                }
            } else if (i3 == 0 && i2 == 0) {
                if (Character.isWhitespace(charAt)) {
                    if (i5 >= 0) {
                        arrayList.add(trim.substring(i5, i4));
                    }
                    i5 = -1;
                } else if (i5 < 0 && charAt != ' ') {
                    i5 = i4;
                }
            }
            i4++;
            char c = charAt;
        }
        arrayList.add(trim.substring(i5, i4));
        return (String[]) arrayList.toArray(new String[0]);
    }

    private static String e(String str) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        StringBuffer stringBuffer = new StringBuffer(length);
        Object obj = 1;
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (O.indexOf(charAt) != -1) {
                stringBuffer.append(charAt);
                obj = null;
            } else if (obj == null) {
                stringBuffer.append(' ');
                int i2 = 1;
            }
        }
        return stringBuffer.toString().trim();
    }

    public final void f(char[] cArr, int i) throws SAXException {
        int i2 = -1;
        if (this.B == null) {
            String b = b(cArr, 0, i);
            if (b != null) {
                d a = this.f.a(b);
                if (a == null) {
                    if (!this.s) {
                        int i3 = this.t ? 0 : -1;
                        if (!this.u) {
                            i2 = Integer.MAX_VALUE;
                        }
                        this.f.a(b, i3, i2, 0);
                        if (!this.u) {
                            this.f.a(b, this.f.d.a);
                        }
                        a = this.f.a(b);
                    } else {
                        return;
                    }
                }
                this.B = new c(a, this.v);
            }
        }
    }

    public final void g(char[] cArr, int i) throws SAXException {
        if (i != 0) {
            int i2 = 1;
            for (int i3 = 0; i3 < i; i3++) {
                if (!Character.isWhitespace(cArr[i3 + 0])) {
                    i2 = 0;
                }
            }
            if (i2 == 0 || this.I.a(this.K)) {
                c(this.K);
                this.a.characters(cArr, 0, i);
            } else if (this.y) {
                this.a.ignorableWhitespace(cArr, 0, i);
            }
        }
    }

    public final void h(char[] cArr, int i) throws SAXException {
        if (this.B == null) {
            this.H = b(cArr, 0, i).replace(':', '_');
        }
    }

    public final void i(char[] cArr, int i) throws SAXException {
        if (this.B == null && this.H != null && !"xml".equalsIgnoreCase(this.H)) {
            if (i > 0 && cArr[i - 1] == '?') {
                i--;
            }
            this.a.processingInstruction(this.H, new String(cArr, 0, i));
            this.H = null;
        }
    }

    public final void j(char[] cArr, int i) throws SAXException {
        if (this.B != null) {
            c(this.B);
            if (this.I.a.d == 0) {
                m(cArr, i);
            }
        }
    }

    public final void k(char[] cArr, int i) throws SAXException {
        if (this.B != null) {
            c(this.B);
            m(cArr, i);
        }
    }

    public final void l(char[] cArr, int i) throws SAXException {
        this.b.comment(cArr, 0, i);
    }

    private void c(c cVar) throws SAXException {
        while (true) {
            c cVar2 = this.I;
            while (cVar2 != null && !cVar2.a(cVar)) {
                cVar2 = cVar2.c;
            }
            if (cVar2 != null) {
                break;
            }
            d dVar = cVar.a.h;
            if (dVar == null) {
                break;
            }
            cVar2 = new c(dVar, this.v);
            cVar2.c = cVar;
            cVar = cVar2;
        }
        if (cVar2 != null) {
            while (this.I != cVar2 && this.I != null && this.I.c != null && this.I.c.c != null) {
                e();
            }
            while (cVar != null) {
                cVar2 = cVar.c;
                if (!cVar.a.a.equals("<pcdata>")) {
                    b(cVar);
                }
                a(cVar2);
                cVar = cVar2;
            }
            this.B = null;
        }
    }

    public final int c() {
        return this.L;
    }

    private String b(char[] cArr, int i, int i2) {
        int i3;
        StringBuffer stringBuffer = new StringBuffer(i2 + 2);
        Object obj = 1;
        Object obj2 = null;
        while (true) {
            int i4 = i2 - 1;
            if (i2 <= 0) {
                break;
            }
            Object obj3;
            char c = cArr[i];
            if (Character.isLetter(c) || c == '_') {
                stringBuffer.append(c);
                obj3 = null;
                obj = obj2;
            } else if (Character.isDigit(c) || c == '-' || c == '.') {
                if (obj != null) {
                    stringBuffer.append('_');
                }
                stringBuffer.append(c);
                obj3 = null;
                obj = obj2;
            } else if (c == ':' && obj2 == null) {
                if (obj != null) {
                    stringBuffer.append('_');
                }
                if (this.w) {
                    c = '_';
                }
                stringBuffer.append(c);
                i3 = 1;
                int i5 = 1;
            } else {
                obj3 = obj;
                obj = obj2;
            }
            i++;
            obj2 = obj;
            i2 = i4;
            obj = obj3;
        }
        i3 = stringBuffer.length();
        if (i3 == 0 || stringBuffer.charAt(i3 - 1) == ':') {
            stringBuffer.append('_');
        }
        return stringBuffer.toString().intern();
    }

    public final void comment(char[] cArr, int i, int i2) throws SAXException {
    }

    public final void endCDATA() throws SAXException {
    }

    public final void endDTD() throws SAXException {
    }

    public final void endEntity(String str) throws SAXException {
    }

    public final void startCDATA() throws SAXException {
    }

    public final void startDTD(String str, String str2, String str3) throws SAXException {
    }

    public final void startEntity(String str) throws SAXException {
    }
}
