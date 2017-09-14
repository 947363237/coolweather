package coolweather.lis.com.coolweather;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;

import coolweather.lis.com.coolweather.activity.WeatherActivity;
import coolweather.lis.com.coolweather.fragment.ChooseAreaFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * 已经选择过城市信息，跳过选择
         */
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        if (prefs.getString("weather", null) != null) {
            Intent intent = new Intent(this, WeatherActivity.class);
            startActivity(intent);
            finish();
        }

        /**
         * 设置城市选择回调
         */
        ChooseAreaFragment chooseAreaFragment = (ChooseAreaFragment)
                getSupportFragmentManager().findFragmentById(R.id.choose_area_fragment);
        chooseAreaFragment.setOnSelected(new ChooseAreaFragment.OnSelected() {
            @Override
            public void onSelected(String weatherId) {
                Intent intent = new Intent(MainActivity.this, WeatherActivity.class);
                intent.putExtra("weather_id", weatherId);
                startActivity(intent);
                finish();
            }
        });
    }
}
