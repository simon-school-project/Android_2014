package cn.edu.siso.xueyao.googlemap;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.Projection;

public class PosOverLay extends Overlay {

	Bitmap posBitmap;
	GeoPoint gp;
	public PosOverLay(GeoPoint gp, Bitmap posBitmap) {
		// TODO Auto-generated constructor stub
		super();
		this.gp = gp;
		this.posBitmap = posBitmap;
	}
	@Override
	public void draw(Canvas canvas, MapView mapView, boolean shadow) {
		// TODO Auto-generated method stub
		
		//super.draw(canvas, mapView, shadow);
		if (!shadow) {
			Projection proj = mapView.getProjection();
			Point p = new Point();
			proj.toPixels(gp, p);
			canvas.drawBitmap(posBitmap, p.x-posBitmap.getWidth()/2,
					p.y-posBitmap.getHeight(),null);
		}
	}
	
	

}
