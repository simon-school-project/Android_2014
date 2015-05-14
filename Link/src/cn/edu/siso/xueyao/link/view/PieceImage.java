package cn.edu.siso.xueyao.link.view;

import android.graphics.Bitmap;
/*
 * 
 * PieceImage封装两个信息
 *  Bitmap对象
 *  图片资源的ID
 * */
public class PieceImage {
	
	private Bitmap  image;
	private int imageId;
	
	//有参数的构造函数
	public PieceImage (Bitmap image, int imageId) 
	{
		
		super();
		this.image = image;
		this.imageId = imageId;
	}
	
	//设置image的值
	public void setimage(Bitmap image)
	{
		this.image = image;
	}
	
	//获取image的值
	public Bitmap getimage()
	{
		return image;
	}
	
	//设置imageId的值
	public void setimageId(int imageId)
	{
		this.imageId = imageId;
	}
	
	//获取imageId的值
	public int getimageId()
	{
		return imageId;
		
	}
}
