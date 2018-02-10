package com.uc.apollo.android;

import android.app.AlertDialog.Builder;
import android.content.Context;
import com.uc.apollo.annotation.KeepForSdk;
import java.util.Map;

@KeepForSdk
/* compiled from: ProGuard */
public interface GuideDialog {
    public static final String MESSAGE = "message";
    public static final String NEGATIVE_BTN = "negativeBtn";
    public static final String POSITIVE_BTN = "positiveBtn";
    public static final String TITLE = "title";

    @KeepForSdk
    /* compiled from: ProGuard */
    public interface Factory {
        GuideDialog create(Context context);
    }

    /* compiled from: ProGuard */
    public final class a implements GuideDialog {
        private Context a;

        public a(Context context) {
            this.a = SystemUtils.a(context);
        }

        public final void show(Map<String, String> map, Runnable runnable) {
            Builder builder = new Builder(this.a);
            builder.setCancelable(true);
            builder.setIcon(17301659);
            builder.setTitle((CharSequence) map.get(GuideDialog.TITLE));
            builder.setMessage((CharSequence) map.get(GuideDialog.MESSAGE));
            builder.setNegativeButton((CharSequence) map.get(GuideDialog.NEGATIVE_BTN), new a(this));
            builder.setPositiveButton((CharSequence) map.get(GuideDialog.POSITIVE_BTN), new b(this, runnable));
            builder.create().show();
        }

        public final Context getContext() {
            return this.a;
        }
    }

    Context getContext();

    void show(Map<String, String> map, Runnable runnable);
}
