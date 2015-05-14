package com.example.sudokuhz;

import com.example.sudokuhz.R;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{
	private Button btnbegin,btnexit,btnabout,btncountine,gamebegint,btnset;
	private PuzzleView myview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btnbegin=(Button)findViewById(R.id.btnbegin);
		btncountine=(Button)findViewById(R.id.btncontinue);
		gamebegint=(Button)findViewById(R.id.gamebegint);
		btnabout=(Button)findViewById(R.id.btnabout);
		btnset=(Button)findViewById(R.id.btnset);
		btnexit=(Button)findViewById(R.id.btnexit);
		btnbegin.setOnClickListener(this);
		btncountine.setOnClickListener(this);
		gamebegint.setOnClickListener(this);
		btnabout.setOnClickListener(this);
		btnset.setOnClickListener(this);
		btnexit.setOnClickListener(this);
	}

	
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getId()){
	
		case R.id.btnbegin:
			
			startNewGame(0);
			

			break;
		case R.id.btncontinue:
			startNewGame(-1);
			break;
		case R.id.gamebegint:
			openNewGame();
			break;

		case R.id.btnabout:
			Intent intent01=new Intent();
			intent01.setClass(this,About.class);
			startActivity(intent01);
			break;
		case R.id.btnset:
			Intent intent=new Intent(this,Prefs.class);
			startActivity(intent);
			break;
		case R.id.btnexit:
				exitAlert("真的要退出吗？");
			break;
		}
	}

	private void openNewGame() {
		// TODO Auto-generated method stub
		AlertDialog.Builder new_game=new AlertDialog.Builder(this);
		final String ss[]={"较难","中等","容易"};
		new_game.setTitle("选择难度");
		new_game.setItems(ss, new DialogInterface.OnClickListener() {			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(MainActivity.this, ss[which], Toast.LENGTH_SHORT).show();	
				startNewGame(which+1);
			}
		});
		AlertDialog alert=new_game.create();
		alert.show();		
		
	}

	private void startNewGame(int diff) {
		// TODO Auto-generated method stub
		Intent intent=new Intent(this,Game.class);
		intent.putExtra("difficulty", diff);
		startActivity(intent);
	}

	private void exitAlert(String msg){
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage(msg)
		.setCancelable(false)
		.setPositiveButton("确定", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
				finish();
			}
		}).setNegativeButton("取消", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
				return;
			}
		});
		AlertDialog alert = builder.create();
		alert.show();
	}

}
