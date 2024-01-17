package abstractfactory;

import model.common.Eveniment;

public class FactoryEvenimentTeatru implements FactoryEveniment{

	@Override
	public Eveniment getEveniment(int numar, String numeEveniment, String numeOrganizator) {		
		return new EvenimentTeatru(numar, numeEveniment, numeOrganizator);
	}

}