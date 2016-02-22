package water.eluosifangkuai.ui;

import java.awt.Graphics;

public class LayerPoint extends Layer {

	/*
	 * �������λ��
	 */
	private static final int POINT_BIT = 5;



	

	// TODO �����ļ�
	private static final int LEVEL_UP = 20;
	
	/*
	 * ����y����
	 */
	private final int rmLineY;

	/*
	 * ����y����
	 */
	private final int pointY;

	/*
	 * ����ֵy����
	 */
	private final int expY;

	/*
	 * ����x����
	 */
	private final int comX;

	public LayerPoint(int x, int y, int w, int h) {
		super(x, y, w, h);
		// ��ʼ����ͨX����
		this.comX = this.w - IMG_NUMBER_W * POINT_BIT - PANDDING;
		// ��ʼ��������ʾ��Y����
		this.pointY = PANDDING;
		// ��ʼ��������ʾ��Y����
		this.rmLineY = this.pointY + Img.POINT.getHeight(null) + PANDDING;
		// ��ʼ������ֵ��ʾ��Y����
		this.expY = this.rmLineY + Img.RMLINE.getHeight(null) + PANDDING;

	}

	public void paint(Graphics g) {
		this.createWindow(g);
		// ���Ʊ���(����)
		g.drawImage(Img.POINT, this.x + PANDDING, this.y + pointY, null);
		// ��ʾ����
		this.drawNumberLeftPad(comX, pointY, this.dto.getNowPoint(), POINT_BIT, g);
		// ���Ʊ���(����)
		g.drawImage(Img.RMLINE, this.x + PANDDING, this.y + rmLineY, null);
		// ��ʾ����
		this.drawNumberLeftPad(comX, rmLineY, this.dto.getNowRemoveLine(), POINT_BIT, g);
		// ����ֵ�ۣ�����ֵ��
		int rmLine = this.dto.getNowRemoveLine();
		this.drawRect(expY,"��һ��",null,(double) (rmLine % LEVEL_UP) / (double) LEVEL_UP, g);

	}



}