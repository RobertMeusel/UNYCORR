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
package de.uni_mannheim.informatik.wdi.identityresolution.similarity.string;

import com.wcohen.ss.Jaccard;
import com.wcohen.ss.tokens.SimpleTokenizer;

import de.uni_mannheim.informatik.wdi.identityresolution.similarity.SimilarityMeasure;

/**
 * {@link SimilarityMeasure}, that calculates the Jaccard similarity between two
 * strings.
 * 
 * @author Oliver Lehmberg (oli@dwslab.de)
 * 
 */
public class TokenizingJaccardSimilarity extends SimilarityMeasure<String> {

	@Override
	public double calculate(String first, String second) {
		if(first==null || second==null) {
			return 0.0;
		} else {
			Jaccard j = new Jaccard(new SimpleTokenizer(true, true));
			return j.score(first, second);
		}
	}

}
