package android.mini.support.v4.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.mini.support.v4.d.d;
import android.mini.support.v4.d.e;
import android.mini.support.v4.view.ViewCompat;
import android.mini.support.v4.view.ac;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import com.uc.imagecodec.export.IPictureView;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: ProGuard */
final class ab extends u implements ac {
    static final Interpolator A = new DecelerateInterpolator(2.5f);
    static final Interpolator B = new DecelerateInterpolator(1.5f);
    static final Interpolator C = new AccelerateInterpolator(2.5f);
    static final Interpolator D = new AccelerateInterpolator(1.5f);
    static boolean a = false;
    static final boolean b;
    static Field r = null;
    ArrayList<Runnable> c;
    Runnable[] d;
    boolean e;
    ArrayList<Fragment> f;
    ArrayList<Fragment> g;
    ArrayList<Integer> h;
    ArrayList<f> i;
    ArrayList<Fragment> j;
    ArrayList<f> k;
    ArrayList<Integer> l;
    ArrayList<Object> m;
    int n = 0;
    t o;
    r p;
    Fragment q;
    boolean s;
    boolean t;
    boolean u;
    String v;
    boolean w;
    Bundle x = null;
    SparseArray<Parcelable> y = null;
    Runnable z = new v(this);

    ab() {
    }

    static {
        boolean z = false;
        if (VERSION.SDK_INT >= 11) {
            z = true;
        }
        b = z;
    }

