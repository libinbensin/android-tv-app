package example.com.pizzatvapp.presenter;

import android.support.v17.leanback.widget.Presenter;
import android.view.ViewGroup;

import example.com.pizzatvapp.model.TrackItem;
import example.com.pizzatvapp.view.TrackItemView;
import example.com.pizzatvapp.view.TrackItemView_;

/**
 * Created by libinsalal on 9/29/15.
 */
public class TrackItemPresenter extends Presenter {
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        TrackItemView trackItemView = TrackItemView_.build(parent.getContext());
        return new ViewHolder(trackItemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, Object item) {
        TrackItem trackItem = (TrackItem) item;
        TrackItemView trackItemView = (TrackItemView) viewHolder.view;
        trackItemView.bind(trackItem);
    }

    @Override
    public void onUnbindViewHolder(ViewHolder viewHolder) {

    }
}
