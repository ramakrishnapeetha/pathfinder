package com.pathfinder;


/**
 * A heuristic that uses the tile that is closest to the target
 * as the next best tile.
 * 
 * @author ramakrishnap
 */
public class ClosestHeuristic implements IAStarHeuristic {
	/**
	 * @see IAStarHeuristic#getCost(int, int, int, int)
	 */
	public float getCost(int x, int y, int tx, int ty) {		
		float dx = tx - x;
		float dy = ty - y;
		
		/*float result = (float) (Math.sqrt((dx*dx)+(dy*dy)));
		return result;*/
		
		float result = Math.abs(dx)+Math.abs(dy);
		return result;
	}

}
