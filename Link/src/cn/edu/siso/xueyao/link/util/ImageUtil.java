package cn.edu.siso.xueyao.link.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import cn.edu.siso.xueyao.link.view.PieceImage;
import cn.edu.siso.xueyao.link.R;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/*
 * ���ؽ����ͼƬ
 * */
public class ImageUtil
{
	//��������������ͼƬ��Դֵ��int ���ͣ�
	private static List<Integer> imageValues = getImageValues();
	
	//��ȡ����������ͼƬ��ID��Լ������ͼƬID��P_��ͷ��
	private static List<Integer> getImageValues() 
	{
		// TODO Auto-generated method stub
		
		try {
				//�õ�R.drawable���е����ԣ�����ȡdrawableĿ¼�µ�����ͼƬ
				Field[] drawableFields = R.drawable.class.getFields();
				List<Integer> resourceValues = new ArrayList<Integer>();
				for(Field field:drawableFields)
				{
					//�����Field��������P_��ͷ
					if (field.getName().indexOf("p_") != -1)
					{
						resourceValues.add(field.getInt(R.drawable.class));
					}
				}
				return resourceValues;
		} catch (Exception e) 
		{
			// TODO: handle exception
			return null;
		}
		
	}
	
	/*
	 * �����sourceValues �ļ����л�ȡsize��ͼƬID,���ؽ��ΪͼƬID�ļ���
	 * @param sourceValues ���л�ȡ�ļ���
	 * @param size ��Ҫ��ȡ�ĸ���
	 * @return size ��ͼƬID�ļ���
	 * */
	public static List<Integer> getRandomValues(List<Integer> sourceValues,
			int size)
			{
				//����һ�������������
				Random random = new Random();
				
				//�����������
				List<Integer> result = new ArrayList<Integer>();
				for (int i = 0; i < size; i++)
				{
					try 
					{
							//�����ȡһ�����֣����ڡ�С��sourceValues.size()����ֵ					
							int index = random.nextInt(sourceValues.size());
							
							//��ͼƬID�����л�ȡ��ͼƬ����
							Integer image = sourceValues.get(index);
							
							//��ӵ��������
							result.add(image);
							
					} catch (IndexOutOfBoundsException e)
					{
						// TODO: handle exception
						return result;
					}
				}
				return  result;
			}
	
	/*
	 * ��drawableĿ¼���л�ȡsize��ͼƬ��ԴID������sizeΪ��Ϸ����
	 * @param size ��Ҫ��ȡ��ͼƬID������
	 * @return size ��ͼƬID�ļ���
	 * */
	public static List<Integer> getPlayValues(int size)
	{
		if (size%2 !=0)
		{
			//�����������2����������size��1
			size += 1;
		}
		
		//�ٴ����е�ͼƬֵ�������ȡsize��һ������
		List<Integer> playImageValue = getRandomValues(imageValues, size/2);
		
		//��playImageValues���ϵ�Ԫ������һ������֤����ͼƬ������֮��Ե�ͼƬ��
		playImageValue.addAll(playImageValue);
		
		//������ͼƬID�����ϴ�ơ�
		Collections.shuffle(playImageValue);
		return playImageValue;
	}
	
	/*
	 * ��ͼƬID����ת��PieceImage���󼯺ϣ�PieceImage��װ��ͼƬID��ͼƬ����
	 * @param context
	 * @param resourceValues
	 * @return size��PieceImage����ļ���
	 * */
	public static List<PieceImage> getPlayImages(Context context,int size)
	{
		//��ȡͼƬID��ɵļ���
		List<Integer> resourceValues = getPlayValues(size);
		List<PieceImage> result = new ArrayList<PieceImage>();
		
		//����ÿ��ͼƬID
		for(Integer value: resourceValues)
		{
			//����ÿ��ͼƬID
			Bitmap bm = BitmapFactory.decodeResource(
					context.getResources(), value);
			
			//��װͼƬID��ͼƬ����
			PieceImage pieceImage = new PieceImage(bm, value);
			result.add(pieceImage);
		}
		return result;
	}
	
	/*
	 * 
	 * ��ȡѡ�б�ʶ��ͼƬ
	 * 
	 * */
	public static Bitmap getSelectImage(Context context)
	{
		Bitmap bm = BitmapFactory.decodeResource(
				context.getResources(), R.drawable.selected);
		return bm ;
	}
}
