package com.ucpro.ui.widget;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.quark.browser.R;
import com.ucpro.services.e.e;
import com.ucpro.ui.c.a;
import com.ucpro.ui.contextmenu.b;
import com.ucpro.ui.contextmenu.d;

/* compiled from: ProGuard */
final class ag implements OnLongClickListener {
    final /* synthetic */ EditText a;

    ag(EditText editText) {
        this.a = editText;
    }

    public final boolean onLongClick(View view) {
        boolean z = false;
        b bVar = this.a;
        if (bVar.getContextMenuManager() != null) {
            d a = bVar.getContextMenuManager().a(bVar.getContext());
            a.c();
            e.a.d();
            Object b = e.a.b();
            if (bVar.getResources() != null) {
                if (!TextUtils.isEmpty(b)) {
                    a.a(a.d((int) R.string.edittext_paste), 20041);
                    if (bVar.a == 1) {
                        a.a(a.d((int) R.string.edittext_paste_search), 20084);
                    } else if (bVar.a == 2) {
                        a.a(a.d((int) R.string.edittext_paste_go), 20042);
                    } else if (bVar.a == 3) {
                        com.uc.base.net.a.a aVar;
                        try {
                            aVar = new com.uc.base.net.a.a(b);
                        } catch (Exception e) {
                            aVar = null;
                        }
                        if (aVar != null) {
                            if (aVar.a) {
                                z = true;
                            } else if (!TextUtils.isEmpty(aVar.b) && aVar.b.contains(".")) {
                                if (com.uc.base.net.a.a.b(aVar.b)) {
                                    z = true;
                                } else if (com.uc.base.net.a.a.a(aVar.b)) {
                                    z = true;
                                }
                            }
                            if (z) {
                                a.a(a.d((int) R.string.edittext_paste_go), 20042);
                            }
                        }
                        a.a(a.d((int) R.string.edittext_paste_search), 20084);
                    }
                }
                if (bVar.length() > 0) {
                    a.a(a.d((int) R.string.edittext_select), 20043);
                    if (bVar.b) {
                        a.a(a.d((int) R.string.edittext_copyall), 20069);
                    } else {
                        a.a(a.d((int) R.string.edittext_selectall), 20044);
                    }
                }
                if (!bVar.c && com.ucpro.model.a.a("flag_addon_clipboard_enabled")) {
                    a.a(a.d((int) R.string.edittext_clipboard), 20045);
                }
                a.a(a.d((int) R.string.edittext_inputmethod), 20046);
                bVar.getContextMenuManager().a(bVar.getContext(), bVar);
            }
        }
        return true;
    }
}
