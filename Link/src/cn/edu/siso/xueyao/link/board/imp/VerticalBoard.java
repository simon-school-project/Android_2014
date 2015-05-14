package cn.edu.siso.xueyao.link.board.imp;

import java.util.ArrayList;
import java.util.List;

import cn.edu.siso.xueyao.link.board.AbstractBoard;
import cn.edu.siso.xueyao.link.object.GameConf;
import cn.edu.siso.xueyao.link.view.Piece;

/*
 * 竖向排列的方块
 * */
public class VerticalBoard extends AbstractBoard 
{

	@Override
	protected List<Piece> createPieces(GameConf config, Piece[][] pieces) {
		// TODO Auto-generated method stub
		
		//创建一个Piece集合，该集合里面存放初始化游戏时所需的Piece对象
		List<Piece> notNullPieces = new ArrayList<Piece>();
		
		//加入判断，符合一定条件才去构造Piece对象，并加到集合中
		for (int i = 0; i < pieces.length; i++)
		{
			for (int j = 0; j < pieces[i].length; j++)
			{
				if (i %2 == 0)
				{
					/**
					 * 如果x能被2整除，即单数列不会创建方块
					 * 先构造一个Piece对象，只设置它在Piece[][]数组中的索引值
					 * 所需要的PieceImage由其父类负责设置
					 * */
					Piece piece = new Piece(i, j);
					
					//添加到Piece集合中
					notNullPieces.add(piece);
				}
			}
		}
		return notNullPieces;
	}

}
