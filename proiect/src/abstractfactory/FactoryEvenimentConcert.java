package abstractfactory;

import model.common.Eveniment;

public class FactoryEvenimentConcert implements FactoryEveniment{

	@Override
	public Eveniment getEveniment(int numar, String numeEveniment, String numeOrganizator) {		
		return new EvenimentConcert(numar, numeEveniment, numeOrganizator);
	}

}
