package com.example.sudokuhz;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;
import android.app.Activity;
import android.app.AlertDialog;


public class Game extends Activity {

	String continueString;
	PuzzleView puzzleview ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//Preferences的应用
		continueString= getPreferences(MODE_PRIVATE).getString("puzzle","");
		int diff=getIntent().getIntExtra("difficulty",0);

		puzzleview = new PuzzleView(this,diff);
		
		setContentView(puzzleview);
		puzzleview.requestFocus();
	}
	
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();	
		continueString=getPreferences(MODE_PRIVATE).getString("puzzle", "");
		music.paly(this,R.raw.yue);
	}
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		music.stop(this);
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		getPreferences(MODE_PRIVATE).edit().putString("puzzle", arraytoString()).commit();
		music.stop(this);
	}
	/* 
	 * 把 puzzle数组中的9*9字符串
	 * */
	private String arraytoString(){
		String s1="";
		int j,k;
		for(j=0;j<9;j++)
			for(k=0;k<9;k++){
				s1+=puzzleview.puzzle[j][k];
			}
		return s1;
	}
	


	
}
