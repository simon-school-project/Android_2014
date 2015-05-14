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

	private GameConf config;	//游戏配置对象
	private GameService gameService;	//游戏业务逻辑接口
	private GameView gameView;	//游戏界面
	private Button startButton;	//开始按钮
	private TextView timeTextView;	//记录剩余时间TextView
	private AlertDialog.Builder lostDialog;	//失败后弹出的对话框
	private AlertDialog.Builder successDialog;	//游戏胜利弹出的对话框
	private Timer timer = new Timer();	//定时器
	private int gameTime;		//记录游戏剩余时间
	private boolean isPlaying;	//记录是否处于游戏状态
	
	//播放音效soundPool
	SoundPool soundPool = new SoundPool(2,	
			AudioManager.STREAM_SYSTEM, 8);
	
	int dis;
	
	//记录已经选中的方块
	private Piece selected = null;
	
	private Handler handler = new Handler()
	{
		public void handleMessage(Message msg)
		{
			switch (msg.what)
			{
			case 0x123:
					timeTextView.setText("剩余时间："+gameTime);
					gameTime--;
					
					//时间小于0，游戏失败
					if (gameTime<0)
					{
						stopTimer();
						
						//更改游戏的状态
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
		init();	//初始化界面
	}

	//初始化界面
	private void init() 
	{
		// TODO Auto-generated method stub
		
		//游戏配置
		config = new GameConf(8, 9, 2, 10, 100000, this);
		
		//得到游戏区域对象
		gameView = (GameView)findViewById(R.id.gameView);
		
		//获取显示剩余时间的文本框
		timeTextView = (TextView)findViewById(R.id.timeText);
		
		//获取开始按钮
		startButton = (Button)findViewById(R.id.startButton);
		
		//初始化音效
		dis = soundPool.load(this, R.raw.dis,1);
		gameService = new GameServiceImpl(this.config);
		gameView.setGameService(gameService);
		
		//为开始按钮的单击事件绑定事件监听器
		startButton.setOnClickListener(new OnClickListener() 
		{
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
					startGame(GameConf.DEFAULT_TIME);
			}
		});
		
		//为游戏区域的触碰事件绑定监听器
		this.gameView.setOnTouchListener(new OnTouchListener() 
		{
			
			@Override
			public boolean onTouch(View v, MotionEvent e) 
			{
				// TODO Auto-generated method stub
				
				//如果不处于游戏状态中
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
		
		//初始化游戏失败对话框
		lostDialog = createDialog("Lost","游戏失败！重新开始",
				R.drawable.lost).setPositiveButton("确定",
						new DialogInterface.OnClickListener()
				{
					
					@Override
					public void onClick(DialogInterface dialog, int which) 
					{
						// TODO Auto-generated method stub
						startGame(GameConf.DEFAULT_TIME);
					}
				} );
		
		//初始化游戏胜利对话框
		successDialog = createDialog("Success","游戏胜利！重新开始",
				R.drawable.success).setPositiveButton("确定",
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
		
		
		//暂停游戏
		stopTimer();
		super.onPause();
	}

	@Override
	protected void onResume()
	{
		// TODO Auto-generated method stub
		
		//如果处于游戏状态中
		if (isPlaying)
		{
			//以剩余时间重写开始游戏
			startGame(gameTime);
		}
		super.onResume();
	}
	
	
	//触碰游戏区域的处理方法
	private void gameViewTouchDown(MotionEvent event)
	{
		//获取GameServiceImpl中的Piece[][]数组
		Piece [][] pieces = gameService.getPieces();
		
		//获取用户点击的X坐标
		float touchX = event.getX();
		
		//获取用户点击的Y坐标
		float touchY = event.getY();
		
		//根据用户触碰的坐标得到对应的Piece对象
		Piece currentPiece = gameService.findPiece(touchX, touchY);
		
		//如果没有选中任何Piece对象（鼠标点击的地方没有图片），不再往下执行
		if (currentPiece == null)
		{
			return;
		}
		
		//将gameView中的选中方块设为当前方块
		this.gameView.setSelectedPiece(currentPiece);
		
		//表示之前没有选中任意一个Piece
		if (this.selected == null )
		{
			/*
			 * 将当前方块设为已选中的方块，重新将GamePanel绘制
			 * 并不再往下执行
			 * */
			this.selected = currentPiece;
			this.gameView.postInvalidate();
			return;
		}
		
		//表示之前已经选择了一个
		if (this.selected != null)
		{
			//在这里就要对currentPiece和prePiece进行判断并进行选择
			LinkInfo linkInfo = this.gameService.link(this.selected, currentPiece);
			
			//两个Piece不可连，linkInfo为null;
			if (linkInfo == null)
			{
				//如果连接不成功，将当前方块设为选中方块
				this.selected = currentPiece;
				this.gameView.postInvalidate();
				
			}
			else
			{
				//处理成功连接
				handleSuccessLink(linkInfo,this.selected,currentPiece,pieces);
				
			}
		}
	}
	
	//触碰游戏区域的处理方法
	private void gameViewTouchUp(MotionEvent event)
	{
		this.gameView.postInvalidate();
	}
	//以gammeTime作为剩余时间开始或恢复游戏
	private void startGame(int gameTime)
	{
		//如果之前的timer还未取消，取消timer
		if (this.timer != null)
		{
			stopTimer();
		}
		
		//重新设置游戏时间
		this.gameTime = gameTime;
		
		//如果游戏剩余时间与总游戏时间相等，即为重新开始新游戏
		if (gameTime == GameConf.DEFAULT_TIME)
		{
			
			//开始新的游戏
			gameView.startGame();
		}
		
		isPlaying = true;
		this.timer = new Timer();
		
		//启动计时器，每隔1秒发送一次消息
		this.timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				handler.sendEmptyMessage(0x123);
			}
		}, 0,1000);
		
		//将选中方块设为null;
		this.selected = null;
		
	}
	
	/*
	 * 成功连接后处理
	 * @param linkInfo 连接信息
	 * @param prePiece 前一个选中方块
	 * @param currentPiece 当前选中方块
	 * @param pieces 系统中还剩的全部方块
	 * 
	 * */
	private void handleSuccessLink(LinkInfo linkInfo,Piece prePiece,
			Piece currentPiece,Piece[][]pieces)
	{
		//它们可以相连，让GamePanel处理LinkInfo
		this.gameView.setLinkInfo(linkInfo);
		
		//将gameView中的选中方块设为null;
		this.gameView.setSelectedPiece(null);
		
		
		this.gameView.postInvalidate();
		
		//将两个Piece对象从数组中删除
		pieces[prePiece.getIndexX()][prePiece.getIndexY()] = null;
		pieces[currentPiece.getIndexX()][currentPiece.getIndexY()] = null;
		
		//将选中的方块设为null
		this.selected = null;
		
		//播放音效
		soundPool.play(dis, 1, 1, 0, 0, 1);
		
		//判断是否还有剩下的方块，如果没有，游戏胜利
		if (!this.gameService.hasPieces())
		{
			//游戏胜利
			this.successDialog.show();
			
			//停止定时器
			stopTimer();
			
			//更改游戏状态
			isPlaying = false;
			
		}
		
	}
	
	//创建对话框工具方法
	private AlertDialog.Builder createDialog(String title, String message,
			int imageResource)
	{
		return new AlertDialog.Builder(this).setTitle(title)
				.setMessage(message).setIcon(imageResource);
	}
	
	private void stopTimer()
	{
		//停止定时器
		this.timer.cancel();
		this.timer = null;
		
	}
	
}
