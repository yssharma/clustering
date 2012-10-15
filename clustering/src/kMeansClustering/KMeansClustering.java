package kMeansClustering;

import graphplot.PlotGraphKMeans;

import java.io.FileNotFoundException;
import java.util.List;

import org.jfree.ui.RefineryUtilities;

import util.DataUtil;
import util.ReadData;
import vo.BankDataVO;

public class KMeansClustering {
	
	float[][] data;
	int noOfClusters;
	float[][] centroids;
	float[][] distanceMatrix;
	int[][] groupMatrix;
	int[][] newGroupMatrix;
	
	
	
	public static void main(String[] args) throws FileNotFoundException{
		
		new KMeansClustering().init();
		
	}
	
	private void init() throws FileNotFoundException{
		String filePath = "bank-data.csv";
		noOfClusters = 3;
		
		System.out.println("Reading bank data from :"+filePath);
		List<BankDataVO> dataList = ReadData.readData(filePath);
		data = DataUtil.getAgeSalaryMatrix(dataList, 1000);
		DataUtil.printMatrix(data);
		kMeans();
		
		plotGraph("K-Means Plot", data, newGroupMatrix);
		
	}	
	
	
	private void kMeans(){
		centroids = getInitialCentriods();
		distanceMatrix = new float[data.length][noOfClusters];
		
		System.out.println("\nInitial Centroids:");
		DataUtil.printMatrix(centroids);
		
		do{
			groupMatrix = newGroupMatrix;
			calculateDistanceFromCentroids();			
			
			groupByShortestDistance();
			
			calculateNewCentroids();
			System.out.println("\nNew Centroids:");
			DataUtil.printMatrix(centroids);
			
			System.gc();			
		}while(!DataUtil.equalsMatrix(newGroupMatrix, groupMatrix));		
		
		System.out.println("Done..");
	}
	


	private void calculateDistanceFromCentroids() {
		
		for(int i=0; i<data.length; i++){
			for(int j=0; j<centroids.length; j++){
			distanceMatrix[i][j] = (float)Math.sqrt((data[i][0] - centroids[j][0])*(data[i][0] - centroids[j][0]) + (data[i][1] - centroids[j][1])*(data[i][1] - centroids[j][1]));
			}
		}		
	}

	
	

	private void groupByShortestDistance() {
		float minDist = 0;
		int minIndex = 0;
		newGroupMatrix = new int[data.length][noOfClusters];
		
		for(int i=0; i<data.length; i++){
			minDist = distanceMatrix[i][0];
			minIndex = 0;
			
			for(int j=0; j<noOfClusters; j++){
				if(minDist > distanceMatrix[i][j])
				{
					minDist = distanceMatrix[i][j];
					minIndex = j;
				}
			}
			
			for(int j=0; j<noOfClusters; j++){				
				if(j==minIndex){
				newGroupMatrix[i][j] = 1;
				}
			}
		}	
	}
	
	

	private void calculateNewCentroids() {	
		int[] noOfCoordinates = new int[noOfClusters];
		centroids = new float[noOfClusters][2];
		
		for(int i=0; i<newGroupMatrix.length; i++){
			for(int j=0; j<newGroupMatrix[i].length; j++)
			{
				if(newGroupMatrix[i][j] == 1){
					centroids[j][0] += data[i][0];
					centroids[j][1] += data[i][1];
					noOfCoordinates[j]++;
				}
			}
		}
		
		System.out.println("\nNo of points per group:");
		DataUtil.printMatrix(noOfCoordinates);
		
		for(int j=0; j<centroids.length; j++){
			centroids[j][0] /= noOfCoordinates[j];
			centroids[j][1] /= noOfCoordinates[j];
		}	
	}
	
	
	private float[][] getInitialCentriods(){
		float[][] centroids = new float[noOfClusters][2];
		
		for(int i=0; i<noOfClusters; i++){
			centroids[i][0] = data[i][0];
			centroids[i][1] = data[i][1];			
		}
		
		return centroids;
	}
	
	
	private void plotGraph(String title, float[][] data, int[][] groupMtrix){
		PlotGraphKMeans scatterplot = new PlotGraphKMeans("K-Means Clustering", data, groupMtrix);
        scatterplot.pack();
        RefineryUtilities.centerFrameOnScreen(scatterplot);
        scatterplot.setVisible(true);
	}

}



