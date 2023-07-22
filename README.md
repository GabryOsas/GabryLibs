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
e.setCancelled(); //Useful for canceling the event.
e.isCancelled(); //Useful to see if the event has been cancelled.
}
```
```java
public void onActionBar(PlayerReceivedActionBarEvent e){
e.getPlayer(); //Useful to set the message when the player join.
e.getActionBarMessage(); //Useful for taking the message.
e.setActionBarMessage; //Useful for setting the message.
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
SpamAPI.spamMessage("Hello World!"); //This spams the message console.
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