    private void a(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new e("FragmentManager"));
        if (this.o != null) {
            try {
                this.o.a("  ", printWriter, new String[0]);
            } catch (Throwable e) {
                Log.e("FragmentManager", "Failed dumping state", e);
            }
        } else {
            try {
                a("  ", null, printWriter, new String[0]);
            } catch (Throwable e2) {
                Log.e("FragmentManager", "Failed dumping state", e2);
            }
        }
        throw runtimeException;
    }

    public final FragmentTransaction a() {
        return new f(this);
    }

    public final boolean b() {
        o();
        c();
        return a(-1, 0);
    }

    public final void a(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Bad id: " + i);
        }
        a(new w(this, i), false);
    }

    private Fragment a(Bundle bundle, String str) {
        int i = bundle.getInt(str, -1);
        if (i == -1) {
            return null;
        }
        if (i >= this.f.size()) {
            a(new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i));
        }
        Fragment fragment = (Fragment) this.f.get(i);
        if (fragment != null) {
            return fragment;
        }
        a(new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i));
        return fragment;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("FragmentManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        if (this.q != null) {
            d.a(this.q, stringBuilder);
        } else {
            d.a(this.o, stringBuilder);
        }
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }

    public final void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int i;
        Fragment fragment;
        int i2 = 0;
        String str2 = str + "    ";
        if (this.f != null) {
            size = this.f.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.print("Active Fragments in ");
                printWriter.print(Integer.toHexString(System.identityHashCode(this)));
                printWriter.println(":");
                for (i = 0; i < size; i++) {
                    fragment = (Fragment) this.f.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(fragment);
                    if (fragment != null) {
                        printWriter.print(str2);
                        printWriter.print("mFragmentId=#");
                        printWriter.print(Integer.toHexString(fragment.G));
                        printWriter.print(" mContainerId=#");
                        printWriter.print(Integer.toHexString(fragment.H));
                        printWriter.print(" mTag=");
                        printWriter.println(fragment.I);
                        printWriter.print(str2);
                        printWriter.print("mState=");
                        printWriter.print(fragment.k);
                        printWriter.print(" mIndex=");
                        printWriter.print(fragment.p);
                        printWriter.print(" mWho=");
                        printWriter.print(fragment.q);
                        printWriter.print(" mBackStackNesting=");
                        printWriter.println(fragment.A);
                        printWriter.print(str2);
                        printWriter.print("mAdded=");
                        printWriter.print(fragment.v);
                        printWriter.print(" mRemoving=");
                        printWriter.print(fragment.w);
                        printWriter.print(" mFromLayout=");
                        printWriter.print(fragment.x);
                        printWriter.print(" mInLayout=");
                        printWriter.println(fragment.y);
                        printWriter.print(str2);
                        printWriter.print("mHidden=");
                        printWriter.print(fragment.J);
                        printWriter.print(" mDetached=");
                        printWriter.print(fragment.K);
                        printWriter.print(" mMenuVisible=");
                        printWriter.print(fragment.O);
                        printWriter.print(" mHasMenu=");
                        printWriter.println(fragment.N);
                        printWriter.print(str2);
                        printWriter.print("mRetainInstance=");
                        printWriter.print(fragment.L);
                        printWriter.print(" mRetaining=");
                        printWriter.print(fragment.M);
                        printWriter.print(" mUserVisibleHint=");
                        printWriter.println(fragment.V);
                        if (fragment.B != null) {
                            printWriter.print(str2);
                            printWriter.print("mFragmentManager=");
                            printWriter.println(fragment.B);
                        }
                        if (fragment.C != null) {
                            printWriter.print(str2);
                            printWriter.print("mHost=");
                            printWriter.println(fragment.C);
                        }
                        if (fragment.F != null) {
                            printWriter.print(str2);
                            printWriter.print("mParentFragment=");
                            printWriter.println(fragment.F);
                        }
                        if (fragment.r != null) {
                            printWriter.print(str2);
                            printWriter.print("mArguments=");
                            printWriter.println(fragment.r);
                        }
                        if (fragment.n != null) {
                            printWriter.print(str2);
                            printWriter.print("mSavedFragmentState=");
                            printWriter.println(fragment.n);
                        }
                        if (fragment.o != null) {
                            printWriter.print(str2);
                            printWriter.print("mSavedViewState=");
                            printWriter.println(fragment.o);
                        }
                        if (fragment.s != null) {
                            printWriter.print(str2);
                            printWriter.print("mTarget=");
                            printWriter.print(fragment.s);
                            printWriter.print(" mTargetRequestCode=");
                            printWriter.println(fragment.u);
                        }
                        if (fragment.Q != 0) {
                            printWriter.print(str2);
                            printWriter.print("mNextAnim=");
                            printWriter.println(fragment.Q);
                        }
                        if (fragment.R != null) {
                            printWriter.print(str2);
                            printWriter.print("mContainer=");
                            printWriter.println(fragment.R);
                        }
                        if (fragment.S != null) {
                            printWriter.print(str2);
                            printWriter.print("mView=");
                            printWriter.println(fragment.S);
                        }
                        if (fragment.T != null) {
                            printWriter.print(str2);
                            printWriter.print("mInnerView=");
                            printWriter.println(fragment.S);
                        }
                        if (fragment.l != null) {
                            printWriter.print(str2);
                            printWriter.print("mAnimatingAway=");
                            printWriter.println(fragment.l);
                            printWriter.print(str2);
                            printWriter.print("mStateAfterAnimating=");
                            printWriter.println(fragment.m);
                        }
                        if (fragment.W != null) {
                            printWriter.print(str2);
                            printWriter.println("Loader Manager:");
                            fragment.W.a(str2 + "  ", fileDescriptor, printWriter);
                        }
                        if (fragment.D != null) {
                            printWriter.print(str2);
                            printWriter.println("Child " + fragment.D + ":");
                            fragment.D.a(str2 + "  ", fileDescriptor, printWriter, strArr);
                        }
                    }
                }
            }
        }
        if (this.g != null) {
            size = this.g.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Added Fragments:");
                for (i = 0; i < size; i++) {
                    fragment = (Fragment) this.g.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(fragment.toString());
                }
            }
        }
        if (this.j != null) {
            size = this.j.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Fragments Created Menus:");
                for (i = 0; i < size; i++) {
                    fragment = (Fragment) this.j.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(fragment.toString());
                }
            }
        }
        if (this.i != null) {
            size = this.i.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack:");
                for (i = 0; i < size; i++) {
                    f fVar = (f) this.i.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(fVar.toString());
                    fVar.a(str2, printWriter);
                }
            }
        }
        synchronized (this) {
            if (this.k != null) {
                int size2 = this.k.size();
                if (size2 > 0) {
                    printWriter.print(str);
                    printWriter.println("Back Stack Indices:");
                    for (i = 0; i < size2; i++) {
                        fVar = (f) this.k.get(i);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i);
                        printWriter.print(": ");
                        printWriter.println(fVar);
                    }
                }
            }
            if (this.l != null && this.l.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.l.toArray()));
            }
        }
        if (this.c != null) {
            i = this.c.size();
            if (i > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                while (i2 < i) {
                    Runnable runnable = (Runnable) this.c.get(i2);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i2);
                    printWriter.print(": ");
                    printWriter.println(runnable);
                    i2++;
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.o);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.p);
        if (this.q != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.q);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.n);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.t);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.u);
        if (this.s) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.s);
        }
        if (this.v != null) {
            printWriter.print(str);
            printWriter.print("  mNoTransactionsBecause=");
            printWriter.println(this.v);
        }
        if (this.h != null && this.h.size() > 0) {
            printWriter.print(str);
            printWriter.print("  mAvailIndices: ");
            printWriter.println(Arrays.toString(this.h.toArray()));
        }
    }

    private static Animation a(float f, float f2, float f3, float f4) {
        Animation animationSet = new AnimationSet(false);
        Animation scaleAnimation = new ScaleAnimation(f, f2, f, f2, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(A);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        scaleAnimation = new AlphaAnimation(f3, f4);
        scaleAnimation.setInterpolator(B);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        return animationSet;
    }

    private static Animation a(float f, float f2) {
        Animation alphaAnimation = new AlphaAnimation(f, f2);
        alphaAnimation.setInterpolator(B);
        alphaAnimation.setDuration(220);
        return alphaAnimation;
    }

    private Animation a(Fragment fragment, int i, boolean z, int i2) {
        int i3 = fragment.Q;
        Fragment.l();
        if (fragment.Q != 0) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.o.c, fragment.Q);
            if (loadAnimation != null) {
                return loadAnimation;
            }
        }
        if (i == 0) {
            return null;
        }
        Object obj = -1;
        switch (i) {
            case 4097:
                if (!z) {
                    obj = 2;
                    break;
                }
                obj = 1;
                break;
            case 4099:
                if (!z) {
                    obj = 6;
                    break;
                }
                obj = 5;
                break;
            case 8194:
                if (!z) {
                    obj = 4;
                    break;
                }
                obj = 3;
                break;
        }
        if (obj < null) {
            return null;
        }
        switch (obj) {
            case 1:
                return a(1.125f, (float) IPictureView.DEFAULT_MIN_SCALE, 0.0f, (float) IPictureView.DEFAULT_MIN_SCALE);
            case 2:
                return a((float) IPictureView.DEFAULT_MIN_SCALE, 0.975f, (float) IPictureView.DEFAULT_MIN_SCALE, 0.0f);
            case 3:
                return a(0.975f, (float) IPictureView.DEFAULT_MIN_SCALE, 0.0f, (float) IPictureView.DEFAULT_MIN_SCALE);
            case 4:
                return a((float) IPictureView.DEFAULT_MIN_SCALE, 1.075f, (float) IPictureView.DEFAULT_MIN_SCALE, 0.0f);
            case 5:
                return a(0.0f, (float) IPictureView.DEFAULT_MIN_SCALE);
            case 6:
                return a((float) IPictureView.DEFAULT_MIN_SCALE, 0.0f);
            default:
                if (i2 == 0 && this.o.e()) {
                    i2 = this.o.f();
                }
                if (i2 == 0) {
                    return null;
                }
                return null;
        }
    }

    private static void a(View view, Animation animation) {
        Object obj = null;
        if (view != null && animation != null) {
            if (VERSION.SDK_INT >= 19 && ViewCompat.g(view) == 0 && ViewCompat.p(view)) {
                Object obj2;
                if (animation instanceof AlphaAnimation) {
                    obj2 = 1;
                } else {
                    if (animation instanceof AnimationSet) {
                        List animations = ((AnimationSet) animation).getAnimations();
                        for (int i = 0; i < animations.size(); i++) {
                            if (animations.get(i) instanceof AlphaAnimation) {
                                i = 1;
                                break;
                            }
                        }
                    }
                    obj2 = null;
                }
                if (obj2 != null) {
                    obj = 1;
                }
            }
            if (obj != null) {
                AnimationListener animationListener;
                try {
                    if (r == null) {
                        Field declaredField = Animation.class.getDeclaredField("mListener");
                        r = declaredField;
                        declaredField.setAccessible(true);
                    }
                    animationListener = (AnimationListener) r.get(animation);
                } catch (Throwable e) {
                    Log.e("FragmentManager", "No field with the name mListener is found in Animation class", e);
                    animationListener = null;
                } catch (Throwable e2) {
                    Log.e("FragmentManager", "Cannot access Animation's mListener field", e2);
                    animationListener = null;
                }
                ViewCompat.a(view, 2, null);
                animation.setAnimationListener(new z(view, animation, animationListener));
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final void a(android.mini.support.v4.app.Fragment r11, int r12, int r13, int r14, boolean r15) {
        /*
        r10 = this;
        r9 = 4;
        r6 = 3;
        r5 = 1;
        r7 = 0;
        r3 = 0;
        r0 = r11.v;
        if (r0 == 0) goto L_0x000d;
    L_0x0009:
        r0 = r11.K;
        if (r0 == 0) goto L_0x0010;
    L_0x000d:
        if (r12 <= r5) goto L_0x0010;
    L_0x000f:
        r12 = r5;
    L_0x0010:
        r0 = r11.w;
        if (r0 == 0) goto L_0x001a;
    L_0x0014:
        r0 = r11.k;
        if (r12 <= r0) goto L_0x001a;
    L_0x0018:
        r12 = r11.k;
    L_0x001a:
        r0 = r11.U;
        if (r0 == 0) goto L_0x0025;
    L_0x001e:
        r0 = r11.k;
        if (r0 >= r9) goto L_0x0025;
    L_0x0022:
        if (r12 <= r6) goto L_0x0025;
    L_0x0024:
        r12 = r6;
    L_0x0025:
        r0 = r11.k;
        if (r0 >= r12) goto L_0x03c0;
    L_0x0029:
        r0 = r11.x;
        if (r0 == 0) goto L_0x0032;
    L_0x002d:
        r0 = r11.y;
        if (r0 != 0) goto L_0x0032;
    L_0x0031:
        return;
    L_0x0032:
        r0 = r11.l;
        if (r0 == 0) goto L_0x0040;
    L_0x0036:
        r11.l = r7;
        r2 = r11.m;
        r0 = r10;
        r1 = r11;
        r4 = r3;
        r0.a(r1, r2, r3, r4, r5);
    L_0x0040:
        r0 = r11.k;
        switch(r0) {
            case 0: goto L_0x0076;
            case 1: goto L_0x018b;
            case 2: goto L_0x030f;
            case 3: goto L_0x0314;
            case 4: goto L_0x0369;
            default: goto L_0x0045;
        };
    L_0x0045:
        r0 = r11.k;
        if (r0 == r12) goto L_0x0031;
    L_0x0049:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r2 = "moveToState: Fragment state for ";
        r1.<init>(r2);
        r1 = r1.append(r11);
        r2 = " not updated inline; expected state ";
        r1 = r1.append(r2);
        r1 = r1.append(r12);
        r2 = " found ";
        r1 = r1.append(r2);
        r2 = r11.k;
        r1 = r1.append(r2);
        r1 = r1.toString();
        android.util.Log.w(r0, r1);
        r11.k = r12;
        goto L_0x0031;
    L_0x0076:
        r0 = a;
        if (r0 == 0) goto L_0x0084;
    L_0x007a:
        r0 = new java.lang.StringBuilder;
        r1 = "moveto CREATED: ";
        r0.<init>(r1);
        r0.append(r11);
    L_0x0084:
        r0 = r11.n;
        if (r0 == 0) goto L_0x00ca;
    L_0x0088:
        r0 = r11.n;
        r1 = r10.o;
        r1 = r1.c;
        r1 = r1.getClassLoader();
        r0.setClassLoader(r1);
        r0 = r11.n;
        r1 = "android:view_state";
        r0 = r0.getSparseParcelableArray(r1);
        r11.o = r0;
        r0 = r11.n;
        r1 = "android:target_state";
        r0 = r10.a(r0, r1);
        r11.s = r0;
        r0 = r11.s;
        if (r0 == 0) goto L_0x00b7;
    L_0x00ad:
        r0 = r11.n;
        r1 = "android:target_req_state";
        r0 = r0.getInt(r1, r3);
        r11.u = r0;
    L_0x00b7:
        r0 = r11.n;
        r1 = "android:user_visible_hint";
        r0 = r0.getBoolean(r1, r5);
        r11.V = r0;
        r0 = r11.V;
        if (r0 != 0) goto L_0x00ca;
    L_0x00c5:
        r11.U = r5;
        if (r12 <= r6) goto L_0x00ca;
    L_0x00c9:
        r12 = r6;
    L_0x00ca:
        r0 = r10.o;
        r11.C = r0;
        r0 = r10.q;
        r11.F = r0;
        r0 = r10.q;
        if (r0 == 0) goto L_0x0104;
    L_0x00d6:
        r0 = r10.q;
        r0 = r0.D;
    L_0x00da:
        r11.B = r0;
        r11.P = r3;
        r0 = r10.o;
        r0 = r0.c;
        r11.a(r0);
        r0 = r11.P;
        if (r0 != 0) goto L_0x0109;
    L_0x00e9:
        r0 = new android.mini.support.v4.app.as;
        r1 = new java.lang.StringBuilder;
        r2 = "Fragment ";
        r1.<init>(r2);
        r1 = r1.append(r11);
        r2 = " did not call through to super.onAttach()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0104:
        r0 = r10.o;
        r0 = r0.f;
        goto L_0x00da;
    L_0x0109:
        r0 = r11.F;
        if (r0 != 0) goto L_0x0146;
    L_0x010d:
        r0 = r10.o;
        r0.g();
    L_0x0112:
        r0 = r11.M;
        if (r0 != 0) goto L_0x014c;
    L_0x0116:
        r0 = r11.n;
        r1 = r11.D;
        if (r1 == 0) goto L_0x0120;
    L_0x011c:
        r1 = r11.D;
        r1.t = r3;
    L_0x0120:
        r11.k = r5;
        r11.P = r3;
        r11.a(r0);
        r0 = r11.P;
        if (r0 != 0) goto L_0x0153;
    L_0x012b:
        r0 = new android.mini.support.v4.app.as;
        r1 = new java.lang.StringBuilder;
        r2 = "Fragment ";
        r1.<init>(r2);
        r1 = r1.append(r11);
        r2 = " did not call through to super.onCreate()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0146:
        r0 = r11.F;
        android.mini.support.v4.app.Fragment.k();
        goto L_0x0112;
    L_0x014c:
        r0 = r11.n;
        r11.e(r0);
        r11.k = r5;
    L_0x0153:
        r11.M = r3;
        r0 = r11.x;
        if (r0 == 0) goto L_0x018b;
    L_0x0159:
        r0 = r11.n;
        r11.b(r0);
        r0 = r11.n;
        r0 = r11.o();
        r11.S = r0;
        r0 = r11.S;
        if (r0 == 0) goto L_0x02ae;
    L_0x016a:
        r0 = r11.S;
        r11.T = r0;
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 11;
        if (r0 < r1) goto L_0x02a4;
    L_0x0174:
        r0 = r11.S;
        android.mini.support.v4.view.ViewCompat.o(r0);
    L_0x0179:
        r0 = r11.J;
        if (r0 == 0) goto L_0x0184;
    L_0x017d:
        r0 = r11.S;
        r1 = 8;
        r0.setVisibility(r1);
    L_0x0184:
        r0 = r11.S;
        r0 = r11.n;
        android.mini.support.v4.app.Fragment.m();
    L_0x018b:
        if (r12 <= r5) goto L_0x030f;
    L_0x018d:
        r0 = a;
        if (r0 == 0) goto L_0x019b;
    L_0x0191:
        r0 = new java.lang.StringBuilder;
        r1 = "moveto ACTIVITY_CREATED: ";
        r0.<init>(r1);
        r0.append(r11);
    L_0x019b:
        r0 = r11.x;
        if (r0 != 0) goto L_0x0273;
    L_0x019f:
        r0 = r11.H;
        if (r0 == 0) goto L_0x05e4;
    L_0x01a3:
        r0 = r11.H;
        r1 = -1;
        if (r0 != r1) goto L_0x01c5;
    L_0x01a8:
        r0 = new java.lang.IllegalArgumentException;
        r1 = new java.lang.StringBuilder;
        r2 = "Cannot create fragment ";
        r1.<init>(r2);
        r1 = r1.append(r11);
        r2 = " for a container view with no id";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        r10.a(r0);
    L_0x01c5:
        r0 = r10.p;
        r1 = r11.H;
        r0 = r0.a(r1);
        r0 = (android.view.ViewGroup) r0;
        if (r0 != 0) goto L_0x0228;
    L_0x01d1:
        r1 = r11.z;
        if (r1 != 0) goto L_0x0228;
    L_0x01d5:
        r1 = r11.C;	 Catch:{ NotFoundException -> 0x01f4 }
        if (r1 != 0) goto L_0x02b2;
    L_0x01d9:
        r1 = new java.lang.IllegalStateException;	 Catch:{ NotFoundException -> 0x01f4 }
        r2 = new java.lang.StringBuilder;	 Catch:{ NotFoundException -> 0x01f4 }
        r4 = "Fragment ";
        r2.<init>(r4);	 Catch:{ NotFoundException -> 0x01f4 }
        r2 = r2.append(r11);	 Catch:{ NotFoundException -> 0x01f4 }
        r4 = " not attached to Activity";
        r2 = r2.append(r4);	 Catch:{ NotFoundException -> 0x01f4 }
        r2 = r2.toString();	 Catch:{ NotFoundException -> 0x01f4 }
        r1.<init>(r2);	 Catch:{ NotFoundException -> 0x01f4 }
        throw r1;	 Catch:{ NotFoundException -> 0x01f4 }
    L_0x01f4:
        r1 = move-exception;
        r1 = "unknown";
    L_0x01f7:
        r2 = new java.lang.IllegalArgumentException;
        r4 = new java.lang.StringBuilder;
        r8 = "No view found for id 0x";
        r4.<init>(r8);
        r8 = r11.H;
        r8 = java.lang.Integer.toHexString(r8);
        r4 = r4.append(r8);
        r8 = " (";
        r4 = r4.append(r8);
        r1 = r4.append(r1);
        r4 = ") for fragment ";
        r1 = r1.append(r4);
        r1 = r1.append(r11);
        r1 = r1.toString();
        r2.<init>(r1);
        r10.a(r2);
    L_0x0228:
        r11.R = r0;
        r1 = r11.n;
        r11.b(r1);
        r1 = r11.n;
        r1 = r11.o();
        r11.S = r1;
        r1 = r11.S;
        if (r1 == 0) goto L_0x02cb;
    L_0x023b:
        r1 = r11.S;
        r11.T = r1;
        r1 = android.os.Build.VERSION.SDK_INT;
        r2 = 11;
        if (r1 < r2) goto L_0x02c2;
    L_0x0245:
        r1 = r11.S;
        android.mini.support.v4.view.ViewCompat.o(r1);
    L_0x024a:
        if (r0 == 0) goto L_0x0261;
    L_0x024c:
        r1 = r10.a(r11, r13, r5, r14);
        if (r1 == 0) goto L_0x025c;
    L_0x0252:
        r2 = r11.S;
        a(r2, r1);
        r2 = r11.S;
        r2.startAnimation(r1);
    L_0x025c:
        r1 = r11.S;
        r0.addView(r1);
    L_0x0261:
        r0 = r11.J;
        if (r0 == 0) goto L_0x026c;
    L_0x0265:
        r0 = r11.S;
        r1 = 8;
        r0.setVisibility(r1);
    L_0x026c:
        r0 = r11.S;
        r0 = r11.n;
        android.mini.support.v4.app.Fragment.m();
    L_0x0273:
        r0 = r11.n;
        r1 = r11.D;
        if (r1 == 0) goto L_0x027d;
    L_0x0279:
        r1 = r11.D;
        r1.t = r3;
    L_0x027d:
        r1 = 2;
        r11.k = r1;
        r11.P = r3;
        r11.c(r0);
        r0 = r11.P;
        if (r0 != 0) goto L_0x02ce;
    L_0x0289:
        r0 = new android.mini.support.v4.app.as;
        r1 = new java.lang.StringBuilder;
        r2 = "Fragment ";
        r1.<init>(r2);
        r1 = r1.append(r11);
        r2 = " did not call through to super.onActivityCreated()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x02a4:
        r0 = r11.S;
        r0 = android.mini.support.v4.app.aq.a(r0);
        r11.S = r0;
        goto L_0x0179;
    L_0x02ae:
        r11.T = r7;
        goto L_0x018b;
    L_0x02b2:
        r1 = r11.C;	 Catch:{ NotFoundException -> 0x01f4 }
        r1 = r1.c;	 Catch:{ NotFoundException -> 0x01f4 }
        r1 = r1.getResources();	 Catch:{ NotFoundException -> 0x01f4 }
        r2 = r11.H;	 Catch:{ NotFoundException -> 0x01f4 }
        r1 = r1.getResourceName(r2);	 Catch:{ NotFoundException -> 0x01f4 }
        goto L_0x01f7;
    L_0x02c2:
        r1 = r11.S;
        r1 = android.mini.support.v4.app.aq.a(r1);
        r11.S = r1;
        goto L_0x024a;
    L_0x02cb:
        r11.T = r7;
        goto L_0x0273;
    L_0x02ce:
        r0 = r11.D;
        if (r0 == 0) goto L_0x02d7;
    L_0x02d2:
        r0 = r11.D;
        r0.h();
    L_0x02d7:
        r0 = r11.S;
        if (r0 == 0) goto L_0x030d;
    L_0x02db:
        r0 = r11.n;
        r0 = r11.o;
        if (r0 == 0) goto L_0x02ea;
    L_0x02e1:
        r0 = r11.T;
        r1 = r11.o;
        r0.restoreHierarchyState(r1);
        r11.o = r7;
    L_0x02ea:
        r11.P = r3;
        r11.P = r5;
        r0 = r11.P;
        if (r0 != 0) goto L_0x030d;
    L_0x02f2:
        r0 = new android.mini.support.v4.app.as;
        r1 = new java.lang.StringBuilder;
        r2 = "Fragment ";
        r1.<init>(r2);
        r1 = r1.append(r11);
        r2 = " did not call through to super.onViewStateRestored()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x030d:
        r11.n = r7;
    L_0x030f:
        r0 = 2;
        if (r12 <= r0) goto L_0x0314;
    L_0x0312:
        r11.k = r6;
    L_0x0314:
        if (r12 <= r6) goto L_0x0369;
    L_0x0316:
        r0 = a;
        if (r0 == 0) goto L_0x0324;
    L_0x031a:
        r0 = new java.lang.StringBuilder;
        r1 = "moveto STARTED: ";
        r0.<init>(r1);
        r0.append(r11);
    L_0x0324:
        r0 = r11.D;
        if (r0 == 0) goto L_0x0331;
    L_0x0328:
        r0 = r11.D;
        r0.t = r3;
        r0 = r11.D;
        r0.c();
    L_0x0331:
        r11.k = r9;
        r11.P = r3;
        r11.b();
        r0 = r11.P;
        if (r0 != 0) goto L_0x0357;
    L_0x033c:
        r0 = new android.mini.support.v4.app.as;
        r1 = new java.lang.StringBuilder;
        r2 = "Fragment ";
        r1.<init>(r2);
        r1 = r1.append(r11);
        r2 = " did not call through to super.onStart()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0357:
        r0 = r11.D;
        if (r0 == 0) goto L_0x0360;
    L_0x035b:
        r0 = r11.D;
        r0.i();
    L_0x0360:
        r0 = r11.W;
        if (r0 == 0) goto L_0x0369;
    L_0x0364:
        r0 = r11.W;
        r0.f();
    L_0x0369:
        if (r12 <= r9) goto L_0x0045;
    L_0x036b:
        r0 = a;
        if (r0 == 0) goto L_0x0379;
    L_0x036f:
        r0 = new java.lang.StringBuilder;
        r1 = "moveto RESUMED: ";
        r0.<init>(r1);
        r0.append(r11);
    L_0x0379:
        r0 = r11.D;
        if (r0 == 0) goto L_0x0386;
    L_0x037d:
        r0 = r11.D;
        r0.t = r3;
        r0 = r11.D;
        r0.c();
    L_0x0386:
        r0 = 5;
        r11.k = r0;
        r11.P = r3;
        r11.P = r5;
        r0 = r11.P;
        if (r0 != 0) goto L_0x03ac;
    L_0x0391:
        r0 = new android.mini.support.v4.app.as;
        r1 = new java.lang.StringBuilder;
        r2 = "Fragment ";
        r1.<init>(r2);
        r1 = r1.append(r11);
        r2 = " did not call through to super.onResume()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x03ac:
        r0 = r11.D;
        if (r0 == 0) goto L_0x03ba;
    L_0x03b0:
        r0 = r11.D;
        r0.j();
        r0 = r11.D;
        r0.c();
    L_0x03ba:
        r11.n = r7;
        r11.o = r7;
        goto L_0x0045;
    L_0x03c0:
        r0 = r11.k;
        if (r0 <= r12) goto L_0x0045;
    L_0x03c4:
        r0 = r11.k;
        switch(r0) {
            case 1: goto L_0x03cb;
            case 2: goto L_0x0476;
            case 3: goto L_0x0463;
            case 4: goto L_0x0424;
            case 5: goto L_0x03e5;
            default: goto L_0x03c9;
        };
    L_0x03c9:
        goto L_0x0045;
    L_0x03cb:
        if (r12 > 0) goto L_0x0045;
    L_0x03cd:
        r0 = r10.u;
        if (r0 == 0) goto L_0x03dc;
    L_0x03d1:
        r0 = r11.l;
        if (r0 == 0) goto L_0x03dc;
    L_0x03d5:
        r0 = r11.l;
        r11.l = r7;
        r0.clearAnimation();
    L_0x03dc:
        r0 = r11.l;
        if (r0 == 0) goto L_0x050c;
    L_0x03e0:
        r11.m = r12;
        r12 = r5;
        goto L_0x0045;
    L_0x03e5:
        r0 = 5;
        if (r12 >= r0) goto L_0x0424;
    L_0x03e8:
        r0 = a;
        if (r0 == 0) goto L_0x03f6;
    L_0x03ec:
        r0 = new java.lang.StringBuilder;
        r1 = "movefrom RESUMED: ";
        r0.<init>(r1);
        r0.append(r11);
    L_0x03f6:
        r0 = r11.D;
        if (r0 == 0) goto L_0x03ff;
    L_0x03fa:
        r0 = r11.D;
        r0.b(r9);
    L_0x03ff:
        r11.k = r9;
        r11.P = r3;
        r11.P = r5;
        r0 = r11.P;
        if (r0 != 0) goto L_0x0424;
    L_0x0409:
        r0 = new android.mini.support.v4.app.as;
        r1 = new java.lang.StringBuilder;
        r2 = "Fragment ";
        r1.<init>(r2);
        r1 = r1.append(r11);
        r2 = " did not call through to super.onPause()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0424:
        if (r12 >= r9) goto L_0x0463;
    L_0x0426:
        r0 = a;
        if (r0 == 0) goto L_0x0434;
    L_0x042a:
        r0 = new java.lang.StringBuilder;
        r1 = "movefrom STARTED: ";
        r0.<init>(r1);
        r0.append(r11);
    L_0x0434:
        r0 = r11.D;
        if (r0 == 0) goto L_0x043d;
    L_0x0438:
        r0 = r11.D;
        r0.k();
    L_0x043d:
        r11.k = r6;
        r11.P = r3;
        r11.c();
        r0 = r11.P;
        if (r0 != 0) goto L_0x0463;
    L_0x0448:
        r0 = new android.mini.support.v4.app.as;
        r1 = new java.lang.StringBuilder;
        r2 = "Fragment ";
        r1.<init>(r2);
        r1 = r1.append(r11);
        r2 = " did not call through to super.onStop()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0463:
        if (r12 >= r6) goto L_0x0476;
    L_0x0465:
        r0 = a;
        if (r0 == 0) goto L_0x0473;
    L_0x0469:
        r0 = new java.lang.StringBuilder;
        r1 = "movefrom STOPPED: ";
        r0.<init>(r1);
        r0.append(r11);
    L_0x0473:
        r11.p();
    L_0x0476:
        r0 = 2;
        if (r12 >= r0) goto L_0x03cb;
    L_0x0479:
        r0 = a;
        if (r0 == 0) goto L_0x0487;
    L_0x047d:
        r0 = new java.lang.StringBuilder;
        r1 = "movefrom ACTIVITY_CREATED: ";
        r0.<init>(r1);
        r0.append(r11);
    L_0x0487:
        r0 = r11.S;
        if (r0 == 0) goto L_0x049a;
    L_0x048b:
        r0 = r10.o;
        r0 = r0.b();
        if (r0 == 0) goto L_0x049a;
    L_0x0493:
        r0 = r11.o;
        if (r0 != 0) goto L_0x049a;
    L_0x0497:
        r10.c(r11);
    L_0x049a:
        r0 = r11.D;
        if (r0 == 0) goto L_0x04a3;
    L_0x049e:
        r0 = r11.D;
        r0.b(r5);
    L_0x04a3:
        r11.k = r5;
        r11.P = r3;
        r11.d();
        r0 = r11.P;
        if (r0 != 0) goto L_0x04c9;
    L_0x04ae:
        r0 = new android.mini.support.v4.app.as;
        r1 = new java.lang.StringBuilder;
        r2 = "Fragment ";
        r1.<init>(r2);
        r1 = r1.append(r11);
        r2 = " did not call through to super.onDestroyView()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x04c9:
        r0 = r11.W;
        if (r0 == 0) goto L_0x04d2;
    L_0x04cd:
        r0 = r11.W;
        r0.e();
    L_0x04d2:
        r0 = r11.S;
        if (r0 == 0) goto L_0x0504;
    L_0x04d6:
        r0 = r11.R;
        if (r0 == 0) goto L_0x0504;
    L_0x04da:
        r0 = r10.n;
        if (r0 <= 0) goto L_0x05e1;
    L_0x04de:
        r0 = r10.u;
        if (r0 != 0) goto L_0x05e1;
    L_0x04e2:
        r0 = r10.a(r11, r13, r3, r14);
    L_0x04e6:
        if (r0 == 0) goto L_0x04fd;
    L_0x04e8:
        r1 = r11.S;
        r11.l = r1;
        r11.m = r12;
        r1 = r11.S;
        r2 = new android.mini.support.v4.app.x;
        r2.<init>(r10, r1, r0, r11);
        r0.setAnimationListener(r2);
        r1 = r11.S;
        r1.startAnimation(r0);
    L_0x04fd:
        r0 = r11.R;
        r1 = r11.S;
        r0.removeView(r1);
    L_0x0504:
        r11.R = r7;
        r11.S = r7;
        r11.T = r7;
        goto L_0x03cb;
    L_0x050c:
        r0 = a;
        if (r0 == 0) goto L_0x051a;
    L_0x0510:
        r0 = new java.lang.StringBuilder;
        r1 = "movefrom CREATED: ";
        r0.<init>(r1);
        r0.append(r11);
    L_0x051a:
        r0 = r11.M;
        if (r0 != 0) goto L_0x0545;
    L_0x051e:
        r11.q();
    L_0x0521:
        r11.P = r3;
        r11.a();
        r0 = r11.P;
        if (r0 != 0) goto L_0x0548;
    L_0x052a:
        r0 = new android.mini.support.v4.app.as;
        r1 = new java.lang.StringBuilder;
        r2 = "Fragment ";
        r1.<init>(r2);
        r1 = r1.append(r11);
        r2 = " did not call through to super.onDetach()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0545:
        r11.k = r3;
        goto L_0x0521;
    L_0x0548:
        r0 = r11.D;
        if (r0 == 0) goto L_0x0572;
    L_0x054c:
        r0 = r11.M;
        if (r0 != 0) goto L_0x056b;
    L_0x0550:
        r0 = new java.lang.IllegalStateException;
        r1 = new java.lang.StringBuilder;
        r2 = "Child FragmentManager of ";
        r1.<init>(r2);
        r1 = r1.append(r11);
        r2 = " was not  destroyed and this fragment is not retaining instance";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x056b:
        r0 = r11.D;
        r0.l();
        r11.D = r7;
    L_0x0572:
        if (r15 != 0) goto L_0x0045;
    L_0x0574:
        r0 = r11.M;
        if (r0 != 0) goto L_0x05d9;
    L_0x0578:
        r0 = r11.p;
        if (r0 < 0) goto L_0x0045;
    L_0x057c:
        r0 = a;
        if (r0 == 0) goto L_0x058a;
    L_0x0580:
        r0 = new java.lang.StringBuilder;
        r1 = "Freeing fragment index ";
        r0.<init>(r1);
        r0.append(r11);
    L_0x058a:
        r0 = r10.f;
        r1 = r11.p;
        r0.set(r1, r7);
        r0 = r10.h;
        if (r0 != 0) goto L_0x059c;
    L_0x0595:
        r0 = new java.util.ArrayList;
        r0.<init>();
        r10.h = r0;
    L_0x059c:
        r0 = r10.h;
        r1 = r11.p;
        r1 = java.lang.Integer.valueOf(r1);
        r0.add(r1);
        r0 = r10.o;
        r1 = r11.q;
        r0.a(r1);
        r0 = -1;
        r11.p = r0;
        r11.q = r7;
        r11.v = r3;
        r11.w = r3;
        r11.x = r3;
        r11.y = r3;
        r11.z = r3;
        r11.A = r3;
        r11.B = r7;
        r11.D = r7;
        r11.C = r7;
        r11.G = r3;
        r11.H = r3;
        r11.I = r7;
        r11.J = r3;
        r11.K = r3;
        r11.M = r3;
        r11.W = r7;
        r11.X = r3;
        r11.Y = r3;
        goto L_0x0045;
    L_0x05d9:
        r11.C = r7;
        r11.F = r7;
        r11.B = r7;
        goto L_0x0045;
    L_0x05e1:
        r0 = r7;
        goto L_0x04e6;
    L_0x05e4:
        r0 = r7;
        goto L_0x0228;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.mini.support.v4.app.ab.a(android.mini.support.v4.app.Fragment, int, int, int, boolean):void");
    }

    private void b(Fragment fragment) {
        a(fragment, this.n, 0, 0, false);
    }

    final void b(int i) {
        a(i, 0, 0, false);
    }

    final void a(int i, int i2, int i3, boolean z) {
        if (this.o == null && i != 0) {
            throw new IllegalStateException("No host");
        } else if (z || this.n != i) {
            this.n = i;
            if (this.f != null) {
                int i4 = 0;
                int i5 = 0;
                while (i4 < this.f.size()) {
                    int a;
                    Fragment fragment = (Fragment) this.f.get(i4);
                    if (fragment != null) {
                        a(fragment, i, i2, i3, false);
                        if (fragment.W != null) {
                            a = i5 | fragment.W.a();
                            i4++;
                            i5 = a;
                        }
                    }
                    a = i5;
                    i4++;
                    i5 = a;
                }
                if (i5 == 0) {
                    n();
                }
                if (this.s && this.o != null && this.n == 5) {
                    this.o.d();
                    this.s = false;
                }
            }
        }
    }

    private void n() {
        if (this.f != null) {
            for (int i = 0; i < this.f.size(); i++) {
                Fragment fragment = (Fragment) this.f.get(i);
                if (fragment != null && fragment.U) {
                    if (this.e) {
                        this.w = true;
                    } else {
                        fragment.U = false;
                        a(fragment, this.n, 0, 0, false);
                    }
                }
            }
        }
    }

    final void a(Fragment fragment) {
        if (fragment.p < 0) {
            if (this.h == null || this.h.size() <= 0) {
                if (this.f == null) {
                    this.f = new ArrayList();
                }
                fragment.a(this.f.size(), this.q);
                this.f.add(fragment);
            } else {
                fragment.a(((Integer) this.h.remove(this.h.size() - 1)).intValue(), this.q);
                this.f.set(fragment.p, fragment);
            }
            if (a) {
                new StringBuilder("Allocated fragment index ").append(fragment);
            }
        }
    }

    public final void a(Fragment fragment, boolean z) {
        if (this.g == null) {
            this.g = new ArrayList();
        }
        if (a) {
            new StringBuilder("add: ").append(fragment);
        }
        a(fragment);
        if (!fragment.K) {
            if (this.g.contains(fragment)) {
                throw new IllegalStateException("Fragment already added: " + fragment);
            }
            this.g.add(fragment);
            fragment.v = true;
            fragment.w = false;
            if (fragment.N && fragment.O) {
                this.s = true;
            }
            if (z) {
                b(fragment);
            }
        }
    }

    public final void a(Fragment fragment, int i, int i2) {
        boolean z;
        if (a) {
            new StringBuilder("remove: ").append(fragment).append(" nesting=").append(fragment.A);
        }
        if (fragment.A > 0) {
            z = true;
        } else {
            z = false;
        }
        z = !z;
        if (!fragment.K || z) {
            int i3;
            if (this.g != null) {
                this.g.remove(fragment);
            }
            if (fragment.N && fragment.O) {
                this.s = true;
            }
            fragment.v = false;
            fragment.w = true;
            if (z) {
                i3 = 0;
            } else {
                i3 = 1;
            }
            a(fragment, i3, i, i2, false);
        }
    }

    public final void b(Fragment fragment, int i, int i2) {
        if (a) {
            new StringBuilder("hide: ").append(fragment);
        }
        if (!fragment.J) {
            fragment.J = true;
            if (fragment.S != null) {
                Animation a = a(fragment, i, false, i2);
                if (a != null) {
                    a(fragment.S, a);
                    fragment.S.startAnimation(a);
                }
                fragment.S.setVisibility(8);
            }
            if (fragment.v && fragment.N && fragment.O) {
                this.s = true;
            }
            Fragment.g();
        }
    }

    public final void c(Fragment fragment, int i, int i2) {
        if (a) {
            new StringBuilder("show: ").append(fragment);
        }
        if (fragment.J) {
            fragment.J = false;
            if (fragment.S != null) {
                Animation a = a(fragment, i, true, i2);
                if (a != null) {
                    a(fragment.S, a);
                    fragment.S.startAnimation(a);
                }
                fragment.S.setVisibility(0);
            }
            if (fragment.v && fragment.N && fragment.O) {
                this.s = true;
            }
            Fragment.g();
        }
    }

    public final void d(Fragment fragment, int i, int i2) {
        if (a) {
            new StringBuilder("detach: ").append(fragment);
        }
        if (!fragment.K) {
            fragment.K = true;
            if (fragment.v) {
                if (this.g != null) {
                    if (a) {
                        new StringBuilder("remove from detach: ").append(fragment);
                    }
                    this.g.remove(fragment);
                }
                if (fragment.N && fragment.O) {
                    this.s = true;
                }
                fragment.v = false;
                a(fragment, 1, i, i2, false);
            }
        }
    }

    public final void e(Fragment fragment, int i, int i2) {
        if (a) {
            new StringBuilder("attach: ").append(fragment);
        }
        if (fragment.K) {
            fragment.K = false;
            if (!fragment.v) {
                if (this.g == null) {
                    this.g = new ArrayList();
                }
                if (this.g.contains(fragment)) {
                    throw new IllegalStateException("Fragment already added: " + fragment);
                }
                if (a) {
                    new StringBuilder("add from attach: ").append(fragment);
                }
                this.g.add(fragment);
                fragment.v = true;
                if (fragment.N && fragment.O) {
                    this.s = true;
                }
                a(fragment, this.n, i, i2, false);
            }
        }
    }

    private Fragment d(int i) {
        int size;
        Fragment fragment;
        if (this.g != null) {
            for (size = this.g.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.g.get(size);
                if (fragment != null && fragment.G == i) {
                    return fragment;
                }
            }
        }
        if (this.f != null) {
            for (size = this.f.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.f.get(size);
                if (fragment != null && fragment.G == i) {
                    return fragment;
                }
            }
        }
        return null;
    }

    private Fragment b(String str) {
        int size;
        Fragment fragment;
        if (!(this.g == null || str == null)) {
            for (size = this.g.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.g.get(size);
                if (fragment != null && str.equals(fragment.I)) {
                    return fragment;
                }
            }
        }
        if (!(this.f == null || str == null)) {
            for (size = this.f.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.f.get(size);
                if (fragment != null && str.equals(fragment.I)) {
                    return fragment;
                }
            }
        }
        return null;
    }

    public final Fragment a(String str) {
        if (!(this.f == null || str == null)) {
            for (int size = this.f.size() - 1; size >= 0; size--) {
                Fragment fragment = (Fragment) this.f.get(size);
                if (fragment != null) {
                    if (!str.equals(fragment.q)) {
                        fragment = fragment.D != null ? fragment.D.a(str) : null;
                    }
                    if (fragment != null) {
                        return fragment;
                    }
                }
            }
        }
        return null;
    }

    private void o() {
        if (this.t) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        } else if (this.v != null) {
            throw new IllegalStateException("Can not perform this action inside of " + this.v);
        }
    }

    public final void a(Runnable runnable, boolean z) {
        if (!z) {
            o();
        }
        synchronized (this) {
            if (this.u || this.o == null) {
                throw new IllegalStateException("Activity has been destroyed");
            }
            if (this.c == null) {
                this.c = new ArrayList();
            }
            this.c.add(runnable);
            if (this.c.size() == 1) {
                this.o.d.removeCallbacks(this.z);
                this.o.d.post(this.z);
            }
        }
    }

    public final int a(f fVar) {
        int size;
        synchronized (this) {
            if (this.l == null || this.l.size() <= 0) {
                if (this.k == null) {
                    this.k = new ArrayList();
                }
                size = this.k.size();
                if (a) {
                    new StringBuilder("Setting back stack index ").append(size).append(" to ").append(fVar);
                }
                this.k.add(fVar);
            } else {
                size = ((Integer) this.l.remove(this.l.size() - 1)).intValue();
                if (a) {
                    new StringBuilder("Adding back stack index ").append(size).append(" with ").append(fVar);
                }
                this.k.set(size, fVar);
            }
        }
        return size;
    }

    private void a(int i, f fVar) {
        synchronized (this) {
            if (this.k == null) {
                this.k = new ArrayList();
            }
            int size = this.k.size();
            if (i < size) {
                if (a) {
                    new StringBuilder("Setting back stack index ").append(i).append(" to ").append(fVar);
                }
                this.k.set(i, fVar);
            } else {
                while (size < i) {
                    this.k.add(null);
                    if (this.l == null) {
                        this.l = new ArrayList();
                    }
                    this.l.add(Integer.valueOf(size));
                    size++;
                }
                if (a) {
                    new StringBuilder("Adding back stack index ").append(i).append(" with ").append(fVar);
                }
                this.k.add(fVar);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean c() {
        /*
        r6 = this;
        r2 = 1;
        r1 = 0;
        r0 = r6.e;
        if (r0 == 0) goto L_0x000e;
    L_0x0006:
        r0 = new java.lang.IllegalStateException;
        r1 = "FragmentManager is already executing transactions";
        r0.<init>(r1);
        throw r0;
    L_0x000e:
        r0 = android.os.Looper.myLooper();
        r3 = r6.o;
        r3 = r3.d;
        r3 = r3.getLooper();
        if (r0 == r3) goto L_0x0024;
    L_0x001c:
        r0 = new java.lang.IllegalStateException;
        r1 = "Must be called from main thread of fragment host";
        r0.<init>(r1);
        throw r0;
    L_0x0024:
        r0 = r1;
    L_0x0025:
        monitor-enter(r6);
        r3 = r6.c;	 Catch:{ all -> 0x0074 }
        if (r3 == 0) goto L_0x0032;
    L_0x002a:
        r3 = r6.c;	 Catch:{ all -> 0x0074 }
        r3 = r3.size();	 Catch:{ all -> 0x0074 }
        if (r3 != 0) goto L_0x0037;
    L_0x0032:
        monitor-exit(r6);	 Catch:{ all -> 0x0074 }
        r6.p();
        return r0;
    L_0x0037:
        r0 = r6.c;	 Catch:{ all -> 0x0074 }
        r3 = r0.size();	 Catch:{ all -> 0x0074 }
        r0 = r6.d;	 Catch:{ all -> 0x0074 }
        if (r0 == 0) goto L_0x0046;
    L_0x0041:
        r0 = r6.d;	 Catch:{ all -> 0x0074 }
        r0 = r0.length;	 Catch:{ all -> 0x0074 }
        if (r0 >= r3) goto L_0x004a;
    L_0x0046:
        r0 = new java.lang.Runnable[r3];	 Catch:{ all -> 0x0074 }
        r6.d = r0;	 Catch:{ all -> 0x0074 }
    L_0x004a:
        r0 = r6.c;	 Catch:{ all -> 0x0074 }
        r4 = r6.d;	 Catch:{ all -> 0x0074 }
        r0.toArray(r4);	 Catch:{ all -> 0x0074 }
        r0 = r6.c;	 Catch:{ all -> 0x0074 }
        r0.clear();	 Catch:{ all -> 0x0074 }
        r0 = r6.o;	 Catch:{ all -> 0x0074 }
        r0 = r0.d;	 Catch:{ all -> 0x0074 }
        r4 = r6.z;	 Catch:{ all -> 0x0074 }
        r0.removeCallbacks(r4);	 Catch:{ all -> 0x0074 }
        monitor-exit(r6);	 Catch:{ all -> 0x0074 }
        r6.e = r2;
        r0 = r1;
    L_0x0063:
        if (r0 >= r3) goto L_0x0077;
    L_0x0065:
        r4 = r6.d;
        r4 = r4[r0];
        r4.run();
        r4 = r6.d;
        r5 = 0;
        r4[r0] = r5;
        r0 = r0 + 1;
        goto L_0x0063;
    L_0x0074:
        r0 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x0074 }
        throw r0;
    L_0x0077:
        r6.e = r1;
        r0 = r2;
        goto L_0x0025;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.mini.support.v4.app.ab.c():boolean");
    }

    private void p() {
        if (this.w) {
            int i = 0;
            for (int i2 = 0; i2 < this.f.size(); i2++) {
                Fragment fragment = (Fragment) this.f.get(i2);
                if (!(fragment == null || fragment.W == null)) {
                    i |= fragment.W.a();
                }
            }
            if (i == 0) {
                this.w = false;
                n();
            }
        }
    }

    final void d() {
        if (this.m != null) {
            for (int i = 0; i < this.m.size(); i++) {
                this.m.get(i);
            }
        }
    }

    final boolean a(int i, int i2) {
        if (this.i == null) {
            return false;
        }
        int i3;
        f fVar;
        if (i >= 0 || (i2 & 1) != 0) {
            int size;
            i3 = -1;
            if (i >= 0) {
                size = this.i.size() - 1;
                while (size >= 0) {
                    fVar = (f) this.i.get(size);
                    if (i >= 0 && i == fVar.p) {
                        break;
                    }
                    size--;
                }
                if (size < 0) {
                    return false;
                }
                if ((i2 & 1) != 0) {
                    size--;
                    while (size >= 0) {
                        fVar = (f) this.i.get(size);
                        if (i < 0 || i != fVar.p) {
                            break;
                        }
                        size--;
                    }
                }
                i3 = size;
            }
            if (i3 == this.i.size() - 1) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (size = this.i.size() - 1; size > i3; size--) {
                arrayList.add(this.i.remove(size));
            }
            int size2 = arrayList.size() - 1;
            SparseArray sparseArray = new SparseArray();
            SparseArray sparseArray2 = new SparseArray();
            if (this.n > 0) {
                for (size = 0; size <= size2; size++) {
                    ((f) arrayList.get(size)).a(sparseArray, sparseArray2);
                }
            }
            e eVar = null;
            int i4 = 0;
            while (i4 <= size2) {
                boolean z;
                if (a) {
                    new StringBuilder("Popping back stack state: ").append(arrayList.get(i4));
                }
                fVar = (f) arrayList.get(i4);
                if (i4 == size2) {
                    z = true;
                } else {
                    z = false;
                }
                i4++;
                eVar = fVar.a(z, eVar, sparseArray, sparseArray2);
            }
        } else {
            i3 = this.i.size() - 1;
            if (i3 < 0) {
                return false;
            }
            fVar = (f) this.i.remove(i3);
            SparseArray sparseArray3 = new SparseArray();
            SparseArray sparseArray4 = new SparseArray();
            if (this.n > 0) {
                fVar.a(sparseArray3, sparseArray4);
            }
            fVar.a(true, null, sparseArray3, sparseArray4);
        }
        d();
        return true;
    }

    final ac e() {
        List list;
        List list2;
        if (this.f != null) {
            int i = 0;
            list = null;
            list2 = null;
            while (i < this.f.size()) {
                ArrayList arrayList;
                Fragment fragment = (Fragment) this.f.get(i);
                if (fragment != null) {
                    boolean z;
                    if (fragment.L) {
                        if (list2 == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(fragment);
                        fragment.M = true;
                        fragment.t = fragment.s != null ? fragment.s.p : -1;
                        if (a) {
                            new StringBuilder("retainNonConfig: keeping retained ").append(fragment);
                        }
                    }
                    if (fragment.D != null) {
                        ac e = fragment.D.e();
                        if (e != null) {
                            ArrayList arrayList2;
                            if (list == null) {
                                arrayList2 = new ArrayList();
                                for (int i2 = 0; i2 < i; i2++) {
                                    arrayList2.add(null);
                                }
                            } else {
                                arrayList2 = list;
                            }
                            arrayList2.add(e);
                            list = arrayList2;
                            z = true;
                            if (!(list == null || r0)) {
                                list.add(null);
                            }
                        }
                    }
                    z = false;
                    list.add(null);
                }
                i++;
                Object obj = arrayList;
            }
        } else {
            list = null;
            list2 = null;
        }
        if (list2 == null && list == null) {
            return null;
        }
        return new ac(list2, list);
    }

    private void c(Fragment fragment) {
        if (fragment.T != null) {
            if (this.y == null) {
                this.y = new SparseArray();
            } else {
                this.y.clear();
            }
            fragment.T.saveHierarchyState(this.y);
            if (this.y.size() > 0) {
                fragment.o = this.y;
                this.y = null;
            }
        }
    }

    final Parcelable f() {
        BackStackState[] backStackStateArr = null;
        c();
        if (b) {
            this.t = true;
        }
        if (this.f == null || this.f.size() <= 0) {
            return null;
        }
        int size = this.f.size();
        FragmentState[] fragmentStateArr = new FragmentState[size];
        int i = 0;
        boolean z = false;
        while (i < size) {
            boolean z2;
            Fragment fragment = (Fragment) this.f.get(i);
            if (fragment != null) {
                if (fragment.p < 0) {
                    a(new IllegalStateException("Failure saving state: active " + fragment + " has cleared index: " + fragment.p));
                }
                FragmentState fragmentState = new FragmentState(fragment);
                fragmentStateArr[i] = fragmentState;
                if (fragment.k <= 0 || fragmentState.k != null) {
                    fragmentState.k = fragment.n;
                } else {
                    Bundle bundle;
                    if (this.x == null) {
                        this.x = new Bundle();
                    }
                    fragment.f(this.x);
                    if (this.x.isEmpty()) {
                        bundle = null;
                    } else {
                        bundle = this.x;
                        this.x = null;
                    }
                    if (fragment.S != null) {
                        c(fragment);
                    }
                    if (fragment.o != null) {
                        if (bundle == null) {
                            bundle = new Bundle();
                        }
                        bundle.putSparseParcelableArray("android:view_state", fragment.o);
                    }
                    if (!fragment.V) {
                        if (bundle == null) {
                            bundle = new Bundle();
                        }
                        bundle.putBoolean("android:user_visible_hint", fragment.V);
                    }
                    fragmentState.k = bundle;
                    if (fragment.s != null) {
                        if (fragment.s.p < 0) {
                            a(new IllegalStateException("Failure saving state: " + fragment + " has target not in fragment manager: " + fragment.s));
                        }
                        if (fragmentState.k == null) {
                            fragmentState.k = new Bundle();
                        }
                        bundle = fragmentState.k;
                        String str = "android:target_state";
                        Fragment fragment2 = fragment.s;
                        if (fragment2.p < 0) {
                            a(new IllegalStateException("Fragment " + fragment2 + " is not currently in the FragmentManager"));
                        }
                        bundle.putInt(str, fragment2.p);
                        if (fragment.u != 0) {
                            fragmentState.k.putInt("android:target_req_state", fragment.u);
                        }
                    }
                }
                if (a) {
                    new StringBuilder("Saved state of ").append(fragment).append(": ").append(fragmentState.k);
                }
                z2 = true;
            } else {
                z2 = z;
            }
            i++;
            z = z2;
        }
        if (!z) {
            return null;
        }
        int[] iArr;
        int i2;
        FragmentManagerState fragmentManagerState;
        if (this.g != null) {
            i = this.g.size();
            if (i > 0) {
                iArr = new int[i];
                for (i2 = 0; i2 < i; i2++) {
                    iArr[i2] = ((Fragment) this.g.get(i2)).p;
                    if (iArr[i2] < 0) {
                        a(new IllegalStateException("Failure saving state: active " + this.g.get(i2) + " has cleared index: " + iArr[i2]));
                    }
                    if (a) {
                        new StringBuilder("saveAllState: adding fragment #").append(i2).append(": ").append(this.g.get(i2));
                    }
                }
                if (this.i != null) {
                    i = this.i.size();
                    if (i > 0) {
                        backStackStateArr = new BackStackState[i];
                        for (i2 = 0; i2 < i; i2++) {
                            backStackStateArr[i2] = new BackStackState((f) this.i.get(i2));
                            if (a) {
                                new StringBuilder("saveAllState: adding back stack #").append(i2).append(": ").append(this.i.get(i2));
                            }
                        }
                    }
                }
                fragmentManagerState = new FragmentManagerState();
                fragmentManagerState.a = fragmentStateArr;
                fragmentManagerState.b = iArr;
                fragmentManagerState.c = backStackStateArr;
                return fragmentManagerState;
            }
        }
        iArr = null;
        if (this.i != null) {
            i = this.i.size();
            if (i > 0) {
                backStackStateArr = new BackStackState[i];
                for (i2 = 0; i2 < i; i2++) {
                    backStackStateArr[i2] = new BackStackState((f) this.i.get(i2));
                    if (a) {
                        new StringBuilder("saveAllState: adding back stack #").append(i2).append(": ").append(this.i.get(i2));
                    }
                }
            }
        }
        fragmentManagerState = new FragmentManagerState();
        fragmentManagerState.a = fragmentStateArr;
        fragmentManagerState.b = iArr;
        fragmentManagerState.c = backStackStateArr;
        return fragmentManagerState;
    }

    final void a(Parcelable parcelable, ac acVar) {
        if (parcelable != null) {
            FragmentManagerState fragmentManagerState = (FragmentManagerState) parcelable;
            if (fragmentManagerState.a != null) {
                List list;
                int size;
                int i;
                Fragment fragment;
                List list2;
                if (acVar != null) {
                    list = acVar.a;
                    List list3 = acVar.b;
                    if (list != null) {
                        size = list.size();
                    } else {
                        boolean z = false;
                    }
                    for (i = 0; i < size; i++) {
                        fragment = (Fragment) list.get(i);
                        if (a) {
                            new StringBuilder("restoreAllState: re-attaching retained ").append(fragment);
                        }
                        FragmentState fragmentState = fragmentManagerState.a[fragment.p];
                        fragmentState.l = fragment;
                        fragment.o = null;
                        fragment.A = 0;
                        fragment.y = false;
                        fragment.v = false;
                        fragment.s = null;
                        if (fragmentState.k != null) {
                            fragmentState.k.setClassLoader(this.o.c.getClassLoader());
                            fragment.o = fragmentState.k.getSparseParcelableArray("android:view_state");
                            fragment.n = fragmentState.k;
                        }
                    }
                    list2 = list3;
                } else {
                    list2 = null;
                }
                this.f = new ArrayList(fragmentManagerState.a.length);
                if (this.h != null) {
                    this.h.clear();
                }
                int i2 = 0;
                while (i2 < fragmentManagerState.a.length) {
                    FragmentState fragmentState2 = fragmentManagerState.a[i2];
                    if (fragmentState2 != null) {
                        ac acVar2;
                        if (list2 == null || i2 >= list2.size()) {
                            acVar2 = null;
                        } else {
                            acVar2 = (ac) list2.get(i2);
                        }
                        t tVar = this.o;
                        Fragment fragment2 = this.q;
                        if (fragmentState2.l == null) {
                            Context context = tVar.c;
                            if (fragmentState2.i != null) {
                                fragmentState2.i.setClassLoader(context.getClassLoader());
                            }
                            fragmentState2.l = Fragment.a(context, fragmentState2.a, fragmentState2.i);
                            if (fragmentState2.k != null) {
                                fragmentState2.k.setClassLoader(context.getClassLoader());
                                fragmentState2.l.n = fragmentState2.k;
                            }
                            fragmentState2.l.a(fragmentState2.b, fragment2);
                            fragmentState2.l.x = fragmentState2.c;
                            fragmentState2.l.z = true;
                            fragmentState2.l.G = fragmentState2.d;
                            fragmentState2.l.H = fragmentState2.e;
                            fragmentState2.l.I = fragmentState2.f;
                            fragmentState2.l.L = fragmentState2.g;
                            fragmentState2.l.K = fragmentState2.h;
                            fragmentState2.l.J = fragmentState2.j;
                            fragmentState2.l.B = tVar.f;
                            if (a) {
                                new StringBuilder("Instantiated fragment ").append(fragmentState2.l);
                            }
                        }
                        fragmentState2.l.E = acVar2;
                        fragment = fragmentState2.l;
                        if (a) {
                            new StringBuilder("restoreAllState: active #").append(i2).append(": ").append(fragment);
                        }
                        this.f.add(fragment);
                        fragmentState2.l = null;
                    } else {
                        this.f.add(null);
                        if (this.h == null) {
                            this.h = new ArrayList();
                        }
                        this.h.add(Integer.valueOf(i2));
                    }
                    i2++;
                }
                if (acVar != null) {
                    list = acVar.a;
                    if (list != null) {
                        i2 = list.size();
                    } else {
                        boolean z2 = false;
                    }
                    for (i = 0; i < i2; i++) {
                        fragment = (Fragment) list.get(i);
                        if (fragment.t >= 0) {
                            if (fragment.t < this.f.size()) {
                                fragment.s = (Fragment) this.f.get(fragment.t);
                            } else {
                                Log.w("FragmentManager", "Re-attaching retained fragment " + fragment + " target no longer exists: " + fragment.t);
                                fragment.s = null;
                            }
                        }
                    }
                }
                if (fragmentManagerState.b != null) {
                    this.g = new ArrayList(fragmentManagerState.b.length);
                    for (size = 0; size < fragmentManagerState.b.length; size++) {
                        fragment = (Fragment) this.f.get(fragmentManagerState.b[size]);
                        if (fragment == null) {
                            a(new IllegalStateException("No instantiated fragment for index #" + fragmentManagerState.b[size]));
                        }
                        fragment.v = true;
                        if (a) {
                            new StringBuilder("restoreAllState: added #").append(size).append(": ").append(fragment);
                        }
                        if (this.g.contains(fragment)) {
                            throw new IllegalStateException("Already added!");
                        }
                        this.g.add(fragment);
                    }
                } else {
                    this.g = null;
                }
                if (fragmentManagerState.c != null) {
                    this.i = new ArrayList(fragmentManagerState.c.length);
                    for (int i3 = 0; i3 < fragmentManagerState.c.length; i3++) {
                        f a = fragmentManagerState.c[i3].a(this);
                        if (a) {
                            new StringBuilder("restoreAllState: back stack #").append(i3).append(" (index ").append(a.p).append("): ").append(a);
                            a.a("  ", new PrintWriter(new e("FragmentManager")), false);
                        }
                        this.i.add(a);
                        if (a.p >= 0) {
                            a(a.p, a);
                        }
                    }
                    return;
                }
                this.i = null;
            }
        }
    }

    public final void a(t tVar, r rVar, Fragment fragment) {
        if (this.o != null) {
            throw new IllegalStateException("Already attached");
        }
        this.o = tVar;
        this.p = rVar;
        this.q = fragment;
    }

    public final void g() {
        this.t = false;
        b(1);
    }

    public final void h() {
        this.t = false;
        b(2);
    }

    public final void i() {
        this.t = false;
        b(4);
    }

    public final void j() {
        this.t = false;
        b(5);
    }

    public final void k() {
        this.t = true;
        b(3);
    }

    public final void l() {
        this.u = true;
        c();
        b(0);
        this.o = null;
        this.p = null;
        this.q = null;
    }

    public final void a(boolean z) {
        if (this.g != null) {
            for (int size = this.g.size() - 1; size >= 0; size--) {
                Fragment fragment = (Fragment) this.g.get(size);
                if (!(fragment == null || fragment.D == null)) {
                    fragment.D.a(z);
                }
            }
        }
    }

    public final void b(boolean z) {
        if (this.g != null) {
            for (int size = this.g.size() - 1; size >= 0; size--) {
                Fragment fragment = (Fragment) this.g.get(size);
                if (!(fragment == null || fragment.D == null)) {
                    fragment.D.b(z);
                }
            }
        }
    }

    public final void a(Configuration configuration) {
        if (this.g != null) {
            for (int i = 0; i < this.g.size(); i++) {
                Fragment fragment = (Fragment) this.g.get(i);
                if (fragment != null) {
                    fragment.onConfigurationChanged(configuration);
                    if (fragment.D != null) {
                        fragment.D.a(configuration);
                    }
                }
            }
        }
    }

    public final void m() {
        if (this.g != null) {
            for (int i = 0; i < this.g.size(); i++) {
                Fragment fragment = (Fragment) this.g.get(i);
                if (fragment != null) {
                    fragment.onLowMemory();
                    if (fragment.D != null) {
                        fragment.D.m();
                    }
                }
            }
        }
    }

    public final boolean a(Menu menu, MenuInflater menuInflater) {
        boolean z;
        int i = 0;
        ArrayList arrayList = null;
        if (this.g != null) {
            int i2 = 0;
            z = false;
            while (i2 < this.g.size()) {
                boolean z2;
                Fragment fragment = (Fragment) this.g.get(i2);
                if (fragment != null) {
                    int i3;
                    if (fragment.J) {
                        i3 = 0;
                    } else {
                        if (fragment.N && fragment.O) {
                            i3 = 1;
                        } else {
                            i3 = 0;
                        }
                        if (fragment.D != null) {
                            i3 |= fragment.D.a(menu, menuInflater);
                        }
                    }
                    if (i3 != 0) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(fragment);
                        z2 = true;
                        i2++;
                        z = z2;
                    }
                }
                z2 = z;
                i2++;
                z = z2;
            }
        } else {
            z = false;
        }
        if (this.j != null) {
            while (i < this.j.size()) {
                fragment = (Fragment) this.j.get(i);
                if (arrayList == null || !arrayList.contains(fragment)) {
                    Fragment.n();
                }
                i++;
            }
        }
        this.j = arrayList;
        return z;
    }

    public final boolean a(Menu menu) {
        if (this.g == null) {
            return false;
        }
        boolean z = false;
        for (int i = 0; i < this.g.size(); i++) {
            Fragment fragment = (Fragment) this.g.get(i);
            if (fragment != null) {
                int i2;
                if (fragment.J) {
                    i2 = 0;
                } else {
                    if (fragment.N && fragment.O) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    if (fragment.D != null) {
                        i2 |= fragment.D.a(menu);
                    }
                }
                if (i2 != 0) {
                    z = true;
                }
            }
        }
        return z;
    }

    public final boolean a(MenuItem menuItem) {
        if (this.g == null) {
            return false;
        }
        for (int i = 0; i < this.g.size(); i++) {
            Fragment fragment = (Fragment) this.g.get(i);
            if (fragment != null) {
                boolean z;
                if (fragment.J || fragment.D == null || !fragment.D.a(menuItem)) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean b(MenuItem menuItem) {
        if (this.g == null) {
            return false;
        }
        for (int i = 0; i < this.g.size(); i++) {
            Fragment fragment = (Fragment) this.g.get(i);
            if (fragment != null) {
                boolean z;
                if (fragment.J || fragment.D == null || !fragment.D.b(menuItem)) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void b(Menu menu) {
        if (this.g != null) {
            for (int i = 0; i < this.g.size(); i++) {
                Fragment fragment = (Fragment) this.g.get(i);
                if (!(fragment == null || fragment.J || fragment.D == null)) {
                    fragment.D.b(menu);
                }
            }
        }
    }

    public static int c(int i) {
        switch (i) {
            case 4097:
                return 8194;
            case 4099:
                return 4099;
            case 8194:
                return 4097;
            default:
                return 0;
        }
    }

    public final View a(View view, String str, Context context, AttributeSet attributeSet) {
        if (!"fragment".equals(str)) {
            return null;
        }
        String string;
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, aa.a);
        if (attributeValue == null) {
            string = obtainStyledAttributes.getString(0);
        } else {
            string = attributeValue;
        }
        int resourceId = obtainStyledAttributes.getResourceId(1, -1);
        String string2 = obtainStyledAttributes.getString(2);
        obtainStyledAttributes.recycle();
        if (!Fragment.b(this.o.c, string)) {
            return null;
        }
        int id;
        if (view != null) {
            id = view.getId();
        } else {
            id = 0;
        }
        if (id == -1 && resourceId == -1 && string2 == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + string);
        }
        Fragment fragment;
        Fragment d = resourceId != -1 ? d(resourceId) : null;
        if (d == null && string2 != null) {
            d = b(string2);
        }
        if (d == null && id != -1) {
            d = d(id);
        }
        if (a) {
            new StringBuilder("onCreateView: id=0x").append(Integer.toHexString(resourceId)).append(" fname=").append(string).append(" existing=").append(d);
        }
        if (d == null) {
            Fragment a = Fragment.a(context, string);
            a.x = true;
            a.G = resourceId != 0 ? resourceId : id;
            a.H = id;
            a.I = string2;
            a.y = true;
            a.B = this;
            a.C = this.o;
            Bundle bundle = a.n;
            a.j();
            a(a, true);
            fragment = a;
        } else if (d.y) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string2 + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + string);
        } else {
            d.y = true;
            d.C = this.o;
            if (!d.M) {
                Bundle bundle2 = d.n;
                d.j();
            }
            fragment = d;
        }
        if (this.n > 0 || !fragment.x) {
            b(fragment);
        } else {
            a(fragment, 1, 0, 0, false);
        }
        if (fragment.S == null) {
            throw new IllegalStateException("Fragment " + string + " did not create a view.");
        }
        if (resourceId != 0) {
            fragment.S.setId(resourceId);
        }
        if (fragment.S.getTag() == null) {
            fragment.S.setTag(string2);
        }
        return fragment.S;
    }
}
