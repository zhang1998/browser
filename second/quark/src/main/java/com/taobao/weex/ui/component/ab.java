package com.taobao.weex.ui.component;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.mini.support.annotation.CallSuper;
import android.mini.support.annotation.CheckResult;
import android.mini.support.annotation.NonNull;
import android.mini.support.annotation.Nullable;
import android.mini.support.v4.view.ViewCompat;
import android.os.Build.VERSION;
import android.os.Message;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.taobao.weex.ac;
import com.taobao.weex.ad;
import com.taobao.weex.c.a.e;
import com.taobao.weex.c.ae;
import com.taobao.weex.c.ao;
import com.taobao.weex.c.b.r;
import com.taobao.weex.c.o;
import com.taobao.weex.c.v;
import com.taobao.weex.common.t;
import com.taobao.weex.i;
import com.taobao.weex.ui.animation.WXAnimationBean.Style;
import com.taobao.weex.ui.animation.d;
import com.taobao.weex.ui.component.c.a;
import com.taobao.weex.ui.view.a.c;
import com.taobao.weex.ui.view.a.f;
import com.taobao.weex.ui.view.border.b;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.WXViewUtils;
import com.taobao.weex.utils.af;
import com.taobao.weex.utils.ah;
import com.taobao.weex.utils.w;
import com.tencent.tinker.loader.shareutil.ShareElfFile.SectionHeader;
import com.uc.imagecodec.export.IPictureView;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: ProGuard */
public abstract class ab<T extends View> implements a {
    public static final int HORIZONTAL = 0;
    public static final String PROP_FIXED_SIZE = "fixedSize";
    public static final String PROP_FS_MATCH_PARENT = "m";
    public static final String PROP_FS_MATCH_PARENT_HEIGHT = "m-h";
    public static final String PROP_FS_MATCH_PARENT_WIDTH = "m-w";
    public static final String PROP_FS_WRAP_CONTENT = "w";
    public static final int TYPE_COMMON = 0;
    public static final int TYPE_VIRTUAL = 1;
    public static final int VERTICAL = 1;
    public static int mComponentNum = 0;
    private boolean isUsing;
    private int mAbsoluteX;
    private int mAbsoluteY;
    private d mAnimationHolder;
    private Set<String> mAppendEvents;
    private b mBackgroundDrawable;
    private z mClickEventListener;
    private Context mContext;
    private String mCurrentRef;
    private float mCustomAppearProportion;
    private volatile o mDomObj;
    private int mFixedProp;
    private int mFixedPropHeight;
    private int mFixedPropWidth;
    private List<aa> mFocusChangeListeners;
    private com.taobao.weex.ui.view.a.b mGesture;
    private Set<String> mGestureType;
    private com.taobao.weex.ui.b mHolder;
    T mHost;
    private List<z> mHostClickListeners;
    private ac mInstance;
    private boolean mIsDestroyed;
    private boolean mIsDisabled;
    private boolean mNeedLayoutOnAnimation;
    private volatile bv mParent;
    private com.taobao.weex.ui.component.c.b mPesudoStatus;
    private int mPreRealHeight;
    private int mPreRealLeft;
    private int mPreRealTop;
    private int mPreRealWidth;
    private int mStickyOffset;
    private int mType;

    public void postAnimation(d dVar) {
        this.mAnimationHolder = dVar;
    }

    public String getInstanceId() {
        return this.mInstance.e;
    }

    public Rect getComponentSize() {
        Rect rect = new Rect();
        if (this.mHost != null) {
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            this.mHost.getLocationOnScreen(iArr);
            this.mInstance.f.getLocationOnScreen(iArr2);
            int i = iArr[0] - iArr2[0];
            int i2 = (iArr[1] - this.mStickyOffset) - iArr2[1];
            rect.set(i, i2, ((int) this.mDomObj.o()) + i, ((int) this.mDomObj.p()) + i2);
        }
        return rect;
    }

    public final void invoke(String str, com.alibaba.fastjson.b bVar) {
        com.taobao.weex.bridge.a a = this.mHolder.a(str);
        if (a != null) {
            try {
                getInstance().j.a(this, a, bVar);
                return;
            } catch (Throwable e) {
                WXLogUtils.e("[WXComponent] updateProperties :class:" + getClass() + "method:" + a.toString() + " function " + WXLogUtils.getStackTrace(e));
                return;
            }
        }
        onInvokeUnknownMethod(str, bVar);
    }

    protected void onInvokeUnknownMethod(String str, com.alibaba.fastjson.b bVar) {
    }

    @Deprecated
    public ab(ac acVar, ae aeVar, bv bvVar, String str, boolean z) {
        this(acVar, aeVar, bvVar, z);
    }

    @Deprecated
    public ab(ac acVar, ae aeVar, bv bvVar, boolean z) {
        this(acVar, aeVar, bvVar);
    }

    public ab(ac acVar, ae aeVar, bv bvVar) {
        this(acVar, aeVar, bvVar, 0);
    }

    public ab(ac acVar, ae aeVar, bv bvVar, int i) {
        this.mFixedPropWidth = 0;
        this.mFixedPropHeight = 0;
        this.mFixedProp = 0;
        this.mAbsoluteY = 0;
        this.mAbsoluteX = 0;
        this.mPreRealWidth = 0;
        this.mPreRealHeight = 0;
        this.mPreRealLeft = 0;
        this.mPreRealTop = 0;
        this.mStickyOffset = 0;
        this.isUsing = false;
        this.mAppendEvents = new HashSet();
        this.mPesudoStatus = new com.taobao.weex.ui.component.c.b();
        this.mIsDestroyed = false;
        this.mIsDisabled = false;
        this.mType = 0;
        this.mNeedLayoutOnAnimation = false;
        this.mCustomAppearProportion = 0.0f;
        this.mClickEventListener = new u(this);
        this.mInstance = acVar;
        this.mContext = this.mInstance.b();
        this.mParent = bvVar;
        this.mType = i;
        this.mDomObj = aeVar.v();
        this.mCurrentRef = this.mDomObj.b_();
        this.mGestureType = new HashSet();
        mComponentNum++;
        onCreate();
    }

    protected void onCreate() {
    }

    public void bindHolder(com.taobao.weex.ui.b bVar) {
        this.mHolder = bVar;
    }

