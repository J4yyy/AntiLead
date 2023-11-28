package de.j4yyy.antilead.listener;

import de.j4yyy.antilead.utils.MountService;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerLeashEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class InteractionListener implements Listener {

    private final MountService mountService;

    public InteractionListener(MountService mountService) {
        this.mountService = mountService;
    }

    @EventHandler
    public void test(PlayerLeashEntityEvent event) {
        if(!(event.getLeashHolder() instanceof Player)) {
            return;
        }
        Player player = (Player) event.getLeashHolder();

        ItemStack lead = player.getInventory().getItemInMainHand();
        ItemMeta clickedItemMeta = lead.getItemMeta();
        if(clickedItemMeta.hasLore() && clickedItemMeta.getLore().contains(ChatColor.WHITE + "Wird zum einfangen benötigt!") && clickedItemMeta.hasDisplayName() && clickedItemMeta.getDisplayName().equalsIgnoreCase(ChatColor.DARK_GREEN + ChatColor.BOLD.toString() + "Haustierleine")) {
            event.setCancelled(true);
            event.getPlayer().updateInventory();
            this.mountService.addMountBlock(player);
        }
    }
}