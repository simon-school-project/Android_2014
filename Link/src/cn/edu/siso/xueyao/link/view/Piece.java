package cn.edu.siso.xueyao.link.view;

import android.graphics.Point;



/*
 * 
 * Piece���������Ϸ�����ϵ�һ�����飬�����˷�װ�����ϵ�ͼƬ֮�⣬
 * ����װ�÷������Ķ�ά�����е��ĸ�Ԫ�أ�Ҳ��װ�������Ͻ�����Ϸ
 * ������X.Y���ꡣ
 * 
 * */


public class Piece {
	
	private PieceImage image;	 //���淽����������Ӧ��ͼƬ
	private int beginX;		//�÷�������Ͻǵ�x����
	private int beginY;		//�÷�������Ͻǵ�y����
	private int indexX;		//�ö�����Piece[][]�����е�һά������ֵ
	private int indexY;		//�ö�����Piece[][]�����еڶ�ά������ֵ
	
	//���ø�piece���������������е�λ��
	public Piece(int indexX, int indexY)
	{
			this.indexX = indexX; 
			this.indexY = indexY;
	}
	
	//��ȡ��������Ͻǵ�x����
	public int getBeginX()
	{
		return beginX;
	}
	
	//���÷�������Ͻǵ�x����
	public void setBeginX(int beginX)
	{
		this.beginX = beginX;
	}
	
	//��ȡ��������Ͻǵ�y����
	public int getBeginY()
	{
		return beginY;
	}
	
	//���÷�������Ͻǵ�y����
	public void setBeginY(int beginY)
	{
		this.beginY = beginY;
	}
	
	//��ȡ��Piece[][]�����е�һά������ֵ
	public int getIndexX()
	{
		return indexX;
	}
	
	//������Piece[][]�����е�һά������ֵ
	public void setIndexX(int indexX)
	{
		this.indexX = indexX;
	}
	
	//��ȡ��Piece[][]�����еڶ�ά������ֵ
	public int getIndexY()
	{
		return indexY;
	}
	
	//������Piece[][]�����еڶ�ά������ֵ
	public void setIndexY(int indexY)
	{
		this.indexY = indexY;
	}
	
	//��ȡ������������Ӧ��ͼƬ
	public PieceImage getImage()
	{
		return image;
	}
	
	//���÷�����������Ӧ��ͼƬ
	public void setImage(PieceImage image)
	{
		this.image = image;
	}
	
	//�ж�����Piece�ϵ�ͼƬ�Ƿ���ͬ
	public boolean isSameImage(Piece other)
	{
		if (image == null)
		{
			if (other.image != null)
			{
				return false;
			}
		}
		//ֻҪPiece��װͼƬID��ͬ��������Ϊ����Piece���
		return image.getimageId() ==other.image.getimageId();
	}

	public Point getCenter() {
		// TODO Auto-generated method stub
		return new Point(getImage().getimage().getWidth() / 2
				+ getBeginX(), getBeginY()
				+ getImage().getimage().getHeight() / 2);
	}
}
