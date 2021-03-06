package dev.entity.creature;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import dev.Handler;
import dev.entity.Entity;

public class Player extends Creature{
	
	public Player(Handler handler, int x, int y) {
		super(handler, x, y);
		health = 10;
		speed = 8;//pixels per frame
		handler.getCamera().focusOnEntity(this, 0);
	}

	private void move() {
		boolean moved = false;
		
		boolean up = handler.getMain().getKeyManager().isKeyPressed(KeyEvent.VK_W);
		boolean left = handler.getMain().getKeyManager().isKeyPressed(KeyEvent.VK_A);
		boolean down = handler.getMain().getKeyManager().isKeyPressed(KeyEvent.VK_S);
		boolean right = handler.getMain().getKeyManager().isKeyPressed(KeyEvent.VK_D);

		float dx = 0, dy = 0;

		if (up) dy --;
		if (down) dy ++;
		if (left) dx --;
		if (right) dx ++;

		float mag = (float) Math.sqrt(dx*dx+dy*dy);
		if (mag != 0) {
			moved = true;
			x += dx*speed*handler.getSpeedMult()/mag;
			Rectangle cHitbox = collided();
			if (cHitbox != null) {
				moved = false;
				if(Math.signum(dx*speed*handler.getSpeedMult()/mag) == 1)
					x = cHitbox.x-hitbox.width;
				else
					x = cHitbox.x+cHitbox.width;
			}
			y += dy*speed*handler.getSpeedMult()/mag;
			cHitbox = collided();
			if (cHitbox != null) {
				moved = false;
				if(Math.signum(dy*speed*handler.getSpeedMult()/mag) == 1)
					y = cHitbox.y-hitbox.height;
				else
					y = cHitbox.y+cHitbox.height;
			}
		}
		if(moved) handler.getWorld().requireNavmeshUpdate();
	}

	@Override
	public void update() {
		move();
	}

	@Override
	public void render(Graphics g) {
		g.setColor(new Color(255, 0, 0));
		g.fillRect((int)(x-handler.getCamera().getXoff()), (int)(y-handler.getCamera().getYoff()), width, height);
	}

	@Override
	public void onCollision(Entity e) {

	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int a) {
		health = a;
	}
	
}
