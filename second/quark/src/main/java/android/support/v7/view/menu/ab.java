package android.support.v7.view.menu;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.e.a.b;
import android.support.v4.view.bl;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import java.lang.reflect.Method;

@TargetApi(14)
/* compiled from: ProGuard */
public class ab extends y<b> implements MenuItem {
    public Method e;

    ab(Context context, b bVar) {
        super(context, bVar);
    }

    public int getItemId() {
        return ((b) this.a).getItemId();
    }

    public int getGroupId() {
        return ((b) this.a).getGroupId();
    }

    public int getOrder() {
        return ((b) this.a).getOrder();
    }

    public MenuItem setTitle(CharSequence charSequence) {
        ((b) this.a).setTitle(charSequence);
        return this;
    }

    public MenuItem setTitle(int i) {
        ((b) this.a).setTitle(i);
        return this;
    }

    public CharSequence getTitle() {
        return ((b) this.a).getTitle();
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        ((b) this.a).setTitleCondensed(charSequence);
        return this;
    }

    public CharSequence getTitleCondensed() {
        return ((b) this.a).getTitleCondensed();
    }

    public MenuItem setIcon(Drawable drawable) {
        ((b) this.a).setIcon(drawable);
        return this;
    }

    public MenuItem setIcon(int i) {
        ((b) this.a).setIcon(i);
        return this;
    }

    public Drawable getIcon() {
        return ((b) this.a).getIcon();
    }

    public MenuItem setIntent(Intent intent) {
        ((b) this.a).setIntent(intent);
        return this;
    }

    public Intent getIntent() {
        return ((b) this.a).getIntent();
    }

    public MenuItem setShortcut(char c, char c2) {
        ((b) this.a).setShortcut(c, c2);
        return this;
    }

    public MenuItem setNumericShortcut(char c) {
        ((b) this.a).setNumericShortcut(c);
        return this;
    }

    public char getNumericShortcut() {
        return ((b) this.a).getNumericShortcut();
    }

    public MenuItem setAlphabeticShortcut(char c) {
        ((b) this.a).setAlphabeticShortcut(c);
        return this;
    }

    public char getAlphabeticShortcut() {
        return ((b) this.a).getAlphabeticShortcut();
    }

    public MenuItem setCheckable(boolean z) {
        ((b) this.a).setCheckable(z);
        return this;
    }

    public boolean isCheckable() {
        return ((b) this.a).isCheckable();
    }

    public MenuItem setChecked(boolean z) {
        ((b) this.a).setChecked(z);
        return this;
    }

    public boolean isChecked() {
        return ((b) this.a).isChecked();
    }

    public MenuItem setVisible(boolean z) {
        return ((b) this.a).setVisible(z);
    }

    public boolean isVisible() {
        return ((b) this.a).isVisible();
    }

    public MenuItem setEnabled(boolean z) {
        ((b) this.a).setEnabled(z);
        return this;
    }

    public boolean isEnabled() {
        return ((b) this.a).isEnabled();
    }

    public boolean hasSubMenu() {
        return ((b) this.a).hasSubMenu();
    }

    public SubMenu getSubMenu() {
        return a(((b) this.a).getSubMenu());
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        ((b) this.a).setOnMenuItemClickListener(onMenuItemClickListener != null ? new n(this, onMenuItemClickListener) : null);
        return this;
    }

    public ContextMenuInfo getMenuInfo() {
        return ((b) this.a).getMenuInfo();
    }

    public void setShowAsAction(int i) {
        ((b) this.a).setShowAsAction(i);
    }

    public MenuItem setShowAsActionFlags(int i) {
        ((b) this.a).setShowAsActionFlags(i);
        return this;
    }

    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new aa(view);
        }
        ((b) this.a).setActionView(view);
        return this;
    }

    public MenuItem setActionView(int i) {
        ((b) this.a).setActionView(i);
        View actionView = ((b) this.a).getActionView();
        if (actionView instanceof CollapsibleActionView) {
            ((b) this.a).setActionView(new aa(actionView));
        }
        return this;
    }

    public View getActionView() {
        View actionView = ((b) this.a).getActionView();
        return actionView instanceof aa ? (View) ((aa) actionView).a : actionView;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        ((b) this.a).a(actionProvider != null ? a(actionProvider) : null);
        return this;
    }

    public ActionProvider getActionProvider() {
        bl a = ((b) this.a).a();
        if (a instanceof s) {
            return ((s) a).c;
        }
        return null;
    }

    public boolean expandActionView() {
        return ((b) this.a).expandActionView();
    }

    public boolean collapseActionView() {
        return ((b) this.a).collapseActionView();
    }

    public boolean isActionViewExpanded() {
        return ((b) this.a).isActionViewExpanded();
    }

    public MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        ((b) this.a).a(onActionExpandListener != null ? new f(this, onActionExpandListener) : null);
        return this;
    }

    s a(ActionProvider actionProvider) {
        return new s(this, this.b, actionProvider);
    }
}
