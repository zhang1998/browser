package android.support.v7.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.ax;
import android.support.v4.app.ct;
import android.support.v4.app.cu;
import android.support.v4.view.dn;
import android.support.v7.widget.ga;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.UCMobile.Apollo.MediaPlayer;
import org.android.spdy.SpdyProtocol;

/* compiled from: ProGuard */
public class AppCompatActivity extends FragmentActivity implements ct, ac {
    private AppCompatDelegate l;
    private int m = 0;
    private boolean n;
    private Resources o;

    protected void onCreate(@Nullable Bundle bundle) {
        AppCompatDelegate g = g();
        g.h();
        g.a(bundle);
        if (g.i() && this.m != 0) {
            if (VERSION.SDK_INT >= 23) {
                onApplyThemeResource(getTheme(), this.m, false);
            } else {
                setTheme(this.m);
            }
        }
        super.onCreate(bundle);
    }

    public void setTheme(@StyleRes int i) {
        super.setTheme(i);
        this.m = i;
    }

    protected void onPostCreate(@Nullable Bundle bundle) {
        super.onPostCreate(bundle);
        g().a();
    }

    public MenuInflater getMenuInflater() {
        return g().k();
    }

    public void setContentView(@LayoutRes int i) {
        g().b(i);
    }

    public void setContentView(View view) {
        g().a(view);
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        g().a(view, layoutParams);
    }

    public void addContentView(View view, LayoutParams layoutParams) {
        g().b(view, layoutParams);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        g().a(configuration);
        if (this.o != null) {
            this.o.updateConfiguration(configuration, super.getResources().getDisplayMetrics());
        }
    }

    protected void onStop() {
        super.onStop();
        g().c();
    }

    protected void onPostResume() {
        super.onPostResume();
        g().d();
    }

    @Nullable
    public View findViewById(@IdRes int i) {
        return g().a(i);
    }

    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        ActionBar j = g().j();
        if (menuItem.getItemId() != 16908332 || j == null || (j.a() & 4) == 0) {
            return false;
        }
        return f();
    }

    protected void onDestroy() {
        super.onDestroy();
        g().e();
    }

    protected void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        g().b(charSequence);
    }

    public final void a() {
        g().f();
    }

    public void invalidateOptionsMenu() {
        g().f();
    }

    private boolean f() {
        int i = 0;
        Intent a = ax.a(this);
        if (a == null) {
            return false;
        }
        if (ax.a((Activity) this, a)) {
            Intent a2;
            cu a3 = cu.a((Context) this);
            if (this instanceof ct) {
                a = b();
            } else {
                a = null;
            }
            if (a == null) {
                a2 = ax.a(this);
            } else {
                a2 = a;
            }
            if (a2 != null) {
                ComponentName component = a2.getComponent();
                if (component == null) {
                    component = a2.resolveActivity(a3.b.getPackageManager());
                }
                a3.a(component);
                a3.a.add(a2);
            }
            if (a3.a.isEmpty()) {
                throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
            }
            Intent[] intentArr = (Intent[]) a3.a.toArray(new Intent[a3.a.size()]);
            intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
            Context context = a3.b;
            int i2 = VERSION.SDK_INT;
            if (i2 >= 16) {
                context.startActivities(intentArr, null);
                i = 1;
            } else if (i2 >= 11) {
                context.startActivities(intentArr);
                i = 1;
            }
            if (i == 0) {
                Intent intent = new Intent(intentArr[intentArr.length - 1]);
                intent.addFlags(MediaPlayer.MEDIA_ERROR_UNKNOWN);
                a3.b.startActivity(intent);
            }
            try {
                if (VERSION.SDK_INT >= 16) {
                    finishAffinity();
                } else {
                    finish();
                }
            } catch (IllegalStateException e) {
                finish();
            }
        } else {
            ax.b((Activity) this, a);
        }
        return true;
    }

    @Nullable
    public final Intent b() {
        return ax.a(this);
    }

    public void onContentChanged() {
    }

    public boolean onMenuOpened(int i, Menu menu) {
        return super.onMenuOpened(i, menu);
    }

    public void onPanelClosed(int i, Menu menu) {
        super.onPanelClosed(i, menu);
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        g().b(bundle);
    }

    @NonNull
    private AppCompatDelegate g() {
        if (this.l == null) {
            this.l = AppCompatDelegate.a((Activity) this, (ac) this);
        }
        return this.l;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (dn.a(keyEvent, SpdyProtocol.SLIGHTSSL_0_RTT_MODE) && keyEvent.getUnicodeChar(keyEvent.getMetaState() & -28673) == 60) {
            int action = keyEvent.getAction();
            if (action == 0) {
                ActionBar j = g().j();
                if (j != null && j.b() && j.f()) {
                    this.n = true;
                    return true;
                }
            } else if (action == 1 && this.n) {
                this.n = false;
                return true;
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public Resources getResources() {
        if (this.o == null && ga.a()) {
            this.o = new ga(this, super.getResources());
        }
        return this.o == null ? super.getResources() : this.o;
    }
}
