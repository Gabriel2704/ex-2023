package abstractfactory;

import model.common.Eveniment;

public class EvenimentConcert extends Eveniment{

	public EvenimentConcert(int numar, String numeEveniment, String numeOrganizator) {
		super(numar, numeEveniment, numeOrganizator);
		
	}
	
	public EvenimentConcert(String numeEveniment) {
		super(numeEveniment);		
	}
}
