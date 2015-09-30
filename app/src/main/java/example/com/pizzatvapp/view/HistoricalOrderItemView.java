package example.com.pizzatvapp.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import example.com.pizzatvapp.R;

/**
 * Created by libinsalal on 9/29/15.
 */
@EViewGroup(R.layout.view_tv_historical_order_item)
public class HistoricalOrderItemView extends LinearLayout {

    @ViewById(R.id.historical_order_tv_title)
    TextView mTitle;

    @ViewById(R.id.historical_order_tv_description)
    TextView mDescription;

    public HistoricalOrderItemView(Context context) {
        super(context);
    }

    public HistoricalOrderItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public HistoricalOrderItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public HistoricalOrderItemView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void bind(String title, String description) {
        mTitle.setText(title);
        if(description != null) {
            mDescription.setText(description);
        }
    }
}
