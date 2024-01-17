package abstractfactory;

import model.common.Eveniment;

public interface FactoryEveniment {
	public Eveniment getEveniment(int numar, String numeEveniment, String numeOrganizator);
}