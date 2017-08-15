package com.nindo.app.extractor;

/**
 * Created by nigelnindo on 8/15/17.
 */
public class Extractor {
    public String extract(String sentence){
        return searchForPlate(splitSentence(sentence)).toUpperCase();
    }

    public String[] splitSentence(String sentence){
        String[] words = sentence.split("\\s+");
        for (int i = 0; i < words.length; i++) {
            // You may want to check for a non-word character before blindly
            // performing a replacement
            // It may also be necessary to adjust the character class
            words[i] = words[i].replaceAll("[^\\w]", "");
        }
        return words;
    }

    public Boolean isPlatePrefix(String word){
        if (!"K".equals(String.valueOf(word.charAt(0)))){
            return false;
        } else if (word.length() != 3){
            return false;
        } else if (word.matches(".*\\d+.*")){
            return false;
        }
        return true;
    }

    public Boolean isPlateSuffix(String word){
        if (word.length() != 4){
            return false;
        } else if (! String.valueOf(word.charAt(3)).matches(".*[a-zA-Z]+.*")){
            System.out.println("Last character not digit");
            return false;
        } else if (! word.substring(0,2).matches("[0-9]+")){
            System.out.println("First 3 chars not numbers");
            System.out.println(word.substring(0,3));
            return false;
        }
        return true;
    }

    public String searchForPlate(String[] wordList){
        PlatePrefix platePrefix = new PlatePrefix("",0);
        String plateSuffix = "";
        String result = "NO PLATE";

        for (int x = 0 ; x < wordList.length ; x++){
            System.out.println("Run loop");
            System.out.println(x);
            System.out.println(platePrefix.index);
            if("".equals(platePrefix.getWord())){
                System.out.println("prefix is empty");
                if (isPlatePrefix(wordList[x])){
                    System.out.println("Set plate prefix");
                    platePrefix.setWord(wordList[x]);
                    platePrefix.setIndex(x);
                }
            } else{
                if ("".equals(plateSuffix)){
                    System.out.println("Plate suffix is empty");
                    if (x - platePrefix.getIndex() == 1){
                        System.out.print("At correct index to search for plate suffix");
                        if (isPlateSuffix(wordList[x])){
                            System.out.println("Set plate suffix");
                            plateSuffix = wordList[x];
                        }
                    } else {
                        if (isPlatePrefix(wordList[x])){
                            platePrefix.setWord(wordList[x]);
                            platePrefix.setIndex(x);
                        }
                    }
                }
            }
        }
        if (!"".equals(plateSuffix)){
            return platePrefix.getWord() + " " + plateSuffix;
        }
        System.out.println(platePrefix.getWord());
        System.out.println(plateSuffix);
        return result;
    }

}
