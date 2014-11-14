import framework.interfaces.Player;
import framework.interfaces.SelfControl;
import framework.interfaces.World;

public class MyStrategy extends Player {

    @Override
    public void init() {
        getSelfControl().setName("Firer");
    }

    @Override
    public void move() {
        World world = getWorld();
        if (getSelfControl().getActionCoolDown(SelfControl.Action.FIRE_FROZER) == 0) {
            getSelfControl().fireFrozer();
        } else {
            getSelfControl().fireMissile();
        }
    }
}
