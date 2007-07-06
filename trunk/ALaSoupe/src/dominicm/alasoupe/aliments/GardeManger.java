package dominicm.alasoupe.aliments;

import java.util.List;

public interface GardeManger {

	Aliment getAliment(String aliment);

	void createAliment(String aliment);

	List<Aliment> getListAliments();

}
