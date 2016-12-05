package bkoruznjak.from.hr.funtimes;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import bkoruznjak.from.hr.funtimes.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mBinding;
    private int mNumberOfTimesButtonClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mBinding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("bbb", "button clicked");
                mNumberOfTimesButtonClicked++;
                mBinding.textView.setText("clicked button :" + mNumberOfTimesButtonClicked + " times.");
            }
        });
    }
}
