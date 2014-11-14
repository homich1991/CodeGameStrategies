
import framework.interfaces.Bonus;
import framework.interfaces.Player;
import framework.interfaces.World;

/**
 * Created by Homich on 29.10.2014.
 */
public class MyStrategy extends Player {

    @Override
    public void init() {
        getSelfControl().setName("BonusCollector");
    }

    @Override
    public void move() {
        World world = getWorld();
        if (getSelfControl().getScore() < 100) {
            Bonus b = null;
            double minDistance = Double.MAX_VALUE;
            for (Bonus bonus : world.getBonuses()) {
                double distance = getSelfControl().getDistanceTo(bonus.getX(), bonus.getY());
                if (distance < minDistance) {
                    b = bonus;
                    minDistance = distance;
                }
            }
            if (b != null) {
                getSelfControl().moveForward();
                getSelfControl().turnTo(b.getX(), b.getY());
            }
        } else {
            getSelfControl().moveForward();
            getSelfControl().turnTo(getSelfControl().getBaseStationX(), getSelfControl().getBaseStationY());
        }
    }
}
