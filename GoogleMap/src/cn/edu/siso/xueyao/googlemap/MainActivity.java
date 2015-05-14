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

	//��������ϵĿ��ӻ��ؼ�
	Button locBn;
	RadioGroup mapType;
	MapView mv;
	EditText etLng, etLat;
	//���� MapCnetroller����
	MapController controller;
	Bitmap posBitmap;
	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.activity_main);
		posBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
		//��ý�����MapView����
		mv =(MapView)findViewById(R.id.mv);
		//��ȡ�����������ı���
		etLat = (EditText)findViewById(R.id.lat);
		etLng = (EditText)findViewById(R.id.lng);
		//������ʾ�Ŵ���С�Ŀ��ư�ť
		mv.setBuiltInZoomControls(true);
		//����MapController����
		controller = mv.getController();
		//���Button����
		locBn = (Button)findViewById(R.id.loc);
		locBn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//����û�����ľ��ȡ�γ��ֵ
				String lng = etLng.getEditableText().toString().trim();
				String lat  = etLat.getEditableText().toString().trim();
				
				if (lng.equals("")||lat.equals("")) {
					Toast.makeText(MainActivity.this, "��������Ч�ľ��ȡ�γ�ȣ�", Toast.LENGTH_LONG).show();
				}
				else {
					double dLong = Double.parseDouble(lng);
					double dLat = Double.parseDouble(lat);
					//���÷�������MapView
					updateMapView(dLong,dLat);
				}
			}
		});
		
		//������ť�ĵ����¼�
		locBn.performClick();
		//���RadioGroup����
		mapType = (RadioGroup)findViewById(R.id.rg);
		//ΪRadioGroup��ѡ��״̬�ı���Ӽ�����
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
