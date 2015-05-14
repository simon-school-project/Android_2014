package cn.edu.siso.xueyao.link.object;

import android.content.Context;

public class GameConf
{
		// 设置连连看的每个方块的图片的宽、高
		public static final int PIECE_WIDTH = 40;
		public static final int PIECE_HEIGHT = 40;
		
		// 记录游戏的总时间（100秒）.
		public static int DEFAULT_TIME = 100;
		
		// Piece[][]数组第一维的长度
		private int xSize;
		
		// Piece[][]数组第二维的长度
		private int ySize;
		
		// Board中第一张图片出现的x座标
		private int beginImageX;
		
		// Board中第一张图片出现的y座标
		private int beginImageY;
		
		// 记录游戏的总时间, 单位是毫秒
		private long gameTime;
		private Context context;
	
		public GameConf(int xSize, int ySize, int beginImageX,
				int beginImageY, long gameTime, Context context)
			{
				this.xSize = xSize;
				this.ySize = ySize;
				this.beginImageX = beginImageX;
				this.beginImageY = beginImageY;
				this.gameTime = gameTime;
				this.context = context;
			}

			//获取游戏总时间
			public long getGameTime()
			{
				return gameTime;
			}

			//获取Piece[][]数组第一维的长度
			public int getXSize()
			{
				return xSize;
			}

			//获取Piece[][]数组第二维的长度
			public int getYSize()
			{
				return ySize;
			}

			//获取Board中第一张图片出现的x座标
			public int getBeginImageX()
			{
				return beginImageX;
			}

			//获取Board中第一张图片出现的y座标
			public int getBeginImageY()
			{
				return beginImageY;
			}

			public Context getContext()
			{
				return context;
			}
		}

