package water.eluosifangkuai.ui;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import water.eluosifangkuai.config.ConfigFactory;
import water.eluosifangkuai.config.GameConfig;

public class JFrameGame extends JFrame{

	public JFrameGame(JPanelGame panelGame){
		//获得游戏配置
		GameConfig cfg=ConfigFactory.getGameConfig();
		//设置标题
		this.setTitle(cfg.getTitle());
		//设计默认关闭属性（程序结束）
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//设置窗口大小
		this.setSize(cfg.getWidth(),cfg.getHeight());
		//不允许用户改变窗口大小
		this.setResizable(false);
		//居中
		Toolkit toolkit =Toolkit.getDefaultToolkit();
		Dimension screen =toolkit.getScreenSize();
		int x=(screen.width-this.getWidth())/2;
		int y=(screen.height-this.getHeight())/2-cfg.getWindowUp();
		this.setLocation(x,y);
		//设置默认Panel
		this.setContentPane(panelGame);
		//默认该窗口为显示
		this.setVisible(true);
	}
		
}