    public ac getInstance() {
        return this.mInstance;
    }

    public Context getContext() {
        return this.mContext;
    }

    protected final ab findComponent(String str) {
        if (this.mInstance == null || str == null) {
            return null;
        }
        return ad.a().c.a(this.mInstance.e, str);
    }

    public final void fireEvent(String str) {
        fireEvent(str, null);
    }

    public final void fireEvent(String str, Map<String, Object> map) {
        fireEvent(str, map, null);
    }

    protected final void fireEvent(String str, Map<String, Object> map, Map<String, Object> map2) {
        if (this.mInstance != null && this.mDomObj != null) {
            this.mInstance.a(this.mCurrentRef, str, map, map2);
        }
    }

    public boolean isLazy() {
        return this.mParent != null && this.mParent.isLazy();
    }

    public void applyLayoutAndEvent(ab abVar) {
        if (!isLazy()) {
            if (abVar == null) {
                abVar = this;
            }
            setLayout(abVar.getDomObject());
            setPadding(abVar.getDomObject().k(), abVar.getDomObject().l());
            addEvents();
        }
    }

    protected final void addFocusChangeListener(aa aaVar) {
        if (aaVar != null) {
            View realView = getRealView();
            if (realView != null) {
                if (this.mFocusChangeListeners == null) {
                    this.mFocusChangeListeners = new ArrayList();
                    realView.setFocusable(true);
                    realView.setOnFocusChangeListener(new v(this));
                }
                this.mFocusChangeListeners.add(aaVar);
            }
        }
    }

    protected final void addClickListener(z zVar) {
        if (zVar != null) {
            View realView = getRealView();
            if (realView != null) {
                if (this.mHostClickListeners == null) {
                    this.mHostClickListeners = new ArrayList();
                    realView.setOnClickListener(new w(this));
                }
                this.mHostClickListeners.add(zVar);
            }
        }
    }

    protected final void removeClickListener(z zVar) {
        this.mHostClickListeners.remove(zVar);
    }

    public void bindData(ab abVar) {
        if (!isLazy()) {
            if (abVar == null) {
                abVar = this;
            }
            this.mCurrentRef = abVar.getDomObject().b_();
            updateStyle(abVar);
            updateAttrs(abVar);
            updateExtra(abVar.getDomObject().q());
        }
    }

    public void updateStyle(ab abVar) {
        o domObject = abVar.getDomObject();
        if (domObject != null) {
            updateProperties(domObject.g());
        }
    }

    public void updateAttrs(ab abVar) {
        o domObject = abVar.getDomObject();
        if (domObject != null) {
            updateProperties(domObject.i());
        }
    }

    public void refreshData(ab abVar) {
    }

    public b getOrCreateBorder() {
        if (this.mBackgroundDrawable == null) {
            Drawable background = this.mHost.getBackground();
            WXViewUtils.a(this.mHost, null);
            this.mBackgroundDrawable = new b();
            if (background == null) {
                WXViewUtils.a(this.mHost, this.mBackgroundDrawable);
            } else {
                WXViewUtils.a(this.mHost, new LayerDrawable(new Drawable[]{this.mBackgroundDrawable, background}));
            }
        }
        return this.mBackgroundDrawable;
    }

    public final void setLayout(o oVar) {
        float f = 0.0f;
        int i = 0;
        if (oVar != null && !TextUtils.isEmpty(this.mCurrentRef)) {
            r rVar;
            int i2 = this.mParent == null ? 1 : 0;
            this.mDomObj = oVar;
            int c = i2 != 0 ? 0 : this.mParent.c();
            r rVar2 = i2 != 0 ? new r() : this.mParent.getDomObject().k();
            if (i2 != 0) {
                rVar = new r();
            } else {
                rVar = this.mParent.getDomObject().l();
            }
            r j = this.mDomObj.j();
            int o = (int) this.mDomObj.o();
            int p = (int) this.mDomObj.p();
            int m = (int) ((this.mDomObj.m() - rVar2.a(0)) - rVar.a(0));
            c += (int) ((this.mDomObj.n() - rVar2.a(1)) - rVar.a(1));
            int a = (int) j.a(2);
            int a2 = (int) j.a(3);
            if (this.mPreRealWidth != o || this.mPreRealHeight != p || this.mPreRealLeft != m || this.mPreRealTop != c) {
                if (this.mParent != null) {
                    if (this.mParent.getDomObject().r().equals("uc-viewpager")) {
                        if (i2 == 0) {
                            i = this.mParent.getAbsoluteY();
                        }
                        this.mAbsoluteY = i;
                    } else {
                        this.mAbsoluteY = (int) (i2 != 0 ? 0.0f : ((float) this.mParent.getAbsoluteY()) + this.mDomObj.n());
                    }
                    if (i2 == 0) {
                        f = ((float) this.mParent.getAbsoluteY()) + this.mDomObj.m();
                    }
                    this.mAbsoluteX = (int) f;
                }
                if (!(this.mInstance.a || (this.mHost instanceof ViewGroup) || this.mAbsoluteY + p <= this.mInstance.c() + 1)) {
                    this.mInstance.l();
                }
                if (this.mHost != null) {
                    y measure = measure(o, p);
                    i = measure.a;
                    int i3 = measure.b;
                    if (this.mDomObj.f()) {
                        setFixedHostLayoutParams(this.mHost, i, i3, m, a, c, a2);
                    } else {
                        setHostLayoutParams(this.mHost, i, i3, m, a, c, a2);
                    }
                    this.mPreRealWidth = i;
                    this.mPreRealHeight = i3;
                    this.mPreRealLeft = m;
                    this.mPreRealTop = c;
                    onFinishLayout();
                }
            }
        }
    }

    public int getLayoutTopOffsetForSibling() {
        return 0;
    }

    public void setHostLayoutParams(T t, int i, int i2, int i3, int i4, int i5, int i6) {
        LayoutParams layoutParams;
        if (this.mParent == null) {
            layoutParams = new FrameLayout.LayoutParams(i, i2);
            layoutParams.setMargins(i3, i5, i4, i6);
        } else {
            layoutParams = this.mParent.a(this, t, i, i2, i3, i4, i5, i6);
        }
        if (layoutParams != null) {
            this.mHost.setLayoutParams(layoutParams);
        }
    }

