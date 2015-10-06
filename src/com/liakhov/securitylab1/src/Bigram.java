package com.liakhov.securitylab1.src;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

public class Bigram {
	
	private Map<String, Integer> mapBigrams;

	public Bigram(){
        mapBigrams = new HashMap<>();

		for(char c = 'a'; c <= 'z'; c++){
			for(char z = 'a'; z <= 'z'; z++) {
				mapBigrams.put(new StringBuilder().append(c).append(z).toString(), 0);
			}
		}
	}
	
	public void addString(String str){
		String newStr = str.toLowerCase();
		for(int i = 0; i < newStr.length() - 1; i++){
			addBigram(new StringBuilder().append(newStr.charAt(i))
							.append(newStr.charAt(i+1)).toString());
		}
	}
	
	private void addBigram(String bigram){
		if(mapBigrams.containsKey(bigram)){
			mapBigrams.put(bigram, mapBigrams.get(bigram) + 1);
		}
	}

    private int sumOfValuesMap(){
        int sum = 0;
        for(Entry<String, Integer> entry : mapBigrams.entrySet()){
            sum += entry.getValue();
        }
        return sum;
    }


    public Map<String, Double> getProbabilityOfBigram(){
		Map<String, Double> map = new TreeMap<>();
        int sum = sumOfValuesMap();
		for(Entry<String, Integer> entry : mapBigrams.entrySet()){
			map.put(entry.getKey(), (double)entry.getValue() / sum);
		}
		return map;
	}

    @Override
    public String toString() {
        String result = "Bigrams\n";
        Map<String, Double> map = getProbabilityOfBigram();

        ValueComparator bvc = new ValueComparator(map);
        Map<String, Double> sortedMap = new TreeMap<>(bvc);

        sortedMap.putAll(map);

        for (Entry<String, Double> entry : sortedMap.entrySet()){
            if(entry.getValue() == 0){
                break;
            }
            result += String.format("%s = %.6f\n", entry.getKey(), entry.getValue());
        }

        return result;
    }
}
