package water.eluosifangkuai.dao;

import java.util.ArrayList;
import java.util.List;

import water.eluosifangkuai.dto.Player;

public class DataTest implements Data {

	@Override
	public List<Player> loadData() {
		List<Player> players = new ArrayList<>();
		players.add(new Player("����", 100));
		players.add(new Player("����", 1000));
		players.add(new Player("����", 2000));
		players.add(new Player("����", 3000));
		players.add(new Player("����", 4000));
		return players;
	}

	@Override
	public void saveData(List<Player> players) {

		System.out.println();
	}

}
