package abstractfactory;

import model.common.Eveniment;

public class EvenimentTeatru extends Eveniment{
	public EvenimentTeatru(int numar, String numeEveniment, String numeOrganizator) {
		super(numar, numeEveniment, numeOrganizator);
		
	}
	
	public EvenimentTeatru(String numeEveniment) {
		super(numeEveniment);		
	}
}
