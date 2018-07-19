package com.pathfinder.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Paths;
import java.util.logging.Logger;

import com.pathfinder.Path;

public class PathFinderUtil {
	
	public static Logger logger = Logger.getLogger(PathFinderUtil.class.getName());
	
	public static void DisplayMap(char[][] grid){
		System.out.println("Map : ");
		for(int i=0;i<grid.length;++i){
			for(int j=0;j<grid[i].length;++j){
				System.out.print(grid[i][j]+" ");
			}
			System.out.println();
		} 
	}
	
	public static void DisplayResultPath(char[][] grid, Path path){
		System.out.println("Shortest Path to reach end location : ");
		for(int i=0;i<grid.length;++i){
			for(int j=0;j<grid[i].length;++j){
				if(path.contains(i,j)){
					System.out.print("# ");
				}else{
					System.out.print(grid[i][j]+" ");
				}
			}
			System.out.println();
		} 
	}
	
	public static void logResultPath(char[][] grid, Path path){
		StringBuilder builder = new StringBuilder();
		for(int i=0;i<grid.length;++i){
			for(int j=0;j<grid[i].length;++j){
				if(path.contains(i,j)){
					builder.append("# ");
				}else{
					builder.append(grid[i][j]+" ");
				}
			}
			builder.append("\n");
		} 
		
		try{
			
			File file = new File(Paths.get("").toAbsolutePath().toString()+"/resources/result.txt");

		    if (!file.exists()) {
		        file.createNewFile();
		    }
		    FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter writer = new BufferedWriter(fw);
			writer.write(builder.toString());
			writer.close();
		}catch(Exception e){
			logger.info("Unable to write result path to file."+e);
		}
	}

}
