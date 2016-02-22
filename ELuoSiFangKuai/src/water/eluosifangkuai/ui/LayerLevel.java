package water.eluosifangkuai.ui;

import java.awt.Graphics;

public class LayerLevel extends Layer {
	

	
	/*
	 * ����ͼƬ�Ŀ��
	 */
	private static final int IMG_LV_W=Img.LEVEL.getWidth(null);
	

	
	public LayerLevel(int x,int y,int w,int h){
		super(x,y,w,h);
	}
	
	public void paint(Graphics g){
		this.createWindow(g);
		//���ڱ���
		int centerX=this.w-IMG_LV_W>>1;
		g.drawImage(Img.LEVEL, this.x+centerX, this.y+PANDDING, null);
		//��ʾ�ȼ�
		this.drawNumberLeftPad(centerX, 64, this.dto.getNowLevel(), 2, g);
		
	}

	/*
	 * ��ʾ����
	 * 
	 * @param x ���Ͻ�x����
	 * 
	 * @param y ���Ͻ�y����
	 * 
	 * @param num Ҫ��ʾ������
	 * 
	 * @param maxBit ����λ��
	 * 
	 * @param g ���ʶ���
	 * 
	 */
	
}
