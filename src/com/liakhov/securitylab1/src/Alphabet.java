package com.liakhov.securitylab1.src;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Alphabet {
	
	private Map<Character, Integer> mapAlphabet;


	public Alphabet(){
		mapAlphabet = new TreeMap<>();
		for(char symb = 'a'; symb <= 'z'; symb++){
			mapAlphabet.put(symb, 0);
		}
        mapAlphabet.put(' ', 0);
	}

	public Map<Character, Double> getProbabilityOfChar(){
		Map<Character, Double> map = new TreeMap<>();
        int sumOfValues = sumOfValuesMap();

		for(Entry<Character, Integer> entry : mapAlphabet.entrySet()){
			map.put(entry.getKey(), (double)entry.getValue() / sumOfValues);
		}
		return map;
	}

    private int sumOfValuesMap(){
        int sum = 0;
        for(Entry<Character, Integer> entry : mapAlphabet.entrySet()){
            sum += entry.getValue();
        }
        return sum;
    }
	
	public void addString(String str) {
		String newStr = str.toLowerCase();
		for(int i = 0; i < newStr.length(); i++){
			addChar(newStr.charAt(i));
		}
	}
	
	private void addChar(char symbol){
		if(mapAlphabet.containsKey(symbol)){
			mapAlphabet.put(symbol, mapAlphabet.get(symbol) + 1);
		}
	}

    @Override
    public String toString() {
        Map<Character, Double> map = getProbabilityOfChar();

        ValueComparator bvc = new ValueComparator(map);
        Map<Character, Double> sortedMap = new TreeMap<>(bvc);

        sortedMap.putAll(map);

        String result = "Alphabet\n";

        for (Entry<Character, Double> entry : sortedMap.entrySet()){
            if(entry.getValue() == 0){
                break;
            }
            result += String.format("'%c' = %.6f\n", entry.getKey(), entry.getValue());
        }

        return result;
    }
}