    private void setFixedHostLayoutParams(T t, int i, int i2, int i3, int i4, int i5, int i6) {
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = i;
        layoutParams.height = i2;
        layoutParams.setMargins(i3, i5, i4, i6);
        t.setLayoutParams(layoutParams);
        ac acVar = this.mInstance;
        if (acVar.f != null) {
            ViewGroup viewGroup = (ViewGroup) t.getParent();
            if (viewGroup != null) {
                if (viewGroup != acVar.f) {
                    viewGroup.removeView(t);
                }
            }
            acVar.f.addView(t);
        }
        if (i.c()) {
            WXLogUtils.d("Weex_Fixed_Style", "WXComponent:setLayout :" + i3 + " " + i5 + " " + i + " " + i2);
            WXLogUtils.d("Weex_Fixed_Style", "WXComponent:setLayout Left:" + ah.a(this.mDomObj.g().get(Style.LEFT)) + " " + ((int) ah.a(this.mDomObj.g().get(Style.TOP))));
        }
    }

    protected void onFinishLayout() {
        Object obj = this.mDomObj.g() != null ? this.mDomObj.g().get("backgroundImage") : null;
        if (obj != null) {
            setBackgroundImage(obj.toString());
        }
    }

    public void setPadding(r rVar, r rVar2) {
        int a = (int) (rVar.a(0) + rVar2.a(0));
        int a2 = (int) (rVar.a(1) + rVar2.a(1));
        int a3 = (int) (rVar.a(2) + rVar2.a(2));
        int a4 = (int) (rVar.a(3) + rVar2.a(3));
        if (this.mHost != null) {
            this.mHost.setPadding(a, a2, a3, a4);
        }
    }

    private void addEvents() {
        int size = this.mDomObj.c_().size();
        for (int i = 0; i < size; i++) {
            addEvent((String) this.mDomObj.c_().get(i));
        }
        setActiveTouchListener();
    }

    public void updateExtra(Object obj) {
    }

    public o getDomObject() {
        return this.mDomObj;
    }

    public y measure(int i, int i2) {
        y yVar = new y();
        if (this.mFixedPropWidth != 0) {
            yVar.a = this.mFixedPropWidth;
            yVar.b = i2;
        } else if (this.mFixedPropHeight != 0) {
            yVar.a = i;
            yVar.b = this.mFixedPropHeight;
        } else {
            yVar.a = i;
            yVar.b = i2;
        }
        return yVar;
    }

    @Deprecated
    public void updateProperties(Map<String, Object> map) {
        if (map == null) {
            return;
        }
        if (this.mHost != null || isVirtualComponent()) {
            for (Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                Object value = entry.getValue();
                CharSequence a = ah.a(value, null);
                if (TextUtils.isEmpty(a)) {
                    value = convertEmptyProperty(str, a);
                }
                if (!setProperty(str, value)) {
                    if (this.mHolder != null) {
                        com.taobao.weex.bridge.a b = this.mHolder.b(str);
                        if (b != null) {
                            try {
                                Type[] a2 = b.a();
                                if (a2.length != 1) {
                                    WXLogUtils.e("[WXComponent] setX method only one parameter：" + b);
                                    return;
                                }
                                value = w.a(a2[0], value);
                                b.a(this, value);
                            } catch (Throwable e) {
                                WXLogUtils.e("[WXComponent] updateProperties :class:" + getClass() + "method:" + b.toString() + " function " + WXLogUtils.getStackTrace(e));
                            }
                        } else {
                            continue;
                        }
                    } else {
                        return;
                    }
                }
            }
            readyToRender();
        }
    }

