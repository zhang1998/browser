package com.ucpro.feature.webwindow.l.a;

import com.quark.browser.R;
import com.ucpro.ui.c.a;
import java.util.ArrayList;

/* compiled from: ProGuard */
public final class c {
    public static ArrayList<a> a;
    private static ArrayList<a> b;

    public static ArrayList<a> a() {
        if (b == null) {
            b = new ArrayList();
            a aVar = new a(a.d((int) R.string.context_menu_free_copy_select_all), 40022);
            a aVar2 = new a(a.d((int) R.string.context_menu_free_copy_copy), 40001);
            a aVar3 = new a(a.d((int) R.string.context_menu_free_copy_search), 40004);
            a aVar4 = new a(a.d((int) R.string.context_menu_free_translate), 40025);
            b.add(aVar);
            b.add(aVar2);
            b.add(aVar3);
            b.add(aVar4);
        }
        return b;
    }
}
