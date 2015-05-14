package cn.edu.siso.xueyao.googlemap;

import java.util.List;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

public class MainActivity extends MapActivity
{

	//定义界面上的可视化控件
	Button locBn;
	RadioGroup mapType;
	MapView mv;
	EditText etLng, etLat;
	//定义 MapCnetroller对象
	MapController controller;
	Bitmap posBitmap;
	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.activity_main);
		posBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
		//获得界面上MapView对象
		mv =(MapView)findViewById(R.id.mv);
		//获取界面上两个文本框
		etLat = (EditText)findViewById(R.id.lat);
		etLng = (EditText)findViewById(R.id.lng);
		//设置显示放大、缩小的控制按钮
		mv.setBuiltInZoomControls(true);
		//创建MapController对象
		controller = mv.getController();
		//获得Button对象
		locBn = (Button)findViewById(R.id.loc);
		locBn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//获得用户输入的经度、纬度值
				String lng = etLng.getEditableText().toString().trim();
				String lat  = etLat.getEditableText().toString().trim();
				
				if (lng.equals("")||lat.equals("")) {
					Toast.makeText(MainActivity.this, "请输入有效的经度、纬度！", Toast.LENGTH_LONG).show();
				}
				else {
					double dLong = Double.parseDouble(lng);
					double dLat = Double.parseDouble(lat);
					//调用方法更新MapView
					updateMapView(dLong,dLat);
				}
			}
		});
		
		//触发按钮的单击事件
		locBn.performClick();
		//获得RadioGroup对象
		mapType = (RadioGroup)findViewById(R.id.rg);
		//为RadioGroup的选中状态改变添加监听器
		mapType.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				switch (checkedId) {
				case R.id.normal:
					mv.setSatellite(false);		
					break;
				case R.id.satellite:
					mv.setSatellite(true);		
					break;
				
				}
			}
		});
	}
	
	
	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return true;
	}

	private void updateMapView(double lng,double lat)
	{
		
		GeoPoint gp = new GeoPoint((int)(lat*1E6), (int)(lng*1E6));
		mv.displayZoomControls(true);
		controller.animateTo(gp);
		List<Overlay> olList  = mv.getOverlays();
		olList.clear();
		olList.add(new PosOverLay(gp,posBitmap));
	}
	
	
	}