    public boolean setProperty(String str, Object obj) {
        boolean z = true;
        switch (str.hashCode()) {
            case -1989576717:
                if (str.equals("borderRightColor")) {
                    z = true;
                    break;
                }
                break;
            case -1974639039:
                if (str.equals("borderRightStyle")) {
                    z = true;
                    break;
                }
                break;
            case -1971292586:
                if (str.equals("borderRightWidth")) {
                    z = true;
                    break;
                }
                break;
            case -1501175880:
                if (str.equals("paddingLeft")) {
                    z = true;
                    break;
                }
                break;
            case -1470826662:
                if (str.equals("borderTopColor")) {
                    z = true;
                    break;
                }
                break;
            case -1455888984:
                if (str.equals("borderTopStyle")) {
                    z = true;
                    break;
                }
                break;
            case -1452542531:
                if (str.equals("borderTopWidth")) {
                    z = true;
                    break;
                }
                break;
            case -1383228885:
                if (str.equals(Style.BOTTOM)) {
                    z = true;
                    break;
                }
                break;
            case -1375815020:
                if (str.equals("minWidth")) {
                    z = true;
                    break;
                }
                break;
            case -1308858324:
                if (str.equals("borderBottomColor")) {
                    z = true;
                    break;
                }
                break;
            case -1293920646:
                if (str.equals("borderBottomStyle")) {
                    z = true;
                    break;
                }
                break;
            case -1290574193:
                if (str.equals("borderBottomWidth")) {
                    z = true;
                    break;
                }
                break;
            case -1267206133:
                if (str.equals("opacity")) {
                    z = true;
                    break;
                }
                break;
            case -1228066334:
                if (str.equals("borderTopLeftRadius")) {
                    z = true;
                    break;
                }
                break;
            case -1221029593:
                if (str.equals(Style.HEIGHT)) {
                    z = true;
                    break;
                }
                break;
            case -1111969773:
                if (str.equals("ariaHidden")) {
                    z = true;
                    break;
                }
                break;
            case -1081309778:
                if (str.equals("margin")) {
                    z = true;
                    break;
                }
                break;
            case -1063257157:
                if (str.equals("alignItems")) {
                    z = true;
                    break;
                }
                break;
            case -1044792121:
                if (str.equals("marginTop")) {
                    z = true;
                    break;
                }
                break;
            case -975171706:
                if (str.equals("flexDirection")) {
                    z = true;
                    break;
                }
                break;
            case -906066005:
                if (str.equals("maxHeight")) {
                    z = true;
                    break;
                }
                break;
            case -863700117:
                if (str.equals("ariaLabel")) {
                    z = true;
                    break;
                }
                break;
            case -806339567:
                if (str.equals("padding")) {
                    z = true;
                    break;
                }
                break;
            case -289173127:
                if (str.equals("marginBottom")) {
                    z = true;
                    break;
                }
                break;
            case -242276144:
                if (str.equals("borderLeftColor")) {
                    z = true;
                    break;
                }
                break;
            case -227338466:
                if (str.equals("borderLeftStyle")) {
                    z = true;
                    break;
                }
                break;
            case -223992013:
                if (str.equals("borderLeftWidth")) {
                    z = true;
                    break;
                }
                break;
            case -133587431:
                if (str.equals("minHeight")) {
                    z = true;
                    break;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    z = true;
                    break;
                }
                break;
            case 115029:
                if (str.equals(Style.TOP)) {
                    z = true;
                    break;
                }
                break;
            case 3145721:
                if (str.equals("flex")) {
                    z = true;
                    break;
                }
                break;
            case 3317767:
                if (str.equals(Style.LEFT)) {
                    z = true;
                    break;
                }
                break;
            case 90130308:
                if (str.equals("paddingTop")) {
                    z = true;
                    break;
                }
                break;
            case 108511772:
                if (str.equals(Style.RIGHT)) {
                    z = true;
                    break;
                }
                break;
            case 113126854:
                if (str.equals(Style.WIDTH)) {
                    z = true;
                    break;
                }
                break;
            case 202355100:
                if (str.equals("paddingBottom")) {
                    z = true;
                    break;
                }
                break;
            case 270940796:
                if (str.equals("disabled")) {
                    z = true;
                    break;
                }
                break;
            case 333432965:
                if (str.equals("borderTopRightRadius")) {
                    z = true;
                    break;
                }
                break;
            case 400381634:
                if (str.equals("maxWidth")) {
                    z = true;
                    break;
                }
                break;
            case 581268560:
                if (str.equals("borderBottomLeftRadius")) {
                    z = true;
                    break;
                }
                break;
            case 588239831:
                if (str.equals("borderBottomRightRadius")) {
                    z = true;
                    break;
                }
                break;
            case 713848971:
                if (str.equals("paddingRight")) {
                    z = true;
                    break;
                }
                break;
            case 717381201:
                if (str.equals("preventMoveEvent")) {
                    z = false;
                    break;
                }
                break;
            case 722830999:
                if (str.equals("borderColor")) {
                    z = true;
                    break;
                }
                break;
            case 737768677:
                if (str.equals("borderStyle")) {
                    z = true;
                    break;
                }
                break;
            case 741115130:
                if (str.equals("borderWidth")) {
                    z = true;
                    break;
                }
                break;
            case 747463061:
                if (str.equals(PROP_FIXED_SIZE)) {
                    z = true;
                    break;
                }
                break;
            case 747804969:
                if (str.equals("position")) {
                    z = true;
                    break;
                }
                break;
            case 975087886:
                if (str.equals("marginRight")) {
                    z = true;
                    break;
                }
                break;
            case 1287124693:
                if (str.equals(Style.BACKGROUND_COLOR)) {
                    z = true;
                    break;
                }
                break;
            case 1292595405:
                if (str.equals("backgroundImage")) {
                    z = true;
                    break;
                }
                break;
            case 1349188574:
                if (str.equals("borderRadius")) {
                    z = true;
                    break;
                }
                break;
            case 1744216035:
                if (str.equals("flexWrap")) {
                    z = true;
                    break;
                }
                break;
            case 1767100401:
                if (str.equals("alignSelf")) {
                    z = true;
                    break;
                }
                break;
            case 1860657097:
                if (str.equals("justifyContent")) {
                    z = true;
                    break;
                }
                break;
            case 1941332754:
                if (str.equals("visibility")) {
                    z = true;
                    break;
                }
                break;
            case 1970934485:
                if (str.equals("marginLeft")) {
                    z = true;
                    break;
                }
                break;
        }
        String a;
        Float a2;
        switch (z) {
            case false:
                if (this.mGesture == null) {
                    return true;
                }
                this.mGesture.a = ah.a(obj, Boolean.valueOf(false)).booleanValue();
                return true;
            case true:
                Boolean a3 = ah.a(obj, null);
                if (a3 == null) {
                    return true;
                }
                setDisabled(a3.booleanValue());
                setPseudoClassStatus(":disabled", a3.booleanValue());
                return true;
            case true:
                a = ah.a(obj, null);
                if (a == null) {
                    return true;
                }
                setSticky(a);
                return true;
            case true:
                a = ah.a(obj, null);
                if (a == null) {
                    return true;
                }
                setBackgroundColor(a);
                return true;
            case true:
                a = ah.a(obj, null);
                if (a == null || this.mHost == null) {
                    return true;
                }
                setBackgroundImage(a);
                return true;
            case true:
                a2 = ah.a(obj, null);
                if (a2 == null) {
                    return true;
                }
                setOpacity(a2.floatValue());
                return true;
            case true:
            case true:
            case true:
            case true:
            case true:
                a2 = ah.a(obj, null);
                if (a2 == null) {
                    return true;
                }
                setBorderRadius(str, a2.floatValue());
                return true;
            case true:
            case true:
            case true:
            case true:
            case true:
                a2 = ah.a(obj, null);
                if (a2 == null) {
                    return true;
                }
                setBorderWidth(str, a2.floatValue());
                return true;
            case true:
            case true:
            case true:
            case true:
            case true:
                a = ah.a(obj, null);
                if (a == null) {
                    return true;
                }
                setBorderStyle(str, a);
                return true;
            case true:
            case true:
            case true:
            case true:
            case true:
                a = ah.a(obj, null);
                if (a == null) {
                    return true;
                }
                setBorderColor(str, a);
                return true;
            case true:
                a = ah.a(obj, null);
                if (a == null) {
                    return true;
                }
                setVisibility(a);
                return true;
            case true:
                if (obj == null) {
                    return true;
                }
                updateElevation();
                return true;
            case true:
                setFixedSize(ah.a(obj, PROP_FS_MATCH_PARENT));
                return true;
            case true:
                setAriaLabel(ah.a(obj, ""));
                return true;
            case true:
                setAriaHidden(ah.a(obj, Boolean.valueOf(false)).booleanValue());
                return true;
            case true:
            case true:
            case true:
            case true:
            case true:
            case true:
            case true:
            case true:
            case true:
            case true:
            case true:
            case true:
            case true:
            case true:
            case true:
            case true:
            case true:
            case true:
            case true:
            case true:
            case true:
            case true:
            case true:
            case true:
            case true:
            case true:
                return true;
            default:
                return false;
        }
    }

