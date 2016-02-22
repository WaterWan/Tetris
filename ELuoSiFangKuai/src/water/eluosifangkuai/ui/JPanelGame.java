package water.eluosifangkuai.ui;

import java.awt.Graphics;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import water.eluosifangkuai.config.ConfigFactory;
import water.eluosifangkuai.config.GameConfig;
import water.eluosifangkuai.config.LayerConfig;
import water.eluosifangkuai.control.GameControl;
import water.eluosifangkuai.control.PlayerControl;
import water.eluosifangkuai.dto.GameDto;
import water.eluosifangkuai.service.GameService;

public class JPanelGame extends JPanel{

	
	private List<Layer> layers=null;
	
	private GameDto dto=null;
	
	public JPanelGame(GameDto dto){
		//���dto����
		this.dto=dto;
		//��ʼ�����
		initComponent();
		//��ʼ����
		initLayer();
 }
	/*
	 * ��װ��ҿ�����
	 */
	public void setGameControl(PlayerControl control){
		this.addKeyListener(control);
	}
	

	/*
	 * ��ʼ�����
	 */
	private void initComponent(){

	}
	/*
	 * ��ʼ����
	 */
	private void initLayer(){
		try {
			//�����Ϸ����
			GameConfig cfg=ConfigFactory.getGameConfig();
			//��ò�����
			List<LayerConfig> layersCfg=cfg.getLayersConfig();
			//������Ϸ������
			layers=new ArrayList<Layer>(layersCfg.size());
			//�������в����
		for(LayerConfig layerCfg : layersCfg){
			//��������		
			Class<?> cls=Class.forName(layerCfg.getClassName());
			//��ù��캯����
			Constructor<?> ctr=cls.getConstructor(int.class,int.class,int.class,int.class);
			//���ù��캯�����������
			Layer layer=(Layer)ctr.newInstance(
					layerCfg.getX(),
					layerCfg.getY(),
					layerCfg.getW(),
					layerCfg.getH()
					);
			//������Ϸ���ݶ���
			layer.setDto(this.dto);
			//�Ѵ�����Layer������뼯�ϡ�
			layers.add(layer);
		
			}		
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	
	@Override
	public void paintComponent(Graphics g){
		//���û��෽��
		super.paintComponent(g);
		//������Ϸ����
		for(int i=0;i<layers.size();layers.get(i++).paint(g));
		//���ؽ���
		this.requestFocus();
	
	}
}


