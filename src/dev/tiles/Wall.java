package dev.tiles;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import dev.Handler;

public class Wall extends Tile{
	
	private int spriteid;

	public Wall(Handler handler, int x, int y, int spriteid) {
		super(handler, x, y, spriteid);
		this.spriteid=spriteid;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(new Color(0,0,200));
		g.fillRect((int)(x-handler.getCamera().getXoff()), (int)(y-handler.getCamera().getYoff()), Tile.tile_width, Tile.tile_height);
		g.setColor(new Color(0,255,255));
		g.drawRect((int)(x-handler.getCamera().getXoff()), (int)(y-handler.getCamera().getYoff()), Tile.tile_width, Tile.tile_height);
	}

	@Override
	public boolean isSolid() {
		return true;
	}
	
}
