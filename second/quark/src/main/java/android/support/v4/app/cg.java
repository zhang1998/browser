package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;

/* compiled from: ProGuard */
final class cg extends cf {
    cg() {
    }

    public final Intent a(Activity activity) {
        Intent parentActivityIntent = activity.getParentActivityIntent();
        if (parentActivityIntent == null) {
            return super.a(activity);
        }
        return parentActivityIntent;
    }

    public final boolean a(Activity activity, Intent intent) {
        return activity.shouldUpRecreateTask(intent);
    }

    public final void b(Activity activity, Intent intent) {
        activity.navigateUpTo(intent);
    }

    public final String a(Context context, ActivityInfo activityInfo) {
        String str = activityInfo.parentActivityName;
        if (str == null) {
            return super.a(context, activityInfo);
        }
        return str;
    }
}
