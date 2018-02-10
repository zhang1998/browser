package com.ucpro.ui.e.a;

import android.view.View;
import com.quark.browser.R;
import com.ucpro.ui.e.b;

/* compiled from: ProGuard */
public enum d {
    VIEW_TYPE_NORMAL(R.layout.cloud_sync_normal_item),
    VIEW_TYPE_IMPORT_BOOK(R.layout.cloud_sync_import_item),
    VIEW_TYPE_CHECKBOX(R.layout.setting_check_item),
    VIEW_TYPE_TIP_ITEM_SELECT(R.layout.dialog_item_select),
    VIEW_TYPE_TEXTVIEW(R.layout.textview),
    VIEW_TYPE_ITEM_DESC(R.layout.setting_item_desc),
    VIEW_TYPE_ITEM_PRIVACYMODE(R.layout.privacymode_item);
    
    public int h;

    private d(int i) {
        this.h = -1;
        this.h = i;
    }

    public static d a(int i) {
        if (i >= 0 && i < values().length) {
            return values()[i];
        }
        throw new IndexOutOfBoundsException("Invalid ordinal");
    }

    public static b a(d dVar, View view) {
        if (dVar == VIEW_TYPE_NORMAL) {
            return new g(view);
        }
        if (dVar == VIEW_TYPE_IMPORT_BOOK) {
            return new h(view);
        }
        if (dVar == VIEW_TYPE_CHECKBOX) {
            return new f(view);
        }
        if (dVar == VIEW_TYPE_TIP_ITEM_SELECT) {
            return new e(view);
        }
        if (dVar == VIEW_TYPE_TEXTVIEW) {
            return new a(view);
        }
        if (dVar == VIEW_TYPE_ITEM_DESC) {
            return new b(view);
        }
        if (dVar == VIEW_TYPE_ITEM_PRIVACYMODE) {
            return new i(view);
        }
        return new b(view);
    }
}
