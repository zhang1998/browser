package com.ucpro.base.weex.component;

import android.content.Context;
import android.support.annotation.Keep;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.GridView;
import com.taobao.weex.ac;
import com.taobao.weex.c.ae;
import com.taobao.weex.ui.component.WXComponentProp;
import com.taobao.weex.ui.component.ab;
import com.taobao.weex.ui.component.bv;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@Keep
/* compiled from: ProGuard */
public class WXTextTable extends ab<FrameLayout> {
    private int mColCount = 0;
    private FrameLayout mContainer = null;
    private ae mDom = null;
    private GridView mGridView = null;
    private List<String> mItems = new ArrayList();
    private int mRowCount = 0;

    public WXTextTable(ac acVar, ae aeVar, bv bvVar) {
        super(acVar, aeVar, bvVar);
        this.mDom = aeVar;
    }

    protected FrameLayout initComponentHostView(@NonNull Context context) {
        this.mContainer = new FrameLayout(context);
        this.mGridView = new GridView(context);
        this.mGridView.setVerticalScrollBarEnabled(false);
        this.mGridView.setClickable(false);
        this.mContainer.addView(this.mGridView, new LayoutParams(-1, -2));
        return this.mContainer;
    }

    @WXComponentProp(name = "rowCount")
    public void setRowCount(String str) {
        try {
            this.mRowCount = Integer.valueOf(str).intValue();
        } catch (Exception e) {
        }
    }

    @WXComponentProp(name = "colCount")
    public void setColCount(String str) {
        try {
            this.mColCount = Integer.valueOf(str).intValue();
            this.mGridView.setNumColumns(this.mColCount);
        } catch (Exception e) {
        }
    }

    @WXComponentProp(name = "items")
    public void setItems(String str) {
        try {
            this.mItems.clear();
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONArray jSONArray2 = (JSONArray) jSONArray.get(i);
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    JSONObject jSONObject = (JSONObject) jSONArray2.get(i2);
                    if (!(jSONObject == null || TextUtils.isEmpty(jSONObject.getString("text")))) {
                        this.mItems.add(jSONObject.getString("text"));
                    }
                }
            }
            this.mGridView.setAdapter(new j(this));
        } catch (Exception e) {
        }
    }
}
