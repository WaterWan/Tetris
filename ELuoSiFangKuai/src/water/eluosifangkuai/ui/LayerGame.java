package water.eluosifangkuai.ui;

import java.awt.Graphics;
import java.awt.Point;


public class LayerGame extends Layer {
	

	//TODO �����ļ�
	private static final int ACT_SIZE=32;
	
	public LayerGame(int x,int y,int w,int h){
		super(x,y,w,h);
	}
	
	public void paint(Graphics g){
		this.createWindow(g);	
		//��÷������鼯��
		Point[] points=this.dto.getGameAct().getActPoints();
		//��÷������ͱ��(0-6)
		int typeCode=this.dto.getGameAct().getTypeCode();
		
		//��ӡ����
		for(int i=0;i<points.length;i++){
			g.drawImage(Img.ACT, 
					this.x + points[i].x * ACT_SIZE + 7,
					this.y + points[i].y * ACT_SIZE + 7, 
					this.x + points[i].x * ACT_SIZE + ACT_SIZE + 7,
					this.y + points[i].y * ACT_SIZE + ACT_SIZE + 7,
					(typeCode+1)* ACT_SIZE, 0, (typeCode+2)* ACT_SIZE, ACT_SIZE, null);
		}
		
		//��ӡ��ͼ
		boolean[][] map =this.dto.getGameMap();
		for (int x = 0; x < map.length; x++) {
			for (int y = 0; y < map[x].length; y++) {
				if (map[x][y]) {
					g.drawImage(Img.ACT,
							this.x + x * ACT_SIZE + 7,
							this.y + y * ACT_SIZE + 7, 
							this.x + x * ACT_SIZE + ACT_SIZE + 7,
							this.y + y * ACT_SIZE + ACT_SIZE + 7,
							0, 0, 32, 32, null);
				}
				
			}
		}
		
		
	}
}