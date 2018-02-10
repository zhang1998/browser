package android.support.v7.widget;

import android.content.ComponentName;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.PopupWindow.OnDismissListener;
import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
final class dy implements OnClickListener, OnLongClickListener, OnItemClickListener, OnDismissListener {
    final /* synthetic */ ActivityChooserView a;

    private dy(ActivityChooserView activityChooserView) {
        this.a = activityChooserView;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        switch (((bv) adapterView.getAdapter()).getItemViewType(i)) {
            case 0:
                this.a.b();
                if (!this.a.o) {
                    if (!this.a.b.b) {
                        i++;
                    }
                    Intent b = this.a.b.a.b(i);
                    if (b != null) {
                        b.addFlags(524288);
                        this.a.getContext().startActivity(b);
                        return;
                    }
                    return;
                } else if (i > 0) {
                    fs fsVar = this.a.b.a;
                    synchronized (fsVar.a) {
                        float f;
                        fsVar.d();
                        cm cmVar = (cm) fsVar.b.get(i);
                        cm cmVar2 = (cm) fsVar.b.get(0);
                        if (cmVar2 != null) {
                            f = (cmVar2.b - cmVar.b) + 5.0f;
                        } else {
                            f = IPictureView.DEFAULT_MIN_SCALE;
                        }
                        fsVar.a(new fq(new ComponentName(cmVar.a.activityInfo.packageName, cmVar.a.activityInfo.name), System.currentTimeMillis(), f));
                    }
                    return;
                } else {
                    return;
                }
            case 1:
                this.a.a(Integer.MAX_VALUE);
                return;
            default:
                throw new IllegalArgumentException();
        }
    }

    public final void onClick(View view) {
        if (view == this.a.h) {
            this.a.b();
            Intent b = this.a.b.a.b(this.a.b.a.a(this.a.b.a.b()));
            if (b != null) {
                b.addFlags(524288);
                this.a.getContext().startActivity(b);
            }
        } else if (view == this.a.f) {
            this.a.o = false;
            this.a.a(this.a.p);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public final boolean onLongClick(View view) {
        if (view == this.a.h) {
            if (this.a.b.getCount() > 0) {
                this.a.o = true;
                this.a.a(this.a.p);
            }
            return true;
        }
        throw new IllegalArgumentException();
    }

    public final void onDismiss() {
        if (this.a.n != null) {
            this.a.n.onDismiss();
        }
        if (this.a.a != null) {
            this.a.a.a(false);
        }
    }
}
