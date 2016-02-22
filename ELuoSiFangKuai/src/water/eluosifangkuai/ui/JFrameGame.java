package water.eluosifangkuai.ui;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import water.eluosifangkuai.config.ConfigFactory;
import water.eluosifangkuai.config.GameConfig;

public class JFrameGame extends JFrame{

	public JFrameGame(JPanelGame panelGame){
		//�����Ϸ����
		GameConfig cfg=ConfigFactory.getGameConfig();
		//���ñ���
		this.setTitle(cfg.getTitle());
		//���Ĭ�Ϲر����ԣ����������
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//���ô��ڴ�С
		this.setSize(cfg.getWidth(),cfg.getHeight());
		//�������û��ı䴰�ڴ�С
		this.setResizable(false);
		//����
		Toolkit toolkit =Toolkit.getDefaultToolkit();
		Dimension screen =toolkit.getScreenSize();
		int x=(screen.width-this.getWidth())/2;
		int y=(screen.height-this.getHeight())/2-cfg.getWindowUp();
		this.setLocation(x,y);
		//����Ĭ��Panel
		this.setContentPane(panelGame);
		//Ĭ�ϸô���Ϊ��ʾ
		this.setVisible(true);
	}
		
}
