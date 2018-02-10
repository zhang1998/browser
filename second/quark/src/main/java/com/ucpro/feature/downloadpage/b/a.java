package com.ucpro.feature.downloadpage.b;

import android.content.Context;
import android.os.Environment;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import com.quark.browser.R;
import com.ucpro.base.d.b;
import com.ucpro.ui.e.a.c;
import com.ucpro.ui.g.o;
import com.ucpro.ui.widget.auto.theme.ATTextView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: ProGuard */
public final class a extends o implements o, c {
    ATTextView a;
    HashSet<String> b;
    private h v;
    private com.ucpro.ui.e.a w = new com.ucpro.ui.e.a(getContext(), this);
    private ArrayList<n> x;

    public a(Context context) {
        super(context);
        View inflate = getLayoutInflater().inflate(R.layout.common_dialog, null);
        this.a = (ATTextView) inflate.findViewById(R.id.bm_tv_tips);
        this.a.setTextColor(com.ucpro.ui.c.a.c("default_maintext_gray"));
        this.a.getPaint().setFakeBoldText(true);
        h().a(inflate);
        LayoutParams layoutParams = new LayoutParams(-1, -2);
        layoutParams.bottomMargin = com.ucpro.ui.c.a.c((int) R.dimen.download_path_select_margin_bottom);
        layoutParams.topMargin = com.ucpro.ui.c.a.c((int) R.dimen.download_path_select_margin_top);
        h().a(this.w, layoutParams);
    }

    public final void setPresenter(b bVar) {
        this.v = (h) bVar;
        this.w.j();
    }

    public final void c(int i) {
        if (this.x != null && this.x.size() > i) {
            if (this.x != null) {
                Iterator it = this.x.iterator();
                while (it.hasNext()) {
                    ((n) it.next()).d = false;
                }
            }
            n nVar = (n) this.x.get(i);
            nVar.d = true;
            this.w.k();
            com.ucpro.model.a.a.a.b("setting_download_store_path", nVar.c);
        }
    }

    public final ArrayList getConfig() {
        if (this.x == null) {
            this.x = new ArrayList();
            String a = com.ucpro.model.a.a.a.a("setting_download_store_path", com.ucpro.c.c.c().getPath());
            String path = Environment.getExternalStorageDirectory().getPath();
            this.x.add(new n("", path, com.ucpro.ui.c.a.d((int) R.string.download_path_inner_desc), com.ucweb.common.util.n.a.d(path, a), this));
            Iterator it = this.b.iterator();
            int i = 0;
            while (it.hasNext()) {
                path = (String) it.next();
                ArrayList arrayList = this.x;
                String str = "";
                String d = com.ucpro.ui.c.a.d((int) R.string.download_path_ext_desc);
                Object[] objArr = new Object[1];
                objArr[0] = i == 0 ? "" : Integer.valueOf(i);
                arrayList.add(new n(str, path, String.format(d, objArr), com.ucweb.common.util.n.a.d(a, path), this));
                i++;
            }
        }
        return this.x;
    }
}
