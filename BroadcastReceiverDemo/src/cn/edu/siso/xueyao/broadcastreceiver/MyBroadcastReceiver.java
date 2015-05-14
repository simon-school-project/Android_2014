package cn.edu.siso.xueyao.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
			String messageString = "you name is:"+intent.getStringExtra("name")+
									"you age is:"+intent.getIntExtra("age", 20);
			Toast.makeText(context, messageString, Toast.LENGTH_SHORT).show();
	}

}
