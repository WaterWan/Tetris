package water.eluosifangkuai.control;

import water.eluosifangkuai.dao.Data;
import water.eluosifangkuai.dao.DataTest;
import water.eluosifangkuai.service.GameService;
import water.eluosifangkuai.ui.JPanelGame;

/*
 * ������Ҽ����¼�
 * ���ƻ���
 * ������Ϸ�߼�
 * 
 */
public class GameControl {
	
	/*
	 * ���ݷ��ʽӿ�A
	 */
	private Data dataA;
	
	/*
	 * ���ݷ��ʽӿ�B
	 */
	private Data dataB;

	/*
	 * ��Ϸ�����
	 */
	private JPanelGame panelGame;

	/*
	 * ��Ϸ�߼���
	 */
	private GameService gameService;

	public GameControl(JPanelGame panelGame, GameService gameService) {
		this.panelGame = panelGame;
		this.gameService = gameService;
		//�����ݽӿ�A������ݿ��¼
		this.dataA = new DataTest();
		//�������ݿ��¼����Ϸ
		this.dataB = new DataTest();
		//�����ݽӿ�B��ñ��ش��̼�¼
		this.gameService.setDbRecode(dataA.loadData());
		//���ñ��ش��̼�¼����Ϸ
		this.gameService.setDiskRecode(dataB.loadData());
	}

	/*
	 * ��������������ϣ�
	 */
	public void keyUp() {
		this.gameService.keyUp();
		this.panelGame.repaint();
	}

	/*
	 * ��������������£�
	 */
	public void keyDown() {
		this.gameService.keyDown();
		this.panelGame.repaint();
	}

	/*
	 * ���������������
	 */
	public void keyLeft() {
		this.gameService.keyLeft();
		this.panelGame.repaint();
	}

	/*
	 * ��������������ң�
	 */
	public void keyRight() {
		this.gameService.keyRight();
		this.panelGame.repaint();
	}
	
	//TODO ========================����ר�÷���=============
	
	public void testLevelUp(){
		this.gameService.testLevelUp();
		this.panelGame.repaint();
	}

	



}