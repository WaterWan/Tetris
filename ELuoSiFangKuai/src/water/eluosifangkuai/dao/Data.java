package water.eluosifangkuai.dao;

import java.util.List;

import water.eluosifangkuai.dto.Player;

/*
 * ���ݳ־ò�ӿ�
 */
public interface Data {

	/*
	 * ��ȡ����
	 */
	public List<Player> loadData();
	
	/*
	 * �洢����
	 */
	public void saveData(List<Player> players);
}