    @TargetApi(16)
    protected void setAriaHidden(boolean z) {
        View hostView = getHostView();
        if (hostView != null && VERSION.SDK_INT >= 16) {
            hostView.setImportantForAccessibility(z ? 2 : 1);
        }
    }

    protected void setAriaLabel(String str) {
        View hostView = getHostView();
        if (hostView != null) {
            hostView.setContentDescription(str);
        }
    }

    private void setFixedSize(String str) {
        if (PROP_FS_MATCH_PARENT.equals(str)) {
            this.mFixedPropWidth = -1;
            this.mFixedPropHeight = -1;
        } else if (PROP_FS_WRAP_CONTENT.equals(str)) {
            this.mFixedPropWidth = -2;
            this.mFixedPropHeight = -2;
        } else if (PROP_FS_MATCH_PARENT_WIDTH.equals(str)) {
            this.mFixedPropWidth = -1;
        } else if (PROP_FS_MATCH_PARENT_HEIGHT.equals(str)) {
            this.mFixedPropHeight = -1;
        } else {
            this.mFixedPropWidth = 0;
            this.mFixedPropHeight = 0;
            return;
        }
        if (this.mHost != null) {
            LayoutParams layoutParams = this.mHost.getLayoutParams();
            if (layoutParams != null) {
                if (this.mFixedPropHeight != 0) {
                    layoutParams.height = this.mFixedPropHeight;
                }
                if (this.mFixedPropWidth != 0) {
                    layoutParams.width = this.mFixedPropWidth;
                }
                this.mHost.setLayoutParams(layoutParams);
            }
        }
    }

    protected void appendEventToDOM(String str) {
        ad.a().a.a(getInstanceId(), new e(getRef(), str), false);
    }

    public void addEvent(String str) {
        if (!TextUtils.isEmpty(str) && !this.mAppendEvents.contains(str)) {
            this.mAppendEvents.add(str);
            View realView = getRealView();
            if (str.equals("click") && realView != null) {
                addClickListener(this.mClickEventListener);
            } else if (str.equals("focus") || str.equals("blur")) {
                addFocusChangeListener(new x(this));
            } else if (realView == null || !needGestureDetector(str)) {
                p parentScroller = getParentScroller();
                if ((str.equals("appear") || str.equals("customAppear")) && parentScroller != null) {
                    parentScroller.c(this);
                }
                if ((str.equals("disappear") || str.equals("customDisappear")) && parentScroller != null) {
                    parentScroller.d(this);
                }
            } else if (realView instanceof c) {
                if (this.mGesture == null) {
                    this.mGesture = new com.taobao.weex.ui.view.a.b(this, this.mContext);
                    this.mGesture.a = ah.a(getDomObject().i().get("preventMoveEvent"), Boolean.valueOf(false)).booleanValue();
                }
                this.mGestureType.add(str);
                ((c) realView).a(this.mGesture);
            } else {
                WXLogUtils.e(realView.getClass().getSimpleName() + " don't implement WXGestureObservable, so no gesture is supported.");
            }
        }
    }

    public View getRealView() {
        return this.mHost;
    }

    private boolean needGestureDetector(String str) {
        if (this.mHost != null) {
            for (Object obj : com.taobao.weex.ui.view.a.e.values()) {
                if (str.equals(obj.toString())) {
                    return true;
                }
            }
            for (Object obj2 : com.taobao.weex.ui.view.a.d.values()) {
                if (str.equals(obj2.toString())) {
                    return true;
                }
            }
        }
        return false;
    }

    public p getParentScroller() {
        while (true) {
            ab parent = getParent();
            if (parent == null) {
                return null;
            }
            if (parent instanceof p) {
                return (p) parent;
            }
            if (parent.getRef().equals("_root")) {
                return null;
            }
            this = parent;
        }
    }

    @Nullable
    public p getFirstScroller() {
        if (this instanceof p) {
            return (p) this;
        }
        return null;
    }

    public bv getParent() {
        return this.mParent;
    }

    public String getRef() {
        if (this.mDomObj == null) {
            return null;
        }
        return this.mCurrentRef;
    }

    public final void createView() {
        if (!isLazy()) {
            createViewImpl();
        }
    }

    protected void createViewImpl() {
        if (this.mContext != null) {
            this.mHost = initComponentHostView(this.mContext);
            if (this.mHost == null && !isVirtualComponent()) {
                initView();
            }
            if (this.mHost != null) {
                this.mHost.setId(WXViewUtils.a());
            }
            onHostViewInitialized(this.mHost);
            return;
        }
        WXLogUtils.e("createViewImpl", "Context is null");
    }

    @Deprecated
    protected void initView() {
        if (this.mContext != null) {
            this.mHost = initComponentHostView(this.mContext);
        }
    }

    public T initComponentHostView(@NonNull Context context) {
        return null;
    }

    @CallSuper
    protected void onHostViewInitialized(T t) {
        if (this.mAnimationHolder != null) {
            d dVar = this.mAnimationHolder;
            ac acVar = this.mInstance;
            ad.a().c.a(acVar.e, new com.taobao.weex.c.a.i(getRef(), dVar.a, dVar.b));
        }
        setActiveTouchListener();
    }

    public T getHostView() {
        return this.mHost;
    }

    @Deprecated
    public View getView() {
        return this.mHost;
    }

    public int getAbsoluteY() {
        return this.mAbsoluteY;
    }

    public int getAbsoluteX() {
        return this.mAbsoluteX;
    }

    public void updateDom(ae aeVar) {
        if (aeVar != null) {
            this.mDomObj = aeVar.v();
        }
    }

