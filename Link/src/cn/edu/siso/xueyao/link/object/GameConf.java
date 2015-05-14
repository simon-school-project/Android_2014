package cn.edu.siso.xueyao.link.object;

import android.content.Context;

public class GameConf
{
		// ������������ÿ�������ͼƬ�Ŀ���
		public static final int PIECE_WIDTH = 40;
		public static final int PIECE_HEIGHT = 40;
		
		// ��¼��Ϸ����ʱ�䣨100�룩.
		public static int DEFAULT_TIME = 100;
		
		// Piece[][]�����һά�ĳ���
		private int xSize;
		
		// Piece[][]����ڶ�ά�ĳ���
		private int ySize;
		
		// Board�е�һ��ͼƬ���ֵ�x����
		private int beginImageX;
		
		// Board�е�һ��ͼƬ���ֵ�y����
		private int beginImageY;
		
		// ��¼��Ϸ����ʱ��, ��λ�Ǻ���
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

			//��ȡ��Ϸ��ʱ��
			public long getGameTime()
			{
				return gameTime;
			}

			//��ȡPiece[][]�����һά�ĳ���
			public int getXSize()
			{
				return xSize;
			}

			//��ȡPiece[][]����ڶ�ά�ĳ���
			public int getYSize()
			{
				return ySize;
			}

			//��ȡBoard�е�һ��ͼƬ���ֵ�x����
			public int getBeginImageX()
			{
				return beginImageX;
			}

			//��ȡBoard�е�һ��ͼƬ���ֵ�y����
			public int getBeginImageY()
			{
				return beginImageY;
			}

			public Context getContext()
			{
				return context;
			}
		}

