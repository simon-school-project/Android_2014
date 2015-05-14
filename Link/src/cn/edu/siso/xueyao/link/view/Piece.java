package cn.edu.siso.xueyao.link.view;

import android.graphics.Point;



/*
 * 
 * Piece对象代表游戏界面上的一个方块，它除了封装方块上的图片之外，
 * 还封装该方块代表的二维数组中的哪个元素，也封装它的左上角在游戏
 * 界面中X.Y坐标。
 * 
 * */


public class Piece {
	
	private PieceImage image;	 //保存方块对象的所对应的图片
	private int beginX;		//该方块的左上角的x坐标
	private int beginY;		//该方块的左上角的y坐标
	private int indexX;		//该对象在Piece[][]数组中第一维的索引值
	private int indexY;		//该对象在Piece[][]数组中第二维的索引值
	
	//设置该piece对象在棋盘数组中的位置
	public Piece(int indexX, int indexY)
	{
			this.indexX = indexX; 
			this.indexY = indexY;
	}
	
	//获取方块的左上角的x坐标
	public int getBeginX()
	{
		return beginX;
	}
	
	//设置方块的左上角的x坐标
	public void setBeginX(int beginX)
	{
		this.beginX = beginX;
	}
	
	//获取方块的左上角的y坐标
	public int getBeginY()
	{
		return beginY;
	}
	
	//设置方块的左上角的y坐标
	public void setBeginY(int beginY)
	{
		this.beginY = beginY;
	}
	
	//获取在Piece[][]数组中第一维的索引值
	public int getIndexX()
	{
		return indexX;
	}
	
	//设置在Piece[][]数组中第一维的索引值
	public void setIndexX(int indexX)
	{
		this.indexX = indexX;
	}
	
	//获取在Piece[][]数组中第二维的索引值
	public int getIndexY()
	{
		return indexY;
	}
	
	//设置在Piece[][]数组中第二维的索引值
	public void setIndexY(int indexY)
	{
		this.indexY = indexY;
	}
	
	//获取方块对象的所对应的图片
	public PieceImage getImage()
	{
		return image;
	}
	
	//设置方块对象的所对应的图片
	public void setImage(PieceImage image)
	{
		this.image = image;
	}
	
	//判断两个Piece上的图片是否相同
	public boolean isSameImage(Piece other)
	{
		if (image == null)
		{
			if (other.image != null)
			{
				return false;
			}
		}
		//只要Piece封装图片ID相同，即可认为两个Piece相等
		return image.getimageId() ==other.image.getimageId();
	}

	public Point getCenter() {
		// TODO Auto-generated method stub
		return new Point(getImage().getimage().getWidth() / 2
				+ getBeginX(), getBeginY()
				+ getImage().getimage().getHeight() / 2);
	}
}