    public final void removeEvent(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mAppendEvents.remove(str);
            this.mGestureType.remove(str);
            removeEventFromView(str);
        }
    }

    protected void removeEventFromView(String str) {
        if (!(!str.equals("click") || getRealView() == null || this.mHostClickListeners == null)) {
            this.mHostClickListeners.remove(this.mClickEventListener);
        }
        p parentScroller = getParentScroller();
        if (str.equals("appear") && parentScroller != null) {
            parentScroller.e(this);
        }
        if (str.equals("disappear") && parentScroller != null) {
            parentScroller.f(this);
        }
    }

    public final void removeAllEvent() {
        if (this.mDomObj != null && this.mDomObj.c_().size() > 0) {
            Iterator it = this.mDomObj.c_().iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (str != null) {
                    removeEventFromView(str);
                }
            }
            this.mAppendEvents.clear();
            this.mGestureType.clear();
            this.mGesture = null;
            if (getRealView() != null && (getRealView() instanceof c)) {
                ((c) getRealView()).a(null);
            }
            if (this.mHost != null) {
                this.mHost.setOnFocusChangeListener(null);
                if (this.mHostClickListeners != null && this.mHostClickListeners.size() > 0) {
                    this.mHostClickListeners.clear();
                    this.mHost.setOnClickListener(null);
                }
            }
        }
    }

    public final void removeStickyStyle() {
        if (this.mDomObj != null && isSticky()) {
            p parentScroller = getParentScroller();
            if (parentScroller != null) {
                parentScroller.b(this);
            }
        }
    }

    public boolean isSticky() {
        Object obj = this.mDomObj.g().get("position");
        if (obj == null) {
            return false;
        }
        return obj.toString().equals("sticky");
    }

    public boolean isFixed() {
        return this.mDomObj.g().b();
    }

    public void setDisabled(boolean z) {
        this.mIsDisabled = z;
        if (this.mHost != null) {
            this.mHost.setEnabled(!z);
        }
    }

    public boolean isDisabled() {
        return this.mIsDisabled;
    }

    public void setSticky(String str) {
        if (!TextUtils.isEmpty(str) && str.equals("sticky")) {
            p parentScroller = getParentScroller();
            if (parentScroller != null) {
                parentScroller.a(this);
            }
        }
    }

    public void setBackgroundColor(String str) {
        if (!TextUtils.isEmpty(str) && this.mHost != null) {
            int a = af.a(str);
            if (a != 0 || this.mBackgroundDrawable != null) {
                getOrCreateBorder().a(a);
            }
        }
    }

    public void setBackgroundImage(@NonNull String str) {
        if ("".equals(str.trim())) {
            getOrCreateBorder().a(null);
            return;
        }
        getOrCreateBorder().a(af.a(str, this.mDomObj.o(), this.mDomObj.p()));
    }

    public void setOpacity(float f) {
        if (f >= 0.0f && f <= IPictureView.DEFAULT_MIN_SCALE && this.mHost.getAlpha() != f) {
            if (isLayerTypeEnabled()) {
                this.mHost.setLayerType(2, null);
            }
            this.mHost.setAlpha(f);
        }
    }

    public void setBorderRadius(String str, float f) {
        if (f >= 0.0f) {
            int i = -1;
            switch (str.hashCode()) {
                case -1228066334:
                    if (str.equals("borderTopLeftRadius")) {
                        i = 1;
                        break;
                    }
                    break;
                case 333432965:
                    if (str.equals("borderTopRightRadius")) {
                        i = 2;
                        break;
                    }
                    break;
                case 581268560:
                    if (str.equals("borderBottomLeftRadius")) {
                        i = 4;
                        break;
                    }
                    break;
                case 588239831:
                    if (str.equals("borderBottomRightRadius")) {
                        i = 3;
                        break;
                    }
                    break;
                case 1349188574:
                    if (str.equals("borderRadius")) {
                        i = 0;
                        break;
                    }
                    break;
            }
            switch (i) {
                case 0:
                    getOrCreateBorder().b(8, WXViewUtils.b(f, this.mInstance.o));
                    return;
                case 1:
                    getOrCreateBorder().b(0, WXViewUtils.b(f, this.mInstance.o));
                    return;
                case 2:
                    getOrCreateBorder().b(1, WXViewUtils.b(f, this.mInstance.o));
                    return;
                case 3:
                    getOrCreateBorder().b(2, WXViewUtils.b(f, this.mInstance.o));
                    return;
                case 4:
                    getOrCreateBorder().b(3, WXViewUtils.b(f, this.mInstance.o));
                    return;
                default:
                    return;
            }
        }
    }

    public void setBorderWidth(String str, float f) {
        if (f >= 0.0f) {
            int i = -1;
            switch (str.hashCode()) {
                case -1971292586:
                    if (str.equals("borderRightWidth")) {
                        i = 2;
                        break;
                    }
                    break;
                case -1452542531:
                    if (str.equals("borderTopWidth")) {
                        i = 1;
                        break;
                    }
                    break;
                case -1290574193:
                    if (str.equals("borderBottomWidth")) {
                        i = 3;
                        break;
                    }
                    break;
                case -223992013:
                    if (str.equals("borderLeftWidth")) {
                        i = 4;
                        break;
                    }
                    break;
                case 741115130:
                    if (str.equals("borderWidth")) {
                        i = 0;
                        break;
                    }
                    break;
            }
            switch (i) {
                case 0:
                    getOrCreateBorder().a(8, WXViewUtils.b(f, getInstance().o));
                    return;
                case 1:
                    getOrCreateBorder().a(1, WXViewUtils.b(f, getInstance().o));
                    return;
                case 2:
                    getOrCreateBorder().a(2, WXViewUtils.b(f, getInstance().o));
                    return;
                case 3:
                    getOrCreateBorder().a(3, WXViewUtils.b(f, getInstance().o));
                    return;
                case 4:
                    getOrCreateBorder().a(0, WXViewUtils.b(f, getInstance().o));
                    return;
                default:
                    return;
            }
        }
    }

    public void setBorderStyle(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            int i = -1;
            switch (str.hashCode()) {
                case -1974639039:
                    if (str.equals("borderRightStyle")) {
                        i = 1;
                        break;
                    }
                    break;
                case -1455888984:
                    if (str.equals("borderTopStyle")) {
                        i = 4;
                        break;
                    }
                    break;
                case -1293920646:
                    if (str.equals("borderBottomStyle")) {
                        i = 2;
                        break;
                    }
                    break;
                case -227338466:
                    if (str.equals("borderLeftStyle")) {
                        i = 3;
                        break;
                    }
                    break;
                case 737768677:
                    if (str.equals("borderStyle")) {
                        i = 0;
                        break;
                    }
                    break;
            }
            switch (i) {
                case 0:
                    getOrCreateBorder().a(8, str2);
                    return;
                case 1:
                    getOrCreateBorder().a(2, str2);
                    return;
                case 2:
                    getOrCreateBorder().a(3, str2);
                    return;
                case 3:
                    getOrCreateBorder().a(0, str2);
                    return;
                case 4:
                    getOrCreateBorder().a(1, str2);
                    return;
                default:
                    return;
            }
        }
    }

    public void setBorderColor(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            int a = af.a(str2);
            if (a != SectionHeader.SHT_LOUSER) {
                int i = -1;
                switch (str.hashCode()) {
                    case -1989576717:
                        if (str.equals("borderRightColor")) {
                            i = 2;
                            break;
                        }
                        break;
                    case -1470826662:
                        if (str.equals("borderTopColor")) {
                            i = 1;
                            break;
                        }
                        break;
                    case -1308858324:
                        if (str.equals("borderBottomColor")) {
                            i = 3;
                            break;
                        }
                        break;
                    case -242276144:
                        if (str.equals("borderLeftColor")) {
                            i = 4;
                            break;
                        }
                        break;
                    case 722830999:
                        if (str.equals("borderColor")) {
                            i = 0;
                            break;
                        }
                        break;
                }
                switch (i) {
                    case 0:
                        getOrCreateBorder().a(8, a);
                        return;
                    case 1:
                        getOrCreateBorder().a(1, a);
                        return;
                    case 2:
                        getOrCreateBorder().a(2, a);
                        return;
                    case 3:
                        getOrCreateBorder().a(3, a);
                        return;
                    case 4:
                        getOrCreateBorder().a(0, a);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    @Nullable
    public String getVisibility() {
        try {
            return (String) getDomObject().g().get("visibility");
        } catch (Exception e) {
            return "visible";
        }
    }

    public void setVisibility(String str) {
        View realView = getRealView();
        if (realView == null) {
            return;
        }
        if (TextUtils.equals(str, "visible")) {
            realView.setVisibility(0);
        } else if (TextUtils.equals(str, "hidden")) {
            realView.setVisibility(8);
        }
    }

    private void updateElevation() {
        v i = getDomObject().i();
        int i2 = getInstance().o;
        Object obj = i.get("elevation");
        float f = Float.NaN;
        if (obj != null) {
            Object obj2 = obj.toString();
            if (TextUtils.isEmpty(obj2)) {
                f = 0.0f;
            } else {
                f = WXViewUtils.b(ah.a(obj2), i2);
            }
        }
        if (!Float.isNaN(f)) {
            ViewCompat.d(getHostView(), f);
        }
    }

    @Deprecated
    public void registerActivityStateListener() {
    }

    public void onActivityCreate() {
    }

    public void onActivityStart() {
    }

    public void onActivityPause() {
    }

    public void onActivityResume() {
    }

    public void onActivityStop() {
    }

    public void onActivityDestroy() {
    }

    public boolean onActivityBack() {
        return false;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
    }

    public void recycled() {
        if (!this.mDomObj.f()) {
        }
    }

    public void destroy() {
        if (!i.c() || ah.a()) {
            if (this.mHost != null && this.mHost.getLayerType() == 2 && isLayerTypeEnabled()) {
                this.mHost.setLayerType(0, null);
            }
            removeAllEvent();
            removeStickyStyle();
            if (this.mDomObj.f()) {
                View hostView = getHostView();
                if (hostView != null) {
                    getInstance().a(hostView);
                }
            }
            this.mDomObj = o.a;
            this.mIsDestroyed = true;
            return;
        }
        throw new t("[WXComponent] destroy can only be called in main thread");
    }

    public boolean isDestoryed() {
        return this.mIsDestroyed;
    }

    public View detachViewAndClearPreInfo() {
        View view = this.mHost;
        this.mPreRealLeft = 0;
        this.mPreRealWidth = 0;
        this.mPreRealHeight = 0;
        this.mPreRealTop = 0;
        return view;
    }

    public void computeVisiblePointInViewCoordinate(PointF pointF) {
        View realView = getRealView();
        pointF.set((float) realView.getScrollX(), (float) realView.getScrollY());
    }

    public boolean containsGesture(f fVar) {
        return this.mGestureType != null && this.mGestureType.contains(fVar.toString());
    }

    public boolean containsEvent(String str) {
        return this.mDomObj.c_().contains(str) || this.mAppendEvents.contains(str);
    }

    public void notifyAppearStateChange(String str, String str2) {
        if (containsEvent("appear") || containsEvent("disappear")) {
            Map hashMap = new HashMap();
            hashMap.put("direction", str2);
            fireEvent(str, hashMap);
        }
    }

    public void notifyCustomAppearStateChange(String str, String str2) {
        if (containsEvent("customAppear") || containsEvent("customDisappear")) {
            Map hashMap = new HashMap();
            hashMap.put("direction", str2);
            fireEvent(str, hashMap);
        }
    }

    public boolean isUsing() {
        return this.isUsing;
    }

    public void setUsing(boolean z) {
        this.isUsing = z;
    }

    public void readyToRender() {
        if (this.mParent != null && getInstance().l) {
            this.mParent.readyToRender();
        }
    }

    public boolean isVirtualComponent() {
        return this.mType == 1;
    }

    public void removeVirtualComponent() {
    }

    public void setType(int i) {
        this.mType = i;
    }

    public boolean hasScrollParent(ab abVar) {
        if (abVar.getParent() == null) {
            return true;
        }
        if (abVar.getParent() instanceof be) {
            return false;
        }
        return hasScrollParent(abVar.getParent());
    }

    @CheckResult
    protected Object convertEmptyProperty(String str, Object obj) {
        int i = -1;
        switch (str.hashCode()) {
            case -1989576717:
                if (str.equals("borderRightColor")) {
                    i = 14;
                    break;
                }
                break;
            case -1971292586:
                if (str.equals("borderRightWidth")) {
                    i = 9;
                    break;
                }
                break;
            case -1470826662:
                if (str.equals("borderTopColor")) {
                    i = 12;
                    break;
                }
                break;
            case -1452542531:
                if (str.equals("borderTopWidth")) {
                    i = 7;
                    break;
                }
                break;
            case -1308858324:
                if (str.equals("borderBottomColor")) {
                    i = 15;
                    break;
                }
                break;
            case -1290574193:
                if (str.equals("borderBottomWidth")) {
                    i = 10;
                    break;
                }
                break;
            case -1228066334:
                if (str.equals("borderTopLeftRadius")) {
                    i = 4;
                    break;
                }
                break;
            case -242276144:
                if (str.equals("borderLeftColor")) {
                    i = 13;
                    break;
                }
                break;
            case -223992013:
                if (str.equals("borderLeftWidth")) {
                    i = 8;
                    break;
                }
                break;
            case 333432965:
                if (str.equals("borderTopRightRadius")) {
                    i = 5;
                    break;
                }
                break;
            case 581268560:
                if (str.equals("borderBottomLeftRadius")) {
                    i = 2;
                    break;
                }
                break;
            case 588239831:
                if (str.equals("borderBottomRightRadius")) {
                    i = 3;
                    break;
                }
                break;
            case 722830999:
                if (str.equals("borderColor")) {
                    i = 11;
                    break;
                }
                break;
            case 741115130:
                if (str.equals("borderWidth")) {
                    i = 6;
                    break;
                }
                break;
            case 1287124693:
                if (str.equals(Style.BACKGROUND_COLOR)) {
                    i = 0;
                    break;
                }
                break;
            case 1349188574:
                if (str.equals("borderRadius")) {
                    i = 1;
                    break;
                }
                break;
        }
        switch (i) {
            case 0:
                return "transparent";
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                return Integer.valueOf(0);
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                return Integer.valueOf(0);
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return "black";
            default:
                return obj;
        }
    }

    private void setActiveTouchListener() {
        if (this.mDomObj.g().a.containsKey(":active")) {
            View realView = getRealView();
            if (realView != null) {
                realView.setOnTouchListener(new com.taobao.weex.ui.component.c.c(this, !isConsumeTouch()));
            }
        }
    }

    protected boolean isConsumeTouch() {
        return (this.mHostClickListeners != null && this.mHostClickListeners.size() > 0) || this.mGesture != null;
    }

    public void updateActivePseudo(boolean z) {
        setPseudoClassStatus(":active", z);
    }

    protected void setPseudoClassStatus(String str, boolean z) {
        ao g = getDomObject().g();
        Map map = g.a;
        if (map != null && map.size() != 0) {
            com.taobao.weex.ui.component.c.b bVar = this.mPesudoStatus;
            Map map2 = g.b;
            String a = bVar.a();
            int i = -1;
            switch (str.hashCode()) {
                case -1487344704:
                    if (str.equals(":active")) {
                        i = 0;
                        break;
                    }
                    break;
                case -1482202954:
                    if (str.equals(":disabled")) {
                        i = 1;
                        break;
                    }
                    break;
                case 689157575:
                    if (str.equals(":enabled")) {
                        i = 2;
                        break;
                    }
                    break;
                case 1758095582:
                    if (str.equals(":focus")) {
                        i = 3;
                        break;
                    }
                    break;
            }
            switch (i) {
                case 0:
                    bVar.a(0, z);
                    break;
                case 1:
                    bVar.a(3, z);
                    break;
                case 2:
                    bVar.a(2, z);
                    break;
                case 3:
                    bVar.a(1, z);
                    break;
            }
            Map map3 = (Map) map.get(bVar.a());
            Map map4 = (Map) map.get(a);
            Map bVar2 = new android.mini.support.v4.d.b();
            if (map4 != null) {
                bVar2.putAll(map4);
            }
            for (String str2 : bVar2.keySet()) {
                Object obj;
                if (map2.containsKey(str2)) {
                    obj = map2.get(str2);
                } else {
                    obj = "";
                }
                bVar2.put(str2, obj);
            }
            if (map3 != null) {
                for (Entry entry : map3.entrySet()) {
                    bVar2.put(entry.getKey(), entry.getValue());
                }
            }
            updateStyleByPesudo(bVar2);
        }
    }

    private void updateStyleByPesudo(Map<String, Object> map) {
        Message obtain = Message.obtain();
        com.taobao.weex.c.ah ahVar = new com.taobao.weex.c.ah();
        ahVar.a = getInstanceId();
        ahVar.b = new ArrayList();
        com.alibaba.fastjson.e eVar = new com.alibaba.fastjson.e((Map) map);
        ahVar.b.add(getRef());
        ahVar.b.add(eVar);
        ahVar.b.add(Boolean.valueOf(true));
        obtain.obj = ahVar;
        obtain.what = 2;
        ad.a().a.a(obtain, 0);
    }

    public int getStickyOffset() {
        return this.mStickyOffset;
    }

    public boolean canRecycled() {
        return !(isFixed() && isSticky()) && this.mDomObj.i().c();
    }

    public void setStickyOffset(int i) {
        this.mStickyOffset = i;
    }

    public boolean isLayerTypeEnabled() {
        return getInstance().m;
    }

    public void setNeedLayoutOnAnimation(boolean z) {
        this.mNeedLayoutOnAnimation = z;
    }

    public void notifyNativeSizeChanged(int i, int i2) {
        if (this.mNeedLayoutOnAnimation) {
            Message obtain = Message.obtain();
            com.taobao.weex.c.ah ahVar = new com.taobao.weex.c.ah();
            ahVar.a = getInstanceId();
            if (ahVar.b == null) {
                ahVar.b = new ArrayList();
            }
            com.alibaba.fastjson.e eVar = new com.alibaba.fastjson.e(2);
            float c = WXViewUtils.c((float) i);
            float c2 = WXViewUtils.c((float) i2);
            eVar.a(Style.WIDTH, Float.valueOf(c));
            eVar.a(Style.HEIGHT, Float.valueOf(c2));
            ahVar.b.add(getRef());
            ahVar.b.add(eVar);
            obtain.obj = ahVar;
            obtain.what = 2;
            ad.a().a.a(obtain, 0);
        }
    }

    public void cleanGestureType() {
        this.mGestureType.clear();
    }

    @WXComponentProp(name = "customAppearProportion")
    public void setCustomAppearProportion(float f) {
        this.mCustomAppearProportion = f;
    }

    public float getCustomAppearProportion() {
        return this.mCustomAppearProportion;
    }
}
