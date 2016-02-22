package water.eluosifangkuai.service;

import java.awt.Point;
import java.util.List;
import java.util.Random;

import water.eluosifangkuai.dto.GameDto;
import water.eluosifangkuai.dto.Player;
import water.eluosifangkuai.entity.GameAct;

public class GameService {
	/*
	 * ��Ϸ���ݶ���
	 */
	private GameDto dto;

	/*
	 * �����������
	 */
	private Random random = new Random();

	/*
	 * �����������
	 */
	private static final int MAX_TYPE = 6;

	public GameService(GameDto dto) {
		this.dto = dto;
		GameAct act = new GameAct(random.nextInt(MAX_TYPE));
		dto.setGameAct(act);
	}

	/*
	 * ����������ϣ�
	 */
	public void keyUp() {
		this.dto.getGameAct().round(this.dto.getGameMap());
	}

	/*
	 * ����������£�
	 */
	public void keyDown() {
		if (this.dto.getGameAct().move(0, 1, this.dto.getGameMap())) {
			return;
		}
		// �����Ϸ��ͼ����
		boolean[][] map = this.dto.getGameMap();
		// ��÷������
		Point[] act = this.dto.getGameAct().getActPoints();
		// ������ѻ�����ͼ����
		for (int i = 0; i < act.length; i++) {
			map[act[i].x][act[i].y] = true;
		}
		// TODO �ж��Ƿ��������
		// TODO ���в���
		// TODO ��ֲ���
		// TODO �ж��Ƿ�����
		// TODO ����
		// ������һ������
		this.dto.getGameAct().init(this.dto.getNext());
		// �����������һ������
		this.dto.setNext(random.nextInt(MAX_TYPE));

	}

	/*
	 * �����������
	 */
	public void keyLeft() {
		this.dto.getGameAct().move(-1, 0, this.dto.getGameMap());
	}

	/*
	 * ����������ң�
	 */
	public void keyRight() {
		this.dto.getGameAct().move(+1, 0, this.dto.getGameMap());
	}

	// TODO =====================����ר�÷���==============================
	public void testLevelUp(){
		int point = this.dto.getNowPoint();
		int rmLine = this.dto.getNowRemoveLine();
		int lv = this.dto.getNowLevel();
		point += 10;
		rmLine += 1;
		if(rmLine % 20 == 0){
			lv += 1;
		}
		this.dto.setNowPoint(point);
		this.dto.setNowLevel(lv);
		this.dto.setNowRemoveLine(rmLine);
		
	}
	
	public void setDbRecode(List<Player> players){
		this.dto.setDbRecode(players);
	}
	
	public void setDiskRecode(List<Player> players){
		this.dto.setDiskRecode(players);
	}
}