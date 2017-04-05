package com.lsmore.myinkview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Simon_Li1 on 3/27/2017.
 */

public class InkView extends View {




    public InkView(Context context) {
        this(context,DEFAULT_FLAGS);
    }

    public InkView(Context context,int flags) {
        super(context);

    }

    public InkView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

}
