package life.grass.grasscore.item;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

/**
 * Created by Ecila on 2016/09/08.
 */
public class ItemPacketRewriter {

    private static final ItemPacketRewriter instance = new ItemPacketRewriter();

    private ItemPacketRewriter() {}

    public static ItemPacketRewriter getInstance() {
        return instance;
    }

    public void addListener(ProtocolManager manager, JavaPlugin plugin) {
        manager.addPacketListener(new PacketAdapter(plugin,
                PacketType.Play.Server.SET_SLOT,
                PacketType.Play.Server.WINDOW_ITEMS) {
            @Override
            public void onPacketSending(PacketEvent event) {
                PacketType type = event.getPacketType();
                if(type.equals(PacketType.Play.Server.SET_SLOT)) {
                    for(ItemStack item : new ItemStack[]{event.getPacket().getItemModifier().read(0)}) {
                        rewriteItem(item);
                    }
                } else if(type.equals(PacketType.Play.Server.WINDOW_ITEMS)) {
                    for(ItemStack item : event.getPacket().getItemArrayModifier().read(0)) {
                        rewriteItem(item);
                    }
                }
            }
        });
    }

    private void rewriteItem(ItemStack item) {
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.WHITE + "REWRITTEN ITEM");
    }

}
