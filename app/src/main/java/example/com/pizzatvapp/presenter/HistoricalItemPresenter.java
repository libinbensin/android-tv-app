package example.com.pizzatvapp.presenter;

import android.support.v17.leanback.widget.Presenter;
import android.view.ViewGroup;
import android.widget.TextView;

import example.com.pizzatvapp.view.HistoricalOrderItemView;
import example.com.pizzatvapp.view.HistoricalOrderItemView_;

/**
 * Created by libinsalal on 9/29/15.
 */
public class HistoricalItemPresenter extends Presenter {

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        HistoricalOrderItemView historicalOrderItemView = HistoricalOrderItemView_.build(parent.getContext());
        historicalOrderItemView.setFocusable(true);
        historicalOrderItemView.setFocusableInTouchMode(true);
        return new ViewHolder(historicalOrderItemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, Object item) {
        HistoricalOrderItemView historicalOrderItemView = (HistoricalOrderItemView)viewHolder.view;

        historicalOrderItemView.bind((String) item, null);
    }

    @Override
    public void onUnbindViewHolder(ViewHolder viewHolder) {
        //NOP
    }
}
