package example.com.pizzatvapp.fragment;

import android.os.Bundle;
import android.support.v17.leanback.app.DetailsFragment;
import android.support.v17.leanback.widget.Action;
import android.support.v17.leanback.widget.ArrayObjectAdapter;
import android.support.v17.leanback.widget.ClassPresenterSelector;
import android.support.v17.leanback.widget.DetailsOverviewRow;
import android.support.v17.leanback.widget.DetailsOverviewRowPresenter;
import android.support.v17.leanback.widget.HeaderItem;
import android.support.v17.leanback.widget.ListRow;
import android.support.v17.leanback.widget.ListRowPresenter;
import android.support.v17.leanback.widget.OnActionClickedListener;

import example.com.pizzatvapp.Movie;
import example.com.pizzatvapp.R;
import example.com.pizzatvapp.presenter.HistoricalDetailsDescriptionPresenter;
import example.com.pizzatvapp.presenter.HistoricalItemPresenter;

/**
 * Created by libinsalal on 9/30/15.
 */
public class HistoricalOrderDetailFragment extends DetailsFragment {

    private DetailsOverviewRowPresenter mDorPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mDorPresenter =
                new DetailsOverviewRowPresenter(new HistoricalDetailsDescriptionPresenter());
        mDorPresenter.setSharedElementEnterTransition(getActivity(), "hero");

        Movie mSelectedMovie = new Movie();
        mSelectedMovie.setTitle("Recent Order  10-11-2015");
        mSelectedMovie.setStudio("2 Items");
        mSelectedMovie.setDescription("Large(14) Brooklyn Memphis BBQ Chicken Pizza, Medium..");

        DetailsOverviewRow row = new DetailsOverviewRow(mSelectedMovie);

        row.addAction(new Action(1, "CANCEL"));
        row.addAction(new Action(2, "REORDER"));
        updateDetail(row);
    }


    private void updateDetail(DetailsOverviewRow detailRow){
        ClassPresenterSelector ps = new ClassPresenterSelector();
        // set detail background and style
        mDorPresenter.setBackgroundColor(getResources().getColor(R.color.detail_background));
        mDorPresenter.setStyleLarge(true);
        mDorPresenter.setOnActionClickedListener(new OnActionClickedListener() {
            @Override
            public void onActionClicked(Action action) {
                if(action.getId() == 1) {
                    getActivity().finish();
                }else if(action.getId() == 2) {
                    // go to cart

                }
            }
        });

        ps.addClassPresenter(DetailsOverviewRow.class, mDorPresenter);
        ps.addClassPresenter(ListRow.class,
                new ListRowPresenter());

        ArrayObjectAdapter adapter = new ArrayObjectAdapter(ps);
        adapter.add(detailRow);

        HistoricalItemPresenter recentOrderHeaderPresenter = new HistoricalItemPresenter();
        ArrayObjectAdapter recentOrderHeaderRowAdapter = new ArrayObjectAdapter(recentOrderHeaderPresenter);
        recentOrderHeaderRowAdapter.add("FRIDAY 09/25");
        recentOrderHeaderRowAdapter.add("FRIDAY 09/18");
        recentOrderHeaderRowAdapter.add("THURSDAY 09/10");
        recentOrderHeaderRowAdapter.add("WEDNESDAY 8/26");
        recentOrderHeaderRowAdapter.add("SATURDAY 1/25");


        HeaderItem header = new HeaderItem(0, "Related Recent Orders");

        adapter.add(new ListRow(header, recentOrderHeaderRowAdapter));

        setAdapter(adapter);
    }

}
