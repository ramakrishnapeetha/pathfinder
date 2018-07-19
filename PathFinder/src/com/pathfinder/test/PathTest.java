package com.pathfinder.test;

import java.util.logging.Logger;

import com.pathfinder.AStarPathFinder;
import com.pathfinder.IPathFinder;
import com.pathfinder.Path;
import com.pathfinder.util.PathFinderUtil;

/**
 * A simple test to show some path finding
 * 
 * @author ramakrishnap
 */
public class PathTest {
	
	public static Logger logger = Logger.getLogger(PathTest.class.getName());
	
	/**
	 * Entry point to our 
	 * 
	 * @param args The arguments passed into the game
	 */
	public static void main(String[] args) {
		
		try{
			TravelMap map = new TravelMap("./resources/large_map.txt");
			PathFinderUtil.DisplayMap(map.getMap());
			
			IPathFinder finder = new AStarPathFinder(map, 500, true);
			Path path = finder.findPath();
			
			PathFinderUtil.DisplayResultPath(map.getMap(), path);
			PathFinderUtil.logResultPath(map.getMap(), path);
		}catch(Exception e){
			System.err.println(e.getMessage());
		}
	}
}

