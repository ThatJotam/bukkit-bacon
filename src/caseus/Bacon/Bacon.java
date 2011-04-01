package caseus.Bacon;

import org.bukkit.event.Event.Priority;
import org.bukkit.event.Event;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.PluginManager;

public class Bacon extends JavaPlugin {
    private final BaconEntityListener entityListener = new BaconEntityListener(this);
    
	public void onDisable() {
	    // TODO: Place any custom disable code here
	
	    // NOTE: All registered events are automatically unregistered when a plugin is disabled
	
	    // EXAMPLE: Custom code, here we just output some info so we can check all is well
	    System.out.println("Goodbye bacon!");
	}
	
	public void onEnable() {
	    // Register our events
	    PluginManager pm = getServer().getPluginManager();
	    pm.registerEvent(Event.Type.ENTITY_DAMAGE, entityListener, Priority.Normal, this);
	    pm.registerEvent(Event.Type.ENTITY_DEATH, entityListener, Priority.Normal, this);
	    
	    // EXAMPLE: Custom code, here we just output some info so we can check all is well
	    PluginDescriptionFile pdfFile = this.getDescription();
	    System.out.println( pdfFile.getName() + " version " + pdfFile.getVersion() + " is enabled!" );
	}
}