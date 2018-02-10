package com.loc;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/* compiled from: ProGuard */
final class eh extends DefaultHandler {
    eh() {
    }

    public final void characters(char[] cArr, int i, int i2) throws SAXException {
        if (ei.b) {
            ei.a = new String(cArr, i, i2);
        }
    }

    public final void endElement(String str, String str2, String str3) throws SAXException {
        ei.b = false;
    }

    public final void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
        if (str2.equals("string") && "UTDID".equals(attributes.getValue("name"))) {
            ei.b = true;
        }
    }
}
