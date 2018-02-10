package android.support.v4.e.a;

import android.support.v4.view.ba;
import android.support.v4.view.bl;
import android.view.MenuItem;
import android.view.View;

/* compiled from: ProGuard */
public interface b extends MenuItem {
    b a(ba baVar);

    b a(bl blVar);

    bl a();

    boolean collapseActionView();

    boolean expandActionView();

    View getActionView();

    boolean isActionViewExpanded();

    MenuItem setActionView(int i);

    MenuItem setActionView(View view);

    void setShowAsAction(int i);

    MenuItem setShowAsActionFlags(int i);
}
