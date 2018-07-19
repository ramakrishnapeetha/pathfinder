package com.pathfinder;

import com.pathfinder.exception.PathNotFoundException;

/**
 * A description of an implementation that can find a path from one 
 * location on a tile map to another based on information provided
 * by that tile map.
 * 
 * @see ITileBasedMap
 * @author ramakrishnap
 */
public interface IPathFinder {

	/**
	 * Find a path from the starting location provided (sx,sy) to the target
	 * location (tx,ty) avoiding blockages and attempting to honour costs 
	 * provided by the tile map.
	 * 
	 * @return The path found from start to end, or throw exception if no path can be found.
	 */
	public Path findPath() throws PathNotFoundException;
}
