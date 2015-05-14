package cn.edu.siso.xueyao.link.board.imp;

import java.util.ArrayList;
import java.util.List;

import cn.edu.siso.xueyao.link.board.AbstractBoard;

import cn.edu.siso.xueyao.link.object.GameConf;
import cn.edu.siso.xueyao.link.view.Piece;

/*
 * 
 * �������еķ���
 * */
public class FullBoard extends AbstractBoard
{

	@Override
	protected List<Piece> createPieces(GameConf config, Piece[][] pieces) 
	{
		// TODO Auto-generated method stub
		
		//����һ��Piece���ϣ��ü��������ų�ʼ����Ϸʱ����Ҫ��Piece����
		List<Piece> notNullPieces = new ArrayList<Piece>();
		for (int i = 1; i < pieces.length-1; i++)
		{
			for (int j = 1; j < pieces[i].length-1; j++)
			{
				//�ȹ���һ��Piece����ֻ��������Piece[][] ����������ֵ
				//����Ҫ��PieceImage���丸�ฺ������
				Piece piece = new Piece(i, j);
				
				//��ӵ�Piece������
				notNullPieces.add(piece);
			}
		}
		return notNullPieces;
	}
	
}
