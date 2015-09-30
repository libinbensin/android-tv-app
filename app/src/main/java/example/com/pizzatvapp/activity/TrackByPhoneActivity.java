package example.com.pizzatvapp.activity;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import example.com.pizzatvapp.fragment.ErrorFragment;
import example.com.pizzatvapp.R;

/**
 * Created by libinsalal on 9/29/15.
 */
@EActivity(R.layout.activity_tv_track_by_phone)
public class TrackByPhoneActivity extends Activity{

    private static int TIMER_DELAY = 3000;
    private static int SPINNER_WIDTH = 100;
    private static int SPINNER_HEIGHT = 100;

    private ErrorFragment mErrorFragment;
    private SpinnerFragment mSpinnerFragment;


    @ViewById(R.id.phone_number_input_view)
    EditText mPhoneNumberInputView;

    @ViewById(R.id.phone_number_input_view)
    EditText mPhoneExtensionInputView;

    @ViewById(R.id.track_by_phone_button)
    Button mTrackPhoneButton;

    @AfterViews
    protected void onAfterViews(){
        mPhoneNumberInputView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //NOP
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mTrackPhoneButton.setEnabled(mPhoneNumberInputView.length() == 10);
            }

            @Override
            public void afterTextChanged(Editable s) {
                //NOP
            }
        });
    }

    @Click(R.id.track_by_phone_button)
    protected void onTrackOrderButtonClicked(){
        // track order
        hideSoftKeyboard();

        TrackerTvActivity_.intent(this).start();
        finish();
        //showErrorFragment();

    }

    private void hideSoftKeyboard() {
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(mPhoneNumberInputView.getWindowToken(), 0);
    }


    private void showErrorFragment() {
        mErrorFragment = new ErrorFragment();
        getFragmentManager().beginTransaction().add(R.id.main_browse_fragment, mErrorFragment).commit();

        mSpinnerFragment = new SpinnerFragment();
        getFragmentManager().beginTransaction().add(R.id.main_browse_fragment, mSpinnerFragment).commit();

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                getFragmentManager().beginTransaction().remove(mSpinnerFragment).commit();
                mErrorFragment.setErrorContent();
            }
        }, TIMER_DELAY);
    }

    static public class SpinnerFragment extends Fragment {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            ProgressBar progressBar = new ProgressBar(container.getContext());
            if (container instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams =
                        new FrameLayout.LayoutParams(SPINNER_WIDTH, SPINNER_HEIGHT, Gravity.CENTER);
                progressBar.setLayoutParams(layoutParams);
            }
            return progressBar;
        }
    }

}
