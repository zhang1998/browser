package com.ucpro.feature.webwindow;

import android.util.JsonReader;
import android.util.JsonToken;
import android.webkit.ValueCallback;
import java.io.IOException;
import java.io.StringReader;

/* compiled from: ProGuard */
final class ay implements ValueCallback<String> {
    final /* synthetic */ ValueCallback a;
    final /* synthetic */ bb b;

    ay(bb bbVar, ValueCallback valueCallback) {
        this.b = bbVar;
        this.a = valueCallback;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        JsonReader jsonReader = new JsonReader(new StringReader((String) obj));
        jsonReader.setLenient(true);
        try {
            if (JsonToken.NULL != jsonReader.peek() && JsonToken.STRING == jsonReader.peek()) {
                this.a.onReceiveValue(jsonReader.nextString());
            }
        } catch (IOException e) {
        }
    }
}
