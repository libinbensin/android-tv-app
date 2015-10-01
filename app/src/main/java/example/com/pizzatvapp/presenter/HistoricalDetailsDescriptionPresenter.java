package example.com.pizzatvapp.presenter;

import android.support.v17.leanback.widget.AbstractDetailsDescriptionPresenter;

import example.com.pizzatvapp.Movie;

/**
 * Created by libinsalal on 9/30/15.
 */
public class HistoricalDetailsDescriptionPresenter extends AbstractDetailsDescriptionPresenter {

    @Override
    protected void onBindDescription(AbstractDetailsDescriptionPresenter.ViewHolder viewHolder, Object item) {
        Movie movie = (Movie) item;

        if (movie != null) {
            viewHolder.getTitle().setText(movie.getTitle());
            viewHolder.getSubtitle().setText(movie.getStudio());
            viewHolder.getBody().setText(movie.getDescription());
        }
    }
}