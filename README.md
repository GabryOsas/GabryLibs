# GabryLibs
A simple API for coding in java with spigot api.
# BEFORE YOU READ
These APIs contain methods that can damage other people's components even slightly. Consequently, I do not assume any responsibility for the damage they may experience or their use. I'm not sure about this but when in doubt I write it.
# Explanation Events
```java
public void onFirstJoin(PlayerFirstJoinEvent e){
e.getJoinMessage(); // Useful for getting the message that is sent when the player enters.
e.setJoinMessage("Hello!"); //Useful to set the message when the player join.
e.getPlayer(); //Useful to set the message when the player enters.
}
```
```java
public void onShield(PlayerShieldEvent e){
e.getPlayer(); //Useful to set the message when the player join.
e.setCancelled(true/false); //Useful for canceling the event.
e.isCancelled(); //Useful to see if the event has been cancelled.
}
```
```java
public void onActionBar(PlayerReceivedActionBarEvent e){
e.getPlayer(); //Useful to set the message when the player join.
e.getActionBarMessage(); //Useful for taking the message.
e.setActionBarMessage("Hello!"); //Useful for setting the message.
}
```
# Explanation ColorAPI
```java
ColorAPI colorAPI = new ColorAPI();
colorAPI.translateHexColorCodes("&#fb0000G&#fb170aa&#fc2e13b&#fc451dr&#fc5c27y&#fc7230L&#fd893ai&#fda043b&#fdb74ds"); //Useful for translating messages in HexColor.
```
# Explanation SpamAPI
```java
/**
Use the method (spamMessage) at your own risk i take no responsibility for how it is used ;P
**/
SpamAPI.spamMessage("Hello World!", value, instance of plugin); //This spams the message console.
```
# Explanation GabryAPI
```java
GabryAPI gabryAPI = new GabryAPI();
gabryAPI.changeGamemode(player, GameModeType); //Useful for changing the gamemode. GameModeType = SURVIVAL, CREATIVE, ADVENTURE, SPECTATOR.
gabryAPI.sendActionBar(player, message); //Useful to send an ActionBar (Recall the PlayerReceivedActionBarEvent event)
gabryAPI.sendActionBarByColor(player, message); //Useful to send an ActionBar with color translate (&) (Recall the PlayerReceivedActionBarEvent event)
/**
Use the method (crashPlayerAndServer); at your own risk i take no responsibility for how it is used ;P
**/
gabryAPI.crashPlayerAndServer(player); //This can come in handy for crashing a player's minecraft. ATTENTION the server can crash and above all I don't assume any responsibility regarding its use.
```
# Explanation Head Database API
```skript
command /gui:
  trigger:
    open chest inventory with 3 rows named "&fExample GUI" to player
    wait 1 tick
    set slot 0 of player's current inventory to new skull named "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTc4NWQ1MmIyMzlkYmVhNWI2MTk1YmFkMmI2MmM3YzE3MTE0N2MyODM1YjI5NDk0MWIyODY4YWUzNzM1Mjc5NiJ9fX0=" of player named "&7HDB" with lore "&7Custom Head!"

on inventory click:
    if name of event-inventory is "&fExample GUI":
        cancel event

on player enter vehicle plus:
	broadcast "Hello!"
on player left vehicle plus:
	broadcast "Bye!"
```
