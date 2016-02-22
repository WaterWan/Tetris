package water.eluosifangkuai.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import water.eluosifangkuai.config.ConfigFactory;
import water.eluosifangkuai.config.GameConfig;
import water.eluosifangkuai.dto.GameDto;


/**
 * ���ƴ���
 * @author Lenovo
 *
 */

public abstract class Layer {
	
	protected static final int PANDDING;

	private static final int SIZE ;
	
	static{
		//�����Ϸ����
		GameConfig cfg=ConfigFactory.getGameConfig();
		PANDDING=cfg.getPadding();
		SIZE =cfg.getWindowSize();
	}
	

	
	private static int WINDOW_W=Img.WINDOW.getWidth(null);
	
	private static int WINDOW_H=Img.WINDOW.getHeight(null);
	


	/*
	 * ������Ƭ�Ŀ���
	 */
	protected static final int IMG_NUMBER_W=Img.NUMBER.getWidth(null)/10;
	
	/*
	 * ������Ƭ�ĸ߶�
	 */
	private static final int IMG_NUMBER_H=Img.NUMBER.getHeight(null);
	


	/*
	 * ����ֵ��(�߶�)
	 */
	protected static final int IMG_RECT_H = Img.RECT.getHeight(null);

	/*
	 * ����ֵ��ͼƬ(����)
	 */
	private static final int IMG_RECT_W = Img.RECT.getWidth(null);
	
	/*
	 * ����ֵ��(����)
	 */
	private final int rectW;
	
	/*
	 * Ĭ������
	 */
	private static final Font DEF_FONT= new Font("����", Font.BOLD, 20);
	
	/**
	 * �������Ͻ�x����
	 */
	protected final int x;
	
	/**
	 * �������Ͻ�y����
	 */
	protected final int y;
	
	/**
	 * ���ڿ���
	 */
	protected final int w;
	
	/**
	 * ���ڸ߶�
	 */
	protected final int h;
	
	/*
	 * ��Ϸ����
	 */
	protected GameDto dto=null;

	protected Layer(int x,int y,int w,int h){
		this.x=x;
		this.y=y;
		this.h=h;
		this.w=w;
		this.rectW = this.w - (PANDDING << 1);
	}
	
	/**
	 * ���ƴ���
	 */
	protected void createWindow(Graphics g){
		g.drawImage(Img.WINDOW, x, y, x+SIZE,y+SIZE, 0, 0, SIZE, SIZE, null);//����
		//(����,��ʾ���x,��ʾ���y,��ʾ�յ�x,��ʾ�յ�y,�и����x,�и����y,�и��յ�x,�и��յ�y,null)
		//(a,b,c,d,a1,b1,c1,d1)��ʾ��[��(a1,b1)��(c1,d1)�ľ�������]�Ŵ�[��(a,b)��(c,d)�ľ�������]
		//�����Ͻǵ����굽���½ǵ�����
		g.drawImage(Img.WINDOW, x+SIZE, y, x+w-SIZE,y+SIZE, SIZE, 0, WINDOW_W-SIZE, SIZE, null);//����
		g.drawImage(Img.WINDOW, x+w-SIZE, y, x+w, y+SIZE, WINDOW_W-SIZE, 0, WINDOW_W, SIZE, null);//����
		g.drawImage(Img.WINDOW, x, y+SIZE, x+SIZE, y+h-SIZE, 0, SIZE, SIZE, WINDOW_H-SIZE, null);//����
		g.drawImage(Img.WINDOW, x+SIZE, y+SIZE, x+w-SIZE, y+h-SIZE, SIZE, SIZE, WINDOW_W-SIZE, WINDOW_H-SIZE, null);//��
		g.drawImage(Img.WINDOW, x+w-SIZE, y+SIZE, x+w, y+h-SIZE, WINDOW_W-SIZE, SIZE, WINDOW_W, WINDOW_H-SIZE, null);//����
		g.drawImage(Img.WINDOW, x, y+h-SIZE, x+SIZE, y+h, 0, WINDOW_H-SIZE, SIZE, WINDOW_H, null);//����
		g.drawImage(Img.WINDOW, x+SIZE, y+h-SIZE, x+w-SIZE, y+h, SIZE, WINDOW_H-SIZE, WINDOW_W-SIZE, WINDOW_H, null);//����
		g.drawImage(Img.WINDOW, x+w-SIZE, y+h-SIZE, x+w, y+h, WINDOW_W-SIZE, WINDOW_H-SIZE, WINDOW_W, WINDOW_H, null);//����
	
	}

	/*
	 * ˢ����Ϸ��������
	 * 
	 * @author water
	 * @param g ����
	 */
	abstract public void paint(Graphics g);
	
	public void setDto(GameDto dto) {
		this.dto = dto;
	}
	
	protected void drawNumberLeftPad(int x, int y, int num, int maxBit, Graphics g){
		//��Ҫ��ӡ������ת�����ַ���
		String strNum=Integer.toString(num);
		//ѭ�����������Ҷ���
		for (int i = 0; i < maxBit; i++) {
			//�ж��Ƿ������������
			if (maxBit-i<=strNum.length()) {
				//����������ַ����е��±�
				int idx=i-maxBit+strNum.length();
				//������num�е�ÿһλȡ��
				int bit = strNum.charAt(idx) - '0';
				//��������
				g.drawImage(Img.NUMBER, 
						this.x + x+ IMG_NUMBER_W*i, this.y + y, 
						this.x + x + IMG_NUMBER_W*(i+1), this.y + y + IMG_NUMBER_H,
						bit * IMG_NUMBER_W, 0, 
						(bit + 1) * IMG_NUMBER_W, IMG_NUMBER_H, null);
			}
		}
	}
	
	/*
	 * ����ֵ��
	 */
	protected void drawRect(int y, String title, String number, double percent, Graphics g) {
		// ����ֵ��ʼ��
		int rect_x = this.x + PANDDING;
		int rect_y = this.y + y;
		// ���Ʊ���
		g.setColor(Color.BLACK);
		g.fillRect(rect_x, rect_y, this.rectW, IMG_RECT_H + 4);
		g.setColor(Color.WHITE);
		g.fillRect(rect_x + 1, rect_y + 1, this.rectW - 2, IMG_RECT_H + 2);
		g.setColor(Color.BLACK);
		g.fillRect(rect_x + 2, rect_y + 2, this.rectW - 4, IMG_RECT_H);
		// �������
		int w = (int) (percent * (this.rectW - 4));
		// �����ɫ
		int subIdx = (int) (percent * IMG_RECT_W) - 1;
		// ����ֵ��
		g.drawImage(Img.RECT,
				rect_x + 2, rect_y + 2, 
				rect_x + 2 + w, rect_y + 2 + IMG_RECT_H, 
				subIdx, 0, 
				subIdx + 1,IMG_RECT_H, null);
		g.setColor(Color.WHITE);
		g.setFont(DEF_FONT);
		g.drawString(title, rect_x + 4, rect_y + 22);
		if (number!=null) {
			g.drawString(number, rect_x + 232, rect_y + 22);
		}	
	}
	
	/*
	 * ���л�ͼ
	 */
	protected void drawImageAtCenter(Image img, Graphics g){
		int imgW=img.getWidth(null);
		int imgH=img.getHeight(null);
		g.drawImage(img, this.x+(this.w-imgW>>1), this.y+(this.h-imgH>>1), null);
	}
	
	
}