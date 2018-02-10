package com.ucpro.feature.z.b;

import android.text.Layout;
import android.text.TextUtils;
import com.ucpro.base.a.e;
import com.ucpro.base.a.g;
import com.ucpro.business.stat.m;
import com.ucpro.business.stat.o;
import com.ucpro.feature.inputenhance.v;
import com.ucpro.feature.z.h.a;
import com.ucpro.ui.edittext.CustomEditText;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
public final class b implements v, i, m {
    int a = -1;
    int b = -1;
    int c = -1;
    public CustomEditText d = null;
    c e = null;
    private g f = null;

    public b(c cVar) {
        this.e = cVar;
        this.e.setUrlState(false);
        this.e.setPresenter(this);
        this.e.setCallback(this);
        this.f = new g(this);
        k();
    }

    public final void c() {
    }

    public final void d() {
    }

    public final void e() {
    }

    public final void f() {
    }

    public final void a(String str) {
        if (this.d != null) {
            Object substring;
            String obj;
            try {
                this.d.n();
                obj = this.d.getText().toString();
                int selectionStart = this.d.getSelectionStart();
                int selectionEnd = this.d.getSelectionEnd();
                if (selectionStart > 0 && selectionEnd > selectionStart) {
                    obj = obj.substring(0, selectionStart);
                }
                if (!TextUtils.isEmpty(obj) && obj.endsWith(".") && str != null && str.startsWith(".") && this.d.getSelectionEnd() == obj.length()) {
                    substring = str.substring(1);
                } else {
                    obj = str;
                }
                try {
                    this.d.getEditableText().replace(selectionStart, selectionEnd, substring);
                    this.d.a(this.d.getSelectionEnd(), this.d.getSelectionEnd());
                } catch (Exception e) {
                }
            } catch (Exception e2) {
                obj = str;
            }
            m.a("searchpage", "cli_inp_e_w", "name", substring);
            Map hashMap = new HashMap();
            hashMap.put("item", substring);
            m.a(a.j, hashMap);
        }
    }

    public final void g() {
    }

    public final void a(int i) {
        Object obj = 1;
        if (this.d != null) {
            if (i != 1) {
                obj = null;
            }
            if (this.d.getText() != null) {
                int length = this.d.getText().length();
                int selectionStart = this.d.getSelectionStart();
                int selectionEnd = this.d.getSelectionEnd();
                if (selectionStart >= 0 && selectionEnd > selectionStart) {
                    this.d.getEditableText().replace(selectionStart, selectionEnd, "");
                } else if (obj != null) {
                    if (selectionStart > 0) {
                        this.d.setSelection(selectionStart - 1);
                    } else {
                        this.d.setSelection(selectionStart);
                    }
                } else if (selectionEnd < length) {
                    this.d.setSelection(selectionEnd + 1);
                } else if (selectionEnd == length) {
                    this.d.setSelection(selectionEnd);
                }
            }
        }
    }

    public final void b(int i) {
        if (this.d != null) {
            if (i == -1) {
                this.a = this.d.getSelectionStart();
                this.b = this.d.getSelectionEnd();
                this.c = -1;
                if (this.d.getSelectionStart() != this.d.getSelectionEnd()) {
                    this.d.setSelection(0);
                }
            } else if (i == 1) {
                if (this.c == -1) {
                    this.c = 0;
                }
                a(this.d, 1);
            } else if (i == 0) {
                if (this.c == -1) {
                    this.c = 1;
                }
                a(this.d, 0);
            }
        }
    }

    public final void h() {
        if (this.d != null) {
            int selectionStart = this.d.getSelectionStart();
            this.d.k();
            this.d.n();
            this.d.setSelection(selectionStart);
        }
    }

    public final void b() {
        if (this.d != null) {
            Layout layout = this.d.getLayout();
            if (layout != null) {
                for (int i = 0; i < 4; i++) {
                    com.ucweb.common.util.h.m.a(2, new e(this, i, layout.getPrimaryHorizontal(this.d.getSelectionStart()) + ((float) this.d.getScrollX())), (long) (i * 1));
                }
            }
        }
    }

    public final void c(int i) {
    }

    public final void d(int i) {
    }

    public final void i() {
        m.a("searchpage", "cli_inp_e_s", new String[0]);
    }

    public final void j() {
        m.a("searchpage", "dra_inp_e_s", new String[0]);
    }

    private void a(CustomEditText customEditText, int i) {
        if (this.c == 0) {
            if (i == 1) {
                if (this.a > 0) {
                    this.a--;
                    customEditText.a(this.a, this.b);
                    customEditText.getViewTreeObserver().addOnPreDrawListener(new l(this, customEditText));
                }
            } else if (i != 0) {
            } else {
                if (this.a < this.b) {
                    this.a++;
                    customEditText.a(this.a, this.b);
                    customEditText.getViewTreeObserver().addOnPreDrawListener(new h(this, customEditText));
                } else if (this.a >= this.b) {
                    this.c = 1;
                    this.b++;
                    if (this.b >= customEditText.getText().length()) {
                        this.b = customEditText.getText().length();
                    }
                    customEditText.a(this.a, this.b);
                }
            }
        } else if (this.c == 1) {
            if (i == 1) {
                if (this.b > this.a) {
                    this.b--;
                } else if (this.a >= this.b) {
                    this.c = 0;
                    this.a--;
                    if (this.a <= 0) {
                        this.a = 0;
                    }
                    customEditText.a(this.a, this.b);
                    return;
                } else {
                    return;
                }
            } else if (i == 0 && this.b < customEditText.getText().toString().length()) {
                this.b++;
                if (this.a <= 0) {
                    this.a = 0;
                }
            } else {
                return;
            }
            customEditText.a(this.a, this.b);
        }
    }

    public final void a() {
        k();
    }

    private void k() {
        Collection collection = this.f.p;
        if (collection != null) {
            this.e.setVerticalSearchItems(new ArrayList(collection));
        }
    }

    public final void a(com.ucpro.feature.z.g.b.a aVar) {
        g.a().b(e.at, new String[]{aVar.c, this.d.getText().toString(), aVar.b});
        String str = aVar.b;
        o.a(a.i.c);
        Map hashMap = new HashMap();
        hashMap.put("site", str);
        m.a(a.i, hashMap);
    }
}
