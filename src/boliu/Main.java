package boliu;

import boliu.TraClusterDoc.Parameter;

public class Main {
		
	public static void main(String[] args) {
		
		if (args.length == 4) {
			TraClusterDoc tcd = new TraClusterDoc();
			tcd.onOpenDocument(args[0]);
			tcd.onClusterGenerate(args[1], Integer.parseInt(args[2]), Integer.parseInt(args[3])); // 25, 5~7
		} else if (args.length == 2) {
			TraClusterDoc tcd = new TraClusterDoc();
			tcd.onOpenDocument(args[0]);

			Parameter p = tcd.onEstimateParameter();
			if (p != null) {				
				System.out.println("Based on the algorithm, the suggested parameters are:\n"+"eps:" + p.epsParam + "  minLns:" + p.minLnsParam);
			} 
			tcd.onClusterGenerate(args[1], p.epsParam, p.minLnsParam);									
		} else {
			System.out.println("Please give me 2 or 4 input parameters! \n "
					+ "If you have no idea how to decide eps and minLns, just feed in 2 parameters (inputFilePath, outputFilePath):\n"
					+ "--e.g. java boliu.Main deer_1995.tra testOut.txt \n"
					+ "If you know the two parameters, just feed in all the 4 parameters (inputFilePath, outputFilePath, eps, minLns)"
					+ "--e.g. java boliu.Main deer_1995.tra testOut.txt 29 8 \n");
		}

/**
 * To use the GUI, Remove the below comment and comment out the above section of code
 * An adjustable GUI is to be added.
 */
/*
		TraClusterDoc tcd = new TraClusterDoc();
		
		//tcd.onOpenDocument("src/deer_1995.tra");		
		//tcd.onClusterGenerate("testDeerResult.txt", 29, 8);
		
		//tcd.onOpenDocument("src/hurricane1950_2006.tra");
		//tcd.onClusterGenerate("testHurricaneResult.txt", 32, 6);
		
		tcd.onOpenDocument("src/elk_1993.tra");
		tcd.onClusterGenerate("testElkResult.txt", 25, 5);// 25, 5~7
		
		MainFrame mf = new MainFrame(tcd.m_trajectoryList, tcd.m_clusterList);
		
		
		Parameter p = tcd.onEstimateParameter();
		if (p != null) {
			System.out.println("Based on the algorithm, the suggested parameters are:\n" + "eps:" + p.epsParam + "  minLns:" + p.minLnsParam);
		}
*/
	}
	
}
