package com.pathfinder;

/**
 * The description for the data we're path finding over. This provides the contract
 * between the data being searched (i.e. the in Travel map) and the path finding
 * generic tools
 * 
 * @author ramakrishnap
 */
public interface ITileBasedMap {
	/**
	 * Get the width of the tile map.
	 * 
	 * @return The number of tiles across the map
	 */
	public int getWidthInTiles();

	/**
	 * Get the height of the tile map.
	 * 
	 * @return The number of tiles down the map
	 */
	public int getHeightInTiles();
	
	/**
	 * Notification that the path finder visited a given tile. This is 
	 * used for debugging new heuristics.
	 * 
	 * @param x The x coordinate of the tile that was visited
	 * @param y The y coordinate of the tile that was visited
	 */
	public void pathFinderVisited(int x, int y);
	
	/**
	 * Check if the given location is blocked.
	 * 
	 * @param x The x coordinate of the tile to check
	 * @param y The y coordinate of the tile to check
	 * @return True if the location is blocked
	 */
	public boolean blocked(int x, int y);
	
	/**
	 * Get the cost of moving through the given tile. This can be used to 
	 * make certain areas more desirable.
	 * 
	 * @param sx The x coordinate of the tile we're moving from
	 * @param sy The y coordinate of the tile we're moving from
	 * @param tx The x coordinate of the tile we're moving to
	 * @param ty The y coordinate of the tile we're moving to
	 * @return The relative cost of moving across the given tile
	 */
	public float getCost(int sx, int sy, int tx, int ty);
	
	/**
	 * Get the x coordinate of the start location of the tile map.
	 * 
	 * @return integer value of the start location x coordinate
	 */
	public int getStartX();
	
	/**
	 * Get the y coordinate of the start location of the tile map.
	 * 
	 * @return integer value of the start location y coordinate
	 */
	public int getStartY();
	
	/**
	 * Get the x coordinate of the end location of the tile map.
	 * 
	 * @return integer value of the end location x coordinate
	 */
	public int getEndX();
	
	/**
	 * Get the y coordinate of the end location of the tile map.
	 * 
	 * @return integer value of the end location y coordinate
	 */
	public int getEndY();
}

