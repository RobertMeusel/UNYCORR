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
package de.uni_mannheim.informatik.wdi.identityresolution.similarity.date;

import org.joda.time.DateTime;
import org.joda.time.Years;

import de.uni_mannheim.informatik.wdi.identityresolution.similarity.SimilarityMeasure;

/**
 * {@link SimilarityMeasure}, that calculates the similarity of the year parts
 * of two dates with respect to a maximum difference.
 * 
 * @author Oliver Lehmberg (oli@dwslab.de)
 * 
 */
public class YearSimilarity extends SimilarityMeasure<DateTime> {

	private int maxDifference;

	/**
	 * Initialize {@link YearSimilarity} with a maximal difference (in years).
	 * In case the difference is larger the maximal difference, the calculated
	 * similarity is 0. In the other cases its 1-(diff/maxDifference).
	 * 
	 * @param maxDifference
	 *            maximal difference between two dates in years.
	 */
	public YearSimilarity(int maxDifference) {
		this.maxDifference = maxDifference;
	}

	@Override
	public double calculate(DateTime first, DateTime second) {
		if (first == null || second == null) {
			return 0.0;
		} else {
			int diff = Math.abs(Years.yearsBetween(first, second).getYears());
			double norm = Math.min((double) diff / (double) maxDifference, 1.0);

			return 1 - norm;
		}
	}

}
