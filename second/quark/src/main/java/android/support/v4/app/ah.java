package android.support.v4.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.d.c;
import android.support.v4.d.f;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.a;
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
final class ah extends be implements a {
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
    ArrayList<an> i;
    ArrayList<Fragment> j;
    ArrayList<an> k;
    ArrayList<Integer> l;
    ArrayList<Object> m;
    int n = 0;
    bm o;
    cp p;
    Fragment q;
    boolean s;
    boolean t;
    boolean u;
    String v;
    boolean w;
    Bundle x = null;
    SparseArray<Parcelable> y = null;
    Runnable z = new bs(this);

    ah() {
    }

    static {
        boolean z = false;
        if (VERSION.SDK_INT >= 11) {
            z = true;
        }
        b = z;
    }

    static boolean a(View view, Animation animation) {
        if (VERSION.SDK_INT < 19 || ViewCompat.g(view) != 0 || !ViewCompat.y(view)) {
            return false;
        }
        boolean z;
        if (animation instanceof AlphaAnimation) {
            z = true;
        } else {
            if (animation instanceof AnimationSet) {
                List animations = ((AnimationSet) animation).getAnimations();
                for (int i = 0; i < animations.size(); i++) {
                    if (animations.get(i) instanceof AlphaAnimation) {
                        z = true;
                        break;
                    }
                }
            }
            z = false;
        }
        if (z) {
            return true;
        }
        return false;
    }

    private void a(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new c("FragmentManager"));
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

    public final ay a() {
        return new an(this);
    }

    public final boolean b() {
        return e();
    }

    public final boolean c() {
        d();
        e();
        if (this.i == null) {
            return false;
        }
        int size = this.i.size() - 1;
        if (size < 0) {
            return false;
        }
        an anVar = (an) this.i.remove(size);
        SparseArray sparseArray = new SparseArray();
        SparseArray sparseArray2 = new SparseArray();
        anVar.a(sparseArray, sparseArray2);
        anVar.a(null, sparseArray, sparseArray2);
        f();
        return true;
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
            f.a(this.q, stringBuilder);
        } else {
            f.a(this.o, stringBuilder);
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
                        printWriter.print(Integer.toHexString(fragment.A));
                        printWriter.print(" mContainerId=#");
                        printWriter.print(Integer.toHexString(fragment.B));
                        printWriter.print(" mTag=");
                        printWriter.println(fragment.C);
                        printWriter.print(str2);
                        printWriter.print("mState=");
                        printWriter.print(fragment.f);
                        printWriter.print(" mIndex=");
                        printWriter.print(fragment.k);
                        printWriter.print(" mWho=");
                        printWriter.print(fragment.l);
                        printWriter.print(" mBackStackNesting=");
                        printWriter.println(fragment.v);
                        printWriter.print(str2);
                        printWriter.print("mAdded=");
                        printWriter.print(fragment.q);
                        printWriter.print(" mRemoving=");
                        printWriter.print(fragment.r);
                        printWriter.print(" mFromLayout=");
                        printWriter.print(fragment.s);
                        printWriter.print(" mInLayout=");
                        printWriter.println(fragment.t);
                        printWriter.print(str2);
                        printWriter.print("mHidden=");
                        printWriter.print(fragment.D);
                        printWriter.print(" mDetached=");
                        printWriter.print(fragment.E);
                        printWriter.print(" mMenuVisible=");
                        printWriter.print(fragment.I);
                        printWriter.print(" mHasMenu=");
                        printWriter.println(fragment.H);
                        printWriter.print(str2);
                        printWriter.print("mRetainInstance=");
                        printWriter.print(fragment.F);
                        printWriter.print(" mRetaining=");
                        printWriter.print(fragment.G);
                        printWriter.print(" mUserVisibleHint=");
                        printWriter.println(fragment.P);
                        if (fragment.w != null) {
                            printWriter.print(str2);
                            printWriter.print("mFragmentManager=");
                            printWriter.println(fragment.w);
                        }
                        if (fragment.x != null) {
                            printWriter.print(str2);
                            printWriter.print("mHost=");
                            printWriter.println(fragment.x);
                        }
                        if (fragment.z != null) {
                            printWriter.print(str2);
                            printWriter.print("mParentFragment=");
                            printWriter.println(fragment.z);
                        }
                        if (fragment.m != null) {
                            printWriter.print(str2);
                            printWriter.print("mArguments=");
                            printWriter.println(fragment.m);
                        }
                        if (fragment.i != null) {
                            printWriter.print(str2);
                            printWriter.print("mSavedFragmentState=");
                            printWriter.println(fragment.i);
                        }
                        if (fragment.j != null) {
                            printWriter.print(str2);
                            printWriter.print("mSavedViewState=");
                            printWriter.println(fragment.j);
                        }
                        if (fragment.n != null) {
                            printWriter.print(str2);
                            printWriter.print("mTarget=");
                            printWriter.print(fragment.n);
                            printWriter.print(" mTargetRequestCode=");
                            printWriter.println(fragment.p);
                        }
                        if (fragment.K != 0) {
                            printWriter.print(str2);
                            printWriter.print("mNextAnim=");
                            printWriter.println(fragment.K);
                        }
                        if (fragment.L != null) {
                            printWriter.print(str2);
                            printWriter.print("mContainer=");
                            printWriter.println(fragment.L);
                        }
                        if (fragment.M != null) {
                            printWriter.print(str2);
                            printWriter.print("mView=");
                            printWriter.println(fragment.M);
                        }
                        if (fragment.N != null) {
                            printWriter.print(str2);
                            printWriter.print("mInnerView=");
                            printWriter.println(fragment.M);
                        }
                        if (fragment.g != null) {
                            printWriter.print(str2);
                            printWriter.print("mAnimatingAway=");
                            printWriter.println(fragment.g);
                            printWriter.print(str2);
                            printWriter.print("mStateAfterAnimating=");
                            printWriter.println(fragment.h);
                        }
                        if (fragment.Q != null) {
                            printWriter.print(str2);
                            printWriter.println("Loader Manager:");
                            fragment.Q.a(str2 + "  ", fileDescriptor, printWriter);
                        }
                        if (fragment.y != null) {
                            printWriter.print(str2);
                            printWriter.println("Child " + fragment.y + ":");
                            fragment.y.a(str2 + "  ", fileDescriptor, printWriter, strArr);
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
                    an anVar = (an) this.i.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(anVar.toString());
                    anVar.a(str2, printWriter);
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
                        anVar = (an) this.k.get(i);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i);
                        printWriter.print(": ");
                        printWriter.println(anVar);
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
        int i3 = fragment.K;
        Fragment.l();
        if (fragment.K != 0) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.o.b, fragment.K);
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

