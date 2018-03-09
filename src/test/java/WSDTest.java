import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class WSDTest {

	/*Bender is the word to be checked in the sentence "A metal bender"
	 * Bender word matches with sense1 word "curve"
	 * The expected answer is 1 i.e; Sense1*/
	@Test
	public void testSense1() {
		String word = "bender";

		ArrayList<String> sentence = new ArrayList<String>();
		sentence.add("A");
		sentence.add("metal");
		sentence.add("bender");

		//sense1Sentences
		ArrayList<ArrayList<String>> sense1Sentences = new ArrayList<ArrayList<String>>();
		ArrayList<String> sense1words = new ArrayList<String>();
		ArrayList<String> sense1words_1 = new ArrayList<String>();
		sense1words.add("The");
		sense1words.add("sharp");
		sense1words.add("curve");
		sense1words_1.add("A");
		sense1words_1.add("Curvature");
		sense1words_1.add("Point");
		sense1Sentences.add(sense1words);
		sense1Sentences.add(sense1words_1);

		//sense2Sentences
		ArrayList<ArrayList<String>> sense2Sentences = new ArrayList<ArrayList<String>>();
		ArrayList<String> sense2words = new ArrayList<String>();
		ArrayList<String> sense2words_1 = new ArrayList<String>();
		sense2words.add("The");
		sense2words.add("left");
		sense2words.add("Turn");
		sense2words_1.add("Bend");
		sense2words_1.add("Your");
		sense2words_1.add("Knees");
		sense2Sentences.add(sense2words);
		sense2Sentences.add(sense2words_1);

		WSD ws=new WSD();
		
		int result=ws.disambiguate(word, sentence, sense1Sentences, sense2Sentences);
		assertEquals(1,result);
		
	}

	/*"approve" is the word to be checked in the sentence "please approve the loan"
	 * approve word matches with sense1 word "okay"
	 * The expected answer is 2 i.e; Sense2*/
	@Test
	public void testSense2() {
		String word = "approve";
		ArrayList<String> sentence = new ArrayList<String>();
		sentence.add("please");
		sentence.add("approve");
		sentence.add("the");
		sentence.add("loan");

		//sense1Sentences
		ArrayList<ArrayList<String>> sense1Sentences = new ArrayList<ArrayList<String>>();
		ArrayList<String> sense1words = new ArrayList<String>();
		sense1words.add("Are");
		sense1words.add("You");
		sense1words.add("Alright");
		sense1Sentences.add(sense1words);

		//sense2Sentences
		ArrayList<ArrayList<String>> sense2Sentences = new ArrayList<ArrayList<String>>();
		ArrayList<String> sense2words = new ArrayList<String>();
		ArrayList<String> sense2words_1 = new ArrayList<String>();
		sense2words.add("He");
		sense2words.add("is");
		sense2words.add("okay");
		sense2words.add("now");
		sense2words_1.add("Manager");
		sense2words_1.add("will");
		sense2words_1.add("not");
		sense2words_1.add("sanction");
		sense2words_1.add("the");
		sense2words_1.add("loan");
		sense2Sentences.add(sense2words);
		sense2Sentences.add(sense2words_1);


		WSD ws=new WSD();
		
		int result=ws.disambiguate(word, sentence, sense1Sentences, sense2Sentences);
		assertEquals(2,result);
		
	}

}
