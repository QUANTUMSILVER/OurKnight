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
		g.fillRect(x, y, Tile.tile_width, 10*Tile.tile_height);
		g.setColor(new Color(0,255,255));
		g.drawRect(x, y, 10*Tile.tile_width, 10*Tile.tile_height);
	}

	@Override
	public boolean isSolid() {
		return true;
	}
	
}