    private static void b(View view, Animation animation) {
        if (view != null && animation != null && a(view, animation)) {
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
            animation.setAnimationListener(new bz(view, animation, animationListener));
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final void a(android.support.v4.app.Fragment r11, int r12, int r13, int r14, boolean r15) {
        /*
        r10 = this;
        r9 = 4;
        r6 = 3;
        r5 = 1;
        r7 = 0;
        r3 = 0;
        r0 = r11.q;
        if (r0 == 0) goto L_0x000d;
    L_0x0009:
        r0 = r11.E;
        if (r0 == 0) goto L_0x0010;
    L_0x000d:
        if (r12 <= r5) goto L_0x0010;
    L_0x000f:
        r12 = r5;
    L_0x0010:
        r0 = r11.r;
        if (r0 == 0) goto L_0x001a;
    L_0x0014:
        r0 = r11.f;
        if (r12 <= r0) goto L_0x001a;
    L_0x0018:
        r12 = r11.f;
    L_0x001a:
        r0 = r11.O;
        if (r0 == 0) goto L_0x0025;
    L_0x001e:
        r0 = r11.f;
        if (r0 >= r9) goto L_0x0025;
    L_0x0022:
        if (r12 <= r6) goto L_0x0025;
    L_0x0024:
        r12 = r6;
    L_0x0025:
        r0 = r11.f;
        if (r0 >= r12) goto L_0x039e;
    L_0x0029:
        r0 = r11.s;
        if (r0 == 0) goto L_0x0032;
    L_0x002d:
        r0 = r11.t;
        if (r0 != 0) goto L_0x0032;
    L_0x0031:
        return;
    L_0x0032:
        r0 = r11.g;
        if (r0 == 0) goto L_0x0040;
    L_0x0036:
        r11.g = r7;
        r2 = r11.h;
        r0 = r10;
        r1 = r11;
        r4 = r3;
        r0.a(r1, r2, r3, r4, r5);
    L_0x0040:
        r0 = r11.f;
        switch(r0) {
            case 0: goto L_0x0076;
            case 1: goto L_0x0198;
            case 2: goto L_0x02f2;
            case 3: goto L_0x02f2;
            case 4: goto L_0x0347;
            default: goto L_0x0045;
        };
    L_0x0045:
        r0 = r11.f;
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
        r2 = r11.f;
        r1 = r1.append(r2);
        r1 = r1.toString();
        android.util.Log.w(r0, r1);
        r11.f = r12;
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
        r0 = r11.i;
        if (r0 == 0) goto L_0x00ca;
    L_0x0088:
        r0 = r11.i;
        r1 = r10.o;
        r1 = r1.b;
        r1 = r1.getClassLoader();
        r0.setClassLoader(r1);
        r0 = r11.i;
        r1 = "android:view_state";
        r0 = r0.getSparseParcelableArray(r1);
        r11.j = r0;
        r0 = r11.i;
        r1 = "android:target_state";
        r0 = r10.a(r0, r1);
        r11.n = r0;
        r0 = r11.n;
        if (r0 == 0) goto L_0x00b7;
    L_0x00ad:
        r0 = r11.i;
        r1 = "android:target_req_state";
        r0 = r0.getInt(r1, r3);
        r11.p = r0;
    L_0x00b7:
        r0 = r11.i;
        r1 = "android:user_visible_hint";
        r0 = r0.getBoolean(r1, r5);
        r11.P = r0;
        r0 = r11.P;
        if (r0 != 0) goto L_0x00ca;
    L_0x00c5:
        r11.O = r5;
        if (r12 <= r6) goto L_0x00ca;
    L_0x00c9:
        r12 = r6;
    L_0x00ca:
        r0 = r10.o;
        r11.x = r0;
        r0 = r10.q;
        r11.z = r0;
        r0 = r10.q;
        if (r0 == 0) goto L_0x0104;
    L_0x00d6:
        r0 = r10.q;
        r0 = r0.y;
    L_0x00da:
        r11.w = r0;
        r11.J = r3;
        r0 = r10.o;
        r0 = r0.b;
        r11.a(r0);
        r0 = r11.J;
        if (r0 != 0) goto L_0x0109;
    L_0x00e9:
        r0 = new android.support.v4.app.aq;
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
        r0 = r0.e;
        goto L_0x00da;
    L_0x0109:
        r0 = r11.z;
        if (r0 != 0) goto L_0x0112;
    L_0x010d:
        r0 = r10.o;
        r0.g();
    L_0x0112:
        r0 = r11.G;
        if (r0 != 0) goto L_0x0160;
    L_0x0116:
        r0 = r11.i;
        r1 = r11.y;
        if (r1 == 0) goto L_0x0120;
    L_0x011c:
        r1 = r11.y;
        r1.t = r3;
    L_0x0120:
        r11.f = r5;
        r11.J = r3;
        r11.J = r5;
        r1 = r11.J;
        if (r1 != 0) goto L_0x0145;
    L_0x012a:
        r0 = new android.support.v4.app.aq;
        r1 = new java.lang.StringBuilder;
        r2 = "Fragment ";
        r1.<init>(r2);
        r1 = r1.append(r11);
        r2 = " did not call through to super.onCreate()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0145:
        if (r0 == 0) goto L_0x0160;
    L_0x0147:
        r1 = "android:support:fragments";
        r0 = r0.getParcelable(r1);
        if (r0 == 0) goto L_0x0160;
    L_0x014f:
        r1 = r11.y;
        if (r1 != 0) goto L_0x0156;
    L_0x0153:
        r11.o();
    L_0x0156:
        r1 = r11.y;
        r1.a(r0, r7);
        r0 = r11.y;
        r0.h();
    L_0x0160:
        r11.G = r3;
        r0 = r11.s;
        if (r0 == 0) goto L_0x0198;
    L_0x0166:
        r0 = r11.i;
        r11.j();
        r0 = r11.i;
        r0 = r11.p();
        r11.M = r0;
        r0 = r11.M;
        if (r0 == 0) goto L_0x0201;
    L_0x0177:
        r0 = r11.M;
        r11.N = r0;
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 11;
        if (r0 < r1) goto L_0x01f8;
    L_0x0181:
        r0 = r11.M;
        android.support.v4.view.ViewCompat.x(r0);
    L_0x0186:
        r0 = r11.D;
        if (r0 == 0) goto L_0x0191;
    L_0x018a:
        r0 = r11.M;
        r1 = 8;
        r0.setVisibility(r1);
    L_0x0191:
        r0 = r11.M;
        r0 = r11.i;
        android.support.v4.app.Fragment.m();
    L_0x0198:
        if (r12 <= r5) goto L_0x02f2;
    L_0x019a:
        r0 = a;
        if (r0 == 0) goto L_0x01a8;
    L_0x019e:
        r0 = new java.lang.StringBuilder;
        r1 = "moveto ACTIVITY_CREATED: ";
        r0.<init>(r1);
        r0.append(r11);
    L_0x01a8:
        r0 = r11.s;
        if (r0 != 0) goto L_0x0275;
    L_0x01ac:
        r0 = r11.B;
        if (r0 == 0) goto L_0x0612;
    L_0x01b0:
        r0 = r10.p;
        r1 = r11.B;
        r0 = r0.a(r1);
        r0 = (android.view.ViewGroup) r0;
        if (r0 != 0) goto L_0x022a;
    L_0x01bc:
        r1 = r11.u;
        if (r1 != 0) goto L_0x022a;
    L_0x01c0:
        r1 = new java.lang.IllegalArgumentException;
        r2 = new java.lang.StringBuilder;
        r4 = "No view found for id 0x";
        r2.<init>(r4);
        r4 = r11.B;
        r4 = java.lang.Integer.toHexString(r4);
        r2 = r2.append(r4);
        r4 = " (";
        r2 = r2.append(r4);
        r4 = r11.x;
        if (r4 != 0) goto L_0x0204;
    L_0x01dd:
        r0 = new java.lang.IllegalStateException;
        r1 = new java.lang.StringBuilder;
        r2 = "Fragment ";
        r1.<init>(r2);
        r1 = r1.append(r11);
        r2 = " not attached to Activity";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x01f8:
        r0 = r11.M;
        r0 = android.support.v4.app.cc.a(r0);
        r11.M = r0;
        goto L_0x0186;
    L_0x0201:
        r11.N = r7;
        goto L_0x0198;
    L_0x0204:
        r4 = r11.x;
        r4 = r4.b;
        r4 = r4.getResources();
        r8 = r11.B;
        r4 = r4.getResourceName(r8);
        r2 = r2.append(r4);
        r4 = ") for fragment ";
        r2 = r2.append(r4);
        r2 = r2.append(r11);
        r2 = r2.toString();
        r1.<init>(r2);
        r10.a(r1);
    L_0x022a:
        r11.L = r0;
        r1 = r11.i;
        r11.j();
        r1 = r11.i;
        r1 = r11.p();
        r11.M = r1;
        r1 = r11.M;
        if (r1 == 0) goto L_0x02ae;
    L_0x023d:
        r1 = r11.M;
        r11.N = r1;
        r1 = android.os.Build.VERSION.SDK_INT;
        r2 = 11;
        if (r1 < r2) goto L_0x02a5;
    L_0x0247:
        r1 = r11.M;
        android.support.v4.view.ViewCompat.x(r1);
    L_0x024c:
        if (r0 == 0) goto L_0x0263;
    L_0x024e:
        r1 = r10.a(r11, r13, r5, r14);
        if (r1 == 0) goto L_0x025e;
    L_0x0254:
        r2 = r11.M;
        b(r2, r1);
        r2 = r11.M;
        r2.startAnimation(r1);
    L_0x025e:
        r1 = r11.M;
        r0.addView(r1);
    L_0x0263:
        r0 = r11.D;
        if (r0 == 0) goto L_0x026e;
    L_0x0267:
        r0 = r11.M;
        r1 = 8;
        r0.setVisibility(r1);
    L_0x026e:
        r0 = r11.M;
        r0 = r11.i;
        android.support.v4.app.Fragment.m();
    L_0x0275:
        r0 = r11.i;
        r0 = r11.y;
        if (r0 == 0) goto L_0x027f;
    L_0x027b:
        r0 = r11.y;
        r0.t = r3;
    L_0x027f:
        r0 = 2;
        r11.f = r0;
        r11.J = r3;
        r11.J = r5;
        r0 = r11.J;
        if (r0 != 0) goto L_0x02b1;
    L_0x028a:
        r0 = new android.support.v4.app.aq;
        r1 = new java.lang.StringBuilder;
        r2 = "Fragment ";
        r1.<init>(r2);
        r1 = r1.append(r11);
        r2 = " did not call through to super.onActivityCreated()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x02a5:
        r1 = r11.M;
        r1 = android.support.v4.app.cc.a(r1);
        r11.M = r1;
        goto L_0x024c;
    L_0x02ae:
        r11.N = r7;
        goto L_0x0275;
    L_0x02b1:
        r0 = r11.y;
        if (r0 == 0) goto L_0x02ba;
    L_0x02b5:
        r0 = r11.y;
        r0.i();
    L_0x02ba:
        r0 = r11.M;
        if (r0 == 0) goto L_0x02f0;
    L_0x02be:
        r0 = r11.i;
        r0 = r11.j;
        if (r0 == 0) goto L_0x02cd;
    L_0x02c4:
        r0 = r11.N;
        r1 = r11.j;
        r0.restoreHierarchyState(r1);
        r11.j = r7;
    L_0x02cd:
        r11.J = r3;
        r11.J = r5;
        r0 = r11.J;
        if (r0 != 0) goto L_0x02f0;
    L_0x02d5:
        r0 = new android.support.v4.app.aq;
        r1 = new java.lang.StringBuilder;
        r2 = "Fragment ";
        r1.<init>(r2);
        r1 = r1.append(r11);
        r2 = " did not call through to super.onViewStateRestored()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x02f0:
        r11.i = r7;
    L_0x02f2:
        if (r12 <= r6) goto L_0x0347;
    L_0x02f4:
        r0 = a;
        if (r0 == 0) goto L_0x0302;
    L_0x02f8:
        r0 = new java.lang.StringBuilder;
        r1 = "moveto STARTED: ";
        r0.<init>(r1);
        r0.append(r11);
    L_0x0302:
        r0 = r11.y;
        if (r0 == 0) goto L_0x030f;
    L_0x0306:
        r0 = r11.y;
        r0.t = r3;
        r0 = r11.y;
        r0.e();
    L_0x030f:
        r11.f = r9;
        r11.J = r3;
        r11.b();
        r0 = r11.J;
        if (r0 != 0) goto L_0x0335;
    L_0x031a:
        r0 = new android.support.v4.app.aq;
        r1 = new java.lang.StringBuilder;
        r2 = "Fragment ";
        r1.<init>(r2);
        r1 = r1.append(r11);
        r2 = " did not call through to super.onStart()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0335:
        r0 = r11.y;
        if (r0 == 0) goto L_0x033e;
    L_0x0339:
        r0 = r11.y;
        r0.j();
    L_0x033e:
        r0 = r11.Q;
        if (r0 == 0) goto L_0x0347;
    L_0x0342:
        r0 = r11.Q;
        r0.f();
    L_0x0347:
        if (r12 <= r9) goto L_0x0045;
    L_0x0349:
        r0 = a;
        if (r0 == 0) goto L_0x0357;
    L_0x034d:
        r0 = new java.lang.StringBuilder;
        r1 = "moveto RESUMED: ";
        r0.<init>(r1);
        r0.append(r11);
    L_0x0357:
        r0 = r11.y;
        if (r0 == 0) goto L_0x0364;
    L_0x035b:
        r0 = r11.y;
        r0.t = r3;
        r0 = r11.y;
        r0.e();
    L_0x0364:
        r0 = 5;
        r11.f = r0;
        r11.J = r3;
        r11.J = r5;
        r0 = r11.J;
        if (r0 != 0) goto L_0x038a;
    L_0x036f:
        r0 = new android.support.v4.app.aq;
        r1 = new java.lang.StringBuilder;
        r2 = "Fragment ";
        r1.<init>(r2);
        r1 = r1.append(r11);
        r2 = " did not call through to super.onResume()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x038a:
        r0 = r11.y;
        if (r0 == 0) goto L_0x0398;
    L_0x038e:
        r0 = r11.y;
        r0.k();
        r0 = r11.y;
        r0.e();
    L_0x0398:
        r11.i = r7;
        r11.j = r7;
        goto L_0x0045;
    L_0x039e:
        r0 = r11.f;
        if (r0 <= r12) goto L_0x0045;
    L_0x03a2:
        r0 = r11.f;
        switch(r0) {
            case 1: goto L_0x03a9;
            case 2: goto L_0x0485;
            case 3: goto L_0x0441;
            case 4: goto L_0x0402;
            case 5: goto L_0x03c3;
            default: goto L_0x03a7;
        };
    L_0x03a7:
        goto L_0x0045;
    L_0x03a9:
        if (r12 > 0) goto L_0x0045;
    L_0x03ab:
        r0 = r10.u;
        if (r0 == 0) goto L_0x03ba;
    L_0x03af:
        r0 = r11.g;
        if (r0 == 0) goto L_0x03ba;
    L_0x03b3:
        r0 = r11.g;
        r11.g = r7;
        r0.clearAnimation();
    L_0x03ba:
        r0 = r11.g;
        if (r0 == 0) goto L_0x0520;
    L_0x03be:
        r11.h = r12;
        r12 = r5;
        goto L_0x0045;
    L_0x03c3:
        r0 = 5;
        if (r12 >= r0) goto L_0x0402;
    L_0x03c6:
        r0 = a;
        if (r0 == 0) goto L_0x03d4;
    L_0x03ca:
        r0 = new java.lang.StringBuilder;
        r1 = "movefrom RESUMED: ";
        r0.<init>(r1);
        r0.append(r11);
    L_0x03d4:
        r0 = r11.y;
        if (r0 == 0) goto L_0x03dd;
    L_0x03d8:
        r0 = r11.y;
        r0.a(r9);
    L_0x03dd:
        r11.f = r9;
        r11.J = r3;
        r11.J = r5;
        r0 = r11.J;
        if (r0 != 0) goto L_0x0402;
    L_0x03e7:
        r0 = new android.support.v4.app.aq;
        r1 = new java.lang.StringBuilder;
        r2 = "Fragment ";
        r1.<init>(r2);
        r1 = r1.append(r11);
        r2 = " did not call through to super.onPause()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0402:
        if (r12 >= r9) goto L_0x0441;
    L_0x0404:
        r0 = a;
        if (r0 == 0) goto L_0x0412;
    L_0x0408:
        r0 = new java.lang.StringBuilder;
        r1 = "movefrom STARTED: ";
        r0.<init>(r1);
        r0.append(r11);
    L_0x0412:
        r0 = r11.y;
        if (r0 == 0) goto L_0x041b;
    L_0x0416:
        r0 = r11.y;
        r0.l();
    L_0x041b:
        r11.f = r6;
        r11.J = r3;
        r11.c();
        r0 = r11.J;
        if (r0 != 0) goto L_0x0441;
    L_0x0426:
        r0 = new android.support.v4.app.aq;
        r1 = new java.lang.StringBuilder;
        r2 = "Fragment ";
        r1.<init>(r2);
        r1 = r1.append(r11);
        r2 = " did not call through to super.onStop()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0441:
        if (r12 >= r6) goto L_0x0485;
    L_0x0443:
        r0 = a;
        if (r0 == 0) goto L_0x0451;
    L_0x0447:
        r0 = new java.lang.StringBuilder;
        r1 = "movefrom STOPPED: ";
        r0.<init>(r1);
        r0.append(r11);
    L_0x0451:
        r0 = r11.y;
        if (r0 == 0) goto L_0x045b;
    L_0x0455:
        r0 = r11.y;
        r1 = 2;
        r0.a(r1);
    L_0x045b:
        r0 = 2;
        r11.f = r0;
        r0 = r11.R;
        if (r0 == 0) goto L_0x0485;
    L_0x0462:
        r11.R = r3;
        r0 = r11.S;
        if (r0 != 0) goto L_0x0476;
    L_0x0468:
        r11.S = r5;
        r0 = r11.x;
        r1 = r11.l;
        r2 = r11.R;
        r0 = r0.a(r1);
        r11.Q = r0;
    L_0x0476:
        r0 = r11.Q;
        if (r0 == 0) goto L_0x0485;
    L_0x047a:
        r0 = r11.x;
        r0 = r0.g;
        if (r0 == 0) goto L_0x04d7;
    L_0x0480:
        r0 = r11.Q;
        r0.d();
    L_0x0485:
        r0 = 2;
        if (r12 >= r0) goto L_0x03a9;
    L_0x0488:
        r0 = a;
        if (r0 == 0) goto L_0x0496;
    L_0x048c:
        r0 = new java.lang.StringBuilder;
        r1 = "movefrom ACTIVITY_CREATED: ";
        r0.<init>(r1);
        r0.append(r11);
    L_0x0496:
        r0 = r11.M;
        if (r0 == 0) goto L_0x04a9;
    L_0x049a:
        r0 = r10.o;
        r0 = r0.b();
        if (r0 == 0) goto L_0x04a9;
    L_0x04a2:
        r0 = r11.j;
        if (r0 != 0) goto L_0x04a9;
    L_0x04a6:
        r10.c(r11);
    L_0x04a9:
        r0 = r11.y;
        if (r0 == 0) goto L_0x04b2;
    L_0x04ad:
        r0 = r11.y;
        r0.a(r5);
    L_0x04b2:
        r11.f = r5;
        r11.J = r3;
        r11.J = r5;
        r0 = r11.J;
        if (r0 != 0) goto L_0x04dd;
    L_0x04bc:
        r0 = new android.support.v4.app.aq;
        r1 = new java.lang.StringBuilder;
        r2 = "Fragment ";
        r1.<init>(r2);
        r1 = r1.append(r11);
        r2 = " did not call through to super.onDestroyView()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x04d7:
        r0 = r11.Q;
        r0.c();
        goto L_0x0485;
    L_0x04dd:
        r0 = r11.Q;
        if (r0 == 0) goto L_0x04e6;
    L_0x04e1:
        r0 = r11.Q;
        r0.e();
    L_0x04e6:
        r0 = r11.M;
        if (r0 == 0) goto L_0x0518;
    L_0x04ea:
        r0 = r11.L;
        if (r0 == 0) goto L_0x0518;
    L_0x04ee:
        r0 = r10.n;
        if (r0 <= 0) goto L_0x060f;
    L_0x04f2:
        r0 = r10.u;
        if (r0 != 0) goto L_0x060f;
    L_0x04f6:
        r0 = r10.a(r11, r13, r3, r14);
    L_0x04fa:
        if (r0 == 0) goto L_0x0511;
    L_0x04fc:
        r1 = r11.M;
        r11.g = r1;
        r11.h = r12;
        r1 = r11.M;
        r2 = new android.support.v4.app.bc;
        r2.<init>(r10, r1, r0, r11);
        r0.setAnimationListener(r2);
        r1 = r11.M;
        r1.startAnimation(r0);
    L_0x0511:
        r0 = r11.L;
        r1 = r11.M;
        r0.removeView(r1);
    L_0x0518:
        r11.L = r7;
        r11.M = r7;
        r11.N = r7;
        goto L_0x03a9;
    L_0x0520:
        r0 = a;
        if (r0 == 0) goto L_0x052e;
    L_0x0524:
        r0 = new java.lang.StringBuilder;
        r1 = "movefrom CREATED: ";
        r0.<init>(r1);
        r0.append(r11);
    L_0x052e:
        r0 = r11.G;
        if (r0 != 0) goto L_0x0561;
    L_0x0532:
        r0 = r11.y;
        if (r0 == 0) goto L_0x053b;
    L_0x0536:
        r0 = r11.y;
        r0.m();
    L_0x053b:
        r11.f = r3;
        r11.J = r3;
        r11.d();
        r0 = r11.J;
        if (r0 != 0) goto L_0x0563;
    L_0x0546:
        r0 = new android.support.v4.app.aq;
        r1 = new java.lang.StringBuilder;
        r2 = "Fragment ";
        r1.<init>(r2);
        r1 = r1.append(r11);
        r2 = " did not call through to super.onDestroy()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0561:
        r11.f = r3;
    L_0x0563:
        r11.J = r3;
        r11.a();
        r0 = r11.J;
        if (r0 != 0) goto L_0x0587;
    L_0x056c:
        r0 = new android.support.v4.app.aq;
        r1 = new java.lang.StringBuilder;
        r2 = "Fragment ";
        r1.<init>(r2);
        r1 = r1.append(r11);
        r2 = " did not call through to super.onDetach()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0587:
        if (r15 != 0) goto L_0x0045;
    L_0x0589:
        r0 = r11.G;
        if (r0 != 0) goto L_0x0605;
    L_0x058d:
        r0 = r11.k;
        if (r0 < 0) goto L_0x0045;
    L_0x0591:
        r0 = a;
        if (r0 == 0) goto L_0x059f;
    L_0x0595:
        r0 = new java.lang.StringBuilder;
        r1 = "Freeing fragment index ";
        r0.<init>(r1);
        r0.append(r11);
    L_0x059f:
        r0 = r10.f;
        r1 = r11.k;
        r0.set(r1, r7);
        r0 = r10.h;
        if (r0 != 0) goto L_0x05b1;
    L_0x05aa:
        r0 = new java.util.ArrayList;
        r0.<init>();
        r10.h = r0;
    L_0x05b1:
        r0 = r10.h;
        r1 = r11.k;
        r1 = java.lang.Integer.valueOf(r1);
        r0.add(r1);
        r1 = r10.o;
        r2 = r11.l;
        r0 = r1.f;
        if (r0 == 0) goto L_0x05da;
    L_0x05c4:
        r0 = r1.f;
        r0 = r0.get(r2);
        r0 = (android.support.v4.app.cs) r0;
        if (r0 == 0) goto L_0x05da;
    L_0x05ce:
        r4 = r0.f;
        if (r4 != 0) goto L_0x05da;
    L_0x05d2:
        r0.g();
        r0 = r1.f;
        r0.remove(r2);
    L_0x05da:
        r0 = -1;
        r11.k = r0;
        r11.l = r7;
        r11.q = r3;
        r11.r = r3;
        r11.s = r3;
        r11.t = r3;
        r11.u = r3;
        r11.v = r3;
        r11.w = r7;
        r11.y = r7;
        r11.x = r7;
        r11.A = r3;
        r11.B = r3;
        r11.C = r7;
        r11.D = r3;
        r11.E = r3;
        r11.G = r3;
        r11.Q = r7;
        r11.R = r3;
        r11.S = r3;
        goto L_0x0045;
    L_0x0605:
        r11.x = r7;
        r11.z = r7;
        r11.w = r7;
        r11.y = r7;
        goto L_0x0045;
    L_0x060f:
        r0 = r7;
        goto L_0x04fa;
    L_0x0612:
        r0 = r7;
        goto L_0x022a;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.ah.a(android.support.v4.app.Fragment, int, int, int, boolean):void");
    }

    private void b(Fragment fragment) {
        a(fragment, this.n, 0, 0, false);
    }

    final void a(int i) {
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
                        if (fragment.Q != null) {
                            a = i5 | fragment.Q.a();
                            i4++;
                            i5 = a;
                        }
                    }
                    a = i5;
                    i4++;
                    i5 = a;
                }
                if (i5 == 0) {
                    o();
                }
                if (this.s && this.o != null && this.n == 5) {
                    this.o.d();
                    this.s = false;
                }
            }
        }
    }

    private void o() {
        if (this.f != null) {
            for (int i = 0; i < this.f.size(); i++) {
                Fragment fragment = (Fragment) this.f.get(i);
                if (fragment != null && fragment.O) {
                    if (this.e) {
                        this.w = true;
                    } else {
                        fragment.O = false;
                        a(fragment, this.n, 0, 0, false);
                    }
                }
            }
        }
    }

    final void a(Fragment fragment) {
        if (fragment.k < 0) {
            if (this.h == null || this.h.size() <= 0) {
                if (this.f == null) {
                    this.f = new ArrayList();
                }
                fragment.a(this.f.size(), this.q);
                this.f.add(fragment);
            } else {
                fragment.a(((Integer) this.h.remove(this.h.size() - 1)).intValue(), this.q);
                this.f.set(fragment.k, fragment);
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
        if (!fragment.E) {
            if (this.g.contains(fragment)) {
                throw new IllegalStateException("Fragment already added: " + fragment);
            }
            this.g.add(fragment);
            fragment.q = true;
            fragment.r = false;
            if (fragment.H && fragment.I) {
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
            new StringBuilder("remove: ").append(fragment).append(" nesting=").append(fragment.v);
        }
        if (fragment.v > 0) {
            z = true;
        } else {
            z = false;
        }
        z = !z;
        if (!fragment.E || z) {
            int i3;
            if (this.g != null) {
                this.g.remove(fragment);
            }
            if (fragment.H && fragment.I) {
                this.s = true;
            }
            fragment.q = false;
            fragment.r = true;
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
        if (!fragment.D) {
            fragment.D = true;
            if (fragment.M != null) {
                Animation a = a(fragment, i, false, i2);
                if (a != null) {
                    b(fragment.M, a);
                    fragment.M.startAnimation(a);
                }
                fragment.M.setVisibility(8);
            }
            if (fragment.q && fragment.H && fragment.I) {
                this.s = true;
            }
            Fragment.g();
        }
    }

    public final void c(Fragment fragment, int i, int i2) {
        if (a) {
            new StringBuilder("show: ").append(fragment);
        }
        if (fragment.D) {
            fragment.D = false;
            if (fragment.M != null) {
                Animation a = a(fragment, i, true, i2);
                if (a != null) {
                    b(fragment.M, a);
                    fragment.M.startAnimation(a);
                }
                fragment.M.setVisibility(0);
            }
            if (fragment.q && fragment.H && fragment.I) {
                this.s = true;
            }
            Fragment.g();
        }
    }

    public final void d(Fragment fragment, int i, int i2) {
        if (a) {
            new StringBuilder("detach: ").append(fragment);
        }
        if (!fragment.E) {
            fragment.E = true;
            if (fragment.q) {
                if (this.g != null) {
                    if (a) {
                        new StringBuilder("remove from detach: ").append(fragment);
                    }
                    this.g.remove(fragment);
                }
                if (fragment.H && fragment.I) {
                    this.s = true;
                }
                fragment.q = false;
                a(fragment, 1, i, i2, false);
            }
        }
    }

    public final void e(Fragment fragment, int i, int i2) {
        if (a) {
            new StringBuilder("attach: ").append(fragment);
        }
        if (fragment.E) {
            fragment.E = false;
            if (!fragment.q) {
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
                fragment.q = true;
                if (fragment.H && fragment.I) {
                    this.s = true;
                }
                a(fragment, this.n, i, i2, false);
            }
        }
    }

    private Fragment c(int i) {
        int size;
        Fragment fragment;
        if (this.g != null) {
            for (size = this.g.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.g.get(size);
                if (fragment != null && fragment.A == i) {
                    return fragment;
                }
            }
        }
        if (this.f != null) {
            for (size = this.f.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.f.get(size);
                if (fragment != null && fragment.A == i) {
                    return fragment;
                }
            }
        }
        return null;
    }

    public final Fragment a(String str) {
        int size;
        Fragment fragment;
        if (!(this.g == null || str == null)) {
            for (size = this.g.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.g.get(size);
                if (fragment != null && str.equals(fragment.C)) {
                    return fragment;
                }
            }
        }
        if (!(this.f == null || str == null)) {
            for (size = this.f.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.f.get(size);
                if (fragment != null && str.equals(fragment.C)) {
                    return fragment;
                }
            }
        }
        return null;
    }

    public final Fragment b(String str) {
        if (!(this.f == null || str == null)) {
            for (int size = this.f.size() - 1; size >= 0; size--) {
                Fragment fragment = (Fragment) this.f.get(size);
                if (fragment != null) {
                    if (!str.equals(fragment.l)) {
                        fragment = fragment.y != null ? fragment.y.b(str) : null;
                    }
                    if (fragment != null) {
                        return fragment;
                    }
                }
            }
        }
        return null;
    }

    final void d() {
        if (this.t) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        } else if (this.v != null) {
            throw new IllegalStateException("Can not perform this action inside of " + this.v);
        }
    }

    public final int a(an anVar) {
        int size;
        synchronized (this) {
            if (this.l == null || this.l.size() <= 0) {
                if (this.k == null) {
                    this.k = new ArrayList();
                }
                size = this.k.size();
                if (a) {
                    new StringBuilder("Setting back stack index ").append(size).append(" to ").append(anVar);
                }
                this.k.add(anVar);
            } else {
                size = ((Integer) this.l.remove(this.l.size() - 1)).intValue();
                if (a) {
                    new StringBuilder("Adding back stack index ").append(size).append(" with ").append(anVar);
                }
                this.k.set(size, anVar);
            }
        }
        return size;
    }

    private void a(int i, an anVar) {
        synchronized (this) {
            if (this.k == null) {
                this.k = new ArrayList();
            }
            int size = this.k.size();
            if (i < size) {
                if (a) {
                    new StringBuilder("Setting back stack index ").append(i).append(" to ").append(anVar);
                }
                this.k.set(i, anVar);
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
                    new StringBuilder("Adding back stack index ").append(i).append(" with ").append(anVar);
                }
                this.k.add(anVar);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean e() {
        /*
        r6 = this;
        r0 = 1;
        r2 = 0;
        r1 = r6.e;
        if (r1 == 0) goto L_0x000e;
    L_0x0006:
        r0 = new java.lang.IllegalStateException;
        r1 = "Recursive entry to executePendingTransactions";
        r0.<init>(r1);
        throw r0;
    L_0x000e:
        r1 = android.os.Looper.myLooper();
        r3 = r6.o;
        r3 = r3.c;
        r3 = r3.getLooper();
        if (r1 == r3) goto L_0x0024;
    L_0x001c:
        r0 = new java.lang.IllegalStateException;
        r1 = "Must be called from main thread of process";
        r0.<init>(r1);
        throw r0;
    L_0x0024:
        r1 = r2;
    L_0x0025:
        monitor-enter(r6);
        r3 = r6.c;	 Catch:{ all -> 0x0097 }
        if (r3 == 0) goto L_0x0032;
    L_0x002a:
        r3 = r6.c;	 Catch:{ all -> 0x0097 }
        r3 = r3.size();	 Catch:{ all -> 0x0097 }
        if (r3 != 0) goto L_0x005a;
    L_0x0032:
        monitor-exit(r6);	 Catch:{ all -> 0x0097 }
        r0 = r6.w;
        if (r0 == 0) goto L_0x00a5;
    L_0x0037:
        r3 = r2;
        r4 = r2;
    L_0x0039:
        r0 = r6.f;
        r0 = r0.size();
        if (r3 >= r0) goto L_0x009e;
    L_0x0041:
        r0 = r6.f;
        r0 = r0.get(r3);
        r0 = (android.support.v4.app.Fragment) r0;
        if (r0 == 0) goto L_0x0056;
    L_0x004b:
        r5 = r0.Q;
        if (r5 == 0) goto L_0x0056;
    L_0x004f:
        r0 = r0.Q;
        r0 = r0.a();
        r4 = r4 | r0;
    L_0x0056:
        r0 = r3 + 1;
        r3 = r0;
        goto L_0x0039;
    L_0x005a:
        r1 = r6.c;	 Catch:{ all -> 0x0097 }
        r3 = r1.size();	 Catch:{ all -> 0x0097 }
        r1 = r6.d;	 Catch:{ all -> 0x0097 }
        if (r1 == 0) goto L_0x0069;
    L_0x0064:
        r1 = r6.d;	 Catch:{ all -> 0x0097 }
        r1 = r1.length;	 Catch:{ all -> 0x0097 }
        if (r1 >= r3) goto L_0x006d;
    L_0x0069:
        r1 = new java.lang.Runnable[r3];	 Catch:{ all -> 0x0097 }
        r6.d = r1;	 Catch:{ all -> 0x0097 }
    L_0x006d:
        r1 = r6.c;	 Catch:{ all -> 0x0097 }
        r4 = r6.d;	 Catch:{ all -> 0x0097 }
        r1.toArray(r4);	 Catch:{ all -> 0x0097 }
        r1 = r6.c;	 Catch:{ all -> 0x0097 }
        r1.clear();	 Catch:{ all -> 0x0097 }
        r1 = r6.o;	 Catch:{ all -> 0x0097 }
        r1 = r1.c;	 Catch:{ all -> 0x0097 }
        r4 = r6.z;	 Catch:{ all -> 0x0097 }
        r1.removeCallbacks(r4);	 Catch:{ all -> 0x0097 }
        monitor-exit(r6);	 Catch:{ all -> 0x0097 }
        r6.e = r0;
        r1 = r2;
    L_0x0086:
        if (r1 >= r3) goto L_0x009a;
    L_0x0088:
        r4 = r6.d;
        r4 = r4[r1];
        r4.run();
        r4 = r6.d;
        r5 = 0;
        r4[r1] = r5;
        r1 = r1 + 1;
        goto L_0x0086;
    L_0x0097:
        r0 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x0097 }
        throw r0;
    L_0x009a:
        r6.e = r2;
        r1 = r0;
        goto L_0x0025;
    L_0x009e:
        if (r4 != 0) goto L_0x00a5;
    L_0x00a0:
        r6.w = r2;
        r6.o();
    L_0x00a5:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.ah.e():boolean");
    }

    final void f() {
        if (this.m != null) {
            for (int i = 0; i < this.m.size(); i++) {
                this.m.get(i);
            }
        }
    }

    private void c(Fragment fragment) {
        if (fragment.N != null) {
            if (this.y == null) {
                this.y = new SparseArray();
            } else {
                this.y.clear();
            }
            fragment.N.saveHierarchyState(this.y);
            if (this.y.size() > 0) {
                fragment.j = this.y;
                this.y = null;
            }
        }
    }

    final Parcelable g() {
        BackStackState[] backStackStateArr = null;
        e();
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
                if (fragment.k < 0) {
                    a(new IllegalStateException("Failure saving state: active " + fragment + " has cleared index: " + fragment.k));
                }
                FragmentState fragmentState = new FragmentState(fragment);
                fragmentStateArr[i] = fragmentState;
                if (fragment.f <= 0 || fragmentState.j != null) {
                    fragmentState.j = fragment.i;
                } else {
                    if (this.x == null) {
                        this.x = new Bundle();
                    }
                    Bundle bundle = this.x;
                    if (fragment.y != null) {
                        Parcelable g = fragment.y.g();
                        if (g != null) {
                            bundle.putParcelable("android:support:fragments", g);
                        }
                    }
                    if (this.x.isEmpty()) {
                        bundle = null;
                    } else {
                        bundle = this.x;
                        this.x = null;
                    }
                    if (fragment.M != null) {
                        c(fragment);
                    }
                    if (fragment.j != null) {
                        if (bundle == null) {
                            bundle = new Bundle();
                        }
                        bundle.putSparseParcelableArray("android:view_state", fragment.j);
                    }
                    if (!fragment.P) {
                        if (bundle == null) {
                            bundle = new Bundle();
                        }
                        bundle.putBoolean("android:user_visible_hint", fragment.P);
                    }
                    fragmentState.j = bundle;
                    if (fragment.n != null) {
                        if (fragment.n.k < 0) {
                            a(new IllegalStateException("Failure saving state: " + fragment + " has target not in fragment manager: " + fragment.n));
                        }
                        if (fragmentState.j == null) {
                            fragmentState.j = new Bundle();
                        }
                        bundle = fragmentState.j;
                        String str = "android:target_state";
                        Fragment fragment2 = fragment.n;
                        if (fragment2.k < 0) {
                            a(new IllegalStateException("Fragment " + fragment2 + " is not currently in the FragmentManager"));
                        }
                        bundle.putInt(str, fragment2.k);
                        if (fragment.p != 0) {
                            fragmentState.j.putInt("android:target_req_state", fragment.p);
                        }
                    }
                }
                if (a) {
                    new StringBuilder("Saved state of ").append(fragment).append(": ").append(fragmentState.j);
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
                    iArr[i2] = ((Fragment) this.g.get(i2)).k;
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
                            backStackStateArr[i2] = new BackStackState((an) this.i.get(i2));
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
                    backStackStateArr[i2] = new BackStackState((an) this.i.get(i2));
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

    final void a(Parcelable parcelable, List<Fragment> list) {
        if (parcelable != null) {
            FragmentManagerState fragmentManagerState = (FragmentManagerState) parcelable;
            if (fragmentManagerState.a != null) {
                int i;
                Fragment fragment;
                int i2;
                if (list != null) {
                    for (i = 0; i < list.size(); i++) {
                        fragment = (Fragment) list.get(i);
                        if (a) {
                            new StringBuilder("restoreAllState: re-attaching retained ").append(fragment);
                        }
                        FragmentState fragmentState = fragmentManagerState.a[fragment.k];
                        fragmentState.k = fragment;
                        fragment.j = null;
                        fragment.v = 0;
                        fragment.t = false;
                        fragment.q = false;
                        fragment.n = null;
                        if (fragmentState.j != null) {
                            fragmentState.j.setClassLoader(this.o.b.getClassLoader());
                            fragment.j = fragmentState.j.getSparseParcelableArray("android:view_state");
                            fragment.i = fragmentState.j;
                        }
                    }
                }
                this.f = new ArrayList(fragmentManagerState.a.length);
                if (this.h != null) {
                    this.h.clear();
                }
                for (i2 = 0; i2 < fragmentManagerState.a.length; i2++) {
                    FragmentState fragmentState2 = fragmentManagerState.a[i2];
                    if (fragmentState2 != null) {
                        bm bmVar = this.o;
                        Fragment fragment2 = this.q;
                        if (fragmentState2.k == null) {
                            Context context = bmVar.b;
                            if (fragmentState2.i != null) {
                                fragmentState2.i.setClassLoader(context.getClassLoader());
                            }
                            fragmentState2.k = Fragment.a(context, fragmentState2.a, fragmentState2.i);
                            if (fragmentState2.j != null) {
                                fragmentState2.j.setClassLoader(context.getClassLoader());
                                fragmentState2.k.i = fragmentState2.j;
                            }
                            fragmentState2.k.a(fragmentState2.b, fragment2);
                            fragmentState2.k.s = fragmentState2.c;
                            fragmentState2.k.u = true;
                            fragmentState2.k.A = fragmentState2.d;
                            fragmentState2.k.B = fragmentState2.e;
                            fragmentState2.k.C = fragmentState2.f;
                            fragmentState2.k.F = fragmentState2.g;
                            fragmentState2.k.E = fragmentState2.h;
                            fragmentState2.k.w = bmVar.e;
                            if (a) {
                                new StringBuilder("Instantiated fragment ").append(fragmentState2.k);
                            }
                        }
                        Fragment fragment3 = fragmentState2.k;
                        if (a) {
                            new StringBuilder("restoreAllState: active #").append(i2).append(": ").append(fragment3);
                        }
                        this.f.add(fragment3);
                        fragmentState2.k = null;
                    } else {
                        this.f.add(null);
                        if (this.h == null) {
                            this.h = new ArrayList();
                        }
                        this.h.add(Integer.valueOf(i2));
                    }
                }
                if (list != null) {
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        fragment = (Fragment) list.get(i3);
                        if (fragment.o >= 0) {
                            if (fragment.o < this.f.size()) {
                                fragment.n = (Fragment) this.f.get(fragment.o);
                            } else {
                                Log.w("FragmentManager", "Re-attaching retained fragment " + fragment + " target no longer exists: " + fragment.o);
                                fragment.n = null;
                            }
                        }
                    }
                }
                if (fragmentManagerState.b != null) {
                    this.g = new ArrayList(fragmentManagerState.b.length);
                    for (i = 0; i < fragmentManagerState.b.length; i++) {
                        fragment = (Fragment) this.f.get(fragmentManagerState.b[i]);
                        if (fragment == null) {
                            a(new IllegalStateException("No instantiated fragment for index #" + fragmentManagerState.b[i]));
                        }
                        fragment.q = true;
                        if (a) {
                            new StringBuilder("restoreAllState: added #").append(i).append(": ").append(fragment);
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
                    for (i2 = 0; i2 < fragmentManagerState.c.length; i2++) {
                        an a = fragmentManagerState.c[i2].a(this);
                        if (a) {
                            new StringBuilder("restoreAllState: back stack #").append(i2).append(" (index ").append(a.p).append("): ").append(a);
                            a.a("  ", new PrintWriter(new c("FragmentManager")), false);
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

    public final void a(bm bmVar, cp cpVar, Fragment fragment) {
        if (this.o != null) {
            throw new IllegalStateException("Already attached");
        }
        this.o = bmVar;
        this.p = cpVar;
        this.q = fragment;
    }

    public final void h() {
        this.t = false;
        a(1);
    }

    public final void i() {
        this.t = false;
        a(2);
    }

    public final void j() {
        this.t = false;
        a(4);
    }

    public final void k() {
        this.t = false;
        a(5);
    }

    public final void l() {
        this.t = true;
        a(3);
    }

    public final void m() {
        this.u = true;
        e();
        a(0);
        this.o = null;
        this.p = null;
        this.q = null;
    }

    public final void a(Configuration configuration) {
        if (this.g != null) {
            for (int i = 0; i < this.g.size(); i++) {
                Fragment fragment = (Fragment) this.g.get(i);
                if (fragment != null) {
                    fragment.onConfigurationChanged(configuration);
                    if (fragment.y != null) {
                        fragment.y.a(configuration);
                    }
                }
            }
        }
    }

    public final void n() {
        if (this.g != null) {
            for (int i = 0; i < this.g.size(); i++) {
                Fragment fragment = (Fragment) this.g.get(i);
                if (fragment != null) {
                    fragment.onLowMemory();
                    if (fragment.y != null) {
                        fragment.y.n();
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
                    if (fragment.D) {
                        i3 = 0;
                    } else {
                        if (fragment.H && fragment.I) {
                            i3 = 1;
                        } else {
                            i3 = 0;
                        }
                        if (fragment.y != null) {
                            i3 |= fragment.y.a(menu, menuInflater);
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
                if (fragment.D) {
                    i2 = 0;
                } else {
                    if (fragment.H && fragment.I) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    if (fragment.y != null) {
                        i2 |= fragment.y.a(menu);
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
                if (fragment.D || fragment.y == null || !fragment.y.a(menuItem)) {
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
                if (fragment.D || fragment.y == null || !fragment.y.b(menuItem)) {
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
                if (!(fragment == null || fragment.D || fragment.y == null)) {
                    fragment.y.b(menu);
                }
            }
        }
    }

    public static int b(int i) {
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
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, cv.a);
        if (attributeValue == null) {
            string = obtainStyledAttributes.getString(0);
        } else {
            string = attributeValue;
        }
        int resourceId = obtainStyledAttributes.getResourceId(1, -1);
        String string2 = obtainStyledAttributes.getString(2);
        obtainStyledAttributes.recycle();
        if (!Fragment.b(this.o.b, string)) {
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
        Fragment c = resourceId != -1 ? c(resourceId) : null;
        if (c == null && string2 != null) {
            c = a(string2);
        }
        if (c == null && id != -1) {
            c = c(id);
        }
        if (a) {
            new StringBuilder("onCreateView: id=0x").append(Integer.toHexString(resourceId)).append(" fname=").append(string).append(" existing=").append(c);
        }
        if (c == null) {
            Fragment a = Fragment.a(context, string);
            a.s = true;
            a.A = resourceId != 0 ? resourceId : id;
            a.B = id;
            a.C = string2;
            a.t = true;
            a.w = this;
            a.x = this.o;
            Bundle bundle = a.i;
            a.k();
            a(a, true);
            fragment = a;
        } else if (c.t) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string2 + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + string);
        } else {
            c.t = true;
            c.x = this.o;
            if (!c.G) {
                Bundle bundle2 = c.i;
                c.k();
            }
            fragment = c;
        }
        if (this.n > 0 || !fragment.s) {
            b(fragment);
        } else {
            a(fragment, 1, 0, 0, false);
        }
        if (fragment.M == null) {
            throw new IllegalStateException("Fragment " + string + " did not create a view.");
        }
        if (resourceId != 0) {
            fragment.M.setId(resourceId);
        }
        if (fragment.M.getTag() == null) {
            fragment.M.setTag(string2);
        }
        return fragment.M;
    }
}
