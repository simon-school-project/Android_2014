package cn.edu.siso.xueyao.link.board.imp;

import java.util.ArrayList;
import java.util.List;

import cn.edu.siso.xueyao.link.board.AbstractBoard;

import cn.edu.siso.xueyao.link.object.GameConf;
import cn.edu.siso.xueyao.link.view.Piece;

/*
 * 
 * 矩阵排列的方块
 * */
public class FullBoard extends AbstractBoard
{

	@Override
	protected List<Piece> createPieces(GameConf config, Piece[][] pieces) 
	{
		// TODO Auto-generated method stub
		
		//创建一个Piece集合，该集合里面存放初始化游戏时所需要的Piece对象
		List<Piece> notNullPieces = new ArrayList<Piece>();
		for (int i = 1; i < pieces.length-1; i++)
		{
			for (int j = 1; j < pieces[i].length-1; j++)
			{
				//先构造一个Piece对象，只设置它在Piece[][] 数组中索引值
				//所需要的PieceImage由其父类负责设置
				Piece piece = new Piece(i, j);
				
				//添加到Piece集合中
				notNullPieces.add(piece);
			}
		}
		return notNullPieces;
	}
	
}
