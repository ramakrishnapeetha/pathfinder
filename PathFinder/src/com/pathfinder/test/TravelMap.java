package com.pathfinder.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.pathfinder.ITileBasedMap;
import com.pathfinder.exception.InvalidMapException;
import com.pathfinder.util.Constants;

/**
 * The data map for example. This holds the state and context of each tile
 * on the map. It also implements the interface required by the path finder. It's implementation
 * of the path finder related methods add specific handling for the types of units
 * and terrain in the example game.
 * 
 * @author ramakrishnap
 */
public class TravelMap implements ITileBasedMap {
	
	private Logger logger = Logger.getLogger(TravelMap.class.getName());
	
	/** The map width in tiles */
	private int WIDTH = 0;
	/** The map height in tiles */
	private int HEIGHT = 0;
	/** Starting point x coordinate */
	private int startX = 0;
	/** Starting point y coordinate */
	private int startY = 0;
	/** end point x coordinate */
	private int endX = 0;
	/** end point y coordinate */
	private int endY = 0;
	
	/** holds non walkable terrain ex.. water */
	private List<Character> nonWalkableTerrain= new ArrayList<Character>();
	
	/** The terrain settings for each tile in the map */
	private char[][] terrain;
	/** Indicator if a given tile has been visited during the search */
	private boolean[][] visited;
	
	/**
	 * Create a new test map with some default configuration
	 */
	public TravelMap(String mapLocation) throws InvalidMapException{
		readMap(mapLocation);
		this.visited = new boolean[getHeightInTiles()][getWidthInTiles()];
	}
	
	private void readMap(String mapFromFile)throws InvalidMapException{
		try{
			File file = new File(mapFromFile);

			BufferedReader reader = new BufferedReader(new FileReader(file));
			String st;
			List<String> list = new ArrayList<String>();
			while ((st = reader.readLine()) != null){
				list.add(st);
			}
			reader.close();
			
			setHeightInTiles(list.size());
			setWidthInTiles(list.get(0).toCharArray().length);
			
			int row = 0;
			for(String str : list){
				int column = 0;
				for(char c :str.toCharArray()){
					setTerrain(row, column, c);
					if(c==Constants.START_TILE){
						setStartLocation(row, column);
					}else if(c==Constants.END_TILE){
						setEndLocation(row, column);
					}
					
					if(c==Constants.WATER){
						getNonWalkableTerrain().add(c);
					}
					
					column++;
				}
				row++;
			}
			
		}catch(Exception exception){
			logger.info("Exception occured while reading map from file.");
			throw new InvalidMapException("Exception occured while reading map from file.", exception);
		}
	}

	/**
	 * @see ITileBasedMap#visited(int, int)
	 */
	public boolean visited(int x, int y) {
		return visited[x][y];
	}
	
	/**
	 * Get the terrain at a given location
	 * 
	 * @param x The x coordinate of the terrain tile to retrieve
	 * @param y The y coordinate of the terrain tile to retrieve
	 * @return The terrain tile at the given location
	 */
	public int getTerrain(int x, int y) {
		return terrain[x][y];
	}
	
	/**
	 * @see ITileBasedMap#blocked(int, int)
	 */
	public boolean blocked(int x, int y) {
		//ex.. if water is at the location, then it's blocked
		return getNonWalkableTerrain().contains(terrain[x][y]);
	}

	/**
	 * @see ITileBasedMap#getCost(int, int, int, int)
	 */
	public float getCost(int sx, int sy, int tx, int ty) {
		
		if(terrain[tx][ty]==Constants.MOUNTAIN){
			return 3;
		}else if(terrain[tx][ty]==Constants.FOREST){
			return 2;
		}else if(terrain[tx][ty]==Constants.FLATLAND_1 ||
				terrain[tx][ty]==Constants.FLATLAND_2 ||
				terrain[tx][ty]==Constants.FLATLAND_3){
			return 1;
		}
		return 0;
	}

	/**
	 * @see ITileBasedMap#getHeightInTiles()
	 */
	public int getHeightInTiles() {
		return HEIGHT;
	}

	/**
	 * @see ITileBasedMap#getWidthInTiles()
	 */
	public int getWidthInTiles() {
		return WIDTH;
	}

	/**
	 * @see ITileBasedMap#pathFinderVisited(int, int)
	 */
	public void pathFinderVisited(int x, int y) {
		visited[x][y] = true;
	}
	
	/**
	 * Will set the start location.
	 * 
	 * @param x The x coordinate of start location.
	 * @param y The y coordinate of start location.
	 */
	public void setStartLocation(int x, int y){
		this.startX=x;
		this.startY=y;
	}
	
	/**
	 * @see ITileBasedMap#getStartX()
	 */
	public int getStartX(){
		return startX;
	}
	
	/**
	 * @see ITileBasedMap#getStartY()
	 */
	public int getStartY(){
		return startY;
	}
	
	/**
	 * Will set the end location.
	 * 
	 * @param x The x coordinate of end location.
	 * @param y The y coordinate of end location.
	 */
	public void setEndLocation(int x, int y){
		this.endX=x;
		this.endY=y;
	}
	
	/**
	 * @see ITileBasedMap#getEndX()
	 */
	public int getEndX(){
		return endX;
	}
	
	/**
	 * @see ITileBasedMap#getEndY()
	 */
	public int getEndY(){
		return endY;
	}
	
	/**
	 * Will set height of the map.
	 * 
	 * @param height The height of the given map.
	 */
	public int setHeightInTiles(int height) {
		return this.HEIGHT=height;
	}

	/**
	 * @see ITileBasedMap#getWidthInTiles()
	 */
	public int setWidthInTiles(int width) {
		return this.WIDTH=width;
	}
	
	/**
	 * Will set the terrain for each tile in the travel map.
	 * 
	 * @param x The x coordinate of tile in the map.
	 * @param y The y coordinate of tile in the map.
	 * 
	 */
	public void setTerrain(int x, int y, char type){
		if(terrain==null){
			terrain = new char[getHeightInTiles()][getWidthInTiles()];
		}
		this.terrain[x][y]=type;
	}

	/**
	 * Will get the non walkable terrain in the map.
	 * 
	 */
	public List<Character> getNonWalkableTerrain() {
		return nonWalkableTerrain;
	}

	/**
	 * Will set the non walkable terrain in the map.
	 * 
	 * @param List the non walkable terrains.
	 * 
	 */
	public void setNonWalkableTerrain(List<Character> nonWalkableTerrain) {
		this.nonWalkableTerrain = nonWalkableTerrain;
	}
	
	public char[][] getMap(){
		return terrain;
	}

	
}

