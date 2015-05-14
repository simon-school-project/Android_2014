package cn.edu.siso.xueyao.link;

import java.util.Timer;
import java.util.TimerTask;

import cn.edu.siso.xueyao.link.board.GameService;

import cn.edu.siso.xueyao.link.object.GameConf;
import cn.edu.siso.xueyao.link.object.LinkInfo;
import cn.edu.siso.xueyao.link.view.GameView;
import cn.edu.siso.xueyao.link.view.Piece;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	private GameConf config;	//��Ϸ���ö���
	private GameService gameService;	//��Ϸҵ���߼��ӿ�
	private GameView gameView;	//��Ϸ����
	private Button startButton;	//��ʼ��ť
	private TextView timeTextView;	//��¼ʣ��ʱ��TextView
	private AlertDialog.Builder lostDialog;	//ʧ�ܺ󵯳��ĶԻ���
	private AlertDialog.Builder successDialog;	//��Ϸʤ�������ĶԻ���
	private Timer timer = new Timer();	//��ʱ��
	private int gameTime;		//��¼��Ϸʣ��ʱ��
	private boolean isPlaying;	//��¼�Ƿ�����Ϸ״̬
	
	//������ЧsoundPool
	SoundPool soundPool = new SoundPool(2,	
			AudioManager.STREAM_SYSTEM, 8);
	
	int dis;
	
	//��¼�Ѿ�ѡ�еķ���
	private Piece selected = null;
	
	private Handler handler = new Handler()
	{
		public void handleMessage(Message msg)
		{
			switch (msg.what)
			{
			case 0x123:
					timeTextView.setText("ʣ��ʱ�䣺"+gameTime);
					gameTime--;
					
					//ʱ��С��0����Ϸʧ��
					if (gameTime<0)
					{
						stopTimer();
						
						//������Ϸ��״̬
						isPlaying = false;
						lostDialog.show();
						return;
					}
				
				break;
			}
		}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		init();	//��ʼ������
	}

	//��ʼ������
	private void init() 
	{
		// TODO Auto-generated method stub
		
		//��Ϸ����
		config = new GameConf(8, 9, 2, 10, 100000, this);
		
		//�õ���Ϸ�������
		gameView = (GameView)findViewById(R.id.gameView);
		
		//��ȡ��ʾʣ��ʱ����ı���
		timeTextView = (TextView)findViewById(R.id.timeText);
		
		//��ȡ��ʼ��ť
		startButton = (Button)findViewById(R.id.startButton);
		
		//��ʼ����Ч
		dis = soundPool.load(this, R.raw.dis,1);
		gameService = new GameServiceImpl(this.config);
		gameView.setGameService(gameService);
		
		//Ϊ��ʼ��ť�ĵ����¼����¼�������
		startButton.setOnClickListener(new OnClickListener() 
		{
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
					startGame(GameConf.DEFAULT_TIME);
			}
		});
		
		//Ϊ��Ϸ����Ĵ����¼��󶨼�����
		this.gameView.setOnTouchListener(new OnTouchListener() 
		{
			
			@Override
			public boolean onTouch(View v, MotionEvent e) 
			{
				// TODO Auto-generated method stub
				
				//�����������Ϸ״̬��
				if (!isPlaying)
				{
					return false;
				}
				if (e.getAction() ==MotionEvent.ACTION_DOWN)
				{
					gameViewTouchDown(e);
				}
				
				if (e.getAction() == MotionEvent.ACTION_UP)
				{
					gameViewTouchUp(e);
				}
				return true;
		
				
			}
		});
		
		//��ʼ����Ϸʧ�ܶԻ���
		lostDialog = createDialog("Lost","��Ϸʧ�ܣ����¿�ʼ",
				R.drawable.lost).setPositiveButton("ȷ��",
						new DialogInterface.OnClickListener()
				{
					
					@Override
					public void onClick(DialogInterface dialog, int which) 
					{
						// TODO Auto-generated method stub
						startGame(GameConf.DEFAULT_TIME);
					}
				} );
		
		//��ʼ����Ϸʤ���Ի���
		successDialog = createDialog("Success","��Ϸʤ�������¿�ʼ",
				R.drawable.success).setPositiveButton("ȷ��",
						new DialogInterface.OnClickListener()
				{
					
					@Override
					public void onClick(DialogInterface dialog, int which) 
					{
						// TODO Auto-generated method stub
						startGame(GameConf.DEFAULT_TIME);
					}
				} );
	}

	@Override
	protected void onPause() 
	{
		// TODO Auto-generated method stub
		
		
		//��ͣ��Ϸ
		stopTimer();
		super.onPause();
	}

	@Override
	protected void onResume()
	{
		// TODO Auto-generated method stub
		
		//���������Ϸ״̬��
		if (isPlaying)
		{
			//��ʣ��ʱ����д��ʼ��Ϸ
			startGame(gameTime);
		}
		super.onResume();
	}
	
	
	//������Ϸ����Ĵ�����
	private void gameViewTouchDown(MotionEvent event)
	{
		//��ȡGameServiceImpl�е�Piece[][]����
		Piece [][] pieces = gameService.getPieces();
		
		//��ȡ�û������X����
		float touchX = event.getX();
		
		//��ȡ�û������Y����
		float touchY = event.getY();
		
		//�����û�����������õ���Ӧ��Piece����
		Piece currentPiece = gameService.findPiece(touchX, touchY);
		
		//���û��ѡ���κ�Piece����������ĵط�û��ͼƬ������������ִ��
		if (currentPiece == null)
		{
			return;
		}
		
		//��gameView�е�ѡ�з�����Ϊ��ǰ����
		this.gameView.setSelectedPiece(currentPiece);
		
		//��ʾ֮ǰû��ѡ������һ��Piece
		if (this.selected == null )
		{
			/*
			 * ����ǰ������Ϊ��ѡ�еķ��飬���½�GamePanel����
			 * ����������ִ��
			 * */
			this.selected = currentPiece;
			this.gameView.postInvalidate();
			return;
		}
		
		//��ʾ֮ǰ�Ѿ�ѡ����һ��
		if (this.selected != null)
		{
			//�������Ҫ��currentPiece��prePiece�����жϲ�����ѡ��
			LinkInfo linkInfo = this.gameService.link(this.selected, currentPiece);
			
			//����Piece��������linkInfoΪnull;
			if (linkInfo == null)
			{
				//������Ӳ��ɹ�������ǰ������Ϊѡ�з���
				this.selected = currentPiece;
				this.gameView.postInvalidate();
				
			}
			else
			{
				//����ɹ�����
				handleSuccessLink(linkInfo,this.selected,currentPiece,pieces);
				
			}
		}
	}
	
	//������Ϸ����Ĵ�����
	private void gameViewTouchUp(MotionEvent event)
	{
		this.gameView.postInvalidate();
	}
	//��gammeTime��Ϊʣ��ʱ�俪ʼ��ָ���Ϸ
	private void startGame(int gameTime)
	{
		//���֮ǰ��timer��δȡ����ȡ��timer
		if (this.timer != null)
		{
			stopTimer();
		}
		
		//����������Ϸʱ��
		this.gameTime = gameTime;
		
		//�����Ϸʣ��ʱ��������Ϸʱ����ȣ���Ϊ���¿�ʼ����Ϸ
		if (gameTime == GameConf.DEFAULT_TIME)
		{
			
			//��ʼ�µ���Ϸ
			gameView.startGame();
		}
		
		isPlaying = true;
		this.timer = new Timer();
		
		//������ʱ����ÿ��1�뷢��һ����Ϣ
		this.timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				handler.sendEmptyMessage(0x123);
			}
		}, 0,1000);
		
		//��ѡ�з�����Ϊnull;
		this.selected = null;
		
	}
	
	/*
	 * �ɹ����Ӻ���
	 * @param linkInfo ������Ϣ
	 * @param prePiece ǰһ��ѡ�з���
	 * @param currentPiece ��ǰѡ�з���
	 * @param pieces ϵͳ�л�ʣ��ȫ������
	 * 
	 * */
	private void handleSuccessLink(LinkInfo linkInfo,Piece prePiece,
			Piece currentPiece,Piece[][]pieces)
	{
		//���ǿ�����������GamePanel����LinkInfo
		this.gameView.setLinkInfo(linkInfo);
		
		//��gameView�е�ѡ�з�����Ϊnull;
		this.gameView.setSelectedPiece(null);
		
		
		this.gameView.postInvalidate();
		
		//������Piece�����������ɾ��
		pieces[prePiece.getIndexX()][prePiece.getIndexY()] = null;
		pieces[currentPiece.getIndexX()][currentPiece.getIndexY()] = null;
		
		//��ѡ�еķ�����Ϊnull
		this.selected = null;
		
		//������Ч
		soundPool.play(dis, 1, 1, 0, 0, 1);
		
		//�ж��Ƿ���ʣ�µķ��飬���û�У���Ϸʤ��
		if (!this.gameService.hasPieces())
		{
			//��Ϸʤ��
			this.successDialog.show();
			
			//ֹͣ��ʱ��
			stopTimer();
			
			//������Ϸ״̬
			isPlaying = false;
			
		}
		
	}
	
	//�����Ի��򹤾߷���
	private AlertDialog.Builder createDialog(String title, String message,
			int imageResource)
	{
		return new AlertDialog.Builder(this).setTitle(title)
				.setMessage(message).setIcon(imageResource);
	}
	
	private void stopTimer()
	{
		//ֹͣ��ʱ��
		this.timer.cancel();
		this.timer = null;
		
	}
	
}
