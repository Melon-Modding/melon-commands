package prophetsama.testing.commands;

import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.net.command.Command;
import net.minecraft.core.net.command.CommandHandler;
import net.minecraft.core.net.command.CommandSender;
import net.minecraft.server.entity.player.EntityPlayerMP;

public class StarterKit extends Command {
	private final static String COMMAND = "starterkit";
	private final static String NAME = "Starter Kit";

	public StarterKit() { super(COMMAND); }

	@Override
	public boolean execute(CommandHandler commandHandler, CommandSender commandSender, String[] strings) {
		// Array to hold items given
		Item[] kit = { Item.toolCompass, Item.toolCalendar, Item.toolClock};

		// Loop through and give items in array
		for (Item i : kit ) {
			commandSender.getPlayer().inventory.insertItem(new ItemStack(i), false);
		}
		return false;
	}

	@Override
	public boolean opRequired(String[] strings) {
		return false;
	}

	@Override
	public void sendCommandSyntax(CommandHandler commandHandler, CommandSender commandSender) {
		// Feedback to the player that it executed
		commandSender.sendMessage("Given 1x " + NAME + " to " + commandSender.getPlayer().username);
	}
}
