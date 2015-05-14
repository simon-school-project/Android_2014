package cn.edu.siso.xueyao.link.board.imp;

import java.util.ArrayList;
import java.util.List;

import cn.edu.siso.xueyao.link.board.AbstractBoard;
import cn.edu.siso.xueyao.link.object.GameConf;
import cn.edu.siso.xueyao.link.view.Piece;

/*
 * �������еķ���
 * */
public class VerticalBoard extends AbstractBoard 
{

	@Override
	protected List<Piece> createPieces(GameConf config, Piece[][] pieces) {
		// TODO Auto-generated method stub
		
		//����һ��Piece���ϣ��ü��������ų�ʼ����Ϸʱ�����Piece����
		List<Piece> notNullPieces = new ArrayList<Piece>();
		
		//�����жϣ�����һ��������ȥ����Piece���󣬲��ӵ�������
		for (int i = 0; i < pieces.length; i++)
		{
			for (int j = 0; j < pieces[i].length; j++)
			{
				if (i %2 == 0)
				{
					/**
					 * ���x�ܱ�2�������������в��ᴴ������
					 * �ȹ���һ��Piece����ֻ��������Piece[][]�����е�����ֵ
					 * ����Ҫ��PieceImage���丸�ฺ������
					 * */
					Piece piece = new Piece(i, j);
					
					//��ӵ�Piece������
					notNullPieces.add(piece);
				}
			}
		}
		return notNullPieces;
	}

}
