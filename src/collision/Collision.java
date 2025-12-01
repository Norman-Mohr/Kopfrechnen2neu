package collision;

import kopfrechnen2.OutputPanel;

public class Collision {

	OutputPanel op;

	public Collision(OutputPanel op) {
		this.op = op;
	}

	public void collisionCheck() {
		if (op.entity.x > 395) {
			op.entity.collisionEntity = true;

		}
		if (op.player.x > 395) {
			op.player.collisionZiel = true;

		}
	}

}
