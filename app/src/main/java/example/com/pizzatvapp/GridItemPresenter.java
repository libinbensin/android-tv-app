package example.com.pizzatvapp;

import android.graphics.Color;
import android.support.v17.leanback.widget.Presenter;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.TextView;

import example.com.pizzatvapp.fragment.MenuFragment;

/**
 * @author Libin
 */
public class GridItemPresenter extends Presenter {
    private static int GRID_ITEM_WIDTH = 200;
    private static int GRID_ITEM_HEIGHT = 200;


    private MenuFragment mainFragment;


    public GridItemPresenter(MenuFragment mainFragment) {
        this.mainFragment = mainFragment;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        TextView view = new TextView(parent.getContext());
        view.setLayoutParams(new ViewGroup.LayoutParams(GRID_ITEM_WIDTH, GRID_ITEM_HEIGHT));
        view.setFocusable(true);
        view.setFocusableInTouchMode(true);
        view.setBackgroundColor(mainFragment.getResources().getColor(R.color.default_background));
        view.setTextColor(Color.WHITE);
        view.setGravity(Gravity.CENTER);
        view.setFocusable(true);
        view.setFocusableInTouchMode(true);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder viewHolder, Object item) {
        ((TextView) viewHolder.view).setText((String) item);
    }


    @Override
    public void onUnbindViewHolder(ViewHolder viewHolder) {
    }
}
