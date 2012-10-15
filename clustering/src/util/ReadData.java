package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import vo.BankDataVO;

public class ReadData {
	
	public static List<BankDataVO> readData(String filePath) throws FileNotFoundException{
		List<BankDataVO> bankList = new ArrayList<BankDataVO>();
		BankDataVO bankData = null;
		Scanner sc = new Scanner(new File(filePath));
		String[] line = null;
		
		/** Bypass 1st line of input, its plain text. **/
		if(sc.hasNext())
			sc.next();
		
		
		while(sc.hasNext()){
			line = sc.next().split(",");
			bankData = new BankDataVO();
				
			bankData.setId(line[0]);
			bankData.setAge(Integer.parseInt(line[1]));
			bankData.setSex(line[2].charAt(0));
			bankData.setRegion(line[3]);
			bankData.setIncome(Float.parseFloat(line[4]));
			bankData.setMarried("YES".equalsIgnoreCase(line[5]));
			bankData.setNoOfhildren(Integer.parseInt(line[6]));
			bankData.setCar("YES".equalsIgnoreCase(line[7]));
			bankData.setSaveAct("YES".equalsIgnoreCase(line[8]));
			bankData.setCurrentAct("YES".equalsIgnoreCase(line[9]));
			bankData.setMortgage("YES".equalsIgnoreCase(line[10]));
			bankData.setPep("YES".equalsIgnoreCase(line[11]));			
			
			bankList.add(bankData);
		}
		
		return bankList;
	}

}
