package com.bumptech.glide.c;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.util.Log;
import com.bumptech.glide.c;
import com.bumptech.glide.u;
import java.util.HashSet;

/* compiled from: ProGuard */
public final class n extends Fragment {
    final a a;
    final r b;
    @Nullable
    u c;
    @Nullable
    Fragment d;
    private final HashSet<n> e;
    @Nullable
    private n f;

    public n() {
        this(new a());
    }

    @SuppressLint({"ValidFragment"})
    private n(a aVar) {
        this.b = new m(this);
        this.e = new HashSet();
        this.a = aVar;
    }

    private void a() {
        if (this.f != null) {
            this.f.e.remove(this);
            this.f = null;
        }
    }

    public final void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            a();
            this.f = c.a((Context) activity).f.a(activity.getFragmentManager());
            if (this.f != this) {
                this.f.e.add(this);
            }
        } catch (Throwable e) {
            if (Log.isLoggable("RMFragment", 5)) {
                Log.w("RMFragment", "Unable to register fragment with root", e);
            }
        }
    }

    public final void onDetach() {
        super.onDetach();
        a();
    }

    public final void onStart() {
        super.onStart();
        this.a.a();
    }

    public final void onStop() {
        super.onStop();
        this.a.b();
    }

    public final void onDestroy() {
        super.onDestroy();
        this.a.c();
        a();
    }

    public final void onTrimMemory(int i) {
        super.onTrimMemory(i);
        if (this.c != null) {
            this.c.a(i);
        }
    }

    public final void onLowMemory() {
        super.onLowMemory();
        if (this.c != null) {
            this.c.d();
        }
    }

    public final String toString() {
        Object parentFragment;
        StringBuilder append = new StringBuilder().append(super.toString()).append("{parent=");
        if (VERSION.SDK_INT >= 17) {
            parentFragment = getParentFragment();
        } else {
            parentFragment = null;
        }
        if (parentFragment == null) {
            parentFragment = this.d;
        }
        return append.append(parentFragment).append("}").toString();
    }
}
