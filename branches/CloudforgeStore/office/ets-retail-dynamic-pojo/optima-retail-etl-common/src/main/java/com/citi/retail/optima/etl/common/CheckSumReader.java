package com.citi.retail.optima.etl.common;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;

public class CheckSumReader {

      public static void main(String[] args) {}
      
      public static BigDecimal calculateCheckSum(String fileName){


          BufferedReader br = null;

          try {

                String sCurrentLine = "";

                br = new BufferedReader(new FileReader(fileName));

                Double dub = new Double("0");
                

                while ((sCurrentLine = br.readLine()) != null) {
                      
                      if (sCurrentLine != null && !sCurrentLine.isEmpty() && sCurrentLine.matches("[0-9.-]*")){
                    	  dub = dub + (new Double(sCurrentLine));
                      }
                      
                }
                return new BigDecimal(dub).setScale(5, BigDecimal.ROUND_HALF_UP);

          } catch (IOException e) {
                e.printStackTrace();
          } finally {
                try {
                      if (br != null)br.close();
                } catch (IOException ex) {
                      ex.printStackTrace();
                }
          }

          return null;
      }
      
      public static BigDecimal calculateOutputCheckSum(String fileName){
          BufferedReader br = null;

          try {

                String sCurrentLine = "";

                br = new BufferedReader(new FileReader(fileName));

                Double dub = new Double("0");
                

                while ((sCurrentLine = br.readLine()) != null) {
                	if(sCurrentLine != null && !sCurrentLine.isEmpty()){
                    String[] strArray = sCurrentLine.split("\\|");
                    if(strArray.length == 2){
                           if(strArray[0].trim().equals("265")){
                               if (strArray[1] != null && !strArray[1].isEmpty() && strArray[1].matches("[0-9.-]*")){
                                    dub = dub + (new Double(strArray[1]));
                               }
                           }
                    	}
                	}
                }
                return new BigDecimal(dub).setScale(5, BigDecimal.ROUND_HALF_UP);

          } catch (IOException e) {
                e.printStackTrace();
          } finally {
                try {
                      if (br != null)br.close();
                } catch (IOException ex) {
                      ex.printStackTrace();
                }
          }

          return null;
      
      }
}
