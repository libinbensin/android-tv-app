package example.com.pizzatvapp.activity;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import example.com.pizzatvapp.R;

/**
 * Created by libinsalal on 9/30/15.
 */
@EActivity(R.layout.activity_tv_cart)
public class CartTvActivity extends Activity {

    @ViewById(R.id.cart_tv_list_view)
    RecyclerView mCartListView;




}
