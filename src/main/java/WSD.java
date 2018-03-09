import java.io.*;
import java.util.*;

import net.didion.jwnl.*;
import net.didion.jwnl.data.*;
import net.didion.jwnl.dictionary.Dictionary;

public class WSD {
	public static int disambiguate(String word, ArrayList<String> sentence,
			ArrayList<ArrayList<String>> sense1Sentences,
			ArrayList<ArrayList<String>> sense2Sentences)

	{
		int result = 0;
		ArrayList<String> sense1SentencesResult = new ArrayList<String>();
		ArrayList<String> sense2SentencesResult = new ArrayList<String>();
		ArrayList<String> resultList = new ArrayList<String>();
		try {
			JWNL.initialize(new FileInputStream("./properties.xml"));

			Dictionary dict = Dictionary.getInstance();

			for (ArrayList<String> sense1SentencesArray : sense1Sentences) {
				for (String sense1SentencesStr : sense1SentencesArray) {
					IndexWord noun_form = dict.lookupIndexWord(POS.NOUN,
							sense1SentencesStr);
					if (noun_form != null && noun_form.getSenseCount() > 0) {
						for (Synset nounSynset : noun_form.getSenses()) {
							if (!sense1SentencesResult.contains(nounSynset.getOffset())) {
								for (Word senseword : nounSynset.getWords()) {
									sense1SentencesResult.add(nounSynset.getOffset()
											+ "-" + senseword.getLemma() + "-"
											+ senseword.getPOS());
								}

							}
						}
					}
					IndexWord adj_form = dict.lookupIndexWord(POS.ADJECTIVE,
							sense1SentencesStr);
					if (adj_form != null && adj_form.getSenseCount() > 0) {
						for (Synset adjSynset : adj_form.getSenses()) {
							if (!sense1SentencesResult.contains(adjSynset.getOffset())) {
								for (Word senseword : adjSynset.getWords()) {
									sense1SentencesResult.add(adjSynset.getOffset()
											+ "-" + senseword.getLemma() + "-"
											+ senseword.getPOS());
								}
							}
						}
					}
					IndexWord adv_form = dict.lookupIndexWord(POS.ADVERB,
							sense1SentencesStr);
					if (adv_form != null && adv_form.getSenseCount() > 0) {
						for (Synset advSynset : adv_form.getSenses()) {
							if (!sense1SentencesResult.contains(advSynset.getOffset())) {
								for (Word senseword : advSynset.getWords()) {
									sense1SentencesResult.add(advSynset.getOffset()
											+ "-" + senseword.getLemma() + "-"
											+ senseword.getPOS());
								}
							}
						}
					}
					IndexWord verb_form = dict.lookupIndexWord(POS.VERB,
							sense1SentencesStr);
					if (verb_form != null && verb_form.getSenseCount() > 0) {
						for (Synset verbSynset : verb_form.getSenses()) {
							if (!sense1SentencesResult.contains(verbSynset.getOffset())) {
								for (Word senseword : verbSynset.getWords()) {
									sense1SentencesResult.add(verbSynset.getOffset()
											+ "-" + senseword.getLemma() + "-"
											+ senseword.getPOS());
								}
							}
						}
					}
				}
			}
			//System.out.println(sense1SentencesResult);
			for (ArrayList<String> sense2SentencesArray : sense2Sentences) {
				for (String sense1SentencesStr : sense2SentencesArray) {

					IndexWord noun_form = dict.lookupIndexWord(POS.NOUN,
							sense1SentencesStr);
					if (noun_form != null && noun_form.getSenseCount() > 0) {
						for (Synset nounSynset : noun_form.getSenses()) {
							if (!sense2SentencesResult.contains(nounSynset.getOffset())) {
								for (Word senseword : nounSynset.getWords()) {
									sense2SentencesResult.add(nounSynset.getOffset()
											+ "-" + senseword.getLemma() + "-"
											+ senseword.getPOS());
								}

							}
						}
					}
					IndexWord adj_form = dict.lookupIndexWord(POS.ADJECTIVE,
							sense1SentencesStr);
					if (adj_form != null && adj_form.getSenseCount() > 0) {
						for (Synset adjSynset : adj_form.getSenses()) {
							if (!sense2SentencesResult.contains(adjSynset.getOffset())) {
								for (Word senseword : adjSynset.getWords()) {
									sense2SentencesResult.add(adjSynset.getOffset()
											+ "-" + senseword.getLemma() + "-"
											+ senseword.getPOS());
								}
							}
						}
					}
					IndexWord adv_form = dict.lookupIndexWord(POS.ADVERB,
							sense1SentencesStr);
					if (adv_form != null && adv_form.getSenseCount() > 0) {
						for (Synset advSynset : adv_form.getSenses()) {
							if (!sense2SentencesResult.contains(advSynset.getOffset())) {
								for (Word senseword : advSynset.getWords()) {
									sense2SentencesResult.add(advSynset.getOffset()
											+ "-" + senseword.getLemma() + "-"
											+ senseword.getPOS());
								}
							}
						}
					}
					IndexWord verb_form = dict.lookupIndexWord(POS.VERB,
							sense1SentencesStr);
					if (verb_form != null && verb_form.getSenseCount() > 0) {
						for (Synset verbSynset : verb_form.getSenses()) {
							if (!sense2SentencesResult.contains(verbSynset.getOffset())) {
								for (Word senseword : verbSynset.getWords()) {
									sense2SentencesResult.add(verbSynset.getOffset()
											+ "-" + senseword.getLemma() + "-"
											+ senseword.getPOS());
								}
							}
						}
					}
				}
			}
			//System.out.println(sense2SentencesResult);
			for (String str : sentence) {
				if (str.contains(word)) {
					IndexWord noun_form = dict.lookupIndexWord(POS.NOUN, str);
					if (noun_form != null && noun_form.getSenseCount() > 0) {
						for (Synset nounSynset : noun_form.getSenses()) {
							if (!sense2SentencesResult.contains(nounSynset.getOffset())) {
								for (Word senseword : nounSynset.getWords()) {
									resultList.add(nounSynset.getOffset() + "-"
											+ senseword.getLemma() + "-"
											+ senseword.getPOS());
								}
							}
						}
					}
					IndexWord adj_form = dict.lookupIndexWord(POS.ADJECTIVE,
							str);
					if (adj_form != null && adj_form.getSenseCount() > 0) {
						for (Synset adjSynset : adj_form.getSenses()) {
							if (!sense2SentencesResult.contains(adjSynset.getOffset())) {
								for (Word senseword : adjSynset.getWords()) {
									resultList.add(adjSynset.getOffset() + "-"
											+ senseword.getLemma() + "-"
											+ senseword.getPOS());
								}
							}
						}
					}
					IndexWord adv_form = dict.lookupIndexWord(POS.ADVERB, str);
					if (adv_form != null && adv_form.getSenseCount() > 0) {
						for (Synset advSynset : adv_form.getSenses()) {
							if (!sense2SentencesResult.contains(advSynset.getOffset())) {
								for (Word senseword : advSynset.getWords()) {
									resultList.add(advSynset.getOffset() + "-"
											+ senseword.getLemma() + "-"
											+ senseword.getPOS());
								}
							}
						}
					}
					IndexWord verb_form = dict.lookupIndexWord(POS.VERB, str);
					if (verb_form != null && verb_form.getSenseCount() > 0) {
						for (Synset verbSynset : verb_form.getSenses()) {
							if (!sense2SentencesResult.contains(verbSynset.getOffset())) {
								for (Word senseword : verbSynset.getWords()) {
									resultList.add(verbSynset.getOffset() + "-"
											+ senseword.getLemma() + "-"
											+ senseword.getPOS());
								}
							}
						}
					}
				}
			}
			//System.out.println(resultList);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (JWNLException e) {
			e.printStackTrace();
		}

		if (resultList.removeAll(sense1SentencesResult)) {
			result = 1;
		} else if (resultList.removeAll(sense2SentencesResult)) {
			result = 2;
		}

		return result;
	}

}