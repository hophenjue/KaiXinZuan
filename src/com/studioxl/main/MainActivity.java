package com.studioxl.main;

import com.studioxl.application.MyApplication;
import com.studioxl.entity.CityInfoList;
import com.studioxl.kaixinzuan.R;
import com.studioxl.util.FastJsonTextHttpRespons;

import android.os.Bundle;
import android.widget.Toast;


public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        test();
    }

	private void test() {
		// TODO Auto-generated method stub
		MyApplication.getRequestUtil().getCityData(getApplicationContext(), new FastJsonTextHttpRespons<CityInfoList>(CityInfoList.class){

			@Override
			public void onSuccess(int responseCode, CityInfoList t) {
				// TODO Auto-generated method stub
				super.onSuccess(responseCode, t);
				Toast.makeText(getApplication(),"a", 2000).show();
			}
			
			
		});
	}

}
