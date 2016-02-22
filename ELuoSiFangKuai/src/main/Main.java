package main;

import water.eluosifangkuai.control.GameControl;
import water.eluosifangkuai.control.PlayerControl;
import water.eluosifangkuai.dto.GameDto;
import water.eluosifangkuai.service.GameService;
import water.eluosifangkuai.ui.JFrameGame;
import water.eluosifangkuai.ui.JPanelGame;

public class Main {

	public static void main(String[] args) {
		//������Ϸ����Դ
		GameDto dto=new GameDto();
		//������Ϸ���
		JPanelGame panel=new JPanelGame(dto);
		//������Ϸ�߼��飨������Ϸ����Դ��
		GameService service=new GameService(dto);
		//������Ϸ��������������Ϸ�������Ϸ�߼��飩
		GameControl gameControl= new GameControl(panel, service);
		//������ҿ�������������Ϸ��������
		PlayerControl control=new PlayerControl(gameControl);
		//��װ��ҿ�����
		panel.setGameControl(control);
		//������Ϸ���ڣ���װ��Ϸ���
		new JFrameGame(panel);
	}

}
