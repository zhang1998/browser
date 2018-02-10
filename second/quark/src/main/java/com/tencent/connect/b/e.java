package com.tencent.connect.b;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.graphics.drawable.PaintDrawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.tauth.a;
import com.tencent.tauth.b;
import com.uc.imagecodec.export.IPictureView;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
final class e implements b {
    b a;
    final /* synthetic */ f b;
    private final String c = "sendinstall";
    private final String d = "installwording";
    private final String e = "http://appsupport.qq.com/cgi-bin/qzapps/mapp_addapp.cgi";

    public e(f fVar, b bVar) {
        this.b = fVar;
        this.a = bVar;
    }

    public final void a(Object obj) {
        if (obj != null) {
            JSONObject jSONObject = (JSONObject) obj;
            if (jSONObject != null) {
                String string;
                Object obj2;
                try {
                    Object obj3 = jSONObject.getInt("sendinstall") == 1 ? 1 : null;
                    string = jSONObject.getString("installwording");
                    obj2 = obj3;
                } catch (JSONException e) {
                    obj2 = null;
                    string = "";
                }
                CharSequence decode = URLDecoder.decode(string);
                new StringBuilder(" WORDING = ").append(decode).append("xx");
                if (obj2 != null && !TextUtils.isEmpty(decode)) {
                    b bVar = this.a;
                    Activity activity = (Activity) this.b.j.get();
                    if (activity != null) {
                        Drawable loadIcon;
                        Dialog dialog = new Dialog(activity);
                        dialog.requestWindowFeature(1);
                        PackageManager packageManager = activity.getPackageManager();
                        PackageInfo packageInfo = null;
                        try {
                            packageInfo = packageManager.getPackageInfo(activity.getPackageName(), 0);
                        } catch (NameNotFoundException e2) {
                        }
                        if (packageInfo != null) {
                            loadIcon = packageInfo.applicationInfo.loadIcon(packageManager);
                        } else {
                            loadIcon = null;
                        }
                        OnClickListener aVar = new a(this, dialog, bVar, obj);
                        OnClickListener bVar2 = new b(this, dialog, bVar, obj);
                        Drawable colorDrawable = new ColorDrawable();
                        colorDrawable.setAlpha(0);
                        dialog.getWindow().setBackgroundDrawable(colorDrawable);
                        DisplayMetrics displayMetrics = new DisplayMetrics();
                        ((WindowManager) activity.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
                        float f = displayMetrics.density;
                        View relativeLayout = new RelativeLayout(activity);
                        View imageView = new ImageView(activity);
                        imageView.setImageDrawable(loadIcon);
                        imageView.setScaleType(ScaleType.FIT_XY);
                        imageView.setId(1);
                        int i = (int) (60.0f * f);
                        int i2 = (int) (14.0f * f);
                        int i3 = (int) (18.0f * f);
                        int i4 = (int) (6.0f * f);
                        LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i);
                        layoutParams.addRule(9);
                        layoutParams.setMargins(0, i3, i4, i3);
                        relativeLayout.addView(imageView, layoutParams);
                        View textView = new TextView(activity);
                        textView.setText(decode);
                        textView.setTextSize(14.0f);
                        textView.setGravity(3);
                        textView.setIncludeFontPadding(false);
                        textView.setPadding(0, 0, 0, 0);
                        textView.setLines(2);
                        textView.setId(5);
                        textView.setMinWidth((int) (185.0f * f));
                        LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                        layoutParams2.addRule(1, 1);
                        layoutParams2.addRule(6, 1);
                        layoutParams2.setMargins(0, 0, (int) (5.0f * f), 0);
                        relativeLayout.addView(textView, layoutParams2);
                        textView = new View(activity);
                        textView.setBackgroundColor(Color.rgb(214, 214, 214));
                        textView.setId(3);
                        layoutParams2 = new RelativeLayout.LayoutParams(-2, 2);
                        layoutParams2.addRule(3, 1);
                        layoutParams2.addRule(5, 1);
                        layoutParams2.addRule(7, 5);
                        layoutParams2.setMargins(0, 0, 0, (int) (12.0f * f));
                        relativeLayout.addView(textView, layoutParams2);
                        textView = new LinearLayout(activity);
                        layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                        layoutParams2.addRule(5, 1);
                        layoutParams2.addRule(7, 5);
                        layoutParams2.addRule(3, 3);
                        imageView = new Button(activity);
                        imageView.setText("跳过");
                        imageView.setBackgroundDrawable(a("buttonNegt.png", activity));
                        imageView.setTextColor(Color.rgb(36, 97, 131));
                        imageView.setTextSize(20.0f);
                        imageView.setOnClickListener(bVar2);
                        imageView.setId(4);
                        LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, (int) (45.0f * f));
                        layoutParams3.rightMargin = i2;
                        layoutParams3.leftMargin = (int) (4.0f * f);
                        layoutParams3.weight = IPictureView.DEFAULT_MIN_SCALE;
                        textView.addView(imageView, layoutParams3);
                        View button = new Button(activity);
                        button.setText("确定");
                        button.setTextSize(20.0f);
                        button.setTextColor(Color.rgb(255, 255, 255));
                        button.setBackgroundDrawable(a("buttonPost.png", activity));
                        button.setOnClickListener(aVar);
                        LayoutParams layoutParams4 = new LinearLayout.LayoutParams(0, (int) (45.0f * f));
                        layoutParams4.weight = IPictureView.DEFAULT_MIN_SCALE;
                        layoutParams4.rightMargin = (int) (4.0f * f);
                        textView.addView(button, layoutParams4);
                        relativeLayout.addView(textView, layoutParams2);
                        layoutParams4 = new FrameLayout.LayoutParams((int) (279.0f * f), (int) (163.0f * f));
                        relativeLayout.setPadding(i2, 0, (int) (12.0f * f), (int) (12.0f * f));
                        relativeLayout.setLayoutParams(layoutParams4);
                        relativeLayout.setBackgroundColor(Color.rgb(247, 251, 247));
                        loadIcon = new PaintDrawable(Color.rgb(247, 251, 247));
                        loadIcon.setCornerRadius(f * 5.0f);
                        relativeLayout.setBackgroundDrawable(loadIcon);
                        dialog.setContentView(relativeLayout);
                        dialog.setOnCancelListener(new c(this, bVar, obj));
                        if (activity != null && !activity.isFinishing()) {
                            dialog.show();
                        }
                    }
                } else if (this.a != null) {
                    this.a.a(obj);
                }
            }
        }
    }

    private static Drawable a(String str, Context context) {
        NinePatchDrawable ninePatchDrawable;
        try {
            InputStream open = context.getApplicationContext().getAssets().open(str);
            if (open == null) {
                return null;
            }
            if (str.endsWith(".9.png")) {
                Bitmap decodeStream;
                try {
                    decodeStream = BitmapFactory.decodeStream(open);
                } catch (OutOfMemoryError e) {
                    decodeStream = null;
                }
                if (decodeStream == null) {
                    return null;
                }
                byte[] ninePatchChunk = decodeStream.getNinePatchChunk();
                NinePatch.isNinePatchChunk(ninePatchChunk);
                ninePatchDrawable = new NinePatchDrawable(decodeStream, ninePatchChunk, new Rect(), null);
                return ninePatchDrawable;
            }
            ninePatchDrawable = Drawable.createFromStream(open, str);
            try {
                open.close();
            } catch (IOException e2) {
            }
            return ninePatchDrawable;
        } catch (IOException e3) {
            ninePatchDrawable = null;
        }
    }

    public final void a(a aVar) {
        if (this.a != null) {
            this.a.a(aVar);
        }
    }

    public final void a() {
        if (this.a != null) {
            this.a.a();
        }
    }
}
