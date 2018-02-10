package com.uc.weex.component.richtext;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan.Standard;
import android.text.style.ForegroundColorSpan;
import android.text.style.ParagraphStyle;
import android.text.style.QuoteSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.TextAppearanceSpan;
import android.text.style.TypefaceSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import com.taobao.weex.c.ak;
import com.taobao.weex.ui.animation.WXAnimationBean.Style;
import com.taobao.weex.utils.WXViewUtils;
import com.taobao.weex.utils.af;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.uc.imagecodec.export.IPictureView;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

/* compiled from: ProGuard */
final class HtmlToSpannedConverter implements ContentHandler {
    private static final float[] a = new float[]{1.5f, 1.4f, 1.3f, 1.2f, 1.1f, IPictureView.DEFAULT_MIN_SCALE};
    private static HashMap<String, Integer> m;
    private int b;
    private boolean c = false;
    private boolean d = false;
    private String e;
    private String f;
    private XMLReader g;
    private SpannableStringBuilder h;
    private c i;
    private d j;
    private boolean k = false;
    private boolean l = false;

    /* compiled from: ProGuard */
    class MyURLSpan extends URLSpan {
        String a;

        MyURLSpan(String str, String str2) {
            super(str);
            this.a = str2;
        }

        public void updateDrawState(TextPaint textPaint) {
        }
    }

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("aqua", Integer.valueOf(65535));
        hashMap.put("black", Integer.valueOf(0));
        hashMap.put("blue", Integer.valueOf(255));
        hashMap.put("fuchsia", Integer.valueOf(16711935));
        hashMap.put("green", Integer.valueOf(WXMediaMessage.THUMB_LENGTH_LIMIT));
        hashMap.put("grey", Integer.valueOf(8421504));
        hashMap.put("lime", Integer.valueOf(65280));
        hashMap.put("maroon", Integer.valueOf(8388608));
        hashMap.put("navy", Integer.valueOf(128));
        hashMap.put("olive", Integer.valueOf(8421376));
        hashMap.put("purple", Integer.valueOf(8388736));
        hashMap.put("red", Integer.valueOf(16711680));
        hashMap.put("silver", Integer.valueOf(12632256));
        hashMap.put("teal", Integer.valueOf(32896));
        hashMap.put("white", Integer.valueOf(16777215));
        hashMap.put("yellow", Integer.valueOf(16776960));
        m = hashMap;
    }

    public HtmlToSpannedConverter(String str, c cVar, XMLReader xMLReader, int i, String str2) {
        this.f = str;
        this.h = new SpannableStringBuilder();
        this.i = cVar;
        this.j = null;
        this.g = xMLReader;
        if (i != -1) {
            this.c = true;
            this.b = i;
        }
        this.e = str2;
    }

    public final Spanned a(int i) {
        int i2 = 0;
        this.g.setContentHandler(this);
        try {
            int spanEnd;
            this.g.parse(new InputSource(new StringReader(this.f)));
            if (i > 0) {
                this.h.setSpan(new ak(i), 0, this.h.length(), 33);
            }
            Object[] spans = this.h.getSpans(0, this.h.length(), ParagraphStyle.class);
            while (i2 < spans.length) {
                int spanStart = this.h.getSpanStart(spans[i2]);
                spanEnd = this.h.getSpanEnd(spans[i2]);
                if (spanEnd - 2 >= 0 && this.h.charAt(spanEnd - 1) == '\n' && this.h.charAt(spanEnd - 2) == '\n') {
                    spanEnd--;
                }
                if (spanEnd == spanStart) {
                    this.h.removeSpan(spans[i2]);
                } else {
                    this.h.setSpan(spans[i2], spanStart, spanEnd, 51);
                }
                i2++;
            }
            SpannableStringBuilder spannableStringBuilder = this.h;
            spanEnd = spannableStringBuilder.length();
            if (spanEnd < 2 || spannableStringBuilder.charAt(spanEnd - 1) != '\n') {
                spannableStringBuilder.append("\n\n");
            } else if (spannableStringBuilder.charAt(spanEnd - 1) == '\n' && spannableStringBuilder.charAt(spanEnd - 2) != '\n') {
                spannableStringBuilder.append('\n');
            }
            return this.h;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        } catch (Throwable e2) {
            throw new RuntimeException(e2);
        }
    }

    private static void a(SpannableStringBuilder spannableStringBuilder) {
        int length = spannableStringBuilder.length();
        if ((length <= 0 || spannableStringBuilder.charAt(length - 1) != '\n') && length != 0) {
            spannableStringBuilder.append("\n");
        }
    }

    private static void b(SpannableStringBuilder spannableStringBuilder) {
        int length = spannableStringBuilder.length();
        if ((length <= 0 || spannableStringBuilder.charAt(length - 1) != '\n') && length != 0) {
            spannableStringBuilder.append("\n");
        }
    }

    private static Object a(Spanned spanned, Class<?> cls) {
        Object[] spans = spanned.getSpans(0, spanned.length(), cls);
        if (spans.length == 0) {
            return null;
        }
        return spans[spans.length - 1];
    }

    private static void a(SpannableStringBuilder spannableStringBuilder, Object obj) {
        int length = spannableStringBuilder.length();
        spannableStringBuilder.setSpan(obj, length, length, 17);
    }

    private static void a(SpannableStringBuilder spannableStringBuilder, Class<?> cls, Object obj) {
        int length = spannableStringBuilder.length();
        Object a = a((Spanned) spannableStringBuilder, (Class) cls);
        int spanStart = spannableStringBuilder.getSpanStart(a);
        spannableStringBuilder.removeSpan(a);
        if (spanStart != length) {
            spannableStringBuilder.setSpan(obj, spanStart, length, 33);
        }
    }

    private static int a(String str) {
        int i = 0;
        if (str != null) {
            try {
                i = Integer.parseInt(str);
            } catch (Exception e) {
            }
        }
        return i;
    }

    private static void c(SpannableStringBuilder spannableStringBuilder) {
        int length = spannableStringBuilder.length();
        Object a = a((Spanned) spannableStringBuilder, m.class);
        int spanStart = spannableStringBuilder.getSpanStart(a);
        spannableStringBuilder.removeSpan(a);
        while (length > spanStart && spannableStringBuilder.charAt(length - 1) == '\n') {
            length--;
        }
        if (spanStart != length) {
            spannableStringBuilder.setSpan(new RelativeSizeSpan(a[((m) a).a]), spanStart, length, 33);
            spannableStringBuilder.setSpan(new StyleSpan(1), spanStart, length, 33);
        }
    }

    public final void setDocumentLocator(Locator locator) {
    }

    public final void startDocument() throws SAXException {
    }

    public final void endDocument() throws SAXException {
    }

    public final void startPrefixMapping(String str, String str2) throws SAXException {
    }

    public final void endPrefixMapping(String str) throws SAXException {
    }

    public final void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
        int i = -1;
        float f = 0.0f;
        if (this.j != null && this.j.a()) {
            return;
        }
        if ((this.c && this.b <= 0) || str2.equalsIgnoreCase("br")) {
            return;
        }
        if (str2.equalsIgnoreCase("p")) {
            a(this.h);
        } else if (str2.equalsIgnoreCase("div")) {
            r0 = this.h;
            r1 = attributes.getValue("", "align");
            if (r1 == null || r1.length() <= 0) {
                this.k = false;
            } else {
                this.k = true;
                r2 = r0.length();
                r0.setSpan(new k(r1), r2, r2, 17);
            }
            b(r0);
        } else if (str2.equalsIgnoreCase("strong")) {
            a(this.h, new h());
        } else if (str2.equalsIgnoreCase("b")) {
            a(this.h, new h());
        } else if (str2.equalsIgnoreCase("em")) {
            a(this.h, new o());
        } else if (str2.equalsIgnoreCase("cite")) {
            a(this.h, new o());
        } else if (str2.equalsIgnoreCase("dfn")) {
            a(this.h, new o());
        } else if (str2.equalsIgnoreCase("i")) {
            a(this.h, new o());
        } else if (str2.equalsIgnoreCase("big")) {
            a(this.h, new f());
        } else if (str2.equalsIgnoreCase("small")) {
            a(this.h, new r());
        } else if (str2.equalsIgnoreCase("font")) {
            r0 = this.h;
            r1 = attributes.getValue("", "color");
            r2 = attributes.getValue("", "face");
            i = (int) WXViewUtils.d((float) a(attributes.getValue("", "size")));
            r4 = r0.length();
            r0.setSpan(new l(r1, r2, i), r4, r4, 17);
        } else if (str2.equalsIgnoreCase("blockquote")) {
            a(this.h);
            SpannableStringBuilder spannableStringBuilder = this.h;
            String value = attributes.getValue("backgroundcolor");
            r1 = attributes.getValue("stripecolor");
            String value2 = attributes.getValue("stripewidth");
            String value3 = attributes.getValue("gap");
            if (value == null && r1 == null && value2 == null && value3 == null) {
                this.l = false;
            } else {
                this.l = true;
            }
            int length = spannableStringBuilder.length();
            if (this.l) {
                float floatValue;
                try {
                    r2 = Color.parseColor(value);
                    try {
                        i = Color.parseColor(r1);
                        floatValue = Float.valueOf(value2).floatValue();
                        try {
                            f = Float.valueOf(value3).floatValue();
                        } catch (Exception e) {
                        }
                    } catch (Exception e2) {
                        floatValue = f;
                    }
                } catch (Exception e3) {
                    floatValue = f;
                    r2 = -1;
                }
                spannableStringBuilder.setSpan(new j(this, r2, i, floatValue, f), length, length, 17);
                return;
            }
            spannableStringBuilder.setSpan(new g(), length, length, 17);
        } else if (str2.equalsIgnoreCase("tt")) {
            a(this.h, new p());
        } else if (str2.equalsIgnoreCase("a")) {
            r0 = this.h;
            r1 = attributes.getValue("", "href");
            r2 = attributes.getValue("", "id");
            i = r0.length();
            r0.setSpan(new n(r1, r2), i, i, 17);
        } else if (str2.equalsIgnoreCase("u")) {
            a(this.h, new u());
        } else if (str2.equalsIgnoreCase("sup")) {
            a(this.h, new t());
        } else if (str2.equalsIgnoreCase("sub")) {
            a(this.h, new s());
        } else if (str2.length() == 2 && Character.toLowerCase(str2.charAt(0)) == 'h' && str2.charAt(1) >= '1' && str2.charAt(1) <= '6') {
            a(this.h);
            a(this.h, new m(str2.charAt(1) - 49));
        } else if (str2.equalsIgnoreCase("img")) {
            SpannableStringBuilder spannableStringBuilder2 = this.h;
            c cVar = this.i;
            String value4 = attributes.getValue("", "src");
            Drawable drawable = null;
            r4 = a(attributes.getValue("", Style.WIDTH));
            r4 = (int) WXViewUtils.d((float) r4);
            int d = (int) WXViewUtils.d((float) a(attributes.getValue("", Style.HEIGHT)));
            if (cVar != null) {
                drawable = cVar.a(r4, d);
            }
            if (drawable != null) {
                r2 = spannableStringBuilder2.length();
                spannableStringBuilder2.append("￼");
                spannableStringBuilder2.setSpan(new q(drawable, value4), r2, spannableStringBuilder2.length(), 33);
            }
        }
    }

    public final void endElement(String str, String str2, String str3) throws SAXException {
        if (this.j != null && this.j.a()) {
            return;
        }
        if (this.c && this.b <= 0) {
            return;
        }
        if (str2.equalsIgnoreCase("br")) {
            this.h.append("\n");
        } else if (str2.equalsIgnoreCase("p")) {
            a(this.h);
        } else if (str2.equalsIgnoreCase("div")) {
            r1 = this.h;
            b((SpannableStringBuilder) r1);
            if (this.k) {
                r2 = r1.length();
                r0 = a(r1, k.class);
                r3 = r1.getSpanStart(r0);
                r1.removeSpan(r0);
                if (r3 != r2) {
                    r1.setSpan(new Standard(((k) r0).a), r3, r2, 33);
                }
            }
        } else if (str2.equalsIgnoreCase("strong")) {
            a(this.h, h.class, new StyleSpan(1));
        } else if (str2.equalsIgnoreCase("b")) {
            a(this.h, h.class, new StyleSpan(1));
        } else if (str2.equalsIgnoreCase("em")) {
            a(this.h, o.class, new StyleSpan(2));
        } else if (str2.equalsIgnoreCase("cite")) {
            a(this.h, o.class, new StyleSpan(2));
        } else if (str2.equalsIgnoreCase("dfn")) {
            a(this.h, o.class, new StyleSpan(2));
        } else if (str2.equalsIgnoreCase("i")) {
            a(this.h, o.class, new StyleSpan(2));
        } else if (str2.equalsIgnoreCase("big")) {
            a(this.h, f.class, new RelativeSizeSpan(1.25f));
        } else if (str2.equalsIgnoreCase("small")) {
            a(this.h, r.class, new RelativeSizeSpan(0.8f));
        } else if (str2.equalsIgnoreCase("font")) {
            Spanned spanned = this.h;
            int length = spanned.length();
            r0 = a(spanned, l.class);
            int spanStart = spanned.getSpanStart(r0);
            spanned.removeSpan(r0);
            if (spanStart != length) {
                l lVar = (l) r0;
                if (!TextUtils.isEmpty(lVar.a)) {
                    if (lVar.a.startsWith("@")) {
                        Resources system = Resources.getSystem();
                        r3 = system.getIdentifier(lVar.a.substring(1), "color", "android");
                        if (r3 != 0) {
                            spanned.setSpan(new TextAppearanceSpan(null, 0, 0, system.getColorStateList(r3), null), spanStart, length, 33);
                        }
                    } else {
                        int c = c(lVar.a);
                        if (c != -1) {
                            spanned.setSpan(new ForegroundColorSpan(c | -16777216), spanStart, length, 33);
                        }
                    }
                }
                if (lVar.b != null) {
                    spanned.setSpan(new TypefaceSpan(lVar.b), spanStart, length, 33);
                }
                if (lVar.c > 0) {
                    spanned.setSpan(new AbsoluteSizeSpan(lVar.c), spanStart, length, 33);
                }
            }
        } else if (str2.equalsIgnoreCase("blockquote")) {
            a(this.h);
            r1 = this.h;
            r2 = r1.length();
            if (this.l) {
                r0 = a(r1, j.class);
            } else {
                r0 = a(r1, g.class);
            }
            r3 = r1.getSpanStart(r0);
            r1.removeSpan(r0);
            if (r3 == r2) {
                return;
            }
            if (this.l) {
                r1.setSpan(new j(this, (j) r0), r3, r2, 33);
            } else {
                r1.setSpan(new QuoteSpan(), r3, r2, 33);
            }
        } else if (str2.equalsIgnoreCase("tt")) {
            a(this.h, p.class, new TypefaceSpan("monospace"));
        } else if (str2.equalsIgnoreCase("a")) {
            r1 = this.h;
            r2 = r1.length();
            r0 = a(r1, n.class);
            r3 = r1.getSpanStart(r0);
            r1.removeSpan(r0);
            if (r3 != r2) {
                n nVar = (n) r0;
                if (nVar != null && nVar.a != null) {
                    r1.setSpan(new MyURLSpan(nVar.a, nVar.b), r3, r2, 33);
                }
            }
        } else if (str2.equalsIgnoreCase("u")) {
            a(this.h, u.class, new UnderlineSpan());
        } else if (str2.equalsIgnoreCase("sup")) {
            a(this.h, t.class, new SuperscriptSpan());
        } else if (str2.equalsIgnoreCase("sub")) {
            a(this.h, s.class, new SubscriptSpan());
        } else if (str2.length() == 2 && Character.toLowerCase(str2.charAt(0)) == 'h' && str2.charAt(1) >= '1' && str2.charAt(1) <= '6') {
            a(this.h);
            c(this.h);
        }
    }

    public final void characters(char[] cArr, int i, int i2) throws SAXException {
        CharSequence stringBuilder = new StringBuilder();
        if (this.c) {
            if (this.b > 0) {
                if (this.b - i2 <= 0) {
                    i2 = this.b;
                    this.d = true;
                }
            } else {
                return;
            }
        }
        for (int i3 = 0; i3 < i2; i3++) {
            char c = cArr[i3 + i];
            if (c == ' ' || c == '\n') {
                int length = stringBuilder.length();
                if (length == 0) {
                    length = this.h.length();
                    if (length == 0) {
                        c = '\n';
                    } else {
                        c = this.h.charAt(length - 1);
                    }
                } else {
                    c = stringBuilder.charAt(length - 1);
                }
                if (!(c == ' ' || c == '\n')) {
                    stringBuilder.append(' ');
                }
            } else {
                stringBuilder.append(c);
            }
        }
        this.h.append(stringBuilder);
        if (this.d) {
            a(this.h, this.e);
        }
        if (this.c) {
            this.b -= i2;
        }
    }

    private static void a(SpannableStringBuilder spannableStringBuilder, String str) {
        if (!TextUtils.isEmpty(str)) {
            for (i iVar : b(str)) {
                int length = spannableStringBuilder.length();
                spannableStringBuilder.append(iVar.a);
                int length2 = spannableStringBuilder.length();
                if (iVar.b != 0) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(iVar.b), length, length2, 33);
                }
                if (iVar.c > 0) {
                    spannableStringBuilder.setSpan(new AbsoluteSizeSpan(iVar.c), length, length2, 33);
                }
            }
        }
    }

    private static List<i> b(String str) {
        List<i> arrayList = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                i iVar = new i();
                iVar.a = (String) keys.next();
                JSONObject jSONObject2 = jSONObject.getJSONObject(iVar.a);
                if (jSONObject2.has("color")) {
                    iVar.b = c(jSONObject2.getString("color"));
                }
                if (jSONObject2.has("fontSize")) {
                    iVar.c = WXViewUtils.f((float) a(jSONObject2.getString("fontSize")));
                }
                arrayList.add(iVar);
            }
        } catch (Exception e) {
        }
        return arrayList;
    }

    public final void ignorableWhitespace(char[] cArr, int i, int i2) throws SAXException {
    }

    public final void processingInstruction(String str, String str2) throws SAXException {
    }

    public final void skippedEntity(String str) throws SAXException {
    }

    private static int c(String str) {
        Integer num = (Integer) m.get(str.toLowerCase());
        if (num != null) {
            return num.intValue();
        }
        return af.a(str);
    }
}
