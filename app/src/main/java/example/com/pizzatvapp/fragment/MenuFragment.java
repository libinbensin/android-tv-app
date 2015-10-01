package example.com.pizzatvapp.fragment;

import android.os.Bundle;
import android.support.v17.leanback.app.BrowseFragment;
import android.support.v17.leanback.widget.ArrayObjectAdapter;
import android.support.v17.leanback.widget.HeaderItem;
import android.support.v17.leanback.widget.ListRow;
import android.support.v17.leanback.widget.ListRowPresenter;
import android.support.v17.leanback.widget.OnItemViewClickedListener;
import android.support.v17.leanback.widget.Presenter;
import android.support.v17.leanback.widget.Row;
import android.support.v17.leanback.widget.RowPresenter;

import example.com.pizzatvapp.GridItemPresenter;
import example.com.pizzatvapp.Movie;
import example.com.pizzatvapp.R;
import example.com.pizzatvapp.activity.DetailTVActivity_;
import example.com.pizzatvapp.activity.TrackByPhoneActivity_;
import example.com.pizzatvapp.presenter.HistoricalItemPresenter;
import example.com.pizzatvapp.model.TrackItem;
import example.com.pizzatvapp.presenter.TrackItemPresenter;

/**
 * @author Libin
 */
public class MenuFragment extends BrowseFragment {

    private ArrayObjectAdapter mRowsAdapter;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setupUIElements();

        loadMenuItems();
    }

    private void setupUIElements() {
        //setBadgeDrawable(getActivity().getResources().getDrawable(R.drawable.videos_by_google_banner));
        setTitle(getString(R.string.browse_title)); // Badge, when set, takes precedent over title
        setHeadersState(HEADERS_ENABLED);
        setHeadersTransitionOnBackEnabled(true);
        // set fastLane (or headers) background color
        setBrandColor(getResources().getColor(R.color.material_blue_grey_800));
        // set search icon color
        setSearchAffordanceColor(getResources().getColor(R.color.material_deep_teal_200));

//        setHeaderPresenterSelector(new PresenterSelector() {
//            @Override
//            public Presenter getPresenter(Object o) {
//                return new IconHeaderItemPresenter();
//            }
//        });
    }

    private void loadMenuItems(){

        mRowsAdapter = new ArrayObjectAdapter(new ListRowPresenter());

        HeaderItem easyOrderHeader = new HeaderItem(0, "EASY ORDER");
        HistoricalItemPresenter easyOrderHeaderPresenter = new HistoricalItemPresenter();
        ArrayObjectAdapter easyOrderHeaderRowAdapter = new ArrayObjectAdapter(easyOrderHeaderPresenter);
        easyOrderHeaderRowAdapter.add("My Favorite");
        mRowsAdapter.add(new ListRow(easyOrderHeader, easyOrderHeaderRowAdapter));

        HeaderItem recentOrderHeader = new HeaderItem(1, "RECENT ORDERS");
        HistoricalItemPresenter recentOrderHeaderPresenter = new HistoricalItemPresenter();
        ArrayObjectAdapter recentOrderHeaderRowAdapter = new ArrayObjectAdapter(recentOrderHeaderPresenter);
        recentOrderHeaderRowAdapter.add("FRIDAY 09/25");
        recentOrderHeaderRowAdapter.add("FRIDAY 09/18");
        recentOrderHeaderRowAdapter.add("THURSDAY 09/10");
        recentOrderHeaderRowAdapter.add("WEDNESDAY 8/26");
        recentOrderHeaderRowAdapter.add("SATURDAY 1/25");
        mRowsAdapter.add(new ListRow(recentOrderHeader, recentOrderHeaderRowAdapter));

        HeaderItem trackOrderHeader = new HeaderItem(2, "TRACK ORDER");
        TrackItemPresenter trackOrderHeaderPresenter = new TrackItemPresenter();
        ArrayObjectAdapter trackOrderHeaderRowAdapter = new ArrayObjectAdapter(trackOrderHeaderPresenter);
        trackOrderHeaderRowAdapter.add(new TrackItem("234-567-8910" , "Use Primary Number" , 0));
        trackOrderHeaderRowAdapter.add(new TrackItem("555-555-5555" , "Use Secondary Number" , 0));
        trackOrderHeaderRowAdapter.add(new TrackItem("ENTER PHONE #" , null, 0));
        mRowsAdapter.add(new ListRow(trackOrderHeader, trackOrderHeaderRowAdapter));

        HeaderItem loginHeader = new HeaderItem(3 , "SETTINGS");
        GridItemPresenter settingsPresenter = new GridItemPresenter(this);
        ArrayObjectAdapter settingsRowAdapter = new ArrayObjectAdapter(settingsPresenter);
        settingsRowAdapter.add("SIGN IN");
        settingsRowAdapter.add("PRIVACY POLICY");
        settingsRowAdapter.add("TERMS OF SERVICE");
        mRowsAdapter.add(new ListRow(loginHeader, settingsRowAdapter));

        setAdapter(mRowsAdapter);

        setOnItemViewClickedListener(new ItemViewClickedListener());
    }



    private final class ItemViewClickedListener implements OnItemViewClickedListener {
        @Override
        public void onItemClicked(Presenter.ViewHolder itemViewHolder, Object item,
                                  RowPresenter.ViewHolder rowViewHolder, Row row) {


            if(item instanceof String){
                DetailTVActivity_.intent(getActivity()).start();
            }
            else if(item instanceof TrackItem) {
                TrackItem trackItem = (TrackItem) item;
                if(trackItem.getTitle().equals("ENTER PHONE #")) {
                    TrackByPhoneActivity_.intent(getActivity()).start();
                }
            }
        }
    }


}
