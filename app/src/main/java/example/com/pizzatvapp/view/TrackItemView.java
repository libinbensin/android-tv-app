package example.com.pizzatvapp.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import example.com.pizzatvapp.R;
import example.com.pizzatvapp.model.TrackItem;

/**
 * Created by libinsalal on 9/29/15.
 */
@EViewGroup(R.layout.view_tv_track_item)
public class TrackItemView extends LinearLayout {

    @ViewById(R.id.track_order_tv_title)
    TextView mTitle;

    @ViewById(R.id.track_order_tv_description)
    TextView mDescription;

    public TrackItemView(Context context) {
        super(context);
    }

    public TrackItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TrackItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public TrackItemView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void bind(TrackItem trackItem) {
        mTitle.setText(trackItem.getTitle());
        mDescription.setText(trackItem.getDescription());
    }
}
