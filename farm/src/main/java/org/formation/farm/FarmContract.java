package org.formation.farm;

import javax.ejb.Remote;

@Remote
public interface FarmContract {
	public String getDescription();
}
