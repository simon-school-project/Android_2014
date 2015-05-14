package cn.edu.siso.xueyao.link.board;

import cn.edu.siso.xueyao.link.object.LinkInfo;
import cn.edu.siso.xueyao.link.view.Piece;

public interface GameService {
	
	/*
	 * ������Ϸ��ʼ�ķ���
	 * */
	void start();
	
	/*
	 * ����һ���ӿڷ��������ڷ���һ����ά����
	 * @return ��ŷ������Ķ�ά����
	 * */
	Piece[][] getPieces();
	
	/*
	 * �жϲ���Piece[][]�������Ƿ񻹴��ڷǿյ�Piece����
	 * @return �����ʣPiece�����򷵻�true,û���򷵻�false
	 * */
	boolean hasPieces();
	
	/*
	 * ��������X�����y���꣬���ҳ�һ��Piece����
	 * @Param touchX �������x����
	 * @Param touchY���������y����
	 * @return ���ض�Ӧ��Piece����û���򷵻�null
	 * */
	Piece findPiece(float touchX,float touchY);

		
		/*
		 * �ж�����Piece�Ƿ��������������������ӣ��򷵻�LinkInfo����
		 * @param p1 ��һ��Piece����
		 * @param p2�ڶ���Piece����
		 * @return ��������������򷵻�LinkInfo�����������Piece���������ӣ�����null
		 * */
		LinkInfo link(Piece p1,Piece p2);
	
}
