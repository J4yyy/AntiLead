package de.j4yyy.antilead.listener;

import de.j4yyy.antilead.utils.MountService;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.spigotmc.event.entity.EntityMountEvent;

public class EntityMountListener implements Listener {

    private final MountService mountService;

    public EntityMountListener(MountService mountService) {
        this.mountService = mountService;
    }

    @EventHandler
    public void onEntityMount(EntityMountEvent event) {
        if(!(event.getEntity() instanceof Player)) {
            return;
        }
        Player player = (Player) event.getEntity();
        if(this.mountService.isMountBlocked(player)) {
            event.setCancelled(true);
        }
    }
}