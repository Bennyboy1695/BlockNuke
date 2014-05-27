package me.Blackace.BlockNuke.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import me.Blackace.BlockNuke.BlockNuke;

public class CommandEntityKill implements CommandExecutor 
{
	BlockNuke plugin;

	public CommandEntityKill(BlockNuke instance)
	{
		plugin = instance;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{

		if(label.equalsIgnoreCase("entitykill") && sender.isOp())
		{
			if(args.length  == 3)
			{
				World world = Bukkit.getServer().getWorld(args[0]);
				if(world == null)
				{
					sender.sendMessage("That world does not exist!");
					return false;
				}

				int chunkX = 0;
				int chunkZ = 0;
				try{
					chunkX = Integer.parseInt(args[1]);
					chunkZ = Integer.parseInt(args[2]);
				}
				catch(Exception e)
				{
					sender.sendMessage(ChatColor.RED + "Invalid Arguements, command is /entitykill <world> <x> <z>. Ensure you are using chunk co-ords!");
					return false;
				}
				Entity[] entities = world.getChunkAt(chunkX, chunkZ).getEntities();
				int count = 0;
				for(int i = entities.length - 1; i >= 0 ; i--)
				{
					if(!(entities[i] instanceof Player))
					{
						entities[i].remove();
						count++;
					}
				}
				sender.sendMessage(ChatColor.GREEN + "" + count + ChatColor.GOLD + " entities at chunk co-ords " + ChatColor.AQUA + chunkX + ", " + chunkZ + ChatColor.GOLD + " have been removed!");


			}
			else
			{
				sender.sendMessage(ChatColor.RED + "Usage: /entitykill <world> <chunkX> <chunkZ>");
			}

		}
		else
		{
			sender.sendMessage(ChatColor.RED + "You do not have permission to use this command!");
		}



		return true;
	}



}
