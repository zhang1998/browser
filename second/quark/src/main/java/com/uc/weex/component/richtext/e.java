package com.uc.weex.component.richtext;

import android.text.Spanned;
import com.uc.weex.component.richtext.a.h;
import org.xml.sax.XMLReader;

/* compiled from: ProGuard */
public final class e {
    public static Spanned a(String str, c cVar, int i, int i2, String str2) {
        XMLReader hVar = new h();
        try {
            hVar.setProperty("http://www.ccil.org/~cowan/tagsoup/properties/schema", b.a);
            return new HtmlToSpannedConverter(str, cVar, hVar, i2, str2).a(i);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        } catch (Throwable e2) {
            throw new RuntimeException(e2);
        }
    }
}
