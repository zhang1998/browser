package android.mini.support.v4.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.mini.support.annotation.Nullable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: ProGuard */
public final class DialogFragment extends Fragment implements OnCancelListener, OnDismissListener {
    int a;
    int b;
    boolean c;
    boolean d;
    int e;
    Dialog f;
    boolean g;
    boolean h;
    boolean i;

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: ProGuard */
    @interface DialogStyle {
    }

    public final void a(Context context) {
        super.a(context);
        if (!this.i) {
            this.h = false;
        }
    }

    public final void a() {
        super.a();
        if (!this.i && !this.h) {
            this.h = true;
        }
    }

    public final void a(@Nullable Bundle bundle) {
        super.a(bundle);
        this.d = this.H == 0;
        if (bundle != null) {
            this.a = bundle.getInt("android:style", 0);
            this.b = bundle.getInt("android:theme", 0);
            this.c = bundle.getBoolean("android:cancelable", true);
            this.d = bundle.getBoolean("android:showsDialog", this.d);
            this.e = bundle.getInt("android:backStackId", -1);
        }
    }

    public final LayoutInflater b(Bundle bundle) {
        if (!this.d) {
            return super.b(bundle);
        }
        this.f = new Dialog(e(), this.b);
        if (this.f == null) {
            return (LayoutInflater) this.C.c.getSystemService("layout_inflater");
        }
        Dialog dialog = this.f;
        switch (this.a) {
            case 1:
            case 2:
                break;
            case 3:
                dialog.getWindow().addFlags(24);
                break;
        }
        dialog.requestWindowFeature(1);
        return (LayoutInflater) this.f.getContext().getSystemService("layout_inflater");
    }

    public final void onCancel(DialogInterface dialogInterface) {
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        if (!this.g && !this.h) {
            this.h = true;
            this.i = false;
            if (this.f != null) {
                this.f.dismiss();
                this.f = null;
            }
            this.g = true;
            if (this.e >= 0) {
                this.B.a(this.e);
                this.e = -1;
                return;
            }
            FragmentTransaction a = this.B.a();
            a.a(this);
            a.a();
        }
    }

    public final void c(Bundle bundle) {
        super.c(bundle);
        if (this.d) {
            View view = this.S;
            if (view != null) {
                if (view.getParent() != null) {
                    throw new IllegalStateException("DialogFragment can not be attached to a container view");
                }
                this.f.setContentView(view);
            }
            Activity e = e();
            if (e != null) {
                this.f.setOwnerActivity(e);
            }
            this.f.setCancelable(this.c);
            this.f.setOnCancelListener(this);
            this.f.setOnDismissListener(this);
            if (bundle != null) {
                Bundle bundle2 = bundle.getBundle("android:savedDialogState");
                if (bundle2 != null) {
                    this.f.onRestoreInstanceState(bundle2);
                }
            }
        }
    }

    public final void b() {
        super.b();
        if (this.f != null) {
            this.g = false;
            this.f.show();
        }
    }

    public final void d(Bundle bundle) {
        super.d(bundle);
        if (this.f != null) {
            Bundle onSaveInstanceState = this.f.onSaveInstanceState();
            if (onSaveInstanceState != null) {
                bundle.putBundle("android:savedDialogState", onSaveInstanceState);
            }
        }
        if (this.a != 0) {
            bundle.putInt("android:style", this.a);
        }
        if (this.b != 0) {
            bundle.putInt("android:theme", this.b);
        }
        if (!this.c) {
            bundle.putBoolean("android:cancelable", this.c);
        }
        if (!this.d) {
            bundle.putBoolean("android:showsDialog", this.d);
        }
        if (this.e != -1) {
            bundle.putInt("android:backStackId", this.e);
        }
    }

    public final void c() {
        super.c();
        if (this.f != null) {
            this.f.hide();
        }
    }

    public final void d() {
        super.d();
        if (this.f != null) {
            this.g = true;
            this.f.dismiss();
            this.f = null;
        }
    }
}
