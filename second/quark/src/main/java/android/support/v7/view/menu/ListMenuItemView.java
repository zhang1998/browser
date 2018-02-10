package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.c.h;
import android.support.v7.c.j;
import android.support.v7.c.l;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

/* compiled from: ProGuard */
public class ListMenuItemView extends LinearLayout implements k {
    private i a;
    private ImageView b;
    private RadioButton c;
    private TextView d;
    private CheckBox e;
    private TextView f;
    private Drawable g;
    private int h;
    private Context i;
    private boolean j;
    private int k;
    private Context l;
    private LayoutInflater m;
    private boolean n;

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.l = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, h.MenuView, i, 0);
        this.g = obtainStyledAttributes.getDrawable(h.MenuView_android_itemBackground);
        this.h = obtainStyledAttributes.getResourceId(h.MenuView_android_itemTextAppearance, -1);
        this.j = obtainStyledAttributes.getBoolean(h.MenuView_preserveIconSpacing, false);
        this.i = context;
        obtainStyledAttributes.recycle();
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        setBackgroundDrawable(this.g);
        this.d = (TextView) findViewById(j.title);
        if (this.h != -1) {
            this.d.setTextAppearance(this.i, this.h);
        }
        this.f = (TextView) findViewById(j.shortcut);
    }

    public final void a(i iVar) {
        int i = 0;
        this.a = iVar;
        this.k = 0;
        setVisibility(iVar.isVisible() ? 0 : 8);
        setTitle(iVar.a((k) this));
        setCheckable(iVar.isCheckable());
        boolean d = iVar.d();
        iVar.c();
        if (!(d && this.a.d())) {
            i = 8;
        }
        if (i == 0) {
            CharSequence charSequence;
            TextView textView = this.f;
            char c = this.a.c();
            if (c == '\u0000') {
                charSequence = "";
            } else {
                StringBuilder stringBuilder = new StringBuilder(i.f);
                switch (c) {
                    case '\b':
                        stringBuilder.append(i.h);
                        break;
                    case '\n':
                        stringBuilder.append(i.g);
                        break;
                    case ' ':
                        stringBuilder.append(i.i);
                        break;
                    default:
                        stringBuilder.append(c);
                        break;
                }
                charSequence = stringBuilder.toString();
            }
            textView.setText(charSequence);
        }
        if (this.f.getVisibility() != i) {
            this.f.setVisibility(i);
        }
        setIcon(iVar.getIcon());
        setEnabled(iVar.isEnabled());
    }

    public void setForceShowIcon(boolean z) {
        this.n = z;
        this.j = z;
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.d.setText(charSequence);
            if (this.d.getVisibility() != 0) {
                this.d.setVisibility(0);
            }
        } else if (this.d.getVisibility() != 8) {
            this.d.setVisibility(8);
        }
    }

    public i getItemData() {
        return this.a;
    }

    public void setCheckable(boolean z) {
        if (z || this.c != null || this.e != null) {
            CompoundButton compoundButton;
            CompoundButton compoundButton2;
            if (this.a.e()) {
                if (this.c == null) {
                    b();
                }
                compoundButton = this.c;
                compoundButton2 = this.e;
            } else {
                if (this.e == null) {
                    c();
                }
                compoundButton = this.e;
                compoundButton2 = this.c;
            }
            if (z) {
                int i;
                compoundButton.setChecked(this.a.isChecked());
                if (z) {
                    i = 0;
                } else {
                    i = 8;
                }
                if (compoundButton.getVisibility() != i) {
                    compoundButton.setVisibility(i);
                }
                if (compoundButton2 != null && compoundButton2.getVisibility() != 8) {
                    compoundButton2.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.e != null) {
                this.e.setVisibility(8);
            }
            if (this.c != null) {
                this.c.setVisibility(8);
            }
        }
    }

    public void setChecked(boolean z) {
        CompoundButton compoundButton;
        if (this.a.e()) {
            if (this.c == null) {
                b();
            }
            compoundButton = this.c;
        } else {
            if (this.e == null) {
                c();
            }
            compoundButton = this.e;
        }
        compoundButton.setChecked(z);
    }

    private void setShortcut$25d965e(boolean z) {
        int i;
        if (z && this.a.d()) {
            i = 0;
        } else {
            i = 8;
        }
        if (i == 0) {
            CharSequence charSequence;
            TextView textView = this.f;
            char c = this.a.c();
            if (c == '\u0000') {
                charSequence = "";
            } else {
                StringBuilder stringBuilder = new StringBuilder(i.f);
                switch (c) {
                    case '\b':
                        stringBuilder.append(i.h);
                        break;
                    case '\n':
                        stringBuilder.append(i.g);
                        break;
                    case ' ':
                        stringBuilder.append(i.i);
                        break;
                    default:
                        stringBuilder.append(c);
                        break;
                }
                charSequence = stringBuilder.toString();
            }
            textView.setText(charSequence);
        }
        if (this.f.getVisibility() != i) {
            this.f.setVisibility(i);
        }
    }

    public void setIcon(Drawable drawable) {
        boolean z = this.a.b.j || this.n;
        if (!z && !this.j) {
            return;
        }
        if (this.b != null || drawable != null || this.j) {
            if (this.b == null) {
                this.b = (ImageView) getInflater().inflate(l.abc_list_menu_item_icon, this, false);
                addView(this.b, 0);
            }
            if (drawable != null || this.j) {
                ImageView imageView = this.b;
                if (!z) {
                    drawable = null;
                }
                imageView.setImageDrawable(drawable);
                if (this.b.getVisibility() != 0) {
                    this.b.setVisibility(0);
                    return;
                }
                return;
            }
            this.b.setVisibility(8);
        }
    }

    protected void onMeasure(int i, int i2) {
        if (this.b != null && this.j) {
            LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.b.getLayoutParams();
            if (layoutParams.height > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = layoutParams.height;
            }
        }
        super.onMeasure(i, i2);
    }

    private void b() {
        this.c = (RadioButton) getInflater().inflate(l.abc_list_menu_item_radio, this, false);
        addView(this.c);
    }

    private void c() {
        this.e = (CheckBox) getInflater().inflate(l.abc_list_menu_item_checkbox, this, false);
        addView(this.e);
    }

    public final boolean a() {
        return false;
    }

    private LayoutInflater getInflater() {
        if (this.m == null) {
            this.m = LayoutInflater.from(this.l);
        }
        return this.m;
    }
}
