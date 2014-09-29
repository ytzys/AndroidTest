package androidtest.ui;

import java.security.PublicKey;

import com.zys.androidtest.R;

import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;

public class MainActivity extends Activity {

	SeekBar seekbar;
	int i = 0;
	Handler tmp = new Handler() {
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case 1:
				seekbar.setSecondaryProgress(500 + i * 100);
				i++;
				tmp.sendEmptyMessageDelayed(1, 1000);
				break;
			case 2:
				crack.setBackgroundResource(R.drawable.super_selected);
				break;
			default:
				break;
			}
		};
	};

	private ImageButton crack;
	private String TAG = "MainActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//test comment.
		//add something in master branch
		//modified in the origin/master branch

		seekbar = (SeekBar) findViewById(R.id.media_progress);
		seekbar.setMax(1000);
		seekbar.setProgress(200);
		seekbar.setSecondaryProgress(500);
		tmp.sendEmptyMessageDelayed(1, 1000);

		crack = (ImageButton) findViewById(R.id.crack);
		crack.setBackgroundResource(R.drawable.standard_selected);
		tmp.sendEmptyMessageDelayed(2, 5000);
		Log.i(TAG, Environment.getDownloadCacheDirectory().toString());
		Log.i(TAG, Environment.getDataDirectory().toString());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
