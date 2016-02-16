package ninja.berbert.androidjokelib;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    public final static String EXTRA_JOKE = "joke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
        if (getIntent().hasExtra(EXTRA_JOKE)) {
            TextView tvJoke = (TextView) findViewById(R.id.tv_joke);
            tvJoke.setText(getIntent().getStringExtra(EXTRA_JOKE));
        }
    }
}
