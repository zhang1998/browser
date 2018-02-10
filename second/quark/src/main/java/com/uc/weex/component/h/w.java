package com.uc.weex.component.h;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Typeface;
import android.text.TextUtils;
import com.taobao.weex.ac;
import com.taobao.weex.c.ae;
import com.taobao.weex.c.v;
import com.taobao.weex.ui.animation.WXAnimationBean.Style;
import com.taobao.weex.ui.component.WXComponentProp;
import com.taobao.weex.ui.component.bv;
import com.taobao.weex.utils.WXViewUtils;
import com.taobao.weex.utils.ah;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: ProGuard */
public class w extends q {
    private static Pattern n = Pattern.compile("^\\s*((?:(?:normal|bold|italic)\\s+)*)(?:(\\d+(?:\\.\\d+)?)[ptexm\\%]*(?:\\s*\\/.*?)?\\s+)?\\s*\\\"?([^\\\"]*)", 2);
    private int o = ((int) WXViewUtils.a(12.0f));
    private String p;
    private boolean q;
    private boolean r;
    private int s = 0;
    private int[] t = new int[]{0, 0};

    public w(ac acVar, ae aeVar, bv bvVar, boolean z) {
        super(acVar, aeVar, bvVar, z);
    }

    @WXComponentProp(name = "font")
    public void setFont(String str) {
        if (str != null) {
            int hashCode = str.hashCode();
            if (this.t[0] != hashCode) {
                Matcher matcher = n.matcher(str);
                if (matcher.find()) {
                    setFontFamily(matcher.group(3));
                    setFontSize(matcher.group(2));
                    String group = matcher.group(1);
                    if (group == null || group.indexOf("bold") < 0) {
                        setFontWeight(null);
                    } else {
                        setFontWeight("bold");
                    }
                    if (group == null || group.indexOf("italic") < 0) {
                        setFontStyle(null);
                    } else {
                        setFontStyle("italic");
                    }
                }
                this.t[0] = hashCode;
            }
        }
    }

    @WXComponentProp(name = "fontSize")
    public void setFontSize(String str) {
        if (str != null) {
            int b = ah.b((Object) str);
            if (this.o != b) {
                this.o = b;
            }
        }
    }

    @WXComponentProp(name = "fontsize")
    public void setFontSize2(String str) {
        setFontSize(str);
    }

    @WXComponentProp(name = "fontFamily")
    public void setFontFamily(String str) {
        if (str != null && !str.equalsIgnoreCase(this.p)) {
            this.p = str;
        }
    }

    @WXComponentProp(name = "fontfamily")
    public void setFontFamily2(String str) {
        setFontFamily(str);
    }

    @WXComponentProp(name = "fontStyle")
    public void setFontStyle(String str) {
        boolean equalsIgnoreCase = "italic".equalsIgnoreCase(str);
        if (equalsIgnoreCase != this.r) {
            this.r = equalsIgnoreCase;
        }
    }

    @WXComponentProp(name = "fontstyle")
    public void setFontStyle2(String str) {
        setFontStyle(str);
    }

    @WXComponentProp(name = "fontWeight")
    public void setFontWeight(String str) {
        boolean equalsIgnoreCase = "bold".equalsIgnoreCase(str);
        if (equalsIgnoreCase != this.q) {
            this.q = equalsIgnoreCase;
        }
    }

    @WXComponentProp(name = "fontweight")
    public void setFontWeight2(String str) {
        setFontWeight(str);
    }

    public final void a(Canvas canvas, Paint paint, float f) {
        String b = b();
        if (b != null) {
            float f2 = f * this.a;
            if (f2 > 0.01f) {
                String[] split = b.split("\n");
                if (split.length != 0) {
                    a(canvas);
                    String join = TextUtils.join("\n", split);
                    if (a(paint, f2)) {
                        a(paint);
                        if (this.l == null) {
                            canvas.drawText(join, 0.0f, -paint.ascent(), paint);
                        } else {
                            canvas.drawTextOnPath(join, this.l, 0.0f, 0.0f, paint);
                        }
                    }
                    if (b(paint, f2)) {
                        a(paint);
                        if (this.l == null) {
                            canvas.drawText(join, 0.0f, -paint.ascent(), paint);
                        } else {
                            canvas.drawTextOnPath(join, this.l, 0.0f, 0.0f, paint);
                        }
                    }
                    canvas.restore();
                }
            }
        }
    }

    private void a(Paint paint) {
        int i;
        switch (this.s) {
            case 0:
                paint.setTextAlign(Align.LEFT);
                break;
            case 1:
                paint.setTextAlign(Align.RIGHT);
                break;
            case 2:
                paint.setTextAlign(Align.CENTER);
                break;
        }
        paint.setTextSize(((float) this.o) * this.b.b);
        if (this.q && this.r) {
            i = 3;
        } else if (this.q) {
            i = 1;
        } else if (this.r) {
            i = 2;
        } else {
            i = 0;
        }
        paint.setTypeface(Typeface.create(this.p, i));
    }

    private String b() {
        return v.a(getDomObject().i());
    }

    public void updateExtra(Object obj) {
        String b = b();
        if (b != null) {
            int hashCode = b.hashCode();
            if (this.t[1] != hashCode) {
                this.t[1] = hashCode;
            }
        }
    }

    @WXComponentProp(name = "alignment")
    public void setAlignment(String str) {
        int i;
        if (Style.RIGHT.equals(str)) {
            i = 1;
        } else if (Style.CENTER.equals(str)) {
            i = 2;
        } else {
            i = 0;
        }
        if (this.s != i) {
            this.s = i;
        }
    }
}
