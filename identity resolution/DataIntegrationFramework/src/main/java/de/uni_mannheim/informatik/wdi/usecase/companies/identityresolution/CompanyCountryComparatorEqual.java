/** 
 *
 * Copyright (C) 2015 Data and Web Science Group, University of Mannheim, Germany (code@dwslab.de)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * 		http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package de.uni_mannheim.informatik.wdi.usecase.companies.identityresolution;

import de.uni_mannheim.informatik.wdi.identityresolution.Comparator;
import de.uni_mannheim.informatik.wdi.identityresolution.similarity.EqualsSimilarity;
import de.uni_mannheim.informatik.wdi.usecase.companies.model.Company;

/**
 * {@link Comparator} for {@link Company}s based on the
 * {@link Company#getCountry()} value and their {@link EqualsSimilarity}
 * value.
 * 
 * @author Robert Meusel (robert@dwslab.de)
 * 
 */
public class CompanyCountryComparatorEqual extends Comparator<Company> {

	private EqualsSimilarity<String> sim = new EqualsSimilarity<String>();

	@Override
	public double compare(Company entity1, Company entity2) {
		double similarity = sim.calculate(entity1.getCountry(), entity2.getCountry());

		return similarity;
	}

}
