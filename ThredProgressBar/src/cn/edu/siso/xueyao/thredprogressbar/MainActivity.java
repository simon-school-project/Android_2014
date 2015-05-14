package cn.edu.siso.xueyao.thredprogressbar;
//¸üÐÂProgressBar
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends Activity {
private Button startbt,stopbt;
private static ProgressBar progressBar;
private static Handler handler = new Handler();
private static int count;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		startbt = (Button)findViewById(R.id.stratbt);
		
		progressBar = (ProgressBar)findViewById(R.id.progressBar1);
		progressBar.setMax(100);
		startbt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				startService(new Intent(MainActivity.this,ProgressService.class));
			}
		});
		
		stopbt = (Button)findViewById(R.id.stopbt);
		stopbt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				stopService(new Intent(MainActivity.this,ProgressService.class));
			}
		});
	}
	
	public  static void UpdateGUI(int scount)
	{
		count = scount;
		handler.post(RefreshLable);
		
	}

	private static Runnable RefreshLable = new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			 progressBar.setProgress(count);
		}
	};
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
