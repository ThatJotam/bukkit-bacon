package caseus.Bacon;

import java.util.List;
import java.util.HashSet;

import org.bukkit.inventory.ItemStack;
import org.bukkit.entity.Pig;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityListener;

public class BaconEntityListener extends EntityListener {
	public static Bacon plugin;
	private final HashSet<Pig> cooked = new HashSet<Pig>();
	
	public BaconEntityListener(Bacon instance){
		plugin = instance;
	}
	
	public void onEntityDeath(EntityDeathEvent event){
		if(event.getEntity() instanceof Pig){
			Pig pig = (Pig) event.getEntity();
			
			if(cooked.remove(pig)){
				List<ItemStack> drops = event.getDrops();
				
				for(int i=0; i < drops.size(); i++){
					drops.get(i).setTypeId(320);
				}
			}
		}
	}
	
	public void onEntityDamage(EntityDamageEvent event){
		if(event.getEntity() instanceof Pig){
			Pig pig = (Pig) event.getEntity();
			
			String lastdamage = event.getCause().name();
			
			if(lastdamage == "FIRE_TICK" || lastdamage == "FIRE" || lastdamage == "LAVA"){
				cooked.add(pig);
			}else{
				cooked.remove(pig);
			}
		}
	}
}
