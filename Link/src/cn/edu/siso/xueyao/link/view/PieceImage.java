package cn.edu.siso.xueyao.link.view;

import android.graphics.Bitmap;
/*
 * 
 * PieceImage��װ������Ϣ
 *  Bitmap����
 *  ͼƬ��Դ��ID
 * */
public class PieceImage {
	
	private Bitmap  image;
	private int imageId;
	
	//�в����Ĺ��캯��
	public PieceImage (Bitmap image, int imageId) 
	{
		
		super();
		this.image = image;
		this.imageId = imageId;
	}
	
	//����image��ֵ
	public void setimage(Bitmap image)
	{
		this.image = image;
	}
	
	//��ȡimage��ֵ
	public Bitmap getimage()
	{
		return image;
	}
	
	//����imageId��ֵ
	public void setimageId(int imageId)
	{
		this.imageId = imageId;
	}
	
	//��ȡimageId��ֵ
	public int getimageId()
	{
		return imageId;
		
	}
}
