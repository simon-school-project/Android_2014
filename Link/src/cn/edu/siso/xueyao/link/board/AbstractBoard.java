package cn.edu.siso.xueyao.link.board;

import java.util.List;

import cn.edu.siso.xueyao.link.object.GameConf;
import cn.edu.siso.xueyao.link.util.ImageUtil;
import cn.edu.siso.xueyao.link.view.Piece;
import cn.edu.siso.xueyao.link.view.PieceImage;

public abstract class AbstractBoard {
	
	//����һ�����󷽷���������ȥʵ��
	protected abstract List<Piece> createPieces(GameConf config,
						Piece[][] pieces);
	
	public Piece[][] create(GameConf config)
	{
		//����Piece[][]����
		Piece[][] pieces = new Piece[config.getXSize()][config.getYSize()];
		
		//���طǿյ�Piece���ϣ��ü���������ȥ����
		List<Piece> notNullPieces = createPieces(config, pieces);
		
		//���ݷǿ�Piece����ļ��ϵĴ�С��ȡͼƬ
		List<PieceImage> playImages = ImageUtil.getPlayImages(
				config.getContext(), 
					notNullPieces.size());
		
		//����ͼƬ�Ŀ��߶�����ͬ��
		int imageWidth = playImages.get(0).getimage().getWidth();
		int imageHeight = playImages.get(0).getimage().getHeight();
		
		//�����ǿյ�Piece����
		for (int i = 0; i < notNullPieces.size(); i++)
		{
			//���λ�ȡÿ��Piece����
			Piece piece = notNullPieces.get(i);
			
			piece.setImage(playImages.get(i));
			
			//����ÿ���������Ͻǵ�X��Y����
			piece.setBeginX(piece.getIndexX()*imageWidth+config.getBeginImageX());
			piece.setBeginY(piece.getIndexY()*imageHeight+config.getBeginImageY());
			
			//���÷��������뷽���������Ӧλ�ô�
			pieces[piece.getIndexX()][piece.getIndexY()] = piece;
		}
		return pieces;
	}
}
