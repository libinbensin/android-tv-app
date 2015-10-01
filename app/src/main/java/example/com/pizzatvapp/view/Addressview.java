package example.com.pizzatvapp.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import org.androidannotations.annotations.EViewGroup;

import example.com.pizzatvapp.R;

/**
 * Created by libinsalal on 9/30/15.
 */
@EViewGroup(R.layout.view_tv_address)
public class Addressview extends LinearLayout{
    public Addressview(Context context) {
        super(context);
    }

    public Addressview(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Addressview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public Addressview(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
