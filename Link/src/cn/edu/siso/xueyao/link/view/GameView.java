package cn.edu.siso.xueyao.link.view;

import java.util.List;

import cn.edu.siso.xueyao.link.R;
import cn.edu.siso.xueyao.link.board.GameService;
import cn.edu.siso.xueyao.link.object.LinkInfo;
import cn.edu.siso.xueyao.link.util.ImageUtil;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

/*
 * ������Ϸ��״̬���������ƽ����ϵķ���
 * �������ӷ����������
 * */
public class GameView extends View 
{
	//��Ϸ�߼���ʵ����
	private GameService gameService;
	//���浱ǰ�Ѿ���ѡ�еķ���
	private Piece selectePiece;
	//������Ϣ����
	private LinkInfo linkInfo;
	private Paint paint;
	//ѡ�б�ʶ��ͼƬ����
	private Bitmap selectImage;
	
	public GameView(Context context, AttributeSet attrs)
	{
		super(context, attrs);
		// TODO Auto-generated constructor stub
		this.paint = new Paint();
		
		//ʹ��λͼƽ����Ϊ��������
		this.paint.setShader(new BitmapShader(
				BitmapFactory.decodeResource(
						context.getResources(), 
						R.drawable.heart), Shader.TileMode.REPEAT, 
						Shader.TileMode.REPEAT));
		//���������ߵľ�ϸ
		this.paint.setStrokeWidth(8);
		this.selectImage = ImageUtil.getSelectImage(context);
	}
	
	//����������
	public void setLinkInfo(LinkInfo linkInfo)
	{
		this.linkInfo = linkInfo;
	}
	
	//������Ϸ����
	public void setGameService(GameService gameService)
	{
		this.gameService = gameService ;
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		
		//�����Ϸ����Ϊ�գ����˳�
		if (this.gameService ==null)
		{
			return;
		}
		Piece[][] pieces = gameService.getPieces();
		if (pieces != null) 
		{
			//����piece��ά����
			for (int i = 0; i < pieces.length; i++)
			{
				for (int j = 0; j < pieces[i].length; j++)
				{
					/*
					 * �����ά�����и�Ԫ�ز�Ϊ��(���з���)��
					 * ����������ͼƬ������
					 * */
					if (pieces[i][j]!= null) 
					{
						//�õ����Piece����
						Piece piece = pieces[i][j];
						
						//���ݷ������Ͻ�X��Y������Ʒ���
						canvas.drawBitmap(piece.getImage().getimage(),
								piece.getBeginX(), piece.getBeginY(),null);
					}
				}
			}
		}
		
		//�����ǰ��������linkInfo���󣬼�������Ϣ
		if (this.linkInfo != null)
		{	
			//����������
			drawLine(this.linkInfo,canvas);
			//����������linkInfo����
			this.linkInfo = null;
		}
		
		//��ѡ�б�ʶ��ͼƬ
		if (this.selectePiece != null)
		{
			canvas.drawBitmap(this.selectImage,
					this.selectePiece.getBeginX(),
					this.selectePiece.getBeginY(),null);
		}
	}
	
	//����linkInfo���������ߵķ���
	private void drawLine(LinkInfo linkInfo,Canvas canvas)
	{
		//��ȡLinkInfo�з�װ���������ӵ�
		List<Point> points = linkInfo.getLinkPoints();
		//���α���linkInfo�е�ÿ�����ӵ�
		for (int i = 0; i < points.size()-1; i++)
		{
			//��ȡ��ǰ���ӵ�����һ�����ӵ�
			Point currentPoint = points.get(i);
			Point nextPoint = points.get(i+1);
		
			//��������
			canvas.drawLine(currentPoint.x,
					currentPoint.y,
					nextPoint.x, nextPoint.y, this.paint);
		}
	}
	
	//���õ�ǰѡ�з���ķ���
	public void setSelectedPiece(Piece piece)
	{
		this.selectePiece = piece;
	}
	
	//��ʼ��Ϸ����
	public void startGame()
	{
		this.gameService.start();
		this.postInvalidate();
	}
	
	
}
