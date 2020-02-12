package com.mygdx.game.map;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Matrix4;

public class TiledGameMap {
	TiledMap tiledMap;
	OrthogonalTiledMapRenderer tiledMapRenderer;
	private final float L = -33, R = 1887, T = -212, B = 868; 
	private final Matrix4 PROJECTMATRIX = new Matrix4(new float[]
			{2/(R-L),0,0,0,
			0,-2/(T-B),0,0,
			0,0,1,0,
			-(R+L)/(R-L),(T+B)/(T-B),0,1});
	
	public TiledGameMap (){
		tiledMap = new TmxMapLoader().load("level1map.tmx");
		tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);
	}
	
	public void render (){ //Uses projection matrices to get the map to render in the right place
		tiledMapRenderer.setView(PROJECTMATRIX, 0, 0, 1856, 832);
		tiledMapRenderer.render();
		
	}
	
	public void update (float delta) {
		// TODO Auto-generated method stub
	}
	
	public void dispose() {
		tiledMap.dispose();
	}
	
	public TileType getTileTypeByScreenCoordinate(float posX, float posY) {
		return TileType.getTileTypeByID(((TiledMapTileLayer)tiledMap.getLayers().get(0)).getCell((int) (posX-33)/32,(int) (posY-212)/32).getTile().getId());
		
	}
	
}