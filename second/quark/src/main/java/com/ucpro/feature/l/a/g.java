package com.ucpro.feature.l.a;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.webkit.ValueCallback;
import android.widget.ImageView;
import com.ucpro.base.d.b;
import com.ucpro.feature.bookmarkhis.bookmark.a.m;
import java.util.ArrayList;

/* compiled from: ProGuard */
public interface g extends b {
    void a(long j, ValueCallback<ArrayList<m>> valueCallback);

    void a(m mVar);

    void a(String str, ImageView imageView, Drawable drawable, ValueCallback<Boolean> valueCallback);

    void a(String str, String str2, View view, Drawable drawable);

    void a(String str, String str2, ImageView imageView);
}